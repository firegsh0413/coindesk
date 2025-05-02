package will.demo.coindesk.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import will.demo.coindesk.entity.dto.TestDTO;
import will.demo.coindesk.entity.BitcoinPriceInfo;
import will.demo.coindesk.entity.BpiCurrency;
import will.demo.coindesk.repository.BitcoinPriceInfoRepository;
import will.demo.coindesk.repository.BpiCurrencyRepository;
import will.demo.coindesk.repository.TimeInfoRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BitCoinService {

    private final TimeInfoRepository timeInfoRepository;
    private final BitcoinPriceInfoRepository bitcoinPriceInfoRepository;
    private final BpiCurrencyRepository bpiCurrencyRepository;

    @Transactional
    public void importData(TestDTO dto) {
        // 儲存主表
        BitcoinPriceInfo info = new BitcoinPriceInfo();
        info.setChartName(dto.getChartName());
        info.setDisclaimer(dto.getDisclaimer());

        List<BpiCurrency> currencyList = new ArrayList<>(dto.getBpi().values());

        bitcoinPriceInfoRepository.save(info);
        timeInfoRepository.save(dto.getTime());
        bpiCurrencyRepository.saveAll(currencyList);
    }
}
