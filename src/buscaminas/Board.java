package buscaminas;

import java.util.ArrayList;
import java.util.Random;

public class Board {

    private ArrayList<Cell> cell;
    private int y;

    public Board(int x, int y, int minas) {
        this.y = y;
        int size = x * y;
        cell = new ArrayList();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                cell.add(new Cell(i, j));
            }
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                ArrayList<Cell> neighbors = new ArrayList();
                if (j - 1 >= 0) {
                    neighbors.add(cell.get((i) * y + j - 1));

                }
                if (j + 1 < y) {
                    neighbors.add(cell.get((i) * y + j + 1));

                }
                if (i + 1 < x) {
                    neighbors.add(cell.get((i + 1) * y + j));
                }
                if (i - 1 >= 0) {
                    neighbors.add(cell.get((i - 1) * y + j));
                }
                if ((j - 1 >= 0) && (i + 1 < x)) {
                    neighbors.add(cell.get((i + 1) * y + j - 1));

                }
                if ((j + 1 < y) && (i + 1 < x)) {
                    neighbors.add(cell.get((i + 1) * y + j + 1));

                }
                if (i - 1 >= 0 && j + 1 < y) {
                    neighbors.add(cell.get((i - 1) * y + j + 1));
                }
                if ((i - 1 >= 0) && (j - 1 >= 0)) {
                    neighbors.add(cell.get((i - 1) * y + j - 1));
                }
                Cell cellAux = cell.get(i * y + j);
                cellAux.setNeighbors(neighbors);
               // cellAux.setHasmine(new Boolean());
                
            }
        }
        Random random = new Random();
        ArrayList<Cell> lisAux = new ArrayList();
        for (int i = 0; i<minas; i++){
            Cell cellAux = cell.get(random.nextInt(x)*y+random.nextInt(y));
            while (lisAux.contains(cellAux)) cellAux = cell.get(random.nextInt(x)*y+random.nextInt(y));
            lisAux.add(cellAux);
            cellAux.setHasmine(true);
        }
    }

    public Cell getCell(int x, int y) {
        return cell.get(x * this.y + y);
    }
}
