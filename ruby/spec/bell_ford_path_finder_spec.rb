
require 'spec_helper'
require_relative '../../../ruby/pathfinders/ford_path_finder'
require_relative '../../../ruby/pathfinders/graph'
require_relative '../../../ruby/pathfinders/edge'



describe 'BellFordPathFinder' do
  context 'One Vertex' do
    g = Graph.new
    g.add_vertex(1)
    it 'should return an array with zero in it' do
      bford = BellFordPathFinder.new
      result = bford.find_smallest_path g.vertices, g.edges, 1
      expect(result).to contain_exactly(0) # should just have zero in the array
    end
  end

  context 'All other vertices are one edge away from the source' do
    g = Graph.new
    10.times do |i|
      g.add_vertex(i)
      g.add_edge(0, i, i) if i > 0
    end
    it 'should have 10 distances in array' do
      bford = BellFordPathFinder.new
      result = bford.find_smallest_path g.vertices, g.edges, 0
      expect(result.length).to be(10)
      result.each_index {|i| expect(result[i]).to eq(i)}
    end
  end
end