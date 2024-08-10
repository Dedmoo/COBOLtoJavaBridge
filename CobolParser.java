
import java.util.HashMap;
import java.util.Map;

public class CobolParser {

    public Map<String, String> parseCobolCode(String cobolCode) {
        Map<String, String> parsedCode = new HashMap<>();

        if (cobolCode.contains("DISPLAY")) {
            parsedCode.put("print", cobolCode.substring(cobolCode.indexOf("DISPLAY") + 8).trim());
        }

        if (cobolCode.contains("MOVE")) {
            String[] parts = cobolCode.split(" TO ");
            String value = parts[0].replace("MOVE", "").trim();
            String variable = parts[1].trim();
            parsedCode.put("assign", variable + " = " + value);
        }

        if (cobolCode.contains("IF")) {
            String condition = cobolCode.substring(cobolCode.indexOf("IF") + 3, cobolCode.indexOf("THEN")).trim();
            parsedCode.put("if", condition);
        }

        if (cobolCode.contains("PERFORM")) {
            String loop = cobolCode.substring(cobolCode.indexOf("PERFORM") + 8).trim();
            parsedCode.put("loop", loop);
        }

        return parsedCode;
    }
}
