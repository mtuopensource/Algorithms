package club.mtuopensource.algorithms.graph;

import java.util.HashMap;
import java.util.Map;

/**
 * Vertex
 * Represents the vertex of a graph.
 *
 * @param <V>
 * @param <E>
 */
public class Vertex<V, E> {
    private V value;
    private Map<Vertex<V, E>, Edge<V, E>> outgoing, incoming;

    public Vertex(V element, boolean directed) {
        this.value = element;
        outgoing = new HashMap<>();
        if (directed) {
            incoming = new HashMap<>();
        } else {
            /**
             * If the graph is undirected, the incoming edges will be the same
             * as the outgoing edges.
             */
            incoming = outgoing;
        }
    }

    /**
     * GetValue
     *
     * @return the value associated with the vertex.
     */
    public V getValue() {
        return value;
    }

    /**
     * SetValue
     * Updates the value associated with the vertex.
     *
     * @param value
     */
    public void setValue(V value) {
        this.value = value;
    }

    /**
     * GetOutgoing
     *
     * @return an map between the vertex and it's outgoing edges.
     */
    public Map<Vertex<V, E>, Edge<V, E>> getOutgoing() {
        return outgoing;
    }

    /**
     * GetIncoming
     *
     * @return an map between the vertex and it's incoming edges.
     */
    public Map<Vertex<V, E>, Edge<V, E>> getIncoming() {
        return incoming;
    }
}
