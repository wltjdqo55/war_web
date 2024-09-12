package kingdom.warPrj.entity.dto;

import kingdom.warPrj.entity.entity.Legion;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class LegionDTO {

  private long id;

  private String legionName;

  private int troopCount;         // 병력 수

  private int totalAttack;

  private int totalDefense;

  private int movementSpeed;

  private int morale;

  public LegionDTO(Legion legion) {
    this.id = legion.getId();
    this.legionName = legion.getLegionName();
    this.troopCount = legion.getTroopCount();
    this.totalAttack = legion.getTotalAttack();
    this.totalDefense = legion.getTotalDefense();
    this.morale = legion.getMorale();
    this.movementSpeed = legion.getMovementSpeed();
  }
}
