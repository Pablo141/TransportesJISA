import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class OpcGasto extends JFrame implements ActionListener{
   public int opcion;
   public JPanel OVPanel;
   public JTextField idGasto, fecha, gastoTotal, busqueda;
   public JButton btnIdG, btnConsultaG, btnAceptar, btnBuscar, btnBuscarE, btnGuardar,btnGuardarM, btnEliminar, btnCancelar, btnBusquedaM;
   public String menuFacturado[] = {"","Si", "No"}, menuProovedor[] = {"","Provedor 1", "Provedor 2"}, menuTipoGasto[]={"","Mantenimiento", "Reparacion"};
   public JComboBox proovedor, facturado, tipoGasto;
   public JLabel texto;
   public OpcGasto(int opc){
      opcion=opc;
      setResizable(false);
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
      
      setTitle("Registrar Gasto");
      
      ImageIcon imagenF = new ImageIcon("./Recursos/Imagenes/ImagenGasto.jpg");
      JLabel imagenGasto = new JLabel();
      imagenGasto.setBounds(300, 40, 340, 340);
      imagenGasto.setIcon(new ImageIcon(imagenF.getImage().getScaledInstance(340, 340, Image.SCALE_SMOOTH)));
      OVPanel.add(imagenGasto);
            
      JLabel fechaT= new JLabel("Fecha");
      fechaT.setBounds(50, 35, 200, 30);
      fecha = new JTextField();
      fecha.setBounds(50, 60, 200, 30);
      OVPanel.add(fecha);
      OVPanel.add(fechaT);
      
      JLabel gastoTotalT= new JLabel("Gasto total");
      gastoTotalT.setBounds(50, 95, 200, 30);
      gastoTotal = new JTextField();
      gastoTotal.setBounds(50, 120, 200, 30);
      OVPanel.add(gastoTotal);
      OVPanel.add(gastoTotalT);
      
      JLabel proovedorT = new JLabel("Proveedor");
      proovedorT.setBounds(50, 155, 200, 30);
      proovedor = new JComboBox(menuProovedor);
      proovedor.setBounds(50, 180, 200, 30);
      OVPanel.add(proovedor);
      OVPanel.add(proovedorT);
      
      JLabel facturadoT= new JLabel("Facturado");
      facturadoT.setBounds(50, 215, 200, 30);
      facturado = new JComboBox(menuFacturado);
      facturado.setBounds(50, 240, 200, 30);
      OVPanel.add(facturado);
      OVPanel.add(facturadoT);
      
      JLabel tipoGastoT= new JLabel("Tipo gasto");
      tipoGastoT.setBounds(50, 275, 200, 30);
      tipoGasto = new JComboBox(menuTipoGasto);
      tipoGasto.setBounds(50, 300, 200, 30);
      OVPanel.add(tipoGastoT);
      OVPanel.add(tipoGasto);
      
      btnGuardar= new JButton("Guardar");
      btnGuardar.setBounds(50, 360, 80, 30);
      btnGuardar.addActionListener(this);
      OVPanel.add(btnGuardar);
      
      btnAceptar= new JButton("Volver");
      btnAceptar.setBounds(150, 360, 80, 30);
      btnAceptar.addActionListener(this);
      OVPanel.add(btnAceptar);
   }
   public void screenConsultar(){
   
      texto= new JLabel();
      setTitle("Consultar Gasto");
      texto.setText("Opciones de busqueda:");
      texto.setBounds(80, 5, 300, 30);
      OVPanel.add(texto);
      
      btnIdG= new JButton("Busqueda por Id");
      btnIdG.setBounds(130, 45, 200, 30);
      btnIdG.addActionListener(this);
      OVPanel.add(btnIdG);
            
      btnConsultaG= new JButton("Consulta General");
      btnConsultaG.setBounds(340, 45, 200, 30);
      btnConsultaG.addActionListener(this);
      OVPanel.add(btnConsultaG);
      
      btnBuscar= new JButton("Buscar");
      btnBuscar.setBounds(500, 100, 100, 30);
      btnBuscar.setVisible(false);
      btnBuscar.addActionListener(this);
      OVPanel.add(btnBuscar);
 
      busqueda = new JTextField();
      busqueda.setBounds(90, 100, 400, 30);
      busqueda.setVisible(false);
      OVPanel.add(busqueda);
      
      btnAceptar= new JButton("Volver");
      btnAceptar.setBounds(50, 360, 100, 30);
      btnAceptar.addActionListener(this);
      OVPanel.add(btnAceptar);
   }
   public void screenModificar(){
      setTitle("Modificar Gasto");
      
      texto= new JLabel();
      texto.setText("Ingrese Id de Gasto:");
      texto.setBounds(90, 15, 300, 30);
      OVPanel.add(texto);
      
      btnBusquedaM= new JButton("Buscar");
      btnBusquedaM.setBounds(500, 40, 100, 30);
      btnBusquedaM.addActionListener(this);
      OVPanel.add(btnBusquedaM);
      
      busqueda = new JTextField();
      busqueda.setBounds(90, 40, 400, 30);
      OVPanel.add(busqueda);
      
      ImageIcon imagenF = new ImageIcon("./Recursos/Imagenes/ImagenGasto.jpg");
      JLabel imagenGasto = new JLabel();
      imagenGasto.setBounds(300, 115, 310, 280);
      imagenGasto.setIcon(new ImageIcon(imagenF.getImage().getScaledInstance(340, 340, Image.SCALE_SMOOTH)));
      OVPanel.add(imagenGasto);
      
      btnAceptar= new JButton("Volver");
      btnAceptar.setBounds(150, 360, 80, 30);
      btnAceptar.addActionListener(this);
      OVPanel.add(btnAceptar);
         
      JLabel fechaT= new JLabel("Fecha");
      fechaT.setBounds(50, 75, 150, 30);
      fecha = new JTextField();
      fecha.setBounds(50, 100, 200, 30);
      fecha.setEnabled(false);
      OVPanel.add(fecha);
      OVPanel.add(fechaT);
         
      JLabel gastoTotalT= new JLabel("Gasto total");
      gastoTotalT.setBounds(50, 125, 150, 30);
      gastoTotal = new JTextField();
      gastoTotal.setBounds(50, 150, 200, 30);
      gastoTotal.setEnabled(false);
      OVPanel.add(gastoTotal);
      OVPanel.add(gastoTotalT);
      
      JLabel proovedorT= new JLabel("Proovedor");
      proovedorT.setBounds(50, 175, 150, 30);
      proovedor = new JComboBox(menuProovedor);
      proovedor.setBounds(50, 200, 200, 30);
      proovedor.setEnabled(false);
      OVPanel.add(proovedor);
      OVPanel.add(proovedorT);
         
      JLabel facturadoT= new JLabel("Facturado");
      facturadoT.setBounds(50, 225, 150, 30);
      facturado = new JComboBox(menuFacturado);
      facturado.setBounds(50, 250, 200, 30);
      facturado.setEnabled(false);
      OVPanel.add(facturado);
      OVPanel.add(facturadoT);
         
      JLabel tipoGastoT= new JLabel("Tipo de gasto");
      tipoGastoT.setBounds(50, 275, 150, 30);
      tipoGasto = new JComboBox(menuTipoGasto);
      tipoGasto.setBounds(50, 300,200, 30);
      tipoGasto.setEnabled(false);
      OVPanel.add(tipoGastoT);
      OVPanel.add(tipoGasto);
      
      btnGuardarM= new JButton("Guardar");
      btnGuardarM.setBounds(50, 360, 80, 30);
      btnGuardarM.addActionListener(this);
      btnGuardarM.setEnabled(false);
      OVPanel.add(btnGuardarM);
   }
   public void screenEliminar(){
      setTitle("Eliminar Gasto");
      
      texto= new JLabel();
      texto.setText("Ingrese Id de Gasto:");
      texto.setBounds(90, 35, 300, 30);
      OVPanel.add(texto);
      
      btnBuscarE= new JButton("Buscar");
      btnBuscarE.setBounds(500, 60, 100, 30);
      btnBuscarE.addActionListener(this);
      OVPanel.add(btnBuscarE);
 
      busqueda = new JTextField();
      busqueda.setBounds(90, 60, 400, 30);
      OVPanel.add(busqueda);
      
      btnEliminar= new JButton("Eliminar");
      btnEliminar.setBounds(280, 360, 100, 30);
      btnEliminar.addActionListener(this);
      btnEliminar.setVisible(false);
      OVPanel.add(btnEliminar);
      
      btnCancelar= new JButton("Cancelar");
      btnCancelar.setBounds(390, 360, 100, 30);
      btnCancelar.addActionListener(this);
      btnCancelar.setVisible(false);
      OVPanel.add(btnCancelar);
      
      btnAceptar= new JButton("Volver");
      btnAceptar.setBounds(50, 360, 100, 30);
      btnAceptar.addActionListener(this);
      OVPanel.add(btnAceptar);
   }
   public void actionPerformed(ActionEvent e){
      
      if(e.getSource() == btnIdG){
         btnBuscar.setVisible(true);
         busqueda.setVisible(true);
         btnConsultaG.setEnabled(false);
      }
      //Evento Consulta General de Gastos
      if(e.getSource() == btnConsultaG){
         btnIdG.setEnabled(false);
      }
      //Evento Consulta de Gastos por Id     
      if(e.getSource() == btnBuscar){
         
      }
      if(e.getSource() == btnAceptar){
         GestionarGastos vol = new GestionarGastos();
         vol.setVisible(true);
         setVisible(false);
      }
      //Guarda datos de registro
      if(e.getSource() ==  btnGuardar){
         JOptionPane.showMessageDialog(null, "Se guardardan los datos");	
         fecha.setText(null);
         gastoTotal.setText(null);
         proovedor.setSelectedIndex(0);
         facturado.setSelectedIndex(0);
         tipoGasto.setSelectedIndex(0);
      }
      //Guarda datos Modificados
      if(e.getSource() ==  btnGuardarM){
         JOptionPane.showMessageDialog(null, "Se guardardan los datos");	
         fecha.setText(null);
         gastoTotal.setText(null);
         busqueda.setText(null);
         fecha.setEnabled(false);
         gastoTotal.setEnabled(false);
         btnGuardarM.setEnabled(false);
         proovedor.setEnabled(false);
         facturado.setEnabled(false);
         tipoGasto.setEnabled(false);
         proovedor.setSelectedIndex(0);
         facturado.setSelectedIndex(0);
         tipoGasto.setSelectedIndex(0);
      }
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
      //Eventos de Modificar Vehiculo
      if(e.getSource() == btnBusquedaM){
         fecha.setEnabled(true);
         gastoTotal.setEnabled(true);
         btnGuardarM.setEnabled(true);
         proovedor.setEnabled(true);
         facturado.setEnabled(true);
         tipoGasto.setEnabled(true);
      }
   }
}
