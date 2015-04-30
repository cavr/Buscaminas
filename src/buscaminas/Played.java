
package buscaminas;

import java.util.ArrayList;


public class Played {
    private CellListener CellListener;
    private buscaminas.FinishGame gameListener;
    private StatListener stat;

    public void setGameListener(FinishGame gameListener) {
        this.gameListener = gameListener;
    }
    private Cell cell;
    public void setPlayListener(CellListener playListener) {
        this.CellListener = playListener;
    }

    public void Played(Cell cell, StatListener stat) {
        int Minas = 0;
        this.stat = stat;
        if (cell.isHasmine()){
            cell.getCellListener().doMine();
            for(Cell  element : cell.getNeighbors() )
            mineExplotion(element, new ArrayList());
            gameListener.loseGame();
            
        }
        else{
            stat.hasGame();
             int i = 1;
            for(Cell element: cell.getNeighbors()){               
               System.out.println(i++); 
            
                if (element.isHasmine()) Minas++;
            }
            if (Minas == 0){
                cell.getCellListener().disable();
                stat.hasGame();
                realese(cell, new ArrayList());
            }
            else cell.getCellListener().doWin(Minas);
        }      
    }

    private void mineExplotion(Cell cell, ArrayList<Cell> list) {        
        for(Cell  element : cell.getNeighbors() ){
            list.add(cell);
            if (element.isHasmine()) element.getCellListener().doMine();
            if(!list.contains(element))
            mineExplotion(element,list);
        }        
    }

    private void realese(Cell cell, ArrayList<Cell> list) {
        int Minas = 0;
        list.add(cell);
        for(Cell element : cell.getNeighbors()){
        if (element.isHasmine()) Minas++;        
        }
        if(Minas == 0){
            for(Cell element : cell.getNeighbors())
            if (!list.contains(element)){
                element.getCellListener().disable();
                stat.hasGame();
                realese(element, list);
            }
        }
        else{
            System.out.println("POrqueeeee");
            cell.getCellListener().doWin(Minas);            
        }                
            
    }

    void Bandera(Cell cell) {
        cell.getCellListener().doFlag();
    }
    
    
}
