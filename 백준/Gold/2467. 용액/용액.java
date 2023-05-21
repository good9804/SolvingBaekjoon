
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.*;
import java.util.*;

class Main {
    static int size;
    static ArrayList<Integer> neg;
    static ArrayList<Integer> pos;
    static StringBuilder sb;
    static int min=Integer.MAX_VALUE;
    static boolean iszero=false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        neg = new ArrayList<>();
        pos = new ArrayList<>();
        sb = new StringBuilder();
        size = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){

            int number = Integer.parseInt(st.nextToken());
            if(number>=0){
                pos.add(number);
            }else neg.add(number);

        }
        if(pos.size()>=2){
            if(min>pos.get(0)+ pos.get(1)){
                min=pos.get(0)+ pos.get(1);
                sb.append(pos.get(0)).append(" ").append(pos.get(1));
            }
        }
        if(neg.size()>=2){
            if(min>Math.abs(neg.get(0)+ neg.get(1))){
                min=Math.abs(neg.get(neg.size()-1)+ neg.get(neg.size()-2));
                sb.setLength(0);
                sb.append(neg.get(neg.size()-2)).append(" ").append(neg.get(neg.size()-1));
            }
        }
        for(int i=0;i<neg.size();i++){
            binarysearch(Math.abs(neg.get(i)));
            if(iszero){
                System.out.println(sb);
                return;
            }
        }
        System.out.println(sb);
    }

    static void binarysearch(int answer){
        int start=0;
        int end= pos.size()-1;
        while (start<=end){
            int mid=(start+end)/2;
            if(answer>pos.get(mid)){
                start=mid+1;
            }else if(answer< pos.get(mid)){
                end=mid-1;
            }else{
                sb.setLength(0);
                sb.append(-1*answer).append(" ").append(pos.get(mid));
                iszero=true;
                return;
            }
        }
        if(start>=0&&start<=pos.size()-1){
            if(min>Math.abs(answer-pos.get(start))){
                sb.setLength(0);
                sb.append(-1*answer).append(" ").append(pos.get(start));
                min=Math.abs(answer-pos.get(start));
            }
        }
        if(end>=0&&end<=pos.size()-1){
            if(min>Math.abs(answer-pos.get(end))){
                sb.setLength(0);
                sb.append(-1*answer).append(" ").append(pos.get(end));
                min=Math.abs(answer-pos.get(end));
            }
        }

    }
}








