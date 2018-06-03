package com.guardado.gui;

import com.guardado.threads.AnimalThread;

import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame {

    private JPanel [] paneles;
    private JLabel [] labels;
    private String[] nombres = {"canguro","colibri","dragon"};

    public Gui(){
        initialComponents();
       AnimalThread conejo = new AnimalThread("canguro",labels[0].getX(),labels[0].getY(),510,labels[0]);
        AnimalThread tortuga = new AnimalThread("colibri",labels[1].getX(),labels[1].getY(),510,labels[1]);
        AnimalThread zorro = new AnimalThread("dragon",labels[2].getX(),labels[2].getY(),510,labels[2]);
        conejo.start();
        tortuga.start();
        zorro.start();
    }

    public void initialComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        paneles = new JPanel[3];
        labels = new JLabel[3];

        Container container = getContentPane();
        //llenando el panel
        for (int i=0 ; i < 3 ; i++)
        {
            labels[i] = new JLabel();
            /*labels[i].setBackground(Color.BLUE);
            labels[i].setOpaque(true);*/
            labels[i].setIcon(new ImageIcon(getClass().getResource(nombres[i]+".gif")));
            labels[i].setBounds(10,(i*220)+10,200,200);
            container.add(labels[i]);
        }
        //System.out.println(getClass().getResource(nombres[2]+".gif"));
        setSize(700,650);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Gui().setVisible(true);
            }
        });
    }

}
