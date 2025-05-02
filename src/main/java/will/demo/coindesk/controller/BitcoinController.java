package will.demo.coindesk.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import will.demo.coindesk.entity.dto.TestDTO;
import will.demo.coindesk.service.BitCoinService;

@RestController
@RequestMapping("/api/bitcoin")
@RequiredArgsConstructor
public class BitcoinController {

    private final BitCoinService bitCoinService;

    @PostMapping("/import")
    public ResponseEntity<String> importBitcoinData(@RequestBody TestDTO dto) {

        bitCoinService.importData(dto);

        return ResponseEntity.ok("Data imported successfully.");
    }
}
