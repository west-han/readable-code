package cleancode.studycafe.tobe.model.pass;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StudyCafePassTypeTest {

    @DisplayName("고정석 이용권은 사물함 이용이 가능하다.")
    @Test
    void isLockerTypeTest() {
        // given
        StudyCafePassType fixedPass = StudyCafePassType.FIXED;

        // when
        boolean isFixedPassLockerType = fixedPass.isLockerType();

        // then
        assertThat(isFixedPassLockerType).isTrue();
    }

    @DisplayName("시간 및 주단위 이용괸은 사물함 이용이 불가능하다.")
    @Test
    void test() {
        // given
        StudyCafePassType hourlyPass = StudyCafePassType.HOURLY;
        StudyCafePassType weeklyPass = StudyCafePassType.WEEKLY;

        // when
        boolean isHourlyPassLockerType = hourlyPass.isNotLockerType();
        boolean isWeeklyPassLockerType = weeklyPass.isNotLockerType();

        // then
        assertThat(isHourlyPassLockerType).isTrue();
        assertThat(isWeeklyPassLockerType).isTrue();
    }
}
