import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String sourceCode = "if (a + 25 <= b) { print(\"hello world\"); }";

        String[] tokens = tokenize(sourceCode);

        for (String token : tokens) {
            System.out.println(token);
        }
    }

    public static String[] tokenize(String sourceCode) {
        // Expresiones regulares para identificar los diferentes tokens
        String identifierRegex = "[a-zA-Z][a-zA-Z0-9]{0,14}";
        String integerConstantRegex = "0|100|[1-9]\\d?";
        String operatorRegex = "[+\\-*/]|:=|>=|<=|<>|[{}\\[\\]();,]";
        String stringRegex = "\"[^\"]*\"";
        String keywordRegex = "if|else|for|print|int|[bfhjk]+";

        String regex = String.format("(%s)|(%s)|(%s)|(%s)|(%s)", identifierRegex, integerConstantRegex, operatorRegex, stringRegex, keywordRegex);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sourceCode);

        // Almacenar los tokens encontrados
        StringBuilder tokenizedCode = new StringBuilder();
        while (matcher.find()) {
            String token = matcher.group().trim();
            tokenizedCode.append(token).append("\n");
        }

        return tokenizedCode.toString().split("\n");
    }
}
