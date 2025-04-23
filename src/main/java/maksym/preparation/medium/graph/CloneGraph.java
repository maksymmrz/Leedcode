package maksym.preparation.medium.graph;

import maksym.preparation.util.Node;

import java.util.*;
import java.util.stream.Collectors;

import static maksym.preparation.util.Node.node;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        return copyG(node, new HashMap<>());
    }

    public Node copyG(Node curr, Map<Node, Node> copies) {
        if (curr == null) return null;
        else if (copies.containsKey(curr)) return copies.get(curr);
        else {
            Node copy = new Node(curr.val);
            copies.put(curr, copy);

            copy.neighbors = curr.neighbors.stream().map(n -> copyG(n, copies)).collect(Collectors.toList());
            return copy;
        }
    }

    public static void main(String[] args) {
        CloneGraph instance = new CloneGraph();
        Node n1 = node(1);
        Node n2 = node(2);
        Node n3 = node(3);
        Node n4 = node(4);
        n1.neighbors = List.of(n2, n4);
        n2.neighbors = List.of(n1, n3);
        n3.neighbors = List.of(n2, n4);
        n4.neighbors = List.of(n3, n1);
        Node.dfs(n1).forEach(System.out::println);
        System.out.println();
        Node.dfs(instance.cloneGraph(n1)).forEach(System.out::println);

    }
}
