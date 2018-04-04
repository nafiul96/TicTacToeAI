
/**
 * MD NAFIUL AZIM
 * ID: 110548047
 *
 * @author nafi
 */
public class GameBoardNode {

    private GameBoard board;
    private boolean isEnd;
    private Box currentTurn;
    private Box winner;
    private GameBoardNode config[];
    private double winProb, loseProb, drawProb;

    public GameBoardNode(GameBoard board, Box currentTurn) throws IllegalArgumentException {

        this.board = board;
        this.currentTurn = currentTurn;
        config = new GameBoardNode[9];

    }

    public static int countLeaves(GameBoardNode node) {
        if (node == null) {
            return 0;
        }
        if (node.isEnd) {
            return 1;
        } else {
            return countLeaves(node.config[0]) + countLeaves(node.config[1]) + countLeaves(node.config[2])
                    + countLeaves(node.config[3]) + countLeaves(node.config[4]) + countLeaves(node.config[5])
                    + countLeaves(node.config[6]) + countLeaves(node.config[7]) + countLeaves(node.config[8]);
        }
    }

    

    public static int winningLeaves(GameBoardNode node) {
        if (node == null) {
            return 0;
        } else if (node.isWinning(Box.O)) {
            // System.out.println("entered!");
            return 1;
        } else {
            return winningLeaves(node.config[0]) + winningLeaves(node.config[1]) + winningLeaves(node.config[2])
                    + winningLeaves(node.config[3]) + winningLeaves(node.config[4]) + winningLeaves(node.config[5])
                    + winningLeaves(node.config[6]) + winningLeaves(node.config[7]) + winningLeaves(node.config[8]);
        }
    }

    public static int drawLeaves(GameBoardNode node) {
        if (node == null) {
            return 0;
        } else if (!node.winning() && node.isFull()) {
            // System.out.println("entered!");
            return 1;
        } else {
            return drawLeaves(node.config[0]) + drawLeaves(node.config[1]) + drawLeaves(node.config[2])
                    + drawLeaves(node.config[3]) + drawLeaves(node.config[4]) + drawLeaves(node.config[5])
                    + drawLeaves(node.config[6]) + drawLeaves(node.config[7]) + drawLeaves(node.config[8]);
        }
    }

    public int bestMove() {

        
        int k = 0;
        for (int i = 0; i < config.length; i++) {

            if (config[i] != null) {

                k = i;
                break;
            }
        }
        config[k].setProbability();

        for (int i = k + 1; i < config.length; i++) {

            if (config[i] != null) {
                
                if(config[i].isWinning(Box.X)){
                    System.out.println("Entered!");
                    k=i;
                    config[i].setProbability();
                    return k;
                }else{
                    config[i].setProbability();
                if ((config[i].winProb > config[k].winProb) /* || (config[i].drawProb<config[i].loseProb)*/) {

                    k = i;
                }
                }
            }
        }

        return k;
    }
    public boolean winning() {

        return isWinning(Box.X) || isWinning(Box.O);
    }

    
    
    
    public boolean isWinning(Box turn) {

        if (board.getBoard()[0] == turn && board.getBoard()[1] == turn && board.getBoard()[2] == turn) {

            return true;
        } else if (board.getBoard()[3] == turn && board.getBoard()[4] == turn && board.getBoard()[5] == turn) {

            return true;
        } else if (board.getBoard()[6] == turn && board.getBoard()[7] == turn && board.getBoard()[8] == turn) {

            return true;
        } else if (board.getBoard()[0] == turn && board.getBoard()[3] == turn && board.getBoard()[6] == turn) {

            return true;
        } else if (board.getBoard()[0] == turn && board.getBoard()[4] == turn && board.getBoard()[8] == turn) {

            return true;
        } else if (board.getBoard()[1] == turn && board.getBoard()[4] == turn && board.getBoard()[7] == turn) {

            return true;
        } else if (board.getBoard()[2] == turn && board.getBoard()[5] == turn && board.getBoard()[8] == turn) {

            return true;
        } else if (board.getBoard()[2] == turn && board.getBoard()[4] == turn && board.getBoard()[6] == turn) {

            return true;
        } else {

            return false;
        }
    }

    public Box getInverseTurn() {

        if (currentTurn == Box.X) {

            return Box.O;
        }

        return Box.X;
    }

    public boolean isFull() {

        for (int i = 0; i < 9; i++) {

            if (board.getBoard()[i] == Box.EMPTY) {

                return false;
            }
        }

        return true;
    }

    public GameBoard getBoard() {
        return board;
    }

    public boolean isIsEnd() {
        return isEnd;
    }

    public void setIsEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }

    public Box getCurrentTurn() {
        return currentTurn;
    }

    public Box getWinner() {
        return winner;
    }

    public void setWinner(Box winner) {
        this.winner = winner;
    }

    public GameBoardNode[] getConfig() {
        return config;
    }

    public double getWinProb() {
        return winProb;
    }

    public double getLoseProb() {
        return loseProb;
    }

    public double getDrawProb() {
        return drawProb;
    }

    public void setProbability() {
        double total = (float) GameBoardNode.countLeaves(this);
        double win = (float) GameBoardNode.winningLeaves(this);
        double draw = (float) GameBoardNode.drawLeaves(this);
        double lose = total - (float) (win + draw);
        this.winProb = win / total;
        this.loseProb = lose / total;
        this.drawProb = draw / total;

    }

}
