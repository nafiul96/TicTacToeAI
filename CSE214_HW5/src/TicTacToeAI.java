/**
 * MD NAFIUL AZIM
 * ID: 110548047
 * @author nafi
 */

import java.util.Scanner;


public class TicTacToeAI {
    
    private static Box p1 = Box.X;
    private static Box p2 = Box.O;
    private static Box current;
    private static Scanner scan = new Scanner(System.in);
    private static GameTree tree = new GameTree();
    public static void main(String [] args){
    
    
        //GameTree.preOrder(tree.getRoot());
        
        playGame(tree);
        System.out.println("The Winner is " + GameTree.checkWin(tree.getCursor()));
        
    }
    
    public static void playGame(GameTree tree){
        
        boolean done = false;
        int input;
        current = p1;
        System.out.println(tree.getRoot().getBoard());
        while(!done){
           try{
            System.out.println("Please Make a Move: ");
            input = scan.nextInt();
            switch(input){
            
                case 1:
                    
                case 2:
                    
                case 3:
                    
                case 4:
                  
                case 5:
                   
                case 6:
                    
                case 7:
                    
                case 8:
                    
                case 9:
                    
                    tree.makeMove(input);
                    done = tree.getCursor().isIsEnd();
                    break;
                default:
                    System.out.println("Not an Option! Please Try agian with valid option!");
                    
            }
           }catch(Exception ex){
           
               System.out.println(ex.toString());
           }
        }
    
    }
    
    
}
