package kingdom.warPrj.entity.dto;

import kingdom.warPrj.entity.entity.SoldierEntity;
import kingdom.warPrj.entity.entity.StorageEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class SoldierDTO {

  private long id;

  private String soldierId;

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

  private long skillId; // 참조 아이디

  private long speciesId; // 참조 아이디

  private String speciesName;

  private String skillName;

  //스킬보정
  private int skillStrength;

  private int skillSpell;

  //종족보정
  private int speciesAttack;

  private int speciesDefense;

  private int speciesStrength;

  private int speciesSpell;

  private int speciesForce;

  private int speciesIntelligence;

  //아이템보정
  private List<StorageDTO> items = new ArrayList<>();

  public SoldierDTO(SoldierEntity soldierEntity) {
    this.id = soldierEntity.getId();
    this.attack = soldierEntity.getAttack();
    this.defense = soldierEntity.getDefense();
    this.force = soldierEntity.getForce();
    this.soldierAge = soldierEntity.getSoldierAge();
    this.soldierName = soldierEntity.getSoldierName();
    this.intelligence = soldierEntity.getIntelligence();
    this.soldierId = soldierEntity.getSoldierId();
    this.soldierPassword = soldierEntity.getSoldierPassword();
    this.soldierBirthPlace = soldierEntity.getSoldierBirthPlace();
    this.soldierState = soldierEntity.isSoldierState() ? "사망" : "생존";
    this.strength = soldierEntity.getStrength();
    this.spell = soldierEntity.getSpell();
    this.skillId = soldierEntity.getSkill().getId();  // 스킬 아이디
    this.speciesId = soldierEntity.getSpecies().getSpeciesId(); // 종족 아이디
    this.speciesName = soldierEntity.getSpecies().getSpeciesName();
    this.skillName = soldierEntity.getSkill().getSkillName();
    this.skillStrength = soldierEntity.getSkill().getStrengthBonus();
    this.skillSpell = soldierEntity.getSkill().getSpellBonus();
    this.speciesAttack = soldierEntity.getSpecies().getAttackBonus();
    this.speciesDefense = soldierEntity.getSpecies().getDefenseBonus();
    this.speciesSpell = soldierEntity.getSpecies().getSpellBonus();
    this.speciesForce = soldierEntity.getSpecies().getForceBonus();
    this.speciesIntelligence = soldierEntity.getSpecies().getIntelligenceBonus();
    this.speciesStrength = soldierEntity.getSpecies().getStrengthBonus();

    for (StorageEntity storageEntity : soldierEntity.getItems()) {
      this.items.add(new StorageDTO(storageEntity, null));  // 재귀함수 호출로 인해 생성자 따로 생성
    }
  }
}
