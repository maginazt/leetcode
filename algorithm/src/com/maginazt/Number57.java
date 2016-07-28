package com.maginazt;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/28.
 */
public class Number57 {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals.size()>0){
            //find the insert position
            int index = findPosition(intervals, newInterval);
            //only to check the last
            if(index >= intervals.size()){
                Interval last = intervals.get(intervals.size()-1);
                //merge condition
                if(newInterval.start <= last.end){
                    last.end = Math.max(last.end, newInterval.end);
                }
                //don't merge
                else
                    intervals.add(newInterval);
                return intervals;
            }
            else{
                List<Interval> result = new ArrayList<>();
                //skip the intervals before index - 1
                for(int i=0;i<index-1;i++)
                    result.add(intervals.get(i));
                int start = newInterval.start;
                int end = newInterval.end;
                //try to merge index - 1
                if(index > 0){
                    Interval pre = intervals.get(index-1);
                    //merge
                    if(newInterval.start <= pre.end){
                        start = pre.start;
                        end = Math.max(pre.end, newInterval.end);
                    }
                    //don't merge
                    else
                        result.add(pre);
                }
                //merge the intervals after
                while(index < intervals.size()){
                    Interval after = intervals.get(index);
                    //merge
                    if(after.start <= end){
                        end = Math.max(after.end, end);
                        ++index;
                    }
                    //don't merge
                    else
                        break;
                }
                result.add(new Interval(start, end));
                //skip the rest
                for(int i=index;i<intervals.size();i++)
                    result.add(intervals.get(i));
                return result;
            }
        }
        else{
            intervals.add(newInterval);
            return intervals;
        }
    }

    private int findPosition(List<Interval> intervals, Interval newInterval) {
        int low = 0;
        int high = intervals.size()-1;
        while(low < high){
            int mid = ((high - low) >> 1) + low;
            int cur = intervals.get(mid).start;
            if(cur == newInterval.start)
                return mid;
            else if(cur > newInterval.start)
                high = mid;
            else
                low = mid+1;
        }
        if(intervals.get(low).start > newInterval.start)
            return low;
        else
            return low+1;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,2));
        intervals.add(new Interval(3,5));
        intervals.add(new Interval(6,7));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(12,16));
        System.out.println(new Number57().insert(intervals, new Interval(4,9)));
    }
}
