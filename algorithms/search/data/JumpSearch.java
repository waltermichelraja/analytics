public class JumpSearch{
    static Integer search(int[] a, int target){
        int n=a.length;
        int step=(int)Math.floor(Math.sqrt(n));
        int prev=0;
        while(prev<n&&a[Math.min(step,n)-1]<target){
            prev=step;
            step+=Math.floor(Math.sqrt(n));
            if(prev>=n){return null;}
        }
        for(int i=prev;i<Math.min(step,n);i++){
            if(a[i]==target){return i;}
        }
        return null;
    }
}
