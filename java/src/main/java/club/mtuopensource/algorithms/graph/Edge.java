package club.mtuopensource.algorithms.graph;

/**
 * Edge
 * Represents the edge of a graph.
 *
 * @param <V>
 * @param <E>
 */
public class Edge<V, E> {
    private Vertex<V, E>[] endpoints;
    private E value;

    public Edge(Vertex<V, E> u, Vertex<V, E> v, E element) {
        this.value = element;
        endpoints = (Vertex<V, E>[]) new Vertex[]{u, v};
    }

    /**
     * GetValue
     *
     * @return the value associated with the edge.
     */
    public E getValue() {
        return value;
    }

    /**
     * GetEndpoints
     *
     * @return vertices associated with the edge.
     */
    public Vertex<V, E>[] getEndpoints() {
        return endpoints;
    }
}
