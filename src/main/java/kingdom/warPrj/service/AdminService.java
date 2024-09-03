package kingdom.warPrj.service;

import kingdom.warPrj.entity.dto.AdminDTO;
import kingdom.warPrj.entity.entity.AdminEntity;
import kingdom.warPrj.entity.vo.AdminVO;
import kingdom.warPrj.repasitory.jpa.AdminRepository;
import kingdom.warPrj.repasitory.queryDSL.AdminQueryDSL;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminService {

  private final AdminRepository adminRepository;
  private final AdminQueryDSL adminQueryDSL;
  private final BCryptPasswordEncoder encoder;

  @Transactional
  public AdminDTO adminAdd(AdminVO adminVO){
    adminVO.setAdminPassword(encoder.encode(adminVO.getAdminPassword()));
    return new AdminDTO(adminRepository.save(new AdminEntity(adminVO)));
  }

  public boolean adminIdCheck(String adminId){
    return adminRepository.findOneByAdminId(adminId).isEmpty();
  }

  public boolean loginCheck(AdminVO adminVO){
    AdminEntity adminEntity = adminRepository.findOneByAdminId(adminVO.getAdminId()).orElse(new AdminEntity());
    return encoder.matches(adminVO.getAdminPassword(), adminEntity.getAdminPassword());
  }
}
