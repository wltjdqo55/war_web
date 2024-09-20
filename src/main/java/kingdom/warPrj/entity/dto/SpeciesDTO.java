package kingdom.warPrj.entity.dto;

import kingdom.warPrj.entity.entity.SpeciesEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SpeciesDTO {

  private long speciesId;

  private String speciesName;

  private int attackBonus;

  private int defenseBonus;

  private int strengthBonus;

  private int spellBonus;

  private int forceBonus;

  private int intelligenceBonus;

  private Long soldierCount;
  private Integer totalAttack;        // 총 공격력
  private Integer totalDefense;       // 총 방어력
  private Integer totalStrength;      // 총 체력
  private Integer totalSpell;         // 총 마력
  private Integer totalForce;         // 총 힘
  private Integer totalIntelligence;   // 총 지능


  public SpeciesDTO(SpeciesEntity speciesEntity){
    this.speciesId = speciesEntity.getSpeciesId();
    this.speciesName = speciesEntity.getSpeciesName();
    this.attackBonus = speciesEntity.getAttackBonus();
    this.defenseBonus = speciesEntity.getDefenseBonus();
    this.strengthBonus = speciesEntity.getStrengthBonus();
    this.spellBonus = speciesEntity.getSpellBonus();
    this.forceBonus = speciesEntity.getForceBonus();
    this.intelligenceBonus = speciesEntity.getIntelligenceBonus();
  }

  public SpeciesDTO(Long speciesId, String speciesName, Long soldierCount, Integer totalAttack,
                    Integer totalDefense, Integer totalStrength, Integer totalSpell,
                    Integer totalForce, Integer totalIntelligence) {
    this.speciesId = speciesId;
    this.speciesName = speciesName;
    this.soldierCount = soldierCount;
    this.totalAttack = totalAttack;
    this.totalDefense = totalDefense;
    this.totalStrength = totalStrength;
    this.totalSpell = totalSpell;
    this.totalForce = totalForce;
    this.totalIntelligence = totalIntelligence;
  }
}
