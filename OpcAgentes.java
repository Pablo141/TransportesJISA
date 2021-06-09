import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class OpcAgentes extends JFrame implements ActionListener{
   public int opcion;
   public JPanel OAPanel;
   public JTextField nombre,busqueda,tel,email,cargo,idAgente;
   public JButton btnIdP, btnConsultaG, btnVolver, btnBuscar, btnBuscarE, btnGuardar,btnGuardarM, btnEliminar, btnCancelar, btnBusquedaM;
   public String menuIdP[]={"","P1"};
   public JComboBox idProveedor;
   public JLabel texto;
   public OpcAgentes(int opc){
      opcion=opc;
      setResizable(false);
      this.setSize(720, 480);
      setLocationRelativeTo(null);
      setTitle(null);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      OAPanel = new JPanel();
      OAPanel.setLayout(null);
      
      this.getContentPane().add(OAPanel);
      switch(opcion){
         case 1:
            screenRegistrar();
         break;
         case 2:
            screenConsultar();
         break;
         case 3:
            screenModificar();
         break;
         case 4:
            screenEliminar();
         break;
      }
   }
   public void screenRegistrar(){
      
      setTitle("Registrar Agente");
            
      ImageIcon imagenF = new ImageIcon("./Recursos/Imagenes/ImagenAgente.jpg");
      JLabel imagenAgente = new JLabel();
      imagenAgente.setBounds(300, 40, 340, 340);
      imagenAgente.setIcon(new ImageIcon(imagenF.getImage().getScaledInstance(340, 340, Image.SCALE_SMOOTH)));
      OAPanel.add(imagenAgente);
      
      JLabel idProveedorT= new JLabel("Proveedor");
      idProveedorT.setBounds(50,25,150,30);
      Conection CP = new Conection();
      idProveedor = new JComboBox(CP.conseguirArreglo("proveedores","nombre"));
      idProveedor.setBounds(50, 50, 200,30);
      OAPanel.add(idProveedorT);
      OAPanel.add(idProveedor);
      
      JLabel nombreT= new JLabel("Nombre");
      nombreT.setBounds(50, 75, 150, 30);
      nombre = new JTextField();
      nombre.setBounds(50, 100, 200, 30);
      OAPanel.add(nombre);
      OAPanel.add(nombreT);
      
      JLabel telT= new JLabel("Numero Telefonico");
      telT.setBounds(50, 125, 150, 30);
      tel = new JTextField();
      tel.setBounds(50, 150, 200, 30);
      OAPanel.add(tel);
      OAPanel.add(telT);
      
      JLabel emailT= new JLabel("Email");
      emailT.setBounds(50, 175, 150, 30);
      email = new JTextField();
      email.setBounds(50, 200, 200, 30);
      OAPanel.add(email);
      OAPanel.add(emailT);
            
      JLabel cargoT= new JLabel("Cargo");
      cargoT.setBounds(50, 225, 150, 30);
      cargo = new JTextField();
      cargo.setBounds(50, 250, 200, 30);
      OAPanel.add(cargoT);
      OAPanel.add(cargo);
      
      btnGuardar= new JButton("Guardar");
      btnGuardar.setBounds(50, 360, 80, 30);
      btnGuardar.addActionListener(this);
      OAPanel.add(btnGuardar);
      
      btnVolver= new JButton("Volver");
      btnVolver.setBounds(150, 360, 80, 30);
      btnVolver.addActionListener(this);
      OAPanel.add(btnVolver);

            /* CÓDIGO DE KEVIN - INICIA*/
            ActionListener registrarA = new ActionListener(){  //EVENTO PARA TRAER LOS DATOS LA INTERFAZ DE MODIFICAR
               public void actionPerformed(ActionEvent ae){
                     Conection CC = new Conection();
                     String prove = (String) idProveedor.getSelectedItem();
                     CC.registrarAgente(prove, nombre.getText(), tel.getText(), email.getText(), cargo.getText());
               }
            };
      
            btnGuardar.addActionListener(registrarA);
            /* CÓDIGO DE KEVIN - ACABA*/


   }
   public void screenConsultar(){
   
      texto= new JLabel();
      setTitle("Consultar Agente");
      texto.setText("Opciones de busqueda:");
      texto.setBounds(80, 5, 300, 30);
      OAPanel.add(texto);
      
      btnIdP= new JButton("Busqueda por Id");
      btnIdP.setBounds(130, 45, 200, 30);
      btnIdP.addActionListener(this);
      OAPanel.add(btnIdP);
            
      btnConsultaG= new JButton("Consulta General");
      btnConsultaG.setBounds(340, 45, 200, 30);
      btnConsultaG.addActionListener(this);
      OAPanel.add(btnConsultaG);
      
      btnBuscar= new JButton("Buscar");
      btnBuscar.setBounds(500, 100, 100, 30);
      btnBuscar.setVisible(false);
      btnBuscar.addActionListener(this);
      OAPanel.add(btnBuscar);
 
      busqueda = new JTextField();
      busqueda.setBounds(90, 100, 400, 30);
      busqueda.setVisible(false);
      OAPanel.add(busqueda);
      
      btnVolver= new JButton("Volver");
      btnVolver.setBounds(50, 360, 100, 30);
      btnVolver.addActionListener(this);
      OAPanel.add(btnVolver);

            //CODIGO KEVIN - INCIA
            ActionListener ConsultaGeneralA = new ActionListener(){
               public void actionPerformed(ActionEvent ae){
                        Conection CadenaC = new Conection();
                        JTable tabla = CadenaC.consultarAgentes();
                        tabla.setBounds(20, 120, 660,200);
                        OAPanel.add(tabla);
                        OAPanel.updateUI();
               }
            };
      
         ActionListener ConsultaAgeI = new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                     Conection CadenaC = new Conection();
                     JTable tabla = CadenaC.consultarAgente(Integer.parseInt(busqueda.getText()));
                     tabla.setBounds(20, 150, 660,200);
                     OAPanel.add(tabla);
                     OAPanel.updateUI();
            }
         };
      
         btnConsultaG.addActionListener(ConsultaGeneralA);
         btnBuscar.addActionListener(ConsultaAgeI);
               //CODIGO KEVIN - Acaba
   }
   public void screenModificar(){
      setTitle("Modificar Agente");
      
      texto= new JLabel();
      texto.setText("Ingrese Id de Agente:");
      texto.setBounds(90, 15, 300, 30);
      OAPanel.add(texto);
      
      btnBusquedaM = new JButton("Buscar");
      btnBusquedaM.setBounds(500, 40, 100, 30);
      btnBusquedaM.addActionListener(this);
      OAPanel.add(btnBusquedaM);
      
      busqueda = new JTextField();
      busqueda.setBounds(90, 40, 400, 30);
      OAPanel.add(busqueda);
      
      ImageIcon imagenF = new ImageIcon("./Recursos/Imagenes/ImagenAgente.jpg");
      JLabel imagenAgentes = new JLabel();
      imagenAgentes.setBounds(300, 115, 310, 280);
      imagenAgentes.setIcon(new ImageIcon(imagenF.getImage().getScaledInstance(340, 340, Image.SCALE_SMOOTH)));
      OAPanel.add(imagenAgentes);
      
      btnVolver= new JButton("Volver");
      btnVolver.setBounds(150, 360, 80, 30);
      btnVolver.addActionListener(this);
      OAPanel.add(btnVolver);
      
      JLabel idProveedorT= new JLabel("Proveedor");
      idProveedorT.setBounds(50,75,150,30);
      Conection CP = new Conection();
      idProveedor = new JComboBox(CP.conseguirArreglo("proveedores","nombre"));
      idProveedor.setBounds(50, 100, 200,30);
      idProveedor.setEnabled(false);
      OAPanel.add(idProveedorT);
      OAPanel.add(idProveedor);
   
      JLabel nombreT= new JLabel("Nombre");
      nombreT.setBounds(50, 125, 150, 30);
      nombre = new JTextField();
      nombre.setBounds(50, 150, 200, 30);
      nombre.setEnabled(false);
      OAPanel.add(nombre);
      OAPanel.add(nombreT);
      
      JLabel telT= new JLabel("Numero Telefonico");
      telT.setBounds(50, 175, 150, 30);
      tel = new JTextField();
      tel.setBounds(50, 200, 200, 30);
      tel.setEnabled(false);
      OAPanel.add(tel);
      OAPanel.add(telT);
      
      JLabel emailT= new JLabel("Email");
      emailT.setBounds(50, 225, 150, 30);
      email = new JTextField();
      email.setBounds(50, 250, 200, 30);
      email.setEnabled(false);
      OAPanel.add(email);
      OAPanel.add(emailT);
            
      JLabel cargoT= new JLabel("Cargo");
      cargoT.setBounds(50, 275, 150, 30);
      cargo = new JTextField();
      cargo.setBounds(50, 300, 200, 30);
      cargo.setEnabled(false);
      OAPanel.add(cargoT);
      OAPanel.add(cargo);
      
      btnGuardarM= new JButton("Guardar");
      btnGuardarM.setBounds(50, 360, 80, 30);
      btnGuardarM.addActionListener(this);
      btnGuardarM.setEnabled(false);
      OAPanel.add(btnGuardarM);

      /* CÓDIGO DE KEVIN - INICIA*/
      ActionListener registrarA = new ActionListener(){  //EVENTO PARA TRAER LOS DATOS LA INTERFAZ DE MODIFICAR
         public void actionPerformed(ActionEvent ae){
               Conection CC = new Conection();
               String prove = (String) idProveedor.getSelectedItem();
               CC.modificarAgente(Integer.parseInt(busqueda.getText()),prove, nombre.getText(), tel.getText(), email.getText(), cargo.getText());
         }
      };

      btnGuardarM.addActionListener(registrarA);


      ActionListener traer = new ActionListener(){  //EVENTO PARA TRAER LOS DATOS LA INTERFAZ DE MODIFICAR
         public void actionPerformed(ActionEvent ae){
               Conection CA = new Conection();
               String pro = (String) idProveedor.getSelectedItem();
               nombre.setText(CA.ObtenerAgente(Integer.parseInt(busqueda.getText()),2));
               tel.setText(CA.ObtenerAgente(Integer.parseInt(busqueda.getText()),3));
               email.setText(CA.ObtenerAgente(Integer.parseInt(busqueda.getText()),4));
               cargo.setText(CA.ObtenerAgente(Integer.parseInt(busqueda.getText()),5));
               
               for(int x = 0; x < CA.conseguirArreglo("proveedores","nombre").length; x++){
                  if(CA.conseguirArreglo("proveedores","nombre")[x].equals(CA.ObtenerAgente(Integer.parseInt(busqueda.getText()),1))){
                     idProveedor.setSelectedIndex(x);   

                  }                        
            }   
         }
      };

      btnBusquedaM.addActionListener(traer);
      /* CÓDIGO DE KEVIN - ACABA*/

   }


   public void screenEliminar(){
      setTitle("Eliminar Agente");
      
      texto= new JLabel();
      texto.setText("Ingrese Id de Agente:");
      texto.setBounds(90, 35, 300, 30);
      OAPanel.add(texto);
      
      btnBuscarE= new JButton("Buscar");
      btnBuscarE.setBounds(500, 60, 100, 30);
      btnBuscarE.addActionListener(this);
      OAPanel.add(btnBuscarE);
 
      busqueda = new JTextField();
      busqueda.setBounds(90, 60, 400, 30);
      OAPanel.add(busqueda);
      
      btnEliminar= new JButton("Eliminar");
      btnEliminar.setBounds(280, 360, 100, 30);
      btnEliminar.addActionListener(this);
      btnEliminar.setVisible(false);
      OAPanel.add(btnEliminar);
      
      btnCancelar= new JButton("Cancelar");
      btnCancelar.setBounds(390, 360, 100, 30);
      btnCancelar.addActionListener(this);
      btnCancelar.setVisible(false);
      OAPanel.add(btnCancelar);
      
      btnVolver= new JButton("Volver");
      btnVolver.setBounds(50, 360, 100, 30);
      btnVolver.addActionListener(this);
      OAPanel.add(btnVolver);


      // CODIGO KEVIN INICIA

      ActionListener EliminarA = new ActionListener(){
         public void actionPerformed(ActionEvent ae){
                  Conection CadenaC = new Conection();
                  CadenaC.eliminarAgente(Integer.parseInt(busqueda.getText()));
         }
      };
      btnEliminar.addActionListener(EliminarA);



      ActionListener ConsultaAgeI = new ActionListener(){
         public void actionPerformed(ActionEvent ae){
                  Conection CadenaC = new Conection();
                  JTable tabla = CadenaC.consultarAgente(Integer.parseInt(busqueda.getText()));
                  tabla.setBounds(20, 150, 660,200);
                  OAPanel.add(tabla);
                  OAPanel.updateUI();
         }
      };

      btnBuscarE.addActionListener(ConsultaAgeI);
      
         // CODIGO KEVIN ACABA
      }
   public void actionPerformed(ActionEvent e){
      
      if(e.getSource() == btnIdP){
         btnBuscar.setVisible(true);
         busqueda.setVisible(true);
         btnConsultaG.setEnabled(false);
      }
      //Eventos de Consulta General de Agentes
      if(e.getSource() == btnConsultaG){
         btnIdP.setEnabled(false);
      }
      //Eventos de Consultar Agentes por Id 
      if(e.getSource() == btnBuscar){
         
      }
      if(e.getSource() == btnVolver){
         GestionarAgentes vol = new GestionarAgentes();
         vol.setVisible(true);
         setVisible(false);
      }
      //Guardar Registro de Agentes
      if(e.getSource() ==  btnGuardar){
         JOptionPane.showMessageDialog(null, "Se guardarán los datos");	
         tel.setText(null);
         nombre.setText(null);
         cargo.setText(null);
         email.setText(null);
         idProveedor.setSelectedIndex(0);         
      }
      //Guardar Modificaciones de Agentes
      if(e.getSource() ==  btnGuardarM){
         JOptionPane.showMessageDialog(null, "Se guardarán los datos");	
         tel.setText(null);
         nombre.setText(null);
         busqueda.setText(null);
         cargo.setText(null);
         email.setText(null);
         tel.setEnabled(false);
         nombre.setEnabled(false);
         email.setEnabled(false);
         cargo.setEnabled(false);
         btnGuardarM.setEnabled(false);
         idProveedor.setEnabled(false);
         idProveedor.setSelectedIndex(0);
      }
      //Eventos de Eliminar Agentes
      if(e.getSource() == btnBuscarE){
         btnEliminar.setVisible(true);
         btnCancelar.setVisible(true);
      }
      if(e.getSource() == btnEliminar){
         JOptionPane.showMessageDialog(null, "Eliminando Datos");	
         busqueda.setText(null);
         btnEliminar.setVisible(false);
         btnCancelar.setVisible(false);
      } 
      if(e.getSource() == btnCancelar){
         busqueda.setText(null);
         btnEliminar.setVisible(false);
         btnCancelar.setVisible(false);
      }
      //Eventos de Modificar Agentes
      if(e.getSource() == btnBusquedaM){
         tel.setEnabled(true);
         nombre.setEnabled(true);
         email.setEnabled(true);
         cargo.setEnabled(true);
         btnGuardarM.setEnabled(true);
         idProveedor.setEnabled(true);
         // idProveedor.setSelectedIndex(1);//Colocar la casilla del id de su proveedor
      }
   }
}
