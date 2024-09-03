package kingdom.warPrj.repasitory.jpa;

import kingdom.warPrj.entity.entity.AdminEntity;
import kingdom.warPrj.entity.entity.SkillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SkillRepository extends JpaRepository<SkillEntity, Long> {

  Optional<SkillEntity> findOneBySkillName(String SkillName);
}
