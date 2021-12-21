import javax.jnlp.ClipboardService;
import java.util.*;

public class UserMessage {
    private String username;
    private String password;

   static HashMap<String,String> hashMap=new HashMap<>();
   public static  void write(String username,String password){
       hashMap.put(username,password);
   }
   public static boolean checkName(String username){
       if(hashMap.containsKey(username)){
           return true;
       }
       return false;
   }
   public static boolean checkNumber(String password){
       if(hashMap.containsValue(password)){
           return true;
       }
       return false;
   }
    public static void main(String[] args) {
        System.out.println(hashMap);
    }
}
