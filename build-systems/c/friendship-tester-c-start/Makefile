# TODO: Vul deze Makefile zodat je met `make compile` alle bestanden in de `/src` directory compiled en linked, waarbij de object files in de `/build` directory komen, en dat de uiteindelijke binary `friendshiptester.bin` in de root directory terecht komt. Zorg er ook voor dat je met `make clean` de build directory en de binary verwijdert en dat je met `make run` het programma kan uitvoeren en dat je ook hier flags aan kan meegeven.

# Directories
SRC_DIR = src
BUILD_DIR = build

# Doel binary
TARGET = friendship-tester.bin

# Compiler en flags
CC = gcc
CFLAGS = -Wall -Wextra -std=c11

# Alle brondbestanden en objectbestanden
SRCS = $(wildcard $(SRC_DIR)/*.c)
OBJS = $(patsubst $(SRC_DIR)/%.c, $(BUILD_DIR)/%.o, $(SRCS))

# Standaard doel: bouw de binary
all: $(TARGET)

# Link de objectbestanden tot de uiteindelijke binary
$(TARGET): $(OBJS)
	$(CC) $(CFLAGS) -o $(TARGET) $(OBJS)

# Compileer .c naar .o en plaats deze in de build map
$(BUILD_DIR)/%.o: $(SRC_DIR)/%.c | $(BUILD_DIR)
	$(CC) $(CFLAGS) -c $< -o $@

# Zorg dat de build map bestaat
$(BUILD_DIR):
	mkdir -p $(BUILD_DIR)

# Geef ook de optie om 'compile' als commando mee te geven
compile: $(TARGET)

# Voer de binary uit. Eventuele argumenten meegegeven met ARGS worden doorgegeven.
run: $(TARGET)
	./$(TARGET) $(ARGS)
# run as 'make run ARGS="-dec"'

# Verwijder de binary en de build directory
clean:
	rm -f $(TARGET)
	rm -rf $(BUILD_DIR)