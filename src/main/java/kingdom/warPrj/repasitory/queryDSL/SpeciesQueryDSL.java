package kingdom.warPrj.repasitory.queryDSL;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kingdom.warPrj.entity.dto.SpeciesDTO;
import kingdom.warPrj.entity.entity.QSoldierEntity;
import kingdom.warPrj.entity.entity.QSpeciesEntity;
import kingdom.warPrj.entity.entity.SpeciesEntity;
import kingdom.warPrj.entity.vo.SpeciesVO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor

public class SpeciesQueryDSL {

  private final JPAQueryFactory jpaQueryFactory;

  QSpeciesEntity species = QSpeciesEntity.speciesEntity;
  QSoldierEntity soldier = QSoldierEntity.soldierEntity;

  public List<SpeciesEntity> getSearchSpecies(SpeciesVO speciesVO){
    return jpaQueryFactory
        .selectFrom(species)
        .where(
            species.speciesName.contains(speciesVO.getSearchKeyword())
        )
        .fetch();
  }

  @Modifying
  public boolean speciesEdit(SpeciesVO speciesVO){
    long affectedRows = jpaQueryFactory.update(species)
        .set(species.attackBonus, speciesVO.getAttackBonus())
        .set(species.defenseBonus, speciesVO.getDefenseBonus())
        .set(species.strengthBonus, speciesVO.getStrengthBonus())
        .set(species.spellBonus, speciesVO.getSpellBonus())
        .set(species.forceBonus, speciesVO.getForceBonus())
        .set(species.intelligenceBonus, speciesVO.getIntelligenceBonus())
        .where(species.speciesId.eq(speciesVO.getSpeciesId()))
        .execute();

    return affectedRows > 0;
  }

  public List<SpeciesDTO> getTotalSpecies() {


    return jpaQueryFactory
        .select(Projections.constructor(SpeciesDTO.class,
            species.speciesId,
            species.speciesName,
            soldier.countDistinct().as("soldierCount"), // 종족에 속한 용사 수
            species.attackBonus.multiply(soldier.count()).as("totalAttack"), // 총 공격력 = 종족의 공격력 * 용사 수
            species.defenseBonus.multiply(soldier.count()).as("totalDefense"), // 총 방어력 = 종족의 방어력 * 용사 수
            species.strengthBonus.multiply(soldier.count()).as("totalStrength"),
            species.spellBonus.multiply(soldier.count()).as("totalSpell"),
            species.forceBonus.multiply(soldier.count()).as("totalForce"),
            species.intelligenceBonus.multiply(soldier.count()).as("totalIntelligence")
        ))
        .from(species)
        .leftJoin(species.soldier, soldier) // 종족과 용사 조인
        .groupBy(species.speciesId, species.speciesName, species.attackBonus, species.defenseBonus, species.strengthBonus, species.spellBonus, species.forceBonus, species.intelligenceBonus) // 종족별로 그룹화
        .orderBy(soldier.count().desc())
        .fetch();
  }
}
