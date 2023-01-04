

import java.util.Random;

/*
## Group members’ names and x500s
Jiatan Huang, huan2460
Ziyue Zhuang, zhuan203
 */
public class Board{
    private String[][] board;

    private int numBoats;
    private Battleboat[] boats;
    private Cell gameBoard[][];
    private int[] boatSizes;
    //add more:
    private String[][] viewBoard; //debugMode usage
    private boolean debugMode; //??
    private int row;
    private int col;
    private Cell[] cells;//to check un-sunk boat


    public Board(int mode){
        if (mode == 1){
            this.row =3;
            this.col =3;
            this.boatSizes = new int[] {2};
            this.board = new String[3][3];
            this.viewBoard = new String[3][3];
            this.numBoats = 1;
            this.boats = new Battleboat[numBoats];
            gameBoard = new Cell[3][3];
            for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++){
                    Cell newCell = new Cell(i,j,'-');
                    gameBoard[i][j] = newCell;//this is how Cell Class related to Board Class
                    board[i][j] ="-";
                    viewBoard[i][j] ="-";
                }
            }

        }
        else if (mode == 2){
            this.row =6;
            this.col =6;
            this.boatSizes = new int[] {2,3,4};
            this.board = new String[6][6];
            this.viewBoard = new String[6][6];
            this.numBoats = 3;
            this.boats = new Battleboat[numBoats];
            gameBoard = new Cell[6][6];
            for (int i = 0; i< 6; i++){
                for (int j = 0; j< 6; j++){
                    Cell newCell = new Cell(i,j,'-');
                    gameBoard[i][j] = newCell;
                    board[i][j] ="-";
                    viewBoard[i][j] ="-";
                }
            }
        }
        else if (mode == 3){
            this.row =9;
            this.col =9;
            this.boatSizes = new int[] {2,3,3,4,5};
            this.board = new String[9][9];
            this.viewBoard = new String[9][9];
            this.numBoats = 5;
            this.boats = new Battleboat[numBoats];
            gameBoard = new Cell[9][9];
            for(int i = 0; i<9; i++){
                for(int j = 0; j< 9; j++){
                    Cell newCell = new Cell(i,j,'-');
                    gameBoard[i][j] = newCell;
                    board[i][j] ="-";
                    viewBoard[i][j] ="-";
                }
            }
        }
    }



    public void placeBoats() {
        int count = 0;
        while (count < numBoats) {
            Battleboat newBoat = new Battleboat(boatSizes[count]);//the length of boat

            int test_row = (int) Math.floor(Math.random() * (row-1));
            int test_col = (int) Math.floor(Math.random() * (col-1));
            int oriRow = test_row;
            int oriCol = test_col;

            int countSpace = 0; //test whether the space followed the boat size

                if (newBoat.getOrientation() == false) {//vertical
                    for (int j = 0; j < newBoat.getSize(); j++) {
                        if (oriRow + newBoat.getSize() - 1 < board.length) {
                            if (gameBoard[oriRow + j][oriCol].getStatus() == '-') {
                                countSpace++;
                            }
                        }
                    }
                    if (countSpace == newBoat.getSize()) {// condition to make sure there are no other boats in that location
//Question
// setSpace : could contain 3 axes ?
// and how to do it
                        for (int j = 0; j < newBoat.getSize(); j++) {//finalizes and adds the cell objects to all the lists

                            gameBoard[oriRow + j][oriCol].setStatus('B');
                            viewBoard[oriRow + j][oriCol]="B";
                            //Cell[] c = new Cell[];
                            //cells[j] = gameBoard[oriRow + j][oriCol];
                            newBoat.setSpaces(j,gameBoard[oriRow + j][oriCol]);//modify
                            boats[count] = newBoat;//modify

                            //cells[count]= gameBoard[oriRow + j][oriCol];
                            //boats[count].setSpaces(cells);
                        }

                        count++;
                    }
                } else if (newBoat.getOrientation() == true) {//horizontal
                    for (int k = 0; k < newBoat.getSize(); k++) {
                        if (oriCol + newBoat.getSize() - 1 < board[0].length) {
                            if (gameBoard[oriRow][oriCol + k].getStatus() == '-') {
                                countSpace++;
                            }
                        }
                    }
                    if (countSpace == newBoat.getSize()) {
                        for (int k = 0; k < newBoat.getSize(); k++) {
                            gameBoard[oriRow][oriCol + k].setStatus('B');
                            viewBoard[oriRow][oriCol + k]="B";
                            //cells[k] = gameBoard[oriRow][oriCol + k];
                            newBoat.setSpaces(k,gameBoard[oriRow][oriCol+k]);
                            boats[count] = newBoat;

                            //cells[count]= gameBoard[oriRow][oriCol + k];
                            //boats[count].setSpaces(cells);
                        }

                        count++;
                    }
                }

            }

    }


    public int fire(int x, int y) {
        if((x<0||x>=this.row) || (y<0||y>=this.col)) {
            System.out.println("Penalty, out of the bound! And you will lose next turn!");
            return 2;
            // out of the bound
        }else if (gameBoard[x][y].getStatus()=='-') {
            gameBoard[x][y].setStatus('M');
            board[x][y] = "M";
            viewBoard[x][y] ="M";
            System.out.println("Miss");
            return 0;
//miss
        } else if (gameBoard[x][y].getStatus()=='B') {
                gameBoard[x][y].setStatus('H');
                board[x][y] = "H";
                viewBoard[x][y] ="H";
                System.out.println("Hit");
                return 1;
                //hit
        }else {
                System.out.println("Penalty, Redundant attack! And you will lose next turn!");
                return 3;
                //Redundant attack
        }
    }

    public int checkSunk(){
        int unsunk_count = 0;//unsunk number check
        int sunkBoat = 0;//sunk number check
        int count = 0;//cell check
        int boatSize = boats.length;
        boolean[] sunkBoatCheck =new boolean[boatSize];
        for(int k =0; k<boatSize;k++){
            sunkBoatCheck[k] = false;
        }

        for (int start=0; start<boatSize; start++) {
            int cell_check = 0;
            cells = boats[start].getSpaces();
            for (int check = 0; check < boats[start].getSize(); check++) {
                if (cells[check].getStatus() =='B') {
                    cell_check++;
                }

            }
            if (cell_check>=1){unsunk_count++;}
        }

        for(int i = 0; i<boatSize;i++){//number of boats we have

            cells = boats[i].getSpaces();//first boat's all axes
            for(int j = 0; j < boats[i].getSize(); j++) {
                //not equal 'B' means has sunk/hit
                if(cells[j].getStatus() != 'B'){
                    count++;
                }
            }
            // if all the position be hit ; the boat sunk
            if (count == boats[i].getSize()){
                if(sunkBoatCheck[i]=false){
                sunkBoat++;
                sunkBoatCheck[i] = true;
                }
            }

    }return unsunk_count;
    }


    public boolean gameEnds() {
        int countB = 0;
        for (int i = 0; i < viewBoard.length; i++) {
            for (int j = 0; j < viewBoard[0].length; j++) {
                if (viewBoard[i][j] == "B") {
                    countB++;
                }
            }
        }
        if (countB == 0) {
            System.out.println("All boats sunk, game ends");
            return true;
        } else {
            return false;
        }
    }
    public void display(){
        String str = "  ";
        for (int j = 0; j < row; j++){//framework
            str +=(j+1) + "|";
        }
        str +="\n";
        for(int i = 0; i< board.length; i++){
            str += i+1+"|";
            for(int j = 0; j < board[0].length;j++){
                str += board[i][j]+" " ;
                }
            str+="\n";
        }

        System.out.println(str);
    }

    public String print(){
        String pri="  ";
        for (int j = 0; j < row; j++){//framework
            pri +=(j+1) + "|";
        }
        pri +="\n";
        for(int i =0;i<row;i++){
            pri  += i+1+"|";
            for(int j=0;j<col;j++){
                pri +=viewBoard[i][j]+" ";
                //System.out.println(gameBoard[i][j]);
            }
            pri +="\n";
            //System.out.println("\n");
        }
        return pri;
        // System.out.println(pri);
    }


    }
