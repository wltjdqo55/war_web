package kingdom.warPrj.controller;

import kingdom.warPrj.entity.dto.SkillDTO;
import kingdom.warPrj.entity.vo.AdminVO;
import kingdom.warPrj.entity.vo.SkillVO;
import kingdom.warPrj.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

  @GetMapping("/skill/getSearchSkill")
  @ResponseBody
  public List<SkillDTO> getSearchSkill(SkillVO skillVO) {
    return skillService.getSearchSkill(skillVO);
  }

  @GetMapping("/account/adminMain/skill/detail/{id}")
  public String detailView(@PathVariable("id") long id, Model model){
    model.addAttribute("id", id);
    return "/skill/skillDetailView.html";
  }

  @GetMapping("/skill/getSkillInfo/{id}")
  @ResponseBody
  public SkillDTO getSkillInfo(@PathVariable long id){
    return skillService.getSkillDetail(id);
  }

  @GetMapping("/account/adminMain/skill/edit/{id}")
  public String editView(@PathVariable long id, Model model){
    model.addAttribute("id", id);
    return "/skill/skillEditView.html";
  }

  @PostMapping("/skill/skillEditOK")
  @ResponseBody
  public boolean skillEdit(SkillVO skillVO) {
    return skillService.skillEdit(skillVO);
  }

  @GetMapping("/skill/skillDelete/{id}")
  @ResponseBody
  public String skillDelete(@PathVariable long id){
     skillService.skillDelete(id);
     return "";
  }
}
