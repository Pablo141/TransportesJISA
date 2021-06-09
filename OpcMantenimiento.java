import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class OpcMantenimiento extends JFrame implements ActionListener{
   public int opcion;
   public JPanel OMPanel;
   public JTextField busqueda,fecha,costo, idMantenimiento, mantenimiento;
   public JTextArea reporte;
   public JButton btnIdM, btnConsultaG, btnVolver, btnBuscar, btnBuscarE, btnGuardar,btnGuardarM, btnEliminar, btnCancelar, btnBusquedaM;
   public String menuIdP[]={"","P1"},menuIdV[]={"","ihdcihd"},menuMantenimiento[]={"","Mecanico","Electrico","Limpieza"};
   public JComboBox idProveedor,idVehiculo;
   public JLabel texto;
   public OpcMantenimiento(int opc){
      opcion=opc;
      setResizable(false);
      this.setSize(720, 480);
      setLocationRelativeTo(null);
      setTitle(null);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      OMPanel = new JPanel();
      OMPanel.setLayout(null);
      
      this.getContentPane().add(OMPanel);
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
      
      setTitle("Registrar Mantenimiento");
            
      JLabel reporteT = new JLabel("Reporte");
      reporteT .setBounds(300,25,150,30);
      reporte = new JTextArea();
      reporte.setBounds(300, 50, 340, 320);
      OMPanel.add(reporte);
      OMPanel.add(reporteT);
      
      JLabel idProveedorT= new JLabel("Proveedor");
      idProveedorT.setBounds(50,25,150,30);
      Conection CP = new Conection();
      idProveedor = new JComboBox(CP.conseguirArreglo("proveedores","nombre"));
      idProveedor.setBounds(50, 50, 200,30);
      OMPanel.add(idProveedorT);
      OMPanel.add(idProveedor);
      
      JLabel idVehiculoT= new JLabel("Vehiculo");
      idVehiculoT.setBounds(50, 75, 150, 30);
      idVehiculo = new JComboBox(CP.conseguirArreglo("vehiculos","nombre_vehiculo"));
      idVehiculo.setBounds(50, 100, 200, 30);
      OMPanel.add(idVehiculo);
      OMPanel.add(idVehiculoT);
      
      JLabel mantenimientoT= new JLabel("Mantenimiento o Reparacion");
      mantenimientoT.setBounds(50, 125, 200, 30);
      mantenimiento = new JTextField();
      mantenimiento.setBounds(50, 150, 200, 30);
      OMPanel.add(mantenimientoT);
      OMPanel.add(mantenimiento);
      
      JLabel costoT= new JLabel("Costo por mano de obra");
      costoT.setBounds(50, 175, 200, 30);
      costo = new JTextField();
      costo.setBounds(50, 200, 200, 30);
      OMPanel.add(costo);
      OMPanel.add(costoT);
            
      JLabel fechaT= new JLabel("Fecha");
      fechaT.setBounds(50, 225, 150, 30);
      fecha = new JTextField();
      fecha.setBounds(50, 250, 200, 30);
      OMPanel.add(fechaT);
      OMPanel.add(fecha);
      
      btnGuardar= new JButton("Guardar");
      btnGuardar.setBounds(50, 360, 80, 30);
      btnGuardar.addActionListener(this);
      OMPanel.add(btnGuardar);
      
      btnVolver= new JButton("Volver");
      btnVolver.setBounds(150, 360, 80, 30);
      btnVolver.addActionListener(this);
      OMPanel.add(btnVolver);


                  //CODIGO KEVIN - INCIA
                  ActionListener eventoRegistrarMoR = new ActionListener(){
                     public void actionPerformed(ActionEvent ae){
                           String vehiculo = (String) idVehiculo.getSelectedItem();
                           
                           String prov = (String) idProveedor.getSelectedItem();
                           Conection CadenaC = new Conection();
                           CadenaC.registrarMan(vehiculo, prov, mantenimiento.getText(), reporte.getText(), Float.parseFloat(costo.getText()), fecha.getText());
                     }
                  };
                  
                     btnGuardar.addActionListener(eventoRegistrarMoR);
               
               
                     //CODIGO KEVIN - Acaba
   }
   public void screenConsultar(){
   
      texto= new JLabel();
      setTitle("Consultar Mantenimientos");
      texto.setText("Opciones de busqueda:");
      texto.setBounds(80, 5, 300, 30);
      OMPanel.add(texto);
      
      btnIdM= new JButton("Busqueda por Id");
      btnIdM.setBounds(130, 45, 200, 30);
      btnIdM.addActionListener(this);
      OMPanel.add(btnIdM);
            
      btnConsultaG= new JButton("Consulta General");
      btnConsultaG.setBounds(340, 45, 200, 30);
      btnConsultaG.addActionListener(this);
      OMPanel.add(btnConsultaG);
      
      btnBuscar= new JButton("Buscar");
      btnBuscar.setBounds(500, 100, 100, 30);
      btnBuscar.setVisible(false);
      btnBuscar.addActionListener(this);
      OMPanel.add(btnBuscar);
 
      busqueda = new JTextField();
      busqueda.setBounds(90, 100, 400, 30);
      busqueda.setVisible(false);
      OMPanel.add(busqueda);
      
      btnVolver= new JButton("Volver");
      btnVolver.setBounds(50, 360, 100, 30);
      btnVolver.addActionListener(this);
      OMPanel.add(btnVolver);

                       //CODIGO KEVIN - INCIA


     ActionListener eventoConsulta = new ActionListener(){
      public void actionPerformed(ActionEvent ae){
            Conection CadenaC = new Conection();
            JTable tabla = CadenaC.consultarMans();
            tabla.setBounds(20, 120, 660,200);
            OMPanel.add(tabla);
            OMPanel.updateUI();
      }
   };

btnConsultaG.addActionListener(eventoConsulta); 



ActionListener eventoConsultaI = new ActionListener(){
   public void actionPerformed(ActionEvent ae){
            Conection CadenaC = new Conection();
            JTable tabla1 = CadenaC.consultarMan(Integer.parseInt(busqueda.getText())); //CAMBIAR MÉTODO
            tabla1.setBounds(70, 170, 600,150);
            OMPanel.add(tabla1);
            OMPanel.updateUI();;
      }
};

btnBuscar.addActionListener(eventoConsultaI); 

//CODIGO KEVIN - ACABA
   }
   public void screenModificar(){
      setTitle("Modificar Mantenimiento");
      
      texto= new JLabel();
      texto.setText("Ingrese Id de Mantenimiento:");
      texto.setBounds(90, 15, 300, 30);
      OMPanel.add(texto);
      
      btnBusquedaM = new JButton("Buscar");
      btnBusquedaM.setBounds(500, 40, 100, 30);
      btnBusquedaM.addActionListener(this);
      OMPanel.add(btnBusquedaM);
      
      busqueda = new JTextField();
      busqueda.setBounds(90, 40, 400, 30);
      OMPanel.add(busqueda);
            
      btnVolver= new JButton("Volver");
      btnVolver.setBounds(150, 360, 80, 30);
      btnVolver.addActionListener(this);
      OMPanel.add(btnVolver);
      
      JLabel idProveedorT= new JLabel("Proveedor");
      idProveedorT.setBounds(50,75,150,30);
      Conection CP = new Conection();
      idProveedor = new JComboBox(CP.conseguirArreglo("proveedores","nombre"));
      idProveedor.setBounds(50, 100, 200,30);
      idProveedor.setEnabled(false);
      OMPanel.add(idProveedorT);
      OMPanel.add(idProveedor);
   
      JLabel reporteT = new JLabel("Reporte");
      reporteT .setBounds(300,75,150,30);
      reporte = new JTextArea();
      reporte.setBounds(300, 100, 340, 320);
      reporte.setEnabled(false);
      OMPanel.add(reporte);
      OMPanel.add(reporteT);
      
      JLabel idVehiculoT= new JLabel("Vehiculo");
      idVehiculoT.setBounds(50, 125, 150, 30);
      idVehiculo = new JComboBox(CP.conseguirArreglo("vehiculos","nombre_vehiculo"));
      idVehiculo.setBounds(50, 150, 200, 30);
      idVehiculo.setEnabled(false);
      OMPanel.add(idVehiculo);
      OMPanel.add(idVehiculoT);
      
      JLabel mantenimientoT= new JLabel("Mantenimiento o Reparacion");
      mantenimientoT.setBounds(50, 175, 200, 30);
      mantenimiento = new JTextField();
      mantenimiento.setBounds(50, 200, 200, 30);
      mantenimiento.setEnabled(false);
      OMPanel.add(mantenimientoT);
      OMPanel.add(mantenimiento);
      
      JLabel costoT= new JLabel("Costo por mano de obra");
      costoT.setBounds(50, 225, 200, 30);
      costo = new JTextField();
      costo.setBounds(50, 250, 200, 30);
      costo.setEnabled(false);
      OMPanel.add(costo);
      OMPanel.add(costoT);
            
      JLabel fechaT= new JLabel("Fecha");
      fechaT.setBounds(50, 275, 150, 30);
      fecha = new JTextField();
      fecha.setBounds(50, 300, 200, 30);
      fecha.setEnabled(false);
      OMPanel.add(fechaT);
      OMPanel.add(fecha);
      
      btnGuardarM= new JButton("Guardar");
      btnGuardarM.setBounds(50, 360, 80, 30);
      btnGuardarM.addActionListener(this);
      btnGuardarM.setEnabled(false);
      OMPanel.add(btnGuardarM);

           //KEVIN - INICIA

      ActionListener modmo = new ActionListener(){
         public void actionPerformed(ActionEvent ae){
               Conection CadenaC = new Conection();
               String car = (String) idVehiculo.getSelectedItem();
               String pr = (String) idProveedor.getSelectedItem();
               CadenaC.modificarM(Integer.parseInt(busqueda.getText()), car, pr, mantenimiento.getText(), reporte.getText(), Float.parseFloat(costo.getText()), fecha.getText());

         }
      };

      ActionListener bring = new ActionListener(){  //EVENTO PARA TRAER LOS DATOS LA INTERFAZ DE MODIFICAR
         public void actionPerformed(ActionEvent ae){
               Conection Cadena = new Conection();
               fecha.setText(Cadena.obtenerMan(Integer.parseInt(busqueda.getText()),1));
               mantenimiento.setText(Cadena.obtenerMan(Integer.parseInt(busqueda.getText()),2));
               reporte.setText(Cadena.obtenerMan(Integer.parseInt(busqueda.getText()),4));
               costo.setText(Cadena.obtenerMan(Integer.parseInt( busqueda.getText()),3));
               for(int x = 0; x <= Cadena.conseguirArreglo("vehiculos", "nombre_vehiculo").length-1;x++){
                     if(Cadena.conseguirArreglo("vehiculos", "nombre_vehiculo")[x].equals(Cadena.obtenerMan(Integer.parseInt(busqueda.getText()),5))){
                           idVehiculo.setSelectedIndex(x);
                     }
               }

               for(int x = 0; x <= Cadena.conseguirArreglo("proveedores", "nombre").length-1;x++){
                  if(  Cadena.conseguirArreglo("proveedores", "nombre")[x].equals(   Cadena.obtenerMan(Integer.parseInt(busqueda.getText()   ),   6)   )  ){
                        idProveedor.setSelectedIndex(x);
                  }
               }
         }
      };
      btnGuardarM.addActionListener(modmo); 
   
      btnBusquedaM.addActionListener(bring);
   
   
         //CODIGO KEVIN - Acaba


      
   }
   public void screenEliminar(){
      setTitle("Eliminar Mantenimiento");
      
      texto= new JLabel();
      texto.setText("Ingrese Id de Mantenimiento:");
      texto.setBounds(90, 35, 300, 30);
      OMPanel.add(texto);
      
      btnBuscarE= new JButton("Buscar");
      btnBuscarE.setBounds(500, 60, 100, 30);
      btnBuscarE.addActionListener(this);
      OMPanel.add(btnBuscarE);
 
      busqueda = new JTextField();
      busqueda.setBounds(90, 60, 400, 30);
      OMPanel.add(busqueda);
      
      btnEliminar= new JButton("Eliminar");
      btnEliminar.setBounds(280, 360, 100, 30);
      btnEliminar.addActionListener(this);
      btnEliminar.setVisible(false);
      OMPanel.add(btnEliminar);
      
      btnCancelar= new JButton("Cancelar");
      btnCancelar.setBounds(390, 360, 100, 30);
      btnCancelar.addActionListener(this);
      btnCancelar.setVisible(false);
      OMPanel.add(btnCancelar);
      
      btnVolver= new JButton("Volver");
      btnVolver.setBounds(50, 360, 100, 30);
      btnVolver.addActionListener(this);
      OMPanel.add(btnVolver);

               //CODIGO KEVIN - INCIA
               ActionListener eventoConsultaM = new ActionListener(){
                  public void actionPerformed(ActionEvent ae){
                        Conection CadenaC = new Conection();
                        JTable tabla = CadenaC.consultarMan(Integer.parseInt(busqueda.getText()));
                        tabla.setBounds(20, 120, 660,200);
                        OMPanel.add(tabla);
                        OMPanel.updateUI();
                  }
            };
      
            btnBuscarE.addActionListener(eventoConsultaM);
      
            ActionListener eventoBorrar = new ActionListener(){
               public void actionPerformed(ActionEvent ae){
                     Conection CadenaC = new Conection();
                     CadenaC.eliminarMoR(Integer.parseInt(busqueda.getText()));
                     OMPanel.updateUI();
               }
            };
            
            btnEliminar.addActionListener(eventoBorrar);
             //CODIGO KEVIN - ACABA
   }
   public void actionPerformed(ActionEvent e){
      
      if(e.getSource() == btnIdM){
         btnBuscar.setVisible(true);
         busqueda.setVisible(true);
         btnConsultaG.setEnabled(false);
      }
      //Eventos de Consulta General de Mantenimientos
      if(e.getSource() == btnConsultaG){
         btnIdM.setEnabled(false);
      }
      //Eventos de Consultar Mantenimientos por Id 
      if(e.getSource() == btnBuscar){
         
      }
      if(e.getSource() == btnVolver){
         GestionarMantenimiento vol = new GestionarMantenimiento();
         vol.setVisible(true);
         setVisible(false);
      }
      //Guardar Registro de Mantenimientos
      if(e.getSource() ==  btnGuardar){
         JOptionPane.showMessageDialog(null, "Se guardaran los datos");	
         costo.setText(null);
         fecha.setText(null);
         reporte.setText(null);
         idVehiculo.setSelectedIndex(0);
         mantenimiento.setText(null);
         idProveedor.setSelectedIndex(0);         
      }
      //Guardar Modificaciones de Mantenimientos
      if(e.getSource() ==  btnGuardarM){
         JOptionPane.showMessageDialog(null, "Se guardaran los datos");	
         costo.setText(null);
         fecha.setText(null);
         busqueda.setText(null);
         reporte.setText(null);
         costo.setEnabled(false);
         fecha.setEnabled(false);
         idProveedor.setEnabled(false);
         idVehiculo.setEnabled(false);
         reporte.setEnabled(false);
         mantenimiento.setEnabled(false);
         btnGuardarM.setEnabled(false);
         idProveedor.setSelectedIndex(0);
         idVehiculo.setSelectedIndex(0);
         mantenimiento.setText(null);
      }
      //Eventos de Eliminar Mantenimientos
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
      //Eventos de Modificar Mantenimientos
      if(e.getSource() == btnBusquedaM){
         costo.setEnabled(true);
         fecha.setEnabled(true);
         idProveedor.setEnabled(true);
         idVehiculo.setEnabled(true);
         mantenimiento.setEnabled(true);
         costo.setEnabled(true);
         fecha.setEnabled(true);
         reporte.setEnabled(true);
         btnGuardarM.setEnabled(true);
         // idProveedor.setSelectedIndex(1);//Colocar la casilla del id de su proveedor
      }
   }
}
