package kingdom.warPrj.service;

import kingdom.warPrj.entity.dto.SpeciesDTO;
import kingdom.warPrj.entity.entity.SpeciesEntity;
import kingdom.warPrj.entity.vo.SpeciesVO;
import kingdom.warPrj.repasitory.jpa.SpeciesRepository;
import kingdom.warPrj.repasitory.queryDSL.GeneralQueryDSL;
import kingdom.warPrj.repasitory.queryDSL.SoldierQueryDSL;
import kingdom.warPrj.repasitory.queryDSL.SpeciesQueryDSL;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SpeciesService {

  private final SpeciesRepository speciesRepository;
  private final SpeciesQueryDSL speciesQueryDSL;
  private final SoldierQueryDSL soldierQueryDSL;
  private final GeneralQueryDSL generalQueryDSL;

  @Transactional
  public SpeciesDTO speciesAdd(SpeciesVO speciesVO){
    return new SpeciesDTO(speciesRepository.save(new SpeciesEntity(speciesVO)));
  }

  public boolean speciesNameCheck(String speciesName){
    return speciesRepository.findOneBySpeciesName(speciesName).isEmpty();
  }

  public List<SpeciesDTO> getSpeciesList(){
    return speciesRepository.findAll().stream().sorted(Comparator.comparingLong(SpeciesEntity::getSpeciesId))
        .map(SpeciesDTO::new).collect(Collectors.toList());
  }

  public List<SpeciesDTO> getSearchSpecies(SpeciesVO speciesVO){
    List<SpeciesEntity> list = speciesQueryDSL.getSearchSpecies(speciesVO);
    return list.stream().sorted(Comparator.comparingLong(SpeciesEntity::getSpeciesId))
        .map(SpeciesDTO::new).collect(Collectors.toList());
  }

  public SpeciesDTO getSpeciesDetail(long id){
    return new SpeciesDTO(speciesRepository.findById(id).orElse(new SpeciesEntity()));
  }

  @Transactional
  public boolean speciesEdit(SpeciesVO speciesVO){
    return speciesQueryDSL.speciesEdit(speciesVO);
  }

  @Transactional
  public void speciesDelete(long id){
    soldierQueryDSL.initSpeciesId(id);  // 용사의 종족 참조 ID null로 변경
    generalQueryDSL.initSpeciesId(id);  // 마물장군의 참조 ID null로 변경
    speciesRepository.deleteById(id);
  }

  public List<SpeciesDTO> getTotalSpecies() {
    return speciesQueryDSL.getTotalSpecies();
  }
}
