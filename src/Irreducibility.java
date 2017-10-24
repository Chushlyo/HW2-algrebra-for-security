public class Irreducibility {
    NewPolynomial poly, irredPoly;
    int modulus;
    ExtendedEuclidean extendedEuclidean;
    int t;
    public  Irreducibility(NewPolynomial poly,int modulus){
        this.poly=poly;
        this.modulus=modulus;
        this.extendedEuclidean=new ExtendedEuclidean(modulus);
        this.t=1;
    }
    public boolean checkIrreducibility(){

        while(extendedEuclidean.compute(poly,new NewPolynomial("x^" +(int) Math.pow(modulus, t) + "-x"))==new NewPolynomial("1")){
              t++;
        }
       if(t==poly.getDegree()){
           System.out.println("It is irreducible");
           irredPoly=poly;
           irredPoly.print();
           return true;
       }else{
           System.out.println("It is not irreducible");// it is reducible
           NewField field=new NewField(modulus,poly.getDegree()+1);
           field.generate();
         //  field.printField();
          field.printFieldIrreduc(poly.getDegree());
           return false;
       }
    }

}
