package buscaminas;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class BuscaminasFrame extends JFrame {

    int i;
    JTextField jtextField;
    private StopListener stopListener;
    private BoardViewer boardViewer;
    private StatListener statListener;
    private FinishGame finish;

    public FinishGame getFinish() {
        return finish;
    }

    public void setStatListener(StatListener statListener) {
        this.statListener = statListener;
    }

    public BuscaminasFrame(int minas, int filas, int columnas) {        
        jtextField = new JTextField();
        Timer timer = new Timer();
        setTitle("Buscaminas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        timer.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                System.out.println("Hola");
                display();
            }
        }, 0, 1000);                
        finish = new FinishGame() {

            @Override
            public void winGame() {
                try {
                    winMessage();
                } catch (InterruptedException ex) {
                    Logger.getLogger(BuscaminasFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void loseGame() {
                try {
                    loseMessage();
                } catch (Throwable ex) {
                    Logger.getLogger(BuscaminasFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        boardViewer = new BoardViewer(filas, columnas, minas,new MouseListener() {

            private Played Played;

            @Override
            public void mouseClicked(MouseEvent e) {
                CellViewer Presionado = ((CellViewer) e.getComponent());
                Played = new Played();
                Played.setGameListener(finish);
                if (e.getButton() == MouseEvent.BUTTON3) {
                    Played.Bandera(Presionado.getCell());
                } else {
                    Played.Played(Presionado.getCell(), statListener);

                }


            }

            @Override
            public void mousePressed(MouseEvent e) {
                ;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                ;
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                ;
            }

            @Override
            public void mouseExited(MouseEvent e) {
                ;
            }
        });
        getContentPane().add(boardViewer);
        JButton startButton = new JButton("Start");
        startButton.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                stopListener.finishGame();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                ;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                ;
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                ;
            }

            @Override
            public void mouseExited(MouseEvent e) {
                ;
            }
        });
        this.add(startButton, BorderLayout.PAGE_END);
        setSize(800, 600);
        setVisible(true);
    }

    public void winMessage() throws InterruptedException {
         JOptionPane.showMessageDialog(this, "Ha ganado en hora buena");
        jtextField.setText("Has Ganado");
        this.add(jtextField, BorderLayout.NORTH);
        boardViewer.disablePanel();
        boardViewer.setVisible(false);
        remove(boardViewer);
        this.add(new JTextField("Eres un Ganador"), BorderLayout.CENTER);
        System.out.println("HeyyyyyEstoQuePasa");        
    }

    public void loseMessage() throws Throwable {
        JOptionPane.showMessageDialog(this, "Has Perdido");        
        jtextField.setText("Has Perdido");
        this.add(jtextField, BorderLayout.SOUTH);
        System.out.println("Has Ganado");
        this.add(new JTextField("Has perdido tiempo " + Integer.toString(i)), BorderLayout.NORTH);
        boardViewer.disablePanel();
        //stopListener.finishGame();
    }

    public void display() {       
        jtextField.setText(Integer.toString(i++));
        this.add(jtextField, BorderLayout.AFTER_LINE_ENDS);

    }

    void setStopListener(StopListener listener) {
        stopListener = listener;
    }
}