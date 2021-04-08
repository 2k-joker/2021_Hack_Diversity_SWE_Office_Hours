module VaccinationSystem
  class QueriesRunner
    def initialize(queries)
      @queries = queries
      @output = []
    end

    def run_queries
      @queries&.each do |query_type, args|
        run_query(query_type, args)
      end

      output
    end

    private

    attr_accessor :output

    def check_in_user(args)
      output << processor.check_in(args[0], args[1], args[2])
    end

    def check_out_user(args)
      output << processor.check_out(args[0], args[1])
    end

    def processor
      @processor ||= Processor.new
    end

    def retrieve_average_wait_time_by_center(center_name)
      output << processor.get_average_time_by_center(center_name)
    end

    def retrieve_average_wait_time_by_city(city_name)
      output << processor.get_average_time_by_city(city_name)
    end

    def run_query(query_type, args)
      if query_type == 'checkIn'
        check_in_user(args)
      elsif query_type == 'checkOut'
        check_out_user(args)
      elsif query_type == 'getCenterAverageTime'
        retrieve_average_wait_time_by_center(args)
      elsif query_type == 'getCityAverageTime'
        retrieve_average_wait_time_by_city(args)
      else
        puts 'ERROR: Invalid query encountered'
        exit 1
      end
    end
  end
end
