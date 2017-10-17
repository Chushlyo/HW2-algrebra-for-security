
public class PolynomialsArithmetic {
    NewPolynomial poly1;
    NewPolynomial poly2;

    public PolynomialsArithmetic(NewPolynomial p1, NewPolynomial p2) {
        this.poly1 = p1;
        this.poly2 = p2;
    }

//    Polynomial sum() {
//        Polynomial result = null;
//        int[] firstPoly= poly1.getCoefficient();
//        int[] secondPoly= poly2.getCoefficient();
//        int length=secondPoly.length;
//         if(firstPoly.length>secondPoly.length){
//             length=firstPoly.length;
//         }
//        int[] coeffResult=new int[length];
//        result.setCoefficient(coeffResult);
//        return result;
//    }

    NewPolynomial sum() {
        int newDegree = Math.max(poly1.getDegree() , poly2.getDegree());
        NewPolynomial result = new NewPolynomial("x^" + newDegree);
        for (int i = 0; i <= poly1.getDegree(); i++) result.addtoThisCoef(i,poly1.getThisCoef(i));
        for (int i = 0; i <= poly2.getDegree(); i++) result.addtoThisCoef(i,poly2.getThisCoef(i));
        return result;
    }
    
    public NewPolynomial difference(NewPolynomial poly1, NewPolynomial poly2) {
        int newDegree = Math.max(poly1.getDegree() , poly2.getDegree());
        NewPolynomial result = new NewPolynomial("x^" + newDegree);
        for (int i = 0; i <= poly1.getDegree(); i++) result.subtoThisCoef(i,poly1.getThisCoef(i));
        for (int i = 0; i <= poly2.getDegree(); i++) result.subtoThisCoef(i,poly2.getThisCoef(i));
        return result;
    }
    
    public NewPolynomial scalar(NewPolynomial poly1,int s){
        NewPolynomial result = poly1.scalar(s);
        return result;
    }

    public NewPolynomial product(NewPolynomial poly1, NewPolynomial poly2) {
        int newDegree = poly1.getDegree() + poly2.getDegree();
        NewPolynomial result = new NewPolynomial("x^" + newDegree);
        
        for (int i = 0; i <= poly1.getDegree(); i++)
            for (int j = 0; j <= poly2.getDegree(); j++)
                result.changeThisCoef(i+j,poly1.getThisCoef(i) * poly2.getThisCoef(j));
    
        return result;
    }

    


}
