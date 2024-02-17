import custom.PasswordFieldCustom;
import custom.TextFieldCustom;

import javax.swing.*;
import java.awt.*;

public class RegisterGui  extends JFrame {
    private TextFieldCustom usernameField,emailField;
    private PasswordFieldCustom passwordField,confirmPasswordField;
    public  RegisterGui(){
        super("Apiyo Ind . Register");

        setSize(CommonConstraints.FRAME_SIZE);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        addGuiComponent();

    }


    public void addGuiComponent(){
        JLabel registerLabel=new JLabel("Register");
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        registerLabel.setBounds(
                0,
                0,
                CommonConstraints.REGISTER_LABEL_SIZE.width,
                CommonConstraints.REGISTER_LABEL_SIZE.height


        );
        //Username field
        usernameField = new TextFieldCustom("Enter username",30);
        usernameField.setBounds(
                50,
                registerLabel.getY() + 150,
                CommonConstraints.TEXTFIELD_SIZE.width, CommonConstraints.TEXTFIELD_SIZE.height);

        //password field
        passwordField=new PasswordFieldCustom("Enter Password",30);
        passwordField.setBounds(50,
                usernameField.getY() + 100,
                CommonConstraints.TEXTFIELD_SIZE.width, CommonConstraints.TEXTFIELD_SIZE.height
                );
        //configure the password field
        confirmPasswordField=new PasswordFieldCustom("Confirm Password",30);
        confirmPasswordField.setBounds(
                50,
                passwordField.getY() + 100,
                CommonConstraints.TEXTFIELD_SIZE.width, CommonConstraints.TEXTFIELD_SIZE.height);
       //email field
        emailField=new TextFieldCustom("Enter E-Mail",30);
        emailField.setBounds(
                50,
                confirmPasswordField.getY() + 100,
                CommonConstraints.TEXTFIELD_SIZE.width, CommonConstraints.TEXTFIELD_SIZE.height);
     //add to frame
        getContentPane().add(usernameField);
        getContentPane().add(passwordField);
        getContentPane().add(confirmPasswordField);
        getContentPane().add(emailField);
    }
}
