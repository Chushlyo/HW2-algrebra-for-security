// for the input we need to plus each part of the polynomial to the biggest degree
public class Polynomial {
    private int[] coefficient;
    private int degree;
    private int p;

    public Polynomial(int a, int x) {
        this.coefficient = new int[x+1];
        this.coefficient[x] = a;
        this.degree = x;
//        removeO();
    }
    public int[] getCoefficient(){
        return this.coefficient;
    }
    public  void setCoefficient(int[] coeff){
        this.coefficient=coeff;
    }
    private void removeO() {
        degree = -1;
        for (int i = coefficient.length - 1; i >= 0; i--) {
            if (coefficient[i] != 0) {
                degree = i;
                return;
            }
        }
    }
    
    public int degree() {
        return degree;
    }

    public void print(){
        for (int i = 0; i<degree+1;i++){
            if(coefficient[degree-i]!=0)
            System.out.print(coefficient[degree-i] + "x^" + (degree-i) +"+");
        }

    }

    public Polynomial plus(Polynomial that) {
        Polynomial poly = new Polynomial(0, Math.max(this.degree, that.degree));
        for (int i = 0; i <= this.degree; i++) poly.coefficient[i] += this.coefficient[i];
        for (int i = 0; i <= that.degree; i++) poly.coefficient[i] += that.coefficient[i];
//        poly.removeO();
        return poly;
    }
    
    public void convertPrime (int p){
        for (int i = 0; i <= this.degree; i++){
            this.coefficient[i] = this.coefficient[i]%p;
        }
        
    }
}
