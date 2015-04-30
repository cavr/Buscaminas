/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas;

/**
 *
 * @author carlos
 */
public interface CellListener {
    public void doMine();
    public void doWin(int i);
    public void doFlag();

    public void disable();
    
}
