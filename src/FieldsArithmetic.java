public class FieldsArithmetic {
    NewPolynomial poly1;
    NewPolynomial poly2;

    //two polynomials should be from the same field, check needs to be done
    public FieldsArithmetic(NewPolynomial p1, NewPolynomial p2) {
        this.poly1 = p1;
        this.poly2 = p2;
    }
    
    
    NewPolynomial sum() {
        int newDegree = Math.max(poly1.getDegree() , poly2.getDegree());
        NewPolynomial result = new NewPolynomial("x^" + newDegree);
        for (int i = 0; i <= poly1.getDegree(); i++) result.addtoThisCoef(i,poly1.getThisCoef(i));
        for (int i = 0; i <= poly2.getDegree(); i++) result.addtoThisCoef(i,poly2.getThisCoef(i));
        return result;
    }
    
    NewPolynomial difference() {
        int newDegree = Math.max(poly1.getDegree() , poly2.getDegree());
        NewPolynomial result = new NewPolynomial("x^" + newDegree);
        for (int i = 0; i <= poly1.getDegree(); i++) result.subtoThisCoef(i,poly1.getThisCoef(i));
        for (int i = 0; i <= poly2.getDegree(); i++) result.subtoThisCoef(i,poly2.getThisCoef(i));
        return result;
    }

    NewPolynomial product() {
        int newDegree = poly1.getDegree() + poly2.getDegree();
        NewPolynomial result = new NewPolynomial("x^" + newDegree);
        
        for (int i = 0; i <= poly1.getDegree(); i++)
            for (int j = 0; j <= poly2.getDegree(); j++)
                result.changeThisCoef(i+j,poly1.getThisCoef(i) * poly2.getThisCoef(j));
    
        return result;
    }

    Polynomial quotient() {
        NewPolynomial q,r;
        q = NewPolynomial();
        r=
        Polynomial result = null;
        return result;
    }


}
