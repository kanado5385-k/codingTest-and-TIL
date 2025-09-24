package level3;

public class bruteForce {
    class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        
        int m = key.length;
        int n = lock.length;
        
        int extendLockSize = n * 3;
        int[][] extendLock = new int[extendLockSize][extendLockSize];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                extendLock[i + n][j + n] = lock[i][j];
            }
        }
        
        for (int k = 0; k < 4; k++) {
                key = turnKey(key);
            
            
            for (int x = 0; x < extendLockSize - m; x++) {
                for (int y = 0; y < extendLockSize - m; y++) {
                    for(int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            extendLock[x + i][y + j] += key[i][j];
                        }
                    }
                    
                    if (check(extendLock, n)) {
                        answer = true;
                    }
                    
                    for(int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            extendLock[x + i][y + j] -= key[i][j];
                        }
                    }
                }
            }
            
            
        }

        return answer;
    }
    
    public int[][] turnKey(int[][] key) {
        int n = key.length;
        int[][] turnedKey = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                turnedKey[j][n - i - 1] = key[i][j];
            }
        }
        
        return turnedKey;
    }
    
    public boolean check(int[][] extendLock, int realSize) {
        for (int i = 0; i < realSize; i++) {
            for (int j = 0; j < realSize; j++) {
                if (extendLock[i + realSize][j + realSize] != 1) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
}
