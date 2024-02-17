import custom.ErrorLabel;
import custom.PasswordFieldCustom;
import custom.TextFieldCustom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterGui  extends JFrame implements ActionListener,FocusListener{
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

        usernameField.addFocusListener(this);
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

        passwordField.addFocusListener(this);


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

        confirmPasswordField.addFocusListener(this);

        //confirm password error label
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


        emailField.addFocusListener(this);
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
  registerButton.addActionListener(this);
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

    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {
        Object fieldSource = e.getSource();
        if (fieldSource == usernameField) {
            //valid username has to be greater or equal to 6
            if (usernameField.getText().length() < 6 || usernameField.isHasPlaceHolder()) {
                usernameErrorLabel.setVisible(true);
            } else {
                usernameErrorLabel.setVisible(false);
            }
        } else if (fieldSource == passwordField){
            String passwordRegex="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\\\S+$).{8,} 20}$";
            Pattern p =Pattern.compile(passwordRegex);
            Matcher m=p.matcher(passwordField.getText());
            if (!m.find())passwordErrorLabel.setVisible(true);
            else passwordErrorLabel.setVisible(false);
        } else if (fieldSource==confirmPasswordField) {
            //if password does not match it is invalid
            if (!passwordField.getText().equals(confirmPasswordField.getText())){
                confirmPasswordErrorLabel.setVisible(true);
            }else{
                confirmPasswordErrorLabel.setVisible(false);
            }
            
        }else if (fieldSource==emailField){
            //checks validity of the email
            String emailRegex=" ^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
            Pattern p= Pattern.compile(emailRegex);
            Matcher m = p.matcher(emailField.getText());
            if (!m.find())emailErrorLabel.setVisible(true);
            else emailErrorLabel.setVisible(false);
        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {
    String command =e.getActionCommand();
    if (command.equals("Register")){
boolean isValid=!usernameErrorLabel.isVisible() && !passwordErrorLabel.isVisible() && !confirmPasswordErrorLabel.isVisible()
        && !emailErrorLabel.isVisible() && !usernameField.isHasPlaceHolder() && !passwordField.isHasPlaceHolder()
        && !confirmPasswordField.isHasPlaceHolder() && !emailField.isHasPlaceHolder();

//result dialog
        JDialog resultDialog=new JDialog();
        resultDialog.setSize(CommonConstraints.RESULT_DIALOG_SIZE);
        resultDialog.setLocationRelativeTo(this);
        resultDialog.setModal(true);

        //result label
        JLabel resultLabel=new JLabel();
        resultLabel.setPreferredSize(CommonConstraints.RESULT_DIALOG_SIZE);
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultDialog.add(resultLabel);

        if (isValid){
            //store the info into userdb
            String username=usernameField.getText();
            String password =passwordField.getText();
            UserDB.addUser(username,password);

            //show a dialog that shows the user has been added to the userdb
            resultLabel.setText("Account Registered");

            //take user back to the login gui
            resultDialog.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    dispose();
                    new LoginGui().setVisible(true);
                }
            });
        }else {
            //show an error label
            resultLabel.setText("Invalid Credentials");
        }
       resultDialog.setVisible(true);
    }
    }
}
