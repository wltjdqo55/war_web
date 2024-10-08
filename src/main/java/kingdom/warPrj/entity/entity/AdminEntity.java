package kingdom.warPrj.entity.entity;

import jakarta.persistence.*;
import kingdom.warPrj.entity.vo.AdminVO;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
@Table(name="administrator")
public class AdminEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  long id;

  private String adminId;

  private String adminPassword;

  private String adminName;

  private String adminPhoneNumber;

  public AdminEntity(AdminVO adminVO){
    this.id = adminVO.getId();
    this.adminId = adminVO.getAdminId();
    this.adminPassword = adminVO.getAdminPassword();
    this.adminName = adminVO.getAdminName();
    this.adminPhoneNumber = adminVO.getAdminPhoneNumber();
  }

  public void update(AdminVO adminVO){
    this.id = adminVO.getId();
    this.adminName = adminVO.getAdminName();
    this.adminPhoneNumber = adminVO.getAdminPhoneNumber();
  }


}
