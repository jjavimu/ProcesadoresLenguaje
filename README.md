## Práctica de Procesadores del Lenguaje

________

En la carpeta **Lenguaje/** encontrarás:

- **`codigo/`** 

  En esta carpeta están los archivos *codigoInput.wasm*, *codigoInput.wat*, *main.js*, *wat2wasm* y *wat2wasm.exe* necesarios para la generación de código.

- **`lib/`** 

  En esta carpeta están los archivos *jlex.jar* y *cup.jar* necesarios para la compilación del analizador léxico y del analizador sintáctico.

- **`src/`** 

  - **`alex/`**
  
    Archivos *.java* para el analizador léxico y archivo *AnalizadorLexicoTiny* que utiliza jlex para el léxico de nuestro lenguaje.

  - **`asint/`**

    Archivos *.java* para el analizador sintáctico y archivo *Tiny.cup* para generar la gramática del lenguaje con CUP.

  - **`ast/`**
  
    Archivos *.java* para la creación del AST.
  
  - **`errors/`**

    Archivos *.java* para la gestión de errores léxicos y sintácticos.

- **`compilar-macOS.sh`**

  Script para facilitar la compilación del proyecto en macOS y Linux. Es recomendable tener uno también para Windows.

- **`input*.txt`**

  Archivos de entrada para para probar las distintas partes de nuestro lenguaje.


- **Para ejecutar desde Windows**
  - script.bat

- **Para ejecutar desde MacOS (y posiblemente Linux)**
  - compilar-macOS.sh