package cleancode.studycafe.mission;

import cleancode.studycafe.mission.config.StudyCafeAppConfig;
import cleancode.studycafe.mission.exception.AppException;
import cleancode.studycafe.mission.io.InputHandler;
import cleancode.studycafe.mission.io.OutputHandler;
import cleancode.studycafe.mission.io.StudyCafeRepository;
import cleancode.studycafe.mission.model.StudyCafeLockerPass;
import cleancode.studycafe.mission.model.StudyCafePass;
import cleancode.studycafe.mission.model.StudyCafePassType;

import java.util.List;

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

            StudyCafePass selectedPass = selectPass();

            StudyCafeLockerPass lockerPass = selectLockerPass(selectedPass);

            if (selectedPass.canUseLocker() && doesUserSelectLocker(lockerPass)) {
                outputHandler.showPassOrderSummary(selectedPass, lockerPass);
            } else {
                outputHandler.showPassOrderSummary(selectedPass, null);
            }

        } catch (AppException e) {
            outputHandler.showSimpleMessage(e.getMessage());
        } catch (Exception e) {
            outputHandler.showSimpleMessage("알 수 없는 오류가 발생했습니다.");
        }
    }

    private boolean doesUserSelectLocker(StudyCafeLockerPass lockerPass) {
        outputHandler.askLockerPass(lockerPass);
        return inputHandler.getLockerSelection();
    }

    private StudyCafeLockerPass selectLockerPass(StudyCafePass studyCafePass) {
        List<StudyCafeLockerPass> lockerPasses = studyCafeRepository.readLockerPasses();
        return lockerPasses.stream()
            .filter(studyCafePass::hasSameDurationTypeWith)
            .findFirst()
            .orElse(null);
    }

    private StudyCafePass selectPass() {
        outputHandler.askPassTypeSelection();
        StudyCafePassType studyCafePassType = inputHandler.getPassTypeSelectingUserAction();

        List<StudyCafePass> passes = listPassCandidates(studyCafePassType);
        outputHandler.showPassListForSelection(passes);
        return inputHandler.getSelectPass(passes);
    }

    private List<StudyCafePass> listPassCandidates(StudyCafePassType passType) {
        List<StudyCafePass> studyCafePasses = studyCafeRepository.readStudyCafePasses();

        return studyCafePasses.stream()
            .filter(studyCafePass -> studyCafePass.isSamePassType(passType))
            .toList();
    }

}
