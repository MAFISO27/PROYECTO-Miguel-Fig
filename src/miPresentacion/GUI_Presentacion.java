package miPresentacion;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

public class GUI_Presentacion extends JFrame {
    //atributos
    private JButton miFoto, miHobby, misExpectativas;
    private JPanel panelBotones, panelDatos;
    private Titulos titulo;
    private JLabel labelImage;
    private JTextArea miTextoExpectativas;
    private Escucha escucha;

    //metodos
    public GUI_Presentacion() {
        initGUI();
        //Configuracion base de la ventana
        this.setTitle("Mi Presentación(Miguel Angel FIgueroa Solarte)");
        this.setSize(800, 800);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initGUI() {
        //Definir Container y Layout del JFrame
        //Crear objetos Escucha y Control
        escucha = new Escucha();
        //Configurar JComponents
        titulo = new Titulos("Hola soy Miguel Angel Figueroa Solarte, oprime el botón que desees para saber más de mí...", Color.GREEN);
        this.add(titulo, BorderLayout.NORTH);

        panelDatos = new JPanel();
        panelDatos.setBorder(BorderFactory.createTitledBorder(null, "Un poco sobre mí...",
                TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, new Font("Calibri",
                        Font.PLAIN, 20), Color.YELLOW));
        panelDatos.setBackground(Color.GRAY);
        this.add(panelDatos, BorderLayout.CENTER);

        miFoto = new JButton("yo soy así");
        miFoto.addMouseListener(escucha);
        miFoto.setBackground(Color.blue);
        miHobby = new JButton("Esta es mi pasión");
        miHobby.addMouseListener(escucha);
        miHobby.setBackground(Color.blue);
        misExpectativas = new JButton("Mis Expectativas");
        misExpectativas.addKeyListener(escucha);
        misExpectativas.setBackground(Color.blue);

        panelBotones = new JPanel();
        panelBotones.add(miFoto);
        panelBotones.add(miHobby);
        panelBotones.add(misExpectativas);
        panelBotones.setBackground(Color.red);

        this.add(panelBotones, BorderLayout.SOUTH);

        labelImage = new JLabel();
        miTextoExpectativas = new JTextArea(8, 24);

    }

    private class Escucha implements MouseListener, KeyListener {
        private ImageIcon image;

        @Override
        public void mouseClicked(MouseEvent e) {

            if ((e.getComponent() == miFoto) && (e.getClickCount() == 1)) {
                panelDatos.removeAll();
                image = new ImageIcon(getClass().getResource("/recursos/Miguel.png"));
                labelImage.setIcon(image);
                panelDatos.add(labelImage);
            }
            if ((e.getComponent() == miHobby) && (e.getClickCount() == 2)) {
                panelDatos.removeAll();
                image = new ImageIcon(getClass().getResource("/recursos/GRANMAESTRO.png"));
                labelImage.setIcon(image);
                panelDatos.add(labelImage);
            }
            revalidate();
            repaint();
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void keyTyped(KeyEvent e) {
            if ((e.getComponent() == misExpectativas) && (e.getKeyChar() == KeyEvent.VK_M)) {
                panelDatos.removeAll();
                miTextoExpectativas.setFont(new Font("SansSerif", Font.BOLD, 22));
                miTextoExpectativas.setLineWrap(true);
                miTextoExpectativas.setBackground(Color.WHITE);
                miTextoExpectativas.setWrapStyleWord(true);
                miTextoExpectativas.setEditable(false);
                miTextoExpectativas.setText("No se acerca de la programación orientada a eventos. Espero en este curso aprender y dominar todas las herramientas.\nMis expectativas son realistas para este semestre, deseo aprender y estar tranquilo.");
                panelDatos.add(miTextoExpectativas);

                revalidate();
                repaint();
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI_Presentacion miGUIPresentacion = new GUI_Presentacion();
            }
        });
    }
}