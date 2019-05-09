/*
Autor: Felipe Alves Ivanaga
email: felipe.alves.ivanaga@gmail.com
*/

package br.com.felipeivanaga.SimpleArray;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SharedArrayTest {
    public static void main(String[] args) {
        SimpleArray sharedSimpleArray = new SimpleArray(6);

        ArrayWriter writer1 = new ArrayWriter(1, sharedSimpleArray);
        ArrayWriter writer2 = new ArrayWriter(11, sharedSimpleArray);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(writer1);
        executorService.execute(writer2);

        executorService.shutdown();

        try {
            boolean tasksEnded = executorService.awaitTermination(1, TimeUnit.MINUTES);

            if (tasksEnded) {
                System.out.printf("%nConteudo do array:%n");
                System.out.println(sharedSimpleArray);
            } else {
                System.out.println("Time out esperando as tarefas finalizarem");
            }
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
