package FileOutputStream;

import java.io.FileInputStream;

public class FileInputStreamMain {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();

        try (FileInputStream fileInputStream = new FileInputStream("text2.txt")){
            int i = -1;
            while ( (i=fileInputStream.read()) != -1){
                stringBuffer.append((char) i);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(stringBuffer);
    }
}
