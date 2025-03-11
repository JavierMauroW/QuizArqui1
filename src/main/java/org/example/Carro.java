package org.example;

public class Carro {

    private String marca;
    private String modelo;
    private  int anio;
    private double kilometraje;
    private  String estado;
    private String placa;

public Carro(){}

    public Carro(String marca, String modelo, int anio, double kilometraje, String estado, String placa) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.kilometraje = kilometraje;
        this.estado = estado;
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public double getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(double kilometraje) {
        this.kilometraje = kilometraje;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anio=" + anio +
                ", kilometraje=" + kilometraje +
                ", estado='" + estado + '\'' +
                ", placa='" + placa + '\'' +
                '}';
    }

    public void mostrarDetalle(){

    System.out.println("MARCA " + marca);
    System.out.println("MODELO " + modelo);
    System.out.println("AÑO " + anio);
    System.out.println("KILOMETRAKE " + kilometraje);
    System.out.println("ESTADO" +  estado);

}

public void actualizarKilometraje(double nuevoKilometraje ){
    this.kilometraje  =nuevoKilometraje;
}
    public boolean esAntiguo() {
        return (2025 - anio) > 15; //
    }

    public boolean necesitaMantenimiento() {
        return kilometraje > 100000;
    }

    public double calcularConsumoCombustible(double distancia, double consumoPorKm) {
        return distancia * consumoPorKm;
    }

    public double combustibleRestante(double capacidadTanque, double consumo) {
        return capacidadTanque - consumo;
    }

    public void mostrarDetalles() {
    }
}




