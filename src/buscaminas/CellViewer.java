/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas;

import com.sun.jndi.toolkit.url.Uri;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author carlos
 */
public class CellViewer extends JButton {
    private Cell cell;
    private CellListener cellListener;
    private boolean hasFlag = false;
    CellViewer(final Cell cell) { 
        this.setSize(1,1);       
        this.cell=cell;
        ImageIcon bomba = new ImageIcon(getClass().getResource("mine_sweeper.gif"));
        final Image bombaImagen = bomba.getImage().getScaledInstance(20, 20, 20);
        cellListener = new CellListener() {
         
            @Override
            public void doMine() {
                setIcon(new ImageIcon(bombaImagen));
                setBackground(Color.GRAY);
                
            }

            @Override
            public void doWin(int i) {                
                    System.out.println("D WINNNNNNNNNNNN");
                   setText(Integer.toString(i));
                   removeListener();
                
            }

            @Override
            public void doFlag() {
                if(cell.isHasflag()){
                    cell.setHasflag(false);
                    setText("");                    
                    setBackground(null);
                    setEnabled(true);
                    
                }
                else{
                    setBackground(Color.blue);
                
                cell.setHasflag(true);
                setText("F");
                setEnabled(false);
                }
            }

            @Override
            public void disable() {
                removeListener();
                setBackground(Color.red);
            }
        };
        this.cell.setCellListener(cellListener);
    }
    public void removeListener(){
        for (MouseListener mouse : this.getMouseListeners())
        this.removeMouseListener(mouse);
    }

    public Cell getCell() {
        return cell;
    }
    
}
