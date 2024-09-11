package kingdom.warPrj.repasitory.queryDSL;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kingdom.warPrj.entity.dto.SoldierDTO;
import kingdom.warPrj.entity.entity.QSoldierEntity;
import kingdom.warPrj.entity.entity.QStorageEntity;
import kingdom.warPrj.entity.entity.SoldierEntity;
import kingdom.warPrj.entity.entity.StorageEntity;
import kingdom.warPrj.entity.vo.SoldierVO;
import kingdom.warPrj.entity.vo.StorageVO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SoldierQueryDSL {

  private final JPAQueryFactory jpaQueryFactory;

  public List<SoldierEntity> getSearchSoldier(SoldierVO soldierVO){
    return jpaQueryFactory
        .selectFrom(QSoldierEntity.soldierEntity)
        .where(
            checkSearchKeywordAndOption(soldierVO)
        )
        .fetch();
  }

  private BooleanExpression checkSearchKeywordAndOption(SoldierVO soldierVO){

    if(soldierVO.getSearchOption().equals("all")){
      return QSoldierEntity.soldierEntity.soldierName.contains(soldierVO.getSearchKeyword());
    }
    else if(soldierVO.getSearchOption().equals("available")){
      return QSoldierEntity.soldierEntity.soldierState.eq(false).and(QSoldierEntity.soldierEntity.soldierName.contains(soldierVO.getSearchKeyword()));
    }
    else if(soldierVO.getSearchOption().equals("notAvailable")){
      return QSoldierEntity.soldierEntity.soldierState.eq(true).and(QSoldierEntity.soldierEntity.soldierName.contains(soldierVO.getSearchKeyword()));
    }
    return null;
  }

}
