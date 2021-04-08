module VaccinationSystem
  class Trip
    attr_reader :card_id, :city_name, :duration, :center_name
  
    def initialize(center_name:, city_name:, card_id:, duration:)
      @card_id = card_id
      @city_name = city_name
      @duration = duration
      @center_name = center_name
    end
  end
end
