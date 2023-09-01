package com.espe.alquiler.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vehiculos")
public class Auto {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "Id_Vehiculos")
        private int idVehiculos;

        @Column(name = "Marca")
        private String marca;


        @Column(name = "Modelo")
        private String modelo;


        @Column(name = "Anio")
        private int anio;

       /* @NotNull(message = "El Tipo es requerido")
        @NotEmpty(message = "El Tipo es requerido")*/
        @Column(name = "Tipo")
        private String tipo;

       /* @Column(name = "foto")
        private String foto;*/

        @Column(name = "placa")
        private String placa;


        private Boolean disponibilidad;

        public int getIdVehiculos() {
                return idVehiculos;
        }

        public void setIdVehiculos(int idVehiculos) {
                this.idVehiculos = idVehiculos;
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

        public String getTipo() {
                return tipo;
        }

        public void setTipo(String tipo) {
                this.tipo = tipo;
        }

        /*public String getFoto() {
                return foto;
        }

        public void setFoto(String foto) {
                this.foto = foto;
        }*/

        public String getPlaca() {
                return placa;
        }

        public void setPlaca(String placa) {
                this.placa = placa;
        }

        public Boolean getDisponibilidad() {
                return disponibilidad;
        }

        public void setDisponibilidad(Boolean disponibilidad) {
                this.disponibilidad = disponibilidad;
        }

        @Override
        public String toString() {
                return "Auto{" +
                        "idVehiculos=" + idVehiculos +
                        ", marca='" + marca + '\'' +
                        ", modelo='" + modelo + '\'' +
                        ", anio=" + anio +
                        ", tipo='" + tipo + '\'' +
                       /* ", foto='" + foto + '\'' +*/
                        ", placa='" + placa + '\'' +
                        ", disponibilidad=" + disponibilidad +
                        '}';
        }
}
