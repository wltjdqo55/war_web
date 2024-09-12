package kingdom.warPrj.repasitory.queryDSL;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kingdom.warPrj.entity.entity.Legion;
import kingdom.warPrj.entity.entity.QLegion;
import kingdom.warPrj.entity.entity.QSkillEntity;
import kingdom.warPrj.entity.entity.SkillEntity;
import kingdom.warPrj.entity.vo.LegionVO;
import kingdom.warPrj.entity.vo.SkillVO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LegionQueryDSL {

  private final JPAQueryFactory jpaQueryFactory;

  public List<Legion> getSearchLegion(LegionVO legionVO){
    return jpaQueryFactory
        .selectFrom(QLegion.legion)
        .where(
            checkSearchKeywordAndOption(legionVO)
        )
        .fetch();
  }

  private BooleanExpression checkSearchKeywordAndOption(LegionVO legionVO){
    if(legionVO.getSearchOption().equals("all")){
      return QLegion.legion.legionName.contains(legionVO.getSearchKeyword());
    }
    return QLegion.legion.generals.any().id.eq(Long.valueOf(legionVO.getSearchOption())).and(QLegion.legion.legionName.contains(legionVO.getSearchKeyword()));
  }

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
