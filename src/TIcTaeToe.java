import java.util.Scanner;
class TicTaeToe {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Player 1, Whats your name?");
        String p1 = in.nextLine();
        System.out.println("Player 2, Whats your name?");
        String p2 = in.nextLine();
        //3*3 ticktacktoe board
        //-- empty spaces
        //x player1
        //o player2
        char[][] board = new char[3][3];
        //fill board with dashes
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';

            }
        }
        // keep track of the turn
        boolean isPlayer1 = true;
        //keep track of game has ended
        boolean gameEnded=false;
        while (!gameEnded){
//Draw the board
            drawBoard(board);
            // keep track of the turn
           // boolean isPlayer1 = true;
            //keep track of symbol
            char symbol = ' ';
            if (isPlayer1) {
                symbol = 'x';
            } else {
                symbol = '0';
            }
            if (isPlayer1) {
                System.out.println(p1 + " 's Turn(x)");
            } else {
                System.out.println(p2 + " 's Turn(o)");
            }
            int row = 0;
            int col = 0;
            while (true) {


    //get row n column from user
                System.out.println("Enter a row (0, 1, or 2):");
                row = in.nextInt();
                System.out.println("Enter a col (0, 1, or 2):");
                col = in.nextInt();

                // check if row and col are valid
                if (row < 0 || col < 0 || row > 2 || col > 2) {
                    System.out.println("Your Row and column are out of board");

                } else if (board[row][col] != '-') {
                    System.out.println("Someone has already made a move there");

                } else {
                    break;
                }
            }
    // setting up the position on the board to the player symbol
            board[row][col] = symbol;
            //drawBoard(board);
    // check if player has won
            if (hasWon(board) == 'x') {
                //Player 1 has won
                System.out.println(p1 + " has won!");
                gameEnded=true;
            } else if (hasWon(board) == 'o') {
                System.out.println(p2 + " has won!");
                gameEnded=true;
            } else {
                //nobody has won
                if (hasTied(board)) {
                    System.out.println("Its a tie");
                } else {
                    //continue the game and toggles the turn
                isPlayer1 = !isPlayer1;
                }
            }
            }
        drawBoard(board);
    }

    public static void drawBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static char hasWon(char[][] board) {
        //Row
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
                return board[i][0];
            }
        }
        //col
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != '-') {
                return board[0][j];
            }
        }
        // Diagnosis
        if(board[0][0]== board[1][1] && board[1][1]==board[2][2] && board[0][0]!= '-') {
            return board[0][0];
        }
        if (board[2][0]== board[1][1] && board[1][1]==board[0][2] && board[2][0] != '-') {
            return board[2][0];
        }
        //nobody won
        return '-';
    }
    // check if board is full
    public static boolean hasTied(char[][] board) {
        for(int i=0;i<3;i++) {
            for (int j=0;j<3;j++) {
                if(board[i][j]=='-') {
                    return false;
                }
            }
        }
        return true;

    }
}



