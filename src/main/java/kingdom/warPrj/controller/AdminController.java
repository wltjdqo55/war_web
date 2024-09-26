package kingdom.warPrj.controller;

import jakarta.servlet.http.HttpSession;
import kingdom.warPrj.account.AdminSession;
import kingdom.warPrj.entity.dto.AdminDTO;
import kingdom.warPrj.entity.dto.SkillDTO;
import kingdom.warPrj.entity.vo.AdminVO;
import kingdom.warPrj.entity.vo.SkillVO;
import kingdom.warPrj.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdminController {

  private final AdminService adminService;

  @GetMapping("/account/login")
  public String loginPage() {return "/account/login.html";}

  @GetMapping("/account/admin")
  public String adminPage() {
    return "/account/admin.html";
  }

  @GetMapping("/account/admin/add")
  public String adminAddPage() {
    return "/account/adminAdd.html";
  }

  @PostMapping("/account/adminAddOK")
  @ResponseBody
  public AdminDTO adminAdd(AdminVO adminVO) {
      return adminService.adminAdd(adminVO);
  }

  @GetMapping("/account")
  public String adminMainPage(HttpSession session) {
//    if(session.getAttribute("adminInfo") != null){
//      AdminSession.closeSession(session);
//    }
    return "/account/adminMain.html";
  }

  @GetMapping("/account/adminIdCheck")
  @ResponseBody
  public boolean adminIdCheck(AdminVO adminVO){
    return adminService.adminIdCheck(adminVO.getAdminId());
  }

  @PostMapping("/account/loginCheck")
  @ResponseBody
  public boolean loginCheck(AdminVO adminVO, HttpSession session){
    AdminDTO adminDTO = adminService.loginCheck(adminVO);
    if(adminDTO != null){
      AdminSession.setSession(adminDTO, session, 3600);
      return true;
    }
    return false;
  }

  @GetMapping("/account/getAdminInfo")
  @ResponseBody
  public AdminDTO getAdminInfo(Model model, HttpSession session){
    if(session.getAttribute("adminInfo") != null) {
      return (AdminDTO) session.getAttribute("adminInfo");
    }
    return null;
  }

  @GetMapping("/account/logout")
  public String logout(HttpSession session){
    if(session.getAttribute("adminInfo") != null){
      AdminSession.closeSession(session);
    }
    return "redirect:/account/login";
  }

  @GetMapping("/admin/getAccountList")
  @ResponseBody
  public List<AdminDTO> getAccountList() {
    return adminService.getAccountList();
  }

  @GetMapping("/account/admin/detail/{id}")
  public String detailView(@PathVariable("id") long id, Model model){
    model.addAttribute("id", id);
    return "/account/adminDetailView.html";
  }

  @GetMapping("/account/getAccountInfo/{id}")
  @ResponseBody
  public AdminDTO getAccountInfo(@PathVariable long id){
    return adminService.getAccountDetail(id);
  }

  @GetMapping("/account/admin/edit/{id}")
  public String editView(@PathVariable long id, Model model){
    model.addAttribute("id", id);
    return "/account/adminEditView.html";
  }

  @PostMapping("/account/adminEditOK")
  @ResponseBody
  public boolean adminEdit(AdminVO adminVO) {
    return adminService.adminEdit(adminVO);
  }

  @GetMapping("/account/adminDelete/{id}")
  @ResponseBody
  public String adminDelete(@PathVariable long id){
    adminService.adminDelete(id);
    return "";
  }

  @GetMapping("/account/sessionCheck")
  @ResponseBody
  public boolean sessionCheck(HttpSession session) {
    return session.getAttribute("adminInfo") != null;
  }

}
