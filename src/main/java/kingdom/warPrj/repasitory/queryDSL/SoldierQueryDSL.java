package kingdom.warPrj.repasitory.queryDSL;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kingdom.warPrj.entity.dto.SoldierDTO;
import kingdom.warPrj.entity.entity.*;
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

  public SoldierEntity getActiveSoldier(long id){
    return jpaQueryFactory.selectFrom(QSoldierEntity.soldierEntity)
        .where(
            checkSkillId(id)
        )
        .fetchOne();
  }

  public BooleanExpression checkSkillId(long id){
      if(QSoldierEntity.soldierEntity.skill == null){
        return null;
      }
      else{
        return QSoldierEntity.soldierEntity.skill.id.eq(id);
      }
  }

  public SoldierDTO getTotalSoldier() {
    return jpaQueryFactory
        .select(Projections.constructor(SoldierDTO.class,
            QSoldierEntity.soldierEntity.count(), // 총 용사 수
            QSoldierEntity.soldierEntity.attack.sum()
                .add(QSoldierEntity.soldierEntity.species.attackBonus.sum()),
//                .add(QStorageEntity.storageEntity.attackBonus.sum()), // 총 공격력
            QSoldierEntity.soldierEntity.defense.sum()
                .add(QSoldierEntity.soldierEntity.species.defenseBonus.sum()),
//                .add(QStorageEntity.storageEntity.defenseBonus.sum()), // 총 방어력
            QSoldierEntity.soldierEntity.strength.sum()
                .add(QSoldierEntity.soldierEntity.skill.strengthBonus.sum())
                .add(QSoldierEntity.soldierEntity.species.strengthBonus.sum()), // 총 체력
            QSoldierEntity.soldierEntity.spell.sum()
                .add(QSoldierEntity.soldierEntity.skill.spellBonus.sum())
                .add(QSoldierEntity.soldierEntity.species.spellBonus.sum()),
//                .add(QStorageEntity.storageEntity.spellBonus.sum()), // 총 마력
            QSoldierEntity.soldierEntity.force.sum()
                .add(QSoldierEntity.soldierEntity.species.forceBonus.sum()),
//                .add(QStorageEntity.storageEntity.forceBonus.sum()), // 총 힘
            QSoldierEntity.soldierEntity.intelligence.sum()
                .add(QSoldierEntity.soldierEntity.species.intelligenceBonus.sum())
        ))
        .from(QSoldierEntity.soldierEntity)
//        .innerJoin(QSoldierEntity.soldierEntity.items, QStorageEntity.storageEntity) // 아이템 조인
//        .where(QStorageEntity.storageEntity.itemState.eq(true)) // 사용 중인 아이템만 필터링
        .fetchOne();
  }

}
