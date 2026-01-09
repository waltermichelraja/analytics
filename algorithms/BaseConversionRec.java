public class BaseConversionRec{
    public static int decimalToBinary(int n){
        if(n==0){return 0;}
        return decimalToBinary(n/2)*10+(n%2);
    }

    public static int binaryToDecimal(int bin){
        if(bin==0){return 0;}
        return (bin%10)+2*binaryToDecimal(bin/10);
    }

    public static int binaryToOctal(int bin){
        if(bin==0){return 0;}
        int group=0;
        int power=1;
        int temp=bin;
        for(int i=0;i<3&&temp>0;i++){
            group+=(temp%10)*power;
            power*=2;
            temp/=10;
        }
        return binaryToOctal(bin/1000)*10+group;
    }
}

