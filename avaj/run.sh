find . -name "*.java" > sources.txt
javac -sourcepath . @sources.txt
java src.simulation.controllers.Simulator src/scenario.txt