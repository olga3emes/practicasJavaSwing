package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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
    public static void usandoJLabel() {
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

    public static void usandoJButtonEvento() {
        JFrame ventana = new JFrame("Mi primera ventana");
        ventana.setSize(400, 300); //Tamaño: ancho alto
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cierra al salir

        JButton boton = new JButton("Haz click aquí");
        boton.setBounds(120, 70, 150, 30); //x,y,ancho y alto
        ventana.add(boton);

        //Crear el evento
        boton.addActionListener(e -> {
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
    public static void usandoJTextField() {
        JFrame ventana = new JFrame("Mi primera ventana");
        ventana.setSize(400, 300); //Tamaño: ancho alto
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(null);
        //cierra al salir
        JLabel etiqueta = new JLabel("Ingresa tu nombre:");
        etiqueta.setBounds(50, 30, 150, 25);
        ventana.add(etiqueta);

        JButton boton = new JButton("Saludar");
        boton.setBounds(140, 80, 80, 20); //x,y,ancho y alto
        ventana.add(boton);

        JTextField campoTexto = new JTextField();
        campoTexto.setBounds(180, 30, 100, 25);
        ventana.add(campoTexto);

        //Crear el evento
        boton.addActionListener(e -> {
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

    public static void usandoFlowLayout() {
        JFrame ventana = new JFrame("FlowLayout");
        ventana.setSize(400, 300); //Tamaño: ancho alto
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new FlowLayout());

        ventana.add(new JButton("Botón 1"));
        ventana.add(new JButton("Botón 2"));
        ventana.add(new JButton("Botón 3"));

        ventana.setVisible(true);
    }

    public static void usandoGridLayout() {
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

    public static void usandoBorderLayout() {
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

    public static void usandoBoxLayout() {
        JFrame ventana = new JFrame("BoxLayout");
        ventana.setSize(400, 300); //Tamaño: ancho alto
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new BoxLayout(ventana.getContentPane(), BoxLayout.Y_AXIS)); //filas, columnas,gapy,gapx

        ventana.add(new JButton("One"));
        ventana.add(new JButton("Two"));
        ventana.add(new JButton("Three"));
        ventana.add(new JButton("Four"));

        ventana.setVisible(true);
    }

    public static void usandoVariosLayout() {
        JFrame ventana = new JFrame("Combination Layout");
        ventana.setSize(400, 300); //Tamaño: ancho alto
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new BorderLayout()); //filas, columnas,gapy,gapx

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Resultado:"));
        topPanel.add(new JTextField(10));
        ventana.add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridLayout(4, 4));
        centerPanel.add(new JButton("1"));
        centerPanel.add(new JButton("2"));
        centerPanel.add(new JButton("3"));
        centerPanel.add(new JButton("4"));
        centerPanel.add(new JButton("5"));
        centerPanel.add(new JButton("6"));
        centerPanel.add(new JButton("7"));
        centerPanel.add(new JButton("8"));
        centerPanel.add(new JButton("9"));
        centerPanel.add(new JButton("C"));
        ventana.add(centerPanel, BorderLayout.CENTER);


        ventana.setVisible(true);
    }

    public static void usandoJList() {
        JFrame ventana = new JFrame("JList");
        ventana.setSize(400, 300); //Tamaño: ancho alto
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] frutas = {"Apple", "Orange", "pear", "Lemon"};

        JList<String> lista = new JList<>(frutas);
        JScrollPane scroll = new JScrollPane(lista);
        ventana.add(scroll);

        ventana.setVisible(true);
    }


    public static void usandoJTable() {
        JFrame ventana = new JFrame("JTable");
        ventana.setSize(400, 300); //Tamaño: ancho alto
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[][] datos = {
                {"1", "Juan", "25"},
                {"2", "Ana", "30"},
                {"3", "Luis", "29"}
        };

        String[] columnas = {"ID", "Nombre", "Edad"};

        JTable tabla = new JTable(datos, columnas);
        JScrollPane scroll = new JScrollPane(tabla);
        ventana.add(scroll);

        ventana.setVisible(true);
    }

    public static void usandoListaDinamica() {
        JFrame ventana = new JFrame("JList + JButton");
        ventana.setSize(400, 300); //Tamaño: ancho alto
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new BorderLayout(5, 5));

        DefaultListModel<String> modelo = new DefaultListModel<>();//Array
        JList<String> lista = new JList<>(modelo);
        JScrollPane scrollPane = new JScrollPane(lista);
        ventana.add(scrollPane, BorderLayout.CENTER);

        JTextField campo = new JTextField();
        JButton botonAdd = new JButton("Agregar");
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(campo, BorderLayout.CENTER);
        panel.add(botonAdd, BorderLayout.EAST);
        ventana.add(panel, BorderLayout.NORTH);

        JButton botonMostrar = new JButton("Mostrar selección");
        ventana.add(botonMostrar, BorderLayout.SOUTH);

        //Evento agregar
        botonAdd.addActionListener(e -> {
            String texto = campo.getText();
            if (!texto.isEmpty()) {
                modelo.addElement(texto);
                campo.setText("");
            }
        });

        //Mostrar seleccion
        botonMostrar.addActionListener(e -> {
            String seleccionado = lista.getSelectedValue();
            if (seleccionado != null) {
                JOptionPane.showMessageDialog(ventana, " ✏  ️Seleccionaste: " + seleccionado);
            } else {
                JOptionPane.showMessageDialog(ventana, "❌ No hay selección");
            }
        });

        ventana.setVisible(true);

    }


    public static void main(String[] args) {

        // usandoJFrame();
        //usandoJLabel();
        // usandoJButtonEvento();
        //usandoJTextField();
        //usandoFlowLayout();
        //usandoBorderLayout();
        //usandoBoxLayout();
        //usandoVariosLayouts();
        JFrame ventana = new JFrame("JTable interactiva");
        ventana.setSize(400, 300); //Tamaño: ancho alto
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new BorderLayout(5, 5));

        //panel superior
        JTextField campo = new JTextField();
        JButton botonAdd = new JButton("Agregar Tarea");
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(campo, BorderLayout.CENTER);
        panel.add(botonAdd, BorderLayout.EAST);
        ventana.add(panel, BorderLayout.NORTH);

        //Panel central
        String[] columnas = {"ID", "Tarea"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
        JTable table = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(table);
        ventana.add(scroll, BorderLayout.CENTER);

        //Panel inferior:
        JPanel panelBotones = new JPanel(new FlowLayout());
        JButton editar = new JButton("Editar");
        JButton eliminar = new JButton("Eliminar");
        panelBotones.add(editar);
        panelBotones.add(eliminar);
        ventana.add(panelBotones, BorderLayout.SOUTH);

        //Evento agregar
        botonAdd.addActionListener(e -> {
            String tarea = campo.getText().trim();
            if (!tarea.isEmpty()) {
                int id = modelo.getRowCount() + 1;
                modelo.addRow(new Object[]{id, tarea});
                campo.setText("");
            }
        });

        //evento para editar
        editar.addActionListener(e -> {
            int fila = table.getSelectedRow();
            if (fila != -1) {
                String nuevaTarea = JOptionPane.showInputDialog(
                        ventana, "Editar tarea: ", modelo.getValueAt(fila, 1)
                );
                if (nuevaTarea != null && !nuevaTarea.trim().isEmpty()) {
                    modelo.setValueAt(nuevaTarea.trim(), fila, 1);
                }
            } else {
                JOptionPane.showMessageDialog(ventana, "selecciona una tarea para editar");
            }

        });

        //evento para eliminar
        eliminar.addActionListener(e -> {

            int fila = table.getSelectedRow();
            if(fila !=-1){
                modelo.removeRow(fila);
            }else{
                JOptionPane.showMessageDialog(ventana, "selecciona una tarea para eliminar");
            }

        });

        ventana.setVisible(true);

    }


}