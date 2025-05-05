package will.demo.coindesk;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BitcoinControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testImportData() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/bitcoin/import"))
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        log.info("原始資料：\n" + content);
        Assert.assertTrue(content.contains("bpi")); // 根據 JSON 結構進行基本斷言
    }

    @Test
    public void testImportAndTransfer() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/bitcoin/import/transfer"))
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        log.info("轉換後資料：\n" + content);
        Assert.assertTrue(content.contains("name")); // 轉換後格式應該有中文名稱
        Assert.assertTrue(content.contains("updated")); // 確保時間欄位存在
    }
}
