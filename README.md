# Consulta-de-HTML
obtém o trecho de texto contido no nível mais profundo da estrutura HTML de seu conteúdo.

http://hiring.axreng.com/internship/example1.html
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

Na estrutura HTML acima, o trecho desejado como retorno é "Este
é o título." (sem as aspas), porque está em 3 níveis de
profundidade (html > head > title), enquanto o trecho "Este
é o corpo." está em 2 níveis (html > body). Se dois ou mais
trechos estiverem no nível máximo de profundidade do documento,
o primeiro deles deve ser retornado.
