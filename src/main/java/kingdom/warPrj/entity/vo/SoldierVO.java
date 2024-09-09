package kingdom.warPrj.entity.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class SoldierVO {

  private long id;

  private String soldierId;

  private String soldierPassword;

  private String soldierName;

  private int soldierAge;

  private String soldierBirthPlace;

  private boolean soldierState;

  private int attack;

  private int defense;

  private int strength;

  private int spell;

  private int force;

  private int intelligence;

  //조인//

  private long skillId;

  private long speciesId;

  private List<Long> selectedItemId;

}
