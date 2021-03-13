## Repositorio para la práctica de Procesadores del Lenguaje

________

En esta carpeta encontrarás:

- **`bin/`**
  
  En esta carpeta se guardan los *.class* generados al compilar los archivos de java.
  
  (El archivo *.gitignore* hace que esos archivos no se suban a GitHub).

- **`lib/`** 

  En esta carpeta están los archivos *jlex.jar* y *cup.jar* necesarios para la compilación del analizador léxico y del analizador sintáctico.

- **`src/`** 

  - **`alex/`**
  
    Archivos *.java* para el analizador léxico y archivo *AnalizadorLexicoTiny* que utiliza jlex para el léxico de nuestro lenguaje.
  - **`asint/`**

    Archivos *.java* para el analizador sintáctico y archivo *Tiny.cup* para generar la gramática del lenguaje con CUP.
  - **`errors/`**

    Archivos *.java* para la gestión de errores.

- **`compilar-macOS.sh`**


  Script para facilitar la compilación del proyecto en macOS y Linux. Es recomendable tener uno también para Windows.

- **`input.txt`**

  Archivo de entrada para que reconozca nuestro lenguaje.
