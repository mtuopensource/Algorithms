require 'rspec'

describe 'Graph' do
context 'When nothing is in the graph' do
    it 'should have a vertex when it is added' do
      graph = Graph.new
      graph.add_vertex(1)
      expect(graph.vertices).to contain_exactly(1)
    end
  end
end