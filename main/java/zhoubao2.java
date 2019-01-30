
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 * 检查周报谁没交
 */
public class zhoubao2 {

    private static ArrayList<String> names = new ArrayList<String>();
    private static FileOutputStream fos = null;
    private static StringBuilder sb = new StringBuilder() ;

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date now = new Date();
        String time = sdf.format(now);
        int count = 0;

        /**
         * 得到每个周报中的人的名字，将名字放到集合中
         */
        File file = new File("F:\\周报及其他文档整理\\20180917个人周报、项目周报、周工作简报\\个人周报");
        try {
            String fileName = "F:\\java_file\\other_file\\" + time + "-没交人员名单.txt";
            fos = new FileOutputStream(fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] filenames = file.list();
        for (String name : filenames) {
            //注意这里取名字时，前后必须是英文状态下时的“-”,而且前后都没有空格
            String newName = name.substring(name.indexOf("-") + 1, name.indexOf("-", name.indexOf("-") + 1));
            names.add(newName);
        }

        String[] people = getName("F:\\java_file\\other_file\\allname-utf8.txt");
        System.out.println("总人数： " + people.length);
        for (String p : people) {
            if (names.contains(p)) {
                System.out.println(p + ": 交");
            } else {
                try {
                    count++;
                    fos.write(p.getBytes());
                    fos.write("，".getBytes());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(p + ": 没交");

            }
        }
        try {
            fos.write("\r\n".getBytes());
            fos.write("没交周报人数：".getBytes());
            fos.write(String.valueOf(count).getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (String p : people) {
            System.out.println("-" + p + "-");
        }
    }

    public static String[] getName(String filepath){
        try {
            File namefile = new File(filepath);
            BufferedReader br = new BufferedReader(new FileReader(namefile));
            String name = br.readLine();
            while (name!=null){
                sb.append(name);
                name = br.readLine();
            }
            String namestring = sb.toString();
            String[] names = namestring.split(",");
            return names;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }
}
