import java.util.Vector;

public class ClassOperator {
    
    Vector<Integer> num1 = new Vector<>();
    Vector<Integer> num2 = new Vector<>();

    public int suma(){
        int maxLength;
        Vector<Integer> num1Aux = new Vector<>();
        Vector<Integer> num2Aux = new Vector<>();

        if (num1.size() >= num2.size()){
            maxLength = num1.size();
        } else {
            maxLength = num2.size();
        }

        int contador = 0;
        while (contador == maxLength){
            int valueSum1;
            int valueSum2;
            int baseExcedente;
            if (num1.get(contador) != null){
                valueSum1 = num1.get(contador);
            }
        }


        for (int i = 0; i < maxLength; i++) {
            
        }

        for (int i = 0; i < maxLength; i++) {
            if(contador <= num1.size()){
                num1Aux.add(num1.get(contador));
            } else {
                num1Aux.add(0);
            }

            if(contador <= num2.size()){
                num2Aux.add(num2.get(contador));
            } else {
                num2Aux.add(0);
            }
            contador --;
        }

        

        return 0;
    }
}
