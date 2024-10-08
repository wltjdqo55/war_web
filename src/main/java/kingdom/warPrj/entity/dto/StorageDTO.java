package kingdom.warPrj.entity.dto;

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

  private SoldierDTO soldier;

  private Integer totalAttack;

  private Integer totalDefense;

  private Integer totalForce;

  private Integer totalSpell;

  public StorageDTO(StorageEntity storageEntity){
    this.storageId = storageEntity.getStorageId();
    this.item = storageEntity.getItem();
    this.itemName = storageEntity.getItemName();
    this.attackBonus = storageEntity.getAttackBonus();
    this.defenseBonus = storageEntity.getDefenseBonus();
    this.forceBonus = storageEntity.getForceBonus();
    this.spellBonus = storageEntity.getSpellBonus();
    this.itemState = storageEntity.isItemState() ? "사용중" : "사용가능";
    if(storageEntity.getSoldierEntity() != null){
      this.soldier = new SoldierDTO(storageEntity.getSoldierEntity());
    }
  }

  public StorageDTO(StorageEntity storageEntity, Object o){
    this.storageId = storageEntity.getStorageId();
    this.item = storageEntity.getItem();
    this.itemName = storageEntity.getItemName();
    this.attackBonus = storageEntity.getAttackBonus();
    this.defenseBonus = storageEntity.getDefenseBonus();
    this.forceBonus = storageEntity.getForceBonus();
    this.spellBonus = storageEntity.getSpellBonus();
    this.itemState = storageEntity.isItemState() ? "사용중" : "사용가능";
  }

  public StorageDTO(Integer totalAttack, Integer totalDefense, Integer totalForce, Integer totalSpell){
    this.totalAttack = totalAttack;
    this.totalDefense = totalDefense;
    this.totalForce = totalForce;
    this.totalSpell = totalSpell;
  }

}
