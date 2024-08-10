
import java.util.Map;
import java.util.Scanner;

public class CobolToJavaConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Kullanıcıdan COBOL kodunu al
        System.out.println("Lütfen COBOL kodunu girin (Çıkmak için 'exit' yazın):");
        StringBuilder cobolCode = new StringBuilder();
        String line;
        while (!(line = scanner.nextLine()).equalsIgnoreCase("exit")) {
            cobolCode.append(line).append("\n");
        }

        // COBOL kodunu parse et
        CobolParser parser = new CobolParser();
        Map<String, String> parsedCobol = parser.parseCobolCode(cobolCode.toString());

        // Java'ya çevir
        JavaTranslator translator = new JavaTranslator();
        String javaCode = translator.translateToJava(parsedCobol);

        // Java kodunu ekrana bas
        System.out.println("Oluşturulan Java Kodu:\n" + javaCode);
    }
}
