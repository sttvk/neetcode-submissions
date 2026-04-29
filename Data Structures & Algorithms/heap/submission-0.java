class MinHeap {
    List<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<Integer>();
        heap.add(0);
    }

    public void push(int val) {
        heap.add(val);
        percolateUp(heap.size() - 1);
    }

    public Integer pop() {
        if (heap.size() <= 1) {
            return -1;
        }

        if (heap.size() == 2) {
            return heap.remove(1);
        }

        int root = heap.get(1);
        int lastNodeIdx = heap.size() - 1;

        heap.set(1, heap.remove(lastNodeIdx));
        
        if (heap.size() > 1) {
            percolateDown(1);
        }

        return root;
    }

    public Integer top() {
        return heap.size() > 1 ? heap.get(1) : -1;
    }

    public void heapify(List<Integer> nums) {
        heap = new ArrayList<>();
        heap.add(0);
        heap.addAll(nums);

        for (int i = heap.size() / 2; i >= 1; i--) {
            percolateDown(i);
        }
    }

    private void percolateUp(int node) {
        int child = node;
        int parent = child / 2;

        while (child > 1 && heap.get(parent) > heap.get(child)) {
            swap(child, parent);
            child = parent;
            parent = child / 2;
        }
    }

    private void percolateDown(int node) {
        int parent = node;

        while (2 * parent < heap.size()) {
            int leftChild = 2 * parent;
            int rightChild = 2 * parent + 1;

            if (rightChild < heap.size() &&
                heap.get(rightChild) < heap.get(leftChild) &&
                heap.get(parent) > heap.get(rightChild)) {

                swap(parent, rightChild);
                parent = rightChild;

            } else if (heap.get(parent) > heap.get(leftChild)) {
                swap(parent, leftChild);
                parent = leftChild;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
