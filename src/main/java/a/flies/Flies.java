/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package a.flies;

/**
 *
 * @author ekaterina
 */

import java.io.File;
import java.util.Scanner;

public class Flies {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String action;
        FileManager fileManager = new FileManager();
        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Переход в указанную папку");
            System.out.println("2. Создание директории");
            System.out.println("3. Копирование файла");
            System.out.println("4. Переименование файла");
            System.out.println("5. Запрос списка файлов текущей директории");
            System.out.println("6. Завершение программы");

            action = scanner.nextLine();

            switch (action) {
                
                case "1":
                    System.out.println("Введите путь к директории:");
                    fileManager.changeDirectory(scanner.nextLine());
                    break;
                    
                case "2":
                    System.out.println("Введите название директории:");
                    fileManager.createDirectory(scanner.nextLine());
                    break;
                    
                case "3":
                    System.out.println("Введите название нового файла:");
                    fileManager.copyFile(scanner.nextLine());
                    break;
                    
                case "4":   
                    System.out.println("Введите название нового файла:");
                    fileManager.renameFile(scanner.nextLine());
                    break;
                    
                case "5":
                    File[] files = fileManager.directoryFiles();
                    for (File file : files) {
                        System.out.println(file.getName());
                    }
                    break;
                    
                case "6":
                    System.out.println("Программа завершена");
                    return;
            }
        }
    }
}
