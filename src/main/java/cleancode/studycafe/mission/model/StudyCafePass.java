package cleancode.studycafe.mission.model;

public class StudyCafePass {

    private final StudyCafePassType passType;
    private final int duration;
    private final int price;
    private final double discountRate;

    private StudyCafePass(StudyCafePassType passType, int duration, int price, double discountRate) {
        this.passType = passType;
        this.duration = duration;
        this.price = price;
        this.discountRate = discountRate;
    }

    public static StudyCafePass of(StudyCafePassType passType, int duration, int price, double discountRate) {
        return new StudyCafePass(passType, duration, price, discountRate);
    }

    public int getDiscountPrice() {
        return (int) (price * discountRate);
    }

    public int getTotalPrice() {
        return price - getDiscountPrice();
    }

    public String display() {
        return String.format("%s%s권 - %d원", duration, passType.getUnit(), price);
    }

    public boolean hasSameDurationTypeWith(StudyCafeLockerPass lockerPass) {
        return this.duration == lockerPass.getDuration() && this.passType == lockerPass.getPassType();
    }

    public boolean isSamePassType(StudyCafePassType passType) {
        return this.passType == passType;
    }

    public boolean canUseLocker() {
        return passType.canUseLocker();
    }

    public boolean isDiscounted() {
        return this.discountRate > 0;
    }
}
