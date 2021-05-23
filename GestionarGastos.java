import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class GestionarGastos extends JFrame implements ActionListener{
   public JPanel gGPanel;
   public JLabel cartel, imagenVehiculo;
   public JButton volver, registrarGasto, consultarGasto, modificarGasto, eliminarGasto;
   public GestionarVehiculos(){
      setResizable(false);
      this.setSize(720, 480);
      setLocationRelativeTo(null);
      setTitle("Gestionar Gastos");
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      screen();
   }
   public void actionPerformed(ActionEvent event){
      int n=0;
      if(event.getSource() != volver){
      
         if(event.getSource() == registrarGasto){
            n=1;
         }
         if(event.getSource() == consultarGasto){
            n=2;
         }
         if(event.getSource() == modificarGasto){
            n=3;
         }
         if(event.getSource() == eliminarVehiculo){
            n=4;
         }
         OpcGasto opc = new OpcGasto(n);
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
      gGPanel = new JPanel();
      gGPanel.setLayout(null);
      this.getContentPane().add(gGPanel);
      
      ImageIcon imagenF = new ImageIcon("./Recursos/Imagenes/ImagenVehiculo.jpeg");
      imagenVehiculo = new JLabel();
      imagenVehiculo.setBounds(300, 40, 340, 340);
      imagenVehiculo.setIcon(new ImageIcon(imagenF.getImage().getScaledInstance(340, 340, Image.SCALE_SMOOTH)));
      gGPanel.add(imagenVehiculo);
      
      cartel = new JLabel();
      cartel.setOpaque(true);
      cartel.setText("Gastos");
      cartel.setBounds(50, 30, 150, 30);
      gGPanel.add(cartel);
      
      registrarGasto = new JButton("Registrar gasto");
      registrarGasto.setBounds(50, 80, 200, 40);
      gGPanel.add(registrarGasto);
      registrarGasto.addActionListener(this);
      
      consultarGasto = new JButton("Consultar gasto");
      consultarGasto.setBounds(50, 150, 200,40);
      gGPanel.add(consultarGasto);
      consultarGasto.addActionListener(this);
      
      modificarGasto = new JButton("Modificar gasto");
      modificarGasto.setBounds(50, 220, 200, 40);
      gGPanel.add(modificarGasto);
      modificarGasto.addActionListener(this);
      
      eliminarGasto = new JButton("Eliminar gasto");
      eliminarGasto.setBounds(50, 290, 200, 40);
      gGPanel.add(eliminarGasto);
      eliminarGasto.addActionListener(this);
      
      volver = new JButton("Volver");
      volver.setBounds(50, 360, 200, 40);
      gGPanel.add(volver);
      volver.addActionListener(this);
   }
}
