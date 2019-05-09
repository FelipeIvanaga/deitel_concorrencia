/*
Autor: Felipe Alves Ivanaga
email: felipe.alves.ivanaga@gmail.com
*/

package br.com.felipeivanaga.SimpleArray;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.Arrays;

public class SimpleArray {
    private static final SecureRandom generator = new SecureRandom();
    private final int[] array;
    private int writeIndex = 0;

    public SimpleArray(int size) {
        array = new int[size];
    }

    public synchronized void add(int value) {
        int position = writeIndex;

        try {
            Thread.sleep(generator.nextInt(500));
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        array[position] = value;
        System.out.printf("%s Escreveu %2d no elemento %d%n", Thread.currentThread().getName(), value, position);

        ++writeIndex;
        System.out.printf("Proximo escreva na posição: %d%n", writeIndex);
    }

    public String toString() {
        return Arrays.toString(array);
    }
}
