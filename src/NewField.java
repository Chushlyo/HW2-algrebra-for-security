
import java.util.ArrayList;

/*
Generates a filed with the specified prime and exponent.
Adds the field polynomials to a list.
*/
public class NewField {
    int prime;
    int exponent;
    ArrayList<NewPolynomial> fieldPoly;
      /**
     * Constructor that creates an field object
     * @param p the prime modulus
     * @param n the exponent
     */
    public NewField(int p, int n) {
        this.prime = p;
        this.exponent = n;
        this.fieldPoly = new ArrayList<>();
    }
    
      /**
     * method that generates irreducible polynomials
     */
    public void generate() {
        exponent--;
        ArrayList<int[]> sArray = new ArrayList();
            
        for (int pk=0; pk< Math.pow((double) (prime), (double) exponent+1 );pk++){
            sArray.add(new int[exponent+1]);
        }

        for(int i = 0; i <= exponent; i ++){
            int pk = 0;
            int j = 0;
            while (pk< Math.pow((double) (prime), (double) exponent+1)){
                for (int i3=0; i3<Math.pow((double) prime, (double) i );i3++){
                sArray.get(pk)[exponent - i] = j;
                pk++;
                }
                j++;
                j=j%prime;
            }
        }

        for (int pk=0; pk< Math.pow((double) (prime), (double) exponent+1 );pk++){
            NewPolynomial tempPoly = new NewPolynomial("x^"+exponent);
            tempPoly.defineByArray(sArray.get(pk));
            fieldPoly.add(tempPoly);
        }
        exponent++;
    }
    
    public ArrayList<NewPolynomial>  getPolys(){
            return fieldPoly;
    }
        
    public void printField() {
        for (int i = 0; i < fieldPoly.size(); i++) {
            fieldPoly.get(i).print();
        }
    }

    public boolean checkIfInField(NewPolynomial p){
        for (int i = 0; i < fieldPoly.size(); i++) {
            if(p.checkIfEqual(p,fieldPoly.get(i))){
                return true;
            }
        }
        return false;
    }
}


