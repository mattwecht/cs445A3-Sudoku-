package cs445.a3;

import java.util.List;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Sudoku {    
    
    /**
     * holds sample boards to be used in test cases
     * @param choice which board to use
     * @return the test board and line describing it
     */
    static int[][] sampleBoards(int choice){
        int [][] test;
        switch (choice){
            case 1:
                test = new int[][] {
                {3,9,1,2,8,6,5,7,4},
                {4,8,7,3,5,9,1,2,6},
                {6,5,2,7,1,4,8,3,9},
                {8,7,5,4,3,1,6,9,2},
                {2,1,3,9,6,7,4,8,5},
                {9,6,4,5,2,8,7,1,3},
                {1,4,9,6,7,3,2,5,8},
                {5,3,8,1,4,2,9,6,7},
                {7,2,6,8,9,5,3,4,1}
                };//test array
                System.out.println("Testing board that is completed");
                System.out.println("********");
                printBoard(test);
                return test;
            case 2:
                test = new int[][] {
                    {3,9,1,2,8,6,5,7,4},
                    {4,8,7,3,5,9,1,2,6},
                    {6,5,2,7,1,4,8,3,9},
                    {8,7,5,4,3,1,6,9,2},
                    {2,1,3,9,6,7,4,8,5},
                    {9,6,4,5,2,8,7,1,3},
                    {1,4,9,6,7,3,2,5,8},
                    {5,3,8,1,4,2,9,6,7},
                    {3,2,6,8,9,5,3,4,1}
                };//test array2
                System.out.println("testing board that is not complete but not blank");
                System.out.println("********");
                printBoard(test);
                return(test);
            case 3:
                test = new int[][] {
                    {0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0},
                };//test array3 
                System.out.println("testing board that is blank");
                 System.out.println("********");
                printBoard(test);
                return(test);
            case 4:
                test = new int[][] {
                    {1,2,3,4,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0},
                };//test array 4
                System.out.println("testing board with 4 numbers");
                System.out.println("********");                
                printBoard(test);
                return (test);
            case 5:
                test = new int[][] {
                    {-1,-2,-3,-4,0,0,0,0,0},
                    {0,0,0,0,-5,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0},
                };//test array 5
                System.out.println("testing board with 5 numbers, so that adding 1 to next blank will not work");
                printBoard(test);
                System.out.println("********");
                return (test);
            case 6:
                test = new int[][] {
                    {1,2,3,4,4,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0},
                };//test array 6
                System.out.println("testing board with the same number in a row");
                printBoard(test);
                System.out.println("********");
                return (test);
                
            case 7:
                test = new int[][] {
                    {1,2,3,4,5,6,7,8,9},
                    {1,2,3,4,5,6,7,8,9},
                    {1,2,3,4,5,6,7,8,9},
                    {1,2,3,4,5,6,7,8,9},
                    {1,2,3,4,5,6,7,8,9},
                    {1,2,3,4,5,6,7,8,9},
                    {1,2,3,4,5,6,7,8,9},
                    {1,2,3,4,5,6,7,8,9},
                    {1,2,3,4,5,6,7,8,0},
                };//test array 7
                System.out.println("testing board with the with last number blank");
                printBoard(test);
                System.out.println("********");
                return (test);
            case 8:
                test = new int[][] {
                    {1,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0},
                };//test array8 
                System.out.println("testing board with one number");
                 System.out.println("********");
                printBoard(test);
                return(test);
            case 9:
                test = new int[][] {
                    {0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,1,2,3,4,5},
                };//test array9 
                System.out.println("testing board with filled with a few in the bottom ");
                 System.out.println("********");
                printBoard(test);
                return(test);
           case 10:
                test = new int[][] {
                    {-1,-2,-3,-4,-5,-6,-7,-8,-9},
                    {-1,-2,-3,-4,-5,-6,-7,-8,-9},
                    {-1,-2,-3,-4,-5,-6,-7,-8,-9},
                    {-1,-2,-3,-4,-5,-6,-7,-8,-9},
                    {-1,-2,-3,-4,-5,-6,-7,-8,-9},
                    {-1,-2,-3,-4,-5,-6,-7,-8,-9},
                    {-1,-2,-3,-4,-5,-6,-7,-8,-9},
                    {-1,-2,-3,-4,-5,-6,-7,-8,-9},
                    {-1,-2,-3,-4,-5,-6,-7,-8,-9},
                };//test array10
                System.out.println("testing board with filled all preplaced numbers ");
                 System.out.println("********");
                printBoard(test);
                return(test);
        }
        return null;
    }
    /**
     * changes result in to a 3 by 3 segment of board (as a 1d array)
     * @param board the full 9 by 9 board
     * @param result the 3 by 3 array to be filled
     * @param x starting spot
     * @param y starting spot 
     */
    static void get3by3 (int [][]board, int [] result, int x, int y){
        int count =0;
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                result[count] = board[3*x +i][3*y+j];
                count++;
            }
        }
    }
     /**
     * returns true if board is complete and valid, false otherwise
     * @param partial The partial solution
     * @return true if the partial solution is complete and valid, false otherwise.
     */
    static boolean isFullSolution(int[][] board) {
        //check if all numbers are placed on the board
         for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
               if(board[i][j] == 0)//if anything is blank (0) than board is not full
                    return false;
            }
        }
        //if all numbers are on the board is it correct
        if (reject(board)) {
            return false;
        }
        // everything is correct
        return true;
    }

    /**
     * Checks if input can ever be extended 
     * @param board The partial solution
     * @return true if it should be rejected, false otherwise.
     */
    static boolean reject(int[][] board) {
        int flag = 0;
        // Check each colum to see if it contains a number twice 
         for (int row2 = 0; row2 < 9; row2++){//loop through the rows
            for (int col = 0; col < 9; col++){//loop through colums in that row
                int num = Math.abs(board[row2][col]);//temp matching var 
                    for (int otherCol = col + 1; otherCol < 9; otherCol++){//loops through other colum with the temp
                        if(num != 0){//to avoid matching blank spots with blank spots
                            if (num == Math.abs(board[row2][otherCol])){//if match found
                                return true;
                            }
                        }
                    }
            }
        }
        //check for doubles in a row 
         for (int row3 = 0; row3 < 9; row3++){
            for (int col = 0; col < 9; col++){
                int num = Math.abs(board[row3][col]);
                    for (int otherrow = row3 + 1; otherrow < 9; otherrow++){
                        if(num!=0){
                            if (num == Math.abs(board[otherrow][col])){
                                return true;                                
                            }
                        }
                    }
            }
        }
        
        //check for doubles in the 3 by 3 segment 
        int result []= new int[9];//new 9 int array for the 3 by 3 segment
        for(int a=0;a<3;a++){
                for( int b=0;b<3;b++){
                    get3by3(board,result,a,b);//makes result the 3 by 3 segment 
                    //test if 3 by 3 has any repeats 
                    for(int i=0; i<8; i++){
                        for(int u = i+1; u <9; u++){
                            if(result[u]!= 0){
                                if(Math.abs(result[u])==Math.abs(result[i])&& i!=u)
                                    return true;//if there is a double value in the three by three
                            }
                        }               
                    }
                }
        }
        for(int a =0; a<9; a++){//tests for blank board
            for(int b=0; b<9; b++){
                if(board[a][b]!=0)//if there is a non zero
                    flag++;
            }
        }
        if(flag<=2)//if one or more numbers
            return true;//reject because all blank or only 1 num
        // There was no conflict thus should not reject this board
        return false;
    }

    /**
     * adds one new number to the board in a legal move
     * @param board the partially completed board
     * @return a new partially completed board with one more number added on, null if no number can be added
     */
    static int[][] extend(int[][] board) {
        int[][] tempBoard = new int[9][9];// Initialize the new board
        boolean swap = false;
        
        for (int i = 0; i < 9; i++) {
            for(int j = 0; j<9; j++){
            if (board[i][j] != 0 || swap) {//if blank spot and no swap has occured
                // Copy each number already on the board
                tempBoard[i][j] = board[i][j];
            } else {
                // Add a number in 
                tempBoard[i][j] = 1;
                swap = true;
                }
            }
        }
        /*
        while(reject(tempBoard)){//while the board is incorrect it will increment the number by one
            tempBoard[row][colum]++;
            if(tempBoard[row][colum]>9)
                return null;//this number cant be added 
        }
        */
        if(swap)
            return tempBoard;
        else
            return null;//if no number was added to the board thus return null
    }

    /**
     * changes most recent number to next legal number
     * @param board the partial completed board
     * @return a board with the last number changed to its next legal number or null if no options are next
     */
    static int[][] next(int[][] board) {
        int row =0, colum = 0, i =8, j =8;
        boolean wasBroke = false;
        
        if(isFullSolution(board)){
           return null;//return null if board is done
        }
        int[][] tempBoard = new int[9][9];//creates temp board to be altered
        boolean flag = true;//used to check if next number is legal

        for (int a = 0; a < 9; a++) { //copies board into the new array
            System.arraycopy(board[a], 0, tempBoard[a], 0, 9);
        }
      
        //find the first positive number increments it by one
        for(i =8; i>-1; i--){
            for(j= 8; j>-1; j--){
                if(tempBoard[i][j]>=9){
                    tempBoard[i][j]=0;//resets 9 to zero to backtrack
                }
                if(tempBoard[i][j]>0){//if it finds a positive then increment
                         tempBoard[i][j]+=1;//add one to the value
                         row =i;
                         colum =j;
                         wasBroke = true;
                         break;
                     }
                }
            if(wasBroke)
                break;
            }
        /*      
        while(flag){//while true tries to increment last spot by one until legal or to big
           if(!reject(tempBoard))//if the board is viable return it
                return tempBoard;
            tempBoard[row][colum] += 1;//moves the last position up one number if under 9
            if(tempBoard[row][colum]>=9)
                return null;//if number goes over 9 than it is invalid 

        }//end while loop */
        if(!flag){
            return null;
        }
        return tempBoard;//returns null if board cant be corrected
    }

    static void testIsFullSolution() {
        System.out.println("Testing isFullSolution() with 1 correct test board");        
        testIsFullSolution(sampleBoards(1));//runs test
        System.out.println();//new line
        
        System.out.println("testing with incorrect full board");
        testIsFullSolution(sampleBoards(2));//runs test again
        System.out.println();
        
        System.out.println("testing with empty board");
        testIsFullSolution(sampleBoards(3));
        
        System.out.println("testing with partially filled board");
        testIsFullSolution(sampleBoards(4));
        
        System.out.println("testing with board partially filled from bottom");
        testIsFullSolution(sampleBoards(9));
    
    }
    /**
     * test the isFullSolution method with a given board
     * @param test board to be tested 
     */
    static void testIsFullSolution(int[][] test){
        if(isFullSolution(test)){
            System.out.println("The board printed above is correct: ");
        }
        else{
            System.out.println("the above board is not complete");
        }
    }

    static void testReject() {
        System.out.println("This board should not be rejected");
        System.out.println(reject(sampleBoards(1)) +"\n");
        
        System.out.println("This board should be rejected");
        System.out.println(reject(sampleBoards(2))+"\n");
        
        System.out.println("this board is blank");
        System.out.println(reject(sampleBoards(3))+ "\n");
        
        System.out.println("This board should return flase as nothing is wrong");
        System.out.println(reject(sampleBoards(4))+ "\n");
        
        System.out.println("This board should be rejected");
        System.out.println(reject(sampleBoards(6))+ "\n");
        
        System.out.println("This board has one number and should be rejected");
        System.out.println(reject(sampleBoards(8))+ "\n");
    }

    static void testExtend() {
        int [][] test = extend(sampleBoards(3));
        System.out.println("the first position can be extended \n");
        printBoard(test);
        
        test = extend(sampleBoards(5));
        System.out.println("next number should be 1 \n");
        printBoard(test);
        
        test = extend(sampleBoards(7));
        System.out.println("the last number should be 1 \n");
        printBoard(test);
        
        test=extend(sampleBoards(10));
        System.out.println("this board can not be extended");
        printBoard(test);
    }

    static void testNext() {
        int[][] test = next(sampleBoards(1));
        System.out.println("Testing next() with completed board (should return null)");
        printBoard(test);
        
        test = extend(sampleBoards(5));
        System.out.println("testing next() with board that has 1 added to position [0][4], it should be 6");
        printBoard(next(test));
        
        test = extend(sampleBoards(3));
        System.out.println("testing next() with board that was blank");
        printBoard(next(test));
        
        test = extend(sampleBoards(10));
        System.out.println("testing next() with board that was all prefilled");
        printBoard(next(test));       
        
    }

    static void printBoard(int[][] board) {
        if (board == null) {
            System.out.println("No assignment");
            return;
        }
        for (int i = 0; i < 9; i++) {
            if (i == 3 || i == 6) {
                System.out.println("----+-----+----");
            }
            for (int j = 0; j < 9; j++) {
                if (j == 2 || j == 5) {
                    System.out.print(Math.abs(board[i][j]) + " | ");
                } else {
                    System.out.print(Math.abs(board[i][j]));
                }
            }
            System.out.print("\n");
        }
    }

    static int[][] readBoard(String filename) {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(filename), Charset.defaultCharset());
        } catch (IOException e) {
            return null;
        }
        int[][] board = new int[9][9];
        int val = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                try {
                    val = Integer.parseInt(Character.toString(lines.get(i).charAt(j)));
                } catch (Exception e) {
                    val = 0;
                }
                board[i][j] = val*-1;
            }
        }
        return board;
    }

    static int[][] solve(int[][] board) {
        if (reject(board)){
            return null;
        }
        if (isFullSolution(board)) return board;
        int[][] attempt = extend(board);
        while (attempt != null) {
            int[][] solution = solve(attempt);
            if (solution != null) return solution;
            attempt = next(attempt);
        }
        return null;
    }

    public static void main(String[] args) {
        
        if (args[0].equals("-t")) {
            testIsFullSolution();
            testReject();
            testExtend();
            testNext();
        } else {
            int[][] board = readBoard(args[0]);
            System.out.println("This is the board being read in: ");
            printBoard(board);
            System.out.println("*******************");
            System.out.println("this is the solved board");
            printBoard(solve(board));
        }
        //testIsFullSolution();
        //testExtend();
        //testNext();
        //testReject();
        //int[][] board = readBoard(args[0]);
        //printBoard(board);
        //System.out.println(reject(board));
    }
    
}
