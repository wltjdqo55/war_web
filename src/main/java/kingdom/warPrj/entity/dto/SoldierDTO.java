package kingdom.warPrj.entity.dto;

import kingdom.warPrj.entity.entity.SoldierEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

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
  }
}
