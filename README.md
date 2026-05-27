# Tugas 3 - Implementasi DFS dan BFS dalam Java

Proyek ini mengimplementasikan dua algoritma pencarian graf, yaitu **Depth-First Search (DFS)** dan **Breadth-First Search (BFS)** menggunakan bahasa pemrograman Java.

---

## 📁 Struktur Proyek

```
dfs/
├── src/
│   ├── dfs.java      # Implementasi algoritma DFS
│   ├── bfs.java      # Implementasi algoritma BFS
│   └── Main.java     # File utama (template IntelliJ)
└── README.md
```

---

## 🌐 Struktur Graf

Graf yang digunakan pada kedua algoritma adalah sebagai berikut:

```
            a0
           /   \
          a1    a2
         / \   / \
        a3  a4 a5  a6
        |   |  |
        a7  a8 a9
```

| Node | Tetangga         |
|------|------------------|
| a0   | a1, a2           |
| a1   | a3, a4           |
| a2   | a5, a6           |
| a3   | a7               |
| a4   | a8               |
| a5   | a9               |
| a6   | (tidak ada)      |
| a7   | (tidak ada)      |
| a8   | (tidak ada)      |
| a9   | (tidak ada)      |

**Target pencarian:** `a8`

---

## 🔍 Algoritma DFS (Depth-First Search)

### Penjelasan
DFS adalah algoritma pencarian yang menelusuri graf **sedalam mungkin** terlebih dahulu sebelum mundur (*backtrack*) dan mencoba jalur lain. Algoritma ini menggunakan **rekursi** (secara implisit menggunakan stack).

### Cara Kerja
1. Mulai dari node awal (`a0`)
2. Tandai node sebagai sudah dikunjungi
3. Kunjungi node tersebut
4. Jika node adalah target, hentikan pencarian
5. Rekursif ke setiap tetangga yang belum dikunjungi

### Output Program
```
Proses DFS:
Mengunjungi: a0
Mengunjungi: a1
Mengunjungi: a3
Mengunjungi: a7
Mengunjungi: a4
Mengunjungi: a8
Target ditemukan: a8
```

### Source Code
```java
import java.util.*;

public class dfs {
    static Map<String, List<String>> graph = new HashMap<>();
    static Set<String> visited = new HashSet<>();

    public static void main(String[] args) {
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
        if (visited.contains(node)) return;

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
```

---

## 🔍 Algoritma BFS (Breadth-First Search)

### Penjelasan
BFS adalah algoritma pencarian yang menelusuri graf **selapis demi selapis** (level by level). Algoritma ini menggunakan struktur data **Queue (antrian)** untuk menentukan urutan kunjungan.

### Cara Kerja
1. Masukkan node awal (`a0`) ke dalam queue
2. Ambil node dari depan queue
3. Kunjungi node tersebut
4. Jika node adalah target, hentikan pencarian
5. Masukkan semua tetangga yang belum dikunjungi ke dalam queue
6. Ulangi hingga queue kosong atau target ditemukan

### Output Program
```
Proses BFS:
Mengunjungi: a0
Mengunjungi: a1
Mengunjungi: a2
Mengunjungi: a3
Mengunjungi: a4
Mengunjungi: a5
Mengunjungi: a6
Mengunjungi: a7
Mengunjungi: a8
Target ditemukan: a8
```

### Source Code
```java
import java.util.*;

public class bfs {
    static Map<String, List<String>> graph = new HashMap<>();

    public static void main(String[] args) {
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
```

---

## ⚖️ Perbandingan DFS vs BFS

| Aspek               | DFS                          | BFS                          |
|---------------------|------------------------------|------------------------------|
| Struktur Data       | Stack (rekursi)              | Queue                        |
| Arah Pencarian      | Sedalam mungkin dulu         | Selapis demi selapis         |
| Jalur yang Ditemukan| Tidak selalu terpendek       | Selalu terpendek (unweighted)|
| Penggunaan Memori   | Lebih hemat (untuk graf lebar)| Lebih besar (simpan semua level)|
| Cocok untuk         | Maze, backtracking, topological sort | Shortest path, level-order traversal |

---

## ▶️ Cara Menjalankan

### Prasyarat
- Java JDK 8 atau lebih baru
- IntelliJ IDEA (opsional)

### Via Terminal
```bash
# Masuk ke folder src
cd src

# Kompilasi
javac dfs.java
javac bfs.java

# Jalankan DFS
java dfs

# Jalankan BFS
java bfs
```

### Via IntelliJ IDEA
1. Buka folder `dfs/` sebagai project
2. Buka file `dfs.java` atau `bfs.java`
3. Klik tombol ▶️ Run di sebelah method `main`

---

## 👤 Informasi

| Keterangan | Detail          |
|------------|-----------------|
| Mata Kuliah | Kecerdasan Buatan |
| Tugas      | Tugas 3         |
| Topik      | Graph Search: DFS & BFS |
| Bahasa     | Java            |
