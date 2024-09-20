package kingdom.warPrj.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ErrorController {

  @GetMapping("/account/error")
  public String errorPage(){
    return "/error/error.html";
  }
}
