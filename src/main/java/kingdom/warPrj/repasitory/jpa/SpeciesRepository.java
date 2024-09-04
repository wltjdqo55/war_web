package kingdom.warPrj.repasitory.jpa;

import kingdom.warPrj.entity.entity.SkillEntity;
import kingdom.warPrj.entity.entity.SpeciesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpeciesRepository extends JpaRepository<SpeciesEntity, Long> {

  Optional<SpeciesEntity> findOneBySpeciesName(String speciesName);
}
