package src.lexer;

import java.util.*;
import java.util.regex.*;

@SuppressWarnings("ObsoleteAnnotationSupportedSource")
public class TokenClassifier {

    private static final Set<String> KEYWORDS = new HashSet<>(Arrays.asList(
        "public", "private", "protected", "class", "static", "void", "int",
        "float", "double", "boolean", "if", "else", "for", "while", "return",
        "new", "this", "import", "package", "String", "true", "false"
    ));

    private static final Set<String> OPERATORS = new HashSet<>(Arrays.asList(
        "+", "-", "*", "/", "=", "==", "!=", ">", "<", ">=", "<=", "&&", "||"
    ));

    private static final Set<String> DELIMITERS = new HashSet<>(Arrays.asList(
        ";", "{", "}", "(", ")", "[", "]", ",", "."
    ));

    public static String classify(String token) {
        if (KEYWORDS.contains(token)) return "Palavra-chave";
        if (OPERATORS.contains(token)) return "Operador";
        if (DELIMITERS.contains(token)) return "Delimitador";
        if (token.matches("\\d+")) return "Número inteiro";
        if (token.matches("\\d+\\.\\d+")) return "Número decimal";
        if (token.matches("[a-zA-Z_]\\w*")) return "Identificador";
        return "Desconhecido";
    }

    public static Pattern getPattern() {
        return Pattern.compile("(\\b\\w+\\b|==|!=|>=|<=|&&|\\|\\||[;{}()\\[\\],.+\\-*/=<>])");
    }
}
