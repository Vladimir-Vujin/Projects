import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter some text in capital letters (only letters A-Z): ");
        String inputTextForEncode = scanner.nextLine();

        // Clear empty spaces from beginning and end of input text, and format empty spaces to one space
        inputTextForEncode = formatInputText(inputTextForEncode);

        // First check if input text is empty
        checkInputContainsAnyText(inputTextForEncode);

        // Second check if input text contains only letters of alphabet
        checkInputText(inputTextForEncode);

        System.out.println("Text to encrypt (formatted text): " + inputTextForEncode);

        CaesarCipherClass cipherTekst = new CaesarCipherClass(inputTextForEncode);
        System.out.print("Encrypted text (Caesar Cipher): ");
        System.err.println(cipherTekst.encodeText());
    }

    /**
     * Method format empty spaces in String, clear from beginning, end and format multiple spaces o one space
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
            System.exit(0);
        }
    }
}