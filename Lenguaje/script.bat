java -cp lib/jlex.jar JLex.Main src/alex/AnalizadorLexicoTiny 

java -cp lib/cup.jar java_cup.Main -parser AnalizadorSintacticoTiny -symbols ClaseLexica -nopositions src/asint/Tiny.cup 
copy AnalizadorSintacticoTiny.java src\asint\AnalizadorSintacticoTiny.java 
del AnalizadorSintacticoTiny.java 
copy ClaseLexica.java src\asint\ClaseLexica.java 
del ClaseLexica.java

cd src
javac -cp "../lib/cup.jar;." alex/*.java asint/*.java errors/*.java ast/*.java ast/accesos/*.java ast/estructuras/*.java ast/expresiones/*.java ast/funciones/*.java ast/instrucciones/*.java ast/tipos/*.java
java -cp ".;../lib/cup.jar" asint/Main ../input5Codigo.txt 

cd ../

REM ------- solo para ejecucion del ejemplo de codigo
 cd codigo
 wat2wasm.exe codigoInput.wat
 node main.js
 cd ../
REM -------
pause