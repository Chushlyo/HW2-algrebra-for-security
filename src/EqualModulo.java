public class EqualModulo {
    NewPolynomial p1,p2,p3;
    LongDivision longDivision1,longDivision2;
    int modulus;
    public EqualModulo(NewPolynomial p1, NewPolynomial p2, NewPolynomial p3, int modulus){
        this.p1=p1;
        this.p2=p2;
        this.p3=p3;
        this.modulus=modulus;
        this.longDivision1=new LongDivision(modulus);
        this.longDivision2=new LongDivision(modulus);
    }
    void congruent(){
        longDivision1.divide(p3,p1);
        longDivision2.divide(p3,p2);
        if(longDivision2.rem==longDivision1.rem){
            System.out.println("The polynomials are congruent");
        } else{
            System.out.println("The polynomials are not congruent");
        }
    }
    
}
