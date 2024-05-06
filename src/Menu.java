import java.util.Scanner;

public class Menu {
    static Scanner leer = new Scanner(System.in);

    public static void introMenu() throws Exception {
        Scanner leer = new Scanner(System.in);
        System.out.println("¿Desea entrar al menu?. 1: entrar ,2: no entrar");
        byte opcionMenu = leer.nextByte();
        if(opcionMenu==1)
        {
            menu();
        }
        else {
            System.out.println("Saliendo la aplicación");
        }

        System.out.println("Fin del metodo introMenu()");

        leer.close();
    }
    public static void menu() throws Exception {



            System.out.println("Le damos la bienvenida Tienda Jeans");
            System.out.println("1: listar productos");
            System.out.println("2: Agregar producto");
            System.out.println("3: Cargar datos productos");
            System.out.println("4: BUSCAR EDITAR PRODUCTO");
            System.out.println("5: Salir");
            int opc = leer.nextInt();// leer la opción del usuario
            switch (opc) {
                case 1:
                    listarProductosM();
                    menu();//recursividad: llamarse a si mismo
                    break;
                case 2:
                    agregarProducto();
                    menu();
                    break;
                case 3:
                    cargarDatosProductos();
                    menu();
                    break;
                    case 4:
                    ProductoServicio.buscarEditarProducto();
                    menu();
                    break;
                default:
                    System.out.println("Saliendo del menu");
                    introMenu();
                    break;


            }



    }

    private static void cargarDatosProductos() throws Exception {

        ArchivoServicio.cargarDatos();
    }

    private static void agregarProducto() {

        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese articulo: ");
        String articulo = leer.nextLine();
        System.out.println("Ingrese precio");
        String precio = leer.nextLine();
        System.out.println("Ingrese descripcion");
        String descripcion = leer.nextLine();
        System.out.println("Ingrese código");
        String codigo = leer.nextLine();
        System.out.println("Ingrese talla");
        String talla = leer.nextLine();
        System.out.println("Ingrese marca");
        String marca = leer.nextLine();
        System.out.println("Ingrese color");
        String color = leer.nextLine();
        Producto producto =
                new Producto(articulo,precio,descripcion,codigo,talla,marca,color);
        ProductoServicio.agregarProductos(producto);

leer.close();

    }

    private static void listarProductosM() {

        ArchivoServicio.listarProductos();

    }
    

}
