# Makefile for compiling the project

# Compiler
JAVAC = javac

# Flags
JFLAGS = -cp grupoNN:.

# Directories
SRC_DIR = compiler
SCAN_DIR = scanner

# Output directory
OUT_DIR = grupoNN

# Main class
MAIN_CLASS = Compiler

# All class files
CLASSES = $(SCAN_DIR)/Scanner.java $(SRC_DIR)/Compiler.java

# Default target
all: $(OUT_DIR)/$(MAIN_CLASS).class

# Compile the Java files
$(OUT_DIR)/$(MAIN_CLASS).class: $(CLASSES)
	mkdir -p $(OUT_DIR)
	$(JAVAC) $(CLASSES) -d $(OUT_DIR) $(JFLAGS)

# Clean up
clean:
	rm -rf $(OUT_DIR)