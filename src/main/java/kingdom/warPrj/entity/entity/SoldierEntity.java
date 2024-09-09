package kingdom.warPrj.entity.entity;

import jakarta.persistence.*;
import kingdom.warPrj.entity.dto.SkillDTO;
import kingdom.warPrj.entity.vo.SoldierVO;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Table(name="soldier")
public class SoldierEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
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

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "soldierEntity")
  private List<StorageEntity> items = new ArrayList<>();

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "skill_id")
  private SkillEntity skill;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "species_id")
  private SpeciesEntity species;

  public SoldierEntity(SoldierVO soldierVO, Long skillId, Long speciesId){
    this.id = soldierVO.getId();
    this.attack = soldierVO.getAttack();
    this.defense = soldierVO.getDefense();
    this.force = soldierVO.getForce();
    this.soldierAge = soldierVO.getSoldierAge();
    this.soldierName = soldierVO.getSoldierName();
    this.intelligence = soldierVO.getIntelligence();
    this.soldierId = soldierVO.getSoldierId();
    this.soldierPassword = soldierVO.getSoldierPassword();
    this.soldierBirthPlace = soldierVO.getSoldierBirthPlace();
    this.soldierState = soldierVO.isSoldierState();
    this.strength = soldierVO.getStrength();
    this.spell = soldierVO.getSpell();
    this.skill = new SkillEntity(skillId);        // 스킬 정보
    this.species = new SpeciesEntity(speciesId);  // 종족 정보
  }

  public SoldierEntity(Long id){
    this.id = id;
  }

}
