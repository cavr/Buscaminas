/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author carlos
 */
public class Start {
    private StopListener listener;
    private BuscaminasFrame buscaminasFrame;
    private gameStats stats;
    private StartListener startListener;
    int filas, columnas, minas;
    public void start(int filas, int columnas, int minas) {
        if (buscaminasFrame != null){
            buscaminasFrame.removeAll();
            buscaminasFrame.setVisible(false);
        }
        else{
            this.filas = filas;
            this.columnas = columnas;
            this.minas = minas;            
        }
        buscaminasFrame = new BuscaminasFrame(minas, filas, columnas);
        buscaminasFrame.setStopListener(listener);
        stats = new gameStats(minas, filas*columnas, buscaminasFrame.getFinish());
        buscaminasFrame.setStatListener(stats.getListener());
        }

    public StartListener getStartListener() {
        return startListener;
    }
    

    public Start() {
        startListener = new StartListener() {

            @Override
            public void startGame(int minas, int filas, int columnas) {                
                start(filas, columnas, minas);
            }
        };
        listener = new StopListener() {

            @Override
            public void finishGame() {
                stop();
            }
        };        
    }
    public void stop(){
        start(filas, columnas, minas);
        
    }
    
    
}
