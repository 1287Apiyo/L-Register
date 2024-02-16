public class TextFieldCustom {
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

    }
}
