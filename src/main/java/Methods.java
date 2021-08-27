import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.*;

public class Methods {

    public static List<String> getFromFile(String arg) throws IOException {

        Path path = Path.of(arg);
        List <String> list= Files.readAllLines(path);


        return list;
    }

    public static String getRandomQuestion(@org.jetbrains.annotations.NotNull List<String> questions) {
        Random random= new Random();
        return questions.get(random.nextInt(questions.size()));
    }

    public static String getCurrentTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }

    public static void writeInFile(Map<String, String> map) throws IOException {
        StringBuilder outputFileName = new StringBuilder();
        String date = getCurrentTimeStamp();
        outputFileName.append("D:\\вопросы-")
                .append(date)
                .append(".txt");
        // FileOutputStream output = new FileOutputStream(String.valueOf(outputFileName));
        File file = new File(String.valueOf(outputFileName));
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(file));
            for (Map.Entry<String, String> entry : map.entrySet()) {
                writer.write(entry.getKey() + " - " + entry.getValue());
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //always close the writer
                writer.close();
            } catch (Exception e) {
            }

        }

    }
}

