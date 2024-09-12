package kingdom.warPrj.service;

import kingdom.warPrj.entity.dto.LegionDTO;
import kingdom.warPrj.entity.dto.SkillDTO;
import kingdom.warPrj.entity.entity.General;
import kingdom.warPrj.entity.entity.Legion;
import kingdom.warPrj.entity.entity.SkillEntity;
import kingdom.warPrj.entity.vo.LegionVO;
import kingdom.warPrj.entity.vo.SkillVO;
import kingdom.warPrj.repasitory.jpa.LegionRepository;
import kingdom.warPrj.repasitory.queryDSL.LegionQueryDSL;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LegionService {
  private final LegionRepository legionRepository;
  private final LegionQueryDSL legionQueryDSL;

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
    return legionRepository.findAll().stream().map(LegionDTO::new).collect(Collectors.toList());
  }

//  public List<SkillDTO> getSearchSkill(SkillVO skillVO){
//    List<SkillEntity> list = skillQueryDSL.getSearchSkill(skillVO);
//    return list.stream().map(SkillDTO::new).collect(Collectors.toList());
//  }
//
  public LegionDTO getLegionDetail(long id){
    return new LegionDTO(legionRepository.findById(id).orElse(new Legion()));
  }

//  @Transactional
//  public boolean skillEdit(SkillVO skillVO){
//    return skillQueryDSL.skillEdit(skillVO);
//  }
//
//  public void skillDelete(long id){
//    skillRepository.deleteById(id);
//  }
//
//  public List<SkillDTO> getSkillStateList() {
//    List<SkillEntity> list = skillQueryDSL.getSkillStateList();
//    return list.stream().map(SkillDTO::new).collect(Collectors.toList());
//  }
}
