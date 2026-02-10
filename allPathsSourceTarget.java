import java.util.ArrayList;
import java.util.List;

/*
========================================================
LeetCode 797 – All Paths From Source to Target
========================================================

CONCEPT:
--------
• DFS (Depth First Search)
• Recursion
• Backtracking
• Path building

PROBLEM IDEA (IN SIMPLE WORDS):
------------------------------
You are given a Directed Acyclic Graph (DAG).
- Start node = 0
- Target node = n-1
- You must find ALL possible paths from 0 to n-1.

Each path is stored as a List<Integer>,
and all paths together are stored as List<List<Integer>>.

This problem is EXACTLY like a MAZE PATH problem,
but instead of (row, col), we move between graph nodes.

--------------------------------------------------------
GRAPH USED FOR DRY RUN:
--------------------------------------------------------
graph = [[1,2],[3],[3],[]]

Visual graph:

        0
       / \
      1   2
       \ /
        3

Target node = 3
--------------------------------------------------------
*/

class Solution {

    /*
    ----------------------------------------------------
    MAIN FUNCTION
    ----------------------------------------------------
    • result -> stores all valid paths
    • path   -> stores current path while exploring
    • Start DFS from node 0
    */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        // Start from source node 0
        path.add(0);

        dfs(graph, 0, path, result);

        return result;
    }

    /*
    ----------------------------------------------------
    DFS FUNCTION
    ----------------------------------------------------
    node  -> current node
    path  -> current path taken
    result-> all valid paths
    */
    public void dfs(int[][] graph, int node,
                    List<Integer> path,
                    List<List<Integer>> result) {

        /*
        ------------------------------------------------
        BASE CASE:
        ------------------------------------------------
        If current node == target (n - 1),
        then current path is COMPLETE.
        Save a COPY of it and return.
        */
        if (node == graph.length - 1) {
            result.add(new ArrayList<>(path));
            return;
        }

        /*
        ------------------------------------------------
        RECURSIVE CASE:
        ------------------------------------------------
        Explore all neighbors of current node.
        */
        for (int n : graph[node]) {

            // 1️⃣ CHOOSE
            path.add(n);

            // 2️⃣ EXPLORE
            dfs(graph, n, path, result);

            // 3️⃣ UN-CHOOSE (BACKTRACK)
            path.remove(path.size() - 1);
        }
    }
}

/*
========================================================
FULL DRY RUN (STEP BY STEP)
========================================================

Initial State:
--------------
path   = [0]
result = []

Call: dfs(node = 0)

--------------------------------------------------------
dfs(0)
Neighbors of 0 = [1, 2]
--------------------------------------------------------

▶ Take neighbor 1
-----------------
path = [0, 1]
dfs(1)

    dfs(1)
    Neighbors of 1 = [3]

    ▶ Take neighbor 3
    -----------------
    path = [0, 1, 3]
    dfs(3)

        node == target (3)
        result = [[0, 1, 3]]
        return

    Backtrack:
    path = [0, 1]

    No more neighbors for node 1
    return

Backtrack:
path = [0]

--------------------------------------------------------
▶ Take neighbor 2
-----------------
path = [0, 2]
dfs(2)

    dfs(2)
    Neighbors of 2 = [3]

    ▶ Take neighbor 3
    -----------------
    path = [0, 2, 3]
    dfs(3)

        node == target (3)
        result = [[0,1,3], [0,2,3]]
        return

    Backtrack:
    path = [0, 2]

    No more neighbors
    return

Backtrack:
path = [0]

--------------------------------------------------------
All neighbors of 0 explored.
DFS finished.
--------------------------------------------------------

FINAL ANSWER:
-------------
[[0,1,3], [0,2,3]]

========================================================
KEY BACKTRACKING RULE (VERY IMPORTANT):
========================================================
• add → recurse → remove
• Loop continues from where it stopped
• Return happens ONLY after all neighbors are processed

========================================================
INTERVIEW ONE-LINER:
========================================================
"This problem uses DFS with backtracking on a DAG
to enumerate all paths from source to target."
========================================================
