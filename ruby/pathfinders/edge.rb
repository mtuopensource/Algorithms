class Edge
  attr_reader :first, :second, :weight
  def initialize(u, v, weight)
    @first = u
    @second = v
    @weight = weight
  end
end