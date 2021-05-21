## Repositorio para la práctica de Procesadores del Lenguaje

________

En la carpeta **Lenguaje/** encontrarás:

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

**Observación:** el archivo *.gitignore* se utiliza para que git ignore ciertos tipos de archivos, entre ellos los *.class*. También lo podremos utilizar para ignorar los archivos que se crean automáticamente, como *AnalizadorSintacticoTiny.java, AnalizadorLexicoTiny.java y ClaseLexica.java*.

- Documentación: https://www.overleaf.com/project/60578b6aee81be8cda759a3d


- Para ejecutar Windows (desde codigo)
wat2wasm.exe codigoPrueba.wat
node main.js
