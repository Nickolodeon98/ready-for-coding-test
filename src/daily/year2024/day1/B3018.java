package daily.year2024.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B3018 {
    final static int SUN_YOUNG = 1; // Sunyoung is always labelled '1'
    static int count;
    static int[] perceived; // tracks people who have learned a song

    public static void findGenius(List<Integer> members) {
        boolean flag = false;
        for (Integer member : members) {
            if (perceived[member-1] >= 1) {
                flag = true;
                break;
            }
        }
        
        if (flag || members.contains(SUN_YOUNG)) {
            for (Integer member : members) {
                perceived[member - 1] += 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> genius = new HashMap<>();
        int N = Integer.parseInt(br.readLine());

        int E = Integer.parseInt(br.readLine());
        count = E;
        perceived = new int[N];

        for (int i = 0; i < E; i++) {
            List<Integer> participants = new ArrayList<>();
            String[] infos = br.readLine().split(" ");
            int K = Integer.parseInt(infos[0]);
            for (int j = 1; j <= K; j++) {
                participants.add(Integer.parseInt(infos[j]));
            }
            findGenius(participants);
            genius.put(String.valueOf(i), Arrays.toString(perceived));
        }

        for (int i = 0; i < perceived.length; i++) {
            if (perceived[i] == count) System.out.println(i+1);
        }

        System.out.println(Arrays.toString(perceived));
    }
}
