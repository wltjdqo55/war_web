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
    return true;  //임시
    //return soldierRepository.findOneBySoldierId(soldierId).isEmpty();
  }

  public List<SoldierDTO> getSoldierList(){
    return soldierRepository.findAll().stream().map(SoldierDTO::new).collect(Collectors.toList());
  }

//  public List<StorageDTO> getSearchItem(StorageVO storageVO){
//    List<StorageEntity> list = storageQueryDSL.getSearchItem(storageVO);
//    return list.stream().map(StorageDTO::new).collect(Collectors.toList());
//  }
//
//  public StorageDTO getItemDetail(long id){
//    return new StorageDTO(storageRepository.findById(id).orElse(new StorageEntity()));
//  }
//
//  @Transactional
//  public boolean itemEdit(StorageVO storageVO){
//    return storageQueryDSL.itemEdit(storageVO);
//  }
//
//  public void itemDelete(long id){
//    storageRepository.deleteById(id);
//  }
}
