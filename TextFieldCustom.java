package custom;


import javax.swing.*;
import java.awt.event.*;

public class TextFieldCustom extends JTextField {
    private String placeholderText;
    private boolean hasPlaceHolder;
    public boolean isHasPlaceHolder() {
        return hasPlaceHolder;
    }

    public TextFieldCustom(String placeholderText, int charLimit){
        super();
        this.placeholderText=placeholderText;

        //placeholder text status
        hasPlaceHolder=true;

        //limit char input in field
     setDocument(new LimitText(charLimit));
     setText(this.placeholderText);
     addListeners();
    }
    private void addListeners(){
        //check for mouse clicks
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (hasPlaceHolder){
                   hasPlaceHolder=false;
                   setText(" ");
                }
            }
        });
        //check for key press
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (hasPlaceHolder){
                    hasPlaceHolder=false;
                    setText("");
                }
            }
        });
        //check to see if user has removed focus for this field
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
             //check if it is empty
                if (getText().toString().length()<=0){
                    hasPlaceHolder=true;
                    setText(placeholderText);
                }
            }
        });
    }
}
