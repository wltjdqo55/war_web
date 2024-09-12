package kingdom.warPrj.entity.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class LegionVO {

  private long id;

  private String legionName;

  private int troopCount;         // 병력 수

  private int totalAttack;

  private int totalDefense;

  private int movementSpeed;

  private int morale;

  private List<Long> selectedGeneralIds;
}
