import java.io.*;
import java.util.ArrayList;

public class ArchivoServicio {

    private static ArrayList<Producto> productosExportados;

    public static void cargarDatos() throws Exception {
        File file = new File("src/ProductosImportados.csv");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String stringLeido; // guardar las lineas
        while ((stringLeido = bufferedReader.readLine()) != null) {

            String[] valores = stringLeido.split(",");
            String articulo = valores[0];
            String precio = valores[1];
            String descripcion = valores[2];
            String codigo = valores[3];
            String talla = valores[4];
            String marca = valores[5];
            String color = valores[6];
            Producto producto = new Producto(articulo, precio, descripcion, codigo, talla, marca, color);
            ProductoServicio.agregarProductos(producto);

        }

    }

    public static void listarProductos() {
        System.out.println("Listado productos: ");
        ProductoServicio.listarProductos();
    }

    public static void exportarListaProductos() {
        productosExportados = ProductoServicio.getListaProductos();

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/ProductosExportados.csv"));

            for (Producto producto : productosExportados) {
                // bufferedWriter.write("articulo"prod + "," + "precio" + "," + "descripcion" +
                // ",");


                // private String articulo;
                // private String precio;
                // private String descripcion;
                // private String codigo;
                // private String talla;
                // private String marca;
                // private String color;

                bufferedWriter.write(
                        producto.getArticulo() +","+
                        producto.getPrecio() +","+
                        producto.getDescripcion() +","+
                        producto.getCodigo() +","+
                        producto.getTalla() +","+
                        producto.getMarca() +","+
                        producto.getColor());

                // String articulo = producto.getArticulo();

                bufferedWriter.newLine();

            }
            bufferedWriter.close();

        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
