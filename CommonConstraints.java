import java.awt.*;

public class CommonConstraints {
    public static final String LOGIN_IMAGE_PATH="resources/profile.png";


    //color config
    public static final Color PRIMARY_COLOR=new Color(38,37,70);
    public static final Color SECONDARY_COLOR=new Color(255,171,63);
    public static final Color BUTTON_COLOR=new Color(207,6,0);


    //frame configuration
    public static final Dimension FRAME_SIZE= new Dimension(540,760);
    public static final Dimension TEXTFIELD_SIZE= new Dimension((int) (FRAME_SIZE.width*0.80),50);
    public static final Dimension BUTTON_SIZE= TEXTFIELD_SIZE;

    //login configuration
    public static final Dimension LOGIN_IMAGE_SIZE= new Dimension(FRAME_SIZE.width,262);

    //register configuration
    public static final Dimension REGISTER_LABEL_SIZE= new Dimension(255,150);


    //result dialog configuration
    public static final Dimension RESULT_DIALOG_SIZE=new Dimension((int)(FRAME_SIZE.width/3),(int)(FRAME_SIZE.height/6));

}
