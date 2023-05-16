package Tasks.sortWords;

import java.io.*;
import java.util.*;

/**
 * ��������� ���� ���������� ���������, ��������� ��� ����� �� ����� � ���������� �� � ��������������� �����:
 * ������� ����� �� � � ���� �.txt �� ���������� ����

 * 1. ��������� ���� ��� ������.
 * 2. ��������� ���� ���������.
 * 3. ��������� ������ ������ �� ����� � ������������ ������ �����.
 * 4. �������� ������ ����� ����� � ��������� ����� � ������ ���� ��� ���� �����.
 * 5. ��������� ���� ��� ������.
 * 6. ������� ����� ��� ������ ���� ��� ������ ����� �� 'a' �� 'z'.
 * 7. �������� ������ ���� ��� ������ ����� � ��������� ���.
 * 8. ���������� ��������������� ������ � ��������������� ���� ��� ���� �����.
 * 9. ��������� ���� ��� ������.
 * 10. ��� �����������.
 */

public class SortWords {
    public static void main(String[] args) throws IOException {
        // ��������� ���� ��� ������
        BufferedReader reader = new BufferedReader(new FileReader("d:\\Users\\Admin\\Desktop\\re.txt"));
        // ������� ��������� ��� ���� � ������ �� ������ ����� �����
        Map<Character, List<String>> wordMap = new HashMap<>();
        // ������ ���� ���������
        String line;
        while ((line = reader.readLine()) != null) {
            // ��������� ������ �� ����� � ������������ ������ �����
            String[] words = line.split("\\s+");
            for (String word : words) {
                // ���������� �����, ������������ �� � �����
                if (!Character.isLetter(word.charAt(0))) {
                    continue;
                }
                // �������� ������ ����� �����, ��������� �� � ������ �������
                char firstChar = Character.toLowerCase(word.charAt(0));
                // �������� ������ ����, ������������ �� ��� �����, ��� ������� ����� ������
                List<String> wordList = wordMap.getOrDefault(firstChar, new ArrayList<>());
                // ��������� ����� � ������
                wordList.add(word);
                // ��������� ������ ���� ��� ���� �����
                wordMap.put(firstChar, wordList);
            }
        }
        // ��������� ���� ��� ������
        reader.close();


        // ������� ����� ��� ������ ����
        for (char letter = 'a'; letter <= 'z'; letter++) {
            String filename = "C:\\words\\"+ letter + ".txt";

            // ��������� ���� �� �����, � ������� ����� �������� �����
            String folderPath = "C:\\words";
            // ������� ������ File ��� ��������� �����
            File folder = new File(folderPath);
            // ���� ����� �� ����������, �� ������� ��
            if (!folder.exists()) {
                folder.mkdirs();
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            // �������� ������ ����, ������������ �� ��� �����
            List<String> wordList = wordMap.getOrDefault(letter, new ArrayList<>());
            // ��������� ������ ���� � ���������� ��� � ����
            Collections.sort(wordList);
            for (String word : wordList) {
                writer.write(word + "\n");
            }
            // ��������� ���� ��� ������
            writer.close();
        }
    }
}