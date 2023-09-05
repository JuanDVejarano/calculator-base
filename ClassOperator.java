import java.util.Vector;

public class ClassOperator {
    
    Vector<Integer> num1 = new Vector<>();
    Vector<Integer> num2 = new Vector<>();

    public int suma(){
        int maxLength;
        Vector<Integer> num1Aux = new Vector<>();
        Vector<Integer> num2Aux = new Vector<>();

        for (int i = (num1.size() -1); -1 < i; i--) { // Dar la vuelta al vector para el numero resultante
            num1Aux.add(num1.get(i));
        }

        for (int i = (num2.size() -1); -1 < i; i--) { // Dar la vuelta al vector para el numero resultante
            num1Aux.add(num2.get(i));
        }
        return 0;
    }
}
