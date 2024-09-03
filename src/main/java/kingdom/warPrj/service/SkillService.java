package kingdom.warPrj.service;

import kingdom.warPrj.entity.dto.AdminDTO;
import kingdom.warPrj.entity.dto.SkillDTO;
import kingdom.warPrj.entity.entity.AdminEntity;
import kingdom.warPrj.entity.entity.SkillEntity;
import kingdom.warPrj.entity.vo.SkillVO;
import kingdom.warPrj.repasitory.jpa.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SkillService {

  private final SkillRepository skillRepository;

  @Transactional
  public SkillDTO skillAdd(SkillVO skillVO){
    skillVO.setSkillState("F");
    return new SkillDTO(skillRepository.save(new SkillEntity(skillVO)));
  }

  public boolean skillNameCheck(String skillName){
    return skillRepository.findOneBySkillName(skillName).isEmpty();
  }

  public List<SkillDTO> getSkillList(){
    return skillRepository.findAll().stream().map(SkillDTO::new).collect(Collectors.toList());
  }
}
