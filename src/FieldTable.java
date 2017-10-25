
import java.util.ArrayList;
/*
     This class given an input field and irreducible polynomial
     will creates a list with all the elements in that field mod the polynomial.
     After that it adds and multiplies every element to that list to every
     element in that list and creates 2 tables.
*/
public class FieldTable {
    NewField field;
    NewPolynomial poly;
    ArrayList<NewPolynomial> modlist = new ArrayList<>();
    ArrayList<NewPolynomial> polys  = new ArrayList<>();;

    public FieldTable(NewField f, NewPolynomial p) {
        this.field = f;
        this.poly = p;
        this.modlist = moddedList(field,poly);
        System.out.println("Addition table:");
        additionTable();
        System.out.println("Multiplication table:");
        multiplicationTable();

    }     
    /**
     * 
     * @param field 
     * @param poly
     * @return All the elements in the field mod poly
     */
    public ArrayList<NewPolynomial> moddedList(NewField field, NewPolynomial poly){
        ArrayList<NewPolynomial> list = new ArrayList<>();
        NewPolynomial r = new NewPolynomial("2");
         NewPolynomial q = new NewPolynomial("2");
        int i =0;
        LongDivision ld = new LongDivision(field.prime);
        while(field.fieldPoly.size()>i && !(q.checkIfOne() && r.checkIfZero())){            
            ld.divide(field.fieldPoly.get(i), poly);
            if (q.checkIfOne() && r.checkIfZero()) break;
            r=ld.rem;
            q=ld.quot;
            if (q.checkIfOne() && r.checkIfZero()) break;
            list.add(ld.rem);
            i++;       
        }
        return list;   
    }
    /*
    Creates the addition table.
    */
    void additionTable() {
        LongDivision ld = new LongDivision(field.prime);
                ArrayList<NewPolynomial> l1 = modlist;
        ArrayList<NewPolynomial> l2 = modlist;
        PolynomialsArithmetic pa = new PolynomialsArithmetic();
        int length = l1.size();
        System.out.print("\t");
        
        for (int j = 1; j <length;j++){
                l1.get(j).printWL();
                System.out.print("\t");
            }
        System.out.println();
        
        for(int i = 1;i< length; i++){
            l1.get(i).printWL();
            System.out.print("\t");
            for (int j =1; j < length; j++){
                ld.divide(pa.sum(l1.get(i), l2.get(j)).primeVersion(field.prime), poly);
                ld.rem.printWL();
                System.out.print("\t");
            }
            System.out.println();
        }

    }
    /*
        Creates the multiplication table
    */
    void multiplicationTable() {
         LongDivision ld = new LongDivision(field.prime);
                ArrayList<NewPolynomial> l1 = modlist;
        ArrayList<NewPolynomial> l2 = modlist;
        PolynomialsArithmetic pa = new PolynomialsArithmetic();
        int length = l1.size();
        System.out.print("\t");
        
        for (int j = 1; j <length;j++){
                l1.get(j).printWL();
                System.out.print("\t");
            }
        System.out.println();
        
        for(int i = 1;i< length; i++){
            l1.get(i).printWL();
            System.out.print("\t");
            for (int j =1; j < length; j++){
                ld.divide(pa.product(l1.get(i), l2.get(j)).primeVersion(field.prime), poly);
                ld.rem.printWL();
                System.out.print("\t");
            }
            System.out.println();
        }

    }

    
}
