package club.mtuopensource.algorithms.test.graph;

import club.mtuopensource.algorithms.graph.Dijkstra;
import club.mtuopensource.algorithms.graph.Graph;
import club.mtuopensource.algorithms.graph.Vertex;
import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertTrue;

public class TestDijkstra {
    @Test
    public void testDistances() {
        Graph<Integer, Double> graph = new Graph<>(false);

        List<Vertex<Integer, Double>> vertices = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            vertices.add(graph.insertVertex(i));
        }

        graph.insertEdge(vertices.get(0), vertices.get(1), 24.);
        graph.insertEdge(vertices.get(0), vertices.get(3), 20.);
        graph.insertEdge(vertices.get(2), vertices.get(0), 3.);
        graph.insertEdge(vertices.get(3), vertices.get(2), 12.);

        Dijkstra<Integer> dijkstra = new Dijkstra<>(graph, vertices.get(0));
        Map<Vertex<Integer, Double>, Double> distances = dijkstra.getDistanceMap();

        assertTrue(distances.get(vertices.get(1)) == 24.0);
        assertTrue(distances.get(vertices.get(2)) == 3.0);
        assertTrue(distances.get(vertices.get(3)) == 15.0);
    }
}
