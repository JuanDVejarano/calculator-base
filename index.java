import java.util.Scanner;
import java.util.Vector;

class index{
    // Los datos de los integrantes esta en el archivio README.md
    public static void main(String[] args) {

        //#region variables
        int option = 0;
        Integer base = 10;
        String catchValue1 = "";
        String catchValue2;
        Vector<Integer> value1 = new Vector<>();
        Vector<Integer> value2 = new Vector<>();
        boolean flagBase = true;
        boolean flagOption = true;
        String message;

        //instacias -> objetos
        ClassConvert instaciaCovert = new ClassConvert();
        //ClassOperator instanciaOperar = new ClassOperator();
        Scanner catchConsol = new Scanner(System.in);
        //#endregion

        //#region opciones a operar
        while (flagOption) { // Ciclo para asegurar quie elija un valor correcto

            //opciones a operar
            System.out.println("Ingrese la operacion que desea realizar");
            System.out.println("1- Convertir de una base a decimal");
            System.out.println("2- Convertir de decimal a una base");
            System.out.println("3- Suma entre 2 numeros de la misma base");
            System.out.println("4- Resta entre 2 numeros de la misma base (No permite numeros mayores en el sustranedo que en el minuendo)");
            System.out.println("5- Multiplicacion entre 2 numeros de la misma base");
            System.out.println("6- Division entre 2 numeros de la misma base (No permite numeros mayores en el divisor que en el dividendo)");
            String validacionOption = catchConsol.next();
            if(validacionLetras(validacionOption)){
                option = Integer.parseInt(validacionOption);
                if (option >= 1 && option <= 6) { // validacion para que seleccion una opcion entre 1 y 6
                flagOption = false;
                }
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
                message = "Ingrese la base sobre la que quiere Sumar";
                break;

            case 4:
                message = "Ingrese la base sobre la que quiere restar";
                break;
            
            case 5:
                message = "Ingrese la base sobre la que quiere multiplicar";
                break;

            case 6:
                message = "Ingrese la base sobre la que quiere dividir";
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
            String baseValidation = String.valueOf(base);
            baseValidation = catchConsol.next(); // captura valor de la base
            if(validacionLetras(baseValidation)){
                base = Integer.parseInt(baseValidation);
                if (base >= 2 && base <= 10) { // validacion para seleccionar una base entre 2 y 10
                    flagBase = false;
                }
                else{
                    message = "Digite una base entre 2 y 10";
                }
            }
            else{
                message = "Digite la base no debe tener letras";
            }
            
            
        }
        //#endregion
        
        //#region operaciones
        // switch segun la operacion elegida
        switch (option) {
            case 1: // Caso de una base a decimal
                String sms = "Ingrese el valor a convertir";
                boolean flag = true;
                
                while (flag){
                    System.out.println(sms);
                    catchValue1 = catchConsol.next();
                    if(validacionLetras(catchValue1)){
                        value1 = convertValueArray(catchValue1);
                        flag = validationBase(base, value1);
                        sms = "El valor no pertenece a la base Ingrese el valor a convertir";
                    } else sms = "El valor no pertenece a la base (contiene letras) Ingrese de nuevo el valor a convertir";
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
                    if(validacionLetras(catchValue1)){
                        value1 = convertValueArray(catchValue1);
                        flag2 = validationBase(10, value1);
                        sms2 = "El valor no pertenece a la base Ingrese el valor a convertir";
                    } else sms2 = "El valor no pertenece a la base (contiene letras) Ingrese de nuevo el valor a convertir";
                }

                instaciaCovert.value = Long.parseLong(catchValue1);
                instaciaCovert.base = base;
                String totalPrint = instaciaCovert.decimalToNum();
                System.out.println("El valor en base " + instaciaCovert.base + " es ");
                System.out.println(totalPrint);
                
                break;

            case 3: // Caso para sumar 2 numeros

                boolean flag31 = true;
                String sms31 = "Ingrese el primer sumando";
                
                while (flag31){
                    System.out.println(sms31);
                    catchValue1 = catchConsol.next();
                    if(validacionLetras(catchValue1)){
                        value1 = convertValueArray(catchValue1);
                        flag31 = validationBase(base, value1);
                        sms31 = "El valor no pertenece a la base Ingrese un valor valido";
                    } else sms31 = "El valor no pertenece a la base (contiene letras) Ingrese un valor valido";
                }

                flag31 = true;
                sms31 = "Ingrese el segundo sumando";
                
                while (flag31){
                    System.out.println(sms31);
                    catchValue2 = catchConsol.next();
                    if(validacionLetras(catchValue2)){
                        value2 = convertValueArray(catchValue2);
                        flag31 = validationBase(base, value2);
                        sms31 = "El valor no pertenece a la base Ingrese un valor valido";
                    } else sms31 = "El valor no pertenece a la base (contiene letras) Ingrese un valor valido";
                }

                ClassOperator instanciaSuma = new ClassOperator(value1, value2, base);
                Vector<Integer> vectorSuma = instanciaSuma.inputSuma();
                String resultSuma = "";
                for (Integer value : vectorSuma) {
                    resultSuma = resultSuma + value;
                }
                System.out.println("El resultado de la suma es " + resultSuma);

                break;

            case 4:// Caso para restar 2 numeros

                Integer flagMinuendo = 0;
                Integer flagsutraendo = 1;
                while(flagsutraendo > flagMinuendo){

                    boolean flag41 = true;
                    String sms41 = "Ingrese el minuendo";
                    
                    while (flag41){
                        System.out.println(sms41);
                        catchValue1 = catchConsol.next();
                        if(validacionLetras(catchValue1)){
                            value1 = convertValueArray(catchValue1);
                            flag41 = validationBase(base, value1);
                            sms41 = "El valor no pertenece a la base Ingrese de nuevo el minuendo";
                        } else sms41 = "El valor no pertenece a la base (contiene letras) Ingrese de nuevo el minuendo";
                        
                    }

                    Long valueFlag1;
                    instaciaCovert.vector = value1; //intToVector(value1);
                    instaciaCovert.base = base;
                    valueFlag1 = instaciaCovert.numToDEcimal();
                    flagMinuendo = valueFlag1.intValue();
    
                    flag41 = true;
                    sms41 = "Ingrese el sustraendo recuerde debe ser menor al minuendo o pedira de nuevo los datos";
                    
                    while (flag41){
                        System.out.println(sms41);
                        catchValue2 = catchConsol.next();
                        if(validacionLetras(catchValue2)){
                            value2 = convertValueArray(catchValue2);
                            flag41 = validationBase(base, value2);
                            sms41 = "El valor no pertenece a la base Ingrese de nuevo el sustraendo";
                        } else sms41 = "El valor no pertenece a la base (contiene letras) Ingrese de nuevo el sustraendo";
                    }

                    Long valueFlag2;
                    instaciaCovert.vector = value2; //intToVector(value1);
                    instaciaCovert.base = base;
                    valueFlag2 = instaciaCovert.numToDEcimal();
                    flagsutraendo = valueFlag2.intValue();
                }

                ClassOperator instanciaResta = new ClassOperator(value1, value2, base);
                Vector<Integer> vectorResta = instanciaResta.inputRestar();

                String resultResta = "";
                for (Integer value : vectorResta) {
                    resultResta = resultResta + value;
                }
                System.out.println("El resultado de la suma es " + resultResta);

                break;

            case 5:// Caso para multiplicar 2 numeros
                boolean flag51 = true;
                String sms51 = "Ingrese el multiplicando";
                
                while (flag51){
                    System.out.println(sms51);
                    catchValue1 = catchConsol.next();
                    if(validacionLetras(catchValue1)){
                        value1 = convertValueArray(catchValue1);
                        flag51 = validationBase(base, value1);
                        sms51 = "El valor no pertenece a la base Ingrese de nuevo el multiplicando";
                    } else sms51 = "El valor no pertenece a la base (contiene letras) Ingrese de nuevo el multiplicando";
                }

                flag51 = true;
                sms51 = "Ingrese el multiplicador";
                
                while (flag51){
                    System.out.println(sms51);
                    catchValue2 = catchConsol.next();
                    if(validacionLetras(catchValue2)){
                        value2 = convertValueArray(catchValue2);
                        flag51 = validationBase(base, value2);
                        sms51 = "El valor no pertenece a la base Ingrese de nuevo el multiplicador";
                    } else sms51 = "El valor no pertenece a la base (contiene letras) Ingrese de nuevo el multiplicador";
                }

                ClassOperator instanciaProducto = new ClassOperator(value1, value2, base);
                Vector<Integer> vectorProducto = instanciaProducto.inputMultiplicacion();

                String resultProducto = "";
                for (Integer value : vectorProducto) {
                    resultProducto = resultProducto + value;
                }
                System.out.println("El resultado de la multiplicacion es " + resultProducto);


                break;
            
            case 6:// Caso para dividir 2 numeros

                Integer flagDividendo = 0;
                Integer flagDivisor = 1;
                while(flagDivisor > flagDividendo){

                    boolean flag61 = true;
                    String sms61 = "Ingrese el Dividendo";
                    
                    while (flag61){
                        System.out.println(sms61);
                        catchValue1 = catchConsol.next();
                        if(validacionLetras(catchValue1)){
                            value1 = convertValueArray(catchValue1);
                            flag61 = validationBase(base, value1);
                            sms61 = "El valor no pertenece a la base Ingrese de nuevo el Dividendo";
                        } else sms61 = "El valor no pertenece a la base (contiene letras) Ingrese de nuevo el Dividendo";
                    }

                    Long valueFlag3;
                    instaciaCovert.vector = value1; //intToVector(value1);
                    instaciaCovert.base = base;
                    valueFlag3 = instaciaCovert.numToDEcimal();
                    flagDividendo = valueFlag3.intValue();
    
                    flag61 = true;
                    sms61 = "Ingrese el Divisor  recuerde debe ser menor al Dividendo o pedira de nuevo los datos";
                    
                    while (flag61){
                        System.out.println(sms61);
                        catchValue2 = catchConsol.next();
                        if(validacionLetras(catchValue2)){
                            value2 = convertValueArray(catchValue2);
                            flag61 = validationBase(base, value2);
                            sms61 = "El valor no pertenece a la base Ingrese de nuevo el Divisor";
                        } else sms61 = "El valor no pertenece a la base (contiene letras) Ingrese de nuevo el Divisor";
                    }

                    Long valueFlag4;
                    instaciaCovert.vector = value2; //intToVector(value1);
                    instaciaCovert.base = base;
                    valueFlag4 = instaciaCovert.numToDEcimal();
                    flagDivisor = valueFlag4.intValue();

                }

                ClassOperator instanciaDivision = new ClassOperator(value1, value2, base);
                Vector<Integer> vectorDivicion = instanciaDivision.inputDividir();

                instaciaCovert.base = base;
                instaciaCovert.value = Long.valueOf(vectorDivicion.get(0));
                String sDividendo = instaciaCovert.decimalToNum();
                instaciaCovert.value = Long.valueOf(vectorDivicion.get(1));
                String sResto = instaciaCovert.decimalToNum();
                
                System.out.println("El resultado de la division en base " + base + " es " + sDividendo + " con residuo " + sResto);
                System.out.println("El resultado de la division en decimal es " + vectorDivicion.get(0) + " con residuo " + vectorDivicion.get(1));

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

    //Validacion de letras
    static boolean validacionLetras(String valueString){
        for (int i = 0; i < valueString.length(); i++) {
           if(valueString.charAt(i) == '0' || valueString.charAt(i) == '1' || valueString.charAt(i) == '2' || valueString.charAt(i) == '3'  || valueString.charAt(i) == '4' || valueString.charAt(i) == '5' || valueString.charAt(i) == '6' || valueString.charAt(i) == '7' || valueString.charAt(i) == '8' || valueString.charAt(i) == '9');
           else return false;
        }
        return true;
    }
    //#endregion
}