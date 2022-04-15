package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import enums.RoleStatus;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void strike() {
        Game game = new Game(Arrays.asList(1, 2, 3));
        RoleStatus status = game.play(new Role(1, 1));
        assertThat(status).isEqualTo(RoleStatus.STRIKE);
    }

    @Test
    public void ball() {
        Game game = new Game(Arrays.asList(1, 2, 3));
        RoleStatus status = game.play(new Role(1, 2));
        assertThat(status).isEqualTo(RoleStatus.BALL);
    }

    @Test
    public void nothing() {
        Game game = new Game(Arrays.asList(1, 2, 3));
        RoleStatus status = game.play(new Role(1, 4));
        assertThat(status).isEqualTo(RoleStatus.NOTHING);
    }
}
