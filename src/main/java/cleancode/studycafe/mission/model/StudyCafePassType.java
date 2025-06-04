package cleancode.studycafe.mission.model;

import java.util.Arrays;
import java.util.Optional;

public enum StudyCafePassType {

    HOURLY("시간 단위 이용권", "1", "시간"),
    WEEKLY("주 단위 이용권", "2", "주"),
    FIXED("1인 고정석", "3", "주");

    private final String description;
    private final String value;
    private final String unit;

    StudyCafePassType(String description, String value, String unit) {
        this.description = description;
        this.value = value;
        this.unit = unit;
    }

    public boolean canUseLocker() {
        return this == StudyCafePassType.FIXED;
    }

    // 입력값을 Enum 내에서 찾도록 하는 이 방식이 ConsoleInputHandler 와의 결합도를 너무 높이는 건 아닐까?
    public static Optional<StudyCafePassType> findBy(String value) {
        return Arrays.stream(values())
                .filter(passType -> passType.isEqualValue(value))
                .findFirst();
    }

    private boolean isEqualValue(String value) {
        return this.value.equals(value);
    }

    public String getUnit() {
        return unit;
    }
}
