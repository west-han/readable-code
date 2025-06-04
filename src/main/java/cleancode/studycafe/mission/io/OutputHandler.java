package cleancode.studycafe.mission.io;

import cleancode.studycafe.mission.model.PassOrder;
import cleancode.studycafe.mission.model.pass.locker.StudyCafeLockerPass;
import cleancode.studycafe.mission.model.pass.seat.StudyCafeSeatPass;

import java.util.List;

public interface OutputHandler {
    void showWelcomeMessage();
    void showAnnouncement();
    void askPassTypeSelection();
    void showPassListForSelection(List<StudyCafeSeatPass> passes);
    void askLockerPass(StudyCafeLockerPass lockerPass);
    void showPassOrderSummary(PassOrder order);
    void showSimpleMessage(String message);
}
