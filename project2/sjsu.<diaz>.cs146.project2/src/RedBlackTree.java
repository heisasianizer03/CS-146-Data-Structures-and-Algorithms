/**
 * RedBlackTree: RedBlackTree
 * @author Paul Diaz
 * CS 146
 * Prof. Potika
 */
public class RedBlackTree{
    private final int RED = 0;
    private final int BLACK = 1;
    
    //private final Node nill = new Node();
    private Node root;
    
    /**
     * Constructor that creates and object of class RBTree
     */
    public RedBlackTree(){
        root = new Node(null);
        root.data = null;
    }
    /**
     * Method that returns the root (for printing purposes)
     * @return the root
     */
    public Node getRoot(){
        return  root;
    }
    
    /**
     * Method that prints the tree
     * @param current is the root reference
     */
    public void printTree(Node current){//Using Preorder
        if(current == null){
            return;//root is nill, do nothing
        }else{//else, we print the tree
            //printTree(current.left);
            String colorNode = getColor(current);
            System.out.println(current.data+ " " + colorNode);
            printTree(current.left);
            printTree(current.right);
        }
        
    }
    /**
     * Method that gives the color of the node in String
     * @param node is the node to check
     * @return string representation of whatever the color is
     */
    public String getColor(Node node){
        String color = "Black";
        if(node.color == 0){
            color = "Red";
        }
        return color;
    }
    
    /**
     * Method that adds a node in the RedBlackTree
     * @param value is the value of the node to be added in the tree
     */
    public void insert(String value){
        Node z = new Node(value);
        Node temp = root;
        
        if(root.data == null){//if root is null
            root = z;
            z.setColor(1);
            root.parent = null;
        }else{//if tree is empty
            z.setColor(0);
            while(true){
                if(z.data.compareTo(temp.data) < 0){//then we go left
                    if(temp.left == null){
                        temp.left = z;
                        z.parent = temp;
                        break;
                    }else{
                        temp = temp.left;
                    }
                }else if(z.data.compareTo(temp.data) >= 0){
                    if(temp.right == null){
                        temp.right = z;
                        z.parent = temp;
                        break;
                    }else{
                        temp = temp.right;
                    }
                }
            }
            fixTree(z);
        }
   
    }
    
    /**
     * Method that fixes the tree right after insertion
     * @param current is the current node where to start fixing
     */
    public void fixTree(Node current){
        if(current == root){//1. current is root node
            current.setColor(BLACK);
            return;
        }
        if(current.parent.color == BLACK){//2. parent is black
            return;//we do nothing, tree is RedBlackTree
        }
        if(current.color == RED && current.parent.color == RED){
            if(getAunt(current) == null || getAunt(current).color == BLACK){//3.1 aunt is empty or black
                //if(getGrandParent(current).left == current.parent.right){
                    if(current.parent == getGrandParent(current).left && current.parent.right == current){//A
                        rotateLeft(current.parent);
                        fixTree(current.parent);
                    }else if(getGrandParent(current).left == current.parent && current.parent.left == current){//C
                        current.parent.setColor(BLACK);
                        getGrandParent(current).setColor(RED);
                        rotateRight(getGrandParent(current));
                        return;
                    }else if(current.parent == getGrandParent(current).right && current.parent.left == current){//B
                        rotateRight(current.parent);
                        fixTree(current.parent);
                    }else if(getGrandParent(current).right == current.parent && current.parent.right == current){//D
                        current.parent.setColor(BLACK);
                        getGrandParent(current).setColor(RED);
                        rotateLeft(current.parent.parent);
                        return;
                    }
                //}
            }else if(getAunt(current).color == RED){//if(getAunt(current).color == RED){//3.2 aunt is red
                current.parent.setColor(BLACK);
                getAunt(current).setColor(BLACK);
                getGrandParent(current).setColor(RED);
                fixTree(current.parent.parent);
            }
        }
    }
    /**
     * Method that rotates the tree to the left
     * @param x is a node
     */
    public void rotateLeft(Node x){
        Node y;
        if(x.right == null){
            return;
        }
        y = x.right;
        
        if(y.left != null){
            y.left.setParent(x);
            x.setRight(y.left);
        }
        
        y.setParent(x.parent);
        
        if(x.parent == null){
            root = y;
        }else if(x == x.parent.left){
            x.parent.setLeft(y);
        }else{
            x.parent.setRight(y);
        }
        x.setRight(y.left);
        y.setLeft(x);
        x.setParent(y); 
    }
    
     /**
     * Method that rotates the tree to the left
     * @param y is a node
     */
    public void rotateRight(Node y){
        Node x;
        if(y.left == null){
            return;
        }
        x = y.left;
        
        if(x.right != null){
            x.right.setParent(y);
            y.setLeft(x.right);
        }
        
        x.setParent(y.parent);
        
        if(y.parent == null){
            root = x;
        }else if(y == y.parent.left){
            y.parent.setLeft(x);
        }else{
            y.parent.setRight(x);
        }
        
        y.setLeft(x.right);
        x.setRight(y);
        y.setParent(x);
    }
    /**
     * Method that finds a node's aunt
     * @param value is the data of the node to be searched
     * @return Node is the aunt of the node
     */
    public Node aunt(String value){
        Node tempAunt = searchTree(value);
        return getAunt(tempAunt);
    }
    
    /**
     * Method that find a node's grandparent
     * @param value is the data of the node to be searched
     * @return Node is the grand parent of the node
     */
    public Node grandParent(String value){
        Node tempGrand = searchTree(value); 
        return getGrandParent(tempGrand);
    }
    
    /**
     * Method that finds the sibling of a node
     * @param value is the value of the node to be searched
     * @return Node
     */
    public Node sibling(String value){
        Node tempSibling = searchTree(value);
        return getSibling(tempSibling);
    }
    
    /**
     * Method that finds the sibling of a node
     * @param  node is the node to be searched
     * @return Node is the sibling we are looking for
     */
    public Node getSibling(Node node){
        if(node.parent == null){
            return null;
        }else if(node.parent.left == node){
            return node.parent.right;
        }else{
            return node.parent.left;
        }
    }
    
    /**
     * Method that finds the aunt of a specific node
     * @param node is the node where we want to find its aunt
     * @return the aunt of the node
     */
    public Node getAunt(Node node){
        return getSibling(node.parent);
    }
    
    /**
     * Method that finds the grandparent of a specific node
     * @param node is the node where we want to find its grandparent
     * @return the grandparent of a node
     */
    public Node getGrandParent(Node node){
        return node.parent.parent;
    }
    
    /**
     * Utility Method that search a node with a data == value
     * @param value is the value of the node to be searched
     * @return Node is the node where a node(value) is located
     */
    public Node searchTree(String value){
        Node pointer = root;
        
        if(this.root == null){
            return null;
        }
        while(true){
            if(pointer.data.compareTo(value) == 0){
                return pointer;
            }else if(value.compareTo(value) > 0){ //value > pointer.data
                if(pointer.right == null){
                    return null;
                }
                pointer = pointer.right;
            }else{
                if(pointer.left == null){
                    return null;
                }
                pointer = pointer.left;
            }
        }   
    }
    
    /**
     * Extra method that looks up for a string
     * @param string is the value of the string to be searched
     * @param node is what node should the program starts searching
     * @return true if search is successful, false otherwise
     */
    public boolean lookUp(String string, Node node){
        Node pointer = node;
        if(pointer == null){
            return false;
        }
        int compResult = string.compareTo(pointer.data);
        
        if(compResult < 0){
            return lookUp(string, pointer.left);
        }else if(compResult > 0){
            return lookUp(string, pointer.right);
        }else{
            return true;
        }
    }
    
     /**
      * Inner class that represents a Node
      */  
    public class Node{
        
        String data;
        int color;
        Node left;
        Node right;
        Node parent;
       
        /**
         * Constructor
         * @param value is the value of the node
         */
        public Node(String value){
            data = value;
            left = null;
            right = null;
            parent = null;
            color = BLACK;//by default
        }
        
        /**
         * Method that sets the color of the node
         * @param color is the right color
         */
        public void setColor(int color){
            this.color = color;
        }
        
        /**
         * Method that determines the color in String
         * @return 0 for Red, otherwise Black
         */
        public int colorString(){
            if(this.color == 0){
                return RED;
            }else{
                return BLACK;
            }
        }
        
        /**
         * Method that sets the parents of a node
         * @param nodeParent is the right parent of the node caller
         */
        public void setParent(Node nodeParent){
            this.parent = nodeParent;
        }
        
        /**
         * Method that sets the right of a node
         * @param nodeRight is the right node
         */
        public void setRight(Node nodeRight){
            this.right = nodeRight;
        }
        
        /**
         * Method that sets the left of a node
         * @param nodeLeft is the left node
         */
        public void setLeft(Node nodeLeft){
            this.left = nodeLeft;
        }
        
        /**
         * Method that prints data and color of a node
         * @return string representation of a node's data and color
         */
        public String printNode(){
            return this.data + " " + this.colorString();
        }
        
    }
    //-------------------------- Added for Testing purposes -----------------
    // add this in your class  
    public static interface Visitor{
    /**
        This method is called at each node.
        @param n the visited node
    */
        void visit(Node n);
    }
 
  
    public void preOrderVisit(Visitor v){
        preOrderVisit(root, v);
    }
 
 
    private static void preOrderVisit(Node n, Visitor v){
        if (n == null) return;
        v.visit(n);
        preOrderVisit(n.left, v);
        preOrderVisit(n.right, v);
    }
}

