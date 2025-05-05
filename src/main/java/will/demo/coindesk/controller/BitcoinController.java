package will.demo.coindesk.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import will.demo.coindesk.api.CoinDeskAPI;
import will.demo.coindesk.entity.dto.CurrencyInfoDTO;
import will.demo.coindesk.entity.dto.CoinDeskDTO;
import will.demo.coindesk.entity.vo.BitcoinPriceInfoVO;
import will.demo.coindesk.entity.vo.CurrencyInfoVO;
import will.demo.coindesk.service.BitCoinService;
import will.demo.coindesk.service.CurrencyInfoService;

import java.util.List;

@RestController
@RequestMapping("/api/bitcoin")
@RequiredArgsConstructor
public class BitcoinController {

    private final String SUCCESS = "SUCCESS";

    private final BitCoinService bitCoinService;

    private final CurrencyInfoService currencyInfoService;

    private final CoinDeskAPI coinDeskAPI;

    @GetMapping("/import")
    public ResponseEntity<CoinDeskDTO> importBitcoinData() {
        return ResponseEntity.ok(coinDeskAPI.importBitcoinData());
    }

    @GetMapping("/import/transfer")
    public ResponseEntity<BitcoinPriceInfoVO> importAndTransfer() {
        CoinDeskDTO dto = coinDeskAPI.importBitcoinData();
        return ResponseEntity.ok(bitCoinService.importData(dto));
    }

    @GetMapping("/currency/all")
    public ResponseEntity<List<CurrencyInfoVO>> getAllCurrencyInfo() {
        return ResponseEntity.ok(currencyInfoService.queryAll());
    }

    @GetMapping("/currency/{id}")
    public ResponseEntity<CurrencyInfoVO> getCurrencyInfo(@PathVariable Long id) {
        return ResponseEntity.ok(currencyInfoService.query(id));
    }

    /**
     * <p>
     * 模糊比對名稱字首
     * </p>
     *
     * @param name 幣別名稱
     * @author firegsh
     * @since 2025-05-05 16:05:23
     * @return org.springframework.http.ResponseEntity<will.demo.coindesk.entity.vo.CurrencyInfoVO>
     **/
    @GetMapping("/currency/get")
    public ResponseEntity<CurrencyInfoVO> getCurrencyByName(@RequestParam String name) {
        return ResponseEntity.ok(currencyInfoService.queryByName(name));
    }

    @PostMapping("/currency/create")
    public ResponseEntity<String> insertCurrency(@RequestBody CurrencyInfoDTO dto) {
        currencyInfoService.insertOrUpdate(dto);
        return ResponseEntity.ok(SUCCESS);
    }

    @PostMapping("/currency/update")
    public ResponseEntity<String> updateCurrency(@RequestBody CurrencyInfoDTO dto) {
        currencyInfoService.insertOrUpdate(dto);
        return ResponseEntity.ok(SUCCESS);
    }

    @DeleteMapping("/currency/delete")
    public ResponseEntity<String> deleteCurrency(@RequestParam Long id) {
        currencyInfoService.delete(id);
        return ResponseEntity.ok(SUCCESS);
    }
}
