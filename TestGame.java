/*
## Group members’ names and x500s
Jiatan Huang, huan2460
Ziyue Zhuang, zhuan203
 */
import java.util.Scanner;
public class TestGame {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Type in a number to choose the mode of this game: ");
        int Mode = myScanner.nextInt();
        Board BB = new Board(Mode);
        Cell CC = new Cell();
        //Battleboat BT = ;

        BB.placeBoats();
        BB.display();
        //System.out.println(BB.print()); //debug mode

        System.out.println("Do you want to use debug mode? (Type yes/no)");
        String debugChoice = myScanner.next();

        if(debugChoice.equals("yes")){
            System.out.println(BB.print());//debug mode
        }
        //1·after selecting the difficulty;
        // 2 - randomly setting the BOAT position.
        //3-Randomly set the cmu position.
        //4-starting the game.

        //5·checkWin
//        while(B.checkSunk()==false){
//
//        }
        //Q：which class to attack；
        //B.fire(int x, int y);



        int turn =1;
        int retBoat = BB.checkSunk();
        System.out.println("There are " +retBoat+" boats are placed on the board when the game begins!");
        while(BB.gameEnds()==false) {
            Scanner pointScanner = new Scanner(System.in);
            System.out.println("Which row would you like the boat to be?");
            int r = pointScanner.nextInt() - 1;
            System.out.println("Which col would you like the boat to be?");
            int c = pointScanner.nextInt() - 1;

            System.out.print("Turn "+turn + ": ");

            // attack； and it will tell "hit/miss"
            int result = BB.fire(r,c);
            if(result==2 || result==3 ){
                //out of bound || redundant attack
                turn++;
                System.out.println("Turn "+turn + ": "+"skipped!!");

                }

            System.out.println("unsunk boat: "+ BB.checkSunk());
            if(BB.checkSunk()<retBoat){
                System.out.println("Sunk!");
                retBoat--;
               // turn++;}
                }
            BB.display();
            if(debugChoice.equals("yes")){
                System.out.println(BB.print());//debug mode
            }

            turn++;
    }
}
}


