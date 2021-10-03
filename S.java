public class S {

    public static void main(String[] args) {
        String str1="hello";
        String str2=new String("hello");
        System.out.println(str1 == str2);//false

        String str3="he"+"llo";
        System.out.println(str1 == str3);//true

        String str4="he";
        String str5="llo";
        String str6=str4+str5;
        System.out.println(str1 == str6 );//false

        String str7="he"+new String("llo");
        System.out.println(str1 == str7 );//false
    }
}
