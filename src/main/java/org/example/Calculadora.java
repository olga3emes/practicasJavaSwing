package org.example;

import javax.swing.*;

public class Calculadora {

    static void main() {
        JFrame ventana = new JFrame("Calculadora");
        ventana.setSize(300,400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(null);

        JLabel etiqueta1 = new JLabel("Número 1");
        etiqueta1.setBounds(20,20,80,25);
        ventana.add(etiqueta1);

        JTextField campo1 = new JTextField();
        campo1.setBounds(100,20,80,25);
        ventana.add(campo1);

        JLabel etiqueta2 = new JLabel("Número 2");
        etiqueta2.setBounds(20,80,80,25);
        ventana.add(etiqueta2);

        JTextField campo2 = new JTextField();
        campo2.setBounds(100,80,80,25);
        ventana.add(campo2);

        JLabel etiqueta3 = new JLabel("Resultado:");
        etiqueta3.setBounds(20,140,80,25);
        ventana.add(etiqueta3);

        JTextField resultado = new JTextField();
        resultado.setBounds(100,140,80,25);
        ventana.add(resultado);

        JButton boton = new JButton("Sumar");
        boton.setBounds(20, 180, 80, 25);
        ventana.add(boton);

        boton.addActionListener(e->{
            try {
                double num1 = Double.parseDouble(campo1.getText());
                double num2 = Double.parseDouble(campo2.getText());
                resultado.setText("" + (num1 + num2));
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(ventana, "Por favor, ingresa números válidos");
            }
        });

        ventana.setVisible(true);
    }

}
