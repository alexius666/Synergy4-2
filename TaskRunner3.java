package java_synergy.Lesson25task;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static java.util.Collections.singletonList;

public class TaskRunner3 {
    public static void main(String[] args) throws IOException {

//-----------------------СОЗДАНИЕ ДИРЕКТОРИИ И ФАЙЛА---------------------------//
        Path path = Paths.get("C:\\temp", "original_file.txt");
        File file = path.toFile();
        if (!file.exists()) {
            path.getParent().toFile().mkdir();
            Files.createFile(path);
        }
        System.out.println("Create "+file+" has success.");
//-----------------------ПОПЫТКА ЗАПИСАТЬ ТЕКСТ В ФАЙЛ ОРИГАНИЛА--------------//
        try (
                FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.append("This is original massage recorded into this file at "
                        + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE));
        }
        System.out.println("Record text into "+file+" has success.");

//-----------------СОЗДАНИЕ ДИРЕКТОРИИ И ФАЙЛА ДЛЯ КОПИИ---------------------//
        Path path_c = Paths.get("C:\\temp", "copy_file.txt");
        File file_c = path_c.toFile();
        if (!file_c.exists()) {
            path_c.getParent().toFile().mkdir();
            Files.createFile(path_c);
        }
        System.out.println("Create "+file_c+" has success.");
//-----------------ЧТЕНИЕ ФАЙЛА ОРИГАНАЛА И ЗАПИСЬ КОПИИ---------------------//

        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()) {
            try (
            FileWriter fileWriter = new FileWriter(file_c)) {
            fileWriter.append(scanner.nextLine()+"\n\n THIS IS COPY FROM "+file);
                System.out.println("Copy text from "+file+" ----> "+ file_c +" has success.");
            }
        }
    }
}



//        InputStream input = new FileInputStream(file);
//        int size = input.available();
//        String str_read;
//        char[] ch = new char[size];
//        for (int j = 0; j < size; j++) {
//            System.out.print((char)input.read());
//            ch[j]=(char)input.read();
//        }