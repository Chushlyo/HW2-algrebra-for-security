// for the input we need to plus each part of the polynomial to the biggest degree
public class Polynomial {
    private int[] coefficient;
    private int degree;   
    private int p;
    public Polynomial(int a, int x) {
        coefficient = new int[x+1];
        coefficient[x] = a;
        p = x;
//        removeO();
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
        for (int i = 0; i<p;i++){
            System.out.print(coefficient[p-i] + "x^" + (p-i) +"+");
        }

    }

    public Polynomial plus(Polynomial that) {
        Polynomial poly = new Polynomial(0, Math.max(this.degree, that.degree));
        for (int i = 0; i <= this.degree; i++) poly.coefficient[i] += this.coefficient[i];
        for (int i = 0; i <= that.degree; i++) poly.coefficient[i] += that.coefficient[i];
        poly.removeO();
        return poly;
    }
    
    public void convertPrime (int p){
        for (int i = 0; i <= this.degree; i++){
            coefficient[i] = coefficient[i]%p;
        }
        
    }
}
