package Baekjoon.수학;
import java.util.*;
import java.io.*;

class P1111 {
    public static void main(String[] args)throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	int n = Integer.parseInt(br.readLine());
    	int[] arr = new int[n];
    	
    	List<ArrayList<Integer>> list = new ArrayList<>();
    	
    	
    	StringTokenizer st = new StringTokenizer(br.readLine()," ");
    	for (int i=0;i<n;i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	if (n == 1) {
    		sb.append("A");
    	} else if (n == 2 && arr[0] == arr[1]) {
    		sb.append(arr[0]);
        } else if (n ==2 && arr[0] == 0) {
    		sb.append(arr[1]+arr[1]);
    	} else if (n == 2 && arr[0] != arr[1]) {
    		sb.append("A");
    	} 
    	
    	
    	else {
        	for (int i=-500;i<500;i++) {
        		ArrayList<Integer> tmp = new ArrayList<>();
        		for (int j=-500;j<500;j++) {
            		Boolean flag = true;
        			for (int k=0; k<n-1;k++) {
        				if (arr[k]*i+j != arr[k+1]) {
        					flag = false;
        					break;
        				}
        			}
        			if (flag == true) {
        				tmp.add(i);
            			tmp.add(j);
            			list.add(tmp);
        			}
        		}
        	}
        	if (list.size() == 0) {
        		sb.append("B");
        	} 
        	else {
            	int first_value = arr[n-1]*list.get(0).get(0)+list.get(0).get(1);

        		if (list.size() == 1) {
        			sb.append(first_value);
        		} else {
                	for (int i=1;i<list.size();i++) {
                		boolean check = true;
                		if (first_value != arr[n-1]*list.get(i).get(0) + list.get(i).get(1)) {
                			check = false;
                			break;
                		}
                		if (check == true) {
                			sb.append(first_value);
                		} else {
                			sb.append("A");
                		}
                	}
        		}

        	}
    	}
    	System.out.println(sb);	
    }
}