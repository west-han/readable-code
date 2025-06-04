package cleancode.studycafe.mission;

import cleancode.studycafe.mission.config.StudyCafeAppConfig;
import cleancode.studycafe.mission.exception.AppException;
import cleancode.studycafe.mission.io.InputHandler;
import cleancode.studycafe.mission.io.OutputHandler;
import cleancode.studycafe.mission.io.StudyCafeRepository;
import cleancode.studycafe.mission.model.PassOrder;
import cleancode.studycafe.mission.model.pass.*;
import cleancode.studycafe.mission.model.pass.locker.StudyCafeLockerPass;
import cleancode.studycafe.mission.model.pass.locker.StudyCafeLockerPasses;
import cleancode.studycafe.mission.model.pass.seat.StudyCafeSeatPass;
import cleancode.studycafe.mission.model.pass.seat.StudyCafeSeatPasses;

import java.util.List;
import java.util.Optional;

public class StudyCafePassMachine {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final StudyCafeRepository studyCafeRepository;

    public StudyCafePassMachine(StudyCafeAppConfig config) {
        this.inputHandler = config.getInputHandler();
        this.outputHandler = config.getOutputHandler();
        this.studyCafeRepository = config.getStudyCafeRepository();
    }

    public void run() {
        try {
            outputHandler.showWelcomeMessage();
            outputHandler.showAnnouncement();

            StudyCafeSeatPass selectedPass = selectPass();
            StudyCafeLockerPass lockerPass = selectLockerPass(selectedPass).orElse(null);
            PassOrder order = PassOrder.of(selectedPass, lockerPass);
            outputHandler.showPassOrderSummary(order);

        } catch (AppException e) {
            outputHandler.showSimpleMessage(e.getMessage());
        } catch (Exception e) {
            outputHandler.showSimpleMessage("알 수 없는 오류가 발생했습니다.");
        }
    }

    private StudyCafeSeatPass selectPass() {
        outputHandler.askPassTypeSelection();
        StudyCafePassType studyCafePassType = inputHandler.getPassTypeSelectingUserAction();

        List<StudyCafeSeatPass> passes = listPassCandidate(studyCafePassType);
        outputHandler.showPassListForSelection(passes);
        return inputHandler.getSelectPass(passes);
    }

    private List<StudyCafeSeatPass> listPassCandidate(StudyCafePassType passType) {
        StudyCafeSeatPasses studyCafeSeatPasses = studyCafeRepository.readStudyCafePasses();
        return studyCafeSeatPasses.listCandidate(passType);
    }

    private Optional<StudyCafeLockerPass> selectLockerPass(StudyCafeSeatPass studyCafeSeatPass) {
        StudyCafeLockerPasses lockerPasses = studyCafeRepository.readLockerPasses();
        Optional<StudyCafeLockerPass> optionalLockerPass = lockerPasses.findLockerPassCandidate(studyCafeSeatPass);

        if (optionalLockerPass.isEmpty()) {
            return optionalLockerPass;
        }

        outputHandler.askLockerPass(optionalLockerPass.get());
        if (inputHandler.getLockerSelection()) {
            return optionalLockerPass;
        }

        return Optional.empty();
    }

}
