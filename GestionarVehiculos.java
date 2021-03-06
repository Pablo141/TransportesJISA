import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class GestionarVehiculos extends JFrame implements ActionListener{
   public JPanel gVPanel;
   public JLabel cartel, imagenVehiculo;
   public JButton volver, registrarVehiculo, consultarVehiculo, modificarVehiculo, eliminarVehiculo;
   public GestionarVehiculos(){
      setResizable(false);
      this.setSize(720, 480);
      setLocationRelativeTo(null);
      setTitle("Gestionar Vehiculos");
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      screen();
   }
   public void actionPerformed(ActionEvent event){
      int n = 0;
      if(event.getSource() != volver){
      
         if(event.getSource() == registrarVehiculo){
            n = 1;
         }
         if(event.getSource() == consultarVehiculo){
            n = 2;
         }
         if(event.getSource() == modificarVehiculo){
            n = 3;
         }
         if(event.getSource() == eliminarVehiculo){
            n = 4;
         }
         OpcVehiculo opc = new OpcVehiculo(n);
         opc.setVisible(true);
         setVisible(false);
      }
      else{
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
      
      modificarVehiculo = new JButton("Modificar vehiculo");
      modificarVehiculo.setBounds(50, 220, 200, 40);
      gVPanel.add(modificarVehiculo);
      modificarVehiculo.addActionListener(this);
      
      eliminarVehiculo = new JButton("Eliminar vehiculo");
      eliminarVehiculo.setBounds(50, 290, 200, 40);
      gVPanel.add(eliminarVehiculo);
      eliminarVehiculo.addActionListener(this);
      
      volver = new JButton("Volver");
      volver.setBounds(50, 360, 200, 40);
      gVPanel.add(volver);
      volver.addActionListener(this);
   }
}
