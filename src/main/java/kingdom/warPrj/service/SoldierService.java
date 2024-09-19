package kingdom.warPrj.service;

import kingdom.warPrj.entity.dto.SoldierDTO;
import kingdom.warPrj.entity.dto.StorageDTO;
import kingdom.warPrj.entity.entity.SoldierEntity;
import kingdom.warPrj.entity.entity.StorageEntity;
import kingdom.warPrj.entity.vo.SoldierVO;
import kingdom.warPrj.entity.vo.StorageVO;
import kingdom.warPrj.repasitory.jpa.SoldierRepository;
import kingdom.warPrj.repasitory.jpa.StorageRepository;
import kingdom.warPrj.repasitory.queryDSL.SkillQueryDSL;
import kingdom.warPrj.repasitory.queryDSL.SoldierQueryDSL;
import kingdom.warPrj.repasitory.queryDSL.StorageQueryDSL;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SoldierService {

  private final SoldierRepository soldierRepository;
  private final SoldierQueryDSL soldierQueryDSL;
  private final StorageQueryDSL storageQueryDSL;
  private final SkillQueryDSL skillQueryDSL;

  @Transactional
  public SoldierDTO soldierAdd(SoldierVO soldierVO){
    SoldierDTO soldierDTO = new SoldierDTO(soldierRepository.save(new SoldierEntity(soldierVO, soldierVO.getSkillId(), soldierVO.getSpeciesId())));

    //스킬 상태 변경
    skillQueryDSL.updateSkillState(soldierVO.getSkillId());

    //아이템 상태 변경, 용사 아이디값 추가
    for(int i = 0 ; i < soldierVO.getSelectedItemId().size() ; i++){
      storageQueryDSL.updateSoldierId(soldierVO.getSelectedItemId().get(i), soldierDTO.getId());
    }

    return soldierDTO;
  }

  public boolean soldierIdCheck(String soldierId){
    return soldierRepository.findOneBySoldierId(soldierId).isEmpty();
  }

  public List<SoldierDTO> getSoldierList(){
    return soldierRepository.findAll().stream().sorted(Comparator.comparingLong(SoldierEntity::getId))
        .map(SoldierDTO::new).collect(Collectors.toList());
  }

  public List<SoldierDTO> getSearchSoldier(SoldierVO soldierVO){
    List<SoldierEntity> list = soldierQueryDSL.getSearchSoldier(soldierVO);
    return list.stream().sorted(Comparator.comparingLong(SoldierEntity::getId))
        .map(SoldierDTO::new).collect(Collectors.toList());
  }

  public SoldierDTO getSoldierDetail(long id){
    SoldierEntity soldierEntity = soldierRepository.findById(id).orElse(new SoldierEntity());

    SoldierDTO soldierDTO = new SoldierDTO(soldierEntity);
    return soldierDTO;
  }

  @Transactional
  public boolean soldierEdit(SoldierVO soldierVO){

      boolean flag = soldierRepository
          .findById(soldierVO.getId())
          .map(t -> {
            t.update(soldierVO);
            return true;
          })
          .orElse(false);

      for(int i = 0 ; i < soldierVO.getBeforeItemIds().size() ; i++){               //storage테이블 용사 아이디 null로 초기화
        storageQueryDSL.initSoldierId(soldierVO.getBeforeItemIds().get(i));
      }

      for(int i = 0 ; i < soldierVO.getSelectedItemId().size() ; i++){              //storage테이블 용사 아이디 update
        storageQueryDSL.updateSoldierId(soldierVO.getSelectedItemId().get(i), soldierVO.getId());
      }
      if(soldierVO.getBeforeSkillId()!=soldierVO.getSkillId() && flag){
        skillQueryDSL.initSkillState(soldierVO.getBeforeSkillId());                 //스킬상태 초기화
        skillQueryDSL.updateSkillState(soldierVO.getSkillId());                     //스킬상태 업데이트
      }

      return flag;
  }

  public void soldierDelete(SoldierVO soldierVO){
    skillQueryDSL.initSkillState(soldierVO.getSkillId());   //스킬 상태 초기화
    storageQueryDSL.initItemState(soldierVO.getId());       //아이템 상태 초기화
    soldierRepository.deleteById(soldierVO.getId());        //용사 삭제
  }

  public SoldierDTO getActiveSoldier(long id){
    if((soldierQueryDSL.getActiveSoldier(id))!=null){
      return new SoldierDTO((soldierQueryDSL.getActiveSoldier(id)));
    }
    return null;
  }
}
