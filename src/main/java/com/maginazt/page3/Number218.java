package com.maginazt.page3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaotao on 2016/9/12.
 */
public class Number218 {

    private static final int LEFT_INDEX = 0;
    private static final int RIGHT_INDEX = 1;
    private static final int HEIGHT_INDEX = 2;

    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> tempList = new ArrayList<>();
        if(buildings != null && buildings.length > 0){
            int startCheckIndex = 0;
            result.add(new int[]{buildings[0][LEFT_INDEX], buildings[0][HEIGHT_INDEX]});
            result.add(new int[]{buildings[0][RIGHT_INDEX], 0});
            for(int i=1;i<buildings.length;i++){
                int[] nextBuilding = buildings[i];
                //1.first try to add/update the accending corner
                int[] lastPoint = result.get(result.size()-1);
                //buildings
                //          building
                if(nextBuilding[LEFT_INDEX] > lastPoint[0]){
                    startCheckIndex = result.size();
                    result.add(new int[]{nextBuilding[LEFT_INDEX], nextBuilding[HEIGHT_INDEX]});
                    result.add(new int[]{nextBuilding[RIGHT_INDEX], 0});
                }
                //buildings
                //        building
                else if(nextBuilding[LEFT_INDEX] == lastPoint[0]){
                    startCheckIndex = result.size() - 1;
                    if(nextBuilding[HEIGHT_INDEX] != result.get(result.size()-2)[1]){
                        result.get(result.size()-1)[1] = nextBuilding[HEIGHT_INDEX];
                        result.add(new int[]{nextBuilding[RIGHT_INDEX], 0});
                    }
                    else{
                        result.get(result.size()-1)[0] = nextBuilding[RIGHT_INDEX];
                    }
                }
                //buildings
                //      building
                else{
                    tempList.clear();
                    for(int checkIndex=startCheckIndex;checkIndex<result.size();checkIndex++){
                        int[] checkPoint = result.get(checkIndex);

                    }
                }
            }
        }
        return result;
    }
}
