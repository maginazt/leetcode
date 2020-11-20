package com.maginazt.page2;

import com.maginazt.structure.UndirectedGraphNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by zhaotao on 2016/8/27.
 */
public class Number133 {

    private static final Map<Integer, UndirectedGraphNode> cache = new HashMap<>();
    private static final LinkedList<UndirectedGraphNode> queue = new LinkedList<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node != null){
            cache.clear();
            queue.clear();
            UndirectedGraphNode newGraph = new UndirectedGraphNode(node.label);
            cache.put(newGraph.label, newGraph);
            queue.addLast(node);
            while (!queue.isEmpty()){
                UndirectedGraphNode oldNode = queue.removeFirst();
                List<UndirectedGraphNode> oldNeighbors = oldNode.neighbors;
                UndirectedGraphNode newNode = cache.get(oldNode.label);
                List<UndirectedGraphNode> newNeighbors = newNode.neighbors;
                for(UndirectedGraphNode oldNeighbor : oldNeighbors){
                    if(cache.containsKey(oldNeighbor.label))
                        newNeighbors.add(cache.get(oldNeighbor.label));
                    else{
                        UndirectedGraphNode newNeighbor = new UndirectedGraphNode(oldNeighbor.label);
                        cache.put(newNeighbor.label, newNeighbor);
                        newNeighbors.add(newNeighbor);
                        queue.addLast(oldNeighbor);
                    }
                }
            }
            return newGraph;
        }
        else
            return null;
    }
}
