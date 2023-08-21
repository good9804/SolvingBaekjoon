
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] arr=new int[N][N];
        long[][] dp=new long[N][N];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0]=1;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(dp[i][j]<1){continue;}
                    if(i==N-1&&j==N-1){break;}
                if(isRange(i+arr[i][j],j)){
                    dp[i+arr[i][j]][j]+=dp[i][j];
                }
                if(isRange(i,j+arr[i][j])){
                    dp[i][j+arr[i][j]]+=dp[i][j];
                }
            }
        }
        System.out.println(dp[N-1][N-1]);




    }
    static boolean isRange(int x,int y){
        return x>=0&&x<N&&y>=0&&y<N;
    }

    }
