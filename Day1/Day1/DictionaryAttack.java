import java.io.*;
import org.apache.commons.codec.digest.DigestUtils;
public class DictionaryAttack
{
    static String wordlist(String password){
        String temp;
        String hash;

        try {
            FileReader wordlistFile = new FileReader("wordsEn.txt");
            BufferedReader wordlist = new BufferedReader(wordlistFile);

            temp = wordlist.readLine();


            while (temp != null){
                hash = DigestUtils.sha1Hex(temp);
                if (hash.equals(password)){
                return temp;
                }
                else {
                System.out.println(temp); //debug
                }

                temp = wordlist.readLine();
            }

        } catch(FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        } catch(IOException ex){
            System.out.println(ex.getMessage());
        }

        return "Not Found";


    }

    static String wordlistUpper(String password){
        String temp;
        String hash;

        try {
            FileReader wordlistFile = new FileReader("wordsEn.txt");
            BufferedReader wordlist = new BufferedReader(wordlistFile);

            temp = wordlist.readLine().toUpperCase();


            while (temp != null){
                hash = DigestUtils.sha1Hex(temp);
                if (hash.equals(password)){
                return temp;
                }
                else {
                System.out.println(temp); //debug
                }

                temp = wordlist.readLine().toUpperCase();
            }

        } catch(FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        } catch(IOException ex){
            System.out.println(ex.getMessage());
        } catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }

        return "Not Found";


    }


}
