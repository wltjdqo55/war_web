package kingdom.warPrj.entity.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdminVO {

  private long id;

  private String adminId;

  private String adminPassword;

  private String adminName;

  private String adminPhoneNumber;

  private String searchKeyword;
}
