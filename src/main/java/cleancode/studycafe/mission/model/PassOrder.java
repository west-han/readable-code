package cleancode.studycafe.mission.model;

import cleancode.studycafe.mission.model.pass.locker.StudyCafeLockerPass;
import cleancode.studycafe.mission.model.pass.seat.StudyCafeSeatPass;

public class PassOrder {

    private final StudyCafeSeatPass studyCafeSeatPass;
    private final StudyCafeLockerPass studyCafeLockerPass;

    private PassOrder(StudyCafeSeatPass studyCafeSeatPass, StudyCafeLockerPass studyCafeLockerPass) {
        this.studyCafeSeatPass = studyCafeSeatPass;
        this.studyCafeLockerPass = studyCafeLockerPass;
    }

    public static PassOrder of(StudyCafeSeatPass studyCafeSeatPass, StudyCafeLockerPass studyCafeLockerPass) {
        return new PassOrder(studyCafeSeatPass, studyCafeLockerPass);
    }

    public boolean hasLockerPass() {
        return studyCafeLockerPass != null;
    }

    public boolean isDiscounted() {
        return studyCafeSeatPass.isDiscounted();
    }

    public int getDiscountPrice() {
        return studyCafeSeatPass.getDiscountPrice();
    }

    public int getTotalPrice() {
        int totalPrice = studyCafeSeatPass.getTotalPrice();
        if (hasLockerPass()) {
            totalPrice += studyCafeLockerPass.getPrice();
        }

        return totalPrice;
    }

    public String getPassInfo() {
        return studyCafeSeatPass.toString();
    }

    public String getLockerPassInfo() {
        return studyCafeLockerPass.toString();
    }
}
