package cleancode.studycafe.mission.model.pass.locker;

import cleancode.studycafe.mission.model.pass.StudyCafePassType;

public class StudyCafeLockerPass {

    private final StudyCafePassType passType;
    private final int duration;
    private final int price;

    private StudyCafeLockerPass(StudyCafePassType passType, int duration, int price) {
        this.passType = passType;
        this.duration = duration;
        this.price = price;
    }

    public static StudyCafeLockerPass of(StudyCafePassType passType, int duration, int price) {
        return new StudyCafeLockerPass(passType, duration, price);
    }

    public StudyCafePassType getPassType() {
        return passType;
    }

    public boolean isSameDuration(int duration) {
        return this.duration == duration;
    }

    public boolean hasSamePassType(StudyCafePassType passType) {
        return this.passType == passType;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s%s권 - %d원", duration, passType.getUnit(), price);
    }

}
