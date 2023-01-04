/*
## Group members’ names and x500s
Jiatan Huang, huan2460
Ziyue Zhuang, zhuan203
 */

public class Battleboat {
    private int size;
    private boolean orientation;
    private Cell[] spaces;// A Cell array representing the cells that a Battleboat is in.

    public Battleboat(int length){//the length of boats
        this.size = length;
        double random = Math.random();
        if(random >= 0.5){
            orientation = false;//vertical
        }
        else{
            orientation = true;//horizontal
        }
        this.spaces = new Cell[length];

    }

    public boolean getOrientation(){
        return orientation;

    }
    public Cell[] getSpaces(){
        return spaces;

    }
    public void setSpaces(int s,Cell cells){//comment
        spaces[s] = cells;//s stands for which boat I'm looking at

    }
    public int getSize(){
        return size;

    }

}
