$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/bddCucumber/delete.feature");
formatter.feature({
  "name": "Delete cars by cars list",
  "description": "As a: user\nIn order to: know how delete method work\nI: prepare some BDD style tests",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Delete cars from database by cars to delete list",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "we have new car database",
  "keyword": "Given "
});
formatter.step({
  "name": "we have car list to delete",
  "keyword": "Given "
});
formatter.step({
  "name": "we add first car into database as \u003ccar_1\u003e",
  "keyword": "And "
});
formatter.step({
  "name": "we add second car into database as \u003ccar_2\u003e",
  "keyword": "And "
});
formatter.step({
  "name": "we add third car into database as \u003ccar_3\u003e",
  "keyword": "And "
});
formatter.step({
  "name": "we add fourth car into database as \u003ccar_4\u003e",
  "keyword": "And "
});
formatter.step({
  "name": "we add car number 2 into to delete list as \u003ccar_2\u003e",
  "keyword": "But "
});
formatter.step({
  "name": "we add car number 4 into to delete list as \u003ccar_4\u003e",
  "keyword": "But "
});
formatter.step({
  "name": "we delete cars from database using list of cars",
  "keyword": "When "
});
formatter.step({
  "name": "the database shouldnt contains cars from list but should contains cars \u003ccar_1\u003e ___and___ \u003ccar_3\u003e",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "car_1",
        "car_2",
        "car_3",
        "car_4"
      ]
    },
    {
      "cells": [
        "BMW X5 PL 2019 white diesel automatic 280 E sport 200000",
        "Fiat Punto IT 2002 white petrol automatic 180 B sport 10000",
        "Dodge Viper US 2010 yellow petrol automatic 310 F sport 300000",
        "Subaru Forester KO 2016 grey diesel automatic 230 D trail 160000"
      ]
    },
    {
      "cells": [
        "Renault Captur FR 2017 yellow petrol automatic 220 C med 120000",
        "Honda Civic JP 2000 red petrol manual 200 B sport 15000",
        "Volkswagen Passat DE 2017 black diesel manual 280 E comfort 130000",
        "Daewoo Lanos KO 1999 green petrol manual 280 B basic 3000"
      ]
    },
    {
      "cells": [
        "Citroen C5 FR 2010 grey petrol manual 200 C basic 90000",
        "Citroen ZX FR 2003 green petrol manual 170 B standard 4000",
        "Toyota Supra JP 2013 yellow petrol manual 300 F sport 280000",
        "Opel Astra US 2019 blue petrol automatic 260 C sport 120000"
      ]
    },
    {
      "cells": [
        "Renault Thalia FR 2001 silver petrol manual 170 B basic 4000",
        "Fiat 126P PL 1995 red petrol manual 120 A fun 17000",
        "Toyota Avensis JP 2015 blue diesel automatic 240 D basic 140000",
        "Toyota Tundra JP 2017 black diesel manual 230 E trail 190000"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Delete cars from database by cars to delete list",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "we have new car database",
  "keyword": "Given "
});
formatter.match({
  "location": "CarDelStepdefs.we_have_new_car_database()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "we have car list to delete",
  "keyword": "Given "
});
formatter.match({
  "location": "CarDelStepdefs.we_have_car_list_to_delete()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "we add first car into database as BMW X5 PL 2019 white diesel automatic 280 E sport 200000",
  "keyword": "And "
});
formatter.match({
  "location": "CarDelStepdefs.we_add_first_car_into_database_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "we add second car into database as Fiat Punto IT 2002 white petrol automatic 180 B sport 10000",
  "keyword": "And "
});
formatter.match({
  "location": "CarDelStepdefs.we_add_second_car_into_database_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "we add third car into database as Dodge Viper US 2010 yellow petrol automatic 310 F sport 300000",
  "keyword": "And "
});
formatter.match({
  "location": "CarDelStepdefs.we_add_third_car_into_database_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "we add fourth car into database as Subaru Forester KO 2016 grey diesel automatic 230 D trail 160000",
  "keyword": "And "
});
formatter.match({
  "location": "CarDelStepdefs.we_add_fourth_car_into_database_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "we add car number 2 into to delete list as Fiat Punto IT 2002 white petrol automatic 180 B sport 10000",
  "keyword": "But "
});
formatter.match({
  "location": "CarDelStepdefs.we_add_car_number_2_into_to_delete_list_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "we add car number 4 into to delete list as Subaru Forester KO 2016 grey diesel automatic 230 D trail 160000",
  "keyword": "But "
});
formatter.match({
  "location": "CarDelStepdefs.we_add_car_number_4_into_to_delete_list_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "we delete cars from database using list of cars",
  "keyword": "When "
});
formatter.match({
  "location": "CarDelStepdefs.we_delete_cars_from_database_using_list_of_cars()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the database shouldnt contains cars from list but should contains cars BMW X5 PL 2019 white diesel automatic 280 E sport 200000 ___and___ Dodge Viper US 2010 yellow petrol automatic 310 F sport 300000",
  "keyword": "Then "
});
formatter.match({
  "location": "CarDelStepdefs.the_database_shouldnt_contains_cars_from_list_but_should_contains_cars(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Delete cars from database by cars to delete list",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "we have new car database",
  "keyword": "Given "
});
formatter.match({
  "location": "CarDelStepdefs.we_have_new_car_database()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "we have car list to delete",
  "keyword": "Given "
});
formatter.match({
  "location": "CarDelStepdefs.we_have_car_list_to_delete()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "we add first car into database as Renault Captur FR 2017 yellow petrol automatic 220 C med 120000",
  "keyword": "And "
});
formatter.match({
  "location": "CarDelStepdefs.we_add_first_car_into_database_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "we add second car into database as Honda Civic JP 2000 red petrol manual 200 B sport 15000",
  "keyword": "And "
});
formatter.match({
  "location": "CarDelStepdefs.we_add_second_car_into_database_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "we add third car into database as Volkswagen Passat DE 2017 black diesel manual 280 E comfort 130000",
  "keyword": "And "
});
formatter.match({
  "location": "CarDelStepdefs.we_add_third_car_into_database_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "we add fourth car into database as Daewoo Lanos KO 1999 green petrol manual 280 B basic 3000",
  "keyword": "And "
});
formatter.match({
  "location": "CarDelStepdefs.we_add_fourth_car_into_database_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "we add car number 2 into to delete list as Honda Civic JP 2000 red petrol manual 200 B sport 15000",
  "keyword": "But "
});
formatter.match({
  "location": "CarDelStepdefs.we_add_car_number_2_into_to_delete_list_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "we add car number 4 into to delete list as Daewoo Lanos KO 1999 green petrol manual 280 B basic 3000",
  "keyword": "But "
});
formatter.match({
  "location": "CarDelStepdefs.we_add_car_number_4_into_to_delete_list_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "we delete cars from database using list of cars",
  "keyword": "When "
});
formatter.match({
  "location": "CarDelStepdefs.we_delete_cars_from_database_using_list_of_cars()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the database shouldnt contains cars from list but should contains cars Renault Captur FR 2017 yellow petrol automatic 220 C med 120000 ___and___ Volkswagen Passat DE 2017 black diesel manual 280 E comfort 130000",
  "keyword": "Then "
});
formatter.match({
  "location": "CarDelStepdefs.the_database_shouldnt_contains_cars_from_list_but_should_contains_cars(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Delete cars from database by cars to delete list",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "we have new car database",
  "keyword": "Given "
});
formatter.match({
  "location": "CarDelStepdefs.we_have_new_car_database()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "we have car list to delete",
  "keyword": "Given "
});
formatter.match({
  "location": "CarDelStepdefs.we_have_car_list_to_delete()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "we add first car into database as Citroen C5 FR 2010 grey petrol manual 200 C basic 90000",
  "keyword": "And "
});
formatter.match({
  "location": "CarDelStepdefs.we_add_first_car_into_database_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "we add second car into database as Citroen ZX FR 2003 green petrol manual 170 B standard 4000",
  "keyword": "And "
});
formatter.match({
  "location": "CarDelStepdefs.we_add_second_car_into_database_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "we add third car into database as Toyota Supra JP 2013 yellow petrol manual 300 F sport 280000",
  "keyword": "And "
});
formatter.match({
  "location": "CarDelStepdefs.we_add_third_car_into_database_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "we add fourth car into database as Opel Astra US 2019 blue petrol automatic 260 C sport 120000",
  "keyword": "And "
});
formatter.match({
  "location": "CarDelStepdefs.we_add_fourth_car_into_database_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "we add car number 2 into to delete list as Citroen ZX FR 2003 green petrol manual 170 B standard 4000",
  "keyword": "But "
});
formatter.match({
  "location": "CarDelStepdefs.we_add_car_number_2_into_to_delete_list_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "we add car number 4 into to delete list as Opel Astra US 2019 blue petrol automatic 260 C sport 120000",
  "keyword": "But "
});
formatter.match({
  "location": "CarDelStepdefs.we_add_car_number_4_into_to_delete_list_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "we delete cars from database using list of cars",
  "keyword": "When "
});
formatter.match({
  "location": "CarDelStepdefs.we_delete_cars_from_database_using_list_of_cars()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the database shouldnt contains cars from list but should contains cars Citroen C5 FR 2010 grey petrol manual 200 C basic 90000 ___and___ Toyota Supra JP 2013 yellow petrol manual 300 F sport 280000",
  "keyword": "Then "
});
formatter.match({
  "location": "CarDelStepdefs.the_database_shouldnt_contains_cars_from_list_but_should_contains_cars(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Delete cars from database by cars to delete list",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "we have new car database",
  "keyword": "Given "
});
formatter.match({
  "location": "CarDelStepdefs.we_have_new_car_database()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "we have car list to delete",
  "keyword": "Given "
});
formatter.match({
  "location": "CarDelStepdefs.we_have_car_list_to_delete()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "we add first car into database as Renault Thalia FR 2001 silver petrol manual 170 B basic 4000",
  "keyword": "And "
});
formatter.match({
  "location": "CarDelStepdefs.we_add_first_car_into_database_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "we add second car into database as Fiat 126P PL 1995 red petrol manual 120 A fun 17000",
  "keyword": "And "
});
formatter.match({
  "location": "CarDelStepdefs.we_add_second_car_into_database_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "we add third car into database as Toyota Avensis JP 2015 blue diesel automatic 240 D basic 140000",
  "keyword": "And "
});
formatter.match({
  "location": "CarDelStepdefs.we_add_third_car_into_database_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "we add fourth car into database as Toyota Tundra JP 2017 black diesel manual 230 E trail 190000",
  "keyword": "And "
});
formatter.match({
  "location": "CarDelStepdefs.we_add_fourth_car_into_database_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "we add car number 2 into to delete list as Fiat 126P PL 1995 red petrol manual 120 A fun 17000",
  "keyword": "But "
});
formatter.match({
  "location": "CarDelStepdefs.we_add_car_number_2_into_to_delete_list_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "we add car number 4 into to delete list as Toyota Tundra JP 2017 black diesel manual 230 E trail 190000",
  "keyword": "But "
});
formatter.match({
  "location": "CarDelStepdefs.we_add_car_number_4_into_to_delete_list_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "we delete cars from database using list of cars",
  "keyword": "When "
});
formatter.match({
  "location": "CarDelStepdefs.we_delete_cars_from_database_using_list_of_cars()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the database shouldnt contains cars from list but should contains cars Renault Thalia FR 2001 silver petrol manual 170 B basic 4000 ___and___ Toyota Avensis JP 2015 blue diesel automatic 240 D basic 140000",
  "keyword": "Then "
});
formatter.match({
  "location": "CarDelStepdefs.the_database_shouldnt_contains_cars_from_list_but_should_contains_cars(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("src/test/resources/bddCucumber/search.feature");
formatter.feature({
  "name": "The searcher for finding cars",
  "description": "As a: user\nIn order to: know how search method work\nI: prepare some BDD style tests",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Search car by key words",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "we have car database",
  "keyword": "Given "
});
formatter.step({
  "name": "we add car into database as \u003ccar\u003e",
  "keyword": "And "
});
formatter.step({
  "name": "we find key words with car searcher as \u003ccarAttr\u003e",
  "keyword": "When "
});
formatter.step({
  "name": "the result should be \u003ccarResults\u003e",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "car",
        "carAttr",
        "carResults"
      ]
    },
    {
      "cells": [
        "BMW X5 PL 2019 white diesel automatic 280 E sport 200000",
        "BMW",
        "BMW X5 PL 2019 white diesel automatic 280 E sport 200000"
      ]
    },
    {
      "cells": [
        "Renault Captur FR 2017 yellow petrol automatic 220 C med 120000",
        "Volkswagen",
        "Nothing found"
      ]
    },
    {
      "cells": [
        "Citroen C5 FR 2010 grey petrol manual 200 C basic 90000",
        "manual",
        "Citroen C5 FR 2010 grey petrol manual 200 C basic 90000"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Search car by key words",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "we have car database",
  "keyword": "Given "
});
formatter.match({
  "location": "CarSearchStepdefs.we_have_car_database()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "we add car into database as BMW X5 PL 2019 white diesel automatic 280 E sport 200000",
  "keyword": "And "
});
formatter.match({
  "location": "CarSearchStepdefs.we_add_car_into_database_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "we find key words with car searcher as BMW",
  "keyword": "When "
});
formatter.match({
  "location": "CarSearchStepdefs.we_find_key_words_with_car_searcher_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the result should be BMW X5 PL 2019 white diesel automatic 280 E sport 200000",
  "keyword": "Then "
});
formatter.match({
  "location": "CarSearchStepdefs.the_result_should_be(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Search car by key words",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "we have car database",
  "keyword": "Given "
});
formatter.match({
  "location": "CarSearchStepdefs.we_have_car_database()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "we add car into database as Renault Captur FR 2017 yellow petrol automatic 220 C med 120000",
  "keyword": "And "
});
formatter.match({
  "location": "CarSearchStepdefs.we_add_car_into_database_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "we find key words with car searcher as Volkswagen",
  "keyword": "When "
});
formatter.match({
  "location": "CarSearchStepdefs.we_find_key_words_with_car_searcher_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the result should be Nothing found",
  "keyword": "Then "
});
formatter.match({
  "location": "CarSearchStepdefs.the_result_should_be(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Search car by key words",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "we have car database",
  "keyword": "Given "
});
formatter.match({
  "location": "CarSearchStepdefs.we_have_car_database()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "we add car into database as Citroen C5 FR 2010 grey petrol manual 200 C basic 90000",
  "keyword": "And "
});
formatter.match({
  "location": "CarSearchStepdefs.we_add_car_into_database_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "we find key words with car searcher as manual",
  "keyword": "When "
});
formatter.match({
  "location": "CarSearchStepdefs.we_find_key_words_with_car_searcher_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the result should be Citroen C5 FR 2010 grey petrol manual 200 C basic 90000",
  "keyword": "Then "
});
formatter.match({
  "location": "CarSearchStepdefs.the_result_should_be(String)"
});
formatter.result({
  "status": "passed"
});
});