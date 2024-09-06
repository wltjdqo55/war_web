package kingdom.warPrj.entity.entity;

import jakarta.persistence.*;
import kingdom.warPrj.entity.vo.SkillVO;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
@Table(name="skill")
public class SkillEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JoinColumn(name = "skill")
  long id;

  private String skillName;

  private int strengthBonus;

  private int spellBonus;

  private boolean skillState;

  public SkillEntity(SkillVO skillVO){
    this.id = skillVO.getId();
    this.skillName = skillVO.getSkillName();
    this.strengthBonus = skillVO.getStrengthBonus();
    this.spellBonus = skillVO.getSpellBonus();
    this.skillState = skillVO.isSkillState();
  }

  public SkillEntity(long id){
    this.id = id;
  }

}
