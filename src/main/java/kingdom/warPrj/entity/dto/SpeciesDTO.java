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

}
