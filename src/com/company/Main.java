package com.company;
import java.util.*;


public class Main {
    public static final int SIZER1 = 19;
    public static final int SIZER2 = 22;
    public static final int SIZER3 = 19;


    public static void main(String[] args) {

        int[] r1 = {1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1};
        int[] r2 = {1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1};
        int[] r3 = {1,1,1,0,0,0,0,1,1,1,1,0,0,0,0,1,1,1,1,0,0,0,0};


        int i,j;
        int m;

        for(i = 0; i < 9; i++){
            m = major(r1[8],r2[10],r3[10]);

            System.out.printf("R1: ");
            if(r1[8] == m){
                int t = r1[13] ^ r1[16] ^ r1[17] ^ r1[18];
                for(j = SIZER1 - 1; i >= 0; i--){
                    if(j == 0){
                        r1[j] = t;
                    }
                    else{
                        r1[j] = r1[j - 1];
                    }
                }
            }
            for(j = 0; j < SIZER1; j++){
                System.out.printf("%d",r1[j]);
            }

            System.out.printf("\nR2: ");
            if(r2[10] == m){
                int t = r2[20] ^ r2[21];
                for(j = SIZER2 - 1; j >= 0; j--){
                    if(j == 0){
                        r2[j] = t;
                    }
                    else{
                        r2[j] = r2[j - 1];
                    }
                }
            }
            for(j = 0; j < SIZER2; j++){
                System.out.printf("%d",r2[j]);
            }

            System.out.printf("\nR3: ");

            if(r3[10] == m){
                int t = r3[7] ^ r3[20] ^ r3[21] ^ r3[22];
                for(j = SIZER3 - 1; j >= 0; j--){
                    if(j == 0){
                        r3[j] = t;
                    }
                    else{
                        r3[j] = r3[j - 1];
                    }
                }
            }
            for(j = 0; j < SIZER3; j++){
                System.out.printf("%d",r3[j]);
            }

            if(i < 8){
                int key = r1[SIZER1-1] ^ r2[SIZER2-1] ^ r3[SIZER3-1];
                System.out.printf("\nКлючевой поток = %d ^ %d ^ %d = %d",r1[SIZER1-1],r2[SIZER2-1],r3[SIZER3-1],key);
                System.out.printf("\n\n");
            }
        }
    }

    public static int major(int x,int y,int z){
        int m;
        if(x == 0){
            if(y == 0 || z == 0) {
                m = 0;
            }
            else{
                m = 1;
            }
        }
        else{
            if(y == 1 || z == 1){
                m = 1;
            }
            else {
                m = 0;
            }
        }

        return m;
    }
}
