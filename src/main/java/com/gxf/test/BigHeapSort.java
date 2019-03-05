package com.gxf.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2019/1/9 2:47 PM
 **/
public class BigHeapSort {

  private static List<Integer> heap = new ArrayList<>();

  public static void main(String[] args) {
    int[] array = new int[]{1, 4, 5, 6, 8};
    for (int i : array) {
      insert(i);
    }
    printList();
  }


  private static void delete(int index) {
    heap.set(index, heap.get(heap.size() - 1));
  }

  private static void downAdjust(int index) {
    int child = -1;
    if (index * 2 > heap.size() - 2) {
      return;
    }
    else if (index * 2 < heap.size() - 2) {
      child = heap.get(index * 2) < heap.get(index * 2 + 1) ? index * 2 + 1 : index * 2;
    }
    else {
      child = index * 2;
    }
    if (heap.get(child) > heap.get(index)) {
      swap(index, child);
      downAdjust(child);
    }
  }

  private static void insert(int value) {
    if (heap.size() == 0) {
      heap.add(0);
    }
    heap.add(value);
    upAdjust(heap.size() - 1);
  }

  private static void upAdjust(int index) {
    if (index > 1) {
      int parent = index / 2;
      if (heap.get(parent) < heap.get(index)) {
        swap(index, parent);
        upAdjust(parent);
      }
    }
  }

  private static void swap(int index1, int index2) {
    int temp = heap.get(index1);
    heap.set(index1, heap.get(index2));
    heap.set(index2, temp);
  }

  private static void printList() {
    for (int i : heap) {
      System.out.print(i + " ");
    }
    System.out.println();
  }
}
