public class QuickSort implements SortingAlgorithm {

    void qs(int[] a, int left, int right){
        if(left < right){
            int p = partition(a, left, right);
            qs(a, left, p-1);
            qs(a, p+1, right);
        }
    }

    int partition(int[]a, int left, int right){
        if(left < right){
            int pivot = 0;
            int i = left + 1;
            int j = right;

            while(i < j){
                while((i < j) && (a[j] < a[pivot]))
                    ++i;
                while((i < j) && (a[j] >= a[pivot]))
                    --j;
                if((i < right) && (i < j))
                    swap(a, i, j);
            }
            swap(a, pivot, j);
            return j;
        }
        return left;
    }

    void swap(int[] a, int x, int y){
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    @Override
    public void sort(int[] a) {
        qs(a, 0, a.length-1);

    }
}
