import custom.TextFieldCustom;

import javax.swing.*;

public class LoginGui  extends JFrame {
    private TextFieldCustom usernameField;
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
     assert loginImage != null;
     loginImage.setBounds((CommonConstraints.FRAME_SIZE.width - loginImage.getPreferredSize().width)/2,
     25, CommonConstraints.LOGIN_IMAGE_SIZE.width,CommonConstraints.LOGIN_IMAGE_SIZE.height
             );
     //Username field
usernameField=new TextFieldCustom("Enter Username", 30);
usernameField.setBounds(50,loginImage.getY() + 315,CommonConstraints.TEXTFIELD_SIZE.width,CommonConstraints.TEXTFIELD_SIZE.height
);
//add to frame
     getContentPane().add(loginImage);
     getContentPane().add(usernameField);
 }

}
