package parcialfinal;



public class Libro {

    private String titulo;
    private String autor;
    private boolean reservado;
    private boolean disponible;

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.reservado = false;
        this.disponible = true;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public boolean isReservado() {
        return reservado;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void reservar() {
        if (disponible) {
            reservado = true;
            disponible = false;
        }
    }

    public void liberar() {
        if (reservado) {
            reservado = false;
            disponible = true;
        }
    }

    public void vender() {
        if (disponible) {
            disponible = false;
        }
    }

    public void devolver() {
        if (!disponible) {
            reservado = false;
            disponible = true;
        }
    }
}
