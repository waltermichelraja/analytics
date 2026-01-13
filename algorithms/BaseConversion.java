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

    public static int decimalToOctal(int n){
        if(n==0){return 0;}
        int oct=0;
        int place=1;
        while(n>0){
            oct+=(n%8)*place;
            place*=10;
            n/=8;
        }
        return oct;
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

    public static int binaryToOctal(int bin){
        int oct=0;
        int place=1;
        while(bin>0){
            int group=0;
            int power=1;
            for(int i=0;i<3&&bin>0;i++){
                group+=(bin%10)*power;
                power*=2;
                bin/=10;
            }
            oct+=group*place;
            place*=10;
        }
        return oct;
    }

    public static int octalToBinary(int oct){
        if(oct==0){return 0;}
        int bin=0;
        int place=1;
        while(oct>0){
            int digit=oct%10;
            int power=1;
            int group=0;
            for(int i=0;i<3;i++){
                group+=(digit%2)*power;
                power*=10;
                digit/=2;
            }
            bin+=group*place;
            place*=1000;
            oct/=10;
        }
        return bin;
    }

    public static int[] binaryToHex(int bin){
        int[] temp=new int[32];
        int index=0;
        while(bin>0){
            int group=0;
            int power=1;
            for(int i=0; i<4 && bin>0; i++){
                group+=(bin%10)*power;
                power*=2;
                bin/=10;
            }
            temp[index++]=group;
        }
        int[] hex=new int[index];
        for(int i=0; i<index; i++){
            hex[i]=temp[index-1-i];
        }
        return hex;
    }
}

