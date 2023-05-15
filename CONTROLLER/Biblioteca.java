package parcialfinal;


import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<Libro> libros;

    public Biblioteca() {

        libros = new ArrayList<>();

    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);

    }

    public List<Libro> buscarPorTitulo(String titulo) {

        List<Libro> resultados = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                resultados.add(libro);
            }
        }
        return resultados;
    }

    public List<Libro> buscarPorAutor(String autor) {

        List<Libro> resultados = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getAutor().equalsIgnoreCase(autor)) {
                resultados.add(libro);

            }
        }
        return resultados;
    }

    public boolean reservarLibro(Libro libro) {

        if (libro.isDisponible()) {
            libro.reservar();
            return true;
        }
        return false;
    }

    public boolean liberarLibro(Libro libro) {

        if (libro.isReservado()) {
            libro.liberar();
            return true;
        }
        return false;
    }

    public boolean venderLibro(Libro libro) {

        if (libro.isDisponible()) {
            libro.vender();
            return true;
        }
        return false;
    }

    public boolean devolverLibro(Libro libro) {

        if (!libro.isDisponible()) {
            libro.devolver();
            return true;
        }
        return false;
    }

    public void eliminarLibro(Libro libro) {
        libros.remove(libro);

    }

    public List<Libro> obtenerLibrosDisponibles() {

        List<Libro> disponibles = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.isDisponible()) {
                disponibles.add(libro);
            }
        }
        return disponibles;
    }

    public List<Libro> obtenerLibrosReservados() {

        List<Libro> reservados = new ArrayList<>();

        for (Libro libro : libros) {
            if (libro.isReservado()) {
                reservados.add(libro);
            }
        }
        return reservados;
    }

    public List obtenerLibrosVendidos() {

        List vendidos = new ArrayList<>();
        for (Libro libro : libros) {
            if (!libro.isDisponible() && !libro.isReservado()) {
                vendidos.add(libro);
            }
        }
        return vendidos;
    }

    public void generarInformeVentas() {

        System.out.println("Informe de ventas:");
        System.out.println("-------------------");

        List<Libro> vendidos = obtenerLibrosVendidos();

        if (vendidos.isEmpty()) {
            System.out.println("No hay libros vendidos.");
        } else {

            for (Libro libro : vendidos) {
                System.out.println("Título: " + libro.getTitulo());
                System.out.println("Autor: " + libro.getAutor());
                System.out.println("------------------------");

            }
        }
    }
}
