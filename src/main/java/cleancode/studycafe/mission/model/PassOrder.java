package cleancode.studycafe.mission.model;

import cleancode.studycafe.mission.model.pass.locker.StudyCafeLockerPass;
import cleancode.studycafe.mission.model.pass.seat.StudyCafeSeatPass;

public class PassOrder {
    // TODO: studyCafeLockerPass가 Nullable이라는 점을 더 명확히 표현할 수 있도록 방안 고려
    //       지금처럼 새로운 메소드 추가 시마다 null 체크(hasLockerPass)가 필요하다면, 해당 로직을 구현하지 않을 경우 NPE 발생 가능성 높음
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
