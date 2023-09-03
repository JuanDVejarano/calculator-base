import java.util.Vector;

public class ClassConvert {

    int base;
    Vector<Integer> vector = new Vector<>();

    public int numToDEcimal(){
        Vector<Integer> itemSuma = new Vector<>();
        int total = 0;

        for (int i = (vector.size() -1); -1 < i; i--) {
            double valor = vector.get(i) * Math.pow(base, i);
            itemSuma.add((int)valor);
        }

        for (Integer value : itemSuma) {
            total = total + value;
        }
        
        return total;

    } 

    public int decimalToNum(){
        return 0;
    }
}
