import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // 33 시작
        // 38 종료
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
        int last = 0;
        try {
            last = Integer.parseInt(String.valueOf(result.charAt(result.length()-1)));
        } catch ( StringIndexOutOfBoundsException e) {
            last = 0;
        }
        for (int i = 0; i < used.length; i++) {
            if (i+1 < last) {
                continue;
            }
            if (used[i] == 0 ) {
                used[i] = 1;
                maker(count - 1, used, result +" " + (i+1));
                used[i] = 0;
            }
        }
    }
}