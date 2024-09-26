package kingdom.warPrj.controller;

import kingdom.warPrj.entity.dto.LegionDTO;
import kingdom.warPrj.entity.dto.SoldierDTO;
import kingdom.warPrj.entity.dto.SpeciesDTO;
import kingdom.warPrj.entity.entity.Legion;
import kingdom.warPrj.service.LegionService;
import kingdom.warPrj.service.SoldierService;
import kingdom.warPrj.service.SpeciesService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AnalysisController {

  private final SoldierService soldierService;
  private final LegionService legionService;
  private final SpeciesService speciesService;

  @GetMapping("/account/analysis")
  public String analysis(){
    return "/battle/analysis.html";
  }

  @GetMapping("/analysis/getTotalSoldier")
  @ResponseBody
  public SoldierDTO getTotalSoldier() {
    return soldierService.getTotalSoldier();
  }

  @GetMapping("/analysis/getTotalLegion")
  @ResponseBody
  public LegionDTO getTotalLegion() {
    return legionService.getTotalLegion();
  }

  @GetMapping("/analysis/getTotalSpecies")
  @ResponseBody
  public List<SpeciesDTO> getTotalSpecies() {
    return speciesService.getTotalSpecies();
  }
}
