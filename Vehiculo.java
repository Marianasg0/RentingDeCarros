public class Vehiculo {
    
    private String Placa;
    private String Marca;
    private int Modelo;
    private float PrecioDiario;
    private String Estado;
    private int TipoVehiculo;
    private String TipoCombustible;
    private String Transmision;
    private String Traccion;
    private float CapacidadMaletero;

    public Vehiculo() {
    }

    public Vehiculo(String placa, String marca, int modelo, float precioDiario, String estado, int tipoVehiculo,
            String tipoCombustible, String transmision, String traccion, float capacidadMaletero) {
        Placa = placa;
        Marca = marca;
        Modelo = modelo;
        PrecioDiario = precioDiario;
        Estado = estado;
        TipoVehiculo = tipoVehiculo;
        TipoCombustible = tipoCombustible;
        Transmision = transmision;
        Traccion = traccion;
        CapacidadMaletero = capacidadMaletero;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String placa) {
        Placa = placa;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public int getModelo() {
        return Modelo;
    }

    public void setModelo(int modelo) {
        Modelo = modelo;
    }

    public float getPrecioDiario() {
        return PrecioDiario;
    }

    public void setPrecioDiario(float precioDiario) {
        PrecioDiario = precioDiario;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public int getTipoVehiculo() {
        return TipoVehiculo;
    }

    public void setTipoVehiculo(int tipoVehiculo) {
        TipoVehiculo = tipoVehiculo;
    }

    public String getTipoCombustible() {
        return TipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        TipoCombustible = tipoCombustible;
    }

    public String getTransmision() {
        return Transmision;
    }

    public void setTransmision(String transmision) {
        Transmision = transmision;
    }

    public String getTraccion() {
        return Traccion;
    }

    public void setTraccion(String traccion) {
        Traccion = traccion;
    }

    public float getCapacidadMaletero() {
        return CapacidadMaletero;
    }

    public void setCapacidadMaletero(float capacidadMaletero) {
        CapacidadMaletero = capacidadMaletero;
    }

    

    
}