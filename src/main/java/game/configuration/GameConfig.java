package game.configuration;

import game.model.Game;
import game.BoardState;
import game.service.ComputerService;
import game.service.HumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfig {

    @Autowired
    private ComputerService computerService;
    @Autowired
    private HumanService humanService;
    @Autowired
    private BoardState boardState;

    @Bean
    Game game (ComputerService computerService, HumanService humanService, BoardState boardState) {
        return new Game(computerService,humanService, boardState);
    }
}
