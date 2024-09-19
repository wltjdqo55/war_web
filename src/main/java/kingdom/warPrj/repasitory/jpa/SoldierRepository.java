package kingdom.warPrj.repasitory.jpa;

import kingdom.warPrj.entity.entity.SoldierEntity;
import kingdom.warPrj.entity.entity.SpeciesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SoldierRepository extends JpaRepository<SoldierEntity, Long> {

  Optional<SoldierEntity> findOneBySoldierId(String soldierId);
}
