import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class GestionarProveedores extends JFrame implements ActionListener{
   public JPanel gPPanel;
   public JLabel cartel, imagenProveedor;
   public JButton volver, registrarProveedor, consultarProveedor, modificarProveedor, eliminarProveedor;
   public GestionarProveedores(){
      setResizable(false);
      this.setSize(720, 480);
      setLocationRelativeTo(null);
      setTitle("Gestionar Proveedores");
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      screen();
   }
   public void actionPerformed(ActionEvent event){
      int n=0;
      if(event.getSource() != volver){
      
         if(event.getSource() == registrarProveedor){
            n=1;
         }
         if(event.getSource() == consultarProveedor){
            n=2;
         }
         if(event.getSource() == modificarProveedor){
            n=3;
         }
         if(event.getSource() == eliminarProveedor){
            n=4;
         }
         OpcProveedores opc = new OpcProveedores(n);
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
      gPPanel = new JPanel();
      gPPanel.setLayout(null);
      this.getContentPane().add(gPPanel);
      
      ImageIcon imagenF = new ImageIcon("./Recursos/Imagenes/ImagenProveedor.jpg");
      imagenProveedor = new JLabel();
      imagenProveedor.setBounds(300, 40, 340, 340);
      imagenProveedor.setIcon(new ImageIcon(imagenF.getImage().getScaledInstance(340, 340, Image.SCALE_SMOOTH)));
      gPPanel.add(imagenProveedor);
      
      cartel = new JLabel();
      cartel.setOpaque(true);
      cartel.setText("Proveedores");
      cartel.setBounds(50, 30, 150, 30);
      gPPanel.add(cartel);
      
      registrarProveedor = new JButton("Registrar Proveedor");
      registrarProveedor.setBounds(50, 80, 200, 40);
      gPPanel.add(registrarProveedor);
      registrarProveedor.addActionListener(this);
      
      consultarProveedor = new JButton("Consultar Proveedor");
      consultarProveedor.setBounds(50, 150, 200,40);
      gPPanel.add(consultarProveedor);
      consultarProveedor.addActionListener(this);
      
      modificarProveedor = new JButton("Modificar Proveedor");
      modificarProveedor.setBounds(50, 220, 200, 40);
      gPPanel.add(modificarProveedor);
      modificarProveedor.addActionListener(this);
      
      eliminarProveedor = new JButton("Eliminar Proveedor");
      eliminarProveedor.setBounds(50, 290, 200, 40);
      gPPanel.add(eliminarProveedor);
      eliminarProveedor.addActionListener(this);
      
      volver = new JButton("Volver");
      volver.setBounds(50, 360, 200, 40);
      gPPanel.add(volver);
      volver.addActionListener(this);
   }
}
