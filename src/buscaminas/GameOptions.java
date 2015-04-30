
package buscaminas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GameOptions extends JFrame {
    private JTextField minas;
    private JTextField columnas;
    private JTextField filas;
    private StartListener listener;
    

    public GameOptions(StartListener listener) {
        setTitle("Buscaminas");
        setSize(800,600);
        this.listener = listener;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel jpanel = new JPanel();
        minas = new JTextField("Minas");
        columnas = new  JTextField("Columnas");
        filas = new JTextField("Filas");
        jpanel.add(minas);
        jpanel.add(columnas);
        jpanel.add(filas);
        jpanel.setBounds(200,200,500,500);
        add(jpanel);
        JButton button = new JButton("Start Game");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                start();
            }
        }); 
        this.add(button, BorderLayout.SOUTH);
        setVisible(true);
        
    }
    private void start(){
        listener.startGame(Integer.parseInt(minas.getText()), Integer.parseInt(filas.getText()),Integer.parseInt(columnas.getText()));
        this.setVisible(false);
        this.removeAll();
        this.disable();
    }
    
    
    
}
