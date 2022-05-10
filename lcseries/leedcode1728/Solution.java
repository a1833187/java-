package qrxedu.leedcode1728;

/**
 * 根据博弈规则看是否需要考虑平局,不需要考虑平局就只考虑轮到某一方是是否能赢,不能赢则对方赢.
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    int m;
    int n;
    int K = 1000;
    String[] g;
    int catJ;
    int mouseJ;
    //别尼玛瞎打表!
    int[][][] cache = new int[1010][80][80];
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean canMouseWin(String[] grid, int catJump, int mouseJump) {
        g = grid;
        m = grid.length;
        n = grid[0].length();
        catJ = catJump;
        mouseJ = mouseJump;
        int[] cat = new int[2];
        int[] mouse = new int[2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) == 'C') {
                    cat[0] = i;
                    cat[1] = j;
                }
                if (grid[i].charAt(j) == 'M') {
                    mouse[0] = i;
                    mouse[1] = j;
                }
            }
        }
        return dfs(0, getIdx(cat[0],cat[1]),getIdx(mouse[0],mouse[1])) == 1;
    }

    public int dfs(int step, int cat,int mouse) {
        if (step > 1000) {
            return 2;
        }
        int catX = getXy(cat)[0];
        int catY = getXy(cat)[1];
        int mouseX = getXy(mouse)[0];
        int mouseY = getXy(mouse)[1];
        if (g[catX].charAt(catY) == 'F' || (catX == mouseX && catY == mouseY)) {
            return 2;
        }
        if (g[mouseX].charAt(mouseY) == 'F') {
            return 1;
        }
        if (cache[step][cat][mouse] != 0) {
            return cache[step][cat][mouse];
        }
        if (step % 2 == 0) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j <= mouseJ; j++) {
                    int x = mouseX + dir[i][0] * j;
                    int y = mouseY + dir[i][1] * j;
                    if (x < 0 || x >= m || y < 0 || y >= n) {
                        break;
                    }
                    if (g[x].charAt(y) == '#') {
                        break;
                    }

                    int t = dfs(step + 1, cat, getIdx(x, y));
                    if (t == 1) {
                        cache[step][cat][mouse] = 1;
                        return 1;
                    }
                }
            }
            cache[step][cat][mouse] = 2;
            return 2;
        } else {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j <= catJ; j++) {
                    int x = catX + dir[i][0] * j;
                    int y = catY + dir[i][1] * j;
                    if (x < 0 || x >= m || y < 0 || y >= n) {
                        break;
                    }
                    if (g[x].charAt(y) == '#') {
                        break;
                    }
                    int t = dfs(step + 1, getIdx(x, y), mouse);
                    if (t == 2) {
                        cache[step][cat][mouse] = 2;
                        return 2;
                    }
                }
            }
            cache[step][cat][mouse] = 1;
            return 1;
        }
    }

    public int getIdx(int x, int y) {
        return x * n + y;
    }

    public int[] getXy(int k) {
        return new int[]{k / n, k % n};
    }
}
