package Exercise2.Problem1.factory;

import Exercise2.Problem1.model.Task;
import java.time.LocalTime;

public class TaskFactory {
    public Task createTask(String description, String start, String end, String priority) throws Exception {
        try {
            LocalTime startTime = LocalTime.parse(start);
            LocalTime endTime = LocalTime.parse(end);
            if (endTime.isBefore(startTime)) {
                throw new Exception("End time must be after start time");
            }
            return new Task(description, startTime, endTime, priority);
        } catch (Exception e) {
            throw new Exception("Invalid time format. Use HH:mm (e.g. 09:00)");
        }
    }
}
