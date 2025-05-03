package BTrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class BinaryTree {

    // Tree traversal in Java

    public static class Node {
        int item;
        Node left, right;

        public Node(int key) {
            item = key;
            left = right = null;
        }
    }
    // Root of Binary Tree
    Node root;

    BinaryTree() {
        root = null;
    }

    void postorder(Node node) {
        if (node == null)
            return;

        // Traverse left
        postorder(node.left);
        // Traverse right
        postorder(node.right);
        // Traverse root
        System.out.print(node.item + "->");
    }

    void inorder(Node node) {
        if (node == null)
            return;

        // Traverse left
        inorder(node.left);
        // Traverse root
        System.out.print(node.item + "->");
        // Traverse right
        inorder(node.right);
    }

    void preorder(Node node) {
        if (node == null)
            return;

        // Traverse root
        System.out.print(node.item + "->");
        // Traverse left
        preorder(node.left);
        // Traverse right
        preorder(node.right);
    }

    static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        int size = adj.size();
        int s = 0;
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[size];

        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {

            int curr = queue.poll();
            res.add(curr);

            for (int x : adj.get(curr)) {
                if (!visited[x]) {
                    visited[x] = true;
                    queue.add(x);
                }
            }
        }
        return res;
    }

    static ArrayList<Integer>
    bfsOfGraph(ArrayList<ArrayList<Integer>> adj,
               int s, boolean[] visited, ArrayList<Integer> res) {

        // Create a queue for BFS
        Queue<Integer> q = new LinkedList<>();

        // Mark source node as visited and enqueue it
        visited[s] = true;
        q.add(s);

        // Iterate over the queue
        while (!q.isEmpty()) {

            // Dequeue a vertex and store it
            int curr = q.poll();
            res.add(curr);

            // Get all adjacent vertices of the dequeued
            // vertex curr If an adjacent has not been
            // visited, mark it visited and enqueue it
            for (int x : adj.get(curr)) {
                if (!visited[x]) {
                    visited[x] = true;
                    q.add(x);
                }
            }
        }
        return res;
    }

    static ArrayList<Integer> bfsDisconnected(
            ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();

        // create an array to store the traversal
        ArrayList<Integer> res = new ArrayList<>();

        // Initially mark all the vertices as not visited
        boolean[] visited = new boolean[V];

        // perform BFS for each node
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                bfsOfGraph(adj, i, visited, res);
            }
        }
        return res;
    }

    public static void main(String[] args) {

        // create the adjacency list
        // { {2, 3, 1}, {0}, {0, 4}, {0}, {2} }

        /*
            0: [1, 2]
            1: [0, 2, 3]
            2: [0, 4]
            3: [1, 4]
            4: [2, 3]
         */

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.add(new ArrayList<>(Arrays.asList(0, 2, 3)));
        adj.add(new ArrayList<>(Arrays.asList(0, 4)));
        adj.add(new ArrayList<>(Arrays.asList(1,4)));
        adj.add(new ArrayList<>(Arrays.asList(2,3)));


//        ArrayList<Integer> ans = bfs(adj);
//        for (int i : ans) {
//            System.out.print(i + " ");
//        }
        int src = 0;
        ArrayList<Integer> ans = bfsDisconnected(adj);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
