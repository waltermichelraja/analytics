public class BucketSort{
  static void sort(int arr[]){
    int x=arr[0];
    for(int i=1;i<arr.length;i++){
      if(arr[i]>x){x=arr[i];}
    }
    int bucket[]=new int[x+1];
    for(int i=0;i<=x;i++){
      bucket[i]=0;
    }
    for(int i=0;i<arr.length;i++){
      bucket[arr[i]]++;
    }
    for(int i=0,j=0;i<=x;i++){
      while(bucket[i]>0){
        arr[j++]=i; bucket[i]--;
      }
    }
  }
}
