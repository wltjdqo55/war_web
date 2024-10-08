package kingdom.warPrj.repasitory.jpa;

import kingdom.warPrj.entity.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity, Long> {

  Optional<AdminEntity> findOneByAdminId(String adminId);
}
