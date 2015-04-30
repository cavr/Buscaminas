
package buscaminas;


public class Main {
    public static void main(String args[]){    
        Start start = new Start();
        GameOptions gameOptions = new GameOptions(start.getStartListener());        
    }
    
}
