
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
public class QuicksortTest {
    private Quicksort QS;
    private int n;

    public QuicksortTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        int [] array = new int[n];
        QS = new Quicksort(array);

    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of quickSort1 method, of class Quicksort.
     */
    @Test
    public void testQuickSort1() {
        System.out.println("quickSort1");
        int[] array1 = {10,34,6,54,65,3,66,22,45,20,11,13,99,12,16,33,55,88,1,5};//20
        int p = 0;
        int r = 19;      //1 3 5 6 10 11 12 13 16 20 22 33 34 45 54 55 65 66 88 99
        int[] expResult1 = {1,3,5,6,10,11,12,13,16,20,22,33,34,45,54,55,65,66,88,99};
        int[] expResult2 = {12,3,5,6,10,11,12,13,16,20,22,33,34,45,54,55,65,66,88,99};
        
        Quicksort instance = new Quicksort(array1);
        instance.quickSort1(array1, p, r);
        assertArrayEquals(expResult1, instance.getArray());
        //assertArrayEquals(expResult2, instance.getArray());
    }

    /**
     * Test of partition1 method, of class Quicksort.
     */
    @Test
    public void testPartition1() {
        System.out.println("partition1");
        //same as testPartition()
    }

    /**
     * Test of swap method, of class Quicksort.
     */
    @Test
    public void testSwap() {
        System.out.println("swap");
        int[] array1 = {10,34,6,54,65,3,6,22,45,20,11,13,99,12,1,33,55,88,1,5};//20
        int p = 0;
        int r = 1;
        Quicksort instance = new Quicksort(array1);
        instance.swap(array1, p, r);
        
        int[] expResult1 = {34,10,6,54,65,3,6,22,45,20,11,13,99,12,1,33,55,88,1,5};//20
        int[] expResult2 = {10,34,6,54,65,3,6,22,45,20,11,13,99,12,1,33,55,88,1,5};//20
        assertArrayEquals(expResult1, instance.getArray());
        //assertArrayEquals(expResult2, instance.getArray());
    }

    /**
     * Test of getArray method, of class Quicksort.
     */
    @Test
    public void testGetArray() {
        System.out.println("getArray");
        int[] array = {10,34,6,54,65,3,6,22,45,20,11,13,99,12,1,33,55,88,1,5};//20
        Quicksort instance = new Quicksort(array);
        int [] expResult1 = {10,34,6,54,65,3,6,22,45,20,11,13,99,12,1,33,55,88,1,5};//20
        int [] expResult2 = {100,34,6,54,65,3,6,22,45,20,11,13,99,12,1,33,55,88,1,5};//20
        int[] result = instance.getArray();

        assertArrayEquals(expResult1, result);
        //assertArrayEquals(expResult2, result);
    }

    /**
     * Test of quickSort2 method, of class Quicksort.
     */
    @Test
    public void testQuickSort2() {
        int[] array1 = {10,34,6,54,65,3,66,22,45,20,11,13,99,12,16,33,55,88,1,5};//20
        int p = 0;
        int r = 19;      //1 3 5 6 10 11 12 13 16 20 22 33 34 45 54 55 65 66 88 99
        int[] expResult1 = {1,3,5,6,10,11,12,13,16,20,22,33,34,45,54,55,65,66,88,99};
        int[] expResult2 = {12,3,5,6,10,11,12,13,16,20,22,33,34,45,54,55,65,66,88,99};
        
        Quicksort instance = new Quicksort(array1);
        instance.quickSort1(array1, p, r);
        assertArrayEquals(expResult1, instance.getArray());
        //assertArrayEquals(expResult2, instance.getArray());
    }

    /**
     * Test of partition method, of class Quicksort.
     */
    @Test
    public void testPartition() {
        System.out.println("partition");
        int[] array1 = {10,34,6,54,65,3,66,22,45,20,11,13,99,12,16,33,55,88,1,5};//20
        int p = 0;
        int r = 19;
        int pivot = 6;//pivot will be randomly selected
        Quicksort instance = new Quicksort(array1);
        
        int expResult = 0;
        int result = instance.partition(array1, p, r, pivot);
        assertEquals(expResult, result);

    }   
    @Test
    public void testGetComparisons(){
        System.out.println("getComparisons");
        int[] array1 = {10,34,6,54,65,3,66,22,45,20,11,13,99,12,16,33,55,88,1,5};//20
        Quicksort instance = new Quicksort(array1);
        
        int expResult = 19;//there are going to be more comparisons more than 19
        instance.quickSort1(array1, 0, array1.length -1);
        int result = instance.getComparisons();
        assertEquals(expResult, result);
    }
}
