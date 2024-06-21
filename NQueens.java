import java.util.ArrayList;
import java.util.List;
public class NQueens {


    boolean isSafe(char[][] board, int row, int col){
        //checking horizontally
        for(int j=0; j<board.length; j++){
            if(board[row][j] == 'Q'){
                return false;
            }
        }
        //cheking vertically
        for(int i=0; i<board.length; i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        //checking diagonally upoward left
        int i =  row;
        for(int j=col; i>0&&j>=0;i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }

        }
        //cheking diagonally downright right
        i=row;
        for(int j=col; i<board.length && j<board.length; i++,j++){
            if(board[i][j] == 'Q'){
                return false;
            }

        }
        //cheking diagonally upward rigt
        i=row;
        for(int j=col; i>=0 && j<board.length; i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        
        }
        //cheking diagonally downright left
        i=row;
        for(int j=col; i<board.length && j>=0; i++,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;

    }

    void nQueensHelper(char board[][], List<List<String>>allsoln, int col ){
        if(col == board.length){
            //sav the board_solution to allsoln List
            return;
        }
        for(int row=0; row<board.length; row++){
            if(isSafe(board,row,col)){
                board[row][col] = 'Q';
                nQueensHelper(board, allsoln, col+1);
                board[row][col] = '.';
            }
        
    }
}
    public static void main(String[] args) {
        char board[][] = new char[4][4];
        NQueens nq = new NQueens();
        List<List<String>> allsoln = new ArrayList<>();
        nq.nQueensHelper(board, allsoln, 0);



    }
    
}
