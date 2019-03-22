package game.model;

import game.service.ComputerService;
import game.BoardState;
import game.service.HumanService;

public class Game {

    private ComputerService computerService;
    private HumanService humanService;
    private BoardState boardState;

    public Game(ComputerService computerService, HumanService humanService, BoardState boardState) {
        this.computerService = computerService;
        this.humanService = humanService;
        this.boardState = boardState;
    }

    public ComputerService getComputerService() {
        return computerService;
    }

    public HumanService getHumanService() {
        return humanService;
    }

    public BoardState getBoardState() {
        return boardState;
    }


}
