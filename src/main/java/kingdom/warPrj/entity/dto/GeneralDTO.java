package kingdom.warPrj.entity.dto;

import kingdom.warPrj.entity.entity.General;
import kingdom.warPrj.entity.entity.Legion;
import kingdom.warPrj.entity.entity.SpeciesEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class GeneralDTO {

  private long id;

  private String generalName;

  private int generalAge;

  private int attackBonus;

  private int defenseBonus;

  private int movementSpeed;

  private int moraleBonus;

  private String speciesName;    // 종족

  private SpeciesEntity species;

  private long speciesId;

  private List<LegionDTO> legions = new ArrayList<>();

  public GeneralDTO(General general){
    this.id = general.getId();
    this.generalName = general.getGeneralName();
    this.generalAge = general.getGeneralAge();
    this.attackBonus = general.getAttackBonus();
    this.defenseBonus = general.getDefenseBonus();
    this.movementSpeed = general.getMovementSpeed();
    this.moraleBonus = general.getMoraleBonus();
    this.speciesName = general.getSpecies().getSpeciesName();
    this.speciesId = general.getSpecies().getSpeciesId();

    for(Legion legion : general.getLegions()){
      this.legions.add(new LegionDTO(legion, null));
    }
  }

  public GeneralDTO(General general, Object o){
    this.id = general.getId();
    this.generalName = general.getGeneralName();
    this.generalAge = general.getGeneralAge();
    this.attackBonus = general.getAttackBonus();
    this.defenseBonus = general.getDefenseBonus();
    this.movementSpeed = general.getMovementSpeed();
    this.moraleBonus = general.getMoraleBonus();
    this.speciesName = general.getSpecies().getSpeciesName();
  }
}
