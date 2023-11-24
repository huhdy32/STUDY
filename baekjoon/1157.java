import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class Main {

    // 시작시간 10:10
    // 종료시간 10:26
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        HashMap<Character, Integer> map = new HashMap<>();
        input = input.toLowerCase();
        // 해시맵을 이용해 각각의 문자에 대해 갯수를 저장한다.
        for (int i=0; i< input.length(); i++) {
            char tempChar = input.charAt(i);
            map.put(tempChar, map.getOrDefault(tempChar, 0) + 1);
        }

        int maxValue = -1;
        char maxChar = 'z';
        // 저장된 값중에 최대 빈도를 가지는 문자를 찾아낸다.
        for (char temp : map.keySet()) {
            if (maxValue < map.get(temp)) {
                maxChar = temp;
                maxValue = map.get(temp);
            }
        }
        String answer = String.valueOf(maxChar);
        answer = answer.toUpperCase();

        // 최대값이 중복되었었다면 ?를 리턴한다.
        int duplicateCount = 0;
        for (char temp : map.keySet()) {
            if (map.get(temp) == maxValue) {
                duplicateCount ++;
            }
        }
        if (duplicateCount > 1) {
            answer = "?";
        }
        System.out.println(answer);
    }
}