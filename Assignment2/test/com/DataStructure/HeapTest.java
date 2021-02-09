package com.DataStructure;

import nullObject.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import strategy.MaxHeapComparison;
import strategy.MinHeapComparison;

import static org.junit.jupiter.api.Assertions.*;

class HeapTest {
    private Heap maxheap;
    private Heap minheap;
    private Integer actualResult, expectedResult;

    @BeforeEach
    void setUp() {
        minheap=new Heap();
        minheap.setHeapStrategy(new MinHeapComparison());
        maxheap=new Heap();
        maxheap.setHeapStrategy(new MaxHeapComparison());

        minheap.add(4);
        minheap.add(5);
        minheap.add(6);
        minheap.add(8);
        minheap.add(3);

        maxheap.add(4);
        maxheap.add(5);
        maxheap.add(6);
        maxheap.add(8);
        maxheap.add(3);

    }

    @Test
    public void minHeapSizeTest() {
        expectedResult = 5;
        actualResult = minheap.size();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void maxHeapSizeTest() {
        expectedResult = 5;
        actualResult = maxheap.size();
        assertEquals(expectedResult, actualResult);
    }
    /* Test to ensure that the root value for heap is minimum when
     * strategy is minheap.
     */
    @Test
    public void minHeapRootTest() {
    actualResult=3;
    expectedResult= minheap.peek();
    assertEquals(expectedResult,actualResult);
    }
    /* Test to ensure that the root value for heap is maximum when
     * strategy is maxheap.
     */
    @Test
    public void maxHeapRootTest() {
        actualResult=8;
        expectedResult= maxheap.peek();
        assertEquals(expectedResult,actualResult);
    }
    /*Test to ensure that heap doesn't have multiple root elements*/
    //Pass:MinHeap
    @Test
    public void notMultipleRootForMinHeapTest(){
        actualResult= 4;
        expectedResult =minheap.peek();
        assertNotEquals(expectedResult,actualResult);
    }
    //Pass:MaxHeap
    @Test
    public void notMultipleRootForMaxHeapTest(){
        actualResult= 4;
        expectedResult = maxheap.peek();
        assertNotEquals(expectedResult,actualResult);
    }
    /*Test to ensure swap functionality.
    * when minHeap, smaller child should get swapped
    * and when maxHeap, child should be smaller and shouldn't swap the values*/
    @Test
    public void swapTest(){
        Node parentNode= new Node(3);
        Node childNode= new Node(1);
        minheap.swap(parentNode,childNode);
        assertEquals(1, parentNode.getValue());
        assertEquals(3, childNode.getValue());
        maxheap.swap(parentNode,childNode);
        assertNotEquals(1, parentNode.getValue());
        assertNotEquals(3, childNode.getValue());
    }
    /*Test to check the inorder traversal when strategy is minHeap*/
    @Test
    public void minHeapInorderTraversalTest(){
        String actualResult= "8 5 3 6 4 ";
        assertEquals(actualResult,minheap.toString());
    }
    /*Test to check the inorder traversal when strategy is maxHeap*/
    @Test
    public void maxHeapInorderTraversalTest(){
        String actualResult= "4 6 8 3 5 ";
        assertEquals(actualResult,maxheap.toString());
    }

    /*Test to check behaviour of iterator, with different strategy passed  */
    //pass 1:minHeap
    @Test
    public void minHeapIteratorTest() {
        String expectedResult = "8 5 3 6 4 ";
        StringBuilder heapStringBuilder = new StringBuilder();
        Iterator iterator= minheap.getIterator();
        while(iterator.hasNext()){
             actualResult =iterator.next().getValue();
            heapStringBuilder.append(actualResult).append(" ");
        }
        assertEquals(expectedResult, heapStringBuilder.toString());

    }
    //Pass 2: maxHeap
    @Test
    public void maxHeapIteratorTest() {
        String expectedResult = "4 6 8 3 5 ";
        StringBuilder heapStringBuilder = new StringBuilder();
        Iterator iterator= maxheap.getIterator();
        while(iterator.hasNext()){
            actualResult =iterator.next().getValue();
            heapStringBuilder.append(actualResult).append(" ");
        }
        assertEquals(expectedResult, heapStringBuilder.toString());
    }
    /*Test to check oddFilter passed on iterator works expected
    * when passed different strategy
    */
    @Test
    public void OddIteratorTest() {
        String expectedResultMinHeap = "5 3 ";
        String expectedResultMaxHeap = "3 5 ";
        StringBuilder heapStringBuilder = new StringBuilder();

        //pass:1
        OddFilter oddIterator=new OddFilter(minheap.getIterator());
        while(oddIterator.hasNext()){
            actualResult =oddIterator.next().getValue();
            heapStringBuilder.append(actualResult).append(" ");
        }
        assertEquals(expectedResultMinHeap , heapStringBuilder.toString());

        //pass:2
        heapStringBuilder.delete(0,4);
        oddIterator=new OddFilter(maxheap.getIterator());
        while(oddIterator.hasNext()){
            actualResult =oddIterator.next().getValue();
            heapStringBuilder.append(actualResult).append(" ");
        }
        assertEquals(expectedResultMaxHeap, heapStringBuilder.toString());
    }
    /*Test to ensure heap gets cleared on call of Clear()*/
    @Test
    public void clearHeapTest(){
      String actualResult="";
      minheap.clear();
      assertEquals(minheap.toString(),actualResult);
    }
    @Test
    /*Test to ensure heap is empty while creating new heap */
    public void heapIsEmptyAtFirst(){
        minheap.clear();
        assertEquals(minheap.isEmpty(), true);
    }

}