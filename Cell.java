/*
## Group members’ names and x500s
Jiatan Huang, huan2460
Ziyue Zhuang, zhuan203
 */

public class Cell {
//contain information about its location and status.
    private int row;
    private int col;
    private char status;//show the status of the Cell(being guessed or boat present)

    // "-" has not been guessed, no boat present
    // "b" has not been guessed, boat present
    // "h" has been guessed, boat present
    // "m" has been guessed, no boat present
    public Cell() {
    }

    public Cell(int row, int col, char status){
        this.row = row;
        this.col = col;
        this.status = '-';

    }
    public char getStatus(){
        return status;

    }
    public void setStatus(char c){
        status = c;

    }
    public int getRow(){
        return row;

    }
    public int getCol(){
        return col;

    }

}
