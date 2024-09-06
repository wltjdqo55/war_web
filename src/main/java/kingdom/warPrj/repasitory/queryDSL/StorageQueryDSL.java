package kingdom.warPrj.repasitory.queryDSL;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kingdom.warPrj.entity.entity.QSkillEntity;
import kingdom.warPrj.entity.entity.QStorageEntity;
import kingdom.warPrj.entity.entity.SkillEntity;
import kingdom.warPrj.entity.entity.StorageEntity;
import kingdom.warPrj.entity.vo.StorageVO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StorageQueryDSL {

  private final JPAQueryFactory jpaQueryFactory;

  public List<StorageEntity> getSearchItem(StorageVO storageVO){
    return jpaQueryFactory
        .selectFrom(QStorageEntity.storageEntity)
        .where(
            checkSearchKeywordAndOption(storageVO)
        )
        .fetch();
  }

  private BooleanExpression checkSearchKeywordAndOption(StorageVO storageVO){

    if(storageVO.getSearchOption().equals("all")){
      return QStorageEntity.storageEntity.itemName.contains(storageVO.getSearchKeyword());
    }
    else if(storageVO.getSearchOption().equals("available")){
      return QStorageEntity.storageEntity.itemState.eq(true).and(QStorageEntity.storageEntity.itemName.contains(storageVO.getSearchKeyword()));
    }
    else if(storageVO.getSearchOption().equals("notAvailable")){
      return QStorageEntity.storageEntity.itemState.eq(false).and(QStorageEntity.storageEntity.itemName.contains(storageVO.getSearchKeyword()));
    }
    return null;
  }

  @Modifying
  public boolean itemEdit(StorageVO storageVO){
    long affectedRows = jpaQueryFactory.update(QStorageEntity.storageEntity)
        .set(QStorageEntity.storageEntity.attackBonus, storageVO.getAttackBonus())
        .set(QStorageEntity.storageEntity.defenseBonus, storageVO.getDefenseBonus())
        .set(QStorageEntity.storageEntity.forceBonus, storageVO.getForceBonus())
        .set(QStorageEntity.storageEntity.spellBonus, storageVO.getSpellBonus())
        .where(QStorageEntity.storageEntity.storageId.eq(storageVO.getStorageId()))
        .execute();

    return affectedRows > 0;
  }

  public List<StorageEntity> getItemStateList() {
    return jpaQueryFactory
        .selectFrom(QStorageEntity.storageEntity)
        .where(
            ItemStateCheck()
        )
        .fetch();
  }

  public BooleanExpression ItemStateCheck() {
    return QStorageEntity.storageEntity.itemState.eq(false);
  }
}
