package cleancode.studycafe.mission.io;

import cleancode.studycafe.mission.model.pass.locker.StudyCafeLockerPasses;
import cleancode.studycafe.mission.model.pass.seat.StudyCafeSeatPasses;

public interface StudyCafeRepository {

    StudyCafeSeatPasses readStudyCafePasses();

    StudyCafeLockerPasses readLockerPasses();

}
