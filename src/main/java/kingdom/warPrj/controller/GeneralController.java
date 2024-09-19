package kingdom.warPrj.controller;

import kingdom.warPrj.entity.dto.GeneralDTO;
import kingdom.warPrj.entity.dto.SkillDTO;
import kingdom.warPrj.entity.vo.GeneralVO;
import kingdom.warPrj.entity.vo.SkillVO;
import kingdom.warPrj.service.GeneralService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

  @GetMapping("/general/getGeneralList")
  @ResponseBody
  public List<GeneralDTO> getGeneralList() {
    return generalService.getGeneralList();
  }

  @GetMapping("/general/getSearchGeneral")
  @ResponseBody
  public List<GeneralDTO> getSearchGeneral(GeneralVO generalVO) {
    return generalService.getSearchGeneral(generalVO);
  }

  @GetMapping("/account/adminMain/general/detail/{id}")
  public String detailView(@PathVariable("id") long id, Model model){
    model.addAttribute("id", id);
    return "/monster/general/generalDetailView.html";
  }

  @GetMapping("/general/getGeneralInfo/{id}")
  @ResponseBody
  public GeneralDTO getGeneralInfo(@PathVariable long id){
    return generalService.getGeneralDetail(id);
  }

  @GetMapping("/account/adminMain/general/edit/{id}")
  public String editView(@PathVariable long id, Model model){
    model.addAttribute("id", id);
    return "/monster/general/generalEditView.html";
  }

  @PostMapping("/general/generalEditOK")
  @ResponseBody
  public boolean generalEdit(GeneralVO generalVO) {
    return generalService.generalEdit(generalVO);
  }

  @GetMapping("/general/generalDelete/{id}")
  @ResponseBody
  public String generalDelete(@PathVariable long id){
    generalService.generalDelete(id);
    return "";
  }
}
