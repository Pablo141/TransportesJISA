import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class Login extends JFrame implements ActionListener{
    Inicio in = new Inicio();
    /*
    Diccionario de variables
    userM = usurio guardado en memoria
    passM = contrasena guardada en memoria
    userI = usuario ingresado
    passI = contrasena ingresada
    */
    public JPanel loginPanel;
    public JTextField userTextField;
    public JPasswordField passJPass;
    public JLabel userLabel, passLabel, porfilePic;
    public JButton loginButton;
    public String userM = "Transportes", passM = "JISA", userI, passI;
    public Login(){
        setResizable(false);
        this.setSize(415, 315);
        setLocationRelativeTo(null);
        setTitle("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        screen();
    }//Elementos de la ventana
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == loginButton){
            userI = userTextField.getText();
            passI = new String(passJPass.getPassword());
            if(userI.equals(userM) && passI.equals(passM)){
                in.setVisible(true);
                setVisible(false);
            }//Comprobacion de que ambos datos son correctos
            else{
               if(userI.equals(userM)){
                  JOptionPane.showMessageDialog(null, "La contrasena es incorrecta");
               }
               else{
                  JOptionPane.showMessageDialog(null, "Las credenciales son incorrectas");
               }
            }//Comprobacion de que dato es incorrecto
        }
    }//Eventos
    
    public void screen(){
        loginPanel = new JPanel();
        loginPanel.setLayout(null);
        this.getContentPane().add(loginPanel);
        
        ImageIcon porfile = new ImageIcon("./Recursos/Imagenes/ImagenLogin.jpg");
        porfilePic = new JLabel();
        porfilePic.setBounds(150, 10, 100, 60);
        porfilePic.setIcon(new ImageIcon(porfile.getImage().getScaledInstance(100, 60, Image.SCALE_SMOOTH)));
        loginPanel.add(porfilePic);
        
        userLabel = new JLabel();
        userLabel.setOpaque(true);
        userLabel.setText("user");
        userLabel.setBounds(20, 60, 360, 30);
        loginPanel.add(userLabel);
        
        passLabel = new JLabel();
        passLabel.setOpaque(true);
        passLabel.setText("pass");
        passLabel.setBounds(20, 140, 360, 30);
        loginPanel.add(passLabel);
        
        userTextField = new JTextField();
        userTextField.setBounds(20, 100, 360, 30);
        loginPanel.add(userTextField);
        
        passJPass = new JPasswordField();
        passJPass.setBounds(20, 180, 360, 30);
        loginPanel.add(passJPass);
        
        loginButton = new JButton("Login");
        loginButton.setBounds(150, 220, 100, 40);
        loginPanel.add(loginButton);
        loginButton.addActionListener(this);
    }//Elementos de panel
}
