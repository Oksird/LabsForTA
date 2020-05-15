import com.opencsv.CSVWriter;

import java.io.*;
import java.util.Random;

public class Finder {

    final static String FILE_PATH = "C:\\TADS\\FileN.csv";


    public static void main(String[] args) {
        Random random = new Random();
        //Limits of fields
        int maxX = 300000;
        int maxY = 300000;
        int maxHeight = 828;
        // Structure of object
        int x= random.nextInt(maxX);
        int y = random.nextInt(maxY);
        int height = random.nextInt(maxHeight);
        // Count of elements
        int count = 1000000;
        int result = 0;
        long elapsedTime = 0;
        int heightToCompare = 400;

        try {
            File file = new File(FILE_PATH);

            FileWriter fileWriter = new FileWriter(file);

            CSVWriter writer = new CSVWriter(fileWriter);

            String[] header = { "X", "Y", "Height" };
            writer.writeNext(header);

            String[] data = new String[3];
            long start = System.currentTimeMillis();
            for (int i = 0; i <count ; i++) {                                //n
                data[0]= String.valueOf(x);                                  //1
                data[1] = String.valueOf(y);                                 //1
                data[2] = String.valueOf(height);                            //1
                if(Integer.parseInt(data[2])>heightToCompare)                //1
                    result++;                                               //1
                writer.writeNext(data);                                     //1

            }
            long end = System.currentTimeMillis();

            elapsedTime = end - start;

            writer.close();

        }
        catch (IOException e){

        }
        System.out.println(result);
        System.out.println("TIME = "+elapsedTime);
    }
}
