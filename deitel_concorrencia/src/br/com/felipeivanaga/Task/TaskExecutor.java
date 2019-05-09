/*
Autor: Felipe Alves Ivanaga
email: felipe.alves.ivanaga@gmail.com
*/

package br.com.felipeivanaga.Task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskExecutor {
    public static void main(String[] args) {
        PrintTask task1 = new PrintTask("Tarefa1");
        PrintTask task2 = new PrintTask("Tarefa2");
        PrintTask task3 = new PrintTask("Tarefa3");

        System.out.println("Iniciando executor");

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(task1);
        executorService.execute(task2);
        executorService.execute(task3);

        executorService.shutdown();

        System.out.printf("Tarefas iniciadas, main encerra. %n%n");
    }
}
