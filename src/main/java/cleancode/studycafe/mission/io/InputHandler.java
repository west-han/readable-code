package cleancode.studycafe.mission.io;

import cleancode.studycafe.mission.model.StudyCafePass;
import cleancode.studycafe.mission.model.StudyCafePassType;

import java.util.List;

/**
 * @author : hansh
 * @package : cleancode.studycafe.mission.io
 * @name : InputHandler
 * @date : 2025-06-04
 * @Description :
 **/
public interface InputHandler {
    StudyCafePassType getPassTypeSelectingUserAction();
    StudyCafePass getSelectPass(List<StudyCafePass> passes);
    boolean getLockerSelection();
}
