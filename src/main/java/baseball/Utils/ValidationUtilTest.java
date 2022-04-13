package baseball.Utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationUtilTest {
    @Test
    @DisplayName("baseballNumberVerification")
    public void baseballNumberVerification() {
        assertThat(ValidationUtil.checkNumber(0)).isFalse();
        assertThat(ValidationUtil.checkNumber(1)).isTrue();
        assertThat(ValidationUtil.checkNumber(5)).isTrue();
        assertThat(ValidationUtil.checkNumber(9)).isTrue();
        assertThat(ValidationUtil.checkNumber(10)).isFalse();
    }
}
