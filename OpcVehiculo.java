import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class OpcVehiculo extends JFrame implements ActionListener{
   public int opcion;
   public JPanel OVPanel;
   public JTextField idVehiculo, placa, nombre, numeroSerie, kmLitros,busqueda;
   public JButton btnIdV, btnConsultaG, btnAceptar, btnBuscar, btnBuscarE, btnGuardar,btnGuardarM, btnEliminar, btnCancelar, btnBusquedaM;
   public String menuModelo[]={"","1998", "1999", "2000", "2006"},menuMarca[]={"","Ford", "Toyota", "Dodge", "Nissan"}, menuCapacidad[] = {"","13", "15", "25", "41"}, menuCilindros[]={"","6", "8"};
   public JComboBox modelo, marca, capacidad, cilindros;
   public JLabel texto;
   public OpcVehiculo(int opc){
      opcion=opc;
      setResizable(false);
      this.setSize(720, 480);
      setLocationRelativeTo(null);
      setTitle(null);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      OVPanel = new JPanel();
      OVPanel.setLayout(null);
      
      this.getContentPane().add(OVPanel);
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
      
      setTitle("Registrar Vehiculo");
      JLabel vehiculo= new JLabel("Id_Vehiculo");
      vehiculo.setBounds(50, 35, 300, 30);
      idVehiculo = new JTextField();
      idVehiculo.setBounds(50, 60, 300, 30);
      OVPanel.add(idVehiculo);
      OVPanel.add(vehiculo);
      
      JLabel placaT= new JLabel("Placa");
      placaT.setBounds(50, 95, 300, 30);
      placa = new JTextField();
      placa.setBounds(50, 120, 300, 30);
      OVPanel.add(placa);
      OVPanel.add(placaT);
      
      JLabel nombreT= new JLabel("Nombre");
      nombreT.setBounds(50, 155, 300, 30);
      nombre = new JTextField();
      nombre.setBounds(50, 180, 300, 30);
      OVPanel.add(nombre);
      OVPanel.add(nombreT);
      
      JLabel kmT= new JLabel("Kilometros por litro");
      kmT.setBounds(50, 215, 300, 30);
      kmLitros = new JTextField();
      kmLitros.setBounds(50, 240, 300, 30);
      OVPanel.add(kmLitros);
      OVPanel.add(kmT);
      
      JLabel numeroST= new JLabel("Numero de serie");
      numeroST.setBounds(50, 275, 300, 30);
      numeroSerie = new JTextField();
      numeroSerie.setBounds(50, 300, 300, 30);
      OVPanel.add(numeroSerie);
      OVPanel.add(numeroST);
      
      JLabel marcaT= new JLabel("Marca");
      marcaT.setBounds(360, 35, 300, 30);
      marca = new JComboBox(menuMarca);
      marca.setBounds(360, 60, 300, 30);
      OVPanel.add(marca);
      OVPanel.add(marcaT);
      
      JLabel modeloT= new JLabel("Modelo");
      modeloT.setBounds(360, 95, 300, 30);
      modelo = new JComboBox(menuModelo);
      modelo.setBounds(360, 120, 300, 30);
      OVPanel.add(modelo);
      OVPanel.add(modeloT);
      
      JLabel cilindrosT= new JLabel("NOÂ° Cilindros");
      cilindrosT.setBounds(360, 155, 300, 30);
      cilindros = new JComboBox(menuCilindros);
      cilindros.setBounds(360, 180, 300, 30);
      OVPanel.add(cilindrosT);
      OVPanel.add(cilindros);
      
      JLabel capacidadT= new JLabel("Capacidad");
      capacidadT.setBounds(360, 215, 300, 30);
      capacidad = new JComboBox(menuCapacidad);
      capacidad.setBounds(360, 240, 300, 30);
      OVPanel.add(capacidadT);
      OVPanel.add(capacidad);
      
      btnGuardar= new JButton("Guardar");
      btnGuardar.setBounds(360, 300, 100, 30);
      btnGuardar.addActionListener(this);
      OVPanel.add(btnGuardar);
      
      btnAceptar= new JButton("Volver");
      btnAceptar.setBounds(50, 360, 100, 30);
      btnAceptar.addActionListener(this);
      OVPanel.add(btnAceptar);

            //CODIGO KEVIN - INCIA
            ActionListener registrarEvent = new ActionListener(){
               public void actionPerformed(ActionEvent ae){
                  int mo = 0, c = 0, m = 0, ca = 0;
                     Conection CadenaC = new Conection();
                     if( marca.getSelectedItem() ==  "Ford"){
                           m = 1;
                     }else if( marca.getSelectedItem() ==  "Toyota"){
                        m = 2;
                     }else if( marca.getSelectedItem() ==  "Dodge"){
                        m = 3;
                     }else if( marca.getSelectedItem() ==  "Nissan"){
                        m = 4;
                     }
                     if(modelo.getSelectedItem() == "1998"){
                           mo = 1;
                     }else if(modelo.getSelectedItem() == "1999"){
                        mo = 2;
                     }if(modelo.getSelectedItem() == "2000"){
                        mo = 3;
                     }else if(modelo.getSelectedItem() == "2006"){
                        mo = 4;
                     }
      
                     if(cilindros.getSelectedItem() == "6"){
                           c = 1;
                     }else if(cilindros.getSelectedItem() == "8"){
                           c = 2;
                     }
      
                     if(capacidad.getSelectedItem() == "13"){
                        ca = 1;
                     }else if(capacidad.getSelectedItem() == "15"){
                        ca = 2;
                     }else if(capacidad.getSelectedItem() == "25"){
                        ca = 3;
                     }else if(capacidad.getSelectedItem() == "41"){
                        ca = 4;
                     }
      
                     // String variable = jComboBox1.getSelectedItem();
                     System.out.println("Se detono el evento");
      
                     CadenaC.registrar(Integer.parseInt(idVehiculo.getText()), nombre.getText(), placa.getText(), numeroSerie.getText(), kmLitros.getText(),mo,c,m,ca);
                     // int id, String nombre, String placas, String num_s, String kmxl, int Id_Modelo, int Id_Cilindro, int Id_Marca, int Id_Capacidad
               }
            };
      
         btnGuardar.addActionListener(registrarEvent); 
      
      
            //CODIGO KEVIN - ACABA
   }
   public void screenConsultar(){
   
      texto= new JLabel();
      setTitle("Consultar Vehiculo");
      texto.setText("Opciones de busqueda:");
      texto.setBounds(80, 5, 300, 30);
      OVPanel.add(texto);
      
      btnIdV= new JButton("Busqueda por Id");
      btnIdV.setBounds(130, 45, 200, 30);
      btnIdV.addActionListener(this);
      OVPanel.add(btnIdV);
            
      btnConsultaG= new JButton("Consulta General");
      btnConsultaG.setBounds(340, 45, 200, 30);
      btnConsultaG.addActionListener(this);
      OVPanel.add(btnConsultaG);
      
      btnBuscar= new JButton("Buscar");
      btnBuscar.setBounds(500, 100, 100, 30);
      btnBuscar.setVisible(false);
      btnBuscar.addActionListener(this);
      OVPanel.add(btnBuscar);
 
      busqueda = new JTextField();
      busqueda.setBounds(90, 100, 400, 30);
      busqueda.setVisible(false);
      OVPanel.add(busqueda);
      
      btnAceptar= new JButton("Volver");
      btnAceptar.setBounds(50, 360, 100, 30);
      btnAceptar.addActionListener(this);
      OVPanel.add(btnAceptar);

                 //CODIGO KEVIN - INCIA


     ActionListener eventoConsulta = new ActionListener(){
      public void actionPerformed(ActionEvent ae){
            Conection CadenaC = new Conection();
            JTable tabla = CadenaC.consultaG();
            tabla.setBounds(20, 120, 660,200);
            OVPanel.add(tabla);
            OVPanel.updateUI();
      }
   };

btnConsultaG.addActionListener(eventoConsulta); 



ActionListener eventoConsultaI = new ActionListener(){
   public void actionPerformed(ActionEvent ae){
            Conection CadenaC = new Conection();
            JTable tabla1 = CadenaC.consultaIndividual(Integer.parseInt(busqueda.getText())); //CAMBIAR MÉTODO
            tabla1.setBounds(70, 170, 600,150);
            OVPanel.add(tabla1);
            OVPanel.updateUI();;
      }
};

btnBuscar.addActionListener(eventoConsultaI); 

//CODIGO KEVIN - ACABA
   }
   public void screenModificar(){
      setTitle("Modificar Vehiculo");
      
      texto= new JLabel();
      texto.setText("Ingrese Id de Vehiculo:");
      texto.setBounds(90, 35, 300, 30);
      OVPanel.add(texto);
      
      btnBusquedaM= new JButton("Buscar");
      btnBusquedaM.setBounds(500, 60, 100, 30);
      btnBusquedaM.addActionListener(this);
      OVPanel.add(btnBusquedaM);
      
      busqueda = new JTextField();
      busqueda.setBounds(90, 60, 400, 30);
      OVPanel.add(busqueda);
      
      btnAceptar= new JButton("Volver");
      btnAceptar.setBounds(50, 360, 100, 30);
      btnAceptar.addActionListener(this);
      OVPanel.add(btnAceptar);
         
      JLabel placaT= new JLabel("Placa");
      placaT.setBounds(50, 95, 300, 30);
      placa = new JTextField();
      placa.setBounds(50, 120, 300, 30);
      placa.setEnabled(false);
      OVPanel.add(placa);
      OVPanel.add(placaT);
         
      JLabel nombreT= new JLabel("Nombre");
      nombreT.setBounds(50, 155, 300, 30);
      nombre = new JTextField();
      nombre.setBounds(50, 180, 300, 30);
      nombre.setEnabled(false);
      OVPanel.add(nombre);
      OVPanel.add(nombreT);
         
      JLabel kmT= new JLabel("Kilometros por litro");
      kmT.setBounds(50, 215, 300, 30);
      kmLitros = new JTextField();
      kmLitros.setBounds(50, 240, 300, 30);
      kmLitros.setEnabled(false);
      OVPanel.add(kmLitros);
      OVPanel.add(kmT);
         
      JLabel numeroST= new JLabel("Numero de serie");
      numeroST.setBounds(50, 275, 300, 30);
      numeroSerie = new JTextField();
      numeroSerie.setBounds(50, 300, 300, 30);
      numeroSerie.setEnabled(false);
      OVPanel.add(numeroSerie);
      OVPanel.add(numeroST);
         
      JLabel marcaT= new JLabel("Marca");
      marcaT.setBounds(360, 95, 300, 30);
      marca = new JComboBox(menuMarca);
      marca.setBounds(360, 120, 300, 30);
      marca.setEnabled(false);
      OVPanel.add(marca);
      OVPanel.add(marcaT);
         
      JLabel modeloT= new JLabel("Modelo");
      modeloT.setBounds(360, 155, 300, 30);
      modelo = new JComboBox(menuModelo);
      modelo.setBounds(360, 180, 300, 30);
      modelo.setEnabled(false);
      OVPanel.add(modelo);
      OVPanel.add(modeloT);
         
      JLabel cilindrosT= new JLabel("No° Cilindros");
      cilindrosT.setBounds(360, 215, 300, 30);
      cilindros = new JComboBox(menuCilindros);
      cilindros.setBounds(360, 240, 300, 30);
      cilindros.setEnabled(false);
      OVPanel.add(cilindrosT);
      OVPanel.add(cilindros);
         
      JLabel capacidadT= new JLabel("Capacidad");
      capacidadT.setBounds(360, 275, 300, 30);
      capacidad = new JComboBox(menuCapacidad);
      capacidad.setBounds(360, 300, 300, 30);
      capacidad.setEnabled(false);
      OVPanel.add(capacidadT);
      OVPanel.add(capacidad);
      
      btnGuardarM= new JButton("Guardar");
      btnGuardarM.setBounds(360, 360, 100, 30);
      btnGuardarM.addActionListener(this);
      btnGuardarM.setEnabled(false);
      OVPanel.add(btnGuardarM);

               //CODIGO KEVIN - INCIA

               ActionListener eventoModificar = new ActionListener(){
                  public void actionPerformed(ActionEvent ae){
         
                     int mo = 0, c = 0, m = 0, ca = 0;
                     if( marca.getSelectedItem() ==  "Ford"){
                           m = 1;
                     }else if( marca.getSelectedItem() ==  "Toyota"){
                        m = 2;
                     }else if( marca.getSelectedItem() ==  "Dodge"){
                        m = 3;
                     }else if( marca.getSelectedItem() ==  "Nissan"){
                        m = 4;
                     }
                     if(modelo.getSelectedItem() == "1998"){
                        mo = 1;
                     }else if(modelo.getSelectedItem() == "1999"){
                        mo = 2;
                     }if(modelo.getSelectedItem() == "2000"){
                        mo = 3;
                     }else if(modelo.getSelectedItem() == "2006"){
                        mo = 4;
                     }
         
                     if(cilindros.getSelectedItem() == "6"){
                           c = 1;
                     }else if(cilindros.getSelectedItem() == "8"){
                           c = 2;
                     }
         
                     if(capacidad.getSelectedItem() == "13"){
                        ca = 1;
                     }else if(capacidad.getSelectedItem() == "15"){
                        ca = 2;
                     }else if(capacidad.getSelectedItem() == "25"){
                        ca = 3;
                     }else if(capacidad.getSelectedItem() == "41"){
                        ca = 4;
                     }
                        Conection CadenaC = new Conection();
                        CadenaC.modificarVehiculos(Integer.parseInt(busqueda.getText()), nombre.getText(), placa.getText(), numeroSerie.getText(), kmLitros.getText(),mo,c,m,ca); //CAMBIAR MÉTODO
                  }
         
               };
         
            btnGuardarM.addActionListener(eventoModificar); 
         
         
               ActionListener mostrar = new ActionListener(){  //EVENTO PARA TRAER LOS DATOS LA INTERFAZ DE MODIFICAR
                     public void actionPerformed(ActionEvent ae){
                           String mar = "", cil = "", cap = "", mod = ""; 
                           Conection Cadena = new Conection();
                           // System.out.println(Cadena.vehiculoNombre(Integer.parseInt(busqueda.getText())).toString());
                           nombre.setText(Cadena.vehiculoObtener(Integer.parseInt(busqueda.getText()),1)); //Cuadro de texto de búsqueda
                           placa.setText(Cadena.vehiculoObtener(Integer.parseInt(busqueda.getText()),2));
                           numeroSerie.setText(Cadena.vehiculoObtener(Integer.parseInt(busqueda.getText()),4)); 
                           kmLitros.setText(Cadena.vehiculoObtener(Integer.parseInt(busqueda.getText()),3));
         
                           for(int x = 0; x < menuMarca.length; x++){
                                 if(menuMarca[x].equals(Cadena.vehiculoObtener(Integer.parseInt(busqueda.getText()),6)))   
                                       marca.setSelectedIndex(x);                        
                           }
         
                           for(int x = 0; x < menuCapacidad.length; x++)
                                 if(menuCapacidad[x].equals(Cadena.vehiculoObtener(Integer.parseInt(busqueda.getText()),9)))   
                                       capacidad.setSelectedIndex(x);                        
               
                           System.out.println(Cadena.vehiculoObtener(Integer.parseInt(busqueda.getText()),7));
                           for(int x = 0; x < menuCilindros.length; x++)
                                 if(menuCilindros[x].equals(Cadena.vehiculoObtener(Integer.parseInt(busqueda.getText()),7)))   
                                       cilindros.setSelectedIndex(x);                        
         
                           for(int x = 0; x < menuModelo.length; x++)
                                 if(menuModelo[x].equals(Cadena.vehiculoObtener(Integer.parseInt(busqueda.getText()),8)))   
                                       modelo.setSelectedIndex(x);                        
                           
                           OVPanel.updateUI();
                     }
               };
            btnBusquedaM.addActionListener(mostrar); 
         
                     //CODIGO KEVIN - ACABA

   }

   public void screenEliminar(){
      setTitle("Eliminar Vehiculo");
      
      texto= new JLabel();
      texto.setText("Ingrese Id de Vehiculo:");
      texto.setBounds(90, 35, 300, 30);
      OVPanel.add(texto);
      
      btnBuscarE= new JButton("Buscar");
      btnBuscarE.setBounds(500, 60, 100, 30);
      btnBuscarE.addActionListener(this);
      OVPanel.add(btnBuscarE);
 
      busqueda = new JTextField();
      busqueda.setBounds(90, 60, 400, 30);
      OVPanel.add(busqueda);
      
      btnEliminar= new JButton("Eliminar");
      btnEliminar.setBounds(280, 360, 100, 30);
      btnEliminar.addActionListener(this);
      btnEliminar.setVisible(false);
      OVPanel.add(btnEliminar);
      
      btnCancelar= new JButton("Cancelar");
      btnCancelar.setBounds(390, 360, 100, 30);
      btnCancelar.addActionListener(this);
      btnCancelar.setVisible(false);
      OVPanel.add(btnCancelar);
      
      btnAceptar= new JButton("Volver");
      btnAceptar.setBounds(50, 360, 100, 30);
      btnAceptar.addActionListener(this);
      OVPanel.add(btnAceptar);

            //CODIGO KEVIN - INCIA
            ActionListener eventoConsultaI = new ActionListener(){
               public void actionPerformed(ActionEvent ae){
                     Conection CadenaC = new Conection();
                     JTable tabla1 = CadenaC.consultaIndividual(Integer.parseInt(busqueda.getText())); //CAMBIAR MÉTODO
                     tabla1.setBounds(70, 170, 600,150);
                     OVPanel.add(tabla1);
                     OVPanel.updateUI();
               }
            };
                     
         btnBuscarE.addActionListener(eventoConsultaI); 
   
         ActionListener eventoEliminar = new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                  Conection CadenaC = new Conection();
                  CadenaC.eliminar(Integer.parseInt(busqueda.getText())); //CAMBIAR MÉTODO
            }
         };
               
         btnEliminar.addActionListener(eventoEliminar);
   
         // CODIGO KEVIN - ACABA
   
   
   }
   public void actionPerformed(ActionEvent e){
      
      if(e.getSource() == btnIdV){
         btnBuscar.setVisible(true);
         busqueda.setVisible(true);
         btnConsultaG.setEnabled(false);
      }
      //Eventos Consulta General Vehiculo
      if(e.getSource() == btnConsultaG){
         btnIdV.setEnabled(false);
      }
      //Eventos de Consultar Vehiculo por Id
      if(e.getSource() == btnBuscar){
         
      }
      if(e.getSource() == btnAceptar){
         GestionarVehiculos vol = new GestionarVehiculos();
         vol.setVisible(true);
         setVisible(false);
      }
      //Guarda datos de registro
      if(e.getSource() ==  btnGuardar){
         JOptionPane.showMessageDialog(null, "Se guardaran los datos");	
         idVehiculo.setText(null);
         placa.setText(null);
         nombre.setText(null);
         kmLitros.setText(null);
         numeroSerie.setText(null);
         marca.setSelectedIndex(0);
         modelo.setSelectedIndex(0);
         capacidad.setSelectedIndex(0);
         cilindros.setSelectedIndex(0);
      }
      //Guarda datos de modificacion
      if(e.getSource() ==  btnGuardarM){
         JOptionPane.showMessageDialog(null, "Se guardaran los datos");	
         placa.setText(null);
         nombre.setText(null);
         kmLitros.setText(null);
         numeroSerie.setText(null);
         busqueda.setText(null);
         placa.setEnabled(false);
         nombre.setEnabled(false);
         kmLitros.setEnabled(false);
         numeroSerie.setEnabled(false);
         capacidad.setEnabled(false);
         marca.setEnabled(false);
         modelo.setEnabled(false);
         cilindros.setEnabled(false);         
         btnGuardarM.setEnabled(false);
         marca.setSelectedIndex(0);
         modelo.setSelectedIndex(0);
         capacidad.setSelectedIndex(0);
         cilindros.setSelectedIndex(0);
      }
      //Eventos de Eliminar Vehiculo
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
      //Eventos de Modificar Vehiculo
      if(e.getSource() == btnBusquedaM){
         placa.setEnabled(true);
         nombre.setEnabled(true);
         kmLitros.setEnabled(true);
         numeroSerie.setEnabled(true);
         btnGuardarM.setEnabled(true);
         capacidad.setEnabled(true);
         marca.setEnabled(true);
         modelo.setEnabled(true);
         cilindros.setEnabled(true);
      }
   }
}
