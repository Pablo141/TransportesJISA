import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class Inicio extends JFrame implements ActionListener{
   GestionarVehiculos GV = new GestionarVehiculos();
   public JPanel inicioPanel;
   public JButton gVehiculos, gMantenimientos, gGastos, gProveedores, gAgentes,gSalir;
   public JLabel elijaOpc, imagen;
   public Inicio(){
      setResizable(false);
      this.setSize(720, 480);
      setLocationRelativeTo(null);
      setTitle("Inicio");
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      screen();
   }//atributos de la ventana de inicio
   public void actionPerformed(ActionEvent event){
      if(event.getSource() == gVehiculos){
         GV.setVisible(true);
         setVisible(false);
      }
      if(event.getSource() == gMantenimientos){
         
      }
      if(event.getSource() == gGastos){
         
      }
      if(event.getSource() == gProveedores){
         
      }
      if(event.getSource() == gAgentes){
         
      }
      if(event.getSource() == gSalir){
         System.exit(0);
      }
   }//eventos de la ventana de inicio
   public void screen(){
      inicioPanel = new JPanel();
      inicioPanel.setLayout(null);
      this.getContentPane().add(inicioPanel);
      
      elijaOpc = new JLabel();
      elijaOpc.setOpaque(true);
      elijaOpc.setText("Elija una opcion");
      elijaOpc.setBounds(50, 30, 150, 30);
      inicioPanel.add(elijaOpc);
      
      ImageIcon imagenF = new ImageIcon("./Recursos/Imagenes/ImagenInicio.jpg");
      imagen = new JLabel();
      imagen.setBounds(300, 40, 340, 340);
      imagen.setIcon(new ImageIcon(imagenF.getImage().getScaledInstance(340, 340, Image.SCALE_SMOOTH)));
      inicioPanel.add(imagen);
      /*
      Botones
      */
      
      gVehiculos = new JButton("Gestionar Vehiculos");
      gVehiculos.setBounds(50, 70, 200, 40);
      inicioPanel.add(gVehiculos);
      gVehiculos.addActionListener(this);
      
      gMantenimientos = new JButton("Gestionar Mantenimientos");
      gMantenimientos.setBounds(50, 130, 200,40);
      inicioPanel.add(gMantenimientos);
      gMantenimientos.addActionListener(this);
      
      gGastos = new JButton("Gestionar Gastos");
      gGastos.setBounds(50, 190, 200, 40);
      inicioPanel.add(gGastos);
      gGastos.addActionListener(this);
      
      gProveedores = new JButton("Gestionar Provedores");
      gProveedores.setBounds(50, 250, 200, 40);
      inicioPanel.add(gProveedores);
      gProveedores.addActionListener(this);
      
      gAgentes = new JButton("Gestionar Agentes");
      gAgentes.setBounds(50, 310, 200, 40);
      inicioPanel.add(gAgentes);
      gAgentes.addActionListener(this);
      
      gSalir = new JButton("Salir");
      gSalir.setBounds(50,370,200,40);
      inicioPanel.add(gSalir);
      gSalir.addActionListener(this);
   }
}
