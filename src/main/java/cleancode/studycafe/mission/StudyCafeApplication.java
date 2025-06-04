package cleancode.studycafe.mission;

import cleancode.studycafe.mission.config.StudyCafeAppConfig;
import cleancode.studycafe.mission.io.ConsoleInputHandler;
import cleancode.studycafe.mission.io.ConsoleOutputHandler;
import cleancode.studycafe.mission.io.StudyCafeFileRepository;

public class StudyCafeApplication {

    public static void main(String[] args) {

        StudyCafeAppConfig appConfig = new StudyCafeAppConfig(
                new ConsoleInputHandler(),
                new ConsoleOutputHandler(),
                new StudyCafeFileRepository()
        );

        StudyCafePassMachine studyCafePassMachine = new StudyCafePassMachine(appConfig);
        studyCafePassMachine.run();
    }

}
