public class FieldTable {
    int prime;
    int exponent;
    Field field;

    public FieldTable(int p, int e) {
        this.prime = p;
        this.exponent = e;
        this.field = new Field(prime, exponent);
    }

    void additionTable() {

    }

    void multiplicationTable() {

    }
}
