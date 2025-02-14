import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Stack;

public class AnalisadorHTML {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java AnalisadorHTML <URL>");
            return;
        }

        String urlString = args[0];

        try {
            URL url = new URL(urlString);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;
            int currentDepth = 0;
            int maxTextDepth = -1;
            String deepestText = null;
            Stack<String> tagStack = new Stack<>();

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }

                // Verifica se a linha é uma tag (abertura ou fechamento)
                if (line.startsWith("<") && line.endsWith(">")) {
                    if (line.startsWith("</")) {
                        // Linha de tag de fechamento
                        String tagName = line.substring(2, line.length() - 1).trim();
                        if (tagStack.isEmpty() || !tagStack.peek().equals(tagName)) {
                            System.out.println("malformed HTML");
                            reader.close();
                            return;
                        }
                        tagStack.pop();
                        currentDepth--;
                    } else {
                        // Linha de tag de abertura
                        String tagName = line.substring(1, line.length() - 1).trim();
                        tagStack.push(tagName);
                        currentDepth++;
                    }
                } else {
                    // Linha de texto: registra se esta for a primeira no nível máximo de profundidade
                    if (currentDepth > maxTextDepth) {
                        maxTextDepth = currentDepth;
                        deepestText = line;
                    }
                }
            }
            reader.close();

            // Se ainda houver tags não fechadas, o HTML está malformado.
            if (!tagStack.isEmpty()) {
                System.out.println("malformed HTML");
                return;
            }

            // Exibe o trecho de texto identificado, se houver.
            if (deepestText != null) {
                System.out.println(deepestText);
            }
        } catch (IOException e) {
            System.out.println("URL connection error");
        }
    }
}
