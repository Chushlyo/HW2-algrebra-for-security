public class IntegerMod {
    int modp; //mod p 
      
    public void isPrime(int p, int x) {
        if (p<100){
            for(int i=2; i<p; i++) {
                if(p%i==0){
                    System.out.println("p is not prime");
                    } else {
                    modReduction(p,x); 
                    break;
                   }
            }
        }
    }
    
    //Naive method
    public double modReduction(int p, int x){ //where p=m
        double y= x/p;
        double q=0;
        while (y >= p){
            q=Math.floor(x/p);
            y=x-q*p;
        }
        return y;
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
