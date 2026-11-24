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

public LinkedList<ContratoRenting> registrarContrato(LinkedList<ContratoRenting> lc,LinkedList<Vehiculo> lv,LinkedList<Cliente> lcl,Scanner sc,metodos m){
        boolean continuar = true;

        while (continuar) {
            ContratoRenting c = new ContratoRenting();
            System.out.println("Ingrese la cedula del cliente");
            String cedula = m.SoloNumeros(sc);

            int encontrado1=0;
            for (Cliente cl : lcl) {
                if (cl.getCedula().equalsIgnoreCase(cedula)) {
                    encontrado1=1;
                    for (ContratoRenting ct : lc) {
                        if (ct.getCedulaCliente().equalsIgnoreCase(cedula) && ct.getEstado()==1) {
                        System.out.println("El cliente ya tiene un vehiculo alquilado");
                        return lc;
                        }
                    }
                }
            }

            if (encontrado1==0) {
                System.out.println("Este cliente no fue encontrado");
                return lc;
            }

            c.setCedulaCliente(cedula);

            System.out.println("Ingrese el ID del contrato");
            String IdContrato = sc.nextLine();

            for (ContratoRenting ct : lc) {
                if (ct.getIdContrato().equalsIgnoreCase(IdContrato)) {
                    System.out.println("Este ID de contrato ya existe");
                    return lc;
                }
            }


            c.setIdContrato(IdContrato);

            System.out.println("Ingrese la placa del vehiculo");
            String placa = m.SinCaracteresEspeciales(sc);

            int encontrado = 0;
            for (Vehiculo v : lv) {
                if(v.getPlaca().equalsIgnoreCase(placa)){
                    encontrado=1;
                    if(v.getEstado().equalsIgnoreCase("alquilado")){
                        System.out.println("El vehiculo se encuentra alquilado");
                        return lc;
                    }
                    else{
                        v.setEstado("alquilado");
                    }
                }
            }
            if (encontrado==0) {
                System.out.println("Esta placa no fue encontrada");
                return lc;
            }

            c.setPlacaVehiculo(placa);
            System.out.println("Ingrese la fecha de inicio del alquiler");
            c.setFechaInicio(sc.nextLine());
            System.out.println("Ingrese la fecha de finalizacion del alquiler");
            c.setFechaFin(sc.nextLine());
            System.out.println("Ingrese el total de dias de alquiler");
            c.setTotalDias(m.ValidarEntero(sc));
            System.out.println("Ingrese el valor total del alquiler");
            c.setValorTotal(m.ValidarPositivo(sc));
            c.setEstado(1);
            lc.add(c);

            System.out.println("Desea agregar otro registro 1)Si 2)No");
            int opt = m.ValidarEntero(sc);

            if (opt == 2) {
                continuar=false;
            }

        }

        return lc;
    }

    public String buscarContrato (LinkedList<ContratoRenting> lc,Scanner sc){
        System.out.println("Ingrese el ID del contrato que desea consultar");
        String ID = sc.nextLine();

        int encontrado=0;
        String mensaje="";

        for (ContratoRenting ct : lc) {
            if (ct.getIdContrato().equalsIgnoreCase(ID)) {
                encontrado=1;
                mensaje= "Contrato encontrado";
                System.out.println("ID Contrato: " +ct.getIdContrato() );
                System.out.println("Cedula cliente: " + ct.getCedulaCliente());
                System.out.println("Placa vehiculo: " + ct.getPlacaVehiculo());
                System.out.println("Fecha inicio: " + ct.getFechaInicio());
                System.out.println("Fecha finalizacion: " + ct.getFechaFin());
                System.out.println("Total dias: " + ct.getTotalDias());
                System.out.println("Valor total: " + ct.getValorTotal());
                if (ct.getEstado()==1) {
                    System.out.println("Estado: Activo");
                }
                else{
                    System.out.println("Estado: Finalizado");
                }
            }
        }

        if (encontrado==0) {
            mensaje = "Contrato no encontrado";
        }

        return mensaje;

    }

    
    public LinkedList<ContratoRenting> modificarContrato(LinkedList<ContratoRenting> lc,Scanner sc,metodos m){
        System.out.println("Ingrese el ID del contrato que desea modificar");
        String ID = sc.nextLine();
        int encontrado=0;
        for (ContratoRenting ct : lc) {
            if (ct.getIdContrato().equalsIgnoreCase(ID)) {
                encontrado=1;
                if (ct.getEstado()==0) {
                    System.out.println("Este contrato ya fue finalizado");
                }
                else{
                System.out.println("Ingrese la fecha de inicio del alquiler");
                ct.setFechaInicio(sc.nextLine());
                System.out.println("Ingrese la fecha de finalizacion del alquiler");
                ct.setFechaFin(sc.nextLine());
                System.out.println("Ingrese el total de dias de alquiler");
                ct.setTotalDias(m.ValidarEntero(sc));
                System.out.println("Ingrese el valor total del alquiler");
                ct.setValorTotal(m.ValidarPositivo(sc));
                System.out.println("Contrato modificado exitosamente");
                }
            }
        }

        if (encontrado==0) {
            System.out.println("Contrato no encontrado");
        }

        return lc;
    }
    


    public LinkedList<ContratoRenting> finalizarContrato(LinkedList<ContratoRenting> lc,LinkedList<Vehiculo> lv,Scanner sc){
        System.out.println("Ingrese el ID del contrato que desea finalizar");
        String ID = sc.nextLine();
        int encontrado=0;

        for (ContratoRenting ct : lc) {
            if (ct.getIdContrato().equalsIgnoreCase(ID)) {
                encontrado=1;

                if(ct.getEstado()!=0){
                    ct.setEstado(0);
                    for (Vehiculo v : lv) {
                        if (v.getPlaca().equalsIgnoreCase(ct.getPlacaVehiculo())) {
                            v.setEstado("disponible");
                        }
                    }
                    System.out.println("Contrato finalizado exitosamente");
                }
                else{
                  System.out.println("Este contrato esta finalizado");  
                }
            }
        }

        if (encontrado==0) {
            System.out.println("Contrato no encontrado");
        }

        return lc;
    }
    public String SubMenu1(Scanner sc,metodos m){
    String mensaje = "";
    boolean seguir = true;
    while (seguir) {
        System.out.println("SubMenu: Gestion de clientes");
        System.out.println("Seleccione la opcion que desea realizar");
        System.out.println("1)Registrar cliente");
        System.out.println("2)Modificar cliente");
        System.out.println("3)Eliminar cliente");
        System.out.println("4)Buscar cliente");
        System.out.println("5)Volver al menu principal");
        
        int opt = m.ValidarEntero(sc);

        switch (opt) {
            case 1:
                mensaje="Registro completado";
                System.out.println(mensaje);
                break;

            case 2:
                mensaje="Modificacion completada";
                System.out.println(mensaje);
                break;

            case 3:
                mensaje="Eliminacion completada";
                System.out.println(mensaje);
                break;

            case 4:
                mensaje="Busqueda completada";
                System.out.println(mensaje);
                break;

            case 5:
                mensaje="Volviendo al menu principal";
                seguir=false;
                break;
        
            default:
                System.out.println("Esa opcion no existe");
                break;
        }
    }
    return mensaje;
}

public String SubMenu2(Scanner sc,metodos m){
    String mensaje = "";
    boolean seguir = true;
    while (seguir) {
        System.out.println("SubMenu: Gestion de vehiculos");
        System.out.println("Seleccione la opcion que desea realizar");
        System.out.println("1)Registrar vehiculo");
        System.out.println("2)Modificar vehiculo");
        System.out.println("3)Eliminar vehiculo");
        System.out.println("4)Buscar vehiculo");
        System.out.println("5)Volver al menu principal");
        
        int opt = m.ValidarEntero(sc);

        switch (opt) {
            case 1:
                mensaje="Registro completado";
                System.out.println(mensaje);
                break;

            case 2:
                mensaje="Modificacion completada";
                System.out.println(mensaje);
                break;

            case 3:
                mensaje="Eliminacion completada";
                System.out.println(mensaje);
                break;

            case 4:
                mensaje="Busqueda completada";
                System.out.println(mensaje);
                break;

            case 5:
                mensaje="Volviendo al menu principal";
                seguir=false;
                break;
        
            default:
                System.out.println("Esa opcion no existe");
                break;
        }
    }
    return mensaje;
}

public String SubMenu3(Scanner sc,metodos m){
    String mensaje = "";
    boolean seguir = true;
    while (seguir) {
        System.out.println("SubMenu: Gestion de contratos de renting");
        System.out.println("Seleccione la opcion que desea realizar");
        System.out.println("1)Registrar nuevo contrato");
        System.out.println("2)Modificar contrato");
        System.out.println("3)Finalizar contrato");
        System.out.println("4)Buscar contrato");
        System.out.println("5)Volver al menu principal");
        
        int opt = m.ValidarEntero(sc);

        switch (opt) {
            case 1:
                mensaje="Registro completado";
                System.out.println(mensaje);
                break;

            case 2:
                mensaje="Modificacion completada";
                System.out.println(mensaje);
                break;

            case 3:
                mensaje="Finalizacion completada";
                System.out.println(mensaje);
                break;

            case 4:
                mensaje="Busqueda completada";
                System.out.println(mensaje);
                break;

            case 5:
                mensaje="Volviendo al menu principal";
                seguir=false;
                break;
        
            default:
                System.out.println("Esa opcion no existe");
                break;
        }
    }
    return mensaje;
}

}
