package kingdom.warPrj.repasitory.queryDSL;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kingdom.warPrj.entity.entity.QSkillEntity;
import kingdom.warPrj.entity.entity.QStorageEntity;
import kingdom.warPrj.entity.entity.SkillEntity;
import kingdom.warPrj.entity.entity.StorageEntity;
import kingdom.warPrj.entity.vo.SoldierVO;
import kingdom.warPrj.entity.vo.StorageVO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

  public List<StorageEntity> getItemStateList(long id) {
    return jpaQueryFactory
        .selectFrom(QStorageEntity.storageEntity)
        .where(
            ItemStateCheck(id)
        )
        .fetch();
  }

  public BooleanExpression ItemStateCheck(long id) {
    System.out.println(id);
    return QStorageEntity.storageEntity.itemState.isFalse().or(QStorageEntity.storageEntity.soldierEntity.id.eq(id));
  }

  @Transactional
  public void updateSoldierId(Long storageId, Long soldierId){
    jpaQueryFactory
        .update(QStorageEntity.storageEntity)
        .set(QStorageEntity.storageEntity.soldierEntity.id, soldierId)
        .set(QStorageEntity.storageEntity.itemState, true)
        .where(QStorageEntity.storageEntity.storageId.eq(storageId))
        .execute();

  }

  @Transactional
  public void initSoldierId(Long id){
    jpaQueryFactory
        .update(QStorageEntity.storageEntity)
        .set(QStorageEntity.storageEntity.soldierEntity.id, (Long) null)
        .set(QStorageEntity.storageEntity.itemState, false)
        .where(QStorageEntity.storageEntity.storageId.eq(id))
        .execute();
  }

  @Transactional
  public void initItemState(Long id){
    jpaQueryFactory
        .update(QStorageEntity.storageEntity)
        .set(QStorageEntity.storageEntity.itemState, false)
        .set(QStorageEntity.storageEntity.soldierEntity.id, (Long) null)
        .where(QStorageEntity.storageEntity.soldierEntity.id.eq(id))
        .execute();
  }
}
