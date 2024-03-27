package daily.year2024.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B3018 {
    final static int SUN_YOUNG = 1; // Sunyoung is always labelled '1'
    static int[] perceived; // tracks people who have learned a song
    public static int[] findGenius(int total, List<Integer> members) {
        for (Integer member : members) {
            perceived[member-1] = 1;
        }

        Arrays.sort(perceived); // sort in ascending order

        return perceived; // returns anything that is of type 'integer'
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, int[]> genius = new HashMap<>();
        int N = Integer.parseInt(br.readLine());

        int E = Integer.parseInt(br.readLine());

        for (int i = 0; i < E; i++) {
            perceived = new int[N];
            List<Integer> participants = new ArrayList<>();
            String[] infos = br.readLine().split(" ");
            int K = Integer.parseInt(infos[0]);
            for (int j = 1; j <= K; j++) {
                participants.add(Integer.parseInt(infos[j]));
            }
            genius.put(String.valueOf(i), findGenius(K, participants));
        }

        System.out.println(genius);
    }
}
