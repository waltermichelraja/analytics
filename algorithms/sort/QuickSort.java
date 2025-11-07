public class QuickSort{
    static int[] sort(int[] arr){
        quickSortHelper(arr, 0, arr.length-1);
        return arr;
    }
    static void quickSortHelper(int[] arr, int low, int high) {
        if(low<high){
            int pi=partition(arr, low, high);
            quickSortHelper(arr, low, pi-1);
            quickSortHelper(arr, pi+1, high);
        }
    }
    static int partition(int[] arr, int low, int high) {
        int pivot=arr[high];
        int i=low-1;
        for (int j=low;j<high;j++){
            if (arr[j]<=pivot) {
                i++; int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        int temp=arr[i+1];
        arr[i+1]=arr[high];
        arr[high]=temp;
        return i+1;
    }
}

