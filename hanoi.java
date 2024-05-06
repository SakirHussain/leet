import java.util.*;
class TowerOfHanoi{

    static void move_disk(Stack<Integer> source, Stack<Integer> destination, char s, char d){
        if(source.isEmpty()){
            int x=destination.pop();
            source.push(x);
            System.out.println("Moving the disk "+x+" from "+d+" to "+s);
        }
        else if(destination.isEmpty()){
            int x=source.pop();
            destination.push(x);
            System.out.println("Moving the disk "+x+" from "+s+" to "+d);
        }
        else if(source.peek()>destination.peek()){
            int x=destination.pop();
            source.push(x);
            System.out.println("Moving the disk "+x+" from "+d+" to "+s);
        }
        else{
            int x=source.pop();
            destination.push(x);
            System.out.println("Moving the disk "+x+" from "+s+" to "+d);
        }
    }


    public static void main(String args[]){

        //accept number of disks
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of disks: ");
        int num_of_disks=sc.nextInt();
        Stack<Integer> source=new Stack<>();
        Stack<Integer> destination=new Stack<>();
        Stack<Integer> auxilliary=new Stack<>();

        int total_num_of_moves=(int)(Math.pow(2,num_of_disks)-1);
        char s='S';
        char d='D';
        char a='A';
        if(num_of_disks%2==0){
            char tmp=d;
            d=a;
            a=tmp;  
        }

        for(int i=num_of_disks;i>=1;i--){
            source.push(i);
        }

        for(int i=1;i<=total_num_of_moves;i++){
            if(i%3==1){
                move_disk(source, destination, s, d);
            }
            else if(i%3==2){
                move_disk(source, auxilliary, s, a);
            }
            else if(i%3==0){
                move_disk(auxilliary, destination, a, d);
            }
        }
        sc.close();
    }

}