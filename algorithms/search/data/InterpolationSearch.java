public class InterpolationSearch{
    static Integer search(int[] a, int target){
        int low=0;
        int high=a.length-1;
        while(low<=high && target>=a[low] && target<=a[high]){
            if(low==high){
                if(a[low]==target){return low;}
                return null;
            }
            int pos=low+((target-a[low])*(high-low))/(a[high]-a[low]);
            if(pos<0 || pos>=a.length){return null;}
            if(a[pos]==target){return pos;}
            if(a[pos]<target){low=pos+1;}
            else{high=pos-1;}
        }
        return null;
    }
}
