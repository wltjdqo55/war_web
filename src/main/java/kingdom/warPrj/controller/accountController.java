package kingdom.warPrj.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class accountController {

  @GetMapping("/account/login")
  public String loginPage() {return "/account/login.html";}

  @GetMapping("/account/adminAdd")
  public String adminAddPage() {
    return "/account/adminAdd.html";
  }

}
