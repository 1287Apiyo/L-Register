import java.awt.*;

public class CommonConstraints {
    public static final String LOGIN_IMAGE_PATH="resources/profile.png";

    //frame configuration
    public static final Dimension FRAME_SIZE= new Dimension(540,760);
    public static final Dimension TEXTFIELD_SIZE= new Dimension((int) (FRAME_SIZE.width*0.80),50);
    public static final Dimension BUTTON_SIZE= TEXTFIELD_SIZE;

    //login configuration
    public static final Dimension LOGIN_IMAGE_SIZE= new Dimension(255,262);

    //result dialog configuration
    public static final Dimension RESULT_DIALOG_SIZE=new Dimension((int)(FRAME_SIZE.width/3),(int)(FRAME_SIZE.height/6));

}
