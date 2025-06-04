package cleancode.studycafe.mission.model.pass.locker;

import cleancode.studycafe.mission.model.pass.seat.StudyCafeSeatPass;

import java.util.List;
import java.util.Optional;

public class StudyCafeLockerPasses {
    private final List<StudyCafeLockerPass> passes;

    private StudyCafeLockerPasses(List<StudyCafeLockerPass> passes) {
        this.passes = passes;
    }

    public static StudyCafeLockerPasses of(List<StudyCafeLockerPass> passes) {
        return new StudyCafeLockerPasses(passes);
    }

    public Optional<StudyCafeLockerPass> findLockerPassCandidate(StudyCafeSeatPass studyCafeSeatPass) {
        return passes.stream()
                .filter(studyCafeSeatPass::hasSameDurationTypeWith)
                .findFirst();
    }
}
