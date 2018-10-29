require 'rspec'
require_relative '../../ruby/sorts/sleep_sort'
describe 'SleepSort' do

  it 'should sort an array' do
    input = [2,5,1,6,4,8,9]
    expected = input.sort

    sort = SleepSort.new
    expect(sort.sort(input)).to eq(expected)

  end
end