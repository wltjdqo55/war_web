package kingdom.warPrj.entity.vo;

import kingdom.warPrj.entity.entity.SkillEntity;
import kingdom.warPrj.entity.entity.SpeciesEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SoldierVO {

  private long id;

  private String soliderId;

  private String soldierPassword;

  private String soldierName;

  private int soldierAge;

  private String soldierBirthPlace;

  private String soldierState;

  private int attack;

  private int defense;

  private int strength;

  private int spell;

  private int force;

  private int intelligence;

  //조인//

  private long skillId;

  private long speciesId;


}
