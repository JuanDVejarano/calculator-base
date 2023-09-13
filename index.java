import java.util.Scanner;
import java.util.Vector;

class index{
    // Los datos de los integrantes esta en el archivio README.md
    public static void main(String[] args) {

        //#region variables
        int option = 0;
        int base = 10;
        String catchValue1 = "";
        String catchValue2;
        Vector<Integer> value1 = new Vector<>();
        Vector<Integer> value2 = new Vector<>();
        boolean flagBase = true;
        boolean flagOption = true;
        String message;

        //instacias -> objetos
        ClassConvert instaciaCovert = new ClassConvert();
        ClassOperator instanciaOperar = new ClassOperator();
        Scanner catchConsol = new Scanner(System.in);
        //#endregion

        //#region opciones a operar
        while (flagOption) { // Ciclo para asegurar quie elija un valor correcto

            //opciones a operar
            System.out.println("Ingrese la operacion que decea realizar");
            System.out.println("1- Convertir de una base a decimal");
            System.out.println("2- Convertir de decimal a una base");
            System.out.println("3- Suma entre 2 numeros de la misma base");
            System.out.println("4- Resta entre 2 numeros de la misma base");
            System.out.println("5- Multiplicacion entre 2 numeros de la misma base");
            System.out.println("6- Division entre 2 numeros de la misma base");
            option = catchConsol.nextInt(); // captura de opcion de operacion
            if (option >= 1 && option <= 6) { // validacion para que seleccion una opcion entre 1 y 6
                flagOption = false;
            }
        }
        //#endregion

        //#region Mensajes segun la opcion 
        switch (option) {
            case 1:
                message = "Ingrese la base que quiere convertir a decimal";
                break;

            case 2:
                message = "Ingrese la base a la que quiere convertir el numero decimal";
                break;

            case 3:
                message = "Ingrese la base sobre la que quiere operar";
                break;

            default:
                message = "Opcion no valida";
                break;
        }
        //#endregion

        //#region ingreso de base
        while (flagBase) { // Ciclo para asegurar quie elija un valor correcto

            // Seleccionar Base a operar
            System.out.println(message);
            System.out.println("minimo base 2");
            System.out.println("maximo base 10");
            base = catchConsol.nextInt(); // captura valor de la base
            
            if (base >= 2 && base <= 10) { // validacion para seleccionar una base entre 2 y 10
                flagBase = false;
            }
        }
        //#endregion
        
        //#region operaciones
        // switch segun la operacion elegida
        switch (option) {
            case 1: // Caso de una base a decimal
                String sms = "Ingrese el valor";
                boolean flag = true;
                
                while (flag){
                    System.out.println(sms);
                    catchValue1 = catchConsol.next();
                    value1 = convertValueArray(catchValue1);
                    flag = validationBase(base, value1);
                    sms = "El valor no pertenece a la base Ingrese un valor valido";
                }
                
                // Manejo del objeto
                instaciaCovert.vector = value1; //intToVector(value1);
                instaciaCovert.base = base;
                System.out.println("El valor en decimal es " + instaciaCovert.numToDEcimal());
                
                break;
                
            case 2: // Caso de decimal a una base
                
                boolean flag2 = true;
                String sms2 = "Ingrese el valor";
                
                while (flag2){
                    System.out.println(sms2);
                    catchValue1 = catchConsol.next();
                    value1 = convertValueArray(catchValue1);
                    flag2 = validationBase(10, value1);
                    sms2 = "El valor no pertenece a la base Ingrese un valor valido";
                }

                instaciaCovert.value = Long.parseLong(catchValue1);
                instaciaCovert.base = base;
                String totalPrint = instaciaCovert.decimalToNum();
                System.out.println("El valor en base " + instaciaCovert.base + " es ");
                System.out.println(totalPrint);
                
                break;

            case 3: // Caso para sumar 2 numeros

                boolean flag31 = true;
                String sms31 = "Ingrese el primer valor";
                
                while (flag31){
                    System.out.println(sms31);
                    catchValue1 = catchConsol.next();
                    value1 = convertValueArray(catchValue1);
                    flag31 = validationBase(base, value1);
                    sms31 = "El valor no pertenece a la base Ingrese un valor valido";
                }

                flag31 = true;
                sms31 = "Ingrese el segundo valor";
                
                while (flag31){
                    System.out.println(sms31);
                    catchValue2 = catchConsol.next();
                    value2 = convertValueArray(catchValue2);
                    flag31 = validationBase(base, value2);
                    sms31 = "El valor no pertenece a la base Ingrese un valor valido";
                }

                instanciaOperar.num1 = value1;
                instanciaOperar.num2 = value2;
                instanciaOperar.base = base;
                Vector<Integer> vectorSuma = instanciaOperar.suma();
                String resultSuma = "";
                for (Integer value : vectorSuma) {
                    resultSuma = resultSuma + value;
                }
                System.out.println("El resultado de la suma es " + resultSuma);

                break;
        
            default:
                break;
        }

        //#endregion
    }

    //#region Metodos
    
    //Metodo para verificar si el numero paretenece a la base
    static boolean validationBase(int base, Vector<Integer> vectorParam) 
    {
        for (Integer ValueVector : vectorParam) {
            if (ValueVector >= base || ValueVector < 0){
                return true;
            }
        }
        return false;
    }

    //Metodo pasar de String a Vector
    static Vector<Integer> convertValueArray(String valueString){
        Vector<Integer> newVector = new Vector<Integer>();
        for (int i = 0; i < valueString.length(); i++) {
            String charVal = String.valueOf(valueString.charAt(i));
            newVector.add(Integer.parseInt(charVal));
        }
        return newVector;
    }

    // metodo pone cada valor en un arreglo
    /*static Vector<Integer> intToVector(int value){ // metodo para guardar valores del numero en un vector

        Vector<Integer> vector = new Vector<>();
        Vector<Integer> vectorAux = new Vector<>();
        
        while (value > 0) { // guardar digito por digito en el vector auxiliar
            vectorAux.add(value % 10);
            value = value / 10;
        }
        
        // se organizan los digitos del vector en orden
        for (int i = (vectorAux.size() -1); -1 < i; i--) {
            vector.add(vectorAux.get(i));
        }
        return vector;
    }*/
    //#endregion
}