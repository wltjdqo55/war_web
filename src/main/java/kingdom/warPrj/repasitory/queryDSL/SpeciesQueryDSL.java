package kingdom.warPrj.repasitory.queryDSL;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kingdom.warPrj.entity.entity.QSkillEntity;
import kingdom.warPrj.entity.entity.QSpeciesEntity;
import kingdom.warPrj.entity.entity.SkillEntity;
import kingdom.warPrj.entity.entity.SpeciesEntity;
import kingdom.warPrj.entity.vo.SkillVO;
import kingdom.warPrj.entity.vo.SpeciesVO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor

public class SpeciesQueryDSL {

  private final JPAQueryFactory jpaQueryFactory;

  public List<SpeciesEntity> getSearchSpecies(SpeciesVO speciesVO){
    return jpaQueryFactory
        .selectFrom(QSpeciesEntity.speciesEntity)
        .where(
            QSpeciesEntity.speciesEntity.speciesName.contains(speciesVO.getSearchKeyword())
        )
        .fetch();
  }

  @Modifying
  public boolean speciesEdit(SpeciesVO speciesVO){
    long affectedRows = jpaQueryFactory.update(QSpeciesEntity.speciesEntity)
        .set(QSpeciesEntity.speciesEntity.attackBonus, speciesVO.getAttackBonus())
        .set(QSpeciesEntity.speciesEntity.defenseBonus, speciesVO.getDefenseBonus())
        .set(QSpeciesEntity.speciesEntity.strengthBonus, speciesVO.getStrengthBonus())
        .set(QSpeciesEntity.speciesEntity.spellBonus, speciesVO.getSpellBonus())
        .set(QSpeciesEntity.speciesEntity.forceBonus, speciesVO.getForceBonus())
        .set(QSpeciesEntity.speciesEntity.intelligenceBonus, speciesVO.getIntelligenceBonus())
        .where(QSpeciesEntity.speciesEntity.speciesId.eq(speciesVO.getSpeciesId()))
        .execute();

    return affectedRows > 0;
  }
}
