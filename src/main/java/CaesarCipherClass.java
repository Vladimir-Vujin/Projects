import java.util.ArrayList;
import java.util.Arrays;

public class CaesarCipherClass {

    private String textForEncoding;
    private String keyForEncoding;
    private final ArrayList<Character> alphabetLetters = new ArrayList<Character>(Arrays.asList('A', 'B', 'C', 'D',
            'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
            'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'));

    public CaesarCipherClass() {
    }

    public CaesarCipherClass(String textForEncoding, String keyForEncode) {
        this.textForEncoding = textForEncoding;
        this.keyForEncoding = keyForEncode;
    }

    public String getTextForEncoding() {
        return textForEncoding;
    }

    public void setTextForEncoding(String textForEncoding) {
        this.textForEncoding = textForEncoding;
    }

    public String getKeyForEncoding() {
		return keyForEncoding;
	}

	public void setKeyForEncoding(String keyForEncoding) {
		this.keyForEncoding = keyForEncoding;
	}

	public String encodeText() {
        char[] textForEncodingLetters = textForEncoding.toCharArray();
        int key;
        String encryptedText = "";
        int encryptLetterIndex = 0;
        
        if(keyForEncoding.contains("-")) {
        	key =  Integer.parseInt(keyForEncoding.substring(1, keyForEncoding.length()));
        	key *= -1;
        } else {
        	key =  Integer.parseInt(keyForEncoding);
        }
        if(key >= 26 || key <= -26) {
        	key = key % 26;
        } 

        for (int i = 0; i < textForEncodingLetters.length; i++) {
            if (textForEncodingLetters[i] == ' ') {
                encryptedText = encryptedText + " ";
            }  else {
                	encryptLetterIndex = alphabetLetters.indexOf(textForEncodingLetters[i]) + key;
            		if (encryptLetterIndex > alphabetLetters.size())
                        encryptLetterIndex = encryptLetterIndex - alphabetLetters.size();
            		else if (encryptLetterIndex < 0)
            			encryptLetterIndex = encryptLetterIndex + alphabetLetters.size();
                }           	
                encryptedText = encryptedText + alphabetLetters.get(encryptLetterIndex);
              }
        return encryptedText;
    }
}
