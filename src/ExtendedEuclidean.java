public class ExtendedEuclidean {
    
    int x1=1,x2=0,y1=0,y2=1,x3,y3;
    int q,r;
    int d;
    public ExtendedEuclidean(int a, int b){
        while(b>0){
            q = a/b;
            r = a - q*b;
            a=b;
            b=r;
            x3 = x1 - q*x2;
            y3 = y1 - q*y2;
            x1 = x2;
            y1 = y2;
            x2 = x3;
            y2 = y3;
        }
        
        d = a;
        System.out.println(x1 + " " + y1+ " " + d);
    }
}
