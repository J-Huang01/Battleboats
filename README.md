CSCI 1933 
Project2: Battleboats
3/2/2022

## Group members’ names and x500s
Jiatan Huang, huan2460
Ziyue Zhuang, zhuan203

---

## Contributions of each partner (if working with a partner)

### Classes we created and edited:

• Board.java (Ziyue, Jiatan)
• Battleboat.java (Ziyue, Jiatan)
• Cell.java (Ziyue, Jiatan)
• TestGame.java (Ziyue, Jiatan)

We collaborated on most of the work and discussed the details. Also the teaching assistant gave us some help.

---

## How to compile and run your program

Using the run function that comes with intelliJ, the main method is in TestGame class. 

At the beginning of the game, the player should choose the difficulty level.
1 is the Beginner mode, 2 is the Intermediate mode, 3 is the Expert mode

Then will ask the player whether use the debug mode, when choose yes, choose the debug mode, you can view all status on the board.

Each turn the player should input a location in x, y coordinates to attack boats on the board, each attack will print a result. When the cell has been guessed, and boat present, the status change to "H", when the cell has been guessed, but no boat present, the status change to "M".

When the full coordinates of a boat are hit, will print "Sunk".

When the last boat has sunk, the game ends.

 ## Any assumptions 
1. We modified the original getSpace method in Battleboat class

public void setSpaces(int s,Cell cells){
        spaces[s] = cells;//s stands for which boat I'm looking at

2. We use private Cell gameBoard[][];
instead of private Cell[][] board;

3. We use public String print() which returns a String, that's used in debug mode

Issac Benson can guarantee our changes, and he thinks it's a good try and is doable.


---

## Additional features that you implemented (if applicable)
1. We create a method called public int checkUnsunk() to return the number of unsunk boats, that helps us to find the sunk boat

2. We create a method called public boolean gameEnds(), which returns a boolean number to help us check when the game ends.

---

## Any known bugs or defects in the program


--- ## Any outside sources (aside from course resources) consulted for ideas used in the project, in the format: We do not use any outside sources.

Statement: I certify that the information contained in this README file is complete and accurate. I have both read and followed the rules described in the “Course Policies” section of the course syllabus. (Jiatan Huang, Ziyue Zhuang)

---