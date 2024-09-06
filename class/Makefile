# Makefile

# Directorios
SRC_DIR = src
CLASS_DIR = class
COMPILER_DIR = $(CLASS_DIR)/compiler
SCANNER_DIR = $(SRC_DIR)/scanner
PARSER_DIR = $(SRC_DIR)/parser
AST_DIR = $(SRC_DIR)/ast
SEMANTIC_DIR = $(SRC_DIR)/semantic
IRT_DIR = $(SRC_DIR)/irt
OPT_DIR = $(SRC_DIR)/opt
CODEGEN_DIR = $(SRC_DIR)/codegen

# Archivos fuente
SOURCES = $(wildcard $(SRC_DIR)/**/*.java)

# Archivos de clase
CLASSES = $(patsubst $(SRC_DIR)/%.java,$(CLASS_DIR)/%.class,$(SOURCES))

# Compilador
JAVAC = javac

# Opciones de compilación
JFLAGS = -d $(CLASS_DIR)

all: compile

compile: $(CLASSES)

# Compila todos los archivos .java a .class
$(CLASS_DIR)/%.class: $(SRC_DIR)/%.java
	@mkdir -p $(@D)
	$(JAVAC) $(JFLAGS) $<

# Ejecuta el programa
run: compile
	java -cp $(CLASS_DIR) compiler.Compiler $(ARGS)

clean:
	rm -rf $(CLASS_DIR)

.PHONY: all compile run clean
