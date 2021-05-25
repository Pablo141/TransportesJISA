import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class GestionarAgentes extends JFrame implements ActionListener{
   public JPanel gAPanel;
   public JLabel cartel, imagenAgentes;
   public JButton volver, registrarAgente, consultarAgente, modificarAgente, eliminarAgente;
   public GestionarAgentes(){
      setResizable(false);
      this.setSize(720, 480);
      setLocationRelativeTo(null);
      setTitle("Gestionar Agentes");
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      screen();
   }
   public void actionPerformed(ActionEvent event){
      int n=0;
      if(event.getSource() != volver){
      
         if(event.getSource() == registrarAgente){
            n=1;
         }
         if(event.getSource() == consultarAgente){
            n=2;
         }
         if(event.getSource() == modificarAgente){
            n=3;
         }
         if(event.getSource() == eliminarAgente){
            n=4;
         }
         OpcAgentes opc = new OpcAgentes(n);
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
      gAPanel = new JPanel();
      gAPanel.setLayout(null);
      this.getContentPane().add(gAPanel);
      
      ImageIcon imagenF = new ImageIcon("./Recursos/Imagenes/ImagenAgente.jpg");
      imagenAgentes = new JLabel();
      imagenAgentes.setBounds(300, 40, 340, 340);
      imagenAgentes.setIcon(new ImageIcon(imagenF.getImage().getScaledInstance(340, 340, Image.SCALE_SMOOTH)));
      gAPanel.add(imagenAgentes);
      
      cartel = new JLabel();
      cartel.setOpaque(true);
      cartel.setText("Agentes");
      cartel.setBounds(50, 30, 150, 30);
      gAPanel.add(cartel);
      
      registrarAgente = new JButton("Registrar Agente");
      registrarAgente.setBounds(50, 80, 200, 40);
      gAPanel.add(registrarAgente);
      registrarAgente.addActionListener(this);
      
      consultarAgente = new JButton("Consultar Agente");
      consultarAgente.setBounds(50, 150, 200,40);
      gAPanel.add(consultarAgente);
      consultarAgente.addActionListener(this);
      
      modificarAgente = new JButton("Modificar Agente");
      modificarAgente.setBounds(50, 220, 200, 40);
      gAPanel.add(modificarAgente);
      modificarAgente.addActionListener(this);
      
      eliminarAgente = new JButton("Eliminar Agente");
      eliminarAgente.setBounds(50, 290, 200, 40);
      gAPanel.add(eliminarAgente);
      eliminarAgente.addActionListener(this);
      
      volver = new JButton("Volver");
      volver.setBounds(50, 360, 200, 40);
      gAPanel.add(volver);
      volver.addActionListener(this);
   }
}