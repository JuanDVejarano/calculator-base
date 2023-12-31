import java.util.Vector;

public class ClassConvert {

    //#region variables
    int base;
    Vector<Integer> vector = new Vector<>();
    Long value;
    //#endregion

    //#region metodos
    public long numToDEcimal(){
        Vector<Integer> itemSuma = new Vector<>();
        long total = 0;
        int potencia = 0;
        for (int i = (vector.size() -1); -1 < i; i--) {
            double valor = vector.get(i) * Math.pow(base, potencia);
            itemSuma.add((int)valor);
            potencia ++;
        }

        for (long value : itemSuma) {
            total = total + value;
        }

        return total;

    } 

    public String decimalToNum(){
        Vector<Integer> itemTotalAux = new Vector<>();
        Vector<Integer> itemTotal = new Vector<>();

        int residuo = 0;
        Long valAux = value;
        while (valAux != 0){
            residuo =  valAux.intValue() % base;
            valAux = valAux / base;
            itemTotalAux.add(residuo);
        }

        for (int i = (itemTotalAux.size() -1); -1 < i; i--) { // Dar la vuelta al vector para el numero resultante
            itemTotal.add(itemTotalAux.get(i));
        }

        String total = "";
        for (Integer sumCont : itemTotal) {
            total = total + String.valueOf(sumCont);
        }

        //return Integer.parseInt(total);
        return total;
    }
    //#endregion
}
