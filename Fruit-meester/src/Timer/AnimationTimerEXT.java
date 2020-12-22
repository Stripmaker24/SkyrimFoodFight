package Timer;
import javafx.animation.AnimationTimer;

public abstract class AnimationTimerEXT extends AnimationTimer {
	private long sleepNs = 0;
	private long sleepMs;
	long prevTime = 0;

	public AnimationTimerEXT(long sleepMs) {
		this.sleepMs = sleepMs;
		this.sleepNs = this.sleepMs * 1_000_000;
	}

	@Override
	public void handle(long now) {
		// some delay
		if ((now - prevTime) < sleepNs) {
			return;
		}
		prevTime = now;
		doAction();
	}

	public abstract void doAction();
}