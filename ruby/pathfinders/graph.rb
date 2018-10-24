class Graph
  attr_reader :vertices, :edges
  def initialize
    @vertices = Array.new
    @edges = Array.new
  end

  def add_edge(u, v, weight)
    raise('Vertex not in graph') if @vertices.find(u) == nil or @vertices.find(v) == nil
    @edges.<< Edge.new(u, v, weight)
  end

  def add_vertex(v)
    @vertices << v
  end

end