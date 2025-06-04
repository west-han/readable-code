package cleancode.studycafe.mission.io;

import cleancode.studycafe.mission.model.StudyCafeLockerPass;
import cleancode.studycafe.mission.model.StudyCafePass;

import java.util.List;

/**
 * @author : hansh
 * @package : cleancode.studycafe.mission.io
 * @name : OutputHandler
 * @date : 2025-06-04
 * @Description :
 **/
public interface OutputHandler {
    void showWelcomeMessage();
    void showAnnouncement();
    void askPassTypeSelection();
    void showPassListForSelection(List<StudyCafePass> passes);
    void askLockerPass(StudyCafeLockerPass lockerPass);
    void showPassOrderSummary(StudyCafePass selectedPass, StudyCafeLockerPass lockerPass);
    void showSimpleMessage(String message);
}
