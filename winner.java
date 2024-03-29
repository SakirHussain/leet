import java.util.*;

class Node {
    int idx;
    Node left, right;
}

class Main {
    static Node createNode(int idx) {
        Node t = new Node();
        t.left = t.right = null;
        t.idx = idx;
        return t;
    }

    static void traverseHeight(Node root, int[] arr, int[] res) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        if (root.left != null && res[0] > arr[root.left.idx] && root.left.idx != root.idx) {
            res[0] = arr[root.left.idx];
            traverseHeight(root.right, arr, res);
        } else if (root.right != null && res[0] > arr[root.right.idx] && root.right.idx != root.idx) {
            res[0] = arr[root.right.idx];
            traverseHeight(root.left, arr, res);
        }
    }

    static void findSecondMin(int[] arr, int n) {
        List<Node> li = new LinkedList<>();
        Node root = null;
        for (int i = 0; i < n; i += 2) {
            Node t1 = createNode(i);
            Node t2 = null;
            if (i + 1 < n) {
                t2 = createNode(i + 1);
                root = (arr[i] < arr[i + 1]) ? createNode(i) : createNode(i + 1);
                root.left = t1;
                root.right = t2;
                li.add(root);
            } else {
                li.add(t1);
            }
        }
        int lsize = li.size();
        while (lsize != 1) {
            int last = (lsize & 1) == 1 ? lsize - 2 : lsize - 1;
            for (int i = 0; i < last; i += 2) {
                Node f1 = li.remove(0);
                Node f2 = li.remove(0);
                root = (arr[f1.idx] < arr[f2.idx]) ? createNode(f1.idx) : createNode(f2.idx);
                root.left = f1;
                root.right = f2;
                li.add(root);
            }
            if ((lsize & 1) == 1) {
                li.add(li.remove(0));
            }
            lsize = li.size();
        }
        int[] res = {Integer.MAX_VALUE};
        traverseHeight(root, arr, res);
        System.out.println("Minimum: " + arr[root.idx] + ", Second minimum: " + res[0]);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        findSecondMin(arr, n);
    }
}
