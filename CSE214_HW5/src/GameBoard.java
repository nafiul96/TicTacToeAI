/**
 * MD NAFIUL AZIM
 * ID: 110548047
 * @author nafi
 */
public class GameBoard {

    private Box[] board;
    private final int boardSize = 9;

    public GameBoard() {
        this.board = new Box[boardSize];
        for (int i = 0; i < board.length; i++) {

            board[i] = Box.EMPTY;
        }
    }

    public void setBoardPosition(Box b, int index) {

        board[index - 1] = b;
    }

    public GameBoard clone() {

        GameBoard temp = new GameBoard();
        for (int i = 0; i < this.boardSize; i++) {

            temp.board[i] = this.board[i];
        }
        return temp;
    }

    public Box[] getBoard() {
        return board;
    }

    public void setBoard(Box[] board) {
        this.board = board;
    }

    public String toString() {

        String s = "Game Board: \n";
        for (int i = 0; i < 9; i++) {

            if (i % 3 == 0) {

                if(this.board[i] == Box.EMPTY){
                
                    s += "\n|" + (i+1) + "|";
                }else{
                s += "\n|" + this.board[i] + "|";
                }
            } else {

                if(this.board[i] == Box.EMPTY){
                    
                    s += "|" + (i+1) + "|";
                }else{
                    
                s += "|" + this.board[i] + "|";
                }
            }
        }
        return s;
    }

}
