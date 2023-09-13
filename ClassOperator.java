import java.util.Vector;

public class ClassOperator {
    
    Vector<Integer> num1 = new Vector<>();
    Vector<Integer> num2 = new Vector<>();
    Vector<Integer> result = new Vector<>();
    Integer base;


    private Vector<Integer> num1Aux = new Vector<>();
    private Vector<Integer> num2Aux = new Vector<>();
    private int cociente;
    private int residuo;


    // Metodo para hacer que los vectores auxiliares guarden los datos con la misma cantidad de items
    private void igualarArreglos(){
        int maxLength;

        if (num1.size() > num2.size()) maxLength = num1.size();
        else maxLength = num2.size();

        if(num1.size() == maxLength){
            for (int i = 0; i < maxLength; i++) {
                num1Aux.add(num1.get(i));
            }
        } else{
            int itemsToAdd =  maxLength - num1.size();
            for (int i = 0; i < itemsToAdd; i++) {
                num1Aux.add(0);
            }
            for (int i = 0; i < num1.size(); i++) {
                num1Aux.add(num1.get(i));
            }
        }

        if(num2.size() == maxLength){
            for (int i = 0; i < maxLength; i++) {
                num2Aux.add(num2.get(i));
            }
        } else{
            int itemsToAdd =  maxLength - num2.size();
            for (int i = 0; i < itemsToAdd; i++) {
                num2Aux.add(0);
            }
            for (int i = 0; i < num2.size(); i++) {
                num2Aux.add(num2.get(i));
            }
        }
    } 

    //Metodo que me permite conseguir el residuo y cociente de una division
    private void divideANumber(int dividendo, int divisor){
            int contador = 0;
            int totalResta = dividendo;
            while(totalResta >= divisor){
                totalResta = totalResta - divisor;
                contador++;
            }
            cociente = contador;
            residuo = totalResta;
    }

    //Metodo para verificar si un numero pertenece a la base
    private boolean belongBase(int baseParam, int number){
        if (number < baseParam){
            return true;
        }
        return false;
    }

    //Metodo para invertir vecores
    private Vector<Integer> flipVector(Vector<Integer> vectorParam){
        Vector<Integer> vectorAux = new Vector<>();
        int contador = vectorParam.size();

        for (int i = 0; i < vectorParam.size(); i++) {
            contador -= 1;
            vectorAux.add(vectorParam.get(contador));
        }

        return vectorAux;
    }
    
    //Metodo para realizar la suma de 2 numeros que llegan como vectores
    public Vector<Integer> suma(){

        igualarArreglos();
        int idenxResult = num1Aux.size();
        Integer total = 0;
        int addBase = 0;

        for (int i = (idenxResult - 1); -1 < i; i--) {
            total = num1Aux.get(i) + num2Aux.get(i) + addBase;
            if(belongBase(base, total)){
                result.add(total);
                addBase = 0;
            } else{
                divideANumber(total, base);
                result.add(residuo);
                addBase = cociente;
            }
        }
        
        if(addBase != 0) result.add(addBase);

        result = flipVector(result);

        return result;
    }
}
