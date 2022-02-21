package brokenrobotgame.model.events;

import java.util.EventListener;

// Интерфейс
public interface RobotActionListener extends EventListener {
    void robotMadeMove(RobotActionEvent e);
	void destroyedAllHumans(RobotActionEvent e);
}
