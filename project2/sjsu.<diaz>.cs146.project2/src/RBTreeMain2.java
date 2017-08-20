/**
 * RedBlackTree: RBTreeMain
 * @author Paul Diaz
 * CS 146
 * Prof. Potika
 */
import java.util.Scanner;


public class RBTreeMain2 {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        RedBlackTree tree = new RedBlackTree();

        String choice;
        boolean done = true;
      
        while(done){
            System.out.println("Enter 1 addNode, 2 printTree, 3 getSibling,");
            System.out.println("Enter 4 getAunt, 5 getGrandParent,");
            System.out.print(  "Enter 0 to quit: ");
            choice = input.nextLine();
            int choice2 = Integer.parseInt(choice);
                switch(choice2){
                    case 1:
                        System.out.print("Enter value: ");
                        String value1 = input.nextLine();
                        tree.insert(value1);
                        break;
                    case 2:
                        tree.printTree(tree.getRoot());
                        break;
                    case 3:
                        System.out.print("Enter value: ");
                        String value3 = input.nextLine();
                        
                        try{
                            if(tree.sibling(value3) == null){
                                System.out.println("No sibling");
                            }else{
                                System.out.println(tree.sibling(value3).printNode());
                            }
                        }catch(NullPointerException ex){
                            System.out.println("No sibling");
                        }
                        break;
                    case 4:
                        System.out.print("Enter value: ");
                        String value4 = input.nextLine();
                        try{
                            if(tree.aunt(value4) == null){
                                System.out.println("No aunt");
                            }else{
                                System.out.println(tree.aunt(value4).printNode());
                            }
                        }catch(NullPointerException ex){
                            System.out.println("No aunt");
                        }
                        break;
                    case 5:
                        System.out.print("Enter value: ");
                        String value5 = input.nextLine();
                        try{
                            if(tree.grandParent(value5) == null){
                                System.out.println("No grandParent");
                            }else{
                                System.out.println(tree.grandParent(value5).printNode());
                            } 
                        }catch(NullPointerException ex){
                            System.out.println("No grandParent");
                        }
                        break;
                    case 0:
                        done = false;
                        break;
                }
                System.out.println();
        }
        System.out.println("\nThank you.");
        System.out.println("Programmed by: Paul Diaz");
    }   
}
