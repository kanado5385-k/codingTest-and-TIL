package level3;
import java.util.Arrays;

public class simulation2 {
class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        
        int keySize = key.length; // M
        int lockSize = lock.length; // N
        
        int extendSize = lockSize * 3;
        int[][] extendLock = new int[extendSize][extendSize];
        
        for (int i = 0; i < lockSize; i++) {
            for (int j = 0; j < lockSize; j++) {
                extendLock[i + lockSize][j + lockSize] = lock[i][j];
            }
        }
        
        int[][] turnedKey = new int[key.length][];
        for (int i = 0; i < key.length; i++) {
            turnedKey[i] = Arrays.copyOf(key[i], key[i].length);
        }
        
        for (int k = 0; k < 4; k++) {
            turnedKey = turnKey(turnedKey);
            
            
            for (int i = 0; i <= extendSize - keySize; i++) {
                for (int j = 0; j <= extendSize - keySize; j++) {
                    int[][] copyOfExLock = new int[extendLock.length][];
                    for (int c = 0; c < extendLock.length; c++) {
                        copyOfExLock[c] = Arrays.copyOf(extendLock[c], extendLock[c].length);
                    }
                    
                    for (int q = 0; q < keySize; q++) {
                        for (int w = 0; w < keySize; w++) {
                            copyOfExLock[i + q][j + w] = copyOfExLock[i + q][j + w] + turnedKey[q][w];
                        }
                    }
                    
                    boolean isOpenAble = true;
                    for (int m = 0; m < lockSize; m++) {
                        for (int n = 0; n < lockSize; n++) {
                            if (copyOfExLock[m + lockSize][n + lockSize] != 1) isOpenAble = false;
                        }
                    }
                    
                    if (isOpenAble) {
                        answer = true;
                        return answer;
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
                turnedKey[j][n - i -1] = key[i][j];
            }
        }
        
        return turnedKey;
    }
}
}
