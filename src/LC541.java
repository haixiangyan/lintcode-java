import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC541 {
    private Queue<Iterator<Integer>> iterators;
    private Iterator<Integer> tempIterator;

    /*
    * @param vecs: a list of 1d vectors
    */
    public LC541(List<List<Integer>> vecs) {
        iterators = new LinkedList<>();

        for (int i = 0; i < vecs.size(); i++) {
            if (vecs.get(i).size() != 0){
                iterators.offer(vecs.get(i).iterator());
            }
        }
    }

    /*
     * @return: An integer
     */
    public int next() {
        tempIterator = iterators.poll();
        int ele = tempIterator.next();
        iterators.offer(tempIterator);

        return ele;
    }

    /*
     * @return: True if has next
     */
    public boolean hasNext() {
        if (iterators.size() == 0) {
            return false;
        }
        if (!iterators.peek().hasNext()) {
            iterators.poll();
            return hasNext();
        }
        return true;
    }
}
