package kingdom.warPrj.service;

import kingdom.warPrj.entity.dto.GeneralDTO;
import kingdom.warPrj.entity.dto.LegionDTO;
import kingdom.warPrj.entity.dto.SkillDTO;
import kingdom.warPrj.entity.entity.General;
import kingdom.warPrj.entity.entity.Legion;
import kingdom.warPrj.entity.entity.SkillEntity;
import kingdom.warPrj.entity.vo.LegionVO;
import kingdom.warPrj.entity.vo.SkillVO;
import kingdom.warPrj.repasitory.jpa.GeneralRepository;
import kingdom.warPrj.repasitory.jpa.LegionRepository;
import kingdom.warPrj.repasitory.queryDSL.GeneralQueryDSL;
import kingdom.warPrj.repasitory.queryDSL.LegionQueryDSL;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LegionService {
  private final LegionRepository legionRepository;
  private final LegionQueryDSL legionQueryDSL;
  private final GeneralRepository generalRepository;
  private final GeneralQueryDSL generalQueryDSL;

  @Transactional
  public LegionDTO legionAdd(LegionVO legionVO){
    Legion saveLegion = legionRepository.save(new Legion(legionVO));

    if(!legionVO.getSelectedGeneralIds().isEmpty()){
        legionVO.getSelectedGeneralIds().stream().forEach(generalId -> {
          saveLegion.getGenerals().add(new General(generalId));
        });
    }

    return new LegionDTO(saveLegion);
  }

  public boolean legionNameCheck(String legionName){
    return legionRepository.findOneByLegionName(legionName).isEmpty();
  }

  public List<LegionDTO> getLegionList(){
    return legionRepository.findAll().stream().
        sorted(Comparator.comparingLong(Legion::getId))
        .map(LegionDTO::new).collect(Collectors.toList());
  }

  public List<LegionDTO> getSearchLegion(LegionVO legionVO){
    List<Legion> list = legionQueryDSL.getSearchLegion(legionVO);
    return list.stream().sorted(Comparator.comparingLong(Legion::getId)).
        map(LegionDTO::new).collect(Collectors.toList());
  }

  public LegionDTO getLegionDetail(long id){
    return new LegionDTO(legionRepository.findById(id).orElse(new Legion()));
  }

  @Transactional
  public boolean legionEdit(LegionVO legionVO){
    Optional<Legion> optionalLegion = legionRepository.findById(legionVO.getId());

    if (optionalLegion.isPresent()) {
      Legion legion = optionalLegion.get();
      legion.update(legionVO); // 일반 정보 업데이트

      Set<Long> existingGeneralIds = legion.getGenerals().stream()
          .map(General::getId) // General에서 ID 가져오기
          .collect(Collectors.toSet());

      Set<Long> newGeneralIds = new HashSet<>(legionVO.getSelectedGeneralIds());

      // 삭제할 ID 리스트
      Set<Long> toDelete = existingGeneralIds.stream()
          .filter(id -> !newGeneralIds.contains(id))
          .collect(Collectors.toSet());

      // 추가할 ID 리스트
      Set<Long> toAdd = newGeneralIds.stream()
          .filter(id -> !existingGeneralIds.contains(id))
          .collect(Collectors.toSet());

      // 삭제할 ID 처리
      for (Long id : toDelete) {
        General general = generalRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("General not found: " + id));
        legion.getGenerals().remove(general);
      }

      // 추가할 ID 처리
      for (Long id : toAdd) {
        General general = generalRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("General not found: " + id));
        legion.getGenerals().add(general);
      }

      // 변경된 엔티티 저장
      legionRepository.save(legion);
      return true;
    }
    return false;
  }

  public void legionDelete(long id){
    legionRepository.deleteById(id);
  }

  public LegionDTO getTotalLegion(){
    LegionDTO legionDTO = legionQueryDSL.getTotalLegion();
    GeneralDTO generalDTO = generalQueryDSL.getTotalGeneral();

    legionDTO.setTotalAttackValue(legionDTO.getTotalAttackValue()+generalDTO.getTotalAttackValue());
    legionDTO.setTotalDefenseValue(legionDTO.getTotalDefenseValue()+generalDTO.getTotalDefenseValue());
    legionDTO.setTotalMovementSpeedValue(legionDTO.getTotalMovementSpeedValue()+generalDTO.getTotalMovementSpeedValue());
    legionDTO.setTotalMoraleValue(legionDTO.getTotalMoraleValue()+generalDTO.getTotalMoraleBonusValue());
    legionDTO.setGeneralCountValue(generalDTO.getTotalGeneralCount());

    return legionDTO;
  }
}
