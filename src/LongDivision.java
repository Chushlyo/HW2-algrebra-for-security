
public class LongDivision {
    PolynomialsArithmetic pa=new PolynomialsArithmetic();
    NewPolynomial quot;
    NewPolynomial rem;
    int p;
    public LongDivision(int prime){
        this.p = prime;
    }

    void divide(NewPolynomial n,NewPolynomial d){
        NewPolynomial n1 = n.primeVersion(p);
        NewPolynomial d1 = d.primeVersion(p);
        NewPolynomial q = new NewPolynomial("0");
        NewPolynomial r= n1;
        
        if (n1.getDegree()==0 && d1.getDegree()==0){
            this.quot = new NewPolynomial(""+(n1.getThisCoef(0)/d1.getThisCoef(0)));
            this.rem = new NewPolynomial(""+(n1.getThisCoef(0)%d1.getThisCoef(0)));
            return;
        }
        
        if(n1.getDegree()<d1.getDegree()){
            this.rem = n1;
            this.quot = q;
////            System.out.println("1The quotient is:");
//            quot.print();
//            System.out.println("1The remainder is:");
//            rem.print();
//        r.print();
            return;
        }
        
        if(n1.getDegree()==d1.getDegree()){
            for ( int i = 0; i<d1.getDegree();i++){
//                d1.print();
//                n1.print();
                if (d1.getThisCoef(d1.getDegree()-1-i)<n1.getThisCoef(n1.getDegree()-1-i)) break;
                if (d1.getThisCoef(d1.getDegree()-1-i)>n1.getThisCoef(n1.getDegree()-1-i)){
//                    System.out.println("1" + d1.getThisCoef(d1.getDegree()-1-i));
//                    System.out.println("1" + n1.getThisCoef(n1.getDegree()-1-i));
                    this.rem = n1;
                    this.quot = q;
//                    System.out.println("2The quotient is:");
//                    quot.print();
//                    System.out.println("2The remainder is:");
//                    rem.print();
                    return; 
                }
            }
        }
        while (r.getDegree()>=d1.getDegree() && r.getDegree()!=0){
//            System.out.println("resu?");
            //divide leading terms
            int lcr_lcb;
            if ( r.getThisCoef(r.getDegree()) < d1.getThisCoef(d1.getDegree()))
                lcr_lcb = d1.getThisCoef(d1.getDegree());
            else lcr_lcb = r.getThisCoef(r.getDegree())/ d1.getThisCoef(d1.getDegree());
//            System.out.println("lcrss:" + lcr_lcb);
            NewPolynomial q2 = new NewPolynomial(lcr_lcb+"x^"+ (r.getDegree()-d1.getDegree()));
            q = pa.sum(q, q2).primeVersion(p);
            NewPolynomial r2 = new NewPolynomial(lcr_lcb+"x^"+ (r.getDegree()-d1.getDegree()));
            r2 = pa.product(r2, d1).primeVersion(p);
            r = pa.difference(r, r2).primeVersion(p);
            r.removeLeadingO();
//            System.out.println("wtf");
//            current.print();
            r=r.primeVersion(p);

        }
//        System.out.println("The quotient is:");
        this.quot=q;
//        q.print();
//        System.out.println("The remainder is:");
        this.rem=r;
//        r.print();
    }
    
    public NewPolynomial getQ(){
        return this.quot;
    }
    
    public NewPolynomial getR(){
        return this.rem;
    }
}
