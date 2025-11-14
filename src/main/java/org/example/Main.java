package org.example;

import javax.swing.*;
import java.awt.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    // 1. ¿Qué es Java Swing?

    /* Swing: biblioteca para crear GUI.
    Viene incluida en Java, podemos crear: ventanas, textos, menús...

    Los elementos a los que nos referimos llevan el nombre de componentes.
    Y el paquete es javax.swing
     */

    //2. Crear la primera ventana (JFrame)
    /* JFrame para todas las apps de Java Swing su 💖, y representa una ventana.*/

    public static void usandoJFrame() {
        JFrame ventana = new JFrame("Mi primera ventana");
        ventana.setSize(400, 300); //Tamaño: ancho alto
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cierra al salir
        ventana.setVisible(true); //hace visible la ventana
    }

    //3. Agregar un JLabel

    /*
    El JLabel permite mostrar texto.

    Por defecto, el layout de JFrame ws BorderLayout, y si añadimos solo 1 componente, ocupa todo el espacio.

     */
    public static void usandoJLabel(){
        JFrame ventana = new JFrame("Mi primera ventana");
        ventana.setSize(400, 300); //Tamaño: ancho alto
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cierra al salir

        JLabel texto = new JLabel("Hola DAM!");
        ventana.add(texto);

        ventana.setVisible(true); //hace visible la ventana
    }

    //4. Agregar un botón y capturar eventos
    /*
    El JButton es un botón que el usuario puede pulsa. Y para que algo al hacer click, haga algo,
    teneemos que escuchar eventos usando ActionListener.
     */

    public static void usandoJButtonEvento(){
        JFrame ventana = new JFrame("Mi primera ventana");
        ventana.setSize(400, 300); //Tamaño: ancho alto
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cierra al salir

        JButton boton = new JButton("Haz click aquí");
        boton.setBounds(120,70,150,30); //x,y,ancho y alto
        ventana.add(boton);

        //Crear el evento
        boton.addActionListener(e->{
            JOptionPane.showMessageDialog(ventana, "Botón presionado");
        });

        JLabel texto = new JLabel("Hola DAM!");
        ventana.add(texto);

        ventana.setVisible(true); //hace visible la ventana

    }


    //5. Agregar JTextField (campo de texto)
    /*
    Ahora vamos a permitir que el usuario ingrese datos, por ejemplo su nombre.
    Y vamos a añadir un botón que use ese nombre para decirle hola.
     */
    public static void usandoJTextField(){
        JFrame ventana = new JFrame("Mi primera ventana");
        ventana.setSize(400, 300); //Tamaño: ancho alto
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(null);
        //cierra al salir
        JLabel etiqueta = new JLabel("Ingresa tu nombre:");
        etiqueta.setBounds(50,30,150,25);
        ventana.add(etiqueta);

        JButton boton = new JButton("Saludar");
        boton.setBounds(140,80,80,20); //x,y,ancho y alto
        ventana.add(boton);

        JTextField campoTexto = new JTextField();
        campoTexto.setBounds(180,30,100,25);
        ventana.add(campoTexto);

        //Crear el evento
        boton.addActionListener(e->{
            String nombre = campoTexto.getText();
            JOptionPane.showMessageDialog(ventana, "Hola " + nombre + "!");
        });

        ventana.setVisible(true);
    }

    //6. Layouts en Swing

    /*
    setLayout(null) -> Usamos coordenadas. Poco práctico, una lata...

    FlowLayout -> Componentes de fila, ajuste automático
    BorderLayout-> Ventana dividida en norte, sur, este, oeste y centro
    GridLayout -> Tabla con filas y columnas iguales
    BoxLayout -> Fila o Columna con alineación

     */

    public static void usandoFlowLayout(){
        JFrame ventana = new JFrame("FlowLayout");
        ventana.setSize(400, 300); //Tamaño: ancho alto
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new FlowLayout());

        ventana.add(new JButton("Botón 1"));
        ventana.add(new JButton("Botón 2"));
        ventana.add(new JButton("Botón 3"));

        ventana.setVisible(true);
    }

public static void usandoGridLayout(){
    JFrame ventana = new JFrame("GridLayout");
    ventana.setSize(400, 300); //Tamaño: ancho alto
    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ventana.setLayout(new GridLayout(4, 2, 5, 5)); //filas, columnas,gapy,gapx

    ventana.add(new JButton("Botón 1"));
    ventana.add(new JButton("Botón 2"));
    ventana.add(new JButton("Botón 3"));
    ventana.add(new JButton("Botón 4"));

    ventana.setVisible(true);
}

public static void usandoBorderLayout(){
    JFrame ventana = new JFrame("BorderLayout");
    ventana.setSize(400, 300); //Tamaño: ancho alto
    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ventana.setLayout(new BorderLayout()); //filas, columnas,gapy,gapx

    ventana.add(new JButton("Norte"), BorderLayout.NORTH);
    ventana.add(new JButton("sur"), BorderLayout.SOUTH);
    ventana.add(new JButton("este"), BorderLayout.EAST);
    ventana.add(new JButton("oeste"), BorderLayout.WEST);
    ventana.add(new JButton("centro"), BorderLayout.CENTER);

    ventana.setVisible(true);

}


        public static void main(String[] args) {

            // usandoJFrame();
            //usandoJLabel();
           // usandoJButtonEvento();
           //usandoJTextField();
            //usandoFlowLayout();
            //usandoBorderLayout();


            JFrame ventana = new JFrame("BorderLayout");
            ventana.setSize(400, 300); //Tamaño: ancho alto
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.setLayout(new BorderLayout()); //filas, columnas,gapy,gapx

            ventana.add(new JButton("Norte"), BorderLayout.NORTH);
            ventana.add(new JButton("sur"), BorderLayout.SOUTH);
            ventana.add(new JButton("este"), BorderLayout.EAST);
            ventana.add(new JButton("oeste"), BorderLayout.WEST);
            ventana.add(new JButton("centro"), BorderLayout.CENTER);

            ventana.setVisible(true);


        }



}