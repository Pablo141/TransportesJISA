import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class GestionarMantenimiento extends JFrame implements ActionListener{
   public JPanel gMPanel;
   public JLabel cartel, imagenMantenimiento;
   public JButton volver, registrarMantenimiento, consultarMantenimiento, modificarMantenimiento, eliminarMantenimiento ;
   public GestionarMantenimiento(){
      setResizable(false);
      this.setSize(720, 480);
      setLocationRelativeTo(null);
      setTitle("Gestionar Mantenimientos");
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      screen();
   }
   public void actionPerformed(ActionEvent event){
      int n = 0;
      if(event.getSource() != volver){
      
         if(event.getSource() == registrarMantenimiento){
            n = 1;
         }
         if(event.getSource() == consultarMantenimiento){
            n = 2;
         }
         if(event.getSource() == modificarMantenimiento){
            n = 3;
         }
         if(event.getSource() == eliminarMantenimiento){
            n = 4;
         }
         OpcMantenimiento opc = new OpcMantenimiento(n);
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
      gMPanel = new JPanel();
      gMPanel.setLayout(null);
      this.getContentPane().add(gMPanel);
      
      ImageIcon imagenF = new ImageIcon("./Recursos/Imagenes/ImagenMantenimiento.jpg");
      imagenMantenimiento = new JLabel();
      imagenMantenimiento.setBounds(300, 40, 340, 340);
      imagenMantenimiento.setIcon(new ImageIcon(imagenF.getImage().getScaledInstance(340, 340, Image.SCALE_SMOOTH)));
      gMPanel.add(imagenMantenimiento);
      
      cartel = new JLabel();
      cartel.setOpaque(true);
      cartel.setText("Mantenimientos");
      cartel.setBounds(50, 30, 150, 30);
      gMPanel.add(cartel);
      
      registrarMantenimiento = new JButton("Registrar Mantenimiento");
      registrarMantenimiento.setBounds(50, 80, 200, 40);
      gMPanel.add(registrarMantenimiento);
      registrarMantenimiento.addActionListener(this);
      
      consultarMantenimiento = new JButton("Consultar Mantenimiento");
      consultarMantenimiento.setBounds(50, 150, 200,40);
      gMPanel.add(consultarMantenimiento);
      consultarMantenimiento.addActionListener(this);
      
      modificarMantenimiento = new JButton("Modificar Mantenimiento");
      modificarMantenimiento.setBounds(50, 220, 200, 40);
      gMPanel.add(modificarMantenimiento);
      modificarMantenimiento.addActionListener(this);
      
      eliminarMantenimiento = new JButton("Eliminar Mantenimiento");
      eliminarMantenimiento.setBounds(50, 290, 200, 40);
      gMPanel.add(eliminarMantenimiento);
      eliminarMantenimiento.addActionListener(this);
      
      volver = new JButton("Volver");
      volver.setBounds(50, 360, 200, 40);
      gMPanel.add(volver);
      volver.addActionListener(this);
   }
}
