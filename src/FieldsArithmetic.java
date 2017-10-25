/*
    Upon input of 2 field elements produces the sum and product.
    Also produces the product of the first polynomial times the inverse of the 
    second polynomial.
*/
public class FieldsArithmetic {
    NewPolynomial poly1;
    NewPolynomial poly2;
    NewPolynomial poly3; //modding polynomial
    int prime; 
    PolynomialsArithmetic polynomialsArithmetic=new PolynomialsArithmetic();

    //two polynomials should be from the same field, check needs to be done
    public FieldsArithmetic(NewPolynomial p1, NewPolynomial p2, NewPolynomial p3, int p) {
        this.poly1 = p1;
        this.poly2 = p2;
        this.poly3 = p3;
        this.prime = p;
    }
    
    /*
    The sum of the 2 polynomials modded to the smalles element which is not
    in the field.
    */
    public NewPolynomial sum() {
        NewPolynomial result;
        result = polynomialsArithmetic.sum(poly1,poly2);
        result = result.primeVersion(prime);
        LongDivision ld = new LongDivision(prime);
        ld.divide(result, poly3);
        result = ld.rem;
        result.removeLeadingO();
        return result;
    }
    
    /*
    The product of the 2 polynomials modded to the smalles element which is not
    in the field.
    */
    public NewPolynomial product() {
        NewPolynomial result;
        result = polynomialsArithmetic.product(poly1,poly2);
        result = result.primeVersion(prime);
        LongDivision ld = new LongDivision(prime);
        ld.divide(result, poly3);
        result = ld.rem;
        result.removeLeadingO();
        return result;
    }
    /*
    Produces the quotient as specified in the assignment.
    */
    public NewPolynomial quotient() {
        ExtendedEuclidean e = new ExtendedEuclidean(prime);
        e.compute(poly3,poly2);
        if (e.gcd.checkIfOne()){
            this.poly2 = e.y1;
            return this.product();
        }
        NewPolynomial result = null;
        return result;   
    }


}
