import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class OpcProveedores extends JFrame implements ActionListener{
   public int opcion;
   public JPanel OPPanel;
   public JTextField nombre,busqueda,idProveedor,tel;
   public JButton btnIdP, btnConsultaG, btnVolver, btnBuscar, btnBuscarE, btnGuardar,btnGuardarM, btnEliminar, btnCancelar, btnBusquedaM;
   public String menuTservicio[] = {"","Electrico"};
   public JComboBox tServicio;
   public JLabel texto;
   public OpcProveedores(int opc){
      opcion = opc;
      setResizable(false);
      this.setSize(720, 480);
      setLocationRelativeTo(null);
      setTitle(null);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      OPPanel = new JPanel();
      OPPanel.setLayout(null);
      
      this.getContentPane().add(OPPanel);
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
      
      setTitle("Registrar Proveedor");
            
      ImageIcon imagenF = new ImageIcon("./Recursos/Imagenes/ImagenProveedor.jpg");
      JLabel imagenProveedor = new JLabel();
      imagenProveedor.setBounds(300, 40, 340, 340);
      imagenProveedor.setIcon(new ImageIcon(imagenF.getImage().getScaledInstance(340, 340, Image.SCALE_SMOOTH)));
      OPPanel.add(imagenProveedor);

      
      JLabel telT = new JLabel("Numero Telefonico");
      telT.setBounds(50, 95, 150, 30);
      tel = new JTextField();
      tel.setBounds(50, 120, 200, 30);
      OPPanel.add(tel);
      OPPanel.add(telT);
      
      JLabel nombreT = new JLabel("Nombre");
      nombreT.setBounds(50, 155, 150, 30);
      nombre = new JTextField();
      nombre.setBounds(50, 180, 200, 30);
      OPPanel.add(nombre);
      OPPanel.add(nombreT);
            
      JLabel tServicioT = new JLabel("Tipo de Servicio");
      tServicioT.setBounds(50, 215, 150, 30);
      tServicio = new JComboBox(menuTservicio);
      tServicio.setBounds(50, 240, 200, 30);
      OPPanel.add(tServicioT);
      OPPanel.add(tServicio);
      
      btnGuardar = new JButton("Guardar");
      btnGuardar.setBounds(50, 360, 80, 30);
      btnGuardar.addActionListener(this);
      OPPanel.add(btnGuardar);
      
      btnVolver = new JButton("Volver");
      btnVolver.setBounds(150, 360, 80, 30);
      btnVolver.addActionListener(this);
      OPPanel.add(btnVolver);
   }
   public void screenConsultar(){
   
      texto = new JLabel();
      setTitle("Consultar Proveedor");
      texto.setText("Opciones de busqueda:");
      texto.setBounds(80, 5, 300, 30);
      OPPanel.add(texto);
      
      btnIdP = new JButton("Busqueda por Id");
      btnIdP.setBounds(130, 45, 200, 30);
      btnIdP.addActionListener(this);
      OPPanel.add(btnIdP);
            
      btnConsultaG = new JButton("Consulta General");
      btnConsultaG.setBounds(340, 45, 200, 30);
      btnConsultaG.addActionListener(this);
      OPPanel.add(btnConsultaG);
      
      btnBuscar = new JButton("Buscar");
      btnBuscar.setBounds(500, 100, 100, 30);
      btnBuscar.setVisible(false);
      btnBuscar.addActionListener(this);
      OPPanel.add(btnBuscar);
 
      busqueda = new JTextField();
      busqueda.setBounds(90, 100, 400, 30);
      busqueda.setVisible(false);
      OPPanel.add(busqueda);
      
      btnVolver = new JButton("Volver");
      btnVolver.setBounds(50, 360, 100, 30);
      btnVolver.addActionListener(this);
      OPPanel.add(btnVolver);
   }
   public void screenModificar(){
      setTitle("Modificar Proveedor");
      
      texto = new JLabel();
      texto.setText("Ingrese Id de Proveedor:");
      texto.setBounds(90, 35, 300, 30);
      OPPanel.add(texto);
      
      btnBusquedaM = new JButton("Buscar");
      btnBusquedaM.setBounds(500, 60, 100, 30);
      btnBusquedaM.addActionListener(this);
      OPPanel.add(btnBusquedaM);
      
      busqueda = new JTextField();
      busqueda.setBounds(90, 60, 400, 30);
      OPPanel.add(busqueda);
      
      ImageIcon imagenF = new ImageIcon("./Recursos/Imagenes/ImagenProveedor.jpg");
      JLabel imagenProveedor = new JLabel();
      imagenProveedor.setBounds(300, 115, 310, 280);
      imagenProveedor.setIcon(new ImageIcon(imagenF.getImage().getScaledInstance(340, 340, Image.SCALE_SMOOTH)));
      OPPanel.add(imagenProveedor);
      
      btnVolver = new JButton("Volver");
      btnVolver.setBounds(150, 360, 80, 30);
      btnVolver.addActionListener(this);
      OPPanel.add(btnVolver);
         
      JLabel telT = new JLabel("Numero Telefonico");
      telT.setBounds(50, 95, 200, 30);
      tel = new JTextField();
      tel.setBounds(50, 120, 200, 30);
      tel.setEnabled(false);
      OPPanel.add(tel);
      OPPanel.add(telT);
         
      JLabel nombreT = new JLabel("Nombre");
      nombreT.setBounds(50, 155, 200, 30);
      nombre = new JTextField();
      nombre.setBounds(50, 180, 200, 30);
      nombre.setEnabled(false);
      OPPanel.add(nombre);
      OPPanel.add(nombreT);
               
      JLabel tServicioT = new JLabel("Tipo de Servicio");
      tServicioT.setBounds(50, 215, 200, 30);
      tServicio = new JComboBox(menuTservicio);
      tServicio.setBounds(50, 240, 200, 30);
      tServicio.setEnabled(false);
      OPPanel.add(tServicioT);
      OPPanel.add(tServicio);
      
      btnGuardarM = new JButton("Guardar");
      btnGuardarM.setBounds(50, 360, 80, 30);
      btnGuardarM.addActionListener(this);
      btnGuardarM.setEnabled(false);
      OPPanel.add(btnGuardarM);
   }
   public void screenEliminar(){
      setTitle("Eliminar Proveedor");
      
      texto = new JLabel();
      texto.setText("Ingrese Id de Proveedor:");
      texto.setBounds(90, 35, 300, 30);
      OPPanel.add(texto);
      
      btnBuscarE = new JButton("Buscar");
      btnBuscarE.setBounds(500, 60, 100, 30);
      btnBuscarE.addActionListener(this);
      OPPanel.add(btnBuscarE);
 
      busqueda = new JTextField();
      busqueda.setBounds(90, 60, 400, 30);
      OPPanel.add(busqueda);
      
      btnEliminar = new JButton("Eliminar");
      btnEliminar.setBounds(280, 360, 100, 30);
      btnEliminar.addActionListener(this);
      btnEliminar.setVisible(false);
      OPPanel.add(btnEliminar);
      
      btnCancelar = new JButton("Cancelar");
      btnCancelar.setBounds(390, 360, 100, 30);
      btnCancelar.addActionListener(this);
      btnCancelar.setVisible(false);
      OPPanel.add(btnCancelar);
      
      btnVolver = new JButton("Volver");
      btnVolver.setBounds(50, 360, 100, 30);
      btnVolver.addActionListener(this);
      OPPanel.add(btnVolver);
   }
   public void actionPerformed(ActionEvent e){
      
      if(e.getSource() == btnIdP){
         btnBuscar.setVisible(true);
         busqueda.setVisible(true);
         btnConsultaG.setEnabled(false);
      }
      //Eventos de Consulta General de Proveedores
      if(e.getSource() == btnConsultaG){
         btnIdP.setEnabled(false);
      }
      //Eventos de Consultar Proveedor por Id 
      if(e.getSource() == btnBuscar){
         
      }
      if(e.getSource() == btnVolver){
         GestionarProveedores vol = new GestionarProveedores();
         vol.setVisible(true);
         setVisible(false);
      }
      //Guardar Registro de Proveedor
      if(e.getSource() ==  btnGuardar){
         JOptionPane.showMessageDialog(null, "Se guardarÃƒÆ’Ã‚Â¡n los datos");	
         tel.setText(null);
         nombre.setText(null);
         tServicio.setSelectedIndex(0);         
      }
      //Guardar Modificaciones de Proveedor
      if(e.getSource() ==  btnGuardarM){
         JOptionPane.showMessageDialog(null, "Se guardarÃƒÆ’Ã‚Â¡n los datos");	
         tel.setText(null);
         nombre.setText(null);
         busqueda.setText(null);
         tel.setEnabled(false);
         nombre.setEnabled(false);
         btnGuardarM.setEnabled(false);
         tServicio.setEnabled(false);
         tServicio.setSelectedIndex(0);
      }
      //Eventos de Eliminar Proveedor
      if(e.getSource() == btnBuscarE){
         btnEliminar.setVisible(true);
         btnCancelar.setVisible(true);
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
      //Eventos de Modificar Proveedor
      if(e.getSource() == btnBusquedaM){
         tel.setEnabled(true);
         nombre.setEnabled(true);
         btnGuardarM.setEnabled(true);
         tServicio.setEnabled(true);
      }
   }
}
