package com.maginazt.page10;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zhaotao
 * @date: 2020/12/7 13:36
 */
public class TopVotedCandidate {

    private int[] times;
    private int[] topVotedSoFar;

    public TopVotedCandidate(int[] persons, int[] times) {
        calculateTopVotedSoFar(persons);
        this.times = times;
        this.topVotedSoFar = persons;
    }

    private void calculateTopVotedSoFar(int[] persons) {
        int mostVotes = 0;
        Map<Integer, Integer> voteMap = new HashMap<>();
        for (int i = 0; i < persons.length; i++) {
            int votes = voteMap.merge(persons[i], 1, Integer::sum);
            if (votes >= mostVotes) {
                mostVotes = votes;
            } else {
                persons[i] = persons[i - 1];
            }
        }
    }

    public int q(int t) {
        int index = findT(t);
        return topVotedSoFar[index];
    }

    private int findT(int t) {
        if (t >= times[times.length - 1]) {
            return times.length - 1;
        }
        int low = 0;
        int high = times.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (times[mid] == t) {
                return mid;
            } else if (times[mid] < t) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return times[low] > t ? low - 1 : low;
    }

    public static void main(String[] args) {
        TopVotedCandidate topVotedCandidate = new TopVotedCandidate(new int[]{0, 1, 1, 0, 0, 1, 0}, new int[]{0, 5, 10, 15, 20, 25, 30});
        Assert.assertEquals(0, topVotedCandidate.q(3));
        Assert.assertEquals(1, topVotedCandidate.q(12));
        Assert.assertEquals(1, topVotedCandidate.q(25));
        Assert.assertEquals(0, topVotedCandidate.q(15));
        Assert.assertEquals(0, topVotedCandidate.q(24));
        Assert.assertEquals(1, topVotedCandidate.q(8));
    }
}
