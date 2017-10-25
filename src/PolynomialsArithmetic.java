
public class PolynomialsArithmetic {



    public NewPolynomial sum(NewPolynomial poly1, NewPolynomial poly2) {
        int newDegree = Math.max(poly1.getDegree(), poly2.getDegree());
        NewPolynomial result = new NewPolynomial("x^" + (newDegree));
        for (int i = 0; i <= poly1.getDegree(); i++) result.addtoThisCoef(i, poly1.getThisCoef(i));
        for (int i = 0; i <= poly2.getDegree(); i++) result.addtoThisCoef(i, poly2.getThisCoef(i));
        //in order to remove adding the first degree at the start
        result.subtoThisCoef(result.getDegree(), 1);
        result.removeLeadingO();
        return result;
    }

    public NewPolynomial difference(NewPolynomial poly1, NewPolynomial poly2) {
        int newDegree = Math.max(poly1.getDegree(), poly2.getDegree());
        NewPolynomial result = new NewPolynomial("x^" + newDegree);
        //add the coefficients of the first polynomial as positive integers
        for (int i = 0; i <= poly1.getDegree(); i++) result.addtoThisCoef(i, poly1.getThisCoef(i));
        //subtract the coefficients of the second polynomial from the first one
        for (int i = 0; i <= poly2.getDegree(); i++) result.subtoThisCoef(i, poly2.getThisCoef(i));
        //in order to remove adding the first degree at the start
        result.subtoThisCoef(result.getDegree(), 1);
        result.removeLeadingO();
        return result;
    }

    public NewPolynomial scalar(NewPolynomial poly1, int s) {
        NewPolynomial result = poly1.scalar(s);
        result.removeLeadingO();
        return result;
    }

    public NewPolynomial product(NewPolynomial poly1, NewPolynomial poly2) {
        int newDegree = poly1.getDegree() + poly2.getDegree();
        NewPolynomial result = new NewPolynomial("x^" + newDegree);

        for (int i = 0; i <= poly1.getDegree(); i++) {
            for (int j = 0; j <= poly2.getDegree(); j++) {
                result.changeThisCoef(i + j, poly1.getThisCoef(i) * poly2.getThisCoef(j));
            }
        }

        //in order to remove adding the first degree at the start
        result.subtoThisCoef(result.getDegree(), 1);
        result.removeLeadingO();
        return result;
    }


}
