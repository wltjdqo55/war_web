package kingdom.warPrj.repasitory.queryDSL;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kingdom.warPrj.entity.entity.QSkillEntity;
import kingdom.warPrj.entity.entity.SkillEntity;
import kingdom.warPrj.entity.vo.SkillVO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SkillQueryDSL {

  private final JPAQueryFactory jpaQueryFactory;

  public List<SkillEntity> getSearchSkill(SkillVO skillVO){
    return jpaQueryFactory
        .selectFrom(QSkillEntity.skillEntity)
        .where(
            checkSearchKeywordAndOption(skillVO)
        )
        .fetch();
  }

  private BooleanExpression checkSearchKeywordAndOption(SkillVO skillVO){

    if(skillVO.getSearchOption().equals("all")){
      return QSkillEntity.skillEntity.skillName.contains(skillVO.getSearchKeyword());
    }
    else if(skillVO.getSearchOption().equals("available")){
      return QSkillEntity.skillEntity.skillState.eq(false).and(QSkillEntity.skillEntity.skillName.contains(skillVO.getSearchKeyword()));
    }
    else if(skillVO.getSearchOption().equals("notAvailable")){
      return QSkillEntity.skillEntity.skillState.eq(true).and(QSkillEntity.skillEntity.skillName.contains(skillVO.getSearchKeyword()));
    }
    return null;
  }

  @Modifying
  public boolean skillEdit(SkillVO skillVO){
    long affectedRows = jpaQueryFactory.update(QSkillEntity.skillEntity)
        .set(QSkillEntity.skillEntity.strengthBonus, skillVO.getStrengthBonus())
        .set(QSkillEntity.skillEntity.spellBonus, skillVO.getSpellBonus())
        .where(QSkillEntity.skillEntity.id.eq(skillVO.getId()))
        .execute();

    return affectedRows > 0;
  }

  public List<SkillEntity> getSkillStateList() {
    return jpaQueryFactory
        .selectFrom(QSkillEntity.skillEntity)
        .where(
            skillStateCheck()
        )
        .fetch();
  }

  public BooleanExpression skillStateCheck() {
      return QSkillEntity.skillEntity.skillState.isFalse();
  }

  @Transactional
  public void updateSkillState(Long id) {
    jpaQueryFactory.update(QSkillEntity.skillEntity)
        .set(QSkillEntity.skillEntity.skillState, true)
        .where(QSkillEntity.skillEntity.id.eq(id))
        .execute();
  }

  @Transactional
  public void initSkillState(Long id) {
    jpaQueryFactory.update(QSkillEntity.skillEntity)
        .set(QSkillEntity.skillEntity.skillState, false)
        .where(QSkillEntity.skillEntity.id.eq(id))
        .execute();
  }
}
