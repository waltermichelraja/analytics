class Heap{
    static void minHeap(int arr[]){
        for(int i=0;i<arr.length;i++){
            int j=i;
            while(j>0){
                int parent=(j-1)/2;
                if(arr[parent]>arr[j]){
                    int temp=arr[parent];
                    arr[parent]=arr[j];
                    arr[j]=temp;
                    j=parent;
                }else{
                    break;
                }
            }
        }
    }
    static void maxHeap(int arr[]){
        for(int i=0;i<arr.length;i++){
            int j=i;
            while(j>0){
                int parent=(j-1)/2;
                if(arr[parent]<arr[j]){
                    int temp=arr[parent];
                    arr[parent]=arr[j];
                    arr[j]=temp;
                    j=parent;
                }else{
                    break;
                }
            }
        }
    }
}
