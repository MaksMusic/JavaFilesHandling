package FileReaderFileWriter;

import java.io.FileWriter;

public class JobFileWriter {
    public static void main(String[] args) {
       // File file = new File("C:\\Users\\maksm\\IdeaProjects\\JavaFiles");

        try{
            FileWriter writer = new FileWriter("listUser.txt",false);    //создать новый файл
            writer.write("name:Tomas , age:21 ");    //добавить строку
            writer.flush();         // добавить все изменения в файл

            writer.append('=');     //добавить смивол на ту же строку
            writer.flush();         // добавить все изменения в файл

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
