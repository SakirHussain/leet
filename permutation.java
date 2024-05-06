import java.util.*;
class Permutation{

    public static void main(String args[]){
        
        //creating stack
        Stack<Integer> st=new Stack<>();

        //enter size of array1
        System.out.println("Enter size1");
        Scanner sc=new Scanner(System.in);
        int n1=sc.nextInt();
    
        //enter array1
        System.out.println("Enter "+n1+" elements:");
        for(int count1=0;count1<n1;count1++){
            st.push(sc.nextInt());
        }

        //enter size of array2
        System.out.println("Enter size2");
        int n2=sc.nextInt();
        int check[]=new int[n2];

        //enter array2
        System.out.println("Enter "+n2+" elements:");
        for(int count2=0;count2<n2;count2++){
            check[count2]=sc.nextInt();
        }

        if(n1!=n2){
            System.out.println("NO");
        }
        else{
            for(int i=0;i<n1;i++){
                int a=st.pop();
                for(int j=0;j<n2;j++){
                    if(a==check[j]){
                        check[j]=Integer.MIN_VALUE;
                    }
                }
            }

            boolean notPermutation=false;
            for(int j2=0;j2<n2;j2++){
                if(check[j2]!=-Integer.MIN_VALUE){
                    notPermutation=true;
                    break;
                }
            }

            if(notPermutation){
                System.out.println("NO");
            }
            else{
                System.out.println("YES");
            }
            sc.close();
        }

    }
}