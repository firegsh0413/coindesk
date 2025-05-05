package will.demo.coindesk.util;

import org.springframework.beans.BeanUtils;

import java.beans.PropertyDescriptor;
import java.util.Arrays;
import java.util.Objects;

/**
 * <p>
 * BeanUtils擴充
 * </p>
 * @author firegsh
 * @since 2025-05-05 16:05:39
 **/
public class BeanCopyUtil {

    public static void copyNonNullProperties(Object source, Object target) {
        BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
    }

    private static String[] getNullPropertyNames(Object source) {
        final PropertyDescriptor[] pds = BeanUtils.getPropertyDescriptors(source.getClass());

        return Arrays.stream(pds)
                .map(PropertyDescriptor::getName)
                .filter(name -> {
                    try {
                        Object value = Objects.requireNonNull(BeanUtils.getPropertyDescriptor(source.getClass(), name))
                                .getReadMethod()
                                .invoke(source);
                        return Objects.isNull(value);
                    } catch (Exception e) {
                        return false;
                    }
                })
                .toArray(String[]::new);
    }
}
