public class LC224 {
    private int[] array;
    private int[] pos;
    private int size;
    /*
    * @param size: An integer
    */
    public LC224(int size) {
        array = new int[size * 3];
        pos = new int[]{0, size, size * 2};
        this.size = size;
    }

    /*
     * @param stackNum: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void push(int stackNum, int value) {
        array[pos[stackNum]++] = value;
    }

    /*
     * @param stackNum: An integer
     * @return: the top element
     */
    public int pop(int stackNum) {
        return array[--pos[stackNum]];
    }

    /*
     * @param stackNum: An integer
     * @return: the top element
     */
    public int peek(int stackNum) {
        return array[pos[stackNum] - 1];
    }

    /*
     * @param stackNum: An integer
     * @return: true if the stack is empty else false
     */
    public boolean isEmpty(int stackNum) {
        return pos[stackNum] == size * stackNum;
    }
}
