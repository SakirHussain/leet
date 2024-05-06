import java.util.*;
public class subset {
    static boolean isSum(int set[],int n,int sum){
        if(sum==0){
            return true;
        }
        if(n==0){
            return false;
        }
        if(set[n-1]>sum){
            return isSum(set,n-1,sum);
        }
        return isSum(set,n-1,sum)||isSum(set,n-1,sum-set[n-1]);
    }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int sum=sc.nextInt();
        System.out.println(isSum(arr, n, sum));
        sc.close();
    }
}