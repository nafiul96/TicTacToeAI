/**
 * MD NAFIUL AZIM
 * ID: 110548047
 * @author nafi
 */
public class GameTree {

     GameBoardNode root;
    private GameBoardNode cursor;

    public GameTree() {

        // root = new GameBoardNode(Box.);
        GameBoard temp = new GameBoard();
        root = buildTree(new GameBoardNode(temp,Box.EMPTY),Box.X);
        cursor = root;
    }

    public void makeMove(int position) throws IllegalArgumentException {

        if (position < 0 || position > 9) {

            throw new IllegalArgumentException();
        } else {

            if(cursor.isIsEnd()){
            }else{
            cursor = cursor.getConfig()[position-1];
            
            cursor.setProbability();
           if(!cursor.isIsEnd()){
            cursor = cursor.getConfig()[cursor.bestMove()];
            cursor.setProbability();
           }
            System.out.println(cursor.getBoard());
            System.out.println("Winning prob: " +cursor.getWinProb());
            System.out.println("Losing prob: " +cursor.getLoseProb());
            System.out.println("Draw prob: " +cursor.getDrawProb());
            }
        }
    }

    public static GameBoardNode buildTree(GameBoardNode root, Box turn) {

            if (root.winning()) {
                root.setWinner(root.getCurrentTurn());
                root.setIsEnd(true);
                return root;
            } else if (root.isFull()) {
                root.setWinner(Box.EMPTY);
                root.setIsEnd(true);
                return root;
            }else {

            for (int i = 0; i < 9; i++) {

                if (root.getBoard().getBoard()[i] == Box.EMPTY) {
                    
                    GameBoard temp = root.getBoard().clone();
                    temp.getBoard()[i] = turn;
                    
                    root.getConfig()[i] = buildTree(new GameBoardNode(temp,turn), invert(turn));
                    //System.out.println("here!" + i);
                }
            }
            
            return root;
        }
        
    }
    
    public static Box invert(Box b){
    
        if(b == Box.O){
        
            return Box.X;
        }
        return Box.O;
    }

    public static Box checkWin(GameBoardNode node) {

        return node.getWinner();
    }

    public double cursorProbability() {

        return -2;
    }

    public static void preOrder(GameBoardNode root){
    
        System.out.println(root.getBoard());
        for(int i=0 ; i<9; i++){
        
            if(root.getConfig()[i] != null){
            
                preOrder(root.getConfig()[i]);
            }
        }
    }
    
    public GameBoardNode getRoot(){
    
        return root;
    }

    public GameBoardNode getCursor() {
        return cursor;
    }

    public void setCursor(GameBoardNode cursor) {
        this.cursor = cursor;
    }
    
    
    
}
