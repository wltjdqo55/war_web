package kingdom.warPrj.controller;

import kingdom.warPrj.entity.dto.SkillDTO;
import kingdom.warPrj.entity.dto.SpeciesDTO;
import kingdom.warPrj.entity.vo.SkillVO;
import kingdom.warPrj.entity.vo.SpeciesVO;
import kingdom.warPrj.service.SpeciesService;
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
public class SpeciesController {

  private final SpeciesService speciesService;

  @GetMapping("/account/adminMain/species")
  public String species(){
    return "/species/species.html";
  }

  @GetMapping("/account/adminMain/species/add")
  public String speciesAddView() {
    return "/species/speciesAddView";
  }

  @PostMapping("/species/speciesAddOK")
  @ResponseBody
  public SpeciesDTO speciesAdd(SpeciesVO speciesVO) {
    return speciesService.speciesAdd(speciesVO);
  }

  @GetMapping("/species/speciesNameCheck")
  @ResponseBody
  public boolean speciesNameCheck(SpeciesVO speciesVO){
    return speciesService.speciesNameCheck(speciesVO.getSpeciesName());
  }

  @GetMapping("/species/getSpeciesList")
  @ResponseBody
  public List<SpeciesDTO> getSpeciesList() {
    return speciesService.getSpeciesList();
  }

  @GetMapping("/species/getSearchSpecies")
  @ResponseBody
  public List<SpeciesDTO> getSearchSpecies(SpeciesVO speciesVO) {
    return speciesService.getSearchSpecies(speciesVO);
  }

  @GetMapping("/account/adminMain/species/detail/{id}")
  public String detailView(@PathVariable("id") long id, Model model){
    model.addAttribute("id", id);
    return "/species/speciesDetailView.html";
  }

  @GetMapping("/species/getSpeciesInfo/{id}")
  @ResponseBody
  public SpeciesDTO getSpeciesInfo(@PathVariable long id){
    return speciesService.getSpeciesDetail(id);
  }

  @GetMapping("/account/adminMain/species/edit/{id}")
  public String editView(@PathVariable long id, Model model){
    model.addAttribute("id", id);
    return "/species/speciesEditView.html";
  }

  @PostMapping("/species/speciesEditOK")
  @ResponseBody
  public boolean speciesEdit(SpeciesVO speciesVO) {
    return speciesService.speciesEdit(speciesVO);
  }

  @GetMapping("/species/speciesDelete/{id}")
  @ResponseBody
  public String speciesDelete(@PathVariable long id){
    speciesService.speciesDelete(id);
    return "";
  }
}
