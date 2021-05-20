import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class GestionarVehiculos extends JFrame implements ActionListener{
   OpcVehiculo opc = new OpcVehiculo();
   public JPanel gVPanel;
   public JLabel cartel, imagenVehiculo;
   public JButton volver, registrarVehiculo, consultarVehiculo, modificarVehiculo, eliminarVehiculo;
   public GestionarVehiculos(){
      this.setSize(720, 480);
      setLocationRelativeTo(null);
      setTitle("Gestionar Vehiculos");
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      screen();
   }
   public void actionPerformed(ActionEvent event){
      if(event.getSource() == registrarVehiculo){
         opc.opcion=1;
         opc.setVisible(true);
         setVisible(false);
      }
      if(event.getSource() == consultarVehiculo){
         opc.opcion=2;
         opc.setVisible(true);
         setVisible(false);
      }
      if(event.getSource() == modificarVehiculo){
         
      }
      if(event.getSource() == eliminarVehiculo){
         
      }
      if(event.getSource() == volver){
         Inicio vol = new Inicio();
         vol.setVisible(true);
         setVisible(false);
      }
   }
   public void screen(){
      gVPanel = new JPanel();
      gVPanel.setLayout(null);
      this.getContentPane().add(gVPanel);
      
      ImageIcon imagenF = new ImageIcon("./Recursos/Imagenes/ImagenVehiculo.jpeg");
      imagenVehiculo = new JLabel();
      imagenVehiculo.setBounds(300, 40, 340, 340);
      imagenVehiculo.setIcon(new ImageIcon(imagenF.getImage().getScaledInstance(340, 340, Image.SCALE_SMOOTH)));
      gVPanel.add(imagenVehiculo);
      
      cartel = new JLabel();
      cartel.setOpaque(true);
      cartel.setText("Vehiculos");
      cartel.setBounds(50, 30, 150, 30);
      gVPanel.add(cartel);
      
      registrarVehiculo = new JButton("Registrar vehiculo");
      registrarVehiculo.setBounds(50, 80, 200, 40);
      gVPanel.add(registrarVehiculo);
      registrarVehiculo.addActionListener(this);
      
      consultarVehiculo = new JButton("Consultar vehiculo");
      consultarVehiculo.setBounds(50, 150, 200,40);
      gVPanel.add(consultarVehiculo);
      consultarVehiculo.addActionListener(this);
      
      modificarVehiculo = new JButton("Consultar vehiculo");
      modificarVehiculo.setBounds(50, 220, 200, 40);
      gVPanel.add(modificarVehiculo);
      modificarVehiculo.addActionListener(this);
      
      eliminarVehiculo = new JButton("Eliminar vehiculo");
      eliminarVehiculo.setBounds(50, 290, 200, 40);
      gVPanel.add(eliminarVehiculo);
      eliminarVehiculo.addActionListener(this);
      
      volver = new JButton("Volver");
      volver.setBounds(50, 360, 100, 40);
      gVPanel.add(volver);
      volver.addActionListener(this);
   }
}
