package cleancode.studycafe.mission.io;

import cleancode.studycafe.mission.model.StudyCafeLockerPass;
import cleancode.studycafe.mission.model.StudyCafePass;

import java.util.List;

public interface StudyCafeRepository {

    List<StudyCafePass> readStudyCafePasses();

    List<StudyCafeLockerPass> readLockerPasses();

}
