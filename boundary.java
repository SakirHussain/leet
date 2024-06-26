import java.util.*;
import java.util.Map.Entry;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}
class Main {
    static Node root;
    static Node build(String[] s) {
        if ("N".equals(s[0]) || s.length == 0)
            return null;
        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            Node curr = q.poll();
            String cval = s[i];
            if (!"N".equals(cval)) {
                curr.left = new Node(Integer.parseInt(cval));
                q.add(curr.left);
            }
            i++;
            if (i >= s.length)
                break;
            cval = s[i];
            if (!"N".equals(cval)) {
                curr.right = new Node(Integer.parseInt(cval));
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }
    // Print the leaves
    void printLeaves(Node node) {
        if (node == null)
            return;
        printLeaves(node.left);
        if (node.left == null && node.right == null)
            System.out.print(node.data + " ");
        printLeaves(node.right);
    }
    // Left boundary
    void printBoundaryLeft(Node node) {
        if (node == null)
            return;
        if (node.left != null) {
            System.out.print(node.data + " ");
            printBoundaryLeft(node.left);
        } else if (node.right != null) {
            System.out.print(node.data + " ");
            printBoundaryLeft(node.right);
        }
    }
    // Right boundary
    void printBoundaryRight(Node node) {
        if (node == null)
            return;
        if (node.right != null) {
            printBoundaryRight(node.right);
            System.out.print(node.data + " ");
        } else if (node.left != null) {
            printBoundaryRight(node.left);
            System.out.print(node.data + " ");
        }
    }
    // Print boundary
    void printBoundary(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        printBoundaryLeft(node.left);
        printLeaves(node.left);
        printLeaves(node.right);
        printBoundaryRight(node.right);
    }
    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main ob = new Main();
        String[] s = sc.nextLine().split(" ");
        root = build(s);
        ob.printBoundary(root);
    }
}
