/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package a.closestpairofpoints;

/**
 *
 * @author ekaterina
 */
public class Heap {
    private Point[] array;
    private int capacity;
    
    public Heap(int size) {
         
        array = new Point[size];
        capacity = 0;
        
    }
    
    public void add(Point point) {
        
        array[capacity] = point;
        int i = capacity;
        capacity++;
        while (i != 0 && array[i].getX() <= array[(i - 1) / 2].getX()) {
            swap(i, ((i - 1) / 2));
            i = (i - 1) / 2;
        }
        
    }
    
    public void swap(int index1, int index2) {
        
        Point point = array[index1];
        array[index1] = array[index2];
        array[index2] = point;
        
    }
    
    public Point minDel() {
        
        Point result = array[0];
        if (capacity - 1 != 0) {
            swap (0, capacity - 1);
            capacity--; 
            array[capacity] = null;
            int index1 = 0, index2 = 2 * index1 + 1;
            if (index2 + 1 < capacity && array[index2 + 1].getX() <= array[index2].getX()) {
                index2++;
            }
            while ((2*index1 < capacity && array[index2] != null) && array[index2].getX() <= array[index1].getX()) {
                swap(index1, index2);
                index1 = index2;
                index2 = index1 * 2 + 1;
                if (index2 + 1 < capacity && array[index2 + 1].getX() <= array[index2].getX()) {
                    index2++;
                }
            }
        } 
        return result;
    }
    
}

