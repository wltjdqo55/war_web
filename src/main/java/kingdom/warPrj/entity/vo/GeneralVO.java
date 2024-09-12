package kingdom.warPrj.entity.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class GeneralVO {

  private long id;

  private String generalName;

  private int generalAge;

  private int attackBonus;

  private int defenseBonus;

  private int movementSpeed;

  private int moraleBonus;

  private int speciesId;    // 종족ID

  private List<Long> selectedLegionIds; //선택된 마물군단 id

  private String searchOption;          //검새 - 셀렉트박스

  private String searchKeyword;         //검색 - 키워드
}
