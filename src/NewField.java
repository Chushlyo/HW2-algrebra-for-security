
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nikolay
 */
public class NewField {
    int prime;
    int exponent;
    ArrayList<int[]> fielTemp;
    ArrayList<NewPolynomial> fieldPoly;
      /**
     * Constructor that creates an field object
     * @param p the prime modulus
     * @param n the exponent
     */
    public NewField(int p, int n) {
        this.prime = p;
        this.exponent = n;
//        this.fieldTemp = new ArrayList<>();
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
//
//        /*
//        Printes the arrays
//        */
        for (int pk=0; pk< Math.pow((double) (prime), (double) exponent+1 );pk++){
            for(int f = 0; f<sArray.get(pk).length; f++)
            System.out.print(sArray.get(pk)[f]);
            System.out.println();
        }

        for (int pk=0; pk< Math.pow((double) (prime), (double) exponent+1 );pk++){
            NewPolynomial tempPoly = new NewPolynomial("x^"+exponent);
            tempPoly.defineByArray(sArray.get(pk));
            fieldPoly.add(tempPoly);
           //tempPoly.print();
        }
        exponent++;
    }
    
        public ArrayList<NewPolynomial>  getPolys(){
        return fieldPoly;
        }
        
        public void printField(){
            for (int i = 0; i<fieldPoly.size();i++)
                fieldPoly.get(i).print();
        }
        void print() {
//        for (NewPolynomial p : fieldPoly) {
//            for (int i = 0; i < p.getCoef().length; i++) {
//                System.out.println(i + " is " + p.getCoef()[i]);
//            }
//            System.out.println("next-----------------");
//        }

        boolean onlyCoefficients = true;
        int numberOfPol = 0;
        for (NewPolynomial p : fieldPoly) {
            numberOfPol++;
            int place = p.getCoef().length - 1;
            for (int i =  p.getCoef().length - 1; i >= 0; i--) {
                if ( p.getCoef()[i] != 0 && place == 2) {
                    System.out.print("X^" +  p.getCoef()[i]);
                    onlyCoefficients = false;
                } else if (place == 1) {
                    if ( p.getCoef()[i] != 1 &&  p.getCoef()[i] != 0) {
                        if (onlyCoefficients) {
                            System.out.print( p.getCoef()[i] + "X");
                        } else {
                            System.out.print(" + " +  p.getCoef()[i] + "X");
                        }
                        onlyCoefficients = false;
                    }
                    if ( p.getCoef()[i] == 1) {
                        if (onlyCoefficients) {
                            System.out.print("X");
                        } else {
                            System.out.print(" + " + "X");
                        }
                        onlyCoefficients = false;
                    }

                } else if (place == 0) {
                    if (onlyCoefficients) {
                        System.out.print( p.getCoef()[i]);
                    } else if ( p.getCoef()[i] != 0) {
                        System.out.print(" + " +  p.getCoef()[i]);
                    }
                }
                place--;
            }
            if (numberOfPol !=  fieldPoly.size()) System.out.println(",");
            onlyCoefficients = true;

        }
    }

}

            
            
        
        
        
        
//        for (int i1=2;i1<=exponent+1; i1++){
//            ArrayList<int[]> sArray = new ArrayList();
//            
//            for (int pk=0; pk< (prime)*Math.pow((double) (i1-1), (double) prime );pk++){
//                sArray.add(new int[i1]);
////                System.out.println(pk);
//            }
//            
//            for(int i=0;i<i1;i++){
//            int j=0;    
////            for (int pk=0; pk< Math.pow((double) i1, (double) prime );pk++){
//            int pk=0; 
//            while (pk< (prime)*Math.pow((double) (i1-1), (double) prime )){    
//                for (int i3=0; i3<Math.pow((double) prime, (double) i );i3++){
//                    sArray.get(pk)[i1-i-1] = j;
//                    pk++;
//                }
////                System.out.println(j);
//                j++;
//                j=j%prime;
//                
//            }
//                
//                
//
//            }
//            
//            for (int pk=0; pk< (prime)*Math.pow((double) (i1-1), (double) prime );pk++){
//                for(int f = 0; f<sArray.get(pk).length; f++)
//                System.out.print(sArray.get(pk)[f]);
////                System.out.println(pk);
//                System.out.println();
//            }
//        }
//        
//        
//        
//        //generating the polynomials
////        for (int i = 1; i <= exponent - 1; i++) {
////            result.equals(addPolynomial(result, currentExp));
////            currentExp++;
////        }
////        field = result;
//    }
//    
//    public void addGenerate(int p, int n){
//        for(int i=0;i<n;i++){
//            for(int j=0;j<p;j++){
//                
//                
//            }
//        }
//        
//    }

