import org.apache.commons.codec.digest.DigestUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Messing about with password cracking in Java
 * 
 * @author Daniel Dainty
 * @version 2016-01-25
 * @license Publihed under the DontJudgeMe 2016 license
 */
public class GetSHA
{
    public GetSHA()
    {
        // initialise instance variables
    }

    public static String GetHash(String input)
    {
        // use this to get a hash from a string input.
        String hash = DigestUtils.sha1Hex(input);
        System.out.println(hash);
        return hash;
    }
           
    public static String ShowDate(){
        // Prints the time and date to the creen
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SS a");
        String HH_MM = sdf.format(date);
        return HH_MM;
    }
    
    public static String CrackThisVarlen(String input, int maxlength)
    {
        // brute force of variable length string. Input 'maxlength' to limit password length (and limit how long we spend checking).
        
        String result = null;
        for(int a=1;a<=maxlength;a++)
        {
            System.out.println("Checking passwords of length " + Integer.toString(a));
            result = CrackThisFixedlen(input, a);
            if(result != null){
                return result;
            }
        }
        return null;
    }
    
    public static String CrackThisFixedlen(String input, int pwlength)
    {   
        // Cracks a hash to find a password of fixed length pwlength.
        // Called by CrackThisVarlen or call it directly if you know how long it is.
        
        System.out.println("Started at " + ShowDate());

        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890,./;'<>?:@[]\\{}|!\"`¬~#£$%^&*()_+-=";
       
        // init array
        int[] ticker = new int[pwlength]; // arrays of int are automatically filled with zeroes
        int i = pwlength-1;
        
        while(i >= 0){
            // set up my attempt
            String attempt = "";
            for(int a=0; a<pwlength;a++) attempt += chars.charAt(ticker[a]);
            
            // attempt is in 'attempt' - now see if it matches
            
            if(DigestUtils.sha1Hex(attempt).equals(input)){
                System.out.println("Finished with positive result at " + ShowDate());
                return attempt;
            }
 
            //increment the characters in the attempt
            
            if(ticker[i] == chars.length()-1){
                // reset and move left
                ticker[i] = 0;
                i--;
            } else{
                // increment and ensure i is looking at the end of the string
                ticker[i]++;
                i = pwlength-1;
            }
        }
        System.out.println("Finished with null result at " + ShowDate());
        return null;
    }
}