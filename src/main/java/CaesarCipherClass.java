import java.util.ArrayList;
import java.util.Arrays;

public class CaesarCipherClass {

    private String textForEncoding;
    private final ArrayList<Character> alphabetLetters = new ArrayList<Character>(Arrays.asList('A', 'B', 'C', 'D',
            'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
            'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'));

    public CaesarCipherClass() {
    }

    public CaesarCipherClass(String textForEncoding) {
        this.textForEncoding = textForEncoding;
    }

    public String getTextForEncoding() {
        return textForEncoding;
    }

    public void setTextForEncoding(String textForEncoding) {
        this.textForEncoding = textForEncoding;
    }

    public String encodeText() {
        //System.out.println(textForEncoding);
        char[] textForEncodingLetters = textForEncoding.toCharArray();
        String encryptedText = "";
        int encryptLetterIndex = 0;

        for (int i = 0; i < textForEncodingLetters.length; i++) {
            if (textForEncodingLetters[i] == ' ') {
                encryptedText = encryptedText + " ";
            } else {
                encryptLetterIndex = alphabetLetters.indexOf(textForEncodingLetters[i]) - 3;
                /*if (encryptLetterIndex == -3)
                    encryptLetterIndex = alphabetLetters.size() - 3;
                else if (encryptLetterIndex == -2)
                    encryptLetterIndex = alphabetLetters.size() - 2;
                else if (encryptLetterIndex == -1)
                    encryptLetterIndex = alphabetLetters.size() - 1;
                encryptedText = encryptedText + alphabetLetters.get(encryptLetterIndex);*/
                if (encryptLetterIndex < 0)
                    encryptLetterIndex += alphabetLetters.size();
                encryptedText = encryptedText + alphabetLetters.get(encryptLetterIndex);
            }
        }
        return encryptedText;
    }
}
