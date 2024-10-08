package kingdom.warPrj.service;

import kingdom.warPrj.entity.dto.GeneralDTO;
import kingdom.warPrj.entity.entity.General;
import kingdom.warPrj.entity.entity.Legion;
import kingdom.warPrj.entity.vo.GeneralVO;
import kingdom.warPrj.repasitory.jpa.GeneralRepository;
import kingdom.warPrj.repasitory.jpa.LegionRepository;
import kingdom.warPrj.repasitory.queryDSL.GeneralQueryDSL;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GeneralService {

  private final GeneralRepository generalRepository;
  private final GeneralQueryDSL generalQueryDSL;
  private final LegionRepository legionRepository;

  @Transactional
  public GeneralDTO generalAdd(GeneralVO generalVO){
    General saveGeneral = generalRepository.save(new General(generalVO));

    if(!generalVO.getSelectedLegionIds().isEmpty()){
      generalVO.getSelectedLegionIds().stream().forEach(legion -> {
        saveGeneral.getLegions().add(new Legion(legion));
      });
    }
    return new GeneralDTO(saveGeneral);
  }

  public boolean generalNameCheck(String generalName){
    return generalRepository.findOneByGeneralName(generalName).isEmpty();
  }

  public List<GeneralDTO> getGeneralList(){
    return generalRepository.findAll().stream()
        .sorted(Comparator.comparingLong(General::getId))
        .map(GeneralDTO::new)
        .collect(Collectors.toList());
  }

    public List<GeneralDTO> getSearchGeneral(GeneralVO generalVO){
    List<General> list = generalQueryDSL.getSearchGeneral(generalVO);
    return list.stream().sorted(Comparator.comparingLong(General::getId)).
        map(GeneralDTO::new).collect(Collectors.toList());
  }

  public GeneralDTO getGeneralDetail(long id){
    return new GeneralDTO(generalRepository.findById(id).orElse(new General()));
  }

  @Transactional
  public boolean generalEdit(GeneralVO generalVO) {
    Optional<General> optionalGeneral = generalRepository.findById(generalVO.getId());

    if (optionalGeneral.isPresent()) {
      General general = optionalGeneral.get();
      general.update(generalVO); // 일반 정보 업데이트

      Set<Long> existingLegionIds = general.getLegions().stream()
          .map(Legion::getId) // Legion에서 ID 가져오기
          .collect(Collectors.toSet());

      Set<Long> newLegionIds = new HashSet<>(generalVO.getSelectedLegionIds());

      // 삭제할 ID 리스트
      Set<Long> toDelete = existingLegionIds.stream()
          .filter(id -> !newLegionIds.contains(id))
          .collect(Collectors.toSet());

      // 추가할 ID 리스트
      Set<Long> toAdd = newLegionIds.stream()
          .filter(id -> !existingLegionIds.contains(id))
          .collect(Collectors.toSet());

      // 삭제할 ID 처리
      for (Long id : toDelete) {
        Legion legion = legionRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Legion not found: " + id));
        general.getLegions().remove(legion);
      }

      // 추가할 ID 처리
      for (Long id : toAdd) {
        Legion legion = legionRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Legion not found: " + id));
        general.getLegions().add(legion);
      }

      // 변경된 엔티티 저장
      generalRepository.save(general);
      return true;
    }
    return false;
  }

  public void generalDelete(long id){
    generalRepository.deleteById(id);
  }
}
