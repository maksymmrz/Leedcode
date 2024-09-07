package maksym.preparation.util;

import java.util.*;
import java.util.stream.Collectors;

public class Node {
    public int val;
    public List<Node> neighbors;

    public Node(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }

    public Node(int val, List<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }

    public static Node node(int v, List<Node> neighbors) {
        return new Node(v, neighbors);
    }

    public static Node node(int v) {
        return new Node(v);
    }

    public static List<Integer> dfs(Node graph) {
        return dfs(graph, new HashSet<>()).stream()
                .map(n -> n.val)
                .collect(Collectors.toList());
    }

    private static List<Node> dfs(Node node, Set<Node> visited) {
        if (node != null && visited.add(node)) {
            List<Node> tail = node.neighbors.stream()
                    .flatMap(n -> dfs(n, visited).stream())
                    .collect(Collectors.toList());
            List<Node> result = new ArrayList<>();
            result.add(node);
            result.addAll(tail);
            return result;
        } else return Collections.emptyList();
    }
}
