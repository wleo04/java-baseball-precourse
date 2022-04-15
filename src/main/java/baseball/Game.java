package baseball;

import enums.RoleStatus;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Role> comRoles;

    public Game(List<Integer> comRoles) {
        this.comRoles = mapRole(comRoles);
    }

    private static List<Role> mapRole(List<Integer> answers) {
        List<Role> roles = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            roles.add(new Role(i + 1, answers.get(i)));
        }
        return roles;
    }

    public GameResult play(List<Integer> userGames) {
        Game userGame = new Game(userGames);
        GameResult result = new GameResult();
        for(Role role : comRoles) {
            RoleStatus status = userGame.play(role);
            result.write(status);
        }
        return result;
    }

    public RoleStatus play(Role userAnswer) {
        return comRoles.stream()
                .map(com -> com.play(userAnswer))
                .filter(RoleStatus::isNotNothing)
                .findFirst()
                .orElse(RoleStatus.NOTHING);
    }
}
