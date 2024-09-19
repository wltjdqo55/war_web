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

  private String searchOption; // 검색옵션
  
  private String searchKeyword; // 검색키워드

  private List<Long> selectedGeneralIds; //선택된 마물군단 id

  private List<Long> beforeGeneralIds;   //기존 마물군단 아이디
}
