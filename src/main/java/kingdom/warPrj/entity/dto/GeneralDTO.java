package kingdom.warPrj.entity.dto;

import kingdom.warPrj.entity.entity.General;
import kingdom.warPrj.entity.entity.SpeciesEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

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

  public GeneralDTO(General general){
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
