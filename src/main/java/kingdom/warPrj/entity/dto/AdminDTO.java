package kingdom.warPrj.entity.dto;

import kingdom.warPrj.entity.entity.AdminEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdminDTO {

  private long id;

  private String adminId;

  private String adminPassword;

  private String adminName;

  private String adminPhoneNumber;

  public AdminDTO(AdminEntity adminEntity) {
    this.id = adminEntity.getId();
    this.adminId = adminEntity.getAdminId();
    this.adminPassword = adminEntity.getAdminPassword();
    this.adminName = adminEntity.getAdminName();
    this.adminPhoneNumber = adminEntity.getAdminPhoneNumber();
  }
}
