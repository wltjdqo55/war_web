package kingdom.warPrj.repasitory.queryDSL;

import com.querydsl.jpa.impl.JPAQueryFactory;
import kingdom.warPrj.entity.entity.QSoldierEntity;
import kingdom.warPrj.entity.entity.QStorageEntity;
import kingdom.warPrj.entity.vo.SoldierVO;
import kingdom.warPrj.entity.vo.StorageVO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SoldierQueryDSL {

  private final JPAQueryFactory jpaQueryFactory;

//  public List<StorageEntity> getSearchItem(StorageVO storageVO){
//    return jpaQueryFactory
//        .selectFrom(QStorageEntity.storageEntity)
//        .where(
//            checkSearchKeywordAndOption(storageVO)
//        )
//        .fetch();
//  }
//
//  private BooleanExpression checkSearchKeywordAndOption(StorageVO storageVO){
//
//    if(storageVO.getSearchOption().equals("all")){
//      return QStorageEntity.storageEntity.item.contains(storageVO.getSearchKeyword());
//    }
//    else if(storageVO.getSearchOption().equals("available")){
//      return QStorageEntity.storageEntity.itemState.eq(true).and(QStorageEntity.storageEntity.item.contains(storageVO.getSearchKeyword()));
//    }
//    else if(storageVO.getSearchOption().equals("notAvailable")){
//      return QStorageEntity.storageEntity.itemState.eq(false).and(QStorageEntity.storageEntity.item.contains(storageVO.getSearchKeyword()));
//    }
//    return null;
//  }
//
//  @Modifying
//  public boolean soldierEdit(SoldierVO soldierVO){
//    long affectedRows = jpaQueryFactory.update(QSoldierEntity.soldierEntity)
//        .set(QSoldierEntity.soldierEntity.soldierPassword, soldierVO.getSoldierPassword())
//        .set(QSoldierEntity.soldierEntity.soldierPassword, soldierVO.getSoldierPassword())
//        .set(QSoldierEntity.soldierEntity.soldierPassword, soldierVO.getSoldierPassword())
//        .set(QSoldierEntity.soldierEntity.soldierPassword, soldierVO.getSoldierPassword())
//        .set(QSoldierEntity.soldierEntity.soldierPassword, soldierVO.getSoldierPassword())
//        .set(QSoldierEntity.soldierEntity.soldierPassword, soldierVO.getSoldierPassword())
//        .set(QSoldierEntity.soldierEntity.soldierPassword, soldierVO.getSoldierPassword())
//        .set(QSoldierEntity.soldierEntity.soldierPassword, soldierVO.getSoldierPassword())
//        .set(QSoldierEntity.soldierEntity.soldierPassword, soldierVO.getSoldierPassword())
//        .set(QSoldierEntity.soldierEntity.soldierPassword, soldierVO.getSoldierPassword())
//        .execute();
//
//    return affectedRows > 0;
//  }
}
