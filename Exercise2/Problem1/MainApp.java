package Exercise2.Problem1;

import Exercise2.Problem1.factory.TaskFactory;
import Exercise2.Problem1.manager.ScheduleManager;
import Exercise2.Problem1.model.Task;
import Exercise2.Problem1.observer.ConflictNotifier;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        ScheduleManager manager = ScheduleManager.getInstance();
        manager.addObserver(new ConflictNotifier());
        TaskFactory factory = new TaskFactory();

        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("\n--- Astronaut Daily Schedule ---");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. View All Tasks");
            System.out.println("4. Edit Task");
            System.out.println("5. Mark Task Completed");
            System.out.println("6. View Tasks by Priority");
            System.out.println("7. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch(choice){
                    case 1:
                        System.out.print("Description: ");
                        String desc = sc.nextLine();
                        System.out.print("Start (HH:mm): ");
                        String start = sc.nextLine();
                        System.out.print("End (HH:mm): ");
                        String end = sc.nextLine();
                        System.out.print("Priority: ");
                        String pri = sc.nextLine();

                        Task t = factory.createTask(desc,start,end,pri);
                        if(manager.addTask(t)) System.out.println("Task added successfully.");
                        break;

                    case 2:
                        System.out.print("Enter task description to remove: ");
                        String d = sc.nextLine();
                        if(manager.removeTask(d)) System.out.println("Task removed.");
                        else System.out.println("Task not found.");
                        break;

                    case 3:
                        manager.viewTasks();
                        break;

                    case 4:
                        System.out.print("Enter task description to edit: ");
                        String oldDesc = sc.nextLine();
                        System.out.print("New Description: ");
                        String newDesc = sc.nextLine();
                        System.out.print("New Start (HH:mm): ");
                        String ns = sc.nextLine();
                        System.out.print("New End (HH:mm): ");
                        String ne = sc.nextLine();
                        System.out.print("New Priority: ");
                        String np = sc.nextLine();

                        Task updated = factory.createTask(newDesc, ns, ne, np);
                        if(manager.editTask(oldDesc, updated)) System.out.println("Task updated.");
                        else System.out.println("Task not found.");
                        break;

                    case 5:
                        System.out.print("Enter task description to mark completed: ");
                        String comp = sc.nextLine();
                        if(manager.markTaskCompleted(comp)) System.out.println("Task marked completed.");
                        else System.out.println("Task not found.");
                        break;

                    case 6:
                        System.out.print("Enter priority (High/Medium/Low): ");
                        String p = sc.nextLine();
                        manager.viewTasksByPriority(p);
                        break;

                    case 7:
                        System.out.println("Exiting...");
                        System.exit(0);
                }
            } catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
