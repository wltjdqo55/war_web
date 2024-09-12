package kingdom.warPrj.entity.entity;

import jakarta.persistence.*;
import kingdom.warPrj.entity.vo.SkillVO;
import kingdom.warPrj.entity.vo.SpeciesVO;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Table(name="species")
public class SpeciesEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JoinColumn(name = "species_id")
  private long speciesId;

  private String speciesName;

  private int attackBonus;

  private int defenseBonus;

  private int strengthBonus;

  private int spellBonus;

  private int forceBonus;

  private int intelligenceBonus;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "species")
  private List<SoldierEntity> soldier = new ArrayList<>();

  @OneToMany(mappedBy = "species", fetch = FetchType.LAZY)
  private List<General> generals = new ArrayList<>();

  public SpeciesEntity(SpeciesVO speciesVO){
    this.speciesId = speciesVO.getSpeciesId();
    this.speciesName = speciesVO.getSpeciesName();
    this.attackBonus = speciesVO.getAttackBonus();
    this.defenseBonus = speciesVO.getSpellBonus();
    this.strengthBonus = speciesVO.getStrengthBonus();
    this.spellBonus = speciesVO.getSpellBonus();
    this.forceBonus = speciesVO.getForceBonus();
    this.intelligenceBonus = speciesVO.getIntelligenceBonus();
  }

  public SpeciesEntity(long speciesId) {
    this.speciesId = speciesId;
  }
}
