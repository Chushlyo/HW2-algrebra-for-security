
public class LongDivision {
    PolynomialsArithmetic pa=new PolynomialsArithmetic();
    NewPolynomial quot;
    NewPolynomial rem;

    void divide(NewPolynomial n,NewPolynomial d){
        NewPolynomial q = new NewPolynomial("0");
        NewPolynomial r= n;

        while (r.getDegree()>d.getDegree() && r.getDegree()!=0){
            System.out.println("resu?");
            //divide leading terms
            int lcr_lcb = r.getThisCoef(r.getDegree())/ d.getThisCoef(d.getDegree());
            NewPolynomial q2 = new NewPolynomial(lcr_lcb+"x^"+ (r.getDegree()-d.getDegree()));
            q = pa.sum(q, q2);
            NewPolynomial r2 = new NewPolynomial(lcr_lcb+"x^"+ (r.getDegree()-d.getDegree()));
            r2 = pa.product(r2, d);
            r = pa.difference(r, r2);
            NewPolynomial current=r.changeDegree(r.getDegree()-1,r);
            r=current;

        }
        System.out.println("The quotient is:");
        this.quot=q;
        q.print();
        System.out.println("The remainder is:");
        this.rem=r;
        r.print();
    }
}
