/*
Autor: Felipe Alves Ivanaga
email: felipe.alves.ivanaga@gmail.com
*/

package br.com.felipeivanaga.Task;

import java.security.SecureRandom;

public class PrintTask implements Runnable{
    private static final SecureRandom generator = new SecureRandom();
    private final int sleepTime;
    private final String taskName;

    public PrintTask(String taskName) {
        this.taskName = taskName;

        sleepTime = generator.nextInt(5000);
    }

    public void run() {
        try {
            System.out.printf("%s dormindo por %d milisegundos.%n", taskName, sleepTime);
            Thread.sleep(sleepTime);
        }
        catch (InterruptedException exception) {
            exception.printStackTrace();
            Thread.currentThread().interrupt();
        }

        System.out.printf("%s Parou de dormir%n", taskName);
    }
}
