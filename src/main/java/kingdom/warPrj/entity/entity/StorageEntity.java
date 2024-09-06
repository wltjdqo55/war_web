package kingdom.warPrj.entity.entity;

import jakarta.persistence.*;
import kingdom.warPrj.entity.vo.StorageVO;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
@Table(name="storage")
public class StorageEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long storageId;

  private String item;

  private String itemName;

  private int attackBonus;

  private int defenseBonus;

  private int forceBonus;

  private int spellBonus;

  private boolean itemState;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "soldier_id")
  private SoldierEntity soldierEntity;  // 용사

  public StorageEntity(StorageVO storageVO){
    this.soldierEntity = new SoldierEntity(storageVO.getSoldierId());
    this.storageId = storageVO.getStorageId();
    this.item = storageVO.getItem();
    this.itemName = storageVO.getItemName();
    this.attackBonus = storageVO.getAttackBonus();
    this.defenseBonus = storageVO.getDefenseBonus();
    this.forceBonus = storageVO.getForceBonus();
    this.spellBonus = storageVO.getSpellBonus();
    this.itemState = storageVO.isItemState();
  }
}
