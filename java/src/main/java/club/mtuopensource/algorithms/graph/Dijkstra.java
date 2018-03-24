package club.mtuopensource.algorithms.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Dijkstra
 * An implementation of Dijkstra's Algorithm.
 * @param <V>
 */
public class Dijkstra<V> {
    private Graph<V, Double> graph;
    private Map<Vertex<V, Double>, Vertex<V, Double>> previous = new HashMap<>();
    private Map<Vertex<V, Double>, Double> distance = new HashMap<>();
    private PriorityQueue<Wrapper> pq = new PriorityQueue<>();
    private List<Vertex<V, Double>> visited = new ArrayList<>();
    private Vertex<V, Double> source;

    public Dijkstra(Graph<V, Double> graph, Vertex<V, Double> source) {
        this.graph = graph;
        execute(source);
    }

    /**
     * Execute
     * Completes a shortest path search, using Dijkstra's Algorithm.
     * @param source vertex to begin searching at.
     */
    public void execute(Vertex<V, Double> source) {
        this.source = source;
        previous.clear();
        distance.clear();
        pq.clear();
        visited.clear();
        distance.put(source, 0.0); /* We're already here, so the distance is zero. */
        for(Vertex<V, Double> vertex : graph.vertices()) {
            if(vertex != source) {
                /* Assume that all other nodes are infinitely far away, since we
                 * haven't started searching yet. */
                distance.put(vertex, Double.MAX_VALUE);
                previous.put(vertex, null);
            }
            pq.offer(new Wrapper(vertex, distance.get(vertex)));
        }
        while(pq.size() > 0) {
            Vertex<V, Double> u = pq.poll().getVertex();
            visited.add(u); /* Remember that we've been here before. */
            for(Edge<V, Double> e : graph.outgoingEdges(u)) {
                Vertex<V, Double> v = graph.opposite(u, e);
                if(visited.contains(v) == false) {
                    double weight = distance.get(u) + e.getValue(); /* Relaxation */
                    if(weight < distance.get(v)) {
                        distance.put(v, weight); /* We've found a better cost, remember it. */
                        previous.put(v, u); /* We've found a shorter path, remember it. */
                        new PriorityQueue<>(pq).forEach((x) -> {
                            if(x.vertex == v) {
                                pq.remove(x); /* Update the PriorityQueue */
                                pq.offer(new Wrapper(v, weight));
                            }
                        });
                    }
                }
            }
        }
    }

    /**
     * GetDistanceMap
     * @return map between an arbitrary vertex and the cost to reach it.
     */
    public Map<Vertex<V, Double>, Double> getDistanceMap() {
        return distance;
    }

    /**
     * GetPrevious
     * @return cloud containing vertices reachable from the source vertex.
     */
    public Map<Vertex<V, Double>, Vertex<V, Double>> getPrevious() {
        return previous;
    }

    /**
     * GetPathTo
     * @param destination vertex.
     * @return a linked list representing the shortest path from source to destination.
     */
    public LinkedList<Vertex<V, Double>> getPathTo(Vertex<V, Double> destination) {
        LinkedList<Vertex<V, Double>> path = new LinkedList<>();
        Vertex<V, Double> current = destination; /* Work backwards from the destination. */
        while(current != source) {
            path.addFirst(current); /* Flip Data */
            current = previous.get(current);
        }
        path.addFirst(current); /* Flip Data */
        return path;
    }

    /**
     * Wrapper
     * Associates a cost with a Vertex. Used to naturally order the PQ.
     */
    private class Wrapper implements Comparable<Wrapper> {
        private Vertex<V, Double> vertex;
        private double value;

        public Wrapper(Vertex<V, Double> vertex, double value) {
            this.vertex = vertex;
            this.value = value;
        }

        public Vertex<V, Double> getVertex() {
            return vertex;
        }

        @Override
        public int compareTo(Wrapper o) {
            return Double.compare(value, o.value);
        }
    }
}
