class DynamicArray {
    int[] arr;
    int length; // total elements in the array
    int capacity; // actual length of the array

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.length = 0;
        arr = new int[this.capacity];
    }

    public int get(int i) {
        if (i < length)
            return arr[i];

        return -1;
    }

    public void set(int i, int n) {
        if (i < length)
            arr[i] = n;
    }

    public void pushback(int n) { 
        if (length == capacity) {
            resize();
        }        

        arr[length] = n;
        length++;
    }

    public int popback() {
        if (length > 0)
            length--;

        return arr[length];
    }

    private void resize() {
        capacity *= 2;
        int[] newArr = new int[capacity];

        for (int i = 0; i < length; i++) {
            newArr[i] = arr[i];
        }

        arr = newArr;
    }

    public int getSize() {
        return length;
    }

    public int getCapacity() {
        return capacity;
    }
}
