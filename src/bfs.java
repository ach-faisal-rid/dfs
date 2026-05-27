import java.util.*;

public class bfs {
    static Map<String, List<String>> graph = new HashMap<>();

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

        System.out.println("Proses BFS:");
        bfs("a0", target);
    }

    static void bfs(String start, String target) {

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {

            String node = queue.poll();

            System.out.println("Mengunjungi: " + node);

            if (node.equals(target)) {
                System.out.println("Target ditemukan: " + target);
                return;
            }

            for (String neighbor : graph.get(node)) {

                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }
}
