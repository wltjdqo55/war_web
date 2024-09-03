package kingdom.warPrj.controller;

import kingdom.warPrj.entity.dto.AdminDTO;
import kingdom.warPrj.entity.vo.AdminVO;
import kingdom.warPrj.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class AccountController {

  private final AdminService adminService;

  @GetMapping("/account/login")
  public String loginPage() {return "/account/login.html";}

  @GetMapping("/account/adminAdd")
  public String adminAddPage() {
    return "/account/adminAdd.html";
  }

  @PostMapping("/account/adminAddOK")
  @ResponseBody
  public AdminDTO adminAdd(AdminVO adminVO) {
      return adminService.adminAdd(adminVO);
  }

  @GetMapping("/account/adminMain")
  public String adminMainPage() {
    return "/account/adminMain.html";
  }

  @GetMapping("/account/adminIdCheck")
  @ResponseBody
  public boolean adminIdCheck(AdminVO adminVO){
    return adminService.adminIdCheck(adminVO.getAdminId());
  }

  @PostMapping("/account/loginCheck")
  @ResponseBody
  public boolean loginCheck(AdminVO adminVO){
    System.out.println(adminVO);
    return adminService.loginCheck(adminVO);
  }
}
