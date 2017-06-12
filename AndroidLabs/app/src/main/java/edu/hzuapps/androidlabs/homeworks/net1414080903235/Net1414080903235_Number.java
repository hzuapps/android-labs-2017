/**
 * Created by Administrator on 2017/6/10.
 */

public abstract class Net1414080903235_Number {
    // 定义81个数字
    // str1、str2 各代表一个关卡
    private final String str1 = "600040800084005032000090700563180400009027000708604391" +
            "392476518150900200047512063";
    private final String str2 = "102004007000080000006000000050000380000000000000902000" +
            "000000070000000102089030000";

    // 实例化一个下标81的数组
    private int number[] = new int[9*9];

    // 存储不可用数据
    private int used[][][] = new int[9][9][];

    public void Number(){
        number = fromPuzzleString(str1);
    }

    public void Number(int str){
        if (str == 1){
            number = fromPuzzleString(str1);
        }else if (str == 2){
            number = fromPuzzleString(str2);
        }
        calculateAllUsedTiles(); // 获取当前关卡不可用数字数组
    }

    // 把81个数字设置到数组中，为0的设置为空
    private int[] fromPuzzleString(String str) {
        int[] number = new int[str.length()];
        for (int i = 0; i < number.length; i++) {
            number[i] = str.charAt(i) - '0';
        }
        return number;
    }

    // 根据数字在第几行第几个，获取其在数组中的下表
    private int getTile(int x, int y){
        //return number[y * 9 + x];
        if (y * 9 + x < 81){
            return number[y * 9 + x];
        }else {
            return 0;
        }
    }

    // 获取数字的字符串类型
    public String getTileString(int x, int y){
        int v = getTile(x,y);
        if (v == 0){
            return "";
        }else
            return String.valueOf(v);
    }






    public int[] getUsedTilesByCoor(int x,int y){
        return used[x][y];
    }

    public void calculateAllUsedTiles() {
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                used[x][y] = calculateUsedTiles(x, y);
            }
        }
    }

    /**
     * 获取当前关卡不可用数字数组
     */
    public int[] calculateUsedTiles(int x, int y) {
        int c[] = new int[9];

        for (int i = 0; i < 9; i++) {
            if (i == y)
                continue;
            int t = getTile(x, i);
            if (t != 0)
                c[t - 1] = t;
        }

        for (int i = 0; i < 9; i++) {
            if (i == x)
                continue;
            int t = getTile(i, y);
            if (t != 0)
                c[t - 1] = t;
        }

        int startx = (x / 3) * 3;
        int starty = (y / 3) * 3;
        for (int i = startx; i < startx + 3; i++) {
            for (int j = starty; j < starty + 3; j++) {
                if (i == x && j == y)
                    continue;
                int t = getTile(i, j);
                if (t != 0)
                    c[t - 1] = t;
            }
        }
        // compress
        int nused = 0;
        for (int t : c) {
            if (t != 0)
                nused++;
        }
        int c1[] = new int[nused];
        nused = 0;
        for (int t : c) {
            if (t != 0)
                c1[nused++] = t;
        }
        return c1;
    }

    public abstract int intValue();

    public abstract long longValue();

    public abstract float floatValue();

    public abstract double doubleValue();
}