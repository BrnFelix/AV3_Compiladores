package src.lexer;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class LexicalAnalyzer {

    private final List<Token> tokens = new ArrayList<>();
    private final LinkedHashSet<String> symbolTable = new LinkedHashSet<>();

    public static void main(String[] args) {
        LexicalAnalyzer analyzer = new LexicalAnalyzer();
        analyzer.run("Teste.java"); // altere o nome do arquivo aqui
    }

    public void run(String filePath) {
        try {
            String code = readFile(filePath);
            analyze(code);

            System.out.println("===== LISTA DE TOKENS =====");
            for (Token t : tokens) {
                System.out.printf("%-15s -> %s%n", t.getValue(), t.getType());
            }

            System.out.println("\n===== TABELA DE SÍMBOLOS =====");
            int index = 1;
            for (String symbol : symbolTable) {
                System.out.printf("%02d. %s%n", index++, symbol);
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    private String readFile(String path) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append(" ");
            }
        }
        return content.toString();
    }

    private void analyze(String code) {
        Pattern pattern = TokenClassifier.getPattern();
        Matcher matcher = pattern.matcher(code);

        while (matcher.find()) {
            String tokenValue = matcher.group();
            String type = TokenClassifier.classify(tokenValue);

            tokens.add(new Token(tokenValue, type));

            if (type.equals("Identificador")) {
                symbolTable.add(tokenValue);
            }
        }
    }
}
