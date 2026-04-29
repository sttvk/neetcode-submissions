// Definition for a pair.
// class Pair {
//     public int key;
//     public String value;

//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    // Implementation of MergeSort
    public List<Pair> mergeSort(List<Pair> pairs) {
        return mergeSortHelper(pairs, 0, pairs.size() - 1);
    }

    public List<Pair> mergeSortHelper(List<Pair> pairs, int s, int e) {
        if (e - s + 1 <= 1) {
            return pairs;
        }

        // The middle index of the array
        int m = (s + e) / 2;

        // Sort the left half
        mergeSortHelper(pairs, s, m);

        // Sort the right half
        mergeSortHelper(pairs, m + 1, e);

        // Merge sorted halves
        merge(pairs, s, m, e);

        return pairs;
    }

    // Merge in-place
    public void merge(List<Pair> arr, int s, int m, int e) {
        // Copy the sorted left & right halves to temp arrays
        List<Pair> L = new ArrayList<>(arr.subList(s, m + 1));
        List<Pair> R = new ArrayList<>(arr.subList(m + 1, e + 1));

        int i = 0; // index for L
        int j = 0; // index for R
        int k = s; // index for arr

        // Merge the two sorted halves into the original array
        while (i < L.size() && j < R.size()) {
            if (L.get(i).key <= R.get(j).key) {
                arr.set(k, L.get(i));
                i++;
            } else {
                arr.set(k, R.get(j));
                j++;
            }
            k++;
        }

        // One of the halves will have elements remaining
        while (i < L.size()) {
            arr.set(k, L.get(i));
            i++;
            k++;
        }
        while (j < R.size()) {
            arr.set(k, R.get(j));
            j++;
            k++;
        }
    }
}
