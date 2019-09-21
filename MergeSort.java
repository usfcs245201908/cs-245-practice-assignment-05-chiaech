public class MergeSort implements SortingAlgorithm {

    void sort_a(int[] arr, int left, int right){
        if (left < right) {
            int middle = (left + right) / 2;
            sort_a(arr, left, middle);
            sort_a(arr, middle + 1, right);

            merge_sort(arr, left, middle, right);
        }
    }

    void merge_sort(int[] arr, int left, int middle, int right){
        int left_arr = middle - left + 1;
        int right_arr = right - middle;

        int left_temp[] = new int [left_arr];
        int right_temp[] = new int [right_arr];

        for (int i = 0; i < left_arr; i++)
            left_temp[i] = arr[left + i];
        for (int i = 0; i < right_arr; i++)
            right_temp[i] = arr[right + i];


        //merge
        int a = 0, b = 0;
        int c = left;
        while (a < left_arr && b < right_arr){
            if (left_temp[a] <= right_temp[b]){
                arr[c] = left_temp[a];
                a++;
            }else{
                arr[c] = right_temp[b];
                b++;
            }
            c++;
        }

        //copy remaining elements
        while (a < left_arr){
            arr[c] = left_temp[a];
            a++;
            c++;
        }

        while (b < right_arr){
            arr[c] = right_temp[b];
            b++;
            c++;
        }
    }

    @Override
    public void sort(int[] arr) {
        sort_a(arr, 0, arr.length);
    }
}
