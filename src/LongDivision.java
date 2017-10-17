

public class LongDivision {
    PolynomialsArithmetic pa;
  
    public LongDivision(NewPolynomial a,NewPolynomial b){
        NewPolynomial q = new NewPolynomial("0");
            
        
        NewPolynomial r= a;
        while (r.getDegree()>b.getDegree()){
            int lcr_lcb = r.getThisCoef(r.getDegree())/
                    b.getThisCoef(r.getDegree());
            NewPolynomial q2 = new NewPolynomial(lcr_lcb+"x^"+ (r.getDegree()-b.getDegree()));
            q = pa.sum(q, q2);
            NewPolynomial r2 = new NewPolynomial(lcr_lcb+"x^"+ (r.getDegree()-b.getDegree()));
            r2 = pa.product(r2, b);
            r = pa.difference(r, r2);
        }
        q.print();
        System.out.println();
        r.print();
    }
}
