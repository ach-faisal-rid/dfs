import java.util.*;

public class dfs {
    static Map<String, List<String>> graph = new HashMap<>();
    static Set<String> visited = new HashSet<>();

    public static void main(String[] args) {

        // Membuat graf
        graph.put("a0", Arrays.asList("a1", "a2"));
        graph.put("a1", Arrays.asList("a3", "a4"));
        graph.put("a2", Arrays.asList("a5", "a6"));
        graph.put("a3", Arrays.asList("a7"));
        graph.put("a4", Arrays.asList("a8"));
        graph.put("a5", Arrays.asList("a9"));
        graph.put("a6", new ArrayList<>());
        graph.put("a7", new ArrayList<>());
        graph.put("a8", new ArrayList<>());
        graph.put("a9", new ArrayList<>());

        String target = "a8";

        System.out.println("Proses DFS:");
        dfs("a0", target);
    }

    static void dfs(String node, String target) {

        if (visited.contains(node)) {
            return;
        }

        visited.add(node);

        System.out.println("Mengunjungi: " + node);

        if (node.equals(target)) {
            System.out.println("Target ditemukan: " + target);
            return;
        }

        for (String neighbor : graph.get(node)) {
            dfs(neighbor, target);
        }
    }
}
