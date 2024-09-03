package kingdom.warPrj.entity.dto;

import kingdom.warPrj.entity.entity.SkillEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SkillDTO {

  private long id;

  private String skillName;

  private int strengthBonus;

  private int spellBonus;

  private String skillState;

  public SkillDTO(SkillEntity skillEntity){
      this.id = skillEntity.getId();
      this.skillName = skillEntity.getSkillName();
      this.strengthBonus = skillEntity.getStrengthBonus();
      this.spellBonus = skillEntity.getSpellBonus();
      this.skillState = skillEntity.getSkillState();
  }
}
