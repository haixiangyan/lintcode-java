import java.util.ArrayList;
import java.util.List;

public class LC474 {
    class ParentTreeNode {
        public ParentTreeNode parent, left, right;
    }

    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
        List<ParentTreeNode> pathA = getPath(A);
        List<ParentTreeNode> pathB = getPath(B);

        ParentTreeNode lowestCommonAncestor = null;

        int indexA = pathA.size() - 1;
        int indexB = pathB.size() - 1;

        while (indexA >= 0 && indexB >= 0) {
            if (pathA.get(indexA) != pathB.get(indexB)) {
                break;
            }
            lowestCommonAncestor = pathA.get(indexA);
            indexA--;
            indexB--;
        }

        return lowestCommonAncestor;
    }

    private List<ParentTreeNode> getPath(ParentTreeNode node) {
        List<ParentTreeNode> path = new ArrayList<>();
        while (node != null) {
            path.add(node);
            node = node.parent;
        }
        return path;
    }
}
