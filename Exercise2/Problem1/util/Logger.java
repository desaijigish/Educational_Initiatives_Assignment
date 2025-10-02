package Exercise2.Problem1.util;

import java.time.LocalDateTime;

public class Logger {
    public static void log(String msg) {
        System.out.println("[" + LocalDateTime.now() + "] " + msg);
    }
}
