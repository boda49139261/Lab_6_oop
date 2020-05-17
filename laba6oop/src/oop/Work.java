package oop;

import javax.swing.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodListener;
import java.io.File;
import java.nio.file.Files;
import java.util.EventListener;

class Work extends JPanel {
    //   public static long numberOfExtension() {





    //  }

    public static void main(String[] args) throws Exception {
        // Get the file

        JFrame frame = new JFrame("Chat Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);

        JPanel panel = new JPanel();
        Label label = new Label("Виведення кількості файлів заданих типів");
        panel.add(label);

        JPanel panel1 = new JPanel();
        JFileChooser ta = new JFileChooser();
        panel1.add(ta);

        JPanel panel2 = new JPanel();
        JLabel label3 = new JLabel("Введіть тип файлу:");
        JTextField tf1 = new JTextField(10);
        //if
        ta.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        tf1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String path = "F:\\program.txt";
                String extension = "";

                if (path.contains("."))
                    extension = path.substring(path.lastIndexOf("."));

                if (extension == ".txt"){

                }
                //System.out.println("extension: " + extension);

                tf1.getText();
            }

        });
        JLabel label4 = new JLabel("Кількість файлів:");
        JTextField tf2 = new JTextField(10);


        panel2.add(label3); // Components Added using Flow Layout
        panel2.add(tf1);
        panel2.add(label4);
        panel2.add(tf2);

//        ActionListener actionListener = new ActionListener() {

        /*
                    TextField tf2 = new TextField(10);
                    tf2.setVisible(true);
                    File f = new File("E:\\1.txt");
                    if (f.exists()) {
                        String s1 = "Exists";
                        s1 = tf2.getText();

                        System.out.println("Exists");
                    }
                    else
                        System.out.println("Does not Exists");
*/

        ActionListener actionListener = new ActionListener()
        {
            public void actionPerformed(ActionEvent actionEvent)
            {
                JFileChooser theFileChooser = (JFileChooser) actionEvent.getSource();
                String command = actionEvent.getActionCommand();
                File selectedFile = theFileChooser.getSelectedFile();
                int count = 0;
                for (File file : selectedFile.listFiles())
                {
                    if(file.getName().contains(tf1.getText()))
                    {
                        count++;
                    }
                }
                tf2.setText("" + count);
            }
        };
        ta.addActionListener( actionListener);

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.NORTH, panel);
        frame.getContentPane().add(BorderLayout.CENTER, panel1);
        frame.getContentPane().add(BorderLayout.SOUTH, panel2);
        frame.getContentPane().setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600, 500));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
