MAIN = app.py
TARGET = friendshiptester.bin
DIST_DIR = dist

compile:
	@echo "Copmiling $(MAIN) to $(TARGET)..."
	pyinstaller --onefile --name $(TARGET) $(MAIN)
	@mkdir -p (DIST_DIR)
	@mv $(TARGET) $(DIST_DIR)/
	@echo "Done comipling."

clean:
	@echo "Cleaning..."
	-rm -R ./dist/*
	-rm -R ./build/*
	@echo "Done cleaning."

test:
	@echo "Testing program $(MAIN)...\n---------------------------"
	python3 $(MAIN)
	@echo "---------------------------\nProgram exited."

run:
	@echo "Running $(TARGET)...\n---------------------------"
	@cd ./dist && ./$(TARGET)
	@echo "---------------------------\nProgram exited."