/**
 * RedBlackTree: RBTreeMain
 * @author Paul Diaz
 * CS 146
 * Prof. Potika
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class RBTreeMain {
    public static void main(String[]args) throws IOException{
        RedBlackTree rbt = new RedBlackTree();
        String line;
        File file = new File("dictionary.txt");
        if(file.exists()){
            try{
                Scanner scan = new Scanner(file);
                int temp = 0;
                
                if(file.length() > 0){
                    long startTime1 = System.currentTimeMillis();
                    while(scan.hasNext()){
                        line = scan.nextLine();
                        rbt.insert(line);
                        temp++;
                    }
                
                    long stopTime1 = System.currentTimeMillis();
                    long elapsedTime1 = stopTime1 - startTime1;
                    System.out.println("CreateTree Time: for 30 insertion: " + elapsedTime1 );
                }else{
                    System.out.println("File is empty");
                    return;
                }
            }catch(FileNotFoundException ex){
                System.out.println("\nError: " + ex  + "\n");
            }
        }else{
            file.createNewFile();
        }
        
        //System.out.println(rbt.getRoot().data);
        //--------------- Successful Search ---------------
        String searchString2 = "Lily";
        
        long startTime2 = System.nanoTime();
        boolean result2 = rbt.lookUp(searchString2, rbt.getRoot());
       
        long stopTime2 = System.nanoTime();
        long elapsedTime2 = stopTime2 - startTime2;
        
        System.out.println("Search Time for Successful search is: " + elapsedTime2 );
        
        //--------------- Unsuccessful Search ---------------
        String searchString3 = "Paul";
        
        long startTime3 = System.nanoTime();
        boolean result3 = rbt.lookUp(searchString3, rbt.getRoot());
       
        long stopTime3 = System.nanoTime();
        long elapsedTime3 = stopTime3 - startTime3;
        System.out.println("Search Time for Unsuccessful search is: " + elapsedTime3 );
        
 
        System.out.println("\nThank you.");
        System.out.println("Programmed by: Paul Diaz");
    }
    
    
    
    /////////////////////////////////////////////////////////////
    public static String makeString(RedBlackTree t)
    {
       class MyVisitor implements RedBlackTree.Visitor {
          String result = "";
          public void visit(RedBlackTree.Node n)
          {
             result = result + n.data;
          }
       };
       MyVisitor v = new MyVisitor();
       t.preOrderVisit(v);
       return v.result;
    }

    public static String makeStringDetails(RedBlackTree t) {
    {
        class MyVisitor implements RedBlackTree.Visitor {
            String result = "";
            int i = 0;
            public void visit(RedBlackTree.Node n){
               
                if(!(n.data == null))
                    result = result +"Color: "+n.color+", Key:"+n.data+" Parent: ";
                        if(n == t.getRoot()){
                            result += ""+"\n"; 
                        }else{
                            result += n.parent.data+"\n";
                        }
            }
        };
        MyVisitor v = new MyVisitor();
        t.preOrderVisit(v);
        System.out.println(v.result);
        return v.result;
    }
    }
}

