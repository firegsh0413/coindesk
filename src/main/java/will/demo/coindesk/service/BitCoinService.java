package will.demo.coindesk.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import will.demo.coindesk.entity.dto.CoinDeskDTO;
import will.demo.coindesk.entity.model.BpiCurrency;
import will.demo.coindesk.entity.model.CurrencyInfo;
import will.demo.coindesk.entity.vo.BitcoinPriceInfoVO;
import will.demo.coindesk.entity.vo.BpiCurrencyVO;
import will.demo.coindesk.entity.vo.TimeInfoVO;
import will.demo.coindesk.repository.CurrencyInfoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BitCoinService {
    
    private final CurrencyInfoRepository currencyInfoRepository;

    public BitcoinPriceInfoVO importData(CoinDeskDTO dto) {
        BitcoinPriceInfoVO vo = new BitcoinPriceInfoVO();
        List<CurrencyInfo> currencyInfoList = currencyInfoRepository.findAll();
        Map<String, String> codeNameMap = currencyInfoList.stream()
                .collect(Collectors.toMap(CurrencyInfo::getCode, CurrencyInfo::getName));

        List<BpiCurrency> currencyList = new ArrayList<>(dto.getBpi().values());
        List<BpiCurrencyVO> currencyVOList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(currencyList)) {
            currencyList.forEach(currency -> {
                BpiCurrencyVO currencyVO = new BpiCurrencyVO();
                BeanUtils.copyProperties(currency, currencyVO);
                currencyVO.setName(codeNameMap.get(currency.getCode()));
                currencyVOList.add(currencyVO);
            });
        }
        TimeInfoVO timeInfoVO = new TimeInfoVO();
        BeanUtils.copyProperties(dto.getTime(), timeInfoVO);
        BeanUtils.copyProperties(dto, vo);
        vo.setTimeInfo(timeInfoVO);
        vo.setCurrencies(currencyVOList);
        return vo;
    }
}
