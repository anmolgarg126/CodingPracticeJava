package main.java.leetcode;

import java.util.*;

public class RankTeamsByVotes_1366 {
    public static void main(String[] args) {
        var obj = new RankTeamsByVotes_1366();
        System.out.println(obj.rankTeams(new String[]{"ABC", "ACB", "ABC", "ACB", "ACB"}));
        System.out.println(obj.rankTeams(new String[]{"WXYZ", "XYZW"}));
        System.out.println(obj.rankTeams(new String[]{"ZMNAGUEDSJYLBOPHRQICWFXTVK"}));
    }

    private String rankTeams(String[] votes) {
        int positions = votes[0].length();
        Map<Character, int[]> map = new HashMap<>();
        for (String vote : votes) {
            for (int i = 0; i < positions; i++) {
                char c = vote.charAt(i);
                map.putIfAbsent(c, new int[positions]);
                map.get(c)[i]++;
            }
        }

        List<Character> ranks = new ArrayList<>(map.keySet());
        Collections.sort(ranks, (a, b) -> {
            int[] votesForTeamA = map.get(a);
            int[] votesForTeamB = map.get(b);

            for (int i = 0; i < positions; i++) {
                if (votesForTeamA[i] != votesForTeamB[i]) {
                    return votesForTeamB[i] - votesForTeamA[i];
                }
            }
            return a - b;
        });

        StringBuilder sb = new StringBuilder();
        for (char c : ranks) {
            sb.append(c);
        }
        return sb.toString();
    }
}
