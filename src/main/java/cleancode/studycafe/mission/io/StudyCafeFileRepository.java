package cleancode.studycafe.mission.io;

import cleancode.studycafe.mission.model.pass.*;
import cleancode.studycafe.mission.model.pass.locker.StudyCafeLockerPass;
import cleancode.studycafe.mission.model.pass.locker.StudyCafeLockerPasses;
import cleancode.studycafe.mission.model.pass.seat.StudyCafeSeatPass;
import cleancode.studycafe.mission.model.pass.seat.StudyCafeSeatPasses;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StudyCafeFileRepository implements StudyCafeRepository {

    private static final String STUDYCAFE_SEAT_PASS_LIST = "src/main/resources/cleancode/studycafe/pass-list.csv";
    private static final String STUDYCAFE_LOCKER_PASS_LIST = "src/main/resources/cleancode/studycafe/locker.csv";

    @Override
    public StudyCafeSeatPasses readStudyCafePasses() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(STUDYCAFE_SEAT_PASS_LIST));
            return StudyCafeSeatPasses.of(generateStudyCafePassList(lines));
        } catch (IOException e) {
            throw new RuntimeException("파일을 읽는데 실패했습니다.", e);
        }
    }

    public StudyCafeLockerPasses readLockerPasses() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(STUDYCAFE_LOCKER_PASS_LIST));
            return StudyCafeLockerPasses.of(generateLockerPassList(lines));
        } catch (IOException e) {
            throw new RuntimeException("파일을 읽는데 실패했습니다.", e);
        }
    }

    private List<StudyCafeSeatPass> generateStudyCafePassList(List<String> lines) {
        List<StudyCafeSeatPass> studyCafeSeatPasses = new ArrayList<>();
        for (String line : lines) {
            StudyCafeSeatPass studyCafeSeatPass = parseStringToStudyCafePass(line);
            studyCafeSeatPasses.add(studyCafeSeatPass);
        }
        return studyCafeSeatPasses;
    }

    private StudyCafeSeatPass parseStringToStudyCafePass(String line) {
        String[] values = line.split(",");
        StudyCafePassType studyCafePassType = StudyCafePassType.valueOf(values[0]);
        int duration = Integer.parseInt(values[1]);
        int price = Integer.parseInt(values[2]);
        double discountRate = Double.parseDouble(values[3]);

        return StudyCafeSeatPass.of(studyCafePassType, duration, price, discountRate);
    }

    private List<StudyCafeLockerPass> generateLockerPassList(List<String> lines) {
        List<StudyCafeLockerPass> lockerPasses = new ArrayList<>();
        for (String line : lines) {
            StudyCafeLockerPass lockerPass = parseStringToStudyCafeLockerPass(line);
            lockerPasses.add(lockerPass);
        }
        return lockerPasses;
    }

    private StudyCafeLockerPass parseStringToStudyCafeLockerPass(String line) {
        String[] values = line.split(",");
        StudyCafePassType studyCafePassType = StudyCafePassType.valueOf(values[0]);
        int duration = Integer.parseInt(values[1]);
        int price = Integer.parseInt(values[2]);

        return StudyCafeLockerPass.of(studyCafePassType, duration, price);
    }

}
