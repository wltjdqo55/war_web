package kingdom.warPrj.entity.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GeneralVO {

  private long id;

  private String generalName;

  private int generalAge;

  private int attackBonus;

  private int defenseBonus;

  private int movementSpeed;

  private int moraleBonus;

  private int speciesId;    // 종족ID
}
