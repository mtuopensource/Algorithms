package club.mtuopensource.algorithms.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Graph
 * A Graph implementation compatible with both directed and undirected graphs.
 * Implemented using an adjacency map.
 *
 * @param <V>
 * @param <E>
 */
public class Graph<V, E> {
    private boolean directed;
    private LinkedList<Vertex<V, E>> vertices = new LinkedList<>();
    private LinkedList<Edge<V, E>> edges = new LinkedList<>();

    public Graph(boolean directed) {
        this.directed = directed;
    }

    /**
     * NumVertices
     *
     * @return the number of vertices in the graph.
     */
    public int numVertices() {
        return vertices.size();
    }

    /**
     * Vertices
     *
     * @return an iterable containing the vertices in the graph.
     */
    public Iterable<Vertex<V, E>> vertices() {
        return vertices;
    }

    /**
     * NumEdges
     *
     * @return the number of edges in the graph.
     */
    public int numEdges() {
        return edges.size();
    }

    /**
     * Edges
     *
     * @return an iterable containing the edges in the graph.
     */
    public Iterable<Edge<V, E>> edges() {
        return edges;
    }

    /**
     * GetEdge
     *
     * @param u endpoint.
     * @param v endpoint.
     * @return the edge between vertices u and v. Null if the vertices are not adjacent.
     */
    public Edge<V, E> getEdge(Vertex<V, E> u, Vertex<V, E> v) {
        return u.getOutgoing().get(v);
    }

    /**
     * GetEndpoints
     *
     * @param e edge to check.
     * @return an array of vertices associated with edge e.
     */
    public Vertex<V, E>[] getEndpoints(Edge<V, E> e) {
        return e.getEndpoints();
    }

    /**
     * Opposite
     *
     * @param v vertex to check.
     * @param e edge to check.
     * @return vertex that is opposite vertex v on edge e.
     * @throws IllegalArgumentException if vertex v is not incident to edge e.
     */
    public Vertex<V, E> opposite(Vertex<V, E> v, Edge<V, E> e) throws IllegalArgumentException {
        Vertex<V, E>[] endpoints = e.getEndpoints();
        if (endpoints[0] == v) {
            return endpoints[1];
        } else if (endpoints[1] == v) {
            return endpoints[0];
        } else {
            throw new IllegalArgumentException("vertex v is not incident to edge e.");
        }
    }

    /**
     * OutDegree
     * If the graph is undirected, the number of outgoing edges will be the same
     * as the number of incoming edges.
     *
     * @param v vertex to check.
     * @return the number of outgoing edges for vertex v.
     */
    public int outDegree(Vertex<V, E> v) {
        return v.getOutgoing().size();
    }

    /**
     * OutgoingEdges
     *
     * @param v vertex to check.
     * @return an iterable containing the outgoing edges associated with vertex v.
     */
    public Iterable<Edge<V, E>> outgoingEdges(Vertex<V, E> v) {
        return v.getOutgoing().values();
    }

    /**
     * InDegree
     * If the graph is undirected, the number of incoming edges will be the same
     * as the number of outgoing edges.
     *
     * @param v vertex to check.
     * @return the number of incoming edges for vertex v.
     */
    public int inDegree(Vertex<V, E> v) {
        return v.getIncoming().size();
    }

    /**
     * IncomingEdges
     *
     * @param v vertex to check.
     * @return an iterable containing the incoming edges associated with vertex v.
     */
    public Iterable<Edge<V, E>> incomingEdges(Vertex<V, E> v) {
        return v.getIncoming().values();
    }

    /**
     * InsertVertex
     * Creates a new vertex with the given value and inserts it into the graph.
     *
     * @param value to associate with the vertex.
     * @return a reference to the vertex.
     */
    public Vertex<V, E> insertVertex(V value) {
        Vertex<V, E> v = new Vertex<>(value, directed);
        vertices.addLast(v);
        return v;
    }

    /**
     * RemoveVertex
     * Removes a vertex and all of it's edges from the graph.
     *
     * @param v the vertex to remove.
     */
    public void removeVertex(Vertex<V, E> v) {
        List<Edge<V, E>> outgoing = new ArrayList<>(v.getOutgoing().values());
        List<Edge<V, E>> incoming = new ArrayList<>(v.getIncoming().values());
        for (Edge<V, E> e : outgoing)
            removeEdge(e);
        for (Edge<V, E> e : incoming)
            removeEdge(e);
        vertices.remove(v);
    }

    /**
     * InsertEdge
     * Inserts an edge between the vertices u and v.
     *
     * @param u     endpoint.
     * @param v     endpoint.
     * @param value to associate with the edge.
     * @return a reference to the edge.
     * @throws IllegalArgumentException if an edge between vertices u and v already exists.
     */
    public Edge<V, E> insertEdge(Vertex<V, E> u, Vertex<V, E> v, E value) throws IllegalArgumentException {
        if (getEdge(u, v) == null) {
            Edge<V, E> e = new Edge<>(u, v, value);
            edges.addLast(e);
            u.getOutgoing().put(v, e);
            v.getIncoming().put(u, e);
            return e;
        } else {
            throw new IllegalArgumentException("edge between vertices u and v already exists.");
        }
    }

    /**
     * RemoveEdge
     * Removes an edge from the graph.
     *
     * @param e edge to remove.
     */
    public void removeEdge(Edge<V, E> e) {
        Vertex<V, E>[] endpoints = e.getEndpoints();
        endpoints[0].getOutgoing().remove(endpoints[1]);
        endpoints[1].getIncoming().remove(endpoints[0]);
        edges.remove(e);
    }

    /**
     * Replace
     * Replaces the value at vertex v with e.
     *
     * @param v vertex whose value will be updated.
     * @param e new value.
     * @return the value previously held by vertex v.
     */
    public V replace(Vertex<V, E> v, V e) {
        V old = v.getValue();
        v.setValue(e);
        return old;
    }

    /**
     * Replace
     * Replaces the value at edge e with v.
     *
     * @param e edge whose value will be updated.
     * @param v new value.
     * @return the value previously held by edge e.
     */
    public E replace(Edge<V, E> e, E v) {
        E old = e.getValue();
        Vertex<V, E>[] endpoints = e.getEndpoints();
        removeEdge(e);
        insertEdge(endpoints[0], endpoints[1], v);
        return old;
    }
}
