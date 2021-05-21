import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class OpcVehiculo extends JFrame implements ActionListener{
   public int opcion;
   public JPanel OVPanel,panelBtn;
   public JTextField idVehiculo, placa, nombre, modelo, numeroSerie, marca,busqueda;
   public JButton btnIdV,btnPlaca,btnModelo,btnMarca,btnAceptar,btnBuscar;
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
      
      btnIdV= new JButton("Id_Vehiculo");
      btnIdV.setBounds(80, 45,100 ,30);
      btnIdV.addActionListener(this);
      OVPanel.add(btnIdV);
      
      btnPlaca= new JButton("Placa");
      btnPlaca.setBounds(230, 45, 100,30);
      btnPlaca.addActionListener(this);
      OVPanel.add(btnPlaca);
      
      btnModelo= new JButton("Modelo");
      btnModelo.setBounds(380, 45, 100,30);
      btnModelo.addActionListener(this);
      OVPanel.add(btnModelo);
      
      btnMarca= new JButton("Marca");
      btnMarca.setBounds(530, 45, 100,30);
      btnMarca.addActionListener(this);
      OVPanel.add(btnMarca);
      
      btnBuscar= new JButton("Buscar");
      btnBuscar.setBounds(500,100,100,30);
      btnBuscar.setEnabled(false);
      btnBuscar.addActionListener(this);
      OVPanel.add(btnBuscar);
 
      busqueda = new JTextField();
      busqueda.setBounds(90, 100, 400, 30);
      busqueda.setEnabled(false);
      OVPanel.add(busqueda);
      
      btnAceptar= new JButton();
      btnAceptar.setText("Volver");
      btnAceptar.setBounds(315,360,100,30);
      btnAceptar.addActionListener(this);
      OVPanel.add(btnAceptar);
   }
   public void screenModificar(){
      setTitle("Modificar Vehiculo");
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
      
      if(e.getSource() != btnAceptar && e.getSource() != btnBuscar){
      
         if(e.getSource() == btnIdV){
            btnPlaca.setEnabled(false);
            btnModelo.setEnabled(false);
            btnMarca.setEnabled(false);
         }
         if(e.getSource() == btnPlaca){
            btnIdV.setEnabled(false);
            btnModelo.setEnabled(false);
            btnMarca.setEnabled(false);
         }
         if(e.getSource() == btnModelo){
            btnIdV.setEnabled(false);
            btnPlaca.setEnabled(false);
            btnMarca.setEnabled(false);
         }
         if(e.getSource() == btnMarca){
            btnIdV.setEnabled(false);
            btnModelo.setEnabled(false);
            btnPlaca.setEnabled(false);
         }
         btnBuscar.setEnabled(true);
         busqueda.setEnabled(true);
      }
      else{
         if(e.getSource() == btnBuscar){
            crearTabla();
         }
         if(e.getSource() == btnAceptar){
            GestionarVehiculos vol = new GestionarVehiculos();
            vol.setVisible(true);
            setVisible(false);
         }
      }
   }
   public void crearTabla(){
      
   }
}
