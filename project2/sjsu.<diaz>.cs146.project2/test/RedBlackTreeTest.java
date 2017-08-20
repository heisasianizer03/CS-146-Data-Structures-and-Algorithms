/*
 * Paul Diaz
 * CS 149
 * RBTree: JUnitTest
 * Prof. Potika
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Paul
 */
public class RedBlackTreeTest {

    public RedBlackTreeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void test() {
        RedBlackTree rbt = new RedBlackTree();
        
        rbt.insert("D");
        rbt.insert("B");
        rbt.insert("A");
        rbt.insert("C");
        rbt.insert("F");
        rbt.insert("E");
        rbt.insert("H");
        rbt.insert("G");
        rbt.insert("I");
        rbt.insert("J");
        assertEquals("DBACFEHGIJ", makeString(rbt));
        String str=     
            "Color: 1, Key:D Parent: \n"+
            "Color: 1, Key:B Parent: D\n"+
            "Color: 1, Key:A Parent: B\n"+
            "Color: 1, Key:C Parent: B\n"+
            "Color: 1, Key:F Parent: D\n"+
            "Color: 1, Key:E Parent: F\n"+
            "Color: 0, Key:H Parent: F\n"+
            "Color: 1, Key:G Parent: H\n"+
            "Color: 1, Key:I Parent: H\n"+
            "Color: 0, Key:J Parent: I\n";
        assertEquals(str, makeStringDetails(rbt));
            
    }

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

        class MyVisitor implements RedBlackTree.Visitor {
            String result = "";
            public void visit(RedBlackTree.Node n){
                if(!(n.data == null))
                    result = result +"Color: "+n.color+", Key:"+n.data+" Parent: ";
                    if(n == t.getRoot()){
                        result += ""+"\n"; 
                    }else{
                       result += n.parent.data+"\n";
                    }
            }
        }
        ;
        MyVisitor v = new MyVisitor();
        t.preOrderVisit(v);
        System.out.println("Result: " + v.result);
        return v.result;
    }
   
}
