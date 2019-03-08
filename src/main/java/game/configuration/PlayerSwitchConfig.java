package game.configuration;

import game.model.Player;
import game.service.PlayerSwitcher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlayerSwitchConfig {
    @Bean
    public PlayerSwitcher playerChanger() {
        return new PlayerSwitcher(Player.x);
    }
    @Bean
    public Player player() {
        return Player.x;
    }
}
