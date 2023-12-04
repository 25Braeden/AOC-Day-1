import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BasicFileRead {
    public static void main(String[] args){
        try {
            String filepath = "/workspaces/codespaces-blank/names.txt";
            readAndPrintNames(filepath);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void readAndPrintNames(String filepath) throws IOException{
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))){
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}