import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class OpcVehiculo extends JFrame implements ActionListener{
   public int opcion;
   public JPanel OVPanel,panelBtn;
   public JTextField idVehiculo, placa, nombre, modelo, numeroSerie, marca,busqueda;
   public JButton btnIdV,btnConsultaG,btnAceptar,btnBuscar;
   public OpcVehiculo(int opc){
      opcion=opc;
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
      idVehiculo = new JTextField();
      idVehiculo.setBounds(50, 60, 300, 30);
      OVPanel.add(idVehiculo);
      
      placa = new JTextField();
      placa.setBounds(50, 120, 300, 30);
      OVPanel.add(placa);
      
      nombre = new JTextField();
      nombre.setBounds(50, 180, 300, 30);
      OVPanel.add(nombre);
      
      modelo = new JTextField();
      modelo.setBounds(50, 240, 300, 30);
      OVPanel.add(modelo);
      
      numeroSerie = new JTextField();
      numeroSerie.setBounds(50, 300, 300, 30);
      OVPanel.add(numeroSerie);
      
      marca = new JTextField();
      marca.setBounds(50, 360, 300, 30);
      OVPanel.add(marca);
      
      btnAceptar= new JButton();
      btnAceptar.setText("Volver");
      btnAceptar.setBounds(315,360,100,30);
      btnAceptar.addActionListener(this);
      OVPanel.add(btnAceptar);
   }
   public void screenConsultar(){
   
      JLabel texto= new JLabel();
      setTitle("Consultar Vehiculo");
      texto.setText("Opciones de busqueda:");
      texto.setBounds(80, 5, 300, 30);
      OVPanel.add(texto);
      
      btnIdV= new JButton("Busqueda por Id");
      btnIdV.setBounds(130, 45,200 ,30);
      btnIdV.addActionListener(this);
      OVPanel.add(btnIdV);
            
      btnConsultaG= new JButton("Consulta General");
      btnConsultaG.setBounds(340, 45,200 ,30);
      btnConsultaG.addActionListener(this);
      OVPanel.add(btnConsultaG);
      
      btnBuscar= new JButton("Buscar");
      btnBuscar.setBounds(500,100,100,30);
      btnBuscar.setVisible(false);
      btnBuscar.addActionListener(this);
      OVPanel.add(btnBuscar);
 
      busqueda = new JTextField();
      busqueda.setBounds(90, 100, 400, 30);
      busqueda.setVisible(false);
      OVPanel.add(busqueda);
      
      btnAceptar= new JButton();
      btnAceptar.setText("Volver");
      btnAceptar.setBounds(315,360,100,30);
      btnAceptar.addActionListener(this);
      OVPanel.add(btnAceptar);
   }
   public void screenModificar(){
      setTitle("Registrar Vehiculo");
      idVehiculo = new JTextField();
      idVehiculo.setBounds(50, 60, 300, 30);
      OVPanel.add(idVehiculo);
      
      placa = new JTextField();
      placa.setBounds(50, 120, 300, 30);
      OVPanel.add(placa);  
      
      btnAceptar= new JButton();
      btnAceptar.setText("Volver");
      btnAceptar.setBounds(315,360,100,30);
      btnAceptar.addActionListener(this);
      OVPanel.add(btnAceptar);
   }
   public void screenEliminar(){
      setTitle("Registrar Vehiculo");
      idVehiculo = new JTextField();
      idVehiculo.setBounds(50, 60, 300, 30);
      OVPanel.add(idVehiculo);
      
      placa = new JTextField();
      placa.setBounds(50, 120, 300, 30);
      OVPanel.add(placa);
      
      nombre = new JTextField();
      nombre.setBounds(50, 180, 300, 30);
      OVPanel.add(nombre);
      
      btnAceptar= new JButton();
      btnAceptar.setText("Volver");
      btnAceptar.setBounds(315,360,100,30);
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
      if(e.getSource() == btnBuscar&& busqueda!= null){
            crearTabla();
      }
      if(e.getSource() == btnAceptar){
         GestionarVehiculos vol = new GestionarVehiculos();
         vol.setVisible(true);
         setVisible(false);
      }
   }
   public void crearTabla(){
      
   }
}
