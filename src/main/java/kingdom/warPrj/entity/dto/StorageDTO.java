package kingdom.warPrj.entity.dto;

import kingdom.warPrj.entity.entity.SoldierEntity;
import kingdom.warPrj.entity.entity.StorageEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StorageDTO {

  private long storageId;

  private String item;

  private String itemName;

  private int attackBonus;

  private int defenseBonus;

  private int forceBonus;

  private int spellBonus;

  private String itemState;

  private SoldierDTO soldierDTO;

  public StorageDTO(StorageEntity storageEntity){
    this.storageId = storageEntity.getStorageId();
    this.item = storageEntity.getItem();
    this.itemName = storageEntity.getItemName();
    this.attackBonus = storageEntity.getAttackBonus();
    this.defenseBonus = storageEntity.getDefenseBonus();
    this.forceBonus = storageEntity.getForceBonus();
    this.spellBonus = storageEntity.getSpellBonus();
    this.itemState = storageEntity.isItemState() ? "사용불가" : "사용가능";
    this.soldierDTO = new SoldierDTO(storageEntity.getSoldierEntity());
  }
}
