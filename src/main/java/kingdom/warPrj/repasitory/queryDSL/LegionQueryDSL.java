package kingdom.warPrj.repasitory.queryDSL;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kingdom.warPrj.entity.dto.LegionDTO;
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

  public LegionDTO getTotalLegion() {
    return jpaQueryFactory
        .select(Projections.constructor(LegionDTO.class,
            QLegion.legion.troopCount.sum(),
            QLegion.legion.count(),
            QLegion.legion.totalAttack.sum(),
            QLegion.legion.totalDefense.sum(),
            QLegion.legion.movementSpeed.sum(),
            QLegion.legion.morale.sum()
        ))
        .from(QLegion.legion)
        .fetchOne();
  }
}
