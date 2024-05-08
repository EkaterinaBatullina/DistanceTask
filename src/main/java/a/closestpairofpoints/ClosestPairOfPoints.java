/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package a.closestpairofpoints;
/**
 *
 * @author ekaterina
 */
public class ClosestPairOfPoints {

    public static void main(String[] args) {
        Point[] points = {
            new Point(0, 0, 1),
            new Point(11, 1, 2),
            new Point(20, 2, 3),
            new Point(5, 50, 4),
            new Point(2, 1, 5),
            new Point(9, 56, 6),
            new Point(25, 2, 7),
            new Point(54, 50, 8)
        };
        
        DistanceTask task1 = new DistanceTask(points);
        task1.closestPairOfPoints();
        System.out.println("Минимальное расстояние: " + task1.getMindist());
        System.out.println("Точки: " + task1.getIdA() + " и " + task1.getIdB());
    }
    
}