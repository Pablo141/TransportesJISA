import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class OpcVehiculo extends JFrame implements ActionListener{
   public int opcion;
   public boolean existe;
   public JPanel OVPanel;
   public JTextField idVehiculo, placa, nombre, numeroSerie, kmLitros,busqueda;
   public JButton btnIdV, btnConsultaG, btnAceptar, btnBuscar, btnBuscarE, btnGuardar, btnEliminar, btnCancelar, btnBusquedaM;
   public String menuModelo[]={"1998", "1999", "2000", "2006"},menuMarca[]={"Ford", "Toyota", "Dodge", "Nissan"}, menuCapacidad[] = {"13", "15", "25", "41"}, menuCilindros[]={"6", "8"};
   public String IdVehiculo[]={"V1","V4","V8","V9","V11"};
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
      
      JLabel cilindrosT= new JLabel("NO° Cilindros");
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
         
      JLabel cilindrosT= new JLabel("NÂ° Cilindros");
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
      
      btnGuardar= new JButton("Guardar");
      btnGuardar.setBounds(360, 360, 100, 30);
      btnGuardar.addActionListener(this);
      btnGuardar.setEnabled(false);
      OVPanel.add(btnGuardar);
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
   }
   public void actionPerformed(ActionEvent e){
      
      if(e.getSource() == btnIdV){
         btnBuscar.setVisible(true);
         busqueda.setVisible(true);
         btnConsultaG.setEnabled(false);
      }
      if(e.getSource() == btnConsultaG){
         btnIdV.setEnabled(false);
         crearTabla();
      }
      if(e.getSource() == btnBuscar){
         buscarId();
         if(existe== true){
            crearTabla();
         }
         else{
            JOptionPane.showMessageDialog(null, "ESTE VEHICULO NO SE ENCUENTRA REGISTRADO");	
            busqueda.setText(null);
         }
      }
      if(e.getSource() == btnAceptar){
         GestionarVehiculos vol = new GestionarVehiculos();
         vol.setVisible(true);
         setVisible(false);
      }
      if(e.getSource() ==  btnGuardar){
         JOptionPane.showMessageDialog(null, "Se guardarÃ¡n los datos");	
         idVehiculo.setText(null);
         placa.setText(null);
         nombre.setText(null);
         kmLitros.setText(null);
         numeroSerie.setText(null);
      }
      if(e.getSource() == btnBuscarE){
         buscarId();
         if(existe== true){
            btnEliminar.setVisible(true);
            btnCancelar.setVisible(true);
            crearTabla();
         }
         else{
            JOptionPane.showMessageDialog(null, "ESTE VEHICULO NO SE ENCUENTRA REGISTRADO");	
            busqueda.setText(null);
         }
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
         buscarId();
         if(existe== true){
            idVehiculo.setEnabled(true);
            placa.setEnabled(true);
            nombre.setEnabled(true);
            kmLitros.setEnabled(true);
            numeroSerie.setEnabled(true);
            btnGuardar.setEnabled(true);
            capacidad.setEnabled(true);
            marca.setEnabled(true);
            modelo.setEnabled(true);
            cilindros.setEnabled(true);
         }
         else{
            JOptionPane.showMessageDialog(null, "ESTE VEHICULO NO SE ENCUENTRA REGISTRADO");	
            busqueda.setText(null);
         }
      }
   }
   public void crearTabla(){
      
   }
   public void buscarId(){
      
      for(int x=0;x<IdVehiculo.length;x++){
         if(IdVehiculo[x].equals(busqueda.getText())){
            existe= true;
            break;
         }
         else
            existe=false;
      }
   }
}
