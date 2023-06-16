package hust.soict.globalict.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args){
        String filename = "test.exe";
        byte[] inputBytes = {0};
        long startTime, endTime;
        try{
            inputBytes = Files.readAllBytes(Paths.get(filename));
        } catch (IOException e){
            e.printStackTrace();
        }
        startTime = System.currentTimeMillis();
        String outputString = "";
        StringBuilder outputStringBuilder = new StringBuilder();
        for (byte b : inputBytes){
            outputStringBuilder.append((char) b);
            //outputString += (char) b;
        }
        outputString = outputStringBuilder.toString();
        System.out.println(outputString);
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
    
}
