import java.util.Scanner;
import java.util.Vector;

class index{
    public static void main(String[] args) {
        int option = 0;
        int base = 10;
        int value1 = 0;
        int value2 = 0;
        boolean flagBase = true;
        boolean flagOption = true;
        String message;

        //instacias -> objetos
        ClassConvert instaciaCovert = new ClassConvert();
        Scanner catchConsol = new Scanner(System.in);

        while (flagOption) { // Ciclo para asegurar quie elija un valor correcto
            
            System.out.println(3 * 10);

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

        // Mensajes segun la opcion
        switch (option) {
            case 1:
                message = "Ingrese la base que quiere convertir a decimal";
                break;

            case 2:
                message = "Ingrese la base a la que quiere convertir el numero decimal";
                break;

            default:
                message = "Opcion no valida";
                break;
        }

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
        
        
        // switch segun la operacion elegida
        switch (option) {
            case 1:
                String sms = "Ingrese el valor";
                boolean flag = true;
                
                while (flag){
                    System.out.println(sms);
                    value1 = catchConsol.nextInt();
                    flag = validationBase(base, value1);
                    sms = "El valor no pertenece a la base Ingrese un valor valido";
                }
                
                // Manejo del objeto
                instaciaCovert.vector = intToVector(value1);
                instaciaCovert.base = base;
                System.out.println("El valor en decimal es " + instaciaCovert.numToDEcimal());
                
                break;
                
                case 2:
                
                boolean flag2 = true;
                String sms2 = "Ingrese el valor";
                
                while (flag2){
                    System.out.println(sms2);
                    value1 = catchConsol.nextInt();
                    flag2 = validationBase(10, value1);
                    sms2 = "El valor no pertenece a la base Ingrese un valor valido";
                }

                instaciaCovert.value = value1;
                instaciaCovert.base = base;
                System.out.println("El valor en base " + instaciaCovert.base + " es " + instaciaCovert.decimalToNum());
                
                break;
        
            default:
                break;
        }

    }

    //Metodo para verificar si el numero paretenece a la base
    static boolean validationBase(int base, int value) 
    {
        Vector<Integer> vector = new Vector<>();
        vector = intToVector(value);
        for (Integer ValueVector : vector) {
            if (ValueVector >= (base - 1) || ValueVector < 0){
                return true;
            }
        }
        return false;
    }

    // metodo pone cada valor en un arreglo
    static Vector<Integer> intToVector(int value){ // metodo para guardar valores del numero en un vector

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
    }
}