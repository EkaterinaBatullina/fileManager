/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package a.flies;

import java.io.*;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ekaterina
 */
public class FileManager {

// /Users/ekaterina/NetBeansProjects/Flies
    public String currentLocation = System.getProperty("user.dir");


//1. Переход в указанную папку
    public void changeDirectory(String directoryPath) {
        
        File directory = new File(directoryPath);
        if (directory.isDirectory()) {
            System.setProperty("user.dir", directoryPath);
            System.out.println("Перешли в директорию: " + directoryPath);
        } 
        else {
             System.out.println("Указанной директории не существует.");
        }
        
    }

//2. Создание директории
    public void createDirectory(String directoryName) {

        File dir = new File(currentLocation + '/' + directoryName);
        if (dir.mkdir()) {
            System.out.println("Директория успешно создана");
        } else {
            System.out.println("Ошибка создания директории");
        }

    }

//3. Копирование файла
    public void copyFile(String name) {
        
        File oldFile = new File(currentLocation);
        File newFile  = new File(oldFile.getParent() + '/' + name);
        try (InputStream inputStream = new FileInputStream(oldFile); 
            OutputStream outputStream = new FileOutputStream(newFile)) {
            int b;
            while ((b = inputStream.read()) != -1) {
                outputStream.write(b);
            }
            System.out.println("Фвйл скопирован");
        } catch (IOException e) {
            e.getMessage();
        }
        
    }
    
//4. Переименование файла
    public void renameFile(String name) {
        
        File oldFile = new File(currentLocation);
        File newFile = new File(oldFile.getParent() + '/' + name);
        if (oldFile.renameTo(newFile)) {
            System.out.println("Файл переименован");
        } else {
            System.out.println("переименование не выполнено");
        }
        
    }
    
//5. Запрос списка файлов текущей директории
    public File[] directoryFiles() {
        
        System.out.println("Файлы директории:");
        return (new File(currentLocation).listFiles());
        
    }

}
