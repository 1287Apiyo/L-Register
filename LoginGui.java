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
     loginImage.setBounds((CommonConstraints.FRAME_SIZE.width - loginImage.getPreferredSize().width)/2,
     25, CommonConstraints.LOGIN_IMAGE_SIZE.width,CommonConstraints.LOGIN_IMAGE_SIZE.height
             );
     //Username field

 }

}
