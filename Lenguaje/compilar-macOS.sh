# Compilar AnalizadorLexicoTiny: creará archivo AnalizadorLexicoTiny.java
# en la carpeta src/alex/ y sobreescribirá el existente
java -cp lib/jlex.jar JLex.Main src/alex/AnalizadorLexicoTiny &&
# Compilar Tiny.cup: creará los archivos ClaseLexica.java y AnalizadorSintacticoTiny.java
# en la carpeta actual (Lenguaje) y luego los copia a la carpeta /src/asint/ y los 
# elimina de la carpeta (Lenguaje)
 java -cp lib/cup.jar java_cup.Main -parser AnalizadorSintacticoTiny -symbols ClaseLexica -nopositions src/asint/Tiny.cup &&
 cd src/ &&
 cp ../AnalizadorSintacticoTiny.java asint/ &&
 cp ../ClaseLexica.java asint/ &&
 rm ../AnalizadorSintacticoTiny.java &&
 rm ../ClaseLexica.java &&
 # Compila todos los archivos .java del proyecto. Los .class se crearán dentro de bin/
 javac -cp "../lib/cup.jar:." -d ../bin */*.java &&
 # Ejecuta el programa Main con la entrada input.txt
 java -cp ".:../lib/cup.jar:../bin/" asint.Main ../inputExpresion.txt