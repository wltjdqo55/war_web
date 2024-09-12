package kingdom.warPrj.entity.entity;

import jakarta.persistence.*;
import kingdom.warPrj.entity.vo.LegionVO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Lazy;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Table(name="monsterLegion")
public class Legion {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String legionName;

  private int troopCount;         // 병력 수

  private int totalAttack;

  private int totalDefense;

  private int movementSpeed;

  private int morale;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
      name="monster_legion_general",
      joinColumns = @JoinColumn(name = "monster_legion_id"),
      inverseJoinColumns = @JoinColumn(name = "monster_general_id")
  )
  private List<General> generals = new ArrayList<>();

  public Legion(LegionVO legionVO){
    this.id = legionVO.getId();
    this.legionName = legionVO.getLegionName();
    this.troopCount = legionVO.getTroopCount();
    this.totalAttack = legionVO.getTotalAttack();
    this.totalDefense = legionVO.getTotalDefense();
    this.morale = legionVO.getMorale();
    this.movementSpeed = legionVO.getMovementSpeed();
  }

  public Legion(long id){
    this.id = id;
  }
}
