package kingdom.warPrj.entity.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SkillVO {

  private long id;

  private String skillName;

  private int strengthBonus;

  private int spellBonus;

  private boolean skillState;

  //검색조건
  private String searchOption;

  private String searchKeyword;
}
