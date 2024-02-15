import javax.swing.*;

public class LoginGui  extends JFrame {
 public LoginGui(){
     super("Apiyo Ind. Login");
     setSize(CommonConstraints.FRAME_SIZE);
     setLocationRelativeTo(null);
     setDefaultCloseOperation(EXIT_ON_CLOSE);
     setResizable(false);
     setLayout(null);

     addGuiComponents();

 }
 private void addGuiComponents(){
     //login image
     JLabel loginImage=CustomTools.loadImage(CommonConstraints.LOGIN_IMAGE_PATH);
     loginImage.setBounds();
 }

}
