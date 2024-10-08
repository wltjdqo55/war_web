package kingdom.warPrj.controller;


import kingdom.warPrj.entity.dto.SoldierDTO;
import kingdom.warPrj.entity.vo.SoldierVO;
import kingdom.warPrj.service.SoldierService;
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
public class SoldierController {

  private final SoldierService soldierService;

  @GetMapping("/account/soldier")
  public String soldierPage() {
    return "/soldier/soldier.html";
  }

  @GetMapping("/account/soldier/add")
  public String soldierAddView() {
    return "/soldier/soldierAddView";
  }

  @PostMapping("/soldier/soldierAddOK")
  @ResponseBody
  public SoldierDTO soldierAdd(SoldierVO soldierVO) {
    return soldierService.soldierAdd(soldierVO);
  }

  @GetMapping("/soldier/soldierIdCheck")
  @ResponseBody
  public boolean soldierIdCheck(SoldierVO soldierVO){
    return soldierService.soldierIdCheck(soldierVO.getSoldierId());
  }

  @GetMapping("/soldier/getSoldierList")
  @ResponseBody
  public List<SoldierDTO> getItemList() {
    return soldierService.getSoldierList();
  }

  @GetMapping("/soldier/getSearchSoldier")
  @ResponseBody
  public List<SoldierDTO> getSearchSoldier(SoldierVO soldierVO) {
    return soldierService.getSearchSoldier(soldierVO);
  }

  @GetMapping("/account/soldier/detail/{id}")
  public String detailView(@PathVariable("id") long id, Model model){
    model.addAttribute("id", id);
    return "/soldier/soldierDetailView.html";
  }

  @GetMapping("/soldier/getSoldierInfo/{id}")
  @ResponseBody
  public SoldierDTO getSoldierInfo(@PathVariable long id){
    return soldierService.getSoldierDetail(id);
  }

  @GetMapping("/account/soldier/edit/{id}")
  public String editView(@PathVariable long id, Model model){
    model.addAttribute("id", id);
    return "/soldier/soldierEditView.html";
  }

  @PostMapping("/soldier/soldierEditOK")
  @ResponseBody
  public boolean soldierEdit(SoldierVO soldierVO) {
    return soldierService.soldierEdit(soldierVO);
  }

  @PostMapping("/soldier/soldierDelete")
  @ResponseBody
  public String soldierDelete(SoldierVO soldierVO){
    soldierService.soldierDelete(soldierVO);
    return "";
  }

  @GetMapping("/soldier/getActiveSoldier/{id}")
  @ResponseBody
  public SoldierDTO getActiveSoldier(@PathVariable long id){
    return soldierService.getActiveSoldier(id);
  }
}
