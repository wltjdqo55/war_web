package kingdom.warPrj.controller;


import kingdom.warPrj.entity.dto.SoldierDTO;
import kingdom.warPrj.entity.dto.StorageDTO;
import kingdom.warPrj.entity.vo.SoldierVO;
import kingdom.warPrj.entity.vo.StorageVO;
import kingdom.warPrj.service.SoldierService;
import kingdom.warPrj.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class SoldierController {

  private final SoldierService soldierService;

  @GetMapping("/account/adminMain/soldier")
  public String soldierPage() {
    return "/soldier/soldier.html";
  }

  @GetMapping("/account/adminMain/soldier/add")
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

//  @GetMapping("/storage/getSearchItem")
//  @ResponseBody
//  public List<StorageDTO> getSearchItem(StorageVO storageVO) {
//    return storageService.getSearchItem(storageVO);
//  }
//
//  @GetMapping("/account/adminMain/storage/detail/{id}")
//  public String detailView(@PathVariable("id") long id, Model model){
//    model.addAttribute("id", id);
//    return "/storage/storageDetailView.html";
//  }
//
//  @GetMapping("/storage/getItemInfo/{id}")
//  @ResponseBody
//  public StorageDTO getItemInfo(@PathVariable long id){
//    return storageService.getItemDetail(id);
//  }
//
//  @GetMapping("/account/adminMain/storage/edit/{id}")
//  public String editView(@PathVariable long id, Model model){
//    model.addAttribute("id", id);
//    return "/storage/storageEditView.html";
//  }
//
//  @PostMapping("/storage/itemEditOK")
//  @ResponseBody
//  public boolean itemEdit(StorageVO storageVO) {
//    return storageService.itemEdit(storageVO);
//  }
//
//  @GetMapping("/storage/itemDelete/{id}")
//  @ResponseBody
//  public String itemDelete(@PathVariable long id){
//    storageService.itemDelete(id);
//    return "";
//  }
}
