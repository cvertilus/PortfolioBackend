package com.Portfolio.Porfolio_Backend.Security.DTO;

public class ErrorMensaje {

        private String mensaje;

        public ErrorMensaje(String mensaje) {
            this.mensaje = mensaje;
        }

        public String getMensaje() {
            return mensaje;
        }

        public void setMensaje(String mensaje) {
            this.mensaje = mensaje;
        }

}
