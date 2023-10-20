import java.util.*;

public class NestedIterator {
    private List<Integer> tempList;
    private int index;

    public NestedIterator(List<NestedInteger> nestedList) {
        tempList = new ArrayList<>();
        index = 0;
        flattenList(nestedList);
    }

    public Integer next() {
        return tempList.get(index++);
    }

    public boolean hasNext() {
        return index < tempList.size();
    }

    private void flattenList(List<NestedInteger> nestedList) {
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                tempList.add(ni.getInteger());
            } else {
                flattenList(ni.getList());
            }
        }
    }
}

