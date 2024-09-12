package kingdom.warPrj.entity.dto;

import kingdom.warPrj.entity.entity.General;
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

//  private int speciesId;    // 종족ID

  public GeneralDTO(General general){
    this.id = general.getId();
    this.generalName = general.getGeneralName();
    this.generalAge = general.getGeneralAge();
    this.attackBonus = general.getAttackBonus();
    this.defenseBonus = general.getDefenseBonus();
    this.movementSpeed = general.getMovementSpeed();
    this.moraleBonus = general.getMoraleBonus();
  }
}
