public class Irreducibility {

    public boolean checkIrreducibility(NewPolynomial poly, int modulus){
        ExtendedEuclidean extendedEuclidean=new ExtendedEuclidean(modulus);;
        int t=1;
        NewPolynomial irredPoly;
        NewPolynomial gcd=new NewPolynomial("1");

        while(extendedEuclidean.compute(poly,new NewPolynomial("x^" +(int) Math.pow(modulus, t) + "-x")).getCoef()[0]==(gcd.getCoef()[0])&& extendedEuclidean.compute(poly,new NewPolynomial("x^" +(int) Math.pow(modulus, t) + "-x")).getDegree()==0) {
              t++;
        }
       if(t==poly.getDegree()){
           return true;
       }else{
           return false;
       }
    }

}

