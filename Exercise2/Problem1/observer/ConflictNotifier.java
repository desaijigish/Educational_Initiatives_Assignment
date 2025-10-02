package Exercise2.Problem1.observer;

import Exercise2.Problem1.model.Task;
import Exercise2.Problem1.util.Logger;

public class ConflictNotifier implements Observer {
    @Override
    public void update(String message, Task task) {
        Logger.log("NOTIFICATION: " + message + " - " + task);
    }
}
