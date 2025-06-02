
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryptor {
    public static String encryptString(String user_password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");

        byte[] messageDigest = md.digest(user_password.getBytes());

        BigInteger bigInt = new BigInteger(1, messageDigest);

        String hashText = bigInt.toString(16);

        while (hashText.length() < 32) {
            hashText = "0" + hashText; // pad with leading zeros
        }

        return hashText;
    }


    public static void main(String[] args) throws NoSuchAlgorithmException {
        Encryptor encryptor = new Encryptor();

        String password = "monkey123";

        System.out.println(encryptor.encryptString(password));
        
    }

    
    
}
