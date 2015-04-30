package buscaminas;

import java.util.ArrayList;

public class Cell {
    private ArrayList<Cell> neighbors;
    private boolean hasmine = false;
    private boolean hasflag = false;
    private int x;
    private int y;
    private CellListener cellListener;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public ArrayList<Cell> getNeighbors() {
        return neighbors;
    }

    public CellListener getCellListener() {
        return cellListener;
    }

    public void setCellListener(CellListener cellListener) {
        this.cellListener = cellListener;
    }

    public boolean isHasflag() {
        return hasflag;
    }

    public boolean isHasmine() {
        return hasmine;
    }

    public void setNeighbors(ArrayList<Cell> neighbors) {
        this.neighbors = neighbors;
    }

    public void setHasflag(boolean hasflag) {
        this.hasflag = hasflag;
    }

    public void setHasmine(boolean hasmine) {
        this.hasmine = hasmine;
    }        
    
    
    
}
