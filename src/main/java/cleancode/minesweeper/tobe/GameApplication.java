package cleancode.minesweeper.tobe;

import cleancode.minesweeper.tobe.config.GameConfig;
import cleancode.minesweeper.tobe.gamelevel.Beginner;
import cleancode.minesweeper.tobe.gamelevel.GameLevel;
import cleancode.minesweeper.tobe.io.ConsoleInputHandler;
import cleancode.minesweeper.tobe.io.ConsoleOutputHandler;
import cleancode.minesweeper.tobe.io.InputHandler;
import cleancode.minesweeper.tobe.io.OutputHandler;

public class GameApplication {

    public static void main(String[] args) {
        GameLevel gameLevel = new Beginner();
        InputHandler inputHandler = new ConsoleInputHandler();
        OutputHandler outputHandler = new ConsoleOutputHandler();

        GameConfig gameConfig = new GameConfig(
                new Beginner(),
                new ConsoleInputHandler(),
                new ConsoleOutputHandler());

        MineSweeper minesweeper = new MineSweeper(gameConfig);
        minesweeper.initialize();
        minesweeper.run();
    }
}
