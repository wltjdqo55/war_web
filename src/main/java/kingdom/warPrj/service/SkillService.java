package kingdom.warPrj.service;

import kingdom.warPrj.entity.dto.AdminDTO;
import kingdom.warPrj.entity.dto.SkillDTO;
import kingdom.warPrj.entity.entity.AdminEntity;
import kingdom.warPrj.entity.entity.SkillEntity;
import kingdom.warPrj.entity.vo.SkillVO;
import kingdom.warPrj.repasitory.jpa.SkillRepository;
import kingdom.warPrj.repasitory.queryDSL.SkillQueryDSL;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SkillService {

  private final SkillRepository skillRepository;
  private final SkillQueryDSL skillQueryDSL;

  @Transactional
  public SkillDTO skillAdd(SkillVO skillVO){
    return new SkillDTO(skillRepository.save(new SkillEntity(skillVO)));
  }

  public boolean skillNameCheck(String skillName){
    return skillRepository.findOneBySkillName(skillName).isEmpty();
  }

  public List<SkillDTO> getSkillList(){
    return skillRepository.findAll().stream().
        sorted(Comparator.comparingLong(SkillEntity::getId)).
        map(SkillDTO::new).collect(Collectors.toList());
  }

  public List<SkillDTO> getSearchSkill(SkillVO skillVO){
    List<SkillEntity> list = skillQueryDSL.getSearchSkill(skillVO);
    return list.stream().sorted(Comparator.comparingLong(SkillEntity::getId))
        .map(SkillDTO::new).collect(Collectors.toList());
  }

  public SkillDTO getSkillDetail(long id){
    return new SkillDTO(skillRepository.findById(id).orElse(new SkillEntity()));
  }

  @Transactional
  public boolean skillEdit(SkillVO skillVO){
    return skillQueryDSL.skillEdit(skillVO);
  }

  public void skillDelete(long id){
     skillRepository.deleteById(id);
  }

  public List<SkillDTO> getSkillStateList() {
    List<SkillEntity> list = skillQueryDSL.getSkillStateList();
    return list.stream().sorted(Comparator.comparingLong(SkillEntity::getId))
        .map(SkillDTO::new).collect(Collectors.toList());
  }
}
