
package ejercicio3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Principal {
    
     public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
        
        try
        {    int opcion=0;
            producto s = new producto();
            do
            {
                System.out.println("Seleccione una opcion \n 1- Insertar un producto \n 2-  Actualizar producto \n 3- Borrar un producto \n 4- Buscar un producto \n 5- Salir");
                Scanner opcionin = new Scanner(System.in);
                opcion=opcionin.nextInt();
                switch(opcion)
                {
                    case 1:
                        s.obtenerDatosProductos();
                        s.insertarEstudiantes();
                        break;
                    case 2:
                        s.actualizarProductos();
                        break;
                    case 3:
                        s.borrarProductos();
                        break;
                    case 4:
                        s.buscarProductos();
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Seleccione una opcion correcta");
                }
            }while(opcion!=5);
            System.out.println("Gracias por su visita");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }        
     }
}
class producto
{
    private String id;
    private String nombre;
    private String fechaEnvasado;
    private int unidades;
    private double precio;
    private int disponible;


    
 
    
    public void obtenerDatosProductos() {
        Scanner input = new Scanner(System.in);
        System.out.println("Ponga el id");
        id = input.nextLine();
        System.out.println("Ponga el nombre");
        nombre = input.nextLine();
        System.out.println("Entre la fecha");
        fechaEnvasado = input.nextLine();
        System.out.println("Ponga unidades");
        unidades = input.nextInt();
        System.out.println("Ponga precio");
        precio = input.nextInt();
        System.out.println("Ponga la disponibilidad");
        disponible= input.nextInt();
    }
    
    public void insertarEstudiantes() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

        dbmsconnection dbmsconnect = new dbmsconnection("jdbc:mysql://localhost:3306/hitoprog","root","");
        Connection con = dbmsconnect.getConnection();
        String sql = "insert into productos values (?,?,?,?,?,?);";
        PreparedStatement prod = con.prepareStatement(sql);
        prod.setString(1, id);
        prod.setString(2, nombre);
        prod.setString(3, fechaEnvasado);
        prod.setInt(4, unidades);
        prod.setDouble(5, precio);
        prod.setInt(6, unidades);

        int i = prod.executeUpdate();
        System.out.println("Productos insertados correctamente");
        dbmsconnect.closeConnection(con, prod);
    }
    
    public void actualizarProductos() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        dbmsconnection dbmsconnect = new dbmsconnection("jdbc:mysql://localhost:3306/hitoprog","root","");
        Connection con = dbmsconnect.getConnection();
        System.out.println("Ingresa el id del cual deseas cambiar algun dato");
        Scanner input = new Scanner(System.in);
        String inputid=input.nextLine();
        System.out.println("Ingrese los datos a actualizar");
        String inputdatos=input.nextLine();
        String sql = "update productos set nombre = ? where idProducto = ?;e idProducto = ?;";
       
        
        
        
        PreparedStatement prod = con.prepareStatement(sql);
        prod.setString(1, inputdatos);
        prod.setString(2, inputid);
        
        
        int i = prod.executeUpdate();
        if(i>0)
        {
            System.out.println("Se ha actualizado correctamente");
        }else
        {
            System.out.println("No existe tal dato en la base de datos");
        }
        dbmsconnect.closeConnection(con, prod);
    }


public void borrarProductos() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
    dbmsconnection dbmsconnect = new dbmsconnection("jdbc:mysql://localhost:3306/hitoprog","root","");
    Connection con = dbmsconnect.getConnection();
    System.out.println("Entra el id que desee borrar");
    Scanner input = new Scanner(System.in);
    String inputid=input.nextLine();
    String sql = "delete from productos where idProducto = ?;";
    PreparedStatement prod = con.prepareStatement(sql);
    prod.setString(1, inputid);
    int i = prod.executeUpdate();
    if(i>0)
    {
        System.out.println("Se ha borrado correctamente");
    }
    else
    {
        System.out.println("No existe tal id que desea borrar");
    }
    dbmsconnect.closeConnection(con, prod);
}

public void buscarProductos() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
    dbmsconnection dbmsconnect = new dbmsconnection("jdbc:mysql://localhost:3306/hitoprog","root","");
    Connection con = dbmsconnect.getConnection();
    System.out.println("Ponga el id");
    Scanner input = new Scanner(System.in);
    String inputid=input.nextLine();
    String sql = "select * from productos where idProducto=?";
    PreparedStatement prod = con.prepareStatement(sql);
    prod.setString(1, inputid);
    ResultSet rs = prod.executeQuery();
    if(rs.next()==false)
    {
        System.out.println("No existe tal dato a consultar");
    }
    else
    {    
        System.out.println("idProducto: "+rs.getString(1)+"\n Nombre Producto: "+rs.getString(2)+"\n Fecha envasado: "+rs.getString(3)+"\n Unidades: "+rs.getInt(4)+"\n Precio: "+rs.getDouble(5)+"\n Disponibilidad: "+rs.getInt(6));
        
    }
    dbmsconnect.closeConnection(con, prod);
}
}

class dbmsconnection
{
    String url;
    String username;
    String password;
    
    public dbmsconnection(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        Connection con=null;
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        con = DriverManager.getConnection(url,username,password);
        System.out.println("Conexion establecida correctamente");
        return con;
    }
    
    public void closeConnection(Connection con,Statement prod) throws SQLException
    {
        prod.close();
        con.close();
        System.out.println("La conexion se ha cerrado");
    }
}