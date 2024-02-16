import custom.PasswordFieldCustom;
import custom.TextFieldCustom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGui  extends JFrame implements ActionListener {
    private TextFieldCustom usernameField;

    private PasswordFieldCustom passwordField;
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
     JLabel loginImage = CustomTools.loadImage(CommonConstraints.LOGIN_IMAGE_PATH);
     loginImage.setBounds(
             (CommonConstraints.FRAME_SIZE.width - loginImage.getPreferredSize().width)/2,
             25,
             CommonConstraints.LOGIN_IMAGE_SIZE.width, CommonConstraints.LOGIN_IMAGE_SIZE.height
     );
     //Username field
     usernameField = new TextFieldCustom("Enter Username", 30);
usernameField.setBounds(50,loginImage.getY() + 315,CommonConstraints.TEXTFIELD_SIZE.width,CommonConstraints.TEXTFIELD_SIZE.height
);

     // password field
     passwordField=new PasswordFieldCustom("Enter Password",30);
     passwordField.setBounds(50,usernameField.getY() + 100,
             CommonConstraints.TEXTFIELD_SIZE.width, CommonConstraints.TEXTFIELD_SIZE.height);

     //login button
     JButton loginButton =new JButton("Login");
     loginButton.setBounds(50,
             passwordField.getY() + 100,
             CommonConstraints.BUTTON_SIZE.width,CommonConstraints.BUTTON_SIZE.height
        );
      loginButton.addActionListener(this);
     //login-> register label
     JLabel registerLabel=new JLabel("Not Registered? Click here!");
     registerLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
     registerLabel.setBounds((CommonConstraints.FRAME_SIZE.width - registerLabel.getPreferredSize().width )/2,
             loginButton.getY() + 100,
             registerLabel.getPreferredSize().width,registerLabel.getPreferredSize().height
             );

     //add to frame
     getContentPane().add(loginImage);
     getContentPane().add(usernameField);
     getContentPane().add(passwordField);
     getContentPane().add(loginButton);
     getContentPane().add(registerLabel);
 }

    @Override
    public void actionPerformed(ActionEvent e) {
     String command =e.getActionCommand();
     if (command.equalsIgnoreCase("Login")){
         //create a dialog box
         JDialog resultDialog = new JDialog();
         resultDialog.setPreferredSize(CommonConstraints.RESULT_DIALOG_SIZE);
         resultDialog.pack();
         resultDialog.setLocationRelativeTo(this);
         resultDialog.setModal(true);

         //create label to display results
         JLabel resultLabel =new JLabel();
         resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
         resultDialog.add(resultLabel);

         //retrieve entered credentials
         String username=usernameField.getText();
         String password=passwordField.getText();

         //validate credentials in userDB
         if (UserDB.userDB.get(username) != null){
             //check password
             String validPass = UserDB.userDB.get(username);
             if (password.equals(validPass)){
                 //display a success dialog
                 resultLabel.setText("Login Successful !");
             }else{
                 //display an incorrect password dialog
                 resultLabel.setText("INVALID PASSWORD");
             }
         }else {
             //display an incorrect username dialog
             resultLabel.setText("Invalid Username");

         }
         resultDialog.setVisible(true);
     }
    }
}
