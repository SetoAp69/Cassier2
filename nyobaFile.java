import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class nyobaFile {
    public static Scanner input=new Scanner(System.in);

    public static void main(String[] args) {
        File myObj=new File("D:\\"+"File0"+".txt");
        int duplicate=1;

        while(myObj.exists()){
            duplicate++;
            myObj=new File("D:\\"+"File"+duplicate+".txt");
        }

        if(myObj.exists()==false){
            try{

                myObj.createNewFile();
            }
            catch (IOException e){

            }
        }
    }

}
