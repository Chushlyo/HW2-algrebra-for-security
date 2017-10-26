public class GenerateIrreducible {
    // used to check if the new polynomial is irreducible
    Irreducibility irreducibility=new Irreducibility();

    /**
     *
     * @param degree degree of the irreducible polynomial that needs to generated
     * @param poly the reducible polynomial that needs to be replaced with irreducible one
     * @param modulus the modulus in which the new polynomial is created
     */
    public void printFieldIrreduc(int degree,NewPolynomial poly,int modulus){
        NewField field=new NewField(modulus,poly.getDegree()+1);
        field.generate();
        for (int i = 0; i < field.fieldPoly.size(); i++) {
            //field.fieldPoly.get(i).print();
            if(field.fieldPoly.get(i).getDegree()==degree && irreducibility.checkIrreducibility(field.fieldPoly.get(i),modulus)){
                System.out.println("An irreducible polynomial from the same degree is:");
                field.fieldPoly.get(i).print();
                break;
            }
        }
    }
}
