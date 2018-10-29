require 'thread'
require_relative 'sorter'
class SleepSort < Sorter

  def initialize
    @sorted = []
    @mutex = Mutex.new
  end

  def sort(array)
    threads = array.collect do |n|
      Thread.new do
        sleep 0.01 * n
        @mutex.synchronize {@sorted << n}
      end
    end
    threads.each {|t| t.join}
    @sorted
  end
end