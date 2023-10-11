package common;

import dataStructure.linear.*;
import dataStructure.nonLinear.*;

import java.util.Arrays;
import java.util.List;

public class DSA {
    public static void runEasy() {
        /* NON-LINEAR */
        Graph graph = new Graph();
        graph.makeNonCyclicGraph();
        graph.detectCycleDfs(graph.getGraph(), 4);
        graph.makeCyclicGraph();
        graph.detectCycleDfs(graph.getGraph(), 4);
//        graph.makeTransitiveClosureGraph();
//        graph.transitiveClosureDfs(graph.getGraph());
//        graph.makeIntegerDisconnectedGraph();
//        graph.disconnectedBfsTraversal(graph.getGraph(), 5);
//        graph.makeIntegerGraph();
//        graph.bfsTraversal(graph.getGraph(), 4);
//        graph.dfsTraversal(graph.getGraph(), 3);
//        graph.makeStringGraph();
//        graph.convertToTranspose(graph.getGraph());






        /* LINEAR */
//        LinkedList linkedList = new LinkedList();
//        linkedList.modifySingly(linkedList.makeLinkedList(new int[]{10,4,5,3,6}));
//        linkedList.rotateLinkedList(linkedList.makeDoublyLinkedList(new int[]{1,2,3,4,5}),3);
//        linkedList.removeDuplicate(linkedList.makeDoublyLinkedList(new int[]{1,2,3,2,2,4,2,2,4,4,5}));
//        linkedList.insertInSortedDoubly(linkedList.makeDoublyLinkedList(new int[]{2,4,5,6,8,9}), 11);
//        linkedList.pairSum(linkedList.makeDoublyLinkedList(new int[]{1,2,4,5,6,8,9}), 7);
//        linkedList.deletionCircular(linkedList.makeCircularLinkedList(new int[]{1,2,3,4,5,6}), 6);
//        linkedList.splitInHalves(linkedList.makeCircularLinkedList(new int[]{1,2,3,4,5,6}));
//        linkedList.intersectionTwoLinkedList(linkedList.makeLinkedList(new int[]{4,5}), linkedList.makeLinkedList(new int[]{1,2,4,5,6}));
//        linkedList.removeDuplicates(linkedList.makeLinkedList(new int[]{1,2,4}));
//        linkedList.detectLoopLength(linkedList.circleLinkedList());
//        linkedList.detectLoop(linkedList.circleLinkedList());
//        linkedList.deleteNodeDoubly(linkedList.makeDoublyLinkedList(new int[]{5, 4, 3, 2, 1}), linkedList.makeLinkedList(new int[]{1}));
//        linkedList.circularLinkedListTraversal(linkedList.makeCircularLinkedList(new int[]{5, 4, 3, 2, 1}));
//        linkedList.sizeOfDoubly(linkedList.makeDoublyLinkedList(new int[]{5, 4, 3, 2, 1}));
//        linkedList.reverseDoublyLinkedList(linkedList.makeDoublyLinkedList(new int[]{5, 4, 3, 2, 1}));
//        linkedList.exchangeFirstLast(linkedList.makeCircularLinkedList(new int[]{5, 4, 3, 2, 1}));
//        linkedList.convertToCircular(linkedList.makeLinkedList(new int[]{9, 1, 2, 10, 3, 7}));
//        linkedList.countCircularNodes(linkedList.makeCircularLinkedList(new int[]{9, 1, 2, 10, 3, 7}));
//        linkedList.circularLinkedListCheck(linkedList.makeLinkedList(new int[]{1, 1, 2, 10, 3, 7}));
//        linkedList.circularLinkedListCheck(linkedList.makeCircularLinkedList(new int[]{1, 1, 2, 10, 3, 7}));
//        linkedList.elemCount(linkedList.makeLinkedList(new int[]{1, 1, 2, 10, 3, 7, 1}), 1);
//        linkedList.middlePrint(linkedList.makeLinkedList(new int[]{1, 1, 2, 10, 3, 7}));




//        Array array = new Array();
//        array.sqrtDecompositionAlgorithm(new int[]{1, 1, 2, 1, 3, 4, 5, 2, 8}, 0, 8);
//        array.moAlgorithm(new int[]{1, 1, 2, 1, 3, 4, 5, 2, 8}, List.of(new int[]{0, 4}, new int[]{1, 3}, new int[]{2, 4}) );
//        array.mostOccurrence(new int[]{7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9}, 4);
//        array.equilibriumIndex(new int[]{-7, 1, 5, 2, -4, 3, 0});
//        array.minIncrement(new int[]{4, 7, 19, 16}, 3);
//        array.tripletSum(new int[]{1, 2, 3, 4, 5}, 9);
//        array.peakElement(new int[]{10, 20, 15, 2, 23, 90, 67});
//        array.twoPointers(new int[]{10, 20, 35, 50, 75, 80}, 70);
//        array.majorityElement(new int[]{3, 3, 4, 2, 4, 4, 2, 4, 4});
//        array.mergeTwoArraysSorted(new int[]{1, 5, 9, 10, 15, 20}, new int[]{2, 3, 8, 13});
//        array.sortZeroOneTwo(new int[]{0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1});
//        array.inversionCount(new int[]{1, 20, 6, 4, 5});
//        array.smallestSubarray(new int[]{1, 4, 45, 6, 0, 19}, 51);
//        array.profitArray(new int[]{10, 22, 5, 75, 65, 80});
//        array.updateArray(new int[]{10, 5, 20, 40}, 2 , 2 ,30);
//        array.smallestMissingNumber(new int[]{0, 1, 2, 3}, 4,5);
//        array.kthLargestSum(new int[]{20, -5, -1}, 3);
//        array.sortedInRotation(new int []{7, 9, 11, 12, 15});
//        array.reorderingTheArrays(new int[]{10, 11, 12}, new int[]{1, 0, 2});
//        array.rearrangePosNeg(new int[]{-1, 2, -3, 4, 5, 6, -7, 8, 9});
//        array.rearrange(new int[]{19, 7, 0, 3, 18, 15, 12, 6, 1, 8, 11, 10, 9, 5, 13, 16, 2, 14, 17, 4});
//        array.subArray(new int[]{1, 4, 0, 0, 3, 10, 5}, 7);
//        array.leadersInArray(new int[]{16, 17, 4, 3, 5, 2});
//        array.oneTwo(new int[]{2, 3, 5, 4, 5, 3, 4});
//        array.distinctElement(new int[]{10, 100, 100, 100, 300});
//        array.triangleCounter(new int[]{10, 21, 22, 100, 101, 200, 300});
//        array.sortWave(new int[]{1, 3, 5, 7, 9});
//        array.printLeftRotation(new int[]{1, 3, 5, 7, 9}, 6);
//        array.reversalRotation(new int[]{1, 2, 3, 4, 5, 6, 7},  4);
//        array.segregateEvenOdd(new int[]{7, 2, 9, 4, 6, 1, 3, 8, 5});
//        array.maxMinTwoPointer(new int[]{1, 2, 3, 4, 5, 6, 7});
//        array.evenPositionedGreater(new int[] {0,4,0, 5,2,3,1,0, 6, 0, -1, -10, 3,0});
//        array.zeroToEnd(new int[]{0,4,0, 5,2,3,1,0, 6, 0, -1, -10, 3,0});
//        array.threeElements(new int[]{4, 1, 6, 0, -1, -10, 3});


//        Sort sort = new Sort();
//        sort.insertionSort(new int[]{4, 1, 6, 0, -1, -10, 3});
//        sort.selectionSort(new int[]{4,5,6,0,-1,-10, 1});
//
//        Search search = new Search();
//        System.out.println(search.binarySearch(new int []{2, 5, 6, 8, 9, 10}, 0, 5 ,6));
//        System.out.println(search.linerSearch2D(new String[][]{{"hay", "hay"}, {"hay", "hay"},
//                {"hay", "hay"}, {"hay", "hay"}, {"needle", "hay"}, {"hay", "hay"}}, "needle"));
//        System.out.println(search.linearSearch(new int []{2, 3, 4, 10, 40}, 10));
//
//        Recursion recursion = new Recursion();
//        System.out.println(recursion.getTotal(new ArrayList<>(Arrays.asList(3,5,6,9))));
//        System.out.println(recursion.reverseString("Sadia"));
//        System.out.println(recursion.factorial(4));
    }
}
