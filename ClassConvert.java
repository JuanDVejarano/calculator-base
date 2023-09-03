import java.util.Vector;

public class ClassConvert {

    int base;
    Vector<Integer> vector = new Vector<>();
    int value;

    public int numToDEcimal(){
        Vector<Integer> itemSuma = new Vector<>();
        int total = 0;
        int potencia = 0;
        for (int i = (vector.size() -1); -1 < i; i--) {
            double valor = vector.get(i) * Math.pow(base, potencia);
            itemSuma.add((int)valor);
            potencia ++;
        }

        for (Integer value : itemSuma) {
            total = total + value;
        }

        return total;

    } 

    public int decimalToNum(){
        Vector<Integer> itemTotalAux = new Vector<>();

        int residuo = 1;
        int valAux = value;
        while (residuo == 0){
            residuo = valAux % base;
            valAux = valAux / base;
            itemTotalAux.add(residuo);
        }

        return 0;
    }
}
