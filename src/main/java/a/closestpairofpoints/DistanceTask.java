/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package a.closestpairofpoints;
import java.util.Arrays;
/**
 *
 * @author ekaterina
 */
public class DistanceTask {
    private double mindist = Double.MAX_VALUE;
    private int idA, idB;
    private Point[] points;
    
    public DistanceTask(Point[] points) {
        
        this.points = points;
        
    }

    public void closestPairOfPoints() {
        
        Heap heap = new Heap(points.length);
        for (int i = 0; i < points.length; ++i) {
            heap.add(points[i]);
        }
        for (int i = 0; i < points.length; ++i) {
            points[i] = heap.minDel();
        }
        closestPairRec(0, points.length - 1);
        
    }

// перед вызвовом предполагаем, что массив уже отсортирован по оси абсцисс(сортировка кучей)
    public void closestPairRec(int l, int r) { 
        
        if (r - l <= 3) { //достаточно малый интервал
            for (int i = l; i <= r; i++) {
                for (int j = i + 1; j <= r; j++) {
                    upd_ans(points[i], points[j]);
                }
            }
            Arrays.sort(points, l, r + 1, (p1, p2) -> p1.getY() - p2.getY());
            return;
        }
        
        int m = (l + r) / 2; 
        double midx = points[m].getX();
        closestPairRec(l, m);
        closestPairRec(m + 1, r); 
// рекурсия позволяет находить минимальные расстояния в каждой из частей
// и как результат минимальное из двух первоначальных частей
// далее необходимо проверить, нет ли среди точек, принадлежащих разным частям, более близких
// чем найденное нами на предыдущем шаге
// для этого рассматриваем точки, учитывая, что координаты отличаются друг от друга не более чем на 
// найденное расстояние
// пробегаясь по точкам, каждый раз обновляем данные, в результате получаем минимальное расстояние
        
        Point[] t = new Point[points.length]; // для подходящих точек из разных частей
        int tsz = 0;
        for (int i = l; i <= r; i++) { 
            if (Math.abs(points[i].getX() - midx) < mindist) {
                for (int j = tsz - 1; j >= 0 && points[i].getY() - t[j].getY() < mindist; j--) {
                    upd_ans(points[i], t[j]);
                }
                t[tsz++] = points[i];
            }
        }
        
    }

    public void upd_ans(Point a, Point b) { // проверка двух точек, обновление при необходимости
        
        double dist = Math.sqrt((a.getX() - b.getX()) * (a.getX() - b.getX()) + (a.getY() - b.getY()) * (a.getY() - b.getY()));
        if (dist < mindist) {
            mindist = dist;
            idA = a.getId();
            idB = b.getId();
        }
        
    }
    
    public double getMindist() {
        
        return mindist;
        
    }
    
    public int getIdA() {
        
        return idA;
        
    }
 
    public int getIdB() {
        
        return idB;
        
    }
    
}
