import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class Conection {

        public void Conection (){ }
                                        
        public void OnlyConection(){ //Creamos un método que simplemente haga una conexión y nos avise en la terminal
                System.out.println("Intentando Conectar a la Base de Datos...");

                //Hacemos nuestra cadena de conexión con un objeto tipo Connection y le asignamos los datos: nombre de la base de datos, usuario, contraseña.
                try ( Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      

                        System.out.println("Conectado con Éxito a la Base de Datos!"); //Mostramos un mensaje de conección exitosa a la base de datos

                }catch (SQLException e) {
                        System.out.println("Fallo al intentar conectar con la base de Datos");
                        e.printStackTrace();
                }
        }//OnlyConection




        //CONSULTA GENERAL - Vehiculos
        public JTable consultaG(){
                final JTable table = new JTable();
                DefaultTableModel dtm = new DefaultTableModel();
                try ( 
                        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      
                        System.out.println("Entre xD");

                        String  dato [ ] = new String[9];
                        
                        dtm.addColumn("ID");
                        dtm.addColumn("Nombres");
                        dtm.addColumn("ID");
                        dtm.addColumn("Nombres");
                        dtm.addColumn("ID");
                        dtm.addColumn("Nombres");
                        dtm.addColumn("ID");
                        dtm.addColumn("Nombres");
                        dtm.addColumn("Nombres");

                        try {
                                System.out.println("x222");
                                Statement declaracion = connection.createStatement();
                                ResultSet resultSet = declaracion.executeQuery("SELECT vehiculos.id_vehiculo, vehiculos.nombre_vehiculo, vehiculos.placas, vehiculos.num_serie, vehiculos.kmxl,  modelo,  cilindros, marca, capacidad FROM  vehiculos INNER JOIN modelos  ON id_modelo = id_m INNER JOIN t_cilindros  ON id_cilindros = id_c  INNER JOIN marcas  ON vehiculos.id_marca = marcas.id_marca INNER JOIN capacidades ON id_capacidad = capacidades.id_c");
                                while(resultSet.next()){
                                        dato[0] = resultSet.getString(1);
                                        dato[1] = resultSet.getString(2);
                                        dato[2] = resultSet.getString(3);
                                        dato[3] = resultSet.getString(4);
                                        dato[4] = resultSet.getString(5);
                                        dato[5] = resultSet.getString(6);
                                        dato[6] = resultSet.getString(7);
                                        dato[7] = resultSet.getString(8);
                                        dato[8] = resultSet.getString(9);
                                        dtm.addRow(dato);
                                }
                                table.setModel(dtm);
                        } catch (Exception e) {
                                System.out.println(e);
                        }
                            return table;
                }catch (SQLException e) {
                        System.out.println("Fallo al intentar conectar con la base de Datos");
                        e.printStackTrace();
                        return table;
                }
        }//CONSULTA GENERAL - Vehiculos


        //CONSULTA INDIVIDUAL POR ID
        public JTable consultaIndividual(int id){
                final JTable table = new JTable();
                DefaultTableModel dtm = new DefaultTableModel();
                try ( Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      

                        String  dato [ ] = new String[9];
                        
                        dtm.addColumn("ID");
                        dtm.addColumn("Nombres");
                        dtm.addColumn("ID");
                        dtm.addColumn("Nombres");
                        dtm.addColumn("ID");
                        dtm.addColumn("Nombres");
                        dtm.addColumn("ID");
                        dtm.addColumn("Nombres");
                        dtm.addColumn("Nombres");

                        // SELECT last_name, first_name FROM customer WHERE first_name = 'Jamie' 
                        
                        try {
                                System.out.println("x222");
                                Statement declaracion = connection.createStatement();
                                ResultSet resultSet = declaracion.executeQuery("SELECT vehiculos.id_vehiculo, vehiculos.nombre_vehiculo, vehiculos.placas, vehiculos.num_serie, vehiculos.kmxl,  modelo,  cilindros, marca, capacidad FROM  vehiculos INNER JOIN modelos  ON id_modelo = id_m INNER JOIN t_cilindros  ON id_cilindros = id_c  INNER JOIN marcas  ON vehiculos.id_marca = marcas.id_marca INNER JOIN capacidades ON id_capacidad = capacidades.id_c WHERE id_vehiculo = "+id);
                                while(resultSet.next()){
                                    dato[0] = resultSet.getString(1);
                                    dato[1] = resultSet.getString(2);
                                    dato[2] = resultSet.getString(3);
                                    dato[3] = resultSet.getString(4);
                                    dato[4] = resultSet.getString(5);
                                    dato[5] = resultSet.getString(6);
                                    dato[6] = resultSet.getString(7);
                                    dato[7] = resultSet.getString(8);
                                    dato[8] = resultSet.getString(9);
                                    dtm.addRow(dato);
                                }
                                table.setModel(dtm);
                        } catch (Exception e) {
                                System.out.println("Pos no se pudo");
                        }
                        return table;
                }catch (SQLException e) {
                        System.out.println("Fallo al intentar conectar con la base de Datos");
                        e.printStackTrace();
                        return table;
                }
        }//CONSULTA INDIVIDUAL POR ID


        //ELIMINAR - Vehiculos
        public void eliminar(int id){
                try ( 
                        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      
                        //DELETE FROM links WHERE id = 8;
                        try{
                                Statement declaracion = connection.createStatement();
                                declaracion.executeQuery("DELETE FROM vehiculos WHERE id_vehiculo = "+id);
                        } catch (Exception e) {
                                System.out.println("Pos no se pudo");
                        }
                }catch (SQLException e) {
                        System.out.println("Fallo al intentar conectar con la base de Datos");
                        e.printStackTrace();
                }
        }//ELIMINAR - VEHICULOS



        //REGISTRO - Vehiculos
        public void registrar(int id, String nombre, String placas, String num_s, String kmxl, int Id_Modelo, int Id_Cilindro, int Id_Marca, int Id_Capacidad){
                try( 
                        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      
                        // INSERT INTO table_name(column1, column2, …) VALUES (value1, value2, …);
                        try{
                                Statement declaracion = connection.createStatement();
                                declaracion.executeQuery("INSERT INTO Vehiculos(Id_Vehiculo, Nombre_Vehiculo, Placas, Num_Serie, kmxl,Id_Modelo, Id_Cilindros, Id_Marca, Id_Capacidad) VALUES ("+id+",'"+nombre+"','"+placas+"', '"+num_s+"','"+kmxl+"',"+Id_Modelo+","+Id_Cilindro+","+Id_Marca+","+Id_Capacidad+");");
                        } catch (Exception e) {
                                System.out.println("Pos no se pudo");
                        }
                }catch (SQLException e) {
                        System.out.println("Fallo al intentar conectar con la base de Datos");
                        e.printStackTrace();
                }
        }//Registro - vehiculos




        //MODIFICAR - Vehiculos
        public void modificarVehiculos(int id, String nombre, String placas, String num_s, String kmxl, int Id_Modelo, int Id_Cilindro, int Id_Marca, int Id_Capacidad){
                try ( 
                        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      
                        // UPDATE table_name SET column1 = value1, column2 = value2  WHERE condition
                        try {

                                Statement declaracion = connection.createStatement();
                                declaracion.executeQuery("UPDATE vehiculos SET nombre_vehiculo = '"+nombre+"', placas = '"+placas+"', num_serie = '"+num_s+"', kmxl = '"+kmxl+"', id_modelo = "+Id_Modelo+", id_cilindros = "+Id_Cilindro+", id_marca = "+Id_Marca+", id_capacidad = "+Id_Capacidad+" WHERE id_vehiculo = "+id+";");
                        } catch (Exception e) {
                                System.out.println("Pos no se pudo");
                        }
                        }catch (SQLException e) {
                                    System.out.println("Fallo al intentar conectar con la base de Datos");
                                    e.printStackTrace();
                        }
        }//MODIFICAR - vehiculos




        //Método para conseguir los datos individuales de un vehiculos
        public String vehiculoObtener(int id, int opc){ 
            String tabla = "", resultado = "";
            if(opc == 1){
                    tabla = "nombre_vehiculo";
            }else if(opc == 2){
                    tabla = "placas";
            }else if(opc == 3){
                tabla = "kmxl";
            }else if(opc == 4){
                tabla = "num_serie";
            }else if(opc == 6){
                tabla = "id_marca";
            }else if(opc == 7){
                tabla = "id_cilindros";
            }else if(opc == 8){
                tabla = "id_modelo";
            }else if(opc == 9){
                tabla = "id_capacidad";
            }
            try (   
                    Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      
                    Statement declaracion = connection.createStatement();
                    ResultSet resultSet = declaracion.executeQuery("SELECT "+tabla+" FROM vehiculos WHERE id_vehiculo = "+id);
                    while(resultSet.next()){
                            resultado = resultSet.getString(1);
                    }

                    if(tabla == "id_marca"){
                        
                        int r = Integer.parseInt(resultado);

                            if(r == 1){resultado = "Ford";}
                            if(r == 2){resultado = "Toyota";}
                            if(r == 3){ resultado = "Dodge";}
                            if(r == 4){resultado = "Nissan";}
                    }

                    if(tabla == "id_cilindros"){
                            int r = Integer.parseInt(resultado);
                            if(r == 1)
                                    resultado = "6";
                            if(r == 2)
                                    resultado = "8";             
                    }
                    
                    if(tabla == "id_modelo"){
                            int r = Integer.parseInt(resultado);
                            if(r == 1)
                                    resultado = "1998";
                            if(r == 2)
                                    resultado = "1999";
                            if(r == 3)
                                    resultado = "2000";
                            if(r == 4)
                                    resultado = "2006";
                    }

                    if(tabla == "id_capacidad"){
                            int r = Integer.parseInt(resultado);
                            if(r == 1)
                                    resultado = "13";
                            if(r == 2)
                                    resultado = "15";
                            if(r == 3)
                                    resultado = "25";
                            if(r == 4)
                                    resultado = "41";
                    }

                    return resultado;

            }catch (SQLException e) {
                    System.out.println("Fallo al intentar conectar con la base de Datos");
                    e.printStackTrace();
                    return "eo";
            }
        }



        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                //Métodos para los proovedores

        //REGISTRO de Proovedores
        public void registrarProveedor(String nombre, String NumeroTel, int Id_Tipo){
                try( 
                        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      
                        // INSERT INTO table_name(column1, column2, …) VALUES (value1, value2, …);
                        // INSERT INTO proveedores (nombre, NumeroTel, Id_Tipo) VALUES ('Garibaldi','3411331173',3);
                        try{
                                Statement declaracion = connection.createStatement();
                                declaracion.executeQuery("INSERT INTO proveedores (nombre, NumeroTel, Id_Tipo) VALUES ('"+nombre+"','"+NumeroTel+"',"+Id_Tipo+");");
                        } catch (Exception e) {
                                System.out.println(e);
                        }
                }catch (SQLException e) {
                        System.out.println("Fallo al intentar conectar con la base de Datos");
                        e.printStackTrace();
                }
        }//Registro de Proovedores


        //ELIMINAR - Proveedores
        public void eliminarProveedor(int id){
                try ( 
                        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      
                        //DELETE FROM links WHERE id = 8;
                        try{
                                Statement declaracion = connection.createStatement();
                                declaracion.executeQuery("DELETE FROM proveedores WHERE id_p = "+id);
                        } catch (Exception e) {
                                System.out.println("Pos no se pudo");
                        }
                }catch (SQLException e) {
                        System.out.println("Fallo al intentar conectar con la base de Datos");
                        e.printStackTrace();
                }
        }//ELIMINAR - Proveedores

        //CONSULTA GENERAL - Proveedores
        public JTable consultarProveedores(){
                final JTable table = new JTable();
                DefaultTableModel dtm = new DefaultTableModel();
                try ( 
                        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      

                        String  dato [ ] = new String[9];
                        
                        dtm.addColumn("ID");
                        dtm.addColumn("Nombre");
                        dtm.addColumn("Telefono");
                        dtm.addColumn("Tipo");

                        try {
                                Statement declaracion = connection.createStatement();
                                ResultSet resultSet = declaracion.executeQuery("SELECT id_p, nombre, NumeroTel, Tipo FROM  proveedores INNER JOIN Tipo_SoC  ON Id_tipo = id_t ");
                                while(resultSet.next()){
                                        dato[0] = resultSet.getString(1);
                                        dato[1] = resultSet.getString(2);
                                        dato[2] = resultSet.getString(3);
                                        dato[3] = resultSet.getString(4);
                                        dtm.addRow(dato);
                                }
                                table.setModel(dtm);
                        } catch (Exception e) {
                                System.out.println("Pos no se pudo");
                        }
                                return table;
                }catch (SQLException e) {
                        System.out.println("Fallo al intentar conectar con la base de Datos");
                        e.printStackTrace();
                        return table;
                }
        }//CONSULTA GENERAL - Proveedores




        //CONSULTA INDIVIDUAL POR ID - PROVEEDORES
        public JTable consultarIProveedores(int id){
                final JTable table = new JTable();
                DefaultTableModel dtm = new DefaultTableModel();
                try ( Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      

                        String  dato [ ] = new String[9];
                        
                        dtm.addColumn("ID");
                        dtm.addColumn("Nombres");
                        dtm.addColumn("ID");
                        dtm.addColumn("Nombres");
                        // SELECT last_name, first_name FROM customer WHERE first_name = 'Jamie' 
                        
                        try {
                                Statement declaracion = connection.createStatement();
                                ResultSet resultSet = declaracion.executeQuery("SELECT id_p, nombre, NumeroTel, Tipo FROM  proveedores INNER JOIN Tipo_SoC  ON Id_tipo = id_t WHERE id_p = "+id);
                                while(resultSet.next()){
                                        dato[0] = resultSet.getString(1);
                                        dato[1] = resultSet.getString(2);
                                        dato[2] = resultSet.getString(3);
                                        dato[3] = resultSet.getString(4);
                                        dtm.addRow(dato);
                                }
                                table.setModel(dtm);
                        } catch (Exception e) {
                                System.out.println("Pos no se pudo");
                        }
                        return table;
                }catch (SQLException e) {
                        System.out.println("Fallo al intentar conectar con la base de Datos");
                        e.printStackTrace();
                        return table;
                }
        }//CONSULTA INDIVIDUAL POR ID - Proveedores


                //Conseguir los arreglos de las columnas
                public String[] conseguirArreglo(String tabla, String columna){
                                try ( Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      
                
                                                // SELECT last_name, first_name FROM customer WHERE first_name = 'Jamie' 
                                                
                                                try {
                                                                // Statement declaracion = connection.createStatement();
                                                                Statement declaracion = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                                                                ResultSet resultSet = declaracion.executeQuery("SELECT "+columna+" FROM "+tabla);

                                                                int count = 0;
                                                                resultSet.beforeFirst();
                                                                while (resultSet.next()){
                                                                ++count;
                                                                }
                                                                String  dato[] = new String[count];
                                                                resultSet.beforeFirst();
                                                                int x = 0;
                                                                while(resultSet.next()){
                                                                                dato[x] = resultSet.getString(1);
                                                                                x++;
                                                                }
                                                                return dato;

                                                } catch (Exception e) {
                                                                System.out.println(e);
                                                }
                                                String  dato[ ] = new String[1];
                                                return dato;
                                                }catch (SQLException e) {
                                                                System.out.println("Fallo al intentar conectar con la base de Datos");
                                                                e.printStackTrace();
                                                                String  dato[ ] = new String[1];
                                                                return dato;
                                                }
                }//CONSEGUIR ARREGLO DE OBJETOS



        // MODIFICAR - Proveedores
        public void modificarProveedor(String nombre, String numero, int tipo, int id){
                try ( 
                        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      
                        // UPDATE table_name SET column1 = value1, column2 = value2  WHERE condition
                        try {

                                Statement declaracion = connection.createStatement();
                                declaracion.executeQuery("UPDATE proveedores SET nombre = '"+nombre+"', numerotel = '"+numero+"', id_tipo = "+tipo+" WHERE id_p = "+id);
                        } catch (Exception e) {
                                System.out.println(e);
                        }
                        }catch (SQLException e) {
                                    System.out.println("Fallo al intentar conectar con la base de Datos");
                                    e.printStackTrace();
                        }
        }//MODIFICAR - Proveedores





                //Método para conseguir los datos individuales de los proveedores
                public String proveedorObtener(int id, int opc){ 
                        if(opc == 1){
                                        try (   
                                                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      
                                                Statement declaracion = connection.createStatement();
                                                ResultSet resultSet = declaracion.executeQuery("SELECT numerotel FROM proveedores WHERE  id_p = "+id);
                                                String resultado = "";
                                                while(resultSet.next()){
                                                        resultado = resultSet.getString(1);
                                                }
                                                return resultado;
                        
                                        }catch (SQLException e) {
                                                System.out.println("Fallo al intentar conectar con la base de Datos");
                                                e.printStackTrace();
                                                return "eo";
                                        }
                        }
                        if(opc == 2){
                                        try (   
                                                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      
                                                Statement declaracion = connection.createStatement();
                                                ResultSet resultSet = declaracion.executeQuery("SELECT nombre FROM proveedores WHERE  id_p = "+id);
                                                String resultado = "";
                                                while(resultSet.next()){
                                                        resultado = resultSet.getString(1);
                                                }
                                                return resultado;
                        
                                        }catch (SQLException e) {
                                                System.out.println("Fallo al intentar conectar con la base de Datos");
                                                e.printStackTrace();
                                                return "eo";
                                        }
                        }
                        if(opc == 3){
                                try (   
                                        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      
                                        Statement declaracion = connection.createStatement();
                                        ResultSet resultSet = declaracion.executeQuery("SELECT  Tipo FROM  proveedores INNER JOIN Tipo_SoC  ON id_tipo = id_t WHERE id_p = "+id);
                                        String resultado = "";
                                        while(resultSet.next()){
                                                resultado = resultSet.getString(1);
                                        }
                                        return resultado;
                
                                }catch (SQLException e) {
                                        System.out.println("Fallo al intentar conectar con la base de Datos");
                                        e.printStackTrace();
                                        return "eo";
                                }
                        }
                        return "JAJAJA";
                    }




                            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                //Métodos para los gastos
                
        //REGISTRO de GASTOS
        public void registrarGasto(String fecha, float dinero, String s, int Id_Gasto, int pro){
                if(s.equals("Si")){
                        s = "t";       
                }else if (s.equals("No")){
                        s = "f";
                }
                try( 
                        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      
                        // INSERT INTO table_name(column1, column2, …) VALUES (value1, value2, …);
                        // INSERT INTO proveedores (nombre, NumeroTel, Id_Tipo) VALUES ('Garibaldi','3411331173',3);
                        try{
                                Statement declaracion = connection.createStatement();
                                declaracion.executeQuery("INSERT INTO e_gastos(fecha, gasto_total, facturado, id_tipog,id_proveedor) VALUES ('"+fecha+"',"+dinero+",'"+s+"',"+Id_Gasto+","+pro+")");
                        } catch (Exception e) {
                                System.out.println(e);
                        }
                }catch (SQLException e) {
                        System.out.println("Fallo al intentar conectar con la base de Datos");
                        e.printStackTrace();
                }
        }//Registro de Gastos             
                                        


        //CONSULTA GENERAL - Gastos
        public JTable consultarGastos(){
                final JTable table = new JTable();
                DefaultTableModel dtm = new DefaultTableModel();
                try ( 
                        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      

                        String  dato [ ] = new String[25];
                        
                        dtm.addColumn("ID");
                        dtm.addColumn("Nombre");
                        dtm.addColumn("Telefono");
                        dtm.addColumn("Tipo");
                        dtm.addColumn("Tipo");
                        dtm.addColumn("Tipo");

                        try {
                                Statement declaracion = connection.createStatement();
                                ResultSet resultSet = declaracion.executeQuery("select id_gasto, fecha, gasto_total, facturado, tipo_gasto, nombre from e_gastos Inner Join tipo_gastos on id_tipog = id_tg inner join proveedores ON id_proveedor = id_p");
                                while(resultSet.next()){
                                        dato[0] = resultSet.getString(1);
                                        dato[1] = resultSet.getString(2);
                                        dato[2] = resultSet.getString(3);
                                        dato[3] = resultSet.getString(4);
                                        dato[4] = resultSet.getString(5);
                                        dato[5] = resultSet.getString(6);
                                        dtm.addRow(dato);
                                }
                                table.setModel(dtm);
                        } catch (Exception e) {
                                System.out.println("Pos no se pudo");
                        }
                        return table;
                }catch (SQLException e) {
                        System.out.println("Fallo al intentar conectar con la base de Datos");
                        e.printStackTrace();
                        return table;
                }
        }//CONSULTA GENERAL - Gastos



        public JTable consultarIGastos(int id){
                final JTable table = new JTable();
                DefaultTableModel dtm = new DefaultTableModel();
                try ( 
                        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      

                        String  dato [ ] = new String[25];
                        
                        dtm.addColumn("ID");
                        dtm.addColumn("Nombre");
                        dtm.addColumn("Telefono");
                        dtm.addColumn("Tipo");
                        dtm.addColumn("Tipo");
                        dtm.addColumn("Tipo");

                        try {
                                Statement declaracion = connection.createStatement();
                                ResultSet resultSet = declaracion.executeQuery("select id_gasto, fecha, gasto_total, facturado, tipo_gasto, nombre from e_gastos Inner Join tipo_gastos on id_tipog = id_tg inner join proveedores ON id_proveedor = id_p WHERE id_gasto = "+id);
                                while(resultSet.next()){
                                        dato[0] = resultSet.getString(1);
                                        dato[1] = resultSet.getString(2);
                                        dato[2] = resultSet.getString(3);
                                        dato[3] = resultSet.getString(4);
                                        dato[4] = resultSet.getString(5);
                                        dato[5] = resultSet.getString(6);
                                        dtm.addRow(dato);
                                }
                                table.setModel(dtm);
                        } catch (Exception e) {
                                System.out.println("Pos no se pudo");
                        }
                        return table;
                }catch (SQLException e) {
                        System.out.println("Fallo al intentar conectar con la base de Datos");
                        e.printStackTrace();
                        return table;
                }
        }//CONSULTA Individual - Gastos



                //ELIMINAR - Gasto
                public void eliminarGasto(int id){
                        try ( 
                                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      
                                //DELETE FROM links WHERE id = 8;
                                try{
                                        Statement declaracion = connection.createStatement();
                                        declaracion.executeQuery("DELETE FROM e_gastos WHERE id_gasto = "+id);
                                } catch (Exception e) {
                                        System.out.println("Pos no se pudo");
                                }
                        }catch (SQLException e) {
                                System.out.println("Fallo al intentar conectar con la base de Datos");
                                e.printStackTrace();
                        }
                }//ELIMINAR - Gastos


                        // MODIFICAR - Gastos
                public void modificarGasto(int id, String fecha, float dinero, String s, int Id_Gasto, int pro){
                        if(s.equals("Si")){
                                s = "t";       
                        }else if (s.equals("No")){
                                s = "f";
                        }
                        System.out.println("S vale: "+s);
                        try ( 
                                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      
                                // UPDATE table_name SET column1 = value1, column2 = value2  WHERE condition
                                try {
                                        //INSERT INTO e_gastos(fecha, gasto_total, facturado, id_tipog,id_proveedor) VALUES (' "+fecha+" ',"+dinero+",'"+s+"',"+Id_Gasto+","+pro+")
                                        Statement declaracion = connection.createStatement();
                                        declaracion.executeQuery("UPDATE e_gastos SET fecha = ' "+fecha+" ', gasto_total = ' "+dinero+"', facturado = ' "+s+" ' ,id_tipog = "+Id_Gasto+", id_proveedor = "+pro+" WHERE id_gasto = "+id);
                                } catch (Exception e) {
                                        System.out.println(e);
                                }
                                }catch (SQLException e) {
                                        System.out.println("Fallo al intentar conectar con la base de Datos");
                                        e.printStackTrace();
                                }
                }//MODIFICAR - Gastos


                //GENRAL ------------------------- Método para obtener el algo del objeto

                //Método para conseguir los datos individuales de los gastos
                public String gastosObtener(int id, int opc){ 
                        if(opc == 1){ //Fecha
                                        try (   
                                                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      
                                                Statement declaracion = connection.createStatement();
                                                ResultSet resultSet = declaracion.executeQuery("select fecha from e_gastos where id_gasto = "+id);
                                                String resultado = "No se encontraron datos...";
                                                while(resultSet.next()){
                                                        resultado = resultSet.getString(1);
                                                }
                                                return resultado;
                        
                                        }catch (SQLException e) {
                                                System.out.println("Fallo al intentar conectar con la base de Datos");
                                                e.printStackTrace();
                                                return "eo";
                                        }
                        }else if(opc == 2){ //Gasto Total
                                        try (   
                                                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      
                                                Statement declaracion = connection.createStatement();
                                                ResultSet resultSet = declaracion.executeQuery("select gasto_total from e_gastos where id_gasto = "+id);
                                                String resultado = "No se encontraron datos...";
                                                while(resultSet.next()){
                                                        resultado = resultSet.getString(1);
                                                }
                                                return resultado;
                        
                                        }catch (SQLException e) {
                                                System.out.println("Fallo al intentar conectar con la base de Datos");
                                                e.printStackTrace();
                                                return "eo";
                                        }
                        }else if(opc == 3){ //TIPO DE GASTO
                                try (   
                                        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      
                                        Statement declaracion = connection.createStatement();
                                        ResultSet resultSet = declaracion.executeQuery("select id_tipog from e_gastos where id_gasto = "+id);
                                        String resultado = "No se encontraron datos...";
                                        while(resultSet.next()){
                                                resultado = resultSet.getString(1);
                                        }
                                        int r = Integer.parseInt(resultado);
                                        if(r == 4){
                                                return "Mantenimiento";
                                        }else if(r == 5){
                                                return "Reparaciones";
                                        }
                                }catch (SQLException e) {
                                        System.out.println("Fallo al intentar conectar con la base de Datos");
                                        e.printStackTrace();
                                        return "eo";
                                }
                        }else if(opc == 4){
                                try (   
                                        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      
                                        Statement declaracion = connection.createStatement();
                                        ResultSet resultSet = declaracion.executeQuery("Select proveedores.nombre From e_gastos inner join proveedores ON id_proveedor = id_p WHERE id_gasto = "+id);
                                        String resultado = "";
                                        while(resultSet.next()){
                                                resultado = resultSet.getString(1);
                                        }
                                        return resultado;
                                }catch (SQLException e) {
                                        System.out.println("Fallo al intentar conectar con la base de Datos");
                                        e.printStackTrace();
                                        return "eo";
                                }
                        }else if(opc == 5){ //¿Está facturado?
                                try (   
                                        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      
                                        Statement declaracion = connection.createStatement();
                                        ResultSet resultSet = declaracion.executeQuery("select facturado from e_gastos where id_gasto = "+id);
                                        String resultado = "";
                                        while(resultSet.next()){
                                                resultado = resultSet.getString(1);
                                        }
                                        if(resultado.equals("t")){
                                                return "Si";
                                        }else{
                                                return "No";
                                        }
                                }catch (SQLException e) {
                                        System.out.println("Fallo al intentar conectar con la base de Datos");
                                        e.printStackTrace();
                                        return "eo";
                                }
                        }                      
                        return "JAJAJA";
                }

                public int ObtenerID(String nombre){
                        try ( 
                                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      
                                //DELETE FROM links WHERE id = 8;
                                try{
                                        Statement declaracion = connection.createStatement();
                                        ResultSet resultSet = declaracion.executeQuery("select id_p FROM proveedores WHERE nombre = '"+nombre+"'");
                                        String resultado = "No se encontraron datos...";
                                                while(resultSet.next()){
                                                        resultado = resultSet.getString(1);
                                                }
                                        return Integer.parseInt(resultado);


                                } catch (Exception e) {
                                        System.out.println("Pos no se pudo");
                                        return 0;
                                }
                        }catch (SQLException e) {
                                System.out.println("Fallo al intentar conectar con la base de Datos");
                                e.printStackTrace();
                                return 0;
                        }
                }



                public int ObtenerIDv(String nombre){
                        try ( 
                                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      
                                //DELETE FROM links WHERE id = 8;
                                try{
                                        System.out.println("llegue al 1");
                                        Statement declaracion = connection.createStatement();
                                        System.out.println("llegue al 2");
                                        ResultSet resultSet = declaracion.executeQuery("SELECT id_vehiculo FROM vehiculos WHERE nombre_vehiculo = '"+nombre+"'");
                                        
                                        String resultado = "No se encontraron datos...";
                                        System.out.println("Vehiculo que recibo = " + nombre);
                                        while(resultSet.next()){
                                                        resultado = resultSet.getString(1);
                                                }
                                        System.out.println("Obtuve: "+resultado);
                                        return Integer.parseInt(resultado);

                                } catch (Exception e) {
                                        System.out.println("A continuacion el error chido: ");

                                        System.out.println(e);
                                        return 0;
                                }
                        }catch (SQLException e) {
                                System.out.println("Fallo al intentar conectar con la base de Datos");
                                e.printStackTrace();
                                return 0;
                        }
                }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                //Métodos para los agentes
                
        //REGISTRO de Agentes
        public void registrarAgente(String prov, String nombre, String tel, String email, String cargo){
                int idProv = 0;
                for(int i = 0; i <= conseguirArreglo("proveedores", "nombre").length-1;i++){
                                if(conseguirArreglo("proveedores", "nombre")[i].equals(prov)){
                                                idProv = ObtenerID(prov);
                                }
                }
                System.out.println("idProv = "+idProv);
                try( 
                        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      
                        /*
                        insert into proveedores_Agentes (id_proveedor, nombre_Agente,telefono_a, email, cargo)VALUES (15,'Chalan Luis', '3411086741', 'pepe@gmail.com', 'chalan')
                        */
                        try{
                                Statement declaracion = connection.createStatement();
                                declaracion.executeQuery("insert into proveedores_Agentes (id_proveedor, nombre_Agente,telefono_a, email, cargo)VALUES ("+idProv+",'"+nombre+"', '"+tel+"', '"+email+"', '"+cargo+"')");
                        } catch (Exception e) {
                                System.out.println(e);
                        }
                }catch (SQLException e) {
                        System.out.println("Fallo al intentar conectar con la base de Datos");
                        e.printStackTrace();
                }
        }//Registro de Agentes
        
        // MODIFICAR - Agentes
        public void modificarAgente(int id, String prov, String nombre, String tel, String email, String cargo){
                int idProv = 0;
                for(int i = 0; i <= conseguirArreglo("proveedores", "nombre").length-1;i++){
                                if(conseguirArreglo("proveedores", "nombre")[i].equals(prov)){
                                                idProv = ObtenerID(prov);
                                }
                }
                try ( 
                        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      
                        // UPDATE table_name SET column1 = value1, column2 = value2  WHERE condition
                        try {
                                //INSERT INTO e_gastos(fecha, gasto_total, facturado, id_tipog,id_proveedor) VALUES (' "+fecha+" ',"+dinero+",'"+s+"',"+Id_Gasto+","+pro+")
                                Statement declaracion = connection.createStatement();
                                declaracion.executeQuery("UPDATE proveedores_Agentes SET id_proveedor = "+idProv+", nombre_Agente = '"+nombre+"',telefono_a = '"+tel+"',email = '"+email+"', cargo = '"+cargo+"' WHERE id_agente = "+id);
                        } catch (Exception e) {
                                System.out.println(e);
                        }
                        }catch (SQLException e) {
                                System.out.println("Fallo al intentar conectar con la base de Datos");
                                e.printStackTrace();
                        }
        }//MODIFICAR - Agentes


                //CONSULTA GENERAL - Agentes
                public JTable consultarAgentes(){
                        final JTable table = new JTable();
                        DefaultTableModel dtm = new DefaultTableModel();
                        try ( 
                                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      
        
                                String  dato [ ] = new String[25];
                                
                                dtm.addColumn("ID");
                                dtm.addColumn("Nombre");
                                dtm.addColumn("Telefono");
                                dtm.addColumn("Tipo");
                                dtm.addColumn("Tipo");
                                dtm.addColumn("Tipo");
        
                                try {
                                        Statement declaracion = connection.createStatement();
                                        ResultSet resultSet = declaracion.executeQuery("Select id_agente, nombre_agente, telefono_a, email, cargo, nombre from proveedores_Agentes Inner join proveedores ON proveedores_Agentes.id_proveedor = id_p");
                                        while(resultSet.next()){
                                                dato[0] = resultSet.getString(1);
                                                dato[1] = resultSet.getString(2);
                                                dato[2] = resultSet.getString(3);
                                                dato[3] = resultSet.getString(4);
                                                dato[4] = resultSet.getString(5);
                                                dato[5] = resultSet.getString(6);
                                                dtm.addRow(dato);
                                        }
                                        table.setModel(dtm);
                                } catch (Exception e) {
                                        System.out.println("Pos no se pudo");
                                }
                                return table;
                        }catch (SQLException e) {
                                System.out.println("Fallo al intentar conectar con la base de Datos");
                                e.printStackTrace();
                                return table;
                        }
                }//CONSULTA GENERAL - Agentes


                //CONSULTA Individual - Agentes
                public JTable consultarAgente(int id){
                final JTable table = new JTable();
                DefaultTableModel dtm = new DefaultTableModel();
                try ( 
                        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      

                        String  dato [ ] = new String[25];
                        
                        dtm.addColumn("ID");
                        dtm.addColumn("Nombre");
                        dtm.addColumn("Telefono");
                        dtm.addColumn("Tipo");
                        dtm.addColumn("Tipo");
                        dtm.addColumn("Tipo");

                        try {
                                Statement declaracion = connection.createStatement();
                                ResultSet resultSet = declaracion.executeQuery("Select id_agente, nombre_agente, telefono_a, email, cargo, nombre from proveedores_Agentes Inner join proveedores ON proveedores_Agentes.id_proveedor = id_p WHERE id_agente ="+id);
                                while(resultSet.next()){
                                        dato[0] = resultSet.getString(1);
                                        dato[1] = resultSet.getString(2);
                                        dato[2] = resultSet.getString(3);
                                        dato[3] = resultSet.getString(4);
                                        dato[4] = resultSet.getString(5);
                                        dato[5] = resultSet.getString(6);
                                        dtm.addRow(dato);
                                }
                                table.setModel(dtm);
                        } catch (Exception e) {
                                System.out.println("Pos no se pudo");
                        }
                        return table;
                }catch (SQLException e) {
                        System.out.println("Fallo al intentar conectar con la base de Datos");
                        e.printStackTrace();
                        return table;
                }
        }//CONSULTA Individual - Agentes


        //Obtener
        // public String obtenerNombreProveedor



                        //Método para conseguir los datos individuales de los gastos
                        public String ObtenerAgente(int id, int opc){ 
                                if(opc == 1){ //Proveedor
                                                try (   
                                                        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      
                                                        Statement declaracion = connection.createStatement();
                                                        ResultSet resultSet = declaracion.executeQuery("Select nombre from proveedores_Agentes Inner join proveedores ON proveedores_Agentes.id_proveedor = id_p WHERE id_agente = "+id);
                                                        String resultado = "No se encontraron datos...";
                                                        while(resultSet.next()){
                                                                resultado = resultSet.getString(1);
                                                        }
                                                        return resultado;
                                
                                                }catch (SQLException e) {
                                                        System.out.println("Fallo al intentar conectar con la base de Datos");
                                                        e.printStackTrace();
                                                        return "eo";
                                                }
                                }else if(opc == 2){ //Nombre del Agente
                                                try (   
                                                        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      
                                                        Statement declaracion = connection.createStatement();
                                                        ResultSet resultSet = declaracion.executeQuery("select nombre_agente from proveedores_Agentes WHERE id_agente = "+id);
                                                        String resultado = "No se encontraron datos...";
                                                        while(resultSet.next()){
                                                                resultado = resultSet.getString(1);
                                                        }
                                                        return resultado;
                                
                                                }catch (SQLException e) {
                                                        System.out.println("Fallo al intentar conectar con la base de Datos");
                                                        e.printStackTrace();
                                                        return "eo";
                                                }
                                }else if(opc == 3){ //Telefono del Agente   
                                        try (   
                                                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      
                                                Statement declaracion = connection.createStatement();
                                                ResultSet resultSet = declaracion.executeQuery("select telefono_a from proveedores_Agentes WHERE id_agente = "+id);
                                                String resultado = "No se encontraron datos...";
                                                while(resultSet.next()){
                                                        resultado = resultSet.getString(1);
                                                }
                                                return resultado;
                        
                                        }catch (SQLException e) {
                                                System.out.println("Fallo al intentar conectar con la base de Datos");
                                                e.printStackTrace();
                                                return "eo";
                                        }
                                }else if(opc == 4){ //Email del Agente
                                        try (   
                                                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      
                                                Statement declaracion = connection.createStatement();
                                                ResultSet resultSet = declaracion.executeQuery("select email from proveedores_Agentes WHERE id_agente = "+id);
                                                String resultado = "No se encontraron datos...";
                                                while(resultSet.next()){
                                                        resultado = resultSet.getString(1);
                                                }
                                                return resultado;
                        
                                        }catch (SQLException e) {
                                                System.out.println("Fallo al intentar conectar con la base de Datos");
                                                e.printStackTrace();
                                                return "eo";
                                        }
                                }else if(opc == 5){ //Cargo del Agente
                                        try (   
                                                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      
                                                Statement declaracion = connection.createStatement();
                                                ResultSet resultSet = declaracion.executeQuery("select cargo from proveedores_Agentes WHERE id_agente ="+id);
                                                String resultado = "No se encontraron datos...";
                                                while(resultSet.next()){
                                                        resultado = resultSet.getString(1);
                                                }
                                                return resultado;
                        
                                        }catch (SQLException e) {
                                                System.out.println("Fallo al intentar conectar con la base de Datos");
                                                e.printStackTrace();
                                                return "eo";
                                        }
                                }
                                
                                if(opc == 3){
                                try (   
                                        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      
                                        Statement declaracion = connection.createStatement();
                                        ResultSet resultSet = declaracion.executeQuery("SELECT  Tipo FROM  proveedores INNER JOIN Tipo_SoC  ON id_tipo = id_t WHERE id_p = "+id);
                                        String resultado = "";
                                        while(resultSet.next()){
                                                resultado = resultSet.getString(1);
                                        }
                                        return resultado;
                
                                }catch (SQLException e) {
                                        System.out.println("Fallo al intentar conectar con la base de Datos");
                                        e.printStackTrace();
                                        return "eo";
                                }
                        }
                                return "JAJAJA";
                        }

                //ELIMINAR - Agentes
                public void eliminarAgente(int id){
                        try ( 
                                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      
                                //DELETE FROM links WHERE id = 8;
                                try{
                                        Statement declaracion = connection.createStatement();
                                        declaracion.executeQuery("DELETE FROM proveedores_Agentes WHERE id_agente = "+id);
                                } catch (Exception e) {
                                        System.out.println("Pos no se pudo");
                                }
                        }catch (SQLException e) {
                                System.out.println("Fallo al intentar conectar con la base de Datos");
                                e.printStackTrace();
                        }
                }//ELIMINAR - Agentes

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                //Métodos para los registros y manteinimientos
                
        //REGISTRO de Mantenimientos y reparaciones
        public void registrarMan(String vehiculo, String prov,  String mor, String reporte, float costo, String fecha){
                int idProv = 0; int idveh = 0;
                for(int i = 0; i <= conseguirArreglo("proveedores", "nombre").length-1;i++){
                                if(conseguirArreglo("proveedores", "nombre")[i].equals(prov)){
                                                idProv = ObtenerID(prov);
                                }
                }
                idveh = ObtenerIDv(vehiculo);

                try( 
                        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      
                        /*
Insert into mantenimientosyreparaciones (id_vehiculo, mor, id_proveedor, reporte, costo, fecha) VALUES (2,'Reparacion de Motor',15,'Se le hizo una reparación al motor ya que presentaba fallas con las bujias', 300, '30-05-2021');                        
                                */
                        try{
                                Statement declaracion = connection.createStatement();
                                declaracion.executeQuery("Insert into mantenimientosyreparaciones (id_vehiculo, mor, id_proveedor, reporte, costo, fecha) VALUES ("+idveh+",'"+mor+"',"+idProv+",'"+reporte+"', "+costo+", '"+fecha+"');");
                        } catch (Exception e) {
                                System.out.println(e);
                        }
                }catch (SQLException e) {
                        System.out.println("Fallo al intentar conectar con la base de Datos");
                        e.printStackTrace();
                }
        }//Registro de Mantenimientos y reparaciones


        //CONSULTA GENERAL - Mantenimientos y Reparaciones
        public JTable consultarMans(){
                final JTable table = new JTable();
                DefaultTableModel dtm = new DefaultTableModel();
                try ( 
                        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      

                        String  dato [ ] = new String[25];
                        
                        dtm.addColumn("ID");
                        dtm.addColumn("Nombre");
                        dtm.addColumn("Telefono");
                        dtm.addColumn("Tipo");
                        dtm.addColumn("Tipo");
                        dtm.addColumn("Tipo");
                        dtm.addColumn("Tipo");

                        try {
                                Statement declaracion = connection.createStatement();
                                ResultSet resultSet = declaracion.executeQuery("select id_myr, nombre_vehiculo, mor, proveedores.nombre, reporte, costo, fecha from mantenimientosyreparaciones Inner join vehiculos ON mantenimientosyreparaciones.id_vehiculo = vehiculos.id_vehiculo Inner join proveedores ON id_proveedor = id_p ");
                                while(resultSet.next()){
                                        dato[0] = resultSet.getString(1);
                                        dato[1] = resultSet.getString(2);
                                        dato[2] = resultSet.getString(3);
                                        dato[3] = resultSet.getString(4);
                                        dato[4] = resultSet.getString(5);
                                        dato[5] = resultSet.getString(6);
                                        dato[6] = resultSet.getString(7);
                                        dtm.addRow(dato);
                                }
                                table.setModel(dtm);
                        } catch (Exception e) {
                                System.out.println("Pos no se pudo");
                        }
                        return table;
                }catch (SQLException e) {
                        System.out.println("Fallo al intentar conectar con la base de Datos");
                        e.printStackTrace();
                        return table;
                }
        }//CONSULTA GENERAL - Mantenimientos y Reparaciones


        //CONSULTA INDIVIDUAL - Mantenimientos y Reparaciones
        public JTable consultarMan(int id){
                final JTable table = new JTable();
                DefaultTableModel dtm = new DefaultTableModel();
                try ( 
                        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      

                        String  dato [ ] = new String[25];
                        
                        dtm.addColumn("ID");
                        dtm.addColumn("Nombre");
                        dtm.addColumn("Telefono");
                        dtm.addColumn("Tipo");
                        dtm.addColumn("Tipo");
                        dtm.addColumn("Tipo");
                        dtm.addColumn("Tipo");

                        try {
                                Statement declaracion = connection.createStatement();
                                ResultSet resultSet = declaracion.executeQuery("select id_myr, nombre_vehiculo, mor, proveedores.nombre, reporte, costo, fecha from mantenimientosyreparaciones Inner join vehiculos ON mantenimientosyreparaciones.id_vehiculo = vehiculos.id_vehiculo Inner join proveedores ON id_proveedor = id_p WHERE id_myr = "+id);
                                while(resultSet.next()){
                                        dato[0] = resultSet.getString(1);
                                        dato[1] = resultSet.getString(2);
                                        dato[2] = resultSet.getString(3); 
                                        dato[3] = resultSet.getString(4);
                                        dato[4] = resultSet.getString(5);
                                        dato[5] = resultSet.getString(6);
                                        dato[6] = resultSet.getString(7);
                                        dtm.addRow(dato);
                                }
                                table.setModel(dtm);
                        } catch (Exception e) {
                                System.out.println("Pos no se pudo");
                        }
                        return table;
                }catch (SQLException e) {
                        System.out.println("Fallo al intentar conectar con la base de Datos");
                        e.printStackTrace();
                        return table;
                }
        }//CONSULTA INDIVIDUAL - Mantenimientos y Reparaciones


// Update mantenimientosyreparaciones SET id_vehiculo = 55, mor = 'Cambio de llantas', id_proveedor = 14, reporte = 'se cambiaron llantas', costo = 50, fecha = '20-08-2020'
        


                // MODIFICAR - Mantenimientos y Reparaciones
                public void modificarM(int id, String vehiculo, String prov,  String mor, String reporte, float costo, String fecha){
                        int idProv = 0; int idveh = 0;
                        for(int i = 0; i <= conseguirArreglo("proveedores", "nombre").length-1;i++){
                                        if(conseguirArreglo("proveedores", "nombre")[i].equals(prov)){
                                                        idProv = ObtenerID(prov);
                                        }
                        }
                        for(int i = 0; i <= conseguirArreglo("vehiculos", "nombre_vehiculo").length-1;i++){
                                if(conseguirArreglo("vehiculos", "nombre_vehiculo")[i].equals(vehiculo)){
                                                idveh = ObtenerIDv(vehiculo);
                                }
                        }
                        try ( 
                                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      
                                // UPDATE table_name SET column1 = value1, column2 = value2  WHERE condition
                                try {
                                        Statement declaracion = connection.createStatement();
                                        declaracion.executeQuery("Update mantenimientosyreparaciones SET id_vehiculo = "+idveh+", mor = '"+mor+"', id_proveedor = "+idProv+", reporte = '"+reporte+"', costo = "+costo+", fecha = '"+fecha+"' WHERE id_myr = "+id);
                                } catch (Exception e) {
                                        System.out.println(e);
                                }
                                }catch (SQLException e) {
                                        System.out.println("Fallo al intentar conectar con la base de Datos");
                                        e.printStackTrace();
                                }
                }//MODIFICAR - Mantenimientos y Reparaciones




                // Delete from mantenimientosyreparaciones where id_myr = 2
                //ELIMINAR - Agentes
                public void eliminarMoR(int id){
                        try ( 
                                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      
                                //DELETE FROM links WHERE id = 8;
                                try{
                                        Statement declaracion = connection.createStatement();
                                        declaracion.executeQuery("Delete from mantenimientosyreparaciones where id_myr = "+id);
                                } catch (Exception e) {
                                        System.out.println("Pos no se pudo");
                                }
                        }catch (SQLException e) {
                                System.out.println("Fallo al intentar conectar con la base de Datos");
                                e.printStackTrace();
                        }
                }//ELIMINAR - Agentes



                //obtenerMant
                public String obtenerMan(int id, int opc){ 
                        if(opc == 1){ //Fecha
                                        try (   
                                                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      
                                                Statement declaracion = connection.createStatement();
                                                ResultSet resultSet = declaracion.executeQuery("select fecha from mantenimientosyreparaciones where id_myr="+id);
                                                String resultado = "No se encontraron datos...";
                                                while(resultSet.next()){
                                                        resultado = resultSet.getString(1);
                                                }
                                                return resultado;
                        
                                        }catch (SQLException e) {
                                                System.out.println("Fallo al intentar conectar con la base de Datos");
                                                e.printStackTrace();
                                                return "eo";
                                        }
                        }else if(opc == 2){ //MoR
                                        try (   
                                                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      
                                                Statement declaracion = connection.createStatement();
                                                ResultSet resultSet = declaracion.executeQuery("select mor from  mantenimientosyreparaciones where id_myr ="+id);
                                                String resultado = "No se encontraron datos...";
                                                while(resultSet.next()){
                                                        resultado = resultSet.getString(1);
                                                }
                                                return resultado;
                        
                                        }catch (SQLException e) {
                                                System.out.println("Fallo al intentar conectar con la base de Datos");
                                                e.printStackTrace();
                                                return "eo";
                                        }
                        }else if(opc == 3){ //Costo
                                try (   
                                        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      
                                        Statement declaracion = connection.createStatement();
                                        ResultSet resultSet = declaracion.executeQuery("select costo from  mantenimientosyreparaciones where id_myr = "+id);
                                        String resultado = "No se encontraron datos...";
                                        while(resultSet.next()){
                                                resultado = resultSet.getString(1);
                                        }

                                        return resultado;
                                }catch (SQLException e) {
                                        System.out.println("Fallo al intentar conectar con la base de Datos");
                                        e.printStackTrace();
                                        return "eo";
                                }
                        }else if(opc == 4){ //Reporte
                                try (   
                                        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      
                                        Statement declaracion = connection.createStatement();
                                        ResultSet resultSet = declaracion.executeQuery("select reporte from  mantenimientosyreparaciones where id_myr ="+id);
                                        String resultado = "";
                                        while(resultSet.next()){
                                                resultado = resultSet.getString(1);
                                        }
                                        return resultado;
                                }catch (SQLException e) {
                                        System.out.println("Fallo al intentar conectar con la base de Datos");
                                        e.printStackTrace();
                                        return "eo";
                                }
                        }else if(opc == 5){ //Vehiculo
                                try (   
                                        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      
                                        Statement declaracion = connection.createStatement();
                                        ResultSet resultSet = declaracion.executeQuery("select nombre_vehiculo from mantenimientosyreparaciones INNER JOIN vehiculos on mantenimientosyreparaciones.id_vehiculo = vehiculos.id_vehiculo WHERE id_myr = "+id);
                                        String resultado = "";
                                        while(resultSet.next()){
                                                resultado = resultSet.getString(1);
                                        }
                                        return resultado;
                                }catch (SQLException e) {
                                        System.out.println("Fallo al intentar conectar con la base de Datos");
                                        e.printStackTrace();
                                        return "eo";
                                }
                        }else if(opc == 6){ //Proveedor
                                try (   
                                        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      
                                        Statement declaracion = connection.createStatement();
                                        ResultSet resultSet = declaracion.executeQuery("select nombre from mantenimientosyreparaciones INNER JOIN proveedores on id_proveedor = id_p WHERE id_myr =  "+id);
                                        String resultado = "";
                                        while(resultSet.next()){
                                                resultado = resultSet.getString(1);
                                        }
                                        System.out.println("El resultado es:" +resultado);
                                        return resultado;
                                }catch (SQLException e) {
                                        System.out.println("Fallo al intentar conectar con la base de Datos");
                                        e.printStackTrace();
                                        return "eo";
                                }
                        }                      
                        return "JAJAJA";
                }



                

}//class