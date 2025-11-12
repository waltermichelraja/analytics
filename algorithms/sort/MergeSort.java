public class MergeSort{
    static int[] sort(int[] arr){
        if(arr.length<=1)return arr;
        int mid=arr.length/2;
        int[] left=new int[mid]; int[] right=new int[arr.length-mid];
        for(int i=0;i<mid;i++){left[i]=arr[i];}
        for(int i=mid;i<arr.length;i++){right[i-mid]=arr[i];}
        left=sort(left); right=sort(right);
        return merge(left,right);
    }
    static int[] merge(int[] left,int[] right){
        int[] result=new int[left.length+right.length];
        int i=0,j=0,k=0;
        while(i<left.length && j<right.length){
            if(left[i]<=right[j]){result[k++]=left[i++];}
            else{result[k++]=right[j++];}
        }
        while(i<left.length){result[k++]=left[i++];}
        while(j<right.length){result[k++]=right[j++];}
        return result;
    }
}

