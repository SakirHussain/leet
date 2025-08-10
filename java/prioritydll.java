
public class prioritydll {

    public static Node head;
    public static Node rear;

    public static void initialize(){
        head=null;
        rear=null;
    }

    public static class Node{
        int data;
        int priority;
        Node prev,next;
        public Node(int d,int p){
            data=d;
            priority=p;
        }
    }

    public static void push(int val,int p){
        Node nn=new Node(val,p);
        if(head==null){
            nn.next=null;
            nn.prev=null;
            head=nn;
            rear=nn;
        }
        else{

            if(nn.priority<head.priority){
                nn.next=head;
                nn.prev=null;
                head.prev=nn;
                head=nn;
            }
            else if(nn.priority>rear.priority){
                nn.next=null;
                nn.prev=rear;
                rear.next=nn;
                rear=nn;
            }
            else{
                Node i=head.next;
                while(i.priority<nn.priority){
                    i=i.next;
                }
                nn.next=i;
                nn.prev=i.prev;
                (i.prev).next=nn;
                i.prev=nn;
            }
        }
    }

    public static int pop(){
        if(head==null){
            return -1;
        }
        else{
            int value=head.data;
            if(head.next==null){
                head=null;
            }
            else{
                head=head.next;
                head.prev=null;
            }
            return value;
        }
    }

    public static void main(String args[]){
        initialize();
        push(3, 2);
        push(2, 1);
        push(4, 4);
        push(6,5);
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
    }
}
