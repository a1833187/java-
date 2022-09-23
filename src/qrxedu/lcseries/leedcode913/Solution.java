package qrxedu.lcseries.leedcode913;

/**
 * 博弈论问题:和记忆化搜索有关.为了实现题目中说明的每一次都采取最优策略,我们在模拟某一方的行为的时候,只考虑其能否赢,不能赢退而求其次
 * 看能否平局.
 * 博弈论的记忆化搜索经常会用到一个三维数组来存储之前走完的情况.:表示经过k步操作且玩家A处于i状态且玩家B处于j
 * 状态时比赛的输赢情况
 * @author qiu
 * @version 1.8.0
 */
@SuppressWarnings("all")
public class Solution {
    public boolean[] isVisitedC;
    public boolean[] isVisitedM;
    //表示走了k步后猫处于i位置且鼠处于j位置时的输赢情况.
    public int[][][] guess;
    public int n;

    public int catMouseGame(int[][] graph) {
        int m = graph.length;
        n = m;
        guess = new int[2 * m * m][m][m];
        isVisitedC = new boolean[m];
        isVisitedM = new boolean[m];
        for (int i = 0; i < 2 * m * m; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    guess[i][j][k] = -1;
                }
            }
        }
        return dfs(graph, 0, 2, 1);
    }

    public int dfs(int[][] graph, int step, int cat, int mouse) {
        if (mouse == 0) {
            return 1;
        }
        if (cat == mouse) {
            return 2;
        }
        if (step >= 2 * n * n) {
            return 0;
        }
        int ans = guess[step][cat][mouse];
        if (ans == -1) {
            if (step % 2 == 0) {
                boolean win = false, draw = false;
                for (int i : graph[mouse]) {
                    int t = dfs(graph, step + 1, cat, i);
                    if (t == 1) {
                        win = true;
                    } else if (t == 0) {
                        draw = true;
                    }
                    if (win) {
                        break;
                    }
                }
                if (win) {
                    ans = 1;
                } else if (draw) {
                    ans = 0;
                } else {
                    ans = 2;
                }
            } else {
                boolean win = false, draw = false;
                for (int i : graph[cat]) {
                    if (i == 0) {
                        continue;
                    }
                    int t = dfs(graph, step + 1, i, mouse);
                    if (t == 2) {
                        win = true;
                    } else if (t == 0) {
                        draw = true;
                    }
                    if (win) {
                        break;
                    }
                }
                if (win) {
                    ans = 2;
                } else if (draw) {
                    ans = 0;
                } else {
                    ans = 1;
                }
            }
        }
        guess[step][cat][mouse] = ans;
        return ans;

    }
}
