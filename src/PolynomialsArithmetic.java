public class PolynomialsArithmetic {
    Polynomial poly1;
    Polynomial poly2;

    public PolynomialsArithmetic(Polynomial p1, Polynomial p2) {
        this.poly1 = p1;
        this.poly2 = p2;
    }

    Polynomial sum() {
        Polynomial result = null;
        int[] firstPoly= poly1.getCoefficient();
        int[] secondPoly= poly2.getCoefficient();
        int length=secondPoly.length;
         if(firstPoly.length>secondPoly.length){
             length=firstPoly.length;
         }
        int[] coeffResult=new int[length];
        result.setCoefficient(coeffResult);
        return result;
    }

    Polynomial scalarMultiple() {
        Polynomial result = null;
        return result;
    }

    Polynomial difference() {
        Polynomial result = null;
        return result;
    }

    Polynomial product() {
        Polynomial result = null;
        return result;
    }
}
