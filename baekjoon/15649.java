import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        // 20시작
        // 27종료
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        String[] temp = first.split(" ");
        int range = Integer.parseInt(temp[0]);
        int count = Integer.parseInt(temp[1]);
        maker(count, new int[range], "");
    }

    public static void maker(int count, int[] used, String result) {
        if (count == 0) {
            System.out.println(result.substring(1, result.length()));
            return;
        }
        for (int i = 0; i < used.length; i++) {
            if (used[i] == 0) {
                used[i] = 1;
                maker(count - 1, used, result +" " + (i+1));
                used[i] = 0;
            }
        }
    }
}