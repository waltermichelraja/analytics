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
    public static int binaryToDecimal(int bin){
        int dec=0;
        int base=1;
        while(bin>0){
            int last=bin%10;
            dec+=last*base;
            base*=2;
            bin/=10;
        }
        return dec;
    }
    public static int binaryToDecimalRec(int bin){
        if(bin==0){return 0;}
        return (bin%10)+2*binaryToDecimalRec(bin/10);
    }
}

