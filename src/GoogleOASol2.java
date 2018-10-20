import java.util.*;

public class GoogleOASol2 {
    class TreeNode {
        public int val;
        public List<TreeNode> children;
        public TreeNode parent;
        public TreeNode(int val) {
            this.val = val;
            this.children = new ArrayList<>();
            this.parent = null;
        }
    }
    public int[] solution(int D, int[] A) {
        if (D < 0 || A == null || A.length == 0) {
            return new int[0];
        }


        TreeNode[] graph = new TreeNode[A.length];
        List<List<TreeNode>> cache = new ArrayList<>();
        Set<TreeNode> set = new HashSet<>();

        // Init graph
        initGraph(graph, A);

        // Build Tree
        buildGraph(graph, A);

        // BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(graph[0]);
        set.add(graph[0]);

        int[] results = new int[A.length];
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> curLevel = new ArrayList<>();

            // Get previous level num
            int curCacheSize = cache.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                curLevel.add(curNode);

                // Find current node's ancestor
                if (curCacheSize >= D) {
                    results[curNode.val] = findAncestor(graph, curNode, D);
                }
                else {
                    results[curNode.val] = -1;
                }

                // Find its children
                for (TreeNode child : curNode.children) {
                    if (!set.contains(child)) {
                        queue.add(child);
                        set.add(child);
                    }
                }
            }
            cache.add(curLevel);
        }

        return results;
    }

    private void initGraph(TreeNode[] graph, int[] A) {
        // Init tree
        for (int i = 0; i < A.length; i++) {
            graph[i] = new TreeNode(i);
        }
    }

    private void buildGraph(TreeNode[] graph, int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] != -1) {
                graph[A[i]].children.add(graph[i]);
                graph[i].parent = graph[A[i]];
            }
        }
    }

    private int findAncestor(TreeNode[] graph, TreeNode curNode, int D) {
        TreeNode ancestor = curNode;
        for (int step = 0; step < D; step++) {
            ancestor = ancestor.parent;
        }

        return ancestor.val;
    }

    public static void main(String[] args) {
        GoogleOASol2 s = new GoogleOASol2();
        int[] test = {-1, 0, 4, 2, 1};
        s.solution(3, test);
    }
}
