package kingdom.warPrj.repasitory.queryDSL;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kingdom.warPrj.entity.entity.General;
import kingdom.warPrj.entity.entity.QGeneral;
import kingdom.warPrj.entity.entity.QSkillEntity;
import kingdom.warPrj.entity.entity.SkillEntity;
import kingdom.warPrj.entity.vo.GeneralVO;
import kingdom.warPrj.entity.vo.SkillVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class GeneralQueryDSL {

  private final JPAQueryFactory jpaQueryFactory;

  public List<General> getSearchGeneral(GeneralVO generalVO){
    return jpaQueryFactory
        .selectFrom(QGeneral.general)
        .where(
            checkSearchKeywordAndOption(generalVO)
        )
        .fetch();
  }

  private BooleanExpression checkSearchKeywordAndOption(GeneralVO generalVO){

    if(generalVO.getSearchOption().equals("all")){
      return QGeneral.general.generalName.contains(generalVO.getSearchKeyword());
    }
    return QGeneral.general.legions.any().id.eq(Long.valueOf(generalVO.getSearchOption())).and(QGeneral.general.generalName.contains(generalVO.getSearchKeyword()));
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
