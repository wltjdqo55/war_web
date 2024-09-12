package kingdom.warPrj.entity.dto;

import kingdom.warPrj.entity.entity.General;
import kingdom.warPrj.entity.entity.Legion;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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

  private List<GeneralDTO> generals = new ArrayList<>();

  public LegionDTO(Legion legion) {
    this.id = legion.getId();
    this.legionName = legion.getLegionName();
    this.troopCount = legion.getTroopCount();
    this.totalAttack = legion.getTotalAttack();
    this.totalDefense = legion.getTotalDefense();
    this.morale = legion.getMorale();
    this.movementSpeed = legion.getMovementSpeed();

    for(General general : legion.getGenerals()){
      this.generals.add(new GeneralDTO(general, null));
    }

  }

  public LegionDTO(Legion legion, Object o){
    this.id = legion.getId();
    this.legionName = legion.getLegionName();
    this.troopCount = legion.getTroopCount();
    this.totalAttack = legion.getTotalAttack();
    this.totalDefense = legion.getTotalDefense();
    this.morale = legion.getMorale();
    this.movementSpeed = legion.getMovementSpeed();
  }
}
