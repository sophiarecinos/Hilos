package com.guardado.threads;

import javax.swing.*;

public class AnimalThread extends Thread {
    private JButton b;
    private String nombre;
    private int limite;
    private JLabel animal;
    private int x;
    private int y;

    public AnimalThread(){}

    public AnimalThread(String nombre, int x, int y, int limite, JLabel animal, JButton b) {
        this.nombre = nombre;
        this.x = x;
        this.y= y;
        this.limite = limite;
        this.animal = animal;
        this.b=b;
    }

    @Override
    public void run()
    {
        for (int i=x ; i<=this.limite ; i+=10)
        {
            System.out.println(this.nombre + " avanza");
            this.animal.setLocation(i,y);
            try {
                if(this.nombre=="tortuga")
                    sleep(150);
                else
                    sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(nombre=="tortuga"){
            b.setVisible(true);
        }
        System.out.println(this.nombre + " a llegado a la meta");
        

        yield();
    }
}
