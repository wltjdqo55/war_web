package kingdom.warPrj.entity.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SpeciesVO {

  private long speciesId;

  private String speciesName;

  private int attackBonus;

  private int defenseBonus;

  private int strengthBonus;

  private int spellBonus;

  private int forceBonus;

  private int intelligenceBonus;

  //검색
  private String searchKeyword;

}
