 public class Sudoku {
    public static boolean sudokuSolver(int sudoku [][] , int row  , int col){
        if(row==9){return true;}
        int nextrow=row; 
        int nextcol=col+1;
        if(col+1 ==9){
            nextrow=row+1;nextcol=0;
        }
        if(sudoku[row][col]!=0){
            return sudokuSolver(sudoku, nextrow, nextcol);
        }
        for(int digit=1;digit<=9 ;digit++){
             if(isSafe(sudoku, row, col, digit)){
                sudoku[row][col]=digit;
                if(sudokuSolver(sudoku, nextrow, nextcol)){
                    //solution exists
                    return true;
                }
                sudoku[row][col]=0;
             }
        }
        return false;
    }
    // Safe Function
    public static boolean isSafe(int matrx[][]  ,int row ,int col ,int num){
            for(int i=0;i<matrx.length;i++){
               if(matrx[row][i]==num){
                return false;
               }
            }
            for(int i=0;i<matrx.length;i++){
                if(matrx[i][col]==num){
                    return false;
                }
             }
            //  sr=starting row , sc=starting column
            int sr=(row/3)*3 , sc=(col/3)*3;
            for(int i=sr;i<=sr+2;i++){
                for(int j=sc;j<=sc+2;j++){
                    if(matrx[i][j]==num){return false;}
                }
            }
            return true;
    }





    
}
