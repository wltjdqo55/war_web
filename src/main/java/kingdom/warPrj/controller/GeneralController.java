package kingdom.warPrj.controller;

import kingdom.warPrj.entity.dto.GeneralDTO;
import kingdom.warPrj.entity.vo.GeneralVO;
import kingdom.warPrj.service.GeneralService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class GeneralController {

  private final GeneralService generalService;

  @GetMapping("/account/adminMain/general")
  public String generalPage() {
    return "/monster/general/general.html";
  }

  @GetMapping("/account/adminMain/general/add")
  public String generalAddView() {
    return "/monster/general/generalAddView";
  }

  @PostMapping("/general/generalAddOK")
  @ResponseBody
  public GeneralDTO generalAdd(GeneralVO generalVO) {
    return generalService.generalAdd(generalVO);
  }

  @GetMapping("/general/generalNameCheck")
  @ResponseBody
  public boolean generalNameCheck(GeneralVO generalVO){
    return generalService.generalNameCheck(generalVO.getGeneralName());
  }

//  @GetMapping("/general/getgeneralList")
//  @ResponseBody
//  public List<generalDTO> getgeneralList() {
//    return generalService.getgeneralList();
//  }

  //  @GetMapping("/skill/getSearchSkill")
//  @ResponseBody
//  public List<SkillDTO> getSearchSkill(SkillVO skillVO) {
//    return skillService.getSearchSkill(skillVO);
//  }
//
//  @GetMapping("/account/adminMain/general/detail/{id}")
//  public String detailView(@PathVariable("id") long id, Model model){
//    model.addAttribute("id", id);
//    return "/monster/general/generalDetailView.html";
//  }
//
//  @GetMapping("/general/getgeneralInfo/{id}")
//  @ResponseBody
//  public generalDTO getgeneralInfo(@PathVariable long id){
//    return generalService.getgeneralDetail(id);
//  }

//  @GetMapping("/account/adminMain/skill/edit/{id}")
//  public String editView(@PathVariable long id, Model model){
//    model.addAttribute("id", id);
//    return "/skill/skillEditView.html";
//  }
//
//  @PostMapping("/skill/skillEditOK")
//  @ResponseBody
//  public boolean skillEdit(SkillVO skillVO) {
//    return skillService.skillEdit(skillVO);
//  }
//
//  @GetMapping("/skill/skillDelete/{id}")
//  @ResponseBody
//  public String skillDelete(@PathVariable long id){
//    skillService.skillDelete(id);
//    return "";
//  }
//
//  @GetMapping("/skill/getSkillStateList")
//  @ResponseBody
//  public List<SkillDTO> getSkillStateList(){
//    return skillService.getSkillStateList();
//  }

}
