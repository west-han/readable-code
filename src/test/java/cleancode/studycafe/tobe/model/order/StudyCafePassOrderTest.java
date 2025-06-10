package cleancode.studycafe.tobe.model.order;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import cleancode.studycafe.tobe.model.pass.StudyCafeSeatPass;
import cleancode.studycafe.tobe.model.pass.locker.StudyCafeLockerPass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StudyCafePassOrderTest {

    @DisplayName("주문 정보를 이용해 이용권 할인액을 계산할 수 있다.")
    @Test
    void test() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 12, 120000, 0.15);
        StudyCafePassOrder order = StudyCafePassOrder.of(seatPass, null);

        // when
        int discountPrice = order.getDiscountPrice();

        // then
        assertThat(discountPrice).isEqualTo(18000);
    }

    @DisplayName("할인 대상 이용권의 결제 총액을 계산하면 할인이 적용된 총액이 계산된다.")
    @Test
    void test1() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 12, 120000, 0.15);
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 12, 40000);
        StudyCafePassOrder order = StudyCafePassOrder.of(seatPass, lockerPass);

        // when
        int totalPrice = order.getTotalPrice();

        // then
        assertThat(totalPrice).isEqualTo(142000);
    }
}
