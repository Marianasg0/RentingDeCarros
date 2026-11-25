import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class Exportar {

    public void exportarInformeGeneral(LinkedList<Cliente> lcl, LinkedList<Vehiculo> lv, LinkedList<ContratoRenting> lc) {
        try (FileWriter fw = new FileWriter("InformeGeneral.txt")) {

            fw.write("INFORME GENERAL DE RENTING" + "\n");

            fw.write("CLIENTES:"+ "\n");
            if (lcl.isEmpty()) {
                fw.write("No hay clientes registrados.\n");
            } else {
                for (Cliente cl : lcl) {
                    fw.write("Cedula: " + cl.getCedula() + "\n");
                    fw.write("Nombre: " + cl.getNombre() + "\n");
                    fw.write("Apellido: " + cl.getApellido() + "\n");
                    fw.write("Telefono: " + cl.getTelefono() + "\n");
                    fw.write("Direccion: " + cl.getDireccion() + "\n");
                    fw.write("Licencia de conduccion: " + cl.getLicenciaConduccion() + "\n");
                    fw.write("------------------------------------------------------\n");
                }
            }
            fw.write("\n");

            fw.write("VEHICULOS: "+ "\n");
            if (lv.isEmpty()) {
                fw.write("No hay vehiculos registrados.\n");
            } else {
                for (Vehiculo v : lv) {
                    fw.write("Placa: " + v.getPlaca() + "\n");
                    fw.write("Marca: " + v.getMarca() + "\n");
                    fw.write("Modelo: " + v.getModelo() + "\n");
                    fw.write("Precio diario: " + v.getPrecioDiario() + "\n");
                    fw.write("Estado: " + v.getEstado() + "\n");

                    if (v.getTipoVehiculo() == 1) {
                        fw.write("Tipo de vehiculo: Carro sedan\n");
                        fw.write("Tipo de combustible: " + v.getTipoCombustible() + "\n");
                        fw.write("Transmision: " + v.getTransmision() + "\n");
                    } else if (v.getTipoVehiculo() == 2) {
                        fw.write("Tipo de vehiculo: Camioneta SUV\n");
                        fw.write("Traccion: " + v.getTraccion() + "\n");
                        fw.write("Capacidad maletero: " + v.getCapacidadMaletero() + " L\n");
                    }
                    fw.write("------------------------------------------------------\n");
                }
            }
            fw.write("\n");

            float totalIngresos = 0;

            int hayActivos = 0;

            fw.write("CONTRATOS RENTING: " + "\n");
            fw.write("CONTRATOS ACTIVOS: "+ "\n");
            for (ContratoRenting ct : lc) {
                if (ct.getEstado() == 1) {
                    hayActivos = 1;
                    fw.write("ID Contrato: " + ct.getIdContrato() + "\n");
                    fw.write("Cedula Cliente: " + ct.getCedulaCliente() + "\n");
                    fw.write("Placa Vehiculo: " + ct.getPlacaVehiculo() + "\n");
                    fw.write("Fecha Inicio: " + ct.getFechaInicio() + "\n");
                    fw.write("Fecha Fin: " + ct.getFechaFin() + "\n");
                    fw.write("Total Dias: " + ct.getTotalDias() + "\n");
                    fw.write("Valor Total: " + ct.getValorTotal() + "\n");
                    fw.write("Estado: Activo\n");
                    fw.write("------------------------------------------------------\n");
                    totalIngresos += ct.getValorTotal();
                }
            }
            if (hayActivos == 0) {
                fw.write("No hay contratos activos.\n");
            }
            fw.write("\n");

            int hayFinalizados = 0;
            fw.write("CONTRATOS FINALIZADOS: " + "\n");
            for (ContratoRenting ct : lc) {
                if (ct.getEstado() == 0) {
                    hayFinalizados = 1;
                    fw.write("ID Contrato: " + ct.getIdContrato() + "\n");
                    fw.write("Cedula Cliente: " + ct.getCedulaCliente() + "\n");
                    fw.write("Placa Vehiculo: " + ct.getPlacaVehiculo() + "\n");
                    fw.write("Fecha Inicio: " + ct.getFechaInicio() + "\n");
                    fw.write("Fecha Fin: " + ct.getFechaFin() + "\n");
                    fw.write("Total Dias: " + ct.getTotalDias() + "\n");
                    fw.write("Valor Total: " + ct.getValorTotal() + "\n");
                    fw.write("Estado: Finalizado\n");
                    fw.write("------------------------------------------------------\n");
                    totalIngresos += ct.getValorTotal();
                }
            }
            if (hayFinalizados == 0) {
                fw.write("No hay contratos finalizados.\n");
            }
            fw.write("\n");

            fw.write("TOTAL DE INGRESOS POR RENTING: " + totalIngresos + "\n");

            System.out.println("Informe general exportado correctamente");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}