// for the input we need to plus each part of the polynomial to the biggest degree
public class Polynomial {
    private int[] coefficent; 
    private int degree;   

    public Polynomial(int a, int x) {
        coefficent = new int[x+1];
        coefficent[x] = a;
        removeO();
    }

    private void removeO() {
        degree = -1;
        for (int i = coefficent.length - 1; i >= 0; i--) {
            if (coefficent[i] != 0) {
                degree = i;
                return;
            }
        }
    }
    
    public int degree() {
        return degree;
    }

    public Polynomial plus(Polynomial that) {
        Polynomial poly = new Polynomial(0, Math.max(this.degree, that.degree));
        for (int i = 0; i <= this.degree; i++) poly.coefficent[i] += this.coefficent[i];
        for (int i = 0; i <= that.degree; i++) poly.coefficent[i] += that.coefficent[i];
        poly.removeO();
        return poly;
    }
    
    public void convertPrime (int p){
        for (int i = 0; i <= this.degree; i++){
            coefficent[i] = coefficent[i]%p;
        }
        
    }
}
