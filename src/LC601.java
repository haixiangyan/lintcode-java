import java.util.Iterator;
import java.util.List;

public class LC601 {
    public class Vector2D implements Iterator<Integer> {
        private int counter;
        private Iterator<List<Integer>> i;
        private Iterator<Integer> j;

        public Vector2D(List<List<Integer>> vec2d) {
            i = vec2d.iterator();
            j = null;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                return null;
            }
            return j.next();
        }

        @Override
        public boolean hasNext() {
            while (i.hasNext() && (j == null || !j.hasNext())) {
                j = i.next().iterator();
            }
            return j != null && j.hasNext();
        }

        @Override
        public void remove() {}
    }
}
