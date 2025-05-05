package will.demo.coindesk.entity.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.StringUtils;
import will.demo.coindesk.entity.model.TimeInfo;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@EqualsAndHashCode(callSuper = true)
@Data
public class TimeInfoVO extends TimeInfo {

    @Override
    public String getUpdated() {
        String original = super.getUpdated();
        if (StringUtils.isEmpty(original)) {
            return null;
        }
        try {
            // 解析原始字串，例如 "Sep 2, 2024 07:07:20 UTC"
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMM d, yyyy HH:mm:ss z", Locale.US);
            ZonedDateTime zonedDateTime = ZonedDateTime.parse(original, inputFormatter);

            // 格式化為 "1990/01/01 00:00:00" 這種格式
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            return outputFormatter.format(zonedDateTime);
        } catch (Exception e) {
            // 若解析失敗，回傳原始字串或處理錯誤
            return original;
        }
    }
}
