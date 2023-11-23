import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        // 50 시작
        // 54 종료
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        String[] temp = first.split(" ");

        int range = Integer.parseInt(temp[0]);
        int count = Integer.parseInt(temp[1]);
        maker(count, range, "", 1);
        System.out.println(sb);
    }

    public static void maker(int count, int range, String result, int startIdx) {
        if (count == 0) {
            sb.append(result.substring(1, result.length()) + "\n");
            return;
        }

        for (int i = startIdx; i <= range; i++) {
            maker(count - 1, range, result + " " + i, i);
        }
    }
}