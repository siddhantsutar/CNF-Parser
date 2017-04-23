all: 
	javac -d bin src/*.java
	jar cfm CNFParser.jar Manifest.txt -C bin .
	java -jar CNFParser.jar

clean:
	rm CFG.jar bin/*