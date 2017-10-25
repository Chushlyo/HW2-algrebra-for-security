public class IntegerMod {
    int modp; //mod p 
      
    boolean primeCheck(int p) {
        
        if (p == 2) {
            return true;
        }
        if (p % 2 == 0) return false;// the number is even
        for (int i = 3; i * i <= p; i += 2) { //check of being divisible by odd number
            if (p % i == 0)
                return false;
        }
        return true;
    }
    
    //Naive method
    public int modReduction(int m, int x){ //where p=m
        double q= Math.floor(x/m);
        double y = x - q*m;
        if(y<0) y = y + m;
        return (int)y;
    }
    
    //Modular reduction with radix b
    public double modReductionRadix (int p, int x, int b){ //p=m
        double d = x; //d=x'
        String s = Double.toString(d);
        double y = x/p;
        String v = Double.toString(y);
        
        int k = s.length(); //word length of x
        int n = v.length(); //word length of p
        
        for (int i = k-n; i>0; i--){
            while (d>=p*Math.pow(b,i)){
                d = d -p*Math.pow(b,i);
            }
            if (x>=0 || d==0){
                y = d;
            } else
                y = p-d;
            
        }
        return y;
    }
    
        
}
