import java.util.*;
public class sweets {
	static boolean checkCount(int []arr, int n, int k){
		int count;
		for (int i = 0; i < n; i++){
			count = 0;
			for (int j = 0; j < n; j++){
				if (arr[j] == arr[i])count++;
				if (count > 2 * k)return false;
			}
		}return true;
	}
      static public void main (String[] args){
	      Scanner s=new Scanner(System.in);
	      int n=s.nextInt(); int k = s.nextInt();
		int []arr =new int[n];
		for(int i=0; i<n; i++)
		    arr[i]=s.nextInt();
		if(checkCount(arr, n, k)) System.out.println("Yes");
		else  System.out.println("No");
	}
}
