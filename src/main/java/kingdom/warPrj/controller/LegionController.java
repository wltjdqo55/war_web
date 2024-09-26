package kingdom.warPrj.controller;

import kingdom.warPrj.entity.dto.LegionDTO;
import kingdom.warPrj.entity.dto.SkillDTO;
import kingdom.warPrj.entity.vo.LegionVO;
import kingdom.warPrj.entity.vo.SkillVO;
import kingdom.warPrj.service.LegionService;
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
public class LegionController {

  private final LegionService legionService;

  @GetMapping("/account/legion")
  public String legionPage() {
    return "/monster/legion/legion.html";
  }

  @GetMapping("/account/legion/add")
  public String legionAddView() {
    return "/monster/legion/legionAddView";
  }

  @PostMapping("/legion/legionAddOK")
  @ResponseBody
  public LegionDTO legionAdd(LegionVO legionVO) {
    return legionService.legionAdd(legionVO);
  }

  @GetMapping("/legion/legionNameCheck")
  @ResponseBody
  public boolean legionNameCheck(LegionVO legionVO){
    return legionService.legionNameCheck(legionVO.getLegionName());
  }

  @GetMapping("/legion/getLegionList")
  @ResponseBody
  public List<LegionDTO> getLegionList() {
    return legionService.getLegionList();
  }

  @GetMapping("/legion/getSearchLegion")
  @ResponseBody
  public List<LegionDTO> getSearchLegion(LegionVO legionVO) {
    return legionService.getSearchLegion(legionVO);
  }

  @GetMapping("/account/legion/detail/{id}")
  public String detailView(@PathVariable("id") long id, Model model){
    model.addAttribute("id", id);
    return "/monster/legion/legionDetailView.html";
  }

  @GetMapping("/legion/getLegionInfo/{id}")
  @ResponseBody
  public LegionDTO getLegionInfo(@PathVariable long id){
    return legionService.getLegionDetail(id);
  }

  @GetMapping("/account/legion/edit/{id}")
  public String editView(@PathVariable long id, Model model){
    model.addAttribute("id", id);
    return "/monster/legion/legionEditView.html";
  }

  @PostMapping("/legion/legionEditOK")
  @ResponseBody
  public boolean legionEdit(LegionVO legionVO) {
    return legionService.legionEdit(legionVO);
  }

  @GetMapping("/legion/legionDelete/{id}")
  @ResponseBody
  public String legionDelete(@PathVariable long id){
    legionService.legionDelete(id);
    return "";
  }
}
