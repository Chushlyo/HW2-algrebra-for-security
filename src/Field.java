import java.lang.Integer;
import java.util.ArrayList;

public class Field {
    int prime;
    int exponent;
    ArrayList<int[]> field;


    public Field(int p, int n) {
        this.prime = p;
        this.exponent = n;
        this.field = new ArrayList<>();
    }

    public void generate() {
        int currentExp = 1;

        ArrayList<int[]> result = new ArrayList();
        //adding the zero polynomial;
        result.add(new int[exponent]);
        //adding the coefficients

        for (int j = 1; j <= prime - 1; j++) {
            int[] a = new int[exponent];
            a[0] = j;
            result.add(a);

        }

        for (int i = 1; i <= exponent - 1; i++) {
            result.equals(addPolynomial(result, currentExp));
            currentExp++;
        }

        field = result;
    }

    public ArrayList<int[]> addPolynomial(ArrayList<int[]> currentRes, int currentExp) {
        int length = currentRes.size();
//        polynomial[currentExp] = currentExp;
//        if (index == length) {
//            for (int i = 1; i < currentRes.size() - 1; i++) {
//                int[] array = currentRes.get(i);
//                for (int n = 0; n < array.length; n++) {
//                    if (array[n] != 0) polynomial[n] = array[n];
//                }
//
//            }
//        }
        int[] polynomial = new int[exponent];
        int[] polynomial2 = new int[exponent];

             polynomial[currentExp] =currentExp;
             currentRes.add(polynomial);
             polynomial = new int[exponent];
             for (int n = 1; n < length; n++) {
                 int[] array = currentRes.get(n);
                 for (int m = 0; m < array.length; m++) {
                     if (array[m] != 0) {
                         polynomial2[currentExp] = currentExp;
                         polynomial2[m] = array[m];
                     }
                 }

                 currentRes.add(polynomial2);
                 polynomial2 = new int[exponent];


             }


        // }

        return currentRes;
    }

    void print() {
        for (int[] current : field) {
            for (int i = 0; i < current.length; i++) {
                System.out.println(i + " is " + current[i]);
            }
            System.out.println("next-----------------");
        }
        int place = 1;
        for (int[] current : field) {
            for (int i = 0; i < current.length; i++) {
                if (place == 1) {
                    System.out.print(current[i]);
                    place++;
                } else if (place == 2) {
                    if (current[i] != 1 && current[i] != 0) System.out.print(" + " + current[i] + "X");
                    if (current[i] == 1) System.out.print(" + " + "X");
                    place++;
                } else if (current[i] != 0) {
                    System.out.print(" + " + "X^" + i);
                    place++;
                }
            }
            System.out.println(",");
            place = 1;
        }
    }

    public static void main(String[] args) {
        Field field = new Field(2, 3);
        ArrayList<int[]> print = new ArrayList<>();
        print.add(new int[]{0, 0, 0});
        print.add(new int[]{1, 0, 0});
        print.add(new int[]{0, 1, 0});
        print.add(new int[]{1, 1, 0});
        print.add(new int[]{0, 0, 1});
        print.add(new int[]{1, 0, 1});
        print.add(new int[]{0, 1, 1});
        print.add(new int[]{1, 1, 1});
        field.print();
    }
}

