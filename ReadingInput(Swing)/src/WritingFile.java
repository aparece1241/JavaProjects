import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WritingFile {
    public static void main(String[] args) throws FileNotFoundException {
        //opens the file or create the file
        //if the file doesn't exist create the file
        //if the file exist replace the file
        PrintWriter ouputfile = new PrintWriter("OutPutFile.txt");

        ouputfile.println("This is line 1");
        ouputfile.println("This is line 2");
        ouputfile.println("This is line 3");
        ouputfile.print("Exist");
    }
}
