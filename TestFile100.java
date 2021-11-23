package 文件和IO;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;
import java.io.File;
public class TestFile100<files> {
    public static void main(String[] args) throws IOException {
        //1.让用户指定一个待扫描的根目录 和 一个要查询的关键词
        System.out.println("请输入要扫描的根目录（绝对路径）：");
        Scanner scanner=new Scanner(System.in);
        String root=scanner.next();
        File rootDir=new File(root);
        if(rootDir.isDirectory()){
            System.out.println("您输入的路径错误！程序直接退出！");
            return;
        }
        System.out.println("请输入要查找的文件名中的关键词：");
        String token=scanner.next();

        //2.递归的遍历目录
        //   result 表示递归遍历的结果，就包含着所有带有 token关键词的文件
        List<File> result =new ArrayList<>();
        scanDir(rootDir,token,result);
        // 3.遍历result，问用户是否要删除该文件，根据用户的输入决定是否删除
        for(File f: result){
            System.out.println(f.getCanonicalPath()+"是否要删除?(Yes/No)");
            String input=scanner.next();
            if(input.equals("Y")){
                f.delete();
            }
        }
    }

    //递归的来遍历目录，找出里面所有符合条件的文件。
    private static void scanDir(File rootDir, String token, List<File> result) throws IOException {
        //list返回的是一个文件名（String），使用listFiles直接得到的是File对象 用起来更方便一些。
        rootDir.listFiles();
        File[] files = rootDir.listFiles();
        if (files == null || files.length == 0) {
            //当前目录是一个空目录。
            return;
        }

        for (File f : files) {
            if (f.isDirectory()) {
                //如果当前的文件是一个目录，那么就递归的进行查找
                scanDir(f, token, result);
            }else{
                //如果当前文件是一个普通的文件，就判定这个文件是否包含了待查找的关键词
                if(f.getName().contains(token)){
                    result.add(f.getCanonicalFile());
                }
            }
        }

    }
}
