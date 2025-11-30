package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Gestor de Tareas");
        ventana.setSize(600, 300); //Tamaño: ancho alto
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new BorderLayout(10, 10));
        ventana.getContentPane().setBackground(new Color(230,230,250));

        //panel superior

        JTextField campo = new JTextField();
        JButton botonAdd = new JButton("Agregar Tarea");
        JPanel panel = new JPanel(new BorderLayout(5,5));
        panel.setBackground(new Color(200,200,255));
        botonAdd.setBackground(new Color(100,149,237));
        botonAdd.setForeground(Color.WHITE);
        botonAdd.setFocusPainted(false);
        panel.add(campo, BorderLayout.CENTER);
        panel.add(botonAdd, BorderLayout.EAST);
        ventana.add(panel, BorderLayout.NORTH);

        //Panel central
        String[] columnas = {"ID", "Tarea", "COMPLETADA"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0){
            @Override
            public Class<?> getColumnClass(int columnIndex) {
               if(columnIndex==2){
                   return Boolean.class;//Checkbox
               }
               return String.class;
            }
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 2 ; //solo editable checkbox
            }
        };
        JTable table = new JTable(modelo);
        table.setFont(new Font("Arial",Font.PLAIN, 16));
        table.setRowHeight(20);
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                Boolean completada = (Boolean) table.getValueAt(row,2);

                if(completada !=null && completada){
                    c.setForeground(new Color(150,255,230));
                    c.setFont(c.getFont().deriveFont(Font.ITALIC));
                }else{
                    c.setForeground(Color.gray);
                    c.setFont(c.getFont().deriveFont(Font.PLAIN));
                }
                if(isSelected){
                    c.setBackground(new Color(173,216,230));
                }else{
                    c.setBackground(Color.WHITE);
                }
                return c;
            }
        });

        JScrollPane scroll = new JScrollPane(table);
        ventana.add(scroll, BorderLayout.CENTER);

        //Panel inferior:
        JPanel panelBotones = new JPanel(new FlowLayout());
        JButton editar = new JButton("Editar");
        JButton eliminar = new JButton("Eliminar");
        panelBotones.add(editar);
        panelBotones.add(eliminar);
        ventana.add(panelBotones, BorderLayout.SOUTH);

        //Archivo
        File archivo = new File("tareas.txt");
        if(archivo.exists()){
            try(Scanner sc = new Scanner(archivo)){
                while(sc.hasNextLine()){
                    String linea = sc.nextLine();
                    modelo.addRow(new Object[]{modelo.getRowCount() + 1, linea});
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(ventana, "Error al cargar las tareas");
            }
        }

        //Evento agregar
        botonAdd.addActionListener(e -> {
            String tarea = campo.getText().trim();
            if (!tarea.isEmpty()) {
                int id = modelo.getRowCount() + 1;
                modelo.addRow(new Object[]{id, tarea});
                campo.setText("");
                guardarTareas(modelo,archivo);
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
                    guardarTareas(modelo,archivo);
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
                actualizarIDs(modelo);
                guardarTareas(modelo,archivo);

            }else{
                JOptionPane.showMessageDialog(ventana, "selecciona una tarea para eliminar");
            }
        });

        ventana.setVisible(true);

    }

    public static void guardarTareas(DefaultTableModel modelo, File archivo){
        try(PrintWriter pw = new PrintWriter(archivo)){
            for (int i =0; i<modelo.getRowCount(); i++){
                pw.println(modelo.getValueAt(i,1));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void actualizarIDs(DefaultTableModel modelo){
        for (int i=0; i< modelo.getRowCount(); i++){
            modelo.setValueAt(i+1,i,0);
        }
    }



}//endclass