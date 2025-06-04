package cleancode.studycafe.mission.io;

import cleancode.studycafe.mission.exception.AppException;
import cleancode.studycafe.mission.model.pass.StudyCafePassType;
import cleancode.studycafe.mission.model.pass.seat.StudyCafeSeatPass;

import java.util.List;
import java.util.Scanner;

public class ConsoleInputHandler implements InputHandler {

    private static final Scanner SCANNER = new Scanner(System.in);

    public StudyCafePassType getPassTypeSelectingUserAction() {
        String userInput = SCANNER.nextLine();

        return StudyCafePassType
                .findBy(userInput)
                .orElseThrow(() -> new AppException("잘못된 입력입니다."));
    }

    public StudyCafeSeatPass getSelectPass(List<StudyCafeSeatPass> passes) {
        String userInput = SCANNER.nextLine();
        try {
            int selectedIndex = Integer.parseInt(userInput) - 1;
            return passes.get(selectedIndex);
        } catch (NumberFormatException e) {
            throw new AppException("잘못된 입력입니다.");
        }
    }

    public boolean getLockerSelection() {
        String userInput = SCANNER.nextLine();
        return "1".equals(userInput);
    }

}
