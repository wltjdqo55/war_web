package kingdom.warPrj.repasitory.jpa;

import kingdom.warPrj.entity.entity.SoldierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoldierRepository extends JpaRepository<SoldierEntity, Long> {
}
