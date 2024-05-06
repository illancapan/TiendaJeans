import java.util.ArrayList;
import java.util.Scanner;

public class ProductoServicio {

    private static ArrayList<Producto> listaProductos = new ArrayList<Producto>();

    public static ArrayList<Producto> getListaProductos() {

        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {

        this.listaProductos = listaProductos;
    }

    public static void agregarProductos(Producto producto) {
        listaProductos.add(producto);
    }

    public static void listarProductos() {
        for (Producto producto : listaProductos) {
            System.out.println("Datos del producto");
            System.out.println("Articulo: " + producto.getArticulo());
            System.out.println("Precio: " + producto.getPrecio());
            System.out.println("Descripción: " + producto.getDescripcion());
            System.out.println("Código: " + producto.getCodigo());
            System.out.println("Talla: " + producto.getTalla());
            System.out.println("Marca: " + producto.getMarca());
            System.out.println("Color: " + producto.getColor());

        }

    }

    public static void buscarEditarProducto() {
        Scanner leer = new Scanner(System.in);
        // Pedirle al usuario que nos ingrese el código del producto
        System.out.println("Ingrese el código del producto a modificar: ");
        // Leer con la clase Scanner
        // String codigo="1000";
        String codigo = leer.nextLine();

        boolean encontrados = false;

        for (Producto producto : listaProductos) {

            // if (item == producto.getArticulo())
            // System.out.println("Ingrese el nuevonombre del artículo: ");
            // String articulo = leer.nextLine();
            // producto.setArticulo(articulo);
            // equals, si retorna true:son iguales, false: distintos
            if (codigo.equals(producto.getCodigo())) {

                System.out.println(" ingrese el marca del producto");
                String nuevaMarca = leer.nextLine();

                // solicitar los datos para modificar un producto
                // String marca = "Puma";
                producto.setMarca(nuevaMarca);
                encontrados = true;
                break;

            }
            // else
            // {
            // System.out.println("El producto no existe");
            // }

            if (!encontrados) {
                System.out.println("el producto no existe!!!!!!");
            }

        }

    }
}
