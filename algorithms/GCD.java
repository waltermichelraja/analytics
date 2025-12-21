public class GCD{
    public static int findIte(int a,int b){
        while(b!=0){
            int r=a%b;
            a=b; b=r;
        }
        return a;
    }
    public static int findRec(int a,int b){
        if(b==0)return a;
        return findRec(b,a%b);
    }
}

