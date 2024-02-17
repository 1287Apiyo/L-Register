import custom.ErrorLabel;
import custom.PasswordFieldCustom;
import custom.TextFieldCustom;

import javax.swing.*;
import java.awt.*;

public class RegisterGui  extends JFrame {
    private ErrorLabel usernameErrorLabel,passwordErrorLabel,confirmPasswordErrorLabel,emailErrorLabel;
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
        //username error label
        usernameErrorLabel=new ErrorLabel("Invalid: Cannot be less than 6 characters");
        usernameErrorLabel.setBounds(50,usernameField.getY() + 50,
                CommonConstraints.TEXTFIELD_SIZE.width, CommonConstraints.TEXTFIELD_SIZE.height
                );


        //password field
        passwordField=new PasswordFieldCustom("Enter Password",30);
        passwordField.setBounds(50,
                usernameField.getY() + 100,
                CommonConstraints.TEXTFIELD_SIZE.width, CommonConstraints.TEXTFIELD_SIZE.height
                );
        //password error label
        passwordErrorLabel=new ErrorLabel("*Invalid: Size > 6,1 Upper and Lower ,1 #, and 1 Special Char");
        passwordErrorLabel.setBounds(
                50,passwordField.getY() + 50,
                CommonConstraints.TEXTFIELD_SIZE.width, CommonConstraints.TEXTFIELD_SIZE.height
        );

        //confirm the password field
        confirmPasswordField=new PasswordFieldCustom("Confirm Password",30);
        confirmPasswordField.setBounds(
                50,
                passwordField.getY() + 100,
                CommonConstraints.TEXTFIELD_SIZE.width, CommonConstraints.TEXTFIELD_SIZE.height);

        //confirm error password
        confirmPasswordErrorLabel=new ErrorLabel("*Invalid:Password do not match");
        confirmPasswordErrorLabel.setBounds(
                50,confirmPasswordField.getY() + 50,
                CommonConstraints.TEXTFIELD_SIZE.width, CommonConstraints.TEXTFIELD_SIZE.height
        );


       //email field
        emailField=new TextFieldCustom("Enter E-Mail",30);
        emailField.setBounds(
                50,
                confirmPasswordField.getY() + 100,
                CommonConstraints.TEXTFIELD_SIZE.width, CommonConstraints.TEXTFIELD_SIZE.height);


        //email error label
        emailErrorLabel=new ErrorLabel("*Invalid:Not a valid format");
        emailErrorLabel.setBounds(
                50,emailField.getY() + 50,
                CommonConstraints.TEXTFIELD_SIZE.width, CommonConstraints.TEXTFIELD_SIZE.height
        );


        //register button
        JButton registerButton=new JButton("Register");
        registerButton.setBounds(
                50,
                emailField.getY() + 100,
                CommonConstraints.TEXTFIELD_SIZE.width,CommonConstraints.TEXTFIELD_SIZE.height
        );

        //register->login label
        JLabel loginLabel=new JLabel("Already a user?Login Here!");
        loginLabel.setBounds(
                (CommonConstraints.FRAME_SIZE.width - loginLabel.getPreferredSize().width)/2,
                registerButton.getY() + 100,
                loginLabel.getPreferredSize().width,loginLabel.getPreferredSize().height
        );

        //add to frame
        getContentPane().add(registerLabel);
        //username
        getContentPane().add(usernameField);
        getContentPane().add(usernameErrorLabel);

        //password
        getContentPane().add(passwordField);
        getContentPane().add(passwordErrorLabel);

        //confirm password
        getContentPane().add(confirmPasswordField);
        getContentPane().add(confirmPasswordErrorLabel);

        //email
        getContentPane().add(emailField);
        getContentPane().add(emailErrorLabel);

        getContentPane().add(registerButton);
        getContentPane().add(loginLabel);
    }
}
