import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        metodos m = new metodos();
        
        LinkedList<Cliente> lcl = new LinkedList<>();
        LinkedList<Vehiculo> lv = new LinkedList<>();
        LinkedList<ContratoRenting> lc = new LinkedList<>();

        boolean continuar = true;

        while (continuar) {
            System.out.println("Bienvenido al renting de carros");
            System.out.println("Seleccione la opcion que desea realizar");
            System.out.println("1)Gestion de clientes");
            System.out.println("2)Gestion de vehiculos");
            System.out.println("3)Gestion de contratos de renting");
            System.out.println("4)Imprimir informe general");
            System.out.println("5)Salir del sistema");
            
            int opt = m.ValidarEntero(sc);

            switch (opt) {
                case 1:
                    System.out.println(m.SubMenu1(sc, m));
                    break;

                case 2:
                    System.out.println(m.SubMenu2(sc, m));
                    break;
                
                case 3:
                    System.out.println(m.SubMenu3(sc, m));
                    break;
            
                case 4:
                    
                    break;
                
                case 5:
                    System.out.println("Gracias por visitarnos");
                    continuar=false;
                    break;

                default:
                    System.out.println("Esa opcion no existe");
                    break;
            }
        }

    }
}