require './trip'
require './vaccination_system'

queries = [
  ['checkIn', [45,"cvs","boston"]],
  ['checkIn', [32,"walgreens","cambridge"]],
  ['checkIn', [27,"walgreens","danvers"]],
  ['checkOut', [45, 15]],
  ['checkOut', [27, 20]],
  ['checkOut', [32, 22]],
  ['getCityAverageTime', 'boston'],
  ['getCityAverageTime', 'danvers'],
  ['checkIn', [10, "cvs", 'cambridge']],
  ['getCenterAverageTime', 'cvs'],
  ['checkOut', [10, 38]],
  ['getCityAverageTime', 'cambridge'],
  ['getCenterAverageTime', 'walgreens']
]

system = VaccinationSystem.new(queries)
print system.run_queries
