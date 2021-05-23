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

        public void Conection (){

        }

//Creamos un método que simplemente haga una conexión y nos avise en la terminal
        public void OnlyConection(){
                System.out.println("Intentando Conectar a la Base de Datos...");

                //Hacemos nuestra cadena de conexión con un objeto tipo Connection y le asignamos los datos: nombre de la base de datos, usuario, contraseña.
                try ( Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      

                    System.out.println("Conectado con Éxito a la Base de Datos!"); //Mostramos un mensaje de conección exitosa a la base de datos

                }catch (SQLException e) {
                            System.out.println("Fallo al intentar conectar con la base de Datos");
                            e.printStackTrace();
                }
        }//OnlyConection


        
        //Método para consultar  todos los gastos
        public void gastos(){
            System.out.println("Intentando Conectar a la Base de Datos...");

            try ( Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      

                Statement declaracion = connection.createStatement();
                System.out.println("Ejecutando consulta de la tabla Vehiculos");
                ResultSet resultSet = declaracion.executeQuery("SELECT * FROM Alumnos");

                System.out.println("User_ID    Nombre");
                while (resultSet.next()) {
                    System.out.printf(resultSet.getString("user_id")+"          "+resultSet.getString("nombre"));
                }
                
            }catch (SQLException e) {
                        System.out.println("Fallo al intentar conectar con la base de Datos");
                        e.printStackTrace();
            }
        }//Consultar gastos



        //Método para consultar  todos los vehiculos
        public void vehiculos(){
            System.out.println("Intentando Conectar a la Base de Datos...");

            try ( Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      
                
                            final JTable table = new JTable();
                            DefaultTableModel dtm = new DefaultTableModel();
            
                            String[ ] columnNames = {"ID", "Nombre", "Placa","Numero de Serie", "Modelo","Capacidad", "Cilindros", "Km_Litro","Marca"};
                            String  dato [ ] = new String[9];
                            
                            dtm.addColumn(columnNames);
                            table.setModel(dtm);
            
                            try {
                                Statement declaracion = connection.createStatement();
                                ResultSet resultSet = declaracion.executeQuery("SELECT * FROM alumnos");
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
                                            
                            } catch (Exception e) {
                                    System.out.println("Pos no se pudo");
                            }
                            JScrollPane scrollPane = new JScrollPane(table);
                
            }catch (SQLException e) {
                        System.out.println("Fallo al intentar conectar con la base de Datos");
                        e.printStackTrace();
            }
        }//Consultar Vehiculos


        //PRUEBA   -   CONSULTA GENERAL
        public JTable prueba(){
            final JTable table = new JTable();
        DefaultTableModel dtm = new DefaultTableModel();
            try ( Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      
                            System.out.println("Entre xD");
            
                            String  dato [ ] = new String[2];
                            
                            dtm.addColumn("ID");
                            dtm.addColumn("Nombres");

                            try {
                                System.out.println("x222");
                                Statement declaracion = connection.createStatement();
                                ResultSet resultSet = declaracion.executeQuery("SELECT * FROM alumnos");
                                while(resultSet.next()){
                                    dato[0] = resultSet.getString(1);
                                    dato[1] = resultSet.getString(2);
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
        }//PRUEBA  - CONSULTA GENERAL


        //PRUEBA   -   CONSULTA INDIVIDUAL POR ID
        public JTable consultaIndividual(int id){
            final JTable table = new JTable();
        DefaultTableModel dtm = new DefaultTableModel();
            try ( Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      
                            System.out.println("Entre xD");
            
                            String  dato [ ] = new String[2];
                            
                            dtm.addColumn("ID");
                            dtm.addColumn("Nombre");

                        // SELECT last_name, first_name FROM customer WHERE first_name = 'Jamie' 
                            
                        try {
                                System.out.println("x222");
                                Statement declaracion = connection.createStatement();
                                ResultSet resultSet = declaracion.executeQuery("SELECT user_id, nombre FROM alumnos WHERE user_id = "+id);
                                while(resultSet.next()){
                                    dato[0] = resultSet.getString(1);
                                    dato[1] = resultSet.getString(2);
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
        }//PRUEBA  - CONSULTA INDIVIDUAL POR ID


        //PRUEBA   -   ELIMINAR
        public void eliminar(int id){
            try ( Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      
                        //DELETE FROM links WHERE id = 8;

                            try {
                                    Statement declaracion = connection.createStatement();
                                    declaracion.executeQuery("DELETE FROM alumnos WHERE user_id = "+id);
                            } catch (Exception e) {
                                    System.out.println("Pos no se pudo");
                            }
            }catch (SQLException e) {
                        System.out.println("Fallo al intentar conectar con la base de Datos");
                        e.printStackTrace();
            }
        }//PRUEBA  - Eliminar



                //PRUEBA   -   REGISTRO
                public void registrar(int id, String nombre){
                    try ( Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportesJISA", "postgres", "kevin2001") ) {      
                            /*
                            INSERT INTO table_name(column1, column2, …) VALUES (value1, value2, …);
                             */
                                    try {
                                        System.out.println("INSERT INTO alumnos(user_id, nombre) VALUES ("+id+",\'"+nombre+"\')");
                                            Statement declaracion = connection.createStatement();
                                            declaracion.executeQuery("INSERT INTO alumnos(user_id, nombre) VALUES ("+id+",\'"+nombre+"\')");
                                    } catch (Exception e) {
                                            System.out.println("Pos no se pudo");
                                    }
                    }catch (SQLException e) {
                                System.out.println("Fallo al intentar conectar con la base de Datos");
                                e.printStackTrace();
                    }
                }//PRUEBA  - Registro



}//class