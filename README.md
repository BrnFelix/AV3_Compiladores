# 🧠 Lexical Analyzer (Analisador Léxico em Java)

Este projeto implementa um Analisador Léxico simples em Java, capaz de identificar tokens (como palavras-chave, operadores, delimitadores, números e identificadores) em um código-fonte Java e gerar uma tabela de símbolos correspondente.

O projeto foi desenvolvido com foco em clareza, modularização e aprendizado sobre compiladores.

## 🚀 Funcionalidades

Leitura de um arquivo .java especificado no código.

Identificação e classificação de tokens:

Palavras-chave;
Operadores;
Delimitadores;
Números inteiros e decimais;
Identificadores;
Geração de uma lista completa de tokens;
Criação de uma tabela de símbolos (identificadores únicos);
Código totalmente modularizado em classes separadas.

## 📂 Estrutura do Projeto

```
av3_Compiladores/
 ├── src/
 │    └── lexer/
 │         ├── LexicalAnalyzer.java
 │         ├── Token.java
 │         └── TokenClassifier.java
 ├── README.md
 └── teste/
```

## ⚙️ Como Executar

### 1. Clone o repositório:

```
git clone https://github.com/<seu-usuario>/lexical-analyzer.git
cd lexical-analyzer

```

### 2. Compile o projeto:

```

javac src/lexer/*.java

```

### 3. Execute o analisador:

```

java src.lexer.LexicalAnalyzer

```

## 🧱 Tecnologias Utilizadas

Java 21;
Regex (java.util.regex) para análise léxica;
Coleções (List, Set, LinkedHashSet) para armazenar tokens e símbolos.