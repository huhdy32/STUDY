import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // 시작시간 10:30
    // 종료시간
    public static int maxHeight = 0;
    public static int minTime = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] initData = br.readLine().split(" ");

        // chrlghk epdlxj
        int rowSize = Integer.parseInt(initData[0]);
        int colSize = Integer.parseInt(initData[1]);
        int itemCount = Integer.parseInt(initData[2]);

        int[][] map = new int[rowSize][colSize];
        // 맵 정보 입력받기
        for (int i = 0; i < rowSize; i++) {
            String[] rowData = br.readLine().split(" ");
            for (int k = 0; k < rowData.length; k++) {
                map[i][k] = Integer.parseInt(rowData[k]);
            }
        }
        start(map, itemCount, 0);
        System.out.println(minTime + " " + maxHeight);
    }

    public static void start(int[][] map, int count, int time) {
        int[][] tempmap = new int[map.length][map[0].length];
        for (int i=0 ; i< map.length; i++) {
            for (int k=0; k< map[i].length; k++) {
                tempmap[i][k] = map[i][k];
            }
        }
        addBlock(map, count, time);
        removeBlock(tempmap, count, time);
    }

    public static void checkAll(int[][] map, int currTime) {
        int height = map[0][0];
        for (int i = 0; i < map.length; i++) {
            for (int k = 0; k < map[i].length; k++) {
                if (height != map[i][k]) {
                    return;
                }
            }
        }
        if (currTime < minTime) {
            maxHeight = height;
            minTime = currTime;
        }
        if (maxHeight < height && currTime == minTime) {
            maxHeight = height;
            minTime = currTime;
        }
    }

    public static void addBlock(int[][] map, int itemCount, int currTime) {
        if (itemCount == 0) return;

        int min = Integer.MAX_VALUE;
        int rowIdx = 0;
        int colIdx = 0;
        for (int i = 0; i < map.length; i++) {
            for (int k = 0; k < map[i].length; k++) {
                if (min > map[i][k]) {
                    rowIdx = i;
                    colIdx = k;
                    min = map[i][k];
                }
            }
        }

        if (min > 256) {
            return;
        }

        map[rowIdx][colIdx]++;
        currTime += 1;
        itemCount--;
        // 전부 같네 ㅅㅂ?
        checkAll(map, currTime);
        addBlock(map, itemCount, currTime);
    }

    public static void removeBlock(int[][] map, int itemCount, int currTime) {
        int max = Integer.MIN_VALUE;
        int rowIdx = 0;
        int colIdx = 0;
        for (int i = 0; i < map.length; i++) {
            for (int k = 0; k < map[i].length; k++) {
                if (max < map[i][k]) {
                    rowIdx = i;
                    colIdx = k;
                    max = map[i][k];
                }
            }
        }
        map[rowIdx][colIdx]--;
        currTime += 2;
        itemCount++;

        checkAll(map, currTime);
        if (max == 0) return;
        removeBlock(map, itemCount, currTime);
    }
}