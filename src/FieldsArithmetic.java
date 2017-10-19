public class FieldsArithmetic {
    NewPolynomial poly1;
    NewPolynomial poly2;
    PolynomialsArithmetic polynomialsArithmetic=new PolynomialsArithmetic();

    //two polynomials should be from the same field, check needs to be done
    public FieldsArithmetic(NewPolynomial p1, NewPolynomial p2) {
        this.poly1 = p1;
        this.poly2 = p2;
    }
    
    
    NewPolynomial sum() {
        return polynomialsArithmetic.sum(poly1,poly2);
    }
    
    NewPolynomial difference() {
        return polynomialsArithmetic.difference(poly1,poly2);
    }

    NewPolynomial scalar(int s){
        return polynomialsArithmetic.scalar(poly1,s);
    }

    NewPolynomial product() {
        return polynomialsArithmetic.product(poly1,poly2);
    }

    NewPolynomial quotient() {
        NewPolynomial result = null;
        return result;   
    }


}
