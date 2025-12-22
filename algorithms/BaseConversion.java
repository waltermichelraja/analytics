public class BaseConversion{
    public static int decimalToBinary(int n){
        if(n==0){return 0;}
        int bin=0;
        int place=1;
        while(n>0){
            bin+=(n%2)*place;
            place*=10;
            n/=2;
        }
        return bin;
    }
    public static int decimalToBinaryRec(int n){
        if(n==0){return 0;}
        return decimalToBinaryRec(n/2)*10+(n%2);
    }
}

