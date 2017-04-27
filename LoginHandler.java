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

/* This is a class to deal with login data. It is not necessary to construct an instance of this class; all methods
 * are static.
 * 
 * In order to register a user, use the method "LoginHandler.register(emailAddress, password)".
 * This method also returns a boolean: true if the user was successfully registered, false if the user is already in
 * the database.
 *
 * In order to check whether a given emailAddress-password combo is valid, use the method
 * "LoginHandler.checkLogin(emailAddress, password). This method returns "true" if the combo is valid and "false" if
 * either the emailAddress is not in the database or the password given does not match that stored.
 */

public class LoginHandler {
  private static final String ALGORITHM = "PBKDF2WithHmacSHA512";
  private static final String DATABASE  = "LoginDatabase";
  
  //method to register/attempt to register a new user; returns true if successful, false otherwise
  public static boolean register(String emailAddress, String password) throws InvalidKeySpecException, IOException,
    NoSuchAlgorithmException {
    //write code here to check if emailAddress is in DATABASE already and if so return false immediately
    
    //salt and hash the password 
    byte[] salt = new byte[16];
    new SecureRandom().nextBytes(salt);
    String hash = getHash(password, salt);
    
    //add the emailAddress, salt, and hash to the database
    //emailAddress, salt, and hash separated by spaces
    PrintWriter writer = new PrintWriter(new FileWriter(DATABASE, true));
    writer.printf(emailAddress + " " + Base64.getEncoder().encodeToString(salt) + " " + hash + "%n");
    writer.close();
    return true;
  }
  
  //method to check whether a given emailAddress and password are a valid login
  public static boolean checkLogin(String emailAddress, String password) throws InvalidKeySpecException, IOException,
    NoSuchAlgorithmException {
    BufferedReader reader = new BufferedReader(new FileReader(DATABASE));
    String currentLine;
    
    //search through database one line at a time
    while((currentLine = reader.readLine()) != null) {
      String[] login = currentLine.split(" "); //break the line into emailAddress, salt, and hash
      if(emailAddress.equals(login[0])) {
        reader.close();
        String hash = getHash(password, login[1]); //salt and hash given password
        if(hash.equals(login[2])) //check just-salted-and-hashed password against stored hash
          return true; //if hashes match
        return false; //if hashes don't match, don't keep searching
      }
    }
    
    //if the end of the file is reached without seeing the email address
    reader.close();
    return false;
  }
  
  //overloaded method to salt and hash a given password with a given salt as a String or byte array
  private static String getHash(String password, String saltString) throws InvalidKeySpecException,
    NoSuchAlgorithmException {
    return getHash(password, Base64.getDecoder().decode(saltString)); //convert String salt into byte array salt
  }
  
  private static String getHash(String password, byte[] salt) throws InvalidKeySpecException, NoSuchAlgorithmException {
    KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128); //salt password
    byte[] hashBytes = SecretKeyFactory.getInstance(ALGORITHM).generateSecret(spec).getEncoded(); //hash salted password
    return Base64.getEncoder().encodeToString(hashBytes); //hash stored as string
  }
}
