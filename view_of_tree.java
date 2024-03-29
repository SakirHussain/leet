import java.util.*;
import java.util.Map.Entry;

class Node {
    int data, hd;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
        this.hd = Integer.MAX_VALUE; // Corrected from INT_MAX
    }
}

class Main {
    static Node root;

    // Method to build the tree from input
    static Node build(String[] s) {
        if ("N".equals(s[0]) || s.length == 0) // Corrected string comparison
            return null;
        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            Node curr = q.poll();
            String cval = s[i];
            if (!"N".equals(cval)) { // Corrected string comparison
                int h = Integer.parseInt(cval);
                curr.left = new Node(h);
                q.add(curr.left);
            }
            i++;
            if (i >= s.length) break;
            cval = s[i];
            if (!"N".equals(cval)) { // Corrected string comparison
                int h = Integer.parseInt(cval);
                curr.right = new Node(h);
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }

    // Right View
    void rightView(Node root) {
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                Node curr = q.poll();
                if (i == n - 1) {
                    System.out.print(curr.data + " ");
                }
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
        }
    }

    // Left View
    void leftView(Node root) {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 1; i <= n; i++) {
                Node temp = queue.poll();
                if (i == 1) System.out.print(temp.data + " ");
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
        }
    }

    // Top View
    static void topView(Node root) {
        if (root == null) return;
        Queue<QueueObj> q = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>(); // Using TreeMap for natural order
        q.add(new QueueObj(root, 0));
        while (!q.isEmpty()) {
            QueueObj curr = q.poll();
            if (!map.containsKey(curr.hd))
                map.put(curr.hd, curr.node.data);
            if (curr.node.left != null) {
                q.add(new QueueObj(curr.node.left, curr.hd - 1));
            }
            if (curr.node.right != null) {
                q.add(new QueueObj(curr.node.right, curr.hd + 1));
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }
    }

    // Bottom View
    static void bottomView(Node root) {
        if (root == null) return;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Node> queue = new LinkedList<>();
        root.hd = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            int hd = temp.hd;
            map.put(hd, temp.data);
            if (temp.left != null) {
                temp.left.hd = hd - 1;
                queue.add(temp.left);
            }
            if (temp.right != null) {
                temp.right.hd = hd + 1;
                queue.add(temp.right);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }
    }

    // Auxiliary class for holding node and its horizontal distance
    static class QueueObj {
        Node node;
        int hd;

        QueueObj(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        root = build(s);
        Main ob = new Main();
        ob.rightView(root);
        System.out.println();
        ob.leftView(root);
        System.out.println();
        topView(root);
        System.out.println();
        bottomView(root);
    }
}
