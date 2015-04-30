
package buscaminas;

public class gameStats {
    private int mines;
    private int push;
    private int size;
    private FinishGame finish;
    StatListener listener = new StatListener() {

        @Override
        public void hasGame() {
            count();
        }
    };    
    public gameStats(int mines, int size, FinishGame finish) {
        this.mines = mines;
        this.size = size;
        this.finish = finish;
    }

    public StatListener getListener() {
        return listener;
    }
    private void count(){
        System.out.println(Integer.toString(mines));
        push++;        
        if(size - push == mines) finish.winGame();
        else System.out.print(push + "Pulsacions " + mines + " Minas");
    }
    
    
}
