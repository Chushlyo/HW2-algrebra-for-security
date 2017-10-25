/*
    Equal modulo 
    Divides both polynomials  p1 and p2 with long division to a third polynomial
    p3 and checks whether the reminder is the same.
*/
public class EqualModulo {
    NewPolynomial p1,p2,p3;
    LongDivision longDivision1,longDivision2;
    int modulus;
    /**
     * 
     * @param p1 The first polynomial divided.
     * @param p2 The second polynomial divided.
     * @param p3 The polynomial which we add mod to.
     * @param modulus The prime number in which we make the operations.
     */
    public EqualModulo(NewPolynomial p1, NewPolynomial p2, NewPolynomial p3, int modulus){
        this.p1=p1;
        this.p2=p2;
        this.p3=p3;
        this.modulus=modulus;
        this.longDivision1=new LongDivision(modulus);
        this.longDivision2=new LongDivision(modulus);
    }
    /**
     * Checks whether the polynomials are congurent
     */
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
