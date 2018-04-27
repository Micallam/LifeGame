package game.domain;

public class Cell{
    private boolean alive;
    private int x, y;

    Cell(Boolean isAlive, int x, int y){
        this.setAlive(isAlive);
        this.x = x;
        this.y = y;
    }

    public void setAlive(boolean alive){
        this.alive = alive;
    }

    public boolean isAlive(){
        return alive;
    }

    public Cell copyCell(){
        return new Cell(alive, x, y);
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void changeState(int neighboursCount){
        if(alive){
            if(neighboursCount<2 || neighboursCount>3) alive=false;
        }
        else{
            if(neighboursCount==3) alive=true;
        }
    }
}