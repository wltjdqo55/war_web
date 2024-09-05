package kingdom.warPrj.service;

import kingdom.warPrj.entity.dto.StorageDTO;
import kingdom.warPrj.entity.entity.StorageEntity;
import kingdom.warPrj.entity.vo.SkillVO;
import kingdom.warPrj.entity.vo.StorageVO;
import kingdom.warPrj.repasitory.jpa.StorageRepository;
import kingdom.warPrj.repasitory.queryDSL.StorageQueryDSL;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StorageService {

  private final StorageRepository storageRepository;
  private final StorageQueryDSL storageQueryDSL;

  @Transactional
  public StorageDTO itemAdd(StorageVO storageVO){
    storageVO.setItemState(true);
    return new StorageDTO(storageRepository.save(new StorageEntity(storageVO)));
  }

  public boolean itemNameCheck(String itemName){
    return storageRepository.findOneByItem(itemName).isEmpty();
  }

  public List<StorageDTO> getItemList(){
    return storageRepository.findAll().stream().map(StorageDTO::new).collect(Collectors.toList());
  }

  public List<StorageDTO> getSearchItem(StorageVO storageVO){
    List<StorageEntity> list = storageQueryDSL.getSearchItem(storageVO);
    return list.stream().map(StorageDTO::new).collect(Collectors.toList());
  }

  public StorageDTO getItemDetail(long id){
    return new StorageDTO(storageRepository.findById(id).orElse(new StorageEntity()));
  }

  @Transactional
  public boolean itemEdit(StorageVO storageVO){
    return storageQueryDSL.itemEdit(storageVO);
  }

  public void itemDelete(long id){
    storageRepository.deleteById(id);
  }
}
