package kingdom.warPrj.repasitory.queryDSL;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kingdom.warPrj.entity.entity.QSkillEntity;
import kingdom.warPrj.entity.entity.SkillEntity;
import kingdom.warPrj.entity.vo.SkillVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

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
      return QSkillEntity.skillEntity.skillState.eq(true).and(QSkillEntity.skillEntity.skillName.contains(skillVO.getSearchKeyword()));
    }
    else if(skillVO.getSearchOption().equals("notAvailable")){
      return QSkillEntity.skillEntity.skillState.eq(false).and(QSkillEntity.skillEntity.skillName.contains(skillVO.getSearchKeyword()));
    }
    return null;
  }

}
