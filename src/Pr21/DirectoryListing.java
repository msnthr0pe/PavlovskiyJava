package Pr21;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DirectoryListing {
    public static void main(String[] args) {
        String directoryPath = "C:\\Users\\Vasyp\\IdeaProjects\\PavlovskiyJava";

        List<String> fileList = getFileList(directoryPath);
        printFirstFiveElements(fileList);
    }

    public static List<String> getFileList(String directoryPath) {
        List<String> fileList = new ArrayList<>();

        File directory = new File(directoryPath);
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (int i = 0; i < files.length; i++) {
                    fileList.add(files[i].getName());
                }
            }
        }

        return fileList;
    }

    public static void printFirstFiveElements(List<String> fileList) {
        int limit = Math.min(fileList.size(), 5);
        for (int i = 0; i < limit; i++) {
            System.out.println(fileList.get(i));
        }
    }
}
