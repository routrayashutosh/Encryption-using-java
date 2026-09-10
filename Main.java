import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Main {

    private static final String PASSWORD = "mySecretKey12345";

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Simple Sentence Encryptor ===");
        System.out.println("Type a sentence:");

        String sentence = scanner.nextLine();

        String encrypted = encrypt(sentence);

        System.out.println();
        System.out.println("Encrypted:");
        System.out.println(encrypted);

        scanner.close();
    }

    public static String encrypt(String text) throws Exception {

        SecretKeySpec key = new SecretKeySpec(
                PASSWORD.getBytes(),
                "AES"
        );

        Cipher cipher = Cipher.getInstance("AES");

        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] encrypted =
                cipher.doFinal(text.getBytes());

        return Base64.getEncoder()
                .encodeToString(encrypted);
    }
}