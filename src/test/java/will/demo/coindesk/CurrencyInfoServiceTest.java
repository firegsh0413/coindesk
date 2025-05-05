package will.demo.coindesk;

import lombok.RequiredArgsConstructor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import will.demo.coindesk.entity.dto.CurrencyInfoDTO;
import will.demo.coindesk.entity.model.CurrencyInfo;
import will.demo.coindesk.entity.vo.CurrencyInfoVO;
import will.demo.coindesk.service.CurrencyInfoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CurrencyInfoServiceTest {

    @Autowired
    private CurrencyInfoService currencyInfoService;

    @Test
    public void crud() throws Exception {
        // Step 1: 建立初始資料
        CurrencyInfoDTO initialDto = new CurrencyInfoDTO();
        initialDto.setId(0L);
        initialDto.setCode("USD");
        initialDto.setName("美元");
        CurrencyInfo c = currencyInfoService.insertOrUpdate(initialDto); // 回傳含 id 的 VO
        Assert.assertNotNull(c);

        // Step 2: 更新該資料
        CurrencyInfoDTO updateDto = new CurrencyInfoDTO();
        updateDto.setId(c.getId()); // 使用實際回傳的 ID
        updateDto.setCode("USD");
        updateDto.setName("美金"); // 更新名稱
        currencyInfoService.insertOrUpdate(updateDto);

        // Step 3: 查詢驗證更新結果
        CurrencyInfoVO updatedVO = currencyInfoService.query(c.getId());
        Assert.assertEquals("USD", updatedVO.getCode());
        Assert.assertEquals("美金", updatedVO.getName());

        currencyInfoService.delete(1L);
        Assert.assertNull(currencyInfoService.query(1L));
    }
}
