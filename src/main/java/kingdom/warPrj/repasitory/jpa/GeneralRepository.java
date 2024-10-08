package kingdom.warPrj.repasitory.jpa;

import kingdom.warPrj.entity.entity.General;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GeneralRepository extends JpaRepository<General, Long> {
  Optional<General> findOneByGeneralName(String generalName);
}
