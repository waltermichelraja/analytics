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

    public static String decimalToHex(int n){
        if(n==0){return "0";}
        String hex="";
        while(n>0){
            int rem=n%16;
            char digit;
            if(rem<10){
                digit=(char)('0'+rem);
            }else{
                digit=(char)('A'+(rem-10));
            }
            hex=digit+hex;
            n/=16;
        }
        return hex;
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

    public static int octalToDecimal(int oct){
        int dec=0;
        int base=1;
        while(oct>0){
            int last=oct%10;
            dec+=last*base;
            base*=8;
            oct/=10;
        }
        return dec;
    }

    public static int hexToBinary(String hex){
        int bin=0;
        int place=1;
        for(int i=hex.length()-1;i>=0;i--){
            char c=hex.charAt(i);
            int value;
            if(c>='0'&&c<='9'){
                value=c-'0';
            }else if(c>='A'&&c<='F'){
                value=c-'A'+10;
            }else if(c>='a'&&c<='f'){
                value=c-'a'+10;
            }else{
                throw new IllegalArgumentException("invalid hexadecimal character:"+c);
            }
            int group=0;
            int power=1;
            for(int j=0;j<4;j++){
                group+=(value%2)*power;
                power*=10;
                value/=2;
            }
            bin+=group*place;
            place*=10000;
        }
        return bin;
    }

    public static int hexToDecimal(String hex){
        int dec=0;
        int base=1;
        for(int i=hex.length()-1;i>=0;i--){
            char c=hex.charAt(i);
            int value;
            if(c>='0'&&c<='9'){
                value=c-'0';
            }else if(c>='A'&&c<='F'){
                value=c-'A'+10;
            }else if(c>='a'&&c<='f'){
                value=c-'a'+10;
            }else{
                throw new IllegalArgumentException("invalid hexadecimal character:"+c);
            }
            dec+=value*base;
            base*=16;
        }
        return dec;
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

