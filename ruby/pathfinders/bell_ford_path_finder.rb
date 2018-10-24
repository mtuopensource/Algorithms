
# Bellman Ford's alg will find the closet path from a source to
# all other nodes in a graph
class BellFordPathFinder
  INFINITY = Float::INFINITY

  # @!method finds shortest distances from source
  # vertex to all other vertices in a graph
  # @!attribute vertices: list of vertices in graph
  # @!attribute edges: list of edges in graph
  # @!attribute source: the source vertex to start at
  # @return an array that contains the shortest distance to each vertex
  def find_smallest_path(vertices, edges, source)
    @vertices = vertices
    @distance = Array.new @vertices.length, INFINITY
    set_distance source, 0

    # relax the edges
    vertices.each do
      edges.each do |edge|
        if get_distance(edge.first) + edge.weight < get_distance(edge.second)
          set_distance edge.second, get_distance(edge.first) + edge.weight
        end
      end
    end

    # check for negative-weight cycle
    edges.each do |edge|
      if get_distance(edge.first) + edge.weight < get_distance(edge.second)
        raise('Bad graph, still have negative-weight cycle!')
      end
    end
    puts @distance.to_s
    @distance # returns
  end

  def set_distance(vertex, distance)
    @distance[@vertices.find_index(vertex)] = distance
  end

  def get_distance(vertex)
    @distance[@vertices.index(vertex)]
  end

  private :set_distance, :get_distance

end