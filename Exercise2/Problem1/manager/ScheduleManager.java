package Exercise2.Problem1.manager;

import Exercise2.Problem1.model.Task;
import Exercise2.Problem1.observer.Observer;
import Exercise2.Problem1.util.Logger;

import java.util.*;

public class ScheduleManager {
    private static ScheduleManager instance;
    private List<Task> tasks = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    private ScheduleManager(){}

    public static ScheduleManager getInstance(){
        if(instance == null){
            instance = new ScheduleManager();
        }
        return instance;
    }

    public void addObserver(Observer obs){ observers.add(obs); }

    public boolean addTask(Task newTask){
        for(Task t : tasks){
            if( overlaps(t,newTask) ){
                notifyObservers("Conflict with existing task", newTask);
                Logger.log("Error: Task conflict with " + t.getDescription());
                return false;
            }
        }
        tasks.add(newTask);
        tasks.sort(Comparator.comparing(Task::getStartTime));
        Logger.log("Task added: " + newTask);
        return true;
    }

    public boolean removeTask(String desc){
        for(Task t : tasks){
            if(t.getDescription().equalsIgnoreCase(desc)){
                tasks.remove(t);
                Logger.log("Task removed: " + desc);
                return true;
            }
        }
        Logger.log("Error: Task not found: " + desc);
        return false;
    }

    // 🔥 New Feature: Edit Task
    public boolean editTask(String oldDesc, Task updatedTask){
        for(int i=0;i<tasks.size();i++){
            if(tasks.get(i).getDescription().equalsIgnoreCase(oldDesc)){
                tasks.set(i, updatedTask);
                tasks.sort(Comparator.comparing(Task::getStartTime));
                Logger.log("Task updated: " + updatedTask);
                return true;
            }
        }
        Logger.log("Error: Task not found: " + oldDesc);
        return false;
    }

    // 🔥 New Feature: Mark Task Completed
    public boolean markTaskCompleted(String desc){
        for(Task t : tasks){
            if(t.getDescription().equalsIgnoreCase(desc)){
                t.markCompleted();
                Logger.log("Task marked completed: " + desc);
                return true;
            }
        }
        Logger.log("Error: Task not found: " + desc);
        return false;
    }

    // 🔥 New Feature: View by Priority
    public void viewTasksByPriority(String priority){
        boolean found = false;
        for(Task t : tasks){
            if(t.getPriority().equalsIgnoreCase(priority)){
                System.out.println(t);
                found = true;
            }
        }
        if(!found){
            System.out.println("No tasks with priority: " + priority);
        }
    }

    public void viewTasks(){
        if(tasks.isEmpty()){
            System.out.println("No tasks scheduled for the day.");
        } else {
            for(Task t : tasks){
                System.out.println(t);
            }
        }
    }

    private boolean overlaps(Task a, Task b){
        return !(b.getEndTime().isBefore(a.getStartTime()) || b.getStartTime().isAfter(a.getEndTime()));
    }

    private void notifyObservers(String msg, Task task){
        for(Observer o : observers){
            o.update(msg, task);
        }
    }
}
