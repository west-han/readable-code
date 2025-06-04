package cleancode.studycafe.mission.io;

import cleancode.studycafe.mission.model.pass.seat.StudyCafeSeatPass;
import cleancode.studycafe.mission.model.pass.StudyCafePassType;

import java.util.List;

public interface InputHandler {
    StudyCafePassType getPassTypeSelectingUserAction();
    StudyCafeSeatPass getSelectPass(List<StudyCafeSeatPass> passes);
    boolean getLockerSelection();
}
