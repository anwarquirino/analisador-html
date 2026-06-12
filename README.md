# 🔎 Analisador de HTML

Programa em **Java** que, dado o conteúdo HTML de uma URL, retorna o trecho de texto contido no **nível mais profundo** da estrutura do documento.

> 💡 Solução para um desafio técnico de processo seletivo (estágio).

## 🎯 O problema

Dada a estrutura HTML, encontrar o texto mais profundamente aninhado:

```html
<html>
  <head>
    <title>
      Este é o título.
    </title>
  </head>
  <body>
    Este é o corpo.
  </body>
</html>
```

Retorno esperado: **"Este é o título."** — está a 3 níveis de profundidade (`html > head > title`), enquanto "Este é o corpo." está a 2 (`html > body`). Em caso de empate no nível máximo, retorna o **primeiro** trecho encontrado.

## ▶️ Como executar

```bash
git clone https://github.com/anwarquirino/analisador-html.git
cd analisador-html

javac AnalisadorHTML.java
java AnalisadorHTML <URL>
```

Exemplo:

```bash
java AnalisadorHTML http://hiring.axreng.com/internship/example1.html
```

## 🛠️ Como funciona

O programa lê o HTML da URL, percorre as tags mantendo uma pilha (`Stack`) para rastrear a profundidade atual e guarda o texto encontrado no maior nível de aninhamento.

## 🛠️ Tecnologias

- Java (apenas a biblioteca padrão — `java.net`, `java.io`, `java.util.Stack`)
