import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;


public class StarWars {

  public static void main(String[] args) throws IOException {
//  Create an array list of names using the information in characters.txt.
  File characterFile = new File("/Users/nicmac/challenges/java-star-wars-analysis/src/main/resources/characters.txt");
  List<String> nameList = new ArrayList<String>();
  Scanner scanner = new Scanner(characterFile);
  while(scanner.hasNextLine()){
    nameList.add(scanner.nextLine());
  }
    System.out.println("Part 1:");
    System.out.println(nameList);
    System.out.println("=====================");

    nameList.add("Biggs");
    nameList.add("Wedge");
    int leiaIndex = nameList.indexOf("Leia");
    int lukeIndex = nameList.indexOf("Luke");
    String darth = "Darth Vader";
    nameList.add(lukeIndex < leiaIndex ? leiaIndex : lukeIndex,darth);
    nameList.remove("Han");
    System.out.println("Part 2:");
    System.out.println(nameList);
    System.out.println("=====================");

    Map<String, String> nameMap = new HashMap<String, String>();
    for(String name : nameList){
      nameMap.put(name, "Unknown");
    }
    System.out.println("Part 3:");
    System.out.println(nameMap);
    System.out.println("=====================");


    File lastNamesFile = new File("/Users/nicmac/challenges/java-star-wars-analysis/src/main/resources/last-names.json");
    Map<String, String> lastNamesMap = new HashMap();
    ObjectMapper mapper = new ObjectMapper();
    lastNamesMap = mapper.readValue(lastNamesFile, HashMap.class);

    Set<String> names = nameMap.keySet();
    for (String name : names){
      String lastNames = lastNamesMap.get(name);
      nameMap.put(name, lastNames);
    }
    System.out.println("Part 4:");
    System.out.println(nameMap);
    System.out.println("=====================");


    System.out.println("Part 5:");
    nameMap.remove("Obi-Wan", "Kenobi");
    System.out.println(nameMap);
    System.out.println("=====================");

    System.out.println("Part 6:");
    Set<String> firstNamesWithL = nameMap.keySet();
    for (String name : firstNamesWithL){
      if(name.contains("L")){
        System.out.println(name);
      }
    }
    System.out.println("=====================");

for(Entry<String, String> entry : lastNamesMap.entrySet() ){
  String key = entry.getKey();
  String value = entry.getValue();
  if (value.contains("Antilles")) {
    System.out.println(key);
  }
}
  }
}
