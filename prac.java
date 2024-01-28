
import java.io.*;
import java.util.*;

class P15927 {
    public static void main(String[] args)throws Exception {
        int n = 1;
        for (int i=0;i<5;i++) {
            for (int j=0;j<5-i;j++) {
                System.out.printf("%3d",n);
                n++;
            }
            for (int j=0;j<i;j++) {
                System.out.print("   ");
            }
            System.out.println();
        }
    }
}