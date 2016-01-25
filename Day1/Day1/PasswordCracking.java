
/**
 * Write a description of class PasswordCracking here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import org.apache.commons.codec.digest.DigestUtils;

public class PasswordCracking
{   
    static String hash(String password){
        char letter = 'a';
        String hash;
        
        while (letter <= 'z'){
                
                   hash = DigestUtils.sha1Hex(Character.toString(letter));
                
                if(hash.equals(password)){
                    return Character.toString(letter);
                }
                else{
                    letter ++;
                }
                
        }
        
        return "Not Found";
        
        
        
 
    }
    
    static String doublehash(String password){
        
        char letter1 = 'a';
        char letter2 = 'a';
        char letter3 = 'a';
        char letter4 = 'a';
        char letter5 = 'a';
        String combined = "aa";
        String hash;
        
        hash = DigestUtils.sha1Hex(combined);
        
        while (combined != "zzzzzz"){
            
            while(letter1 <= 'z'){
                
                while(letter2 <= 'z'){
                    
                    combined = Character.toString(letter1) + Character.toString(letter2);
                    hash = DigestUtils.sha1Hex(combined);
                    
                     if(hash.equals(password)){
                            return combined;
                        }
                        else{
                            letter2 ++;
                        }
                       
                
                }
                
                letter1 ++;
                letter2 = 'a';
               
            }
            
            letter1 = 'a';
            letter2 = 'a';
          
            
            while(letter1 <= 'z'){
                
                while(letter2 <= 'z'){
                    
                    while(letter3 <= 'z'){
                    
                        
                    combined = Character.toString(letter1) + Character.toString(letter2) + Character.toString(letter3);
                    hash = DigestUtils.sha1Hex(combined);
                    
                     if(hash.equals(password)){
                            return combined;
                        }
                        else{
                            letter3 ++;
                        }

                       
                
                }
                
                letter2 ++;
                letter3 = 'a';
                
                }
                
                letter1 ++;
                letter2 = 'a';
            
            }
            
            letter1 = 'a';
            letter2 = 'a';
            letter3 = 'a';
            
                        while(letter1 <= 'z'){
                
                while(letter2 <= 'z'){
                    
                    while(letter3 <= 'z'){
                    
                        while(letter4 <= 'z'){
                        combined = Character.toString(letter1) + Character.toString(letter2) + Character.toString(letter3) + Character.toString(letter4);
                        hash = DigestUtils.sha1Hex(combined);
                        
                         if(hash.equals(password)){
                                return combined;
                            }
                            else{
                                letter4 ++;
                            }
                        }
                        
                        letter3 ++;
                        letter4 = 'a';
                        

                       
                
                }
                
                letter2 ++;
                letter3 = 'a';
                
                }
                
                letter1 ++;
                letter2 = 'a';
            
            }
            
            letter1 = 'a';
            letter2 = 'a';
            letter3 = 'a';
            letter4 = 'a';
            
                        while(letter1 <= 'z'){
                
                while(letter2 <= 'z'){
                    
                    while(letter3 <= 'z'){
                    
                        while(letter4 <= 'z'){
                            
                            while(letter5 <= 'z'){
                                     combined = Character.toString(letter1) + Character.toString(letter2) + Character.toString(letter3) + Character.toString(letter4) + Character.toString(letter5);
                                hash = DigestUtils.sha1Hex(combined);
                                
                                 if(hash.equals(password)){
                                        return combined;
                                    }
                                    else{
                                        letter5 ++;
                                    }
                            }
                            
                            letter4 ++;
                            letter5 = 'a';
                       
                        }
                        
                        letter3 ++;
                        letter4 = 'a';
                        

                       
                
                }
                
                letter2 ++;
                letter3 = 'a';
                
                }
                
                letter1 ++;
                letter2 = 'a';
            
            }
            
            letter1 = 'a';
            letter2 = 'a';
            letter3 = 'a';
            letter4 = 'a';
            letter5 = 'a';
            char letter6 = 'a';
            
            
                        while(letter1 <= 'z'){
                
                while(letter2 <= 'z'){
                    
                    while(letter3 <= 'z'){
                    
                        while(letter4 <= 'z'){
                            
                            while(letter5 <= 'z'){
                                     
                                while(letter6 <= 'z'){
                                     combined = Character.toString(letter1) + Character.toString(letter2) + Character.toString(letter3) + Character.toString(letter4) + Character.toString(letter5) + Character.toString(letter6);
                                hash = DigestUtils.sha1Hex(combined);
                                
                                 if(hash.equals(password)){
                                        return combined;
                                    }
                                    else{
                                        letter6 ++;
                                    }
                            }
                            letter5 ++;
                            letter6 = 'a';
                            }
                            
                            letter4 ++;
                            letter5 = 'a';
                       
                        }
                        
                        letter3 ++;
                        letter4 = 'a';
                        

                       
                
                }
                
                letter2 ++;
                letter3 = 'a';
                
                }
                
                letter1 ++;
                letter2 = 'a';
            
            }
            
            
            
                
        }
        
        return "Not Found";
        
    }
}
