package kingdom.warPrj.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class BattleController {

  @GetMapping("/account/battle")
  public String battlePage() {
    return "/battle/battle.html";
  }
}
