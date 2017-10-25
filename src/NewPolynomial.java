
/*
    Creates a polynomial of a given degreee
    Coefficients are saved in array with the index being the degree 
    they correspond to.
*/
public class NewPolynomial {

    private int[] coefficient;
    private int degree;
    private IntegerMod integerMod;

    public NewPolynomial(String poly) {
        integerMod = new IntegerMod();
        this.coefficient = extractCoef(poly);
        this.removeLeadingO();

    }
    
    /*
        Given a string input reads the polynomial and creates the coefficient
        array.
    */
    public int[] extractCoef(String poly) {

        boolean minus= (false);
        int i = 1;
        int k = 0;

        int firstCoef;

        if(poly.substring(0,1).equals("-")){
            poly  = poly.substring(1,poly.length());
            {
                minus = true;

            }
        }
        if(poly.length()==1&& !poly.substring(0,1).equals("x")){
            
            coefficient  = new int[1];
            if(minus)
            coefficient[0] = -Integer.valueOf(poly.substring(0,1));
            else coefficient[0] = Integer.valueOf(poly.substring(0,1));
            degree = 0;
            return coefficient;
        }
        //If the first thing you read is x, then the coef is 1
        if(poly.substring(0,1).equals("x")){
            firstCoef = 1;
            degree = 1;

        }else
            if(poly.substring(1,2).equals("x") && poly.substring(0,1).equals("-")){
            firstCoef= -1;
            degree = 1;
            }
        else{


            //if it is not x find out what the coef is
            while (!poly.substring(k,k+1).equals("x")){
                k++;
                //if it is of ^0 then you need this
                if(k>=poly.length()) break;
            }
            firstCoef=Integer.valueOf(poly.substring(0,k));

            //the string without the coef
            poly = poly.substring(k,poly.length());
        }


        if(poly.length()==0){
            coefficient  = new int[1];
            if (minus)
            coefficient[0] = -firstCoef;
            else coefficient[0] = firstCoef;
            degree = 0;
        }else
            //if of ^0 return

            if(poly.length()==1){
                coefficient  = new int[2];
                if (minus)
                coefficient[1] = -firstCoef;
                else coefficient[1] = firstCoef;
                degree = 1;
            }else
                //if^1 without^0 return here

                //if it is of bigger degree than 1 Go here
                if(poly.substring(1,2).equals("^")){
                    k=0;
                    while (!poly.substring(2+k,2+k+1).equals("-") &&!poly.substring(2+k,2+k+1).equals("+")){
                        k++;
                        //if it is of ^0 then you need this
                        if(2+k>=poly.length()) break;
                    }
                    degree=Integer.valueOf(poly.substring(2,2+k));

                    //the string without the degree
                    poly = poly.substring(2+k,poly.length());
                    
//                    degree = Integer.valueOf(poly.substring(2,3));
                    coefficient = new int[degree+1];
                    if(minus)
                    coefficient[degree] = -firstCoef;
                    else coefficient[degree] = firstCoef;
                    
//                    System.out.println("wtf"+poly);
//                    if(poly.length()>3){
//                        poly=poly.substring(3,poly.length());
//                    }
//                    else poly=poly.substring(3,poly.length());
                    while (poly.length()>0){


//                        System.out.println(poly);
                        if(poly.substring(1,2).equals("x") && poly.substring(0,1).equals("+")){
                            firstCoef = 1;
                            poly = poly.substring(1,poly.length());

                        }
                        else if(poly.substring(1,2).equals("x") && poly.substring(0,1).equals("-")){
                            firstCoef= -1;
                            poly = poly.substring(1,poly.length());

                        }else{
                            k = 0;

                            while (!poly.substring(k,k+1).equals("x")){
                                k++;
                                if(k>=poly.length()) break;
                            }

                            firstCoef=Integer.valueOf(poly.substring(0,k));


                            poly = poly.substring(k,poly.length());
                        }

                        if(poly.length()==0) {
                            coefficient[0] = firstCoef;
                            break;
                        }else
                            //if of ^0 return

                            if(poly.length()==1 || (poly.length()==2 && poly.substring(0,1).equals("-"))){
                                coefficient[1] = firstCoef;
                                break;
                            }
                            else
                                //if^1 without^0 return here
                                
                                if(poly.substring(1,2).equals("^")){
                                    k=0;
                                    while (!poly.substring(2+k,2+k+1).equals("-") &&!poly.substring(2+k,2+k+1).equals("+")){
                                        k++;
                                        //if it is of ^0 then you need this
                                        if(2+k>=poly.length()) break;
                                    }
                                    

                            //the string without the coef
                                    
                                    coefficient[Integer.valueOf(poly.substring(2,2+k))] = firstCoef;
//                                    System.out.println(poly+"wtf");
                                    if(poly.length()>=3 ){
                                        poly = poly.substring(2+k,poly.length());
                                    }

                                    else poly=poly.substring(1,poly.length());

                                }else{
                                    coefficient[1] = firstCoef;
                                    coefficient[0] = Integer.valueOf(poly.substring(1,poly.length()));
                                    break;
                                }

                        i++;

                    }
                }else{
                    
                    coefficient = new int[2];
                    if(minus)    coefficient[1] = -firstCoef;
                    else coefficient[1] = firstCoef;
                    coefficient[0] = Integer.valueOf(poly.substring(2,poly.length()));
                }
        return coefficient;
    }
    
    /*
        Prints the array.
    */
    public void print() {
        if (degree == 0 && coefficient[0]>=0){
            System.out.println(coefficient[0]);
            return;
        }
        else if (degree == 0 && coefficient[0]<0){
            System.out.println(coefficient[0]);
            return;
        }
        
       

        String printer = new String();
        if(degree>1 && coefficient[degree]!=1 &&  coefficient[degree]!=-1)
            printer = (coefficient[degree] + "x^" + (degree));
        else if(degree>1 && coefficient[degree]==1)
            printer = ("x^" + (degree));
        else if(degree>1 && coefficient[degree]==-1)
            printer = ("-x^" + (degree));
        for (int i = 1; i <= degree; i++){
            if (degree - i > 1 && coefficient[degree - i] > 1) {
                printer = (printer +"+"+ coefficient[degree - i] + "x^" + (degree - i));
            }
            if (degree - i > 1 && coefficient[degree - i] == 1) {
                printer = (printer +"+"+"x^" + (degree - i));
            }
            else if (degree - i > 1 && coefficient[degree - i] == -1 ) {
                printer = (printer + "-" + "x^" + (degree - i));
            }
            else if (degree - i > 1 && coefficient[degree - i] <  -1) {
                printer = (printer + coefficient[degree - i] + "x^" + (degree - i));
            }
        }
        
        if(degree == 1 && coefficient[1] == 1){
            printer = ("x");
        }
        
        else if(degree == 1 && coefficient[1] == -1){
            printer = ("-" + "x");
        }
        else if(degree ==1  ){
            printer = ( coefficient[1] + "x");
        }
        
        else if (degree > 0 && coefficient[1] > 0) {
            printer = (printer +"+"+ coefficient[1] + "x");
        }
        else if(degree > 0 && coefficient[1] == -1){
            printer = (printer + "-" + "x");
        }
        else if(degree > 0 && coefficient[1] < 0){
            printer = (printer + coefficient[1] + "x");
        }

        if (coefficient[0] > 0) {
            printer = (printer +"+"+ coefficient[0]);
        }
        if (coefficient[0] < 0) {
            printer = (printer + coefficient[0]);
        }
        
        System.out.println(printer);
    }
    
    /*
        Prints the array without a new line
    */
    public void printWL() {
        if (degree == 0 && coefficient[0]>=0){
            System.out.print(coefficient[0]);
            return;
        }
        else if (degree == 0 && coefficient[0]<0){
            System.out.print(coefficient[0]);
            return;
        }
        String printer = new String();
        if(degree>1 && coefficient[degree]!=1 &&  coefficient[degree]!=-1)
            printer = (coefficient[degree] + "x^" + (degree));
        else if(degree>1 && coefficient[degree]==1)
            printer = ("x^" + (degree));
        else if(degree>1 && coefficient[degree]==-1)
            printer = ("-x^" + (degree));
        for (int i = 1; i <= degree; i++){
            if (degree - i > 1 && coefficient[degree - i] > 1) {
                printer = (printer +"+"+ coefficient[degree - i] + "x^" + (degree - i));
            }
            if (degree - i > 1 && coefficient[degree - i] == 1) {
                printer = (printer +"+"+"x^" + (degree - i));
            }
            else if (degree - i > 1 && coefficient[degree - i] == -1 ) {
                printer = (printer + "-" + "x^" + (degree - i));
            }
            else if (degree - i > 1 && coefficient[degree - i] <  -1) {
                printer = (printer + coefficient[degree - i] + "x^" + (degree - i));
            }
        }
        
        if(degree == 1 && coefficient[1] == 1){
            printer = ("x");
        }
        
        else       
        if(degree == 1 && coefficient[1] == -1){
            printer = ("-" + "x");
        }
        else if(degree ==1 ){
            printer = ( coefficient[1] + "x");
        }
        
        else if (degree > 0 && coefficient[1] > 0) {
            printer = (printer +"+"+ coefficient[1] + "x");
        }
        else if(degree > 0 && coefficient[1] == -1){
            printer = (printer + "-" + "x");
        }
        else if(degree > 0 && coefficient[1] < 0){
            printer = (printer + coefficient[1] + "x");
        }

        if (coefficient[0] > 0) {
            printer = (printer +"+"+ coefficient[0]);
        }
        if (coefficient[0] < 0) {
            printer = (printer + coefficient[0]);
        }
        
        System.out.print(printer);
    }
    
    /*
        Changes all the coefficients of the array with their corresponding
        integer to the prime.
    */
    public void convertPrime(int p) {
        for (int i = 0; i <= this.degree; i++) {
            this.coefficient[i] = integerMod.modReduction(p, this.coefficient[i]);
        }
        this.removeLeadingO();

    }
    /*
        Same functions as the above
    */
    public NewPolynomial primeVersion(int p) {
        this.convertPrime(p);
        return this;

    }
    
    /*
        Changes the coefficient array of the given polynomial to the given array.
    */
    public void defineByArray(int[] a){
        int length = a.length;
        this.coefficient = new int[length];
        for (int i = 0; i<length; i++)
        this.coefficient[i] = a[length-1-i];
        removeLeadingO();
    }
    
    /*
        If after some operations the leading coefficient has become 0 lower 
        the degree to the next non zero coefficient.
    */
    public void removeLeadingO(){
        degree = 0;
        for (int i = 0; i <this.coefficient.length; i++) {
            if (this.coefficient[this.coefficient.length-i-1] != 0) {;
                degree = this.coefficient.length-i-1;
                return;
            }
        }
    }
    
    /*
        Checks if the given polynomial is 1
    */
    public boolean checkIfOne(){
        removeLeadingO();
        if(this.degree == 0 && coefficient[0] == 1){
            return true;
        }
        else return false;
    }
    /*
        Checks if the given polynomial is 0.
    */
    public boolean checkIfZero(){
        removeLeadingO();
        if(this.degree<0) return true;
        if(this.degree == 0 && coefficient[0] == 0){
            return true;
        }
        else return false;
    }
    
    /*
        Returns the degree of the array
    */
    public int getDegree() {
        return this.degree;
    }

    public NewPolynomial changeDegree(int newDegree, NewPolynomial old) {
        NewPolynomial newpoly = new NewPolynomial("x^" + newDegree);
//        newpoly.degree=newDegree;
        for (int i = 0; i <= newDegree; i++) {
            newpoly.coefficient[i] = old.coefficient[i];
        }
//        //in order to remove adding the first degree at the start
//        newpoly.subtoThisCoef(newpoly.getDegree(), 1);
        return newpoly;
    }
    
    /*
        Returns the coefficient array
    */
    public int[] getCoef() {
        return this.coefficient;
    }

    /*
    Returns the chosen coefficient.
    */
    public int getThisCoef(int k) {
        return this.coefficient[k];
    }

    //Used in product of two polynomials
    public void changeThisCoef(int k, int change) {
        this.coefficient[k] = this.coefficient[k] + change;
    }

    //Addition
    public void addtoThisCoef(int k, int change) {
        this.coefficient[k] = this.coefficient[k] + change;
    }

    //Subtraction
    public void subtoThisCoef(int k, int change) {
        this.coefficient[k] = this.coefficient[k] - change;
    }

    //Scalar multiplication
    public NewPolynomial scalar(int s) {
        for (int i = 0; i <= degree; i++) {
            this.coefficient[i] = this.coefficient[i] * s;
        }
        return this;
    }
    /*
        Function which checks if 2 coefficients are equal.
    */
    public boolean checkIfEqual (NewPolynomial p1, NewPolynomial p2){
        
        if(p1.getDegree()==p2.getDegree()){
            for(int i= 0; i <= p1.getDegree();i++){
                if(p1.getThisCoef(i)!=p2.getThisCoef(i))
                    return false;
            }
            return true;
        }
        
        else
            return false;
    }
}
