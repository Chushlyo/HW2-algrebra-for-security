/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Nikolay
 */
public class NewPolynomial {

    private int[] coefficient;
    private int degree;

    public NewPolynomial(String poly) {

        this.coefficient = extractCoef(poly);

    }

    public int[] extractCoef(String poly) {

        boolean minus= (true);
        int i = 1;
        int k = 0;

        int firstCoef;

        if(poly.substring(0,1).equals("-")){
            poly.substring(1,poly.length());
            {
                minus = true;

            }
        }
        if(poly.length()==1&& !poly.substring(0,1).equals("x")){
            coefficient  = new int[1];
            coefficient[0] = Integer.valueOf(poly.substring(0,1));
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
            coefficient[0] = firstCoef;
            degree = 0;
        }else
            //if of ^0 return

            if(poly.length()==1){
                coefficient  = new int[2];
                coefficient[1] = firstCoef;
                degree = 1;
            }else
                //if^1 without^0 return here

                //if it is of bigger degree than 1 Go here
                if(poly.substring(1,2).equals("^")){

                    degree = Integer.valueOf(poly.substring(2,3));
                    coefficient = new int[degree+1];
                    coefficient[degree] = firstCoef;

                    if(poly.length()>3){
                        poly=poly.substring(3,poly.length());
                    }
                    else poly=poly.substring(3,poly.length());

                    while (poly.length()>0){


                        System.out.println(poly);
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
                                    coefficient[Integer.valueOf(poly.substring(2,3))] = firstCoef;
                                    System.out.println(poly+"wtf");
                                    if(poly.length()>3 ){
                                        poly=poly.substring(3,poly.length());
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

                    coefficient[1] = firstCoef;
                    coefficient[0] = Integer.valueOf(poly.substring(2,poly.length()));
                }
        return coefficient;
    }

    public void print() {

        String printer = new String();

        for (int i = 0; i < degree; i++) {
            if (degree - i > 1 && coefficient[degree - i] != 0) {
                printer = (printer + coefficient[degree - i] + "x^" + (degree - i) + "+");
            }
        }

        if (degree > 0 && coefficient[1] != 0) {
            printer = (printer + coefficient[1] + "x+");
            if (coefficient[0] != 0) {
                printer = (printer + coefficient[0] + "+");
            }
        } else {
            if (coefficient[0] != 0) {
                printer = (printer + coefficient[0] + "+");
            }
        }

        if (degree > 0) {
            printer = printer.substring(0, printer.length() - 1);
        }
        System.out.println(printer);
    }

    public void convertPrime(int p) {
        for (int i = 0; i <= this.degree; i++) {
            this.coefficient[i] = this.coefficient[i] % p;
        }

    }

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

    public int[] getCoef() {
        return this.coefficient;
    }

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

}
