MAINCLASS = App
JAR = app.jar
SRC_DIR = .
BUILD_DIR = build

$(shell mkdir -p $(BUILD_DIR))

all: compile jar

compile:
	@echo "Compiling..."
	@javac -d $(BUILD_DIR) $(SRC_DIR)/*.java $(SRC_DIR)/*/*.java
	@echo "Done compiling."

jar: compile
	@echo "Packagine to jar..."
	@cd $(BUILD_DIR) && jar cfe $(JAR) $(MAINCLASS) *
	@echo "Done packaging."

run: jar
	@echo "Running program $(JAR)...\n------------------------"
	@cd $(BUILD_DIR) && java -cp $(JAR) $(MAINCLASS)
	@echo "------------------------\nProgram exited."

clean:
	@echo "Cleaning..."
	@rm -rf $(BUILD_DIR)/*
	@echo "Done cleaning."