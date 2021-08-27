import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        List<String> questions = Methods.getFromFile(args[1]);
        List<String> names = Methods.getFromFile(args[0]);

        Map<String, String> output = new HashMap<>();
        for (String name : names) {
            String question = Methods.getRandomQuestion(questions);
            output.put(name, question);
            questions.remove(question);
        }
       Methods.writeInFile(output);
    }


}
