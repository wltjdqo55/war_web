package kingdom.warPrj.service;

import kingdom.warPrj.entity.dto.GeneralDTO;
import kingdom.warPrj.entity.dto.LegionDTO;
import kingdom.warPrj.entity.dto.SkillDTO;
import kingdom.warPrj.entity.entity.General;
import kingdom.warPrj.entity.entity.Legion;
import kingdom.warPrj.entity.entity.SkillEntity;
import kingdom.warPrj.entity.vo.GeneralVO;
import kingdom.warPrj.entity.vo.SkillVO;
import kingdom.warPrj.repasitory.jpa.GeneralRepository;
import kingdom.warPrj.repasitory.queryDSL.GeneralQueryDSL;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GeneralService {

  private final GeneralRepository generalRepository;
  private final GeneralQueryDSL generalQueryDSL;

  @Transactional
  public GeneralDTO generalAdd(GeneralVO generalVO){
    General saveGeneral = generalRepository.save(new General(generalVO));

    if(!generalVO.getSelectedLegionIds().isEmpty()){
      generalVO.getSelectedLegionIds().stream().forEach(legion -> {
        saveGeneral.getLegions().add(new Legion(legion));
      });
    }

    return new GeneralDTO(saveGeneral);
  }

  public boolean generalNameCheck(String generalName){
    return generalRepository.findOneByGeneralName(generalName).isEmpty();
  }

  public List<GeneralDTO> getGeneralList(){
    return generalRepository.findAll().stream().map(GeneralDTO::new).collect(Collectors.toList());
  }

    public List<GeneralDTO> getSearchGeneral(GeneralVO generalVO){
    List<General> list = generalQueryDSL.getSearchGeneral(generalVO);
    return list.stream().map(GeneralDTO::new).collect(Collectors.toList());
  }

  public GeneralDTO getGeneralDetail(long id){
    return new GeneralDTO(generalRepository.findById(id).orElse(new General()));
  }

  @Transactional
  public boolean generalEdit(GeneralVO generalVO){
    boolean flag = generalRepository
        .findById(generalVO.getId())
        .map(t -> {
          t.update(generalVO);
          return true;
        })
        .orElse(false);

    Set<Long> set1 = new HashSet<>(generalVO.getBeforeLegionIds());
    Set<Long> set2 = new HashSet<>(generalVO.getSelectedLegionIds());

    if(!set1.equals(set2)){     // 두 배열이 동일하지 않으면 실행
      System.out.println(set1);
      System.out.println(set2);

    }
    return flag;
  }

//  public void skillDelete(long id){
//    skillRepository.deleteById(id);
//  }
//
//  public List<SkillDTO> getSkillStateList() {
//    List<SkillEntity> list = skillQueryDSL.getSkillStateList();
//    return list.stream().map(SkillDTO::new).collect(Collectors.toList());
//  }
}
