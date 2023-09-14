import java.util.Vector;

public class ClassOperator {
    
    Vector<Integer> num1 = new Vector<>();
    Vector<Integer> num2 = new Vector<>();
    Integer base;


    private Vector<Integer> num1Aux = new Vector<>();
    private Vector<Integer> num2Aux = new Vector<>();
    private Vector<Integer> vectorcomplemento = new Vector<>();
    private int cociente;
    private int residuo;

    //Constructor
    public ClassOperator(Vector<Integer> num1, Vector<Integer> num2, Integer base){
        this.num1 = num1;
        this.num2 = num2;
        this.base = base;
    };

    //#region Metodos privados
    
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
    
    //Encuentra el complemento del sustraendo
    private void complemento(){
        Vector<Integer> complementoAux = new Vector<>();
        Vector<Integer> temporalNum1 = new Vector<>();
        Vector<Integer> addComplemento = new Vector<>();
        //addComplemento.add(1); //Vector para sumarle al complemento el 1

        //temporalNum1 = num1;
        // Se encuentra el complemento
        for (int i = 0; i < num1Aux.size(); i++) {
            int varComplemento = (base - 1) - num2Aux.get(i);
            complementoAux.add(varComplemento);
            if(i < (num1Aux.size() - 1))addComplemento.add(0);
            else addComplemento.add(1);
        }

        // se asignan los valres para sumarle 1 al complemento y mandar el metodo sumar
        num1Aux = complementoAux;
        num2Aux = addComplemento;
        vectorcomplemento = suma(); // se le suma al complemento 1
        //num1 = temporalNum1;
    }

    //Metodo para realizar la suma de num1Aux y num2Aux
    private Vector<Integer> suma(){

        Vector<Integer> result = new Vector<>();
        cociente = 0;
        residuo = 0;
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

        num1Aux.removeAllElements();
        num2Aux.removeAllElements();

        return result;
    }

    //#endregion

    //#region Metodos publicos

    //Metodo publico para la suma
    public Vector<Integer> inputSuma(){
        igualarArreglos(); // se igual los arreglos para que tengan el mismo numero de items
        return suma();  // Se suman los numeros dentro de los vectores auxiliares
    }
    
    //Metodo para realizar la resta de 2 numeros que llegan como vectores usando el complementos
    public Vector<Integer> inputRestar(){
        Vector<Integer> vectorTemporal = new Vector<>();
        igualarArreglos(); // Se igualn los arreglos para que tengan la misma cantidad de digitos complentandolos con 0
        complemento(); // se Encuentra el complemento y se guarda en una atrivuto del objeto
        num1Aux = num1; // se asigna al objeto el primer valor que se va a sumar
        num2Aux = vectorcomplemento; // se asigna al objeto el segundo valor(Complemento) que se va a sumar
        vectorTemporal = suma(); // se suma el primer valor con el complemento
        vectorTemporal.remove(0); //Quitamos el primer valor
        return vectorTemporal;
    }

    // Metodo para la multiplicacion
    public Vector<Integer> inputMultiplicacion(){
        Vector<Integer> resultadoProducto = new Vector<>();
        Long cantidad;
        ClassConvert instanciaCovert = new ClassConvert();

        instanciaCovert.vector = num2;
        instanciaCovert.base = base;
        cantidad = instanciaCovert.numToDEcimal();

        num2 = num1;
        igualarArreglos();
        
        for (int i = 1; i < cantidad; i++) {
            resultadoProducto = suma();
            num2 = resultadoProducto;
            igualarArreglos();
        }

        
        return resultadoProducto;
    }

    // Metodo para dividir

    //#endregion
}
