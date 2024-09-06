package kingdom.warPrj.repasitory.jpa;

import kingdom.warPrj.entity.entity.SpeciesEntity;
import kingdom.warPrj.entity.entity.StorageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StorageRepository extends JpaRepository<StorageEntity, Long> {
  Optional<StorageEntity> findOneByItemName(String itemName);
}
