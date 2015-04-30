
package buscaminas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BoardViewer extends JPanel{
    
    private JPanel jpanel;
    private JPanel jpanelPrincipal;
    private JTextField text;
    private JFrame frame;
    private ArrayList <CellViewer> cellList; 
    private Board board;

    public BoardViewer(int x, int y,int minas,  MouseListener mouse) {        
        jpanel = new JPanel();
        setSize(800,600);
        jpanel.setSize(600,400);
        cellList = new ArrayList();               
        board=new Board(x,y, minas);
        for(int i = 0; i<x; i++)
            for(int j = 0; j<y; j++){
                CellViewer cellViewer = new CellViewer(board.getCell(i, j));              
                cellViewer.addMouseListener(mouse);                
                cellList.add(cellViewer);                
                jpanel.add(cellList.get(i*y+j));
            }
        this.add(jpanel,BorderLayout.CENTER);
        jpanel.setLayout(new GridLayout(x,y,20,20));
        
        System.out.println("Heyyyyyyyy");                    
        
    }
    public void disablePanel() throws InterruptedException{
        for (Component component : jpanel.getComponents()){        
        for(MouseListener mouse : component.getMouseListeners())
        component.removeMouseListener(mouse);
        }        
     
    }
    
    
}
