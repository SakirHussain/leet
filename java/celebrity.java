import java.util.Scanner;

public class celebrity {

    public static boolean check_columns(int index,int matrix[][],int n){

        for(int j=0;j<n;j++){
            if(j==index){
                continue;
            }
            else if(matrix[j][index]==0){
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]){
        System.out.println("Enter number of guests(greater than 2): ");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(); 
        int matrix[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]=sc.nextInt();
            }
        }
        int flag=0;

        for (int c = 0; c < n; c++) {
            int flag2 = 0;
            for (int d = 0; d < n; d++) {
                if (matrix[c][d] == 1) {
                    flag2 = 1;
                    break;
                }
            }
            if (flag2 == 0) {
                if (check_columns(c, matrix, n)) {
                    System.out.println(c+" is a celebrity");
                    flag = 1;
                }
            }
        }
        if(flag==0){
            System.out.println("-1");
        }
        sc.close();
    }
}
