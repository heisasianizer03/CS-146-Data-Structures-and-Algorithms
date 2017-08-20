/**
 * Quick sort: two types - regular quicksort and quicksort with random pivot
 * @author Paul Diaz
 * CS 146
 * Prof. Potika
*/
public class Quicksort { 
    private int array[];
    private int dimension;
    private int comparisons;
 
    public Quicksort(int array[]){
        this.array = array;
        comparisons = 0;
        dimension = array.length;
    }
    /**
     * Constructor that creates an array with random numbers
     * @param size is the of the array
     * @param n is the range of the numbers to be randomly chosen
     */
    public Quicksort(int size, int n){ 
        array = new int[size];
        dimension = this.array.length;
        for(int i = 0; i < size -1; i++){
            array[i] = (int) (Math.random() * n);
        }
    }
    /**
     * Method where quick sort main event
     * @param array[] is the array to be sorted
     * @param p is the index where array starts
     * @param r is the index where array ends
     */                                 //0   8
    public void quickSort1(int array[], int p, int r){
        if(p < r){
            int q = partition1(array, p, r);
            quickSort1(array, p, q - 1);
            quickSort1(array, q + 1, r);
        }
    }
    /**
     * @param array[] is the array to be partitioned
     * @param p is the index where sub-array should start
     * @param r is the index where sub-array should end
     * @return index/pivot where we based the partitioning
     */
    public int partition1(int array[], int p, int r){
        int x = array[r];
        int i = p -1;
        
        for(int j = p; j < r; j++){
            if(array[j] <= x){
                i++;
                swap(array, i, j);
            }
            //comparisons++;
        }
        swap(array, i + 1, r);
        return i + 1;
    }
    /**
     * Method that swaps values of two elements
     * @param array[] is the array where the elements, that need swapping live
     * @param p is the first index
     * @param r is the second index
     */
    public void swap(int array[], int p, int r){
        int temp = array[p];
        array[p] = array[r];
        array[r] = temp;
    }
    /**
     * Method that returns the array
     * @return an array
     */
    public int [] getArray(){return array;}
    
    /**
     * Method where quick sort main event
     * @param array[] is the array to be sorted
     * @param p is the index where array starts
     * @param r is the index where array ends
     * @return 
     */ 
    public int[] quickSort2(int[] array, int p, int r) {
        if (p < r) {
            //left + floor(rand() * (right - left + 1))
            int pivot = p + (int)Math.floor(Math.random() * (r - p + 1));//median(array, p, r);// or random
            int q = partition(array, p, r, pivot);
            quickSort2(array, p, q - 1);
            quickSort2(array, q + 1, r);
        }
        return array;
    }
    
    /**
     * @param array is the array to be selected from
     * @param p is where array index starts
     * @param r is where array index ends
     * @param i 
     * @return the selected 
     */
    public int select(int array[], int p, int r, int i){
        if(p == r){
            return array[p];
        }
        int q = partition(array, p, r, i);
        int k = q - p + 1;
        if(i == k){
            return array[q];
        }else if( i < k){
            return select(array, p, q -1, i);
        }else{
            return select(array, q + 1, r, i - k);
        }
    }
    
    public int partition(int[] array, int p, int r, int pivot) {
        int x = array[r];
        int i = p -1;
        
        for(int j = p; j < r; j++){
            if(array[j] <= x){
                i++;
                swap(array, i, j);
            }
            comparisons++;
        }
        swap(array, i + 1, r);
        return i + 1;
    }
    
    public int getComparisons(){
        return comparisons;
    }
}