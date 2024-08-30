# Proyecto de Scanner para Decaf

Este repositorio contiene un escáner para el lenguaje Decaf, utilizando herramientas como JFlex y JavaCup para la creación de un compilador. A continuación, se proporciona una guía para la instalación, configuración y uso del proyecto.

## Integrantes
- **Luis Villela** - 20220668
- **Daniel Hidalgo** - 20220471

## Requisitos de instalación

### Windows
1. Descarga y descomprime el archivo ZIP de JFlex desde su [página oficial](http://jflex.de).
2. Crea una variable de entorno llamada `JFLEX_HOME` con el valor de la carpeta descomprimida de JFlex.
3. Asegúrate de tener configurada la variable de entorno `JAVA_HOME` apuntando a la carpeta del JDK.
4. Agrega al `PATH` la dirección de la carpeta `bin` dentro de la carpeta de JFlex.
5. Verifica la instalación ejecutando el comando `JFLEX` en el CMD. Si está correctamente instalado, debería mostrar el banner de JFlex.

### Mac
1. Instala JFlex utilizando Homebrew con el comando:
   ```bash
   brew install jflex

# Proyecto de Scanner para Decaf

Este repositorio contiene un escáner para el lenguaje Decaf, utilizando herramientas como JFlex y JavaCup para la creación de un compilador. A continuación, se proporciona una guía para la instalación, configuración y uso del proyecto.

## Integrantes
- **Luis Villela** - 20220668
- **Daniel Hidalgo** - 20220471

## Requisitos de instalación

### Windows
1. Descarga y descomprime el archivo ZIP de JFlex desde su [página oficial](http://jflex.de).
2. Crea una variable de entorno llamada `JFLEX_HOME` con el valor de la carpeta descomprimida de JFlex.
3. Asegúrate de tener configurada la variable de entorno `JAVA_HOME` apuntando a la carpeta del JDK.
4. Agrega al `PATH` la dirección de la carpeta `bin` dentro de la carpeta de JFlex.
5. Verifica la instalación ejecutando el comando `JFLEX` en el CMD. Si está correctamente instalado, debería mostrar el banner de JFlex.

### Mac
1. Instala JFlex utilizando Homebrew con el comando:
   ```bash
   brew install jflex
   ```
2. Verifica la instalación ejecutando el comando `JFLEX` en la terminal.

## Creación del Scanner

1. Crea un archivo `.flex` que defina la estructura del escáner.
2. Ejecuta el siguiente comando dentro de la carpeta `class/scanner`:
   ```bash
   jflex scanner.flex
   ```
   Esto generará el archivo `Scanner.java`.
3. Compila el archivo `Scanner.java` para integrarlo en el compilador.

## Creación del Parser

1. Descarga JavaCup desde su [página principal](http://www2.cs.tum.edu/projects/cup/) o desde su repositorio oficial.
2. Descomprime el archivo y agrégalo al directorio actual dentro de una carpeta nueva llamada `lib`.
3. Crea un archivo `.cup` dentro de la carpeta `parser` donde definas la gramática del lenguaje.
4. Ejecuta el siguiente comando:
   ```bash
   java -cp [path del archivo .jar de java_cup] java_cup.Main -parser [nombre del archivo Parser] -symbols [nombre del archivo sym] [path del archivo .cup]
   ```
   Ejemplo:
   ```bash
   java -cp "C:\Users\danyl\OneDrive\Escritorio\Scanner\class\lib\java-cup-bin-11b-20160615\java-cup-11b.jar;." java_cup.Main -parser Parser -symbols sym C:\Users\danyl\OneDrive\Escritorio\Scanner\class\parser\parser.cup
   ```
   Esto generará los archivos `Parser.java` y `sym.java`.

5. Compila los archivos `sym.java` y `Parser.java` para usarlos posteriormente en el compilador.

## Creación de la Carpeta `opt`

1. Crea una carpeta `opt` que contenga los archivos `Algebraic.java` y `Constant.java`.
2. `Algebraic.java` proporciona métodos para realizar operaciones matemáticas básicas.
3. `Constant.java` se enfoca en el procesamiento de valores de punto flotante.

4. Compila el proyecto completo con el siguiente comando:
   ```bash
   javac -cp "class\lib\java-cup-bin-11b-20160615\java-cup-11b.jar;class\opt;." class\opt\Algebraic.java class\opt\ConstantF.java class\parser\Parser.java class\parser\sym.java class\scanner\Scanner.java
   ```

## Problemas con JavaCup

Se creó una carpeta `.vscode` fuera de la carpeta `class`, la cual contiene archivos JSON con paths necesarios para ejecutar JavaCup y `parser.cup`.

## Creación del Compilador

1. Dentro del directorio `compiler`, se encuentran dos archivos: `input.txt` y `output.txt`.
   - `input.txt` contiene la información que el usuario desea compilar.
   - `output.txt` muestra la salida del escáner.

2. Para compilar el proyecto completo, ejecuta el siguiente comando:
   ```bash
   javac -d class -cp "class\lib\java-cup-bin-11b-20160615\java-cup-11b.jar;class\opt;." class\opt\Algebraic.java class\opt\ConstantF.java class\parser\Parser.java class\parser\sym.java class\scanner\Scanner.java class\compiler\Compiler.java
   ```

3. Para ejecutar el compilador desde la carpeta principal:
   ```bash
   java -cp "class\lib\java-cup-bin-11b-20160615\java-cup-11b.jar;class\opt;class" compiler.Compiler
   ```

## Makefile

El Makefile se encarga de compilar y ejecutar todo el proyecto. Asegúrate de que los directorios importantes, como `Compiler.java` y `Scanner.java`, estén correctamente especificados para facilitar la ejecución.
