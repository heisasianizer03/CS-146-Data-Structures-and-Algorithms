1. testQuickSort1
	assertArrayEquals(expResult1, instance.getArray()); will pass the test
		since expResult1 has the same exact array as the result
	Comment out assertArrayEquals(expResult1, instance.getArray()); and uncomment
		assertArrayEquals(expResult2, instance.getArray()); this will fail the test
		since expResult2 doesn’t have the same array elements

2. testSwap() 
	assertArrayEquals(expResult1, instance.getArray()); will pass the test
		since the swapping of indices 0 and 1 is successfull.
	Comment out assertArrayEquals(expResult1, instance.getArray()); and uncomment 
		assertArrayEquals(expResult2, instance.getArray()); this will fail the test
		because the expResult2 did not swap the two elements with the corresponding
		indices.

3. testGetArray()
	assertArrayEquals(expResult1, result); successfully returns the correct expected
		array, and so we pass this test
	On the other hand, if we comment out assertArrayEquals(expResult1, result); and
		uncomment out assertArrayEquals(expResult2, result); this will fail the test
		because expResult2 doesn’t have the correct array.

4. testPartition()
	This test will always fail since the program generates the pivot randomly

5. testPartition2()
	same as testPartition

6. testGetComparisons()
	comparisons will always have more than the size of an array
	


