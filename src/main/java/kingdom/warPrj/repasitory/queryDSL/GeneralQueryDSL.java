package kingdom.warPrj.repasitory.queryDSL;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kingdom.warPrj.entity.dto.GeneralDTO;
import kingdom.warPrj.entity.entity.*;
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

  public GeneralDTO getTotalGeneral() {
    QGeneral general = QGeneral.general;
    QLegion legion = QLegion.legion;

    return jpaQueryFactory
        .select(Projections.constructor(GeneralDTO.class,
            general.count(), // 장군 수
            general.attackBonus.sum(), // 총 공격력
            general.defenseBonus.sum(), // 총 방어력
            general.movementSpeed.sum(), // 총 방어력
            general.moraleBonus.sum() // 총 방어력
        ))
        .from(general)
        .join(general.legions, legion) // Many-to-Many 조인
        .fetchOne();
  }
}
