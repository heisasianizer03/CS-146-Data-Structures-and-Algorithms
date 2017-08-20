/**
 * Quick sort: two types - regular quicksort and quicksort with random pivot
 * @author Paul Diaz
 * CS 146
 * Prof. Potika
*/
public class QuickSortMain {
    public static void main(String[] args){
        
        int size1 = 10000;
        int size2 = 100000;
        int size3 = 1000000;
        int size4 = 10000000;
        int size5 = 100000000;
        Quicksort sort = new Quicksort(size4, 10000000);//10000000
      
        long startTime1 = System.currentTimeMillis();
        sort.quickSort2(sort.getArray(), 0, sort.getArray().length -1);
        long stopTime1 = System.currentTimeMillis();
        long elapsedTime1 = stopTime1 - startTime1;
        System.out.println("Time: " + elapsedTime1);
       
        //System.out.println(sort.getComparisons());
        //System.out.println();
        
        //printArray(sort.getArray());
        //sort.quickSort2(sort.getArray(), 0, sort.getArray().length -1);
        //printArray(sort.getArray());
        
        long startTime2 = System.currentTimeMillis();
        sort.quickSort2(sort.getArray(), 0, sort.getArray().length -1);
        long stopTime2 = System.currentTimeMillis();
        long elapsedTime2 = stopTime2 - startTime2;
        System.out.println("Time: " + elapsedTime2);
        
        System.out.println(sort.getComparisons());
       
    }
    
     public static void printArray(int[]array){
        String message1 = "";
        for(int i = 0; i < array.length; i++){
            if((i % 100) == 0){
                message1 += "\n";
            }
            message1 += " " + array[i];
        }   
        System.out.println(message1 + "\n");
    }
}
