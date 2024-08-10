
public class JavaTranslator {

    public String translateToJava(Map<String, String> cobolElements) {
        StringBuilder javaCode = new StringBuilder();

        for (Map.Entry<String, String> entry : cobolElements.entrySet()) {
            switch (entry.getKey()) {
                case "print":
                    javaCode.append("System.out.println(\"").append(entry.getValue()).append("\");\n");
                    break;
                case "assign":
                    javaCode.append(entry.getValue()).append(";\n");
                    break;
                case "if":
                    javaCode.append("if (").append(entry.getValue()).append(") {\n");
                    break;
                case "loop":
                    javaCode.append("for (int i = 0; i < ").append(entry.getValue()).append("; i++) {\n");
                    break;
                default:
                    break;
            }
        }

        // Koşullu ifadeler ve döngüler için kapatma parantezlerini ekleyelim
        if (cobolElements.containsKey("if")) {
            javaCode.append("}\n");
        }
        if (cobolElements.containsKey("loop")) {
            javaCode.append("}\n");
        }

        return javaCode.toString();
    }
}
