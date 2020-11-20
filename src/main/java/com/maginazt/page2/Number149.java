package com.maginazt.page2;

import com.maginazt.structure.Point;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhaotao on 2016/8/30.
 */
public class Number149 {

    private static final Map<String, int[]> pointsOnline = new HashMap<>();
    private static final Map<String, Integer> pointsDup = new HashMap<>();

    public int maxPoints(Point[] points) {
        if(points == null || points.length < 1)
            return 0;
        List<Point> filtered = filter(points);
        if(filtered.size() < 2)
            return pointsDup.get(filtered.get(0).x+","+filtered.get(0).y);
        pointsOnline.clear();
        for(int i=0;i<filtered.size()-1;i++){
            for(int j=i+1;j<filtered.size();j++){
                String line = getLine(filtered.get(i), filtered.get(j));
                String p1 = filtered.get(i).x+","+filtered.get(i).y;
                String p2 = filtered.get(j).x+","+filtered.get(j).y;
                if(pointsOnline.containsKey(line)){
                    int[] c = pointsOnline.get(line);
                    c[0] += 1;
                    c[1] += pointsDup.get(p1)+pointsDup.get(p2)-2;
                }
                else
                    pointsOnline.put(line, new int[]{1, pointsDup.get(p1)+pointsDup.get(p2)-2});
            }
        }
        int maxPoints = 2;
        for(Map.Entry<String, int[]> entry : pointsOnline.entrySet()){
            int[] c = entry.getValue();
            int actp = (1+(int)Math.sqrt(1+8*c[0]))/2;
            actp += c[1]/(actp-1);
            if(actp > maxPoints)
                maxPoints = actp;
        }
        return maxPoints;
    }

    private List<Point> filter(Point[] points) {
        List<Point> results = new ArrayList<>();
        pointsDup.clear();
        for(Point p : points){
            String key = p.x+","+p.y;
            if(!pointsDup.containsKey(key)){
                results.add(p);
                pointsDup.put(key, 1);
            }
            else{
                pointsDup.put(key, pointsDup.get(key)+1);
            }
        }
        return results;
    }

    private String getLine(Point x1, Point x2) {
        if(x1.x == x2.x)
            return "x="+x1.x;
        else if(x1.y == x2.y)
            return "y="+x1.y;
        else{
            int diffx = x2.x - x1.x;
            int diffy = x2.y - x1.y;
            int gcd = gcd(diffx, diffy);
            diffx /= gcd;
            diffy /= gcd;
            return diffx+","+(-diffy)+","+(diffy*x1.x-diffx*x1.y);
        }
    }

    private int gcd(int a, int b){
        if(Math.abs(b) > Math.abs(a)){
            int tmp = a;
            a = b;
            b = tmp;
        }
        while (b != 0){
            int rem = a % b;
            a = b;
            b = rem;
        }
        return a;
    }

    public static void main(String[] args) {
        Point[] points = {new Point(3,1), new Point(12,3), new Point(3,1), new Point(-6,-1)};
        System.out.println(new Number149().maxPoints(points));
//        Number149 n = new Number149();
//        System.out.println(n.gcd(-9,-3));
    }
}
