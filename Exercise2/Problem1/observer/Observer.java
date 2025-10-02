package Exercise2.Problem1.observer;

import Exercise2.Problem1.model.Task;

public interface Observer {
    void update(String message, Task task);
}
