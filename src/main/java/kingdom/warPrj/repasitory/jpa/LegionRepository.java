package kingdom.warPrj.repasitory.jpa;

import kingdom.warPrj.entity.entity.Legion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LegionRepository extends JpaRepository<Legion, Long> {

  Optional<Legion> findOneByLegionName(String legionName);
}
