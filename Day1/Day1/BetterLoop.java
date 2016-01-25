import org.apache.commons.codec.digest.DigestUtils;

public class BetterLoop
{
  static String LooptyLoop(String password)
  {
    String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String charAtPos;
    String currentAttempt = "";
    String temp;
    String hash = ""

    for(int i = 0; i < 52; i ++;)
    {
        charAtPos = Character.toString(alphabet.charAt(i));
        hash = DigestUtils.sha1Hex(currentAttempt);
        if (i < 26){
            
            if (hash.equals(password){
                return currentAttempt
            }
            
        }else if(i >= 26){
            
        }
    }

  }

}
