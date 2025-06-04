package cleancode.studycafe.mission.model.pass;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public enum StudyCafePassType {

    HOURLY("시간 단위 이용권", "1", "시간"),
    WEEKLY("주 단위 이용권", "2", "주"),
    FIXED("1인 고정석", "3", "주");

    private final String description;
    private final String value;
    private final String unit;

    private static final List<StudyCafePassType> LOCKER_TYPES = List.of(StudyCafePassType.FIXED);

    StudyCafePassType(String description, String value, String unit) {
        this.description = description;
        this.value = value;
        this.unit = unit;
    }

    public boolean isLockerType() {
        return LOCKER_TYPES.contains(this);
    }

    public boolean isNotLockerType() {
        return !isLockerType();
    }

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
