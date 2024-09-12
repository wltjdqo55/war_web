package kingdom.warPrj.repasitory.queryDSL;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class GeneralQueryDSL {

  private final JPAQueryFactory jpaQueryFactory;

//  public List<SkillEntity> getSearchSkill(SkillVO skillVO){
//    return jpaQueryFactory
//        .selectFrom(QSkillEntity.skillEntity)
//        .where(
//            checkSearchKeywordAndOption(skillVO)
//        )
//        .fetch();
//  }
//
//  private BooleanExpression checkSearchKeywordAndOption(SkillVO skillVO){
//
//    if(skillVO.getSearchOption().equals("all")){
//      return QSkillEntity.skillEntity.skillName.contains(skillVO.getSearchKeyword());
//    }
//    else if(skillVO.getSearchOption().equals("available")){
//      return QSkillEntity.skillEntity.skillState.eq(true).and(QSkillEntity.skillEntity.skillName.contains(skillVO.getSearchKeyword()));
//    }
//    else if(skillVO.getSearchOption().equals("notAvailable")){
//      return QSkillEntity.skillEntity.skillState.eq(false).and(QSkillEntity.skillEntity.skillName.contains(skillVO.getSearchKeyword()));
//    }
//    return null;
//  }
//
//  @Modifying
//  public boolean skillEdit(SkillVO skillVO){
//    long affectedRows = jpaQueryFactory.update(QSkillEntity.skillEntity)
//        .set(QSkillEntity.skillEntity.strengthBonus, skillVO.getStrengthBonus())
//        .set(QSkillEntity.skillEntity.spellBonus, skillVO.getSpellBonus())
//        .where(QSkillEntity.skillEntity.id.eq(skillVO.getId()))
//        .execute();
//
//    return affectedRows > 0;
//  }
//
//  public List<SkillEntity> getSkillStateList() {
//    return jpaQueryFactory
//        .selectFrom(QSkillEntity.skillEntity)
//        .where(
//            skillStateCheck()
//        )
//        .fetch();
//  }
//
//  public BooleanExpression skillStateCheck() {
//    return QSkillEntity.skillEntity.skillState.isFalse();
//  }
//
//  @Transactional
//  public void updateSkillState(Long id) {
//    jpaQueryFactory.update(QSkillEntity.skillEntity)
//        .set(QSkillEntity.skillEntity.skillState, true)
//        .where(QSkillEntity.skillEntity.id.eq(id))
//        .execute();
//  }
//
//  @Transactional
//  public void initSkillState(Long id) {
//    jpaQueryFactory.update(QSkillEntity.skillEntity)
//        .set(QSkillEntity.skillEntity.skillState, false)
//        .where(QSkillEntity.skillEntity.id.eq(id))
//        .execute();
//  }
}
