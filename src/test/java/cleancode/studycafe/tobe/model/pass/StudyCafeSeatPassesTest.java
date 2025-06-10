package cleancode.studycafe.tobe.model.pass;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StudyCafeSeatPassesTest {

    @DisplayName("동일한 종류의 이용권을 필터링할 수 있다.")
    @Test
    void test() {
        // given
        List<StudyCafeSeatPass> allPasses = List.of(
                StudyCafeSeatPass.of(StudyCafePassType.FIXED, 4, 40000, 0),
                StudyCafeSeatPass.of(StudyCafePassType.FIXED, 8, 80000, 0.1),
                StudyCafeSeatPass.of(StudyCafePassType.FIXED, 12, 120000, 0.15),
                StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 4, 4000, 0),
                StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 8, 8000, 0),
                StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 4, 35000, 0),
                StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 8, 7000, 0.1)
        );
        StudyCafeSeatPasses passes = StudyCafeSeatPasses.of(allPasses);

        // when
        List<StudyCafeSeatPass> hourlyPasses = passes.findPassBy(StudyCafePassType.HOURLY);

        // then
        assertThat(hourlyPasses)
                .map(StudyCafeSeatPass::getPassType)
                .allMatch(passType -> passType == StudyCafePassType.HOURLY);
    }
}
