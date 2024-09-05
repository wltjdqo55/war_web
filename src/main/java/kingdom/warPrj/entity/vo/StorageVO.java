package kingdom.warPrj.entity.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StorageVO {

  private long storageId;

  private String item;

  private int attackBonus;

  private int defenseBonus;

  private int forceBonus;

  private int spellBonus;

  private boolean itemState;

  //검색조건
  private String searchOption;

  private String searchKeyword;
}
