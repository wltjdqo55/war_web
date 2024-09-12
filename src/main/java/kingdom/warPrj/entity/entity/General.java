package kingdom.warPrj.entity.entity;

import jakarta.persistence.*;
import kingdom.warPrj.entity.vo.GeneralVO;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
@Table(name="monsterGeneral")
public class General {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String generalName;

  private int generalAge;

  private int attackBonus;

  private int defenseBonus;

  private int movementSpeed;

  private int moraleBonus;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "species_id")
  private SpeciesEntity species; // 천적종족

  public General(GeneralVO generalVO){
    this.id = generalVO.getId();
    this.generalName = generalVO.getGeneralName();
    this.generalAge = generalVO.getGeneralAge();
    this.attackBonus = generalVO.getAttackBonus();
    this.defenseBonus = generalVO.getDefenseBonus();
    this.movementSpeed = generalVO.getMovementSpeed();
    this.moraleBonus = generalVO.getMoraleBonus();
    this.species = new SpeciesEntity(generalVO.getSpeciesId());
  }
}
