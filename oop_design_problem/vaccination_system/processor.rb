module VaccinationSystem
  class Processor
    def initialize()
      @check_ins = []
      @trip_logs = []
    end
  
    def check_in(card_id, center_name, city_name)
      check_in = { card_id: card_id, center_name: center_name, city_name: city_name }
      check_ins << check_in
      nil
    end
  
    def check_out(card_id, duration)
      check_in = get_check_in(card_id)
  
      create_trip(check_in, duration)
      check_ins.delete(check_in)
      nil
    end
  
    def get_average_time_by_city(city_name)
      trips = trip_logs.select { |trip| trip.city_name == city_name }
  
      average_time_for(trips)
    end
  
    def get_average_time_by_center(center_name)
      trips = trip_logs.select { |trip| trip.center_name == center_name }
  
      average_time_for(trips)
    end
  
    private
  
    attr_accessor :check_ins, :trip_logs
  
    def average_time_for(trips)
      trips.sum { |trip| trip.duration }.to_f / trips.size
    end
  
    def create_trip(check_in, duration)
      trip = Trip.new(
        center_name: check_in[:center_name],
        city_name: check_in[:city_name],
        card_id: check_in[:card_id],
        duration: duration
      )
      
      trip_logs << trip
    end
  
    def get_check_in(card_id)
      check_ins.find { |check_in| check_in[:card_id] == card_id }
    end
  end
end
