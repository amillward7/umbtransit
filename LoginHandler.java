import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class LoginHandler {
  private static final String ALGORITHM = "PBKDF2WithHmacSHA512";
  private static final String DATABASE  = "LoginDatabase";
  
  public static boolean register(String emailAddress, String password) throws InvalidKeySpecException, IOException,
    NoSuchAlgorithmException {
    //write code here to check if emailAddress is in DATABASE already
    
    PrintWriter writer = new PrintWriter(new FileWriter(DATABASE, true));
    byte[] salt = new byte[16];
    new SecureRandom().nextBytes(salt);
    String hash = getHash(password, salt);
    writer.printf(emailAddress + " " + Base64.getEncoder().encodeToString(salt) + " " + hash + "%n");
    writer.close();
    return true;
  }
  
  public static boolean checkLogin(String emailAddress, String password) throws InvalidKeySpecException, IOException,
    NoSuchAlgorithmException {
    BufferedReader reader = new BufferedReader(new FileReader(DATABASE));
    String currentLine;
    while((currentLine = reader.readLine()) != null) {
      String[] login = currentLine.split(" ");
      if(emailAddress.equals(login[0])) {
        reader.close();
        String hash = getHash(password, login[1]);
        if(hash.equals(login[2]))
          return true;
        return false;
      }
    }
    
    //if the end of the file is reached without seeing the email address
    reader.close();
    return false;
  }
  
  private static String getHash(String password, String saltString) throws InvalidKeySpecException,
    NoSuchAlgorithmException {
    return getHash(password, Base64.getDecoder().decode(saltString));
  }
  
  private static String getHash(String password, byte[] salt) throws InvalidKeySpecException, NoSuchAlgorithmException {
    KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
    byte[] hashBytes = SecretKeyFactory.getInstance(ALGORITHM).generateSecret(spec).getEncoded();
    return Base64.getEncoder().encodeToString(hashBytes);
  }
}