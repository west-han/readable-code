package cleancode.studycafe.mission.config;

import cleancode.studycafe.mission.io.InputHandler;
import cleancode.studycafe.mission.io.OutputHandler;
import cleancode.studycafe.mission.io.StudyCafeRepository;

/**
 * @author : hansh
 * @package : cleancode.studycafe.mission.config
 * @name : StudyCafeAppConfig
 * @date : 2025-06-04
 * @Description :
 **/

public class StudyCafeAppConfig {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final StudyCafeRepository studyCafeRepository;

    public StudyCafeAppConfig(InputHandler inputHandler, OutputHandler outputHandler, StudyCafeRepository studyCafeRepository) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.studyCafeRepository = studyCafeRepository;
    }

    public InputHandler getInputHandler() {
        return inputHandler;
    }

    public OutputHandler getOutputHandler() {
        return outputHandler;
    }

    public StudyCafeRepository getStudyCafeRepository() {
        return studyCafeRepository;
    }
}
