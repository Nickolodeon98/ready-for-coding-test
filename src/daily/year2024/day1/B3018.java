package daily.year2024.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B3018 {

    final static int SUN_YOUNG = 1;
    static int[] perceived;
    public static int findGenius(int total, List<Integer> members) {
        for (Integer member : members) {
            perceived[member-1] = 1;
        }

        System.out.println(Arrays.toString(perceived));

        return 1; // returns anything that is of type 'integer'
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> genius = new ArrayList<>();
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
            genius.add(findGenius(K, participants));

        }

        for (Integer g : genius) {
            System.out.println(g);
        }
    }
}
