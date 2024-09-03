package kingdom.warPrj.controller;

import kingdom.warPrj.entity.dto.SkillDTO;
import kingdom.warPrj.entity.vo.AdminVO;
import kingdom.warPrj.entity.vo.SkillVO;
import kingdom.warPrj.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class SkillController {

  private final SkillService skillService;

  @GetMapping("/account/adminMain/skill")
  public String skillPage() {
    return "/skill/skill.html";
  }

  @GetMapping("/account/adminMain/skill/add")
  public String skillAddView() {
    return "/skill/skillAddView";
  }

  @PostMapping("/skill/skillAddOK")
  @ResponseBody
  public SkillDTO skillAdd(SkillVO skillVO) {
    return skillService.skillAdd(skillVO);
  }

  @GetMapping("/skill/skillNameCheck")
  @ResponseBody
  public boolean skillNameCheck(SkillVO skillVO){
    return skillService.skillNameCheck(skillVO.getSkillName());
  }

  @GetMapping("/skill/getSkillList")
  @ResponseBody
  public List<SkillDTO> getSkillList() {
    return skillService.getSkillList();
  }


}
