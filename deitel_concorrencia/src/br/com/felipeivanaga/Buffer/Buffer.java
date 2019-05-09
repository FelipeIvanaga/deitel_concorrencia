/*
Autor: Felipe Alves Ivanaga
email: felipe.alves.ivanaga@gmail.com
*/

package br.com.felipeivanaga.Buffer;

public interface Buffer {
    public void blockingPut(int value) throws InterruptedException;

    public int blockingGet() throws InterruptedException;
}
