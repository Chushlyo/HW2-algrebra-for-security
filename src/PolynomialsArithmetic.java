public class PolynomialsArithmetic {
    Polynomial poly1;
    Polynomial poly2;

    public PolynomialsArithmetic(Polynomial p1, Polynomial p2) {
        this.poly1 = p1;
        this.poly2 = p2;
    }

    Polynomial sum() {
//        int[] firstPoly= poly1.getCoefficient();
//        int[] secondPoly= poly2.getCoefficient();
//        int length=secondPoly.length;
//        if(firstPoly.length>secondPoly.length){
//             length=firstPoly.length;
//         }
//
//        int[] coeffResult=new int[length];

        Polynomial result = new Polynomial(0, Math.max(poly1.getDegree(), poly2.getDegree()));
        for (int i = 0; i <= poly1.getDegree(); i++) result.coefficient[i] += poly1.coefficient[i];
        for (int i = 0; i <= poly2.getDegree(); i++) result.coefficient[i] += poly2.coefficient[i];
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
