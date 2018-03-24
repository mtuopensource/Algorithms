package club.mtuopensource.algorithms.test.graph;

import static org.junit.Assert.*;

import club.mtuopensource.algorithms.graph.Graph;
import club.mtuopensource.algorithms.graph.Edge;
import club.mtuopensource.algorithms.graph.Vertex;
import org.junit.Before;
import org.junit.Test;

public class GraphTest {
    private Graph<Integer, Integer> graph;
    private Vertex<Integer, Integer> a;
    private Vertex<Integer, Integer> b;
    private Vertex<Integer, Integer> c;
    private Edge<Integer, Integer> x;
    private Edge<Integer, Integer> y;
    private Edge<Integer, Integer> z;

    @Before
    public void setUp() throws Exception {
        graph = new Graph<>(false);
        a = graph.insertVertex(1);
        b = graph.insertVertex(2);
        c = graph.insertVertex(3);
        x = graph.insertEdge(a, b, -1);
        y = graph.insertEdge(b, c, -2);
        z = graph.insertEdge(c, a, -3);
    }

    @Test
    public void testGetEdge() {
        assertEquals(graph.getEdge(a, b), x);
        assertEquals(graph.getEdge(b, c), y);
        assertEquals(graph.getEdge(c, a), z);
    }

    @Test
    public void testInsertVertex() {
        Vertex<Integer, Integer> d = graph.insertVertex(12);
        assertEquals((int) d.getValue(), 12);
        assertEquals(graph.numVertices(), 4);
        assertEquals(graph.numEdges(), 3);
    }

    @Test
    public void testRemoveVertex() {
        graph.removeVertex(a);
        assertEquals(graph.numVertices(), 2);
        assertEquals(graph.numEdges(), 1);
    }

    @Test
    public void testInsertEdge() {
        Vertex<Integer, Integer> d = graph.insertVertex(12);
        assertEquals((int) d.getValue(), 12);
        assertEquals(graph.numVertices(), 4);
        assertEquals(graph.numEdges(), 3);
        Edge<Integer, Integer> w = graph.insertEdge(a, d, 19);
        assertEquals((int) w.getValue(), 19);
        assertEquals(graph.numVertices(), 4);
        assertEquals(graph.numEdges(), 4);
    }

    @Test
    public void testRemoveEdge() {
        graph.removeEdge(x);
        assertEquals(graph.numEdges(), 2);
        assertEquals(graph.numVertices(), 3);
    }

    @Test
    public void testReplaceVertexOfVV() {
        assertEquals((int) graph.replace(a, 4), 1);
        assertEquals((int) graph.replace(b, 5), 2);
        assertEquals((int) graph.replace(c, 6), 3);
        assertEquals((int) a.getValue(), 4);
        assertEquals((int) b.getValue(), 5);
        assertEquals((int) c.getValue(), 6);
    }

    @Test
    public void testReplaceEdgeOfEE() {
        assertEquals((int) graph.replace(x, -4), -1);
        assertEquals((int) graph.replace(y, -5), -2);
        assertEquals((int) graph.replace(z, -6), -3);
    }

    @Test
    public void testOpposite() {
        assertEquals(graph.opposite(a, x), b);
        assertEquals(graph.opposite(b, y), c);
        assertEquals(graph.opposite(c, z), a);
    }

    @Test
    public void testNumVertices() {
        assertEquals(graph.numVertices(), 3);
    }

    @Test
    public void testOutDegree() {
        assertEquals(graph.outDegree(a), 2);
        assertEquals(graph.outDegree(b), 2);
        assertEquals(graph.outDegree(c), 2);
    }

    @Test
    public void testInDegree() {
        assertEquals(graph.inDegree(a), 2);
        assertEquals(graph.inDegree(b), 2);
        assertEquals(graph.inDegree(c), 2);
    }

    @Test
    public void testVertices() {
        int count = 0;
        boolean[] abc = new boolean[3];
        for (Vertex<Integer, Integer> v : graph.vertices()) {
            count++;
            if (v == a)
                abc[0] = true;
            if (v == b)
                abc[1] = true;
            if (v == c)
                abc[2] = true;
        }
        assertEquals(abc[0], true);
        assertEquals(abc[1], true);
        assertEquals(abc[2], true);
        assertEquals(count, 3);
    }

    @Test
    public void testEndVertices() {
        boolean[] ab = new boolean[2];
        boolean[] bc = new boolean[2];
        boolean[] ca = new boolean[2];
        int count = 0;
        for (Vertex<Integer, Integer> v : graph.getEndpoints(x)) {
            count++;
            if (v == a)
                ab[0] = true;
            if (v == b)
                ab[1] = true;
        }
        assertEquals(ab[0], true);
        assertEquals(ab[1], true);
        assertEquals(count, 2);
        count = 0;
        for (Vertex<Integer, Integer> v : graph.getEndpoints(y)) {
            count++;
            if (v == b)
                bc[0] = true;
            if (v == c)
                bc[1] = true;
        }
        assertEquals(bc[0], true);
        assertEquals(bc[1], true);
        assertEquals(count, 2);
        count = 0;
        for (Vertex<Integer, Integer> v : graph.getEndpoints(z)) {
            count++;
            if (v == c)
                ca[0] = true;
            if (v == a)
                ca[1] = true;
        }
        assertEquals(ca[0], true);
        assertEquals(ca[1], true);
        assertEquals(count, 2);
    }

    @Test
    public void testNumEdges() {
        assertEquals(graph.numVertices(), 3);
    }

    @Test
    public void testEdges() {
        int count = 0;
        boolean[] xyz = new boolean[3];
        for (Edge<Integer, Integer> e : graph.edges()) {
            count++;
            if (e == x)
                xyz[0] = true;
            if (e == y)
                xyz[1] = true;
            if (e == z)
                xyz[2] = true;
        }
        assertEquals(xyz[0], true);
        assertEquals(xyz[1], true);
        assertEquals(xyz[2], true);
        assertEquals(count, 3);
    }

    @Test
    public void testOutgoingEdges() {
        boolean[] xz = new boolean[2];
        int count = 0;
        for (Edge<Integer, Integer> e : graph.outgoingEdges(a)) {
            count++;
            if (e == x)
                xz[0] = true;
            if (e == z)
                xz[1] = true;
        }
        assertEquals(xz[0], true);
        assertEquals(xz[1], true);
        assertEquals(count, 2);
        boolean[] xy = new boolean[2];
        count = 0;
        for (Edge<Integer, Integer> e : graph.outgoingEdges(b)) {
            count++;
            if (e == x)
                xy[0] = true;
            if (e == y)
                xy[1] = true;
        }
        assertEquals(xy[0], true);
        assertEquals(xy[1], true);
        assertEquals(count, 2);
        boolean[] yz = new boolean[2];
        count = 0;
        for (Edge<Integer, Integer> e : graph.outgoingEdges(c)) {
            count++;
            if (e == y)
                yz[0] = true;
            if (e == z)
                yz[1] = true;
        }
        assertEquals(yz[0], true);
        assertEquals(yz[1], true);
        assertEquals(count, 2);
    }

    @Test
    public void testIncomingEdges() {
        boolean[] xz = new boolean[2];
        int count = 0;
        for (Edge<Integer, Integer> e : graph.incomingEdges(a)) {
            count++;
            if (e == x)
                xz[0] = true;
            if (e == z)
                xz[1] = true;
        }
        assertEquals(xz[0], true);
        assertEquals(xz[1], true);
        assertEquals(count, 2);
        boolean[] xy = new boolean[2];
        count = 0;
        for (Edge<Integer, Integer> e : graph.incomingEdges(b)) {
            count++;
            if (e == x)
                xy[0] = true;
            if (e == y)
                xy[1] = true;
        }
        assertEquals(xy[0], true);
        assertEquals(xy[1], true);
        assertEquals(count, 2);
        boolean[] yz = new boolean[2];
        count = 0;
        for (Edge<Integer, Integer> e : graph.incomingEdges(c)) {
            count++;
            if (e == y)
                yz[0] = true;
            if (e == z)
                yz[1] = true;
        }
        assertEquals(yz[0], true);
        assertEquals(yz[1], true);
        assertEquals(count, 2);
    }
}
