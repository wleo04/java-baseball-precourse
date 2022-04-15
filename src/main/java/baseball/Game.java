package baseball;

import enums.RoleStatus;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Role> roles;

    public Game(List<Integer> answers) {
        this.roles = mapRole(answers);
    }

    private static List<Role> mapRole(List<Integer> answers) {
        List<Role> roles = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            roles.add(new Role(i + 1, answers.get(i)));
        }
        return roles;
    }

    public RoleStatus play(Role userAnswer) {
        return roles.stream()
                .map(info -> info.play(userAnswer))
                .filter(RoleStatus::isNotNothing)
                .findFirst()
                .orElse(RoleStatus.NOTHING);
    }
}
