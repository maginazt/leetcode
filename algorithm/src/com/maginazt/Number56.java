package com.maginazt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Administrator on 2016/7/27.
 */
public class Number56 {

    private static final Comparator<Interval> cmp = new Comparator<Interval>() {
        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start < o2.start ? -1 : (o1.start == o2.start ? 0 : 1);
        }
    };

    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size()>1){
            List<Interval> result = new ArrayList<>();
            Collections.sort(intervals, cmp);
            int start = intervals.get(0).start;
            int end = intervals.get(0).end;
            for(int i=1;i<intervals.size();i++){
                Interval current = intervals.get(i);
                if(current.start >= start && current.start <= end){
                    end = Math.max(end, current.end);
                }
                else{
                    result.add(new Interval(start, end));
                    start = current.start;
                    end = current.end;
                }
            }
            result.add(new Interval(start, end));
            return result;
        }
        else
            return intervals;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(15,18));
        System.out.println(new Number56().merge(intervals));
    }
}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        return "["+start+","+end+"]";
    }
}
