import java.util.Scanner;

public class Main {
	
    public static void main(String[] args) {
    	printLineDot();
        Scanner scanner = new Scanner(System.in);
        // INPUT TEXT
        System.out.print("Enter some text in capital letters (only letters A-Z): ");
        String inputTextForEncode = scanner.nextLine();

        // Clear empty spaces from beginning and end of input text, and format empty spaces to one space
        inputTextForEncode = formatInputText(inputTextForEncode);

        // First check if input text is empty
        checkInputContainsAnyText(inputTextForEncode);

        // Second check if input text contains only letters of alphabet
        checkInputText(inputTextForEncode);
        
        // INPUT KEY
        System.out.print("Enter key for encryption (only whole numbers): ");
        String inputKeyForEncode = scanner.nextLine();
        
        // Clear empty spaces from beginning and end of input text, and format empty spaces to one space
        inputKeyForEncode = formatInputText(inputKeyForEncode);
        
        // First check if input key is empty
        checkInputContainsAnyNumbers(inputKeyForEncode);
        
        // Second check if input key contains only number
        checkInputKey(inputKeyForEncode);
        		
        printLineStar();
        System.out.println("Text to encrypt (formatted text): " + inputTextForEncode);
        System.out.println("Key for encrypt: " + inputKeyForEncode);

        CaesarCipherClass cipherTekst = new CaesarCipherClass(inputTextForEncode, inputKeyForEncode);
        //System.out.print("Encrypted text (Caesar Cipher):      " + cipherTekst.encodeText());
        System.out.print("Encrypted text (Caesar Cipher):   ");
        System.err.println(cipherTekst.encodeText());
        
        printLineStar();
        
        scanner.close();
    }
    
    public static void printLineDot() {
    	System.out.println("............................................................................");
    }
    
    public static void printLineStar() {
    	System.out.println("****************************************************************************");
    }
    
    /**
     * Method check input String if contain only alphabetic letters A-Z
     *
     * @param text type String
     */
    public static void checkInputKey(String key) {
        key = key.replaceAll("\\s", "");
        
        if (key.contains("-")) {
        	key = key.substring(1, key.length());
        }
  
        if (!key.matches("[0-9]+")) {
            System.err.println("Incorrect input - not allowed characters in key! Try again! Program ends!");
            printLineDot();
            System.exit(0);
        }
    }
    
    /**
     * Method check input String is non blank text
     *
     * @param text type String
     */
    public static void checkInputContainsAnyNumbers(String key) {
        if (key.isBlank()) {
            System.err.println("Incorrect input - blank key! Try again! Program ends!");
            printLineDot();
            System.exit(0);
        }
    }
    
    /**
     * Method format empty spaces in String, clear from beginning to end, and format multiple spaces to one space
     *
     * @param key type String
     * @return String key
     */
    public static String formatInputKey(String key) {
        key = key.replaceAll("( )+", " ");
        key = key.trim();

        return key;
    }

    /**
     * Method format empty spaces in String, clear from beginning to end, and format multiple spaces to one space
     *
     * @param text type String
     * @return String text
     */
    public static String formatInputText(String text) {
        text = text.toUpperCase();
        text = text.replaceAll("( )+", " ");
        text = text.trim();

        return text;
    }

    /**
     * Method check input String if contain only alphabetic letters A-Z
     *
     * @param text type String
     */
    public static void checkInputText(String text) {
        text = text.replaceAll("\\s", "");
        if (!text.matches("^[A-Z]*$")) {
            System.err.println("Incorrect input - not allowed characters in text! Try again! Program ends!");
            printLineDot();
            System.exit(0);
        }
    }

    /**
     * Method check input String is non blank text
     *
     * @param text type String
     */
    public static void checkInputContainsAnyText(String text) {
        if (text.isBlank()) {
            System.err.println("Incorrect input - blank text! Try again! Program ends!");
            printLineDot();
            System.exit(0);
        }
    }
}
