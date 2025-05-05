package will.demo.coindesk.service;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import will.demo.coindesk.entity.dto.CurrencyInfoDTO;
import will.demo.coindesk.entity.model.CurrencyInfo;
import will.demo.coindesk.entity.vo.CurrencyInfoVO;
import will.demo.coindesk.repository.CurrencyInfoRepository;
import will.demo.coindesk.util.BeanCopyUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CurrencyInfoService {

    private final CurrencyInfoRepository currencyInfoRepository;

    public CurrencyInfoVO query(Long id) {
        Optional<CurrencyInfo> opt = currencyInfoRepository.findById(id);
        if (!opt.isPresent()) {
            return null;
        }
        CurrencyInfoVO vo = new CurrencyInfoVO();
        BeanUtils.copyProperties(opt.get(), vo);
        return vo;
    }

    public List<CurrencyInfoVO> queryAll() {
        List<CurrencyInfoVO> vos = new ArrayList<>();
        CurrencyInfoVO vo = new CurrencyInfoVO();
        currencyInfoRepository.findAll().forEach(c -> {
            BeanUtils.copyProperties(c, vo);
            vos.add(vo);
        });
        return vos;
    }

    public CurrencyInfoVO queryByName(String name) {
        CurrencyInfoVO vo = new CurrencyInfoVO();
        if (StringUtils.isEmpty(name)) {
            return null;
        }
        CurrencyInfo c = currencyInfoRepository.findByNameStartingWith(name);
        if (Objects.isNull(c)) {
            return null;
        }
        BeanUtils.copyProperties(c, vo);
        return vo;
    }

    public CurrencyInfo insertOrUpdate(CurrencyInfoDTO dto) {
        CurrencyInfo c = currencyInfoRepository.findById(dto.getId()).orElse(new CurrencyInfo());
        BeanCopyUtil.copyNonNullProperties(dto, c);
        return currencyInfoRepository.saveAndFlush(c);
    }

    public void delete(Long id) {
        CurrencyInfo c = currencyInfoRepository.findById(id).orElse(null);
        if (Objects.nonNull(c)) {
            currencyInfoRepository.delete(c);
        }
    }
}
