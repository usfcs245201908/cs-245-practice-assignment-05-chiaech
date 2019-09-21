public class MergeSort implements SortingAlgorithm {

    @Override
    public void sort(int[] arr) {
        ms(arr, 0, arr.length - 1);
    }

    void ms(int[] a, int left, int right){
        if (left < right) {
            int middle = (left + right) / 2;

            ms(a, left, middle);
            ms(a, middle + 1, right);

            merge_arrays(a, left, middle, right);
        }
    }

    void merge_arrays(int[] a, int left, int middle, int right){
        int left_a = middle - left + 1;
        int right_a = right - middle;

        int left_temp[] = new int [left_a];
        int right_temp[] = new int [right_a];

        for (int i = 0; i < left_a; i++)
            left_temp[i] = a[left + i];
        for (int i = 0; i < right_a; i++)
            right_temp[i] = a[middle + 1 + i];

        //merge
        int x = 0, y = 0;
        int z = left;
        while (x < left_a && y < right_a){
            if (left_temp[x] <= right_temp[y]){
                a[z] = left_temp[x];
                x++;
            }else{
                a[z] = right_temp[y];
                y++;
            }
            z++;
        }

        //copy remaining elements
        while (x < left_a){
            a[z] = left_temp[x];
            x++;
            z++;
        }

        while (y < right_a){
            a[z] = right_temp[y];
            y++;
            z++;
        }
    }
}
