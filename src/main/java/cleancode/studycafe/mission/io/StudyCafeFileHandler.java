package cleancode.studycafe.mission.io;

import cleancode.studycafe.mission.model.StudyCafeLockerPass;
import cleancode.studycafe.mission.model.StudyCafePass;
import cleancode.studycafe.mission.model.StudyCafePassType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StudyCafeFileHandler {

    public List<StudyCafePass> readStudyCafePasses() {
        try {
            List<String> lines = Files.readAllLines(Paths.get("src/main/resources/cleancode/studycafe/pass-list.csv"));
            return generateStudyCafePassList(lines);
        } catch (IOException e) {
            throw new RuntimeException("파일을 읽는데 실패했습니다.", e);
        }
    }

    public List<StudyCafeLockerPass> readLockerPasses() {
        try {
            List<String> lines = Files.readAllLines(Paths.get("src/main/resources/cleancode/studycafe/locker.csv"));
            return generateLockerPassList(lines);
        } catch (IOException e) {
            throw new RuntimeException("파일을 읽는데 실패했습니다.", e);
        }
    }

    private List<StudyCafePass> generateStudyCafePassList(List<String> lines) {
        List<StudyCafePass> studyCafePasses = new ArrayList<>();
        for (String line : lines) {
            StudyCafePass studyCafePass = parsetStringToStudyCafePass(line);
            studyCafePasses.add(studyCafePass);
        }
        return studyCafePasses;
    }

    private StudyCafePass parsetStringToStudyCafePass(String line) {
        String[] values = line.split(",");
        StudyCafePassType studyCafePassType = StudyCafePassType.valueOf(values[0]);
        int duration = Integer.parseInt(values[1]);
        int price = Integer.parseInt(values[2]);
        double discountRate = Double.parseDouble(values[3]);

        return StudyCafePass.of(studyCafePassType, duration, price, discountRate);
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
