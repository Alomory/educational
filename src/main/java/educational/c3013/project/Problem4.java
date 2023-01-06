package educational.c3013.project;

import java.util.*;

/*
Sample Input
5 4
1 1 3 3
1 4 2 1 2

Sample Output
1 -1 -1 1 3
*/

public class Problem4 {
    public static void solve(int node, ArrayList<Integer>[] tree, int[] col, ArrayList<Integer>[] arr, int[] ans) {
        if (arr[col[node - 1]].size() != 0) {
            ans[node - 1] = arr[col[node - 1]].get(arr[col[node - 1]].size() - 1);
        }

        arr[col[node - 1]].add(node);

        for (int child : tree[node]) {
            solve(child, tree, col, arr, ans);
        }

        arr[col[node - 1]].remove(arr[col[node - 1]].size() - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int c = scanner.nextInt();
        int[] par = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            par[i] = scanner.nextInt();
        }

        ArrayList<Integer>[] tree = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            tree[par[i]].add(i + 2);
        }

        int[] col = new int[n];
        for (int i = 0; i < n; i++) {
            col[i] = scanner.nextInt();
        }

        ArrayList<Integer>[] arr = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        solve(1, tree, col, arr, ans);

        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}

/*
 * This is a program that traverses a tree and assigns a value to each node in
 * the tree. The tree is represented as an adjacency list, with the tree
 * variable being an array of lists of integers. Each element in the array
 * represents a node in the tree, and the list of integers associated with that
 * element represents the children of that node.
 * 
 * The solve function is a recursive function that is called on each node in the
 * tree. It takes as input the current node being processed, the tree
 * representation, an array col that stores the color of each node, an array of
 * lists arr, and an array ans that will store the final result.
 * 
 * The function first checks if there are any elements in the list associated
 * with the color of the current node in arr. If there are, it assigns the last
 * element of that list to the current node in the ans array. Then, it adds the
 * current node to the list associated with its color in arr.
 * 
 * The function then iterates through the children of the current node and calls
 * solve on each of them. After all the children have been processed, the
 * function removes the current node from the list associated with its color in
 * arr.
 * 
 * The main function reads in the input, initializes the tree and color arrays,
 * and calls the solve function on the root node (node 1). It then prints the
 * resulting array ans.
 */