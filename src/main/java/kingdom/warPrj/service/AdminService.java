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

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

  public AdminDTO loginCheck(AdminVO adminVO){
    AdminEntity adminEntity = adminRepository.findOneByAdminId(adminVO.getAdminId()).orElse(new AdminEntity());
    if(encoder.matches(adminVO.getAdminPassword(), adminEntity.getAdminPassword())){
      return new AdminDTO(adminEntity);
    }
    return null;
  }

  public List<AdminDTO> getAccountList(){
    return adminRepository.findAll().stream().
        sorted(Comparator.comparingLong(AdminEntity::getId)).
        map(AdminDTO::new).collect(Collectors.toList());
  }

  public AdminDTO getAccountDetail(long id){
    return new AdminDTO(adminRepository.findById(id).orElse(new AdminEntity()));
  }

  @Transactional
  public boolean adminEdit(AdminVO adminVO){
    return adminRepository
        .findById(adminVO.getId())
        .map(t -> {
          t.update(adminVO);
          return true;
        })
        .orElse(false);
  }

  public void adminDelete(long id){
    adminRepository.deleteById(id);
  }

}
