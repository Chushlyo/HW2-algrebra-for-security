import java.util.ArrayList;

public class Field {
    int prime;
    int exponent;
    ArrayList<int[]> field;

    /**
     * Constructor that creates an field object
     * @param p the prime modulus
     * @param n the exponent
     */
    public Field(int p, int n) {
        this.prime = p;
        this.exponent = n;
        this.field = new ArrayList<>();
    }

    /**
     * method that generates irreducible polynomials
     */
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
        //generating the polynomials
        for (int i = 1; i <= exponent - 1; i++) {
            result.equals(addPolynomial(result, currentExp));
            currentExp++;
        }
        field = result;
    }

    /**
     * Recursive function that generates polynomials
     * @param currentRes  arraylist that contains the current generated polynomials
     * @param currentExp the current exponent that needs to be used for generating the new polynomials
     * @return
     */
    public ArrayList<int[]> addPolynomial(ArrayList<int[]> currentRes, int currentExp) {
        int length = currentRes.size();
        int[] polynomial = new int[exponent];
        int[] polynomial2 = new int[exponent];

        polynomial[currentExp] = currentExp;
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
        for (int j = 2; j < prime; j++) {
            for (int n = 0; n < length; n++) {
                int[] array = currentRes.get(n);
                for (int m = 0; m < array.length; m++) {
                    if (array[m] != 0 && n != 0) {
                        polynomial2[currentExp] = j;
                        polynomial2[m] = array[m];
                    }
                    if (n == 0) {
                        polynomial2[currentExp] = j;
                    }
                }
                currentRes.add(polynomial2);
                polynomial2 = new int[exponent];

            }
        }

        return currentRes;
    }

    /**
     * Method that prints the polynomials in the correct format
     */
    void print() {
        for (int[] current : field) {
            for (int i = 0; i < current.length; i++) {
                System.out.println(i + " is " + current[i]);
            }
            System.out.println("next-----------------");
        }

        boolean onlyCoefficients = true;
        int numberOfPol = 0;
        for (int[] current : field) {
            numberOfPol++;
            int place = current.length - 1;
            for (int i = current.length - 1; i >= 0; i--) {
                if (current[i] != 0 && place == 2) {
                    System.out.print("X^" + current[i]);
                    onlyCoefficients = false;
                } else if (place == 1) {
                    if (current[i] != 1 && current[i] != 0) {
                        if (onlyCoefficients) {
                            System.out.print(current[i] + "X");
                        } else {
                            System.out.print(" + " + current[i] + "X");
                        }
                        onlyCoefficients = false;
                    }
                    if (current[i] == 1) {
                        if (onlyCoefficients) {
                            System.out.print("X");
                        } else {
                            System.out.print(" + " + "X");
                        }
                        onlyCoefficients = false;
                    }

                } else if (place == 0) {
                    if (onlyCoefficients) {
                        System.out.print(current[i]);
                    } else if (current[i] != 0) {
                        System.out.print(" + " + current[i]);
                    }
                }
                place--;
            }
            if (numberOfPol != field.size()) System.out.println(",");
            onlyCoefficients = true;

        }
    }
}

