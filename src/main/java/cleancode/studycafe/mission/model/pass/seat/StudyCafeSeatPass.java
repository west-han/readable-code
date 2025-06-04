package cleancode.studycafe.mission.model.pass.seat;

import cleancode.studycafe.mission.model.pass.StudyCafePassType;
import cleancode.studycafe.mission.model.pass.locker.StudyCafeLockerPass;

public class StudyCafeSeatPass {

    private final StudyCafePassType passType;
    private final int duration;
    private final int price;
    private final double discountRate;

    private StudyCafeSeatPass(StudyCafePassType passType, int duration, int price, double discountRate) {
        this.passType = passType;
        this.duration = duration;
        this.price = price;
        this.discountRate = discountRate;
    }

    public static StudyCafeSeatPass of(StudyCafePassType passType, int duration, int price, double discountRate) {
        return new StudyCafeSeatPass(passType, duration, price, discountRate);
    }

    public boolean hasSameDurationTypeWith(StudyCafeLockerPass lockerPass) {
        return lockerPass.isSameDuration(duration) && lockerPass.hasSamePassType(passType);
    }

    public boolean isSamePassType(StudyCafePassType passType) {
        return this.passType == passType;
    }

    public boolean isDiscounted() {
        return this.discountRate > 0;
    }

    public int getDiscountPrice() {
        return (int) (price * discountRate);
    }

    public int getTotalPrice() {
        return price - getDiscountPrice();
    }

    @Override
    public String toString() {
        return String.format("%s%s권 - %d원", duration, passType.getUnit(), price);
    }
}
