package parcialfinal;


import parcialfinal.MODEL.Libro;
import java.util.List;
import java.util.Scanner;
import parcialfinal.parcialfinal.Biblioteca;

public class LibreriaApp {

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();

        // Agregar algunos libros de ejemplo
        biblioteca.agregarLibro(new Libro("El código Da Vinci", "Dan Brown"));
        biblioteca.agregarLibro(new Libro("Harry Potter y la piedra filosofal", "J.K. Rowling"));
        biblioteca.agregarLibro(new Libro("Cien años de soledad", "Gabriel García Márquez"));

        Scanner scanner = new Scanner(System.in);

        // Menú de opciones
        int opcion = 0;

        while (opcion != 9) {

            System.out.println("----- Menú -----");
            System.out.println("1. Buscar libro por título");
            System.out.println("2. Reservar libro");
            System.out.println("3. Actualizar disponibilidad de libro (administrador)");
            System.out.println("4. Comprar libro");
            System.out.println("5. Agregar nuevo libro (administrador)");
            System.out.println("6. Devolver libro");
            System.out.println("7. Eliminar libro (administrador)");
            System.out.println("8. Buscar libro por autor");
            System.out.println("9. Salir");
            System.out.println("-----------------");
            System.out.print("Ingrese una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {

                case 1:

                    System.out.print("Ingrese el título del libro a buscar: ");
                    scanner.nextLine();
                    String tituloBusqueda = scanner.nextLine();
                    List<Libro> resultadosTitulo = biblioteca.buscarPorTitulo(tituloBusqueda);
                    mostrarResultados(resultadosTitulo);
                    break;

                case 2:

                    System.out.print("Ingrese el título del libro a reservar: ");
                    scanner.nextLine();
                    String tituloReserva = scanner.nextLine();
                    List<Libro> resultadosReserva = biblioteca.buscarPorTitulo(tituloReserva);
                    mostrarResultados(resultadosReserva);
                    
                    if (!resultadosReserva.isEmpty()) {

                        System.out.print("Ingrese el número de libro a reservar: ");
                        int opcionReserva = scanner.nextInt();
                        
                        if (opcionReserva > 0 && opcionReserva <= resultadosReserva.size()) {
                            Libro libroReservado = resultadosReserva.get(opcionReserva - 1);

                            if (biblioteca.reservarLibro(libroReservado)) {
                                System.out.println("El libro ha sido reservado.");

                            } else {

                                System.out.println("El libro ya está reservado.");
                            }

                        } else {

                            System.out.println("Opción inválida.");
                        }

                    } else {
                        
                        System.out.println("No se encontraron libros con ese título.");
                    }
                    break;

                case 3:

                    // Aquí se implementaría la lógica para actualizar la disponibilidad de un libro (solo para el administrador)
                    break;

                case 4:

                    // Aquí se implementaría la lógica para comprar un libro
                    break;

                case 5:

                    // Aquí se implementaría la lógica para agregar un nuevo libro al sistema (solo para el administrador)
                    break;

                case 6:

                    // Aquí se implementaría la lógica para devolver un libro
                    break;

                case 7:

                    // Aquí se implementaría la lógica para eliminar un libro del sistema (solo para el administrador)
                    break;

                case 8:

                    System.out.print("Ingrese el nombre del autor: ");
                    scanner.nextLine();
                    String autorBusqueda = scanner.nextLine();
                    List<Libro> resultadosAutor = biblioteca.buscarPorAutor(autorBusqueda);
                    mostrarResultados(resultadosAutor);
                    break;

                case 9:

                    System.out.println("Gracias por utilizar la aplicación. ¡Hasta luego!");
                    break;

                default:

                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                    break;
            }
        }
        scanner.close();

    }
    
    private static void mostrarResultados(List<Libro> resultados) {

        if (resultados.isEmpty()) {

            System.out.println("No se encontraron libros.");

        } else {

            System.out.println("Resultados de búsqueda:");

            int contador = 1;

            for (Libro libro : resultados) {

                System.out.println(contador + ". Título: " + libro.getTitulo());
                System.out.println("   Autor: " + libro.getAutor());
                if (libro.isDisponible()) {
                    System.out.println("   Estado: Disponible");
                } else if (libro.isReservado()) {
                    System.out.println("   Estado: Reservado");
                } else {
                    System.out.println("   Estado: Vendido");
                }
                System.out.println("------------------------");
                contador++;
            }
        }
    }
}
