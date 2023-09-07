
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

class Main {
    static int N;
    static int[] dx={1,-1,-1,1};
    static int[] dy={1,-1,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr=new int[N][M];
        int[][][] dp=new int[N][M][3];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
                dp[i][j][0]=num;
                dp[i][j][1]=num;
                dp[i][j][2]=num;
            }
        }

        //0- > 오른쪽 1->아래 2->왼쪽
        for(int i=1;i<N;i++){
            dp[i][M-1][2]=987654321;
            dp[i][0][0]=987654321;
            for(int j=0;j<M;j++){
                if(j==0){
                    dp[i][j][1]=Math.min(dp[i-1][j][0],dp[i-1][j][2])+arr[i][j];
                    dp[i][j][2]=Math.min(dp[i-1][j+1][0],dp[i-1][j+1][1])+arr[i][j];
                }
                else if(j==M-1){
                    dp[i][j][0]=Math.min(dp[i-1][j-1][1],dp[i-1][j-1][2])+arr[i][j];
                    dp[i][j][1]=Math.min(dp[i-1][j][0],dp[i-1][j][2])+arr[i][j];
                }
                else{
                    dp[i][j][0]=Math.min(dp[i-1][j-1][1],dp[i-1][j-1][2])+arr[i][j];
                    dp[i][j][1]=Math.min(dp[i-1][j][0],dp[i-1][j][2])+arr[i][j];
                    dp[i][j][2]=Math.min(dp[i-1][j+1][0],dp[i-1][j+1][1])+arr[i][j];
                }

            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<M;i++){
            for(int j=0;j<3;j++){
                min=Math.min(min,dp[N-1][i][j]);
            }
        }
        System.out.println(min);














    }
}



