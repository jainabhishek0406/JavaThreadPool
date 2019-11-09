
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Abhishek Jain
 */

class Task implements Runnable{
    private String taskName;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void run() {
        try {
            Long taskExecutionTime = (long) (Math.random() * 10);
            System.out.println("Executing : " + taskName);
            TimeUnit.SECONDS.sleep(taskExecutionTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
public class ThreadPoolEx {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        for (int i = 1; i <= 15; i++)
        {
            Task task = new Task();
            task.setTaskName("Task " + i);
            System.out.println("Created : " + task.getTaskName());
            executor.execute(task);
        }
        executor.shutdown();
    }
}
