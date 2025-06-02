package cleancode.minesweeper.tobe.io;

import cleancode.minesweeper.tobe.GameBoard;

public interface OutputHandler {

    void showGameStartMessage();

    void showBoard(GameBoard board);

    void showGameWinningComment();

    void showGameLoosingComment();

    void showCommentForSelectingCell();

    void showCommentForUserAction();

    void showExceptionMessage(Exception e);

    void showSimpleMessage(String message);

}
