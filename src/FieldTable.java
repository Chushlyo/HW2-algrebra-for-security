
import java.util.ArrayList;

public class FieldTable {
    NewField field;
    NewPolynomial poly;
    ArrayList<NewPolynomial> modlist = new ArrayList<>();
    ArrayList<NewPolynomial> polys  = new ArrayList<>();;

    public FieldTable(NewField f, NewPolynomial p) {
        this.field = f;
        this.poly = p;
        this.modlist = moddedList(field,poly);
        multiplicationTable();
//        addAsList();

    }
    
    public ArrayList<NewPolynomial> moddedList(NewField field, NewPolynomial poly){
        ArrayList<NewPolynomial> list = new ArrayList<>();
        NewPolynomial r = new NewPolynomial("2");
         NewPolynomial q = new NewPolynomial("2");
        int i =0;
        LongDivision ld = new LongDivision(field.prime);
        while(field.fieldPoly.size()>i && !(q.checkIfOne() && r.checkIfZero())){
//            System.out.println();
//            field.fieldPoly.get(i).print();
            
            ld.divide(field.fieldPoly.get(i), poly);
            if (q.checkIfOne() && r.checkIfZero()) break;
            r=ld.rem;
//            System.out.println("r is");
//            r.print();
//            System.out.println("quot is");
//            q.print();
            q=ld.quot;
            list.add(ld.rem);
            i++;       
        }
        
//        for (i = 0; i < list.size();i++){
//            list.get(i).print();
//        }
        return list;   
    }

    void additionTable() {
        LongDivision ld = new LongDivision(field.prime);
        ArrayList<NewPolynomial> l1 = modlist;
        ArrayList<NewPolynomial> l2 = modlist;
        PolynomialsArithmetic pa = new PolynomialsArithmetic();
        int length = l1.size();
//        System.out.print("     ");
        
//        for (int j = 1; j <length;j++){
//                l1.get(j).printWL();
//                System.out.print("   |    ");
//            }
//        System.out.println();
        
        for(int i = 1;i< length; i++){
//            modlist.get(i).print();
            
            for (int j =1; j < length; j++){
                System.out.print("Sum of: ");
                l1.get(i).printWL();
                System.out.print("and: ");
                l1.get(j).printWL();
                System.out.println("is: ");
                ld.divide(pa.sum(l1.get(i), l2.get(j)).primeVersion(field.prime), poly);
                ld.rem.printWL();
//                System.out.print("   |    ");
                System.out.println();
            }
            System.out.println();
        }

    }

    void multiplicationTable() {
         LongDivision ld = new LongDivision(field.prime);
                ArrayList<NewPolynomial> l1 = modlist;
        ArrayList<NewPolynomial> l2 = modlist;
        PolynomialsArithmetic pa = new PolynomialsArithmetic();
        int length = l1.size();
//        System.out.print("     ");
        
//        for (int j = 1; j <length;j++){
//                l1.get(j).printWL();
//                System.out.print("   |    ");
//            }
//        System.out.println();
        
        for(int i = 1;i< length; i++){
//            modlist.get(i).print();
            
            for (int j =1; j < length; j++){
                System.out.print("Sum of: ");
                l1.get(i).printWL();
                System.out.print("and: ");
                l1.get(j).printWL();
                System.out.println("is: ");
                ld.divide(pa.product(l1.get(i), l2.get(j)).primeVersion(field.prime), poly);
                ld.rem.printWL();
//                System.out.print("   |    ");
                System.out.println();
            }
            System.out.println();
        }

    }

    
}
