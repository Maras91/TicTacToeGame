package game.service;

import game.model.Field;
import game.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    private Game game;

    @Autowired
    public GameService(Game game) {
        this.game = game;
    }

    public void addPlayerMove(int move) {
        Field fieldToAdd = game.getHumanService().makeMove(move);
        game.getBoardState().addMove(fieldToAdd, game.getHumanService().getMYMARK());
        game.getBoardState().checkWinCondition(game.getHumanService().getMYMARK());
    }
    public void addComputerMove () {
        Field fieldToAdd = game.getComputerService().makeMove(game.getBoardState());
        Field noField=new Field(-1,-1);
        if (!(fieldToAdd.equals(noField))) {
            game.getBoardState().addMove(fieldToAdd, game.getComputerService().getMYMARK());
            game.getBoardState().checkWinCondition(game.getComputerService().getMYMARK());
        }
    }
    public Game getGame() {
        return game;
    }
}
