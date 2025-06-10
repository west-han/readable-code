package cleancode.studycafe.tobe.model.pass;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StudyCafeSeatPassTest {

    @DisplayName("이용권의 할인액을 계산할 수 있다.")
    @Test
    void calculateDiscountPriceTest() {
        // given
        StudyCafeSeatPass pass = StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 12, 120000, 0.1);

        // when
        int discountPrice = pass.getDiscountPrice();

        // then
        assertThat(discountPrice).isEqualTo(12000);
    }

    @DisplayName("고정석 이용권의 경우 사물함 이용권을 구매할 수 있다.")
    @Test
    void fixedPassCanUseLockerTest() {
        // given
        StudyCafeSeatPass fixedPass = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 12, 120000, 0.1);

        // when
        boolean cannotUseLocker = fixedPass.cannotUseLocker();

        // then
        assertThat(cannotUseLocker).isFalse();

    }

    @DisplayName("시간 및 주단위 이용권의 경우 사물함 이용권을 구매할 수 없다.")
    @Test
    void timePassCannotUseLockerTest() {
        // given
        StudyCafeSeatPass weeklyPass = StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 12, 120000, 0.1);
        StudyCafeSeatPass hourlyPass = StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 12, 120000, 0.1);

        // when
        boolean weeklyPassCannotUseLocker = weeklyPass.cannotUseLocker();
        boolean hourlyPassCannotUseLocker = hourlyPass.cannotUseLocker();

        // then
        assertThat(weeklyPassCannotUseLocker).isTrue();
        assertThat(hourlyPassCannotUseLocker).isTrue();

    }
}
