import java.util.ArrayList;
import java.util.List;

public class LC474 {
    class ParentTreeNode {
        public ParentTreeNode parent, left, right;
    }

    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
        if (root == null) {
            return null;
        }

        // Find the path
        List<ParentTreeNode> aPath = getPaths(A);
        List<ParentTreeNode> bPath = getPaths(B);

        // Init backward iteration
        ParentTreeNode lca = null;
        int indexA = aPath.size() - 1;
        int indexB = bPath.size() - 1;
        while (indexA >= 0 && indexB >= 0) {
            if (aPath.get(indexA) != bPath.get(indexB)) {
                break;
            }

            lca = aPath.get(indexA);
            indexA--;
            indexB--;
        }

        return lca;
    }

    private List<ParentTreeNode> getPaths(ParentTreeNode root) {
        ParentTreeNode node = root;
        List<ParentTreeNode> path = new ArrayList<>();
        while (node != null) {
            path.add(node);
            node = node.parent;
        }

        return path;
    }
}
