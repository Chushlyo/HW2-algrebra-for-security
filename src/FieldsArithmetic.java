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
    
    NewPolynomial difference() {
        return polynomialsArithmetic.difference(poly1,poly2);
    }

    NewPolynomial scalar(int s){
        return polynomialsArithmetic.scalar(poly1,s);
    }

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

    public NewPolynomial quotient() {
        ExtendedEuclidean e = new ExtendedEuclidean(prime);
        e.compute(poly3,poly2);
        if (e.gcd.checkIfOne()){
            return e.y1;
        }
        NewPolynomial result = null;
        return result;   
    }


}
