package kingdom.warPrj.service;

import kingdom.warPrj.entity.dto.GeneralDTO;
import kingdom.warPrj.entity.entity.General;
import kingdom.warPrj.entity.vo.GeneralVO;
import kingdom.warPrj.repasitory.jpa.GeneralRepository;
import kingdom.warPrj.repasitory.queryDSL.GeneralQueryDSL;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GeneralService {

  private final GeneralRepository generalRepository;
  private final GeneralQueryDSL generalQueryDSL;

  @Transactional
  public GeneralDTO generalAdd(GeneralVO generalVO){
    return new GeneralDTO(generalRepository.save(new General(generalVO)));
  }

  public boolean generalNameCheck(String generalName){
    return generalRepository.findOneByGeneralName(generalName).isEmpty();
  }

//  public List<generalDTO> getgeneralList(){
//    return generalRepository.findAll().stream().map(generalDTO::new).collect(Collectors.toList());
//  }

  //  public List<SkillDTO> getSearchSkill(SkillVO skillVO){
//    List<SkillEntity> list = skillQueryDSL.getSearchSkill(skillVO);
//    return list.stream().map(SkillDTO::new).collect(Collectors.toList());
//  }
//
//  public generalDTO getgeneralDetail(long id){
//    return new generalDTO(generalRepository.findById(id).orElse(new general()));
//  }

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
