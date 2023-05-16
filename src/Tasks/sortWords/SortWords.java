package Tasks.sortWords;

import java.io.*;
import java.util.*;

/**
 * принимает файл текстового документа, сортирует все слова на буквы и записывает их в соответствующие файлы:
 * напрмер слова на а в файл а.txt по указанному пути

 * 1. Открываем файл для чтения.
 * 2. Считываем файл построчно.
 * 3. Разбиваем каждую строку на слова и обрабатываем каждое слово.
 * 4. Получаем первую букву слова и добавляем слово в список слов для этой буквы.
 * 5. Закрываем файл для чтения.
 * 6. Создаем файлы для записи слов для каждой буквы от 'a' до 'z'.
 * 7. Получаем список слов для каждой буквы и сортируем его.
 * 8. Записываем отсортированный список в соответствующий файл для этой буквы.
 * 9. Закрываем файл для записи.
 * 10. Код завершается.
 */

public class SortWords {
    public static void main(String[] args) throws IOException {
        // Открываем файл для чтения
        BufferedReader reader = new BufferedReader(new FileReader("d:\\Users\\Admin\\Desktop\\re.txt"));
        // Создаем хранилище для слов и файлов по первой букве слова
        Map<Character, List<String>> wordMap = new HashMap<>();
        // Читаем файл построчно
        String line;
        while ((line = reader.readLine()) != null) {
            // Разбиваем строку на слова и обрабатываем каждое слово
            String[] words = line.split("\\s+");
            for (String word : words) {
                // Пропускаем слова, начинающиеся не с буквы
                if (!Character.isLetter(word.charAt(0))) {
                    continue;
                }
                // Получаем первую букву слова, переводим ее в нижний регистр
                char firstChar = Character.toLowerCase(word.charAt(0));
                // Получаем список слов, начинающихся на эту букву, или создаем новый список
                List<String> wordList = wordMap.getOrDefault(firstChar, new ArrayList<>());
                // Добавляем слово в список
                wordList.add(word);
                // Сохраняем список слов для этой буквы
                wordMap.put(firstChar, wordList);
            }
        }
        // Закрываем файл для чтения
        reader.close();


        // Создаем файлы для записи слов
        for (char letter = 'a'; letter <= 'z'; letter++) {
            String filename = "C:\\words\\"+ letter + ".txt";

            // Указываем путь до папки, в которую будут записаны файлы
            String folderPath = "C:\\words";
            // Создаем объект File для указанной папки
            File folder = new File(folderPath);
            // Если папки не существует, то создаем ее
            if (!folder.exists()) {
                folder.mkdirs();
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            // Получаем список слов, начинающихся на эту букву
            List<String> wordList = wordMap.getOrDefault(letter, new ArrayList<>());
            // Сортируем список слов и записываем его в файл
            Collections.sort(wordList);
            for (String word : wordList) {
                writer.write(word + "\n");
            }
            // Закрываем файл для записи
            writer.close();
        }
    }
}