package kingdom.warPrj.repasitory.queryDSL;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
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
//  public boolean itemEdit(StorageVO storageVO){
//    long affectedRows = jpaQueryFactory.update(QStorageEntity.storageEntity)
//        .set(QStorageEntity.storageEntity.attackBonus, storageVO.getAttackBonus())
//        .set(QStorageEntity.storageEntity.defenseBonus, storageVO.getDefenseBonus())
//        .set(QStorageEntity.storageEntity.forceBonus, storageVO.getForceBonus())
//        .set(QStorageEntity.storageEntity.spellBonus, storageVO.getSpellBonus())
//        .where(QStorageEntity.storageEntity.storageId.eq(storageVO.getStorageId()))
//        .execute();
//
//    return affectedRows > 0;
//  }
}
