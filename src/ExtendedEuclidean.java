public class ExtendedEuclidean {
    PolynomialsArithmetic polynomialsArithmetic = new PolynomialsArithmetic();
    LongDivision longDivision = new LongDivision();
    NewPolynomial quot, xPr, yPr,gcd;
    NewPolynomial x1 = new NewPolynomial("1");
    NewPolynomial x2 = new NewPolynomial("0");
    NewPolynomial y2 = new NewPolynomial("1");
    NewPolynomial y1 = new NewPolynomial("0");

    void compute(NewPolynomial a, NewPolynomial b) {

        while (b.getDegree() != 0) {
            longDivision.divide(a, b);
            quot = longDivision.quot;
            a = b;
            b=longDivision.rem;
            System.out.println("b is ");
            b.print();
            xPr=polynomialsArithmetic.difference(x1,polynomialsArithmetic.product(quot,x2));
          // if(xPr.getDegree()>0) {
          NewPolynomial current=xPr.changeDegree(xPr.getDegree()-1,xPr);
            xPr=current;
        //   }
            yPr=polynomialsArithmetic.difference(y1,polynomialsArithmetic.product(quot,y2));
            x1=x2;
            y1=y2;
            x2=xPr;
            y2=yPr;
            int degree=b.getDegree();
            while(b.getThisCoef(degree)==0 && degree!=0){
                NewPolynomial Bcurrent=b.changeDegree(b.getDegree()-1,b);
                b=Bcurrent;
                degree=degree-1;
            }
//            if(b.getDegree()==0){
//                break;
//            }
        }
        if (b.getThisCoef(0)!=0){
            gcd=new NewPolynomial("1");
        }else{
            gcd=a;// quot?
        }

        System.out.println("GCD is ");
        gcd.print();
        if (gcd==new NewPolynomial("1")){
            System.out.println("second poly:X is");
            x2.print();
            System.out.println("first poly:Y is");
            y2.print();
        }else{
            System.out.println("second poly:X is");
            x1.print();
            System.out.println("first poly:Y is");
            y1.print();
        }



    }
}
