package file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static void writeFile(String pathFile, String line){
        BufferedWriter bufferedWriter = null;
        try {
            FileWriter fileWriter=new FileWriter(pathFile,true);
            bufferedWriter=new BufferedWriter(fileWriter);
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                assert bufferedWriter != null;
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static List<String> readFile(String pathFile){
        List<String> listLine=new ArrayList<>();
        BufferedReader bufferedReader=null;
        try{
            FileReader fileReader=new FileReader(pathFile);
            bufferedReader =new BufferedReader(fileReader);
            String line=null;
            while((line=bufferedReader.readLine())!=null){
                listLine.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return listLine;
    }
}
