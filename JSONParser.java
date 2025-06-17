import java.util.*;
public class JSONParser {
    public static Map<String, Object> parseJSON(String json) {
        Map<String, Object> map = new HashMap<>();
        json = json.trim();        
        if (!json.startsWith("{") || !json.endsWith("}")) {
            System.out.println("Invalid JSON format.");
            return map;
        }
        json = json.substring(1, json.length() - 1);  
        String[] pairs = json.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
        for (String pair : pairs) {
            String[] keyValue = pair.split(":", 2);
            if (keyValue.length != 2) continue;
            String key = keyValue[0].trim().replace("\"", "");
            String value = keyValue[1].trim();
            if (value.startsWith("\"") && value.endsWith("\"")) {
                map.put(key, value.substring(1, value.length() - 1));
            } else if (value.equals("true") || value.equals("false")) {
                map.put(key, Boolean.parseBoolean(value));
            } else {
                try {
                    map.put(key, Integer.parseInt(value));
                } catch (NumberFormatException e) {
                    map.put(key, value); 
                }
            }
        }
        return map;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a simple JSON object (e.g., {\"name\":\"Alice\",\"age\":25,\"isStudent\":true}):");
        String jsonInput = scanner.nextLine();
        Map<String, Object> parsed = parseJSON(jsonInput);
        System.out.println("\nParsed JSON as Map:");
        for (Map.Entry<String, Object> entry : parsed.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue() + " (" + entry.getValue().getClass().getSimpleName() + ")");
        }
    }
}
