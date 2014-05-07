/*
 * **************************************************************
 * Proyecto Cinemark - Programacion 4
 * Aplicacion que administra los teatros y sus peliculas asociadas.
 * @author Elvis Esteban Aragon Castaño
 * Código: 1115077569
 * @version 1.0
 * Universidad Tecnologica de Pereira - 2014
 * **************************************************************
 */
package Idea;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Date;

/**
 * Esta es la clase que representa la aplicacion Cinemark con sus peliculas y
 * sus teatros
 */
public class Cinemark {

    //*******************************
    //Atributos
    //*******************************
    //La lista de teatros de la aplicacion cinemark
    private ArrayList teatros;

    //El nombre del archivo donde se guardan las peliculas
    private String archivoCinemark;

    /**
     * Se contruye la aplicacion Si el archivo exist entonces la aplicacion se
     * crea vacia y su estado u objeto se guarda en el archivo si el archivo no
     * existe entonces se saca la informacion de los teatros y las peliculas
     *
     * @param discotienda es el nombre del archivo que tiene los datos de la
     * aplicacion - nombreArchivoCinemark != null
     * @throws ExceptionPerseverancia si hay algú problema al manejar el archivo
     */
    public Cinemark(String discotienda) throws ExceptionPerseverancia {
        archivoCinemark = discotienda;
        File archivo = new File(archivoCinemark);
        if (archivo.exists()) {
            // Si el archivo existe entonces se recupera el estado de la aplicación con el archivo binario
            try {
                ObjectInputStream existe = new ObjectInputStream(new FileInputStream(archivo));
                teatros = (ArrayList) existe.readObject();
                existe.close();
            } catch (Exception e) {
                //sino entonces error 
                throw new ExceptionPerseverancia("Error : no se puede restaurar el estado del programa (" + e.getMessage() + ")");
            }
        } else {
            // Si el archivo no existe, es la primera vez que se ejecuta el programa
            teatros = new ArrayList();
        }
        verificar();
    }

    /**
     * Este metodo retorna un teatro de la aplicacion dado un nombre asignado
     *
     * @param nombreTeatro es el nombre del teatro que se va a buscar -
     * tituloTeatro != null
     * @return el titulo donde el nombre es igual al nombre que se va a dar , si
     * no encuentra nada retorne null
     */
    public Teatro getTeatro(String nombreTeatro) {
        for (int i = 0; i < teatros.size(); i++) {
            Teatro d = (Teatro) teatros.get(i);
            if (d.equals(nombreTeatro)) {
                return d;
            }
        }
        return null;
    }

    /**
     * Este metodo retorna un teatro a la aplicacion cinemark dado un nombre,
     * una direccion y una pelicula
     *
     * @param nombreTeatro Es el nombre del teatro donde debería de estar la
     * cancion - nombreTeatro != null
     * @param direccion Es la direccion del teatro - direccion != null
     * @param telefono Es el telefono de la pelicula que se quiere buscar -
     * telefono != null
     * @return Retorna el teatro en el que se encuentre la canción buscada, si
     * no la encuentra entonces retorne null
     */
    private Teatro getTeatro(String nombreTeatro, String direccion, String telefono) {
        Teatro teatroBuscado = getTeatro(nombreTeatro);
        if (teatroBuscado != null && teatroBuscado.getTitulo().equalsIgnoreCase(direccion)) {
            return (teatroBuscado.getPelicula(telefono) != null) ? teatroBuscado : null;
        } else {
            return null;
        }
    }

    /**
     * Este metodo agrega un nuevo teatro a la aplicacion cinemark
     *
     * @param tituloT es el titulo del tratro - tituloT != null
     * @param direccionT es la direccion del teatro - direccionT != null
     * @param telefonoT es el telefono del teatro - telefonoT != null
     * @param imagenT es el nombre del archivo de la caratula del teatro imagenT
     * != null
     * @throws ExceptionElemento Si existe algún problema al momento de agregar
     * un teatro
     */
    public void agregarTeatro(String tituloT, String direccionT, String telefonoT, String imagenT) throws ExceptionElemento {
        if (getTeatro(tituloT) != null) {
            throw new ExceptionElemento("El teatro " + tituloT + " ya existe en la aplicacion");
        }

        teatros.add(new Teatro(tituloT, direccionT, telefonoT, imagenT));
        verificar();
    }
    
    /**
     * Este metodo agrega una nueva pelicula al teatro
     * @param nombreDisco Es el nombre del teatro para poder agregar la pelicula TIENE QUE HABER UN NOMBRE EN LA DISCOTIENDA
     * @param tituloP Es el nombre del teatro
     * @param sipnosisP Es la sipnosis de la pelicula
     * @param generoP Es genero de la pelicula
     * @param idiomaP Es el idioma de la pelicula
     * @param clasificacionP Es la clasificacion de la pelicula
     * @param duracionP Es la duracion de la pelicula
     * @param paisP Es e pais de la pelicula
     * @param directorP Es director de la pelicula
     * @param calidadP Es calidad de la pelicula
     * @param precioP Es precio de la pelicula
     * @param imagenP Es imagen de la pelicula
     * @throws ExceptionElemento Esta exception salta cuando ya existe otra pelicula en el tratro con el mismo nombre
     */
     public void agregarPeliculaATeatro( String nombreDisco, String tituloP, String sipnosisP, String generoP, String idiomaP, String clasificacionP, double duracionP, String paisP, String directorP, String calidadP, double precioP, String imagenP) throws ExceptionElemento
    {
        Teatro d = getTeatro( nombreDisco );
        d.agregarPelicula( new Pelicula(  tituloP,  sipnosisP,  generoP,  idiomaP,  clasificacionP,  duracionP,  paisP,  directorP,  calidadP,  precioP,  imagenP ) );
        verificar( );
    }

    /**
     * Registra la venta de una pelicula y genera una factura en un nuevo
     * archivo
     *
     * @param teatro Es el nombre del teatro a la cual pertenece la pelicula que
     * se quiere vender - teatro != null
     * @param pelicula Es la pelicula la cual se quiere vender - pelicula !=
     * null
     * @param email Es el email de la persona a la que se le vendio la pelicula
     * != null
     * @param rutaFactura Es el directorio donde se debe generar la factura -
     * rutaFactura != null
     * @return Retorna el nombre del archivo que genero la factura
     * @throws IOException Genera una exception si hay problemas en el archivo
     */
    public String venderPelicula(Teatro teatro, Pelicula pelicula, String email, String rutaFactura) throws IOException {
        // Aumenta el n�mero de unidades vendidas de la canci�n
        //cancion.vender( );

        // Genera el nombre para la factura
        int posArroba1 = email.indexOf("@");
        String login = email.substring(0, posArroba1);
        String strTiempo = Long.toString(System.currentTimeMillis());
        String nombreArchivo = login + "_" + strTiempo + ".fac";

        // Guarda el archivo de la factura
        File directorioFacturas = new File(rutaFactura);
        if (!directorioFacturas.exists()) {
            directorioFacturas.mkdirs();
        }
        File archivoFactura = new File(directorioFacturas, nombreArchivo);
        PrintWriter salida = new PrintWriter(archivoFactura);

        Date fecha = new Date();
        salida.println("+++++++++++++++++++++++++++++++++++++++++++");
        salida.println("CINEMARK COLOMBIA SAS");
        salida.println("Nit: 8300556433");
        salida.println("+++++++++++++++++++++++++++++++++++++++++++");
        salida.println("Documento equivalente a factura.");
        salida.println("\n");
        salida.println("Fecha de creacion:      " + fecha.toString());
        //salida.println("Tiquete:      " +tiquete.toString()); //?
        salida.println("Email:                  " + email);
        salida.println("Pelicula:               " + pelicula.getNombre());
        salida.println("Clasificacion:               " + pelicula.getClasificacion());
        salida.println("Genero:               " + pelicula.getGenero());
        salida.println("Precio:               " + pelicula.getPrecio());
        salida.println("+++++++++++++++++++++++++++++++++++++++++++");
        out.close();

        return nombreArchivo;
    }

    /**
     * Retorna el vector con los nombres de los teatros
     *
     * @return Vector con los nombres de los teatros
     */
    public ArrayList getTeatros() {
        ArrayList nombresTeatros = new ArrayList();
        for (int i = 0; i < teatros.size(); i++) {
            Teatro d = (Teatro) teatros.get(i);
            nombresTeatros.add(d.getTitulo());
        }
        return nombresTeatros;
    }

    /**
     * Este metodo genera la factura de la venta de los teatros, en un nuevo
     * archivo
     *
     * @param teatros son los teatros a los que pertenecen las peliculas-
     * teatros != null
     * @param peliculas son las peliculas que se van a vender - peliculas !=
     * null
     * @param noEncontradas es un vector con las lineas de codigo que no se
     * procesadorn porque la pelicula no existe
     * @param email es el email de la persona a la cual se le vendio email !=
     * null
     * @param rutaFactura es el directorio donde se va a guardar la factura !=
     * null
     * @return Retorna el nombre del archivo en el que se genero la factura
     * @throws IOException Excepcion si exite algun problema
     */
    private String generarFactura(ArrayList teatros, ArrayList peliculas, ArrayList noEncontradas, String email, String rutaFactura) throws IOException {
        //generando un nombre aleatoreo para la factura
        int posArroba1 = email.indexOf("@");
        String login = email.substring(0, posArroba1);
        String strTiempo = Long.toString(System.currentTimeMillis());
        String nombreArchivo = login + "_" + strTiempo + ".fac";

        //guardando el archivo en la factura
        File directorioFacturas = new File(rutaFactura);
        if (!directorioFacturas.exists()) {
            directorioFacturas.mkdirs();
        }

        File archivoFactura = new File(directorioFacturas, nombreArchivo);
        PrintWriter salida = new PrintWriter(archivoFactura);
        Date fecha = new Date();
        salida.println("+++++++++++++++++++++++++++++++++++++++++++");
        salida.println("CINEMARK COLOMBIA SAS");
        salida.println("Nit: 8300556433");
        salida.println("+++++++++++++++++++++++++++++++++++++++++++");
        salida.println("Documento equivalente a factura.");
        salida.println("\n");
        salida.println("Fecha de creacion:      " + fecha.toString());
        salida.println("Email:                  " + email);

        //double valorTotal = 0;
        for (int i = 0; i < teatros.size(); i++) {
            Teatro teatro = (Teatro) teatros.get(i);
            Pelicula p = (Pelicula) peliculas.get(i);
            salida.println("Pelicula:             " + p.getNombre());
            salida.println("Genero:               " + p.getGenero());
            salida.println("Idioma:               " + p.getIdioma());
            salida.println("Clasificacion:        " + p.getClasificacion());
            salida.println("Duracion:             " + p.getDuracion());
            salida.println("Pais:                 " + p.getPais());
            salida.println("Calidad:              " + p.getCalidad());
            salida.println("Director:             " + p.getDirector());
            salida.println("Precio:               " + p.getPrecio());
        }

        //metiendo las peliculas que no van
        if (noEncontradas.size() > 0) {
            salida.println("\nCanciones no encontradas:");
            for (int i = 0; i < noEncontradas.size(); i++) {
                salida.println(noEncontradas.get(i));
            }
        }
        salida.close();

        return nombreArchivo;
    }

    /**
     * Este metodo indica si el correo cumple con un formato esperado el formato
     * tiene que ser usuario@correo.etc Este correo tiene que estar unido por lo
     * menos con dos partes separadas por un punto parte1.parte2
     *
     * @param email Es la direccion del correo que se quiere verificar - eamil
     * != null
     * @return Retorna verdadero si el email cumplio con las espeficicaciones
     * dadas.
     */
    public boolean validarEmail(String email) {
        boolean resultado = true;
        int posArroba1 = email.indexOf("@");
        if (posArroba1 == -1) {
            resultado = false;
        } else {
            String dominio = email.substring(posArroba1 + 1);
            resultado = dominio.indexOf(".") != -1 && !(dominio.substring(dominio.indexOf(".") + 1).equals(""));
        }
        return resultado;
    }

    public void salvarDiscotienda() throws ExceptionPerseverancia {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoCinemark));
            oos.writeObject(teatros);
            oos.close();
        } catch (IOException e) {
            throw new ExceptionPerseverancia("Error al salvar: " + e.getMessage());
        }
    }

    private void verificar() {
        assert teatros != null : "la lista de teatros está vacia";
        //assert !buscarTeatrosConElMismoNombre() : "Hay dos discos con el mismo nombre";
    }
    
    public String metodo1( )
    {
        return " * **************************************************************\n" +
                " * Proyecto Cinemark - Programacion 4\n" +
                " * Aplicacion que administra los teatros y sus peliculas asociadas.\n" +
                " * @author Elvis Esteban Aragon Castaño\n" +
                " * Código: 1115077569\n" +
                " * @version 1.0\n" +
                " * Universidad Tecnologica de Pereira - 2014\n" +
                " * **************************************************************";
    }

    
//    public static void main(String[] args) {
//        
//        String titulot= "prueba";
//        ArrayList a = new ArrayList();
//        Teatro t = new Teatro(titulot,"Avenida circunvalar","23332322","imageb");
//        Pelicula p = new Pelicula("Capitan","Tras los devastadores acontecimientos ocurridos",
//                                    "Acción","Doblada al español","7 años", 6, 
//                "USA", "Anthony Russo", "3D", "helo");
//       
//        
//        
//        
//        
//        System.out.println(t.toString());
//    }
//    
}
