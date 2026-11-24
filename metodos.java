import java.util.LinkedList;
import java.util.Scanner;

public class metodos {
    
    public LinkedList<Cliente> RegistrarCliente (LinkedList<Cliente> lcl,Scanner sc, metodos m){
        boolean continuar = true;
    
        while (continuar) {
            Cliente cl = new Cliente();

            System.out.println("Ingrese la cedula del cliente");
            cl.setCedula(m.SinCaracteresEspeciales(sc));
            System.out.println("Ingrese el nombre del cliente");
            cl.setNombre(m.SoloLetras(sc));
            System.out.println("Ingrese el apellido del cliente");
            cl.setApellido(m.SoloLetras(sc));
            System.out.println("Ingrese el telefono del cliente");
            cl.setTelefono(m.SoloNumeros(sc));
            System.out.println("Ingrese la direccion del cliente");
            cl.setDireccion(sc.nextLine());
            System.out.println("Ingrese la licencia de conduccion del cliente");
            cl.setLicenciaConduccion(sc.next());
            lcl.add(cl);

            System.out.println("Desea agregar otro registro 1)Si 2)No");
            int opt = m.ValidarEntero(sc);
            sc.nextLine();
            
            if (opt == 2) {
                continuar=false;
            }

        }


        return lcl;
    }

     public int ValidarEntero(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Por favor tenga en cuenta que se le esta pidiendo un dato numerico");
            sc.next();
        }
        return sc.nextInt();
    }

    public String SinCaracteresEspeciales(Scanner sc) {
    String texto = sc.nextLine(); 

    if (texto.trim().isEmpty()) { 
        System.out.println("El campo no puede estar vacio, intente de nuevo:");
        return SinCaracteresEspeciales(sc); 
    }

    for (int i = 0; i < texto.length(); i++) {
        char c = texto.charAt(i);
        if (!Character.isLetterOrDigit(c)) {
            System.out.println("No se permiten caracteres especiales, intente de nuevo:");
            return SinCaracteresEspeciales(sc);
        }
    }

    return texto;
}

public String SoloLetras(Scanner sc) {
    String texto = sc.nextLine();

    if (texto.trim().isEmpty()) {
        System.out.println("El campo no puede estar vacio, intente de nuevo:");
        return SoloLetras(sc);
    }

    for (int i = 0; i < texto.length(); i++) {
        char c = texto.charAt(i);
        if (!Character.isLetter(c) && c != ' ') {
            System.out.println("Solo se permiten letras (sin numeros ni caracteres especiales), intente de nuevo:");
            return SoloLetras(sc);
        }
    }

    return texto;
}

public String SoloNumeros(Scanner sc) {
    String texto = sc.nextLine();

    if (texto.trim().isEmpty()) {
        System.out.println("El campo no puede estar vacio, intente de nuevo:");
        return SoloNumeros(sc);
    }

    for (int i = 0; i < texto.length(); i++) {
        char c = texto.charAt(i);
        if (!Character.isDigit(c)) {
            System.out.println("Solo se permiten numeros, intente de nuevo:");
            return SoloNumeros(sc);
        }
    }

    return texto;
}
public LinkedList<Vehiculo> RegistrarVehiculo(LinkedList<Vehiculo> lv, Scanner sc, metodos m) {
boolean continuar = true;
    
        while (continuar) {

            Vehiculo v = new Vehiculo();

            System.out.println("Ingrese la placa del vehiculo");
            v.setPlaca(m.SinCaracteresEspeciales(sc));
            System.out.println("Ingrese la marca del vehiculo");
            v.setMarca(m.SoloLetras(sc));
            System.out.println("Ingrese el modelo del veiculo");
            v.setModelo(m.ValidarEntero(sc));
            System.out.println("Ingrese el precio diario del vehiculo");
            v.setPrecioDiario(m.ValidarPositivo(sc));
            v.setEstado("Disponible");

            boolean seguir = true;

            while (seguir) {
            System.out.println("Ingrese el tipo de vehiculo 1)Carro sedan 2)Camioneta SUV");
            int tipovh = m.ValidarEntero(sc);
            v.setTipoVehiculo(tipovh);
            sc.nextLine();
                if (tipovh==1) {
                System.out.println("Ingrese el tipo de combustible del vehiculo");
                v.setTipoCombustible(m.SoloLetras(sc));
                System.out.println("Ingrese el tipo de transmision del vehiculo");
                v.setTransmision(m.SoloLetras(sc));
                seguir=false;
            }
            else if (tipovh==2) {
                System.out.println("Ingrese el tipo de traccion del vehiculo");
                v.setTraccion(m.SinCaracteresEspeciales(sc));
                System.out.println("Ingrese la capacidad del maletero en litros");
                v.setCapacidadMaletero(m.ValidarPositivo(sc));
                seguir=false;
            }
            else{
                System.out.println("Esa opcion no existe");
            }
            }
            lv.add(v);

            System.out.println("Desea agregar otro registro 1)Si 2)No");
            int opt = m.ValidarEntero(sc);
            sc.nextLine();
            
            if (opt == 2) {
                continuar=false;
            }
        }

        return lv;
}

public float ValidarPositivo(Scanner sc) {
    while (!sc.hasNextFloat()) {
        System.out.println("Por favor tenga en cuenta que se le esta pidiendo un dato numerico");
        sc.nextLine();
    }
    float valor = sc.nextFloat();
    sc.nextLine();

    if (valor <= 0) {
        System.out.println("Por favor ingrese un valor positivo");
        return ValidarPositivo(sc);
    }
    return valor;
}

}
