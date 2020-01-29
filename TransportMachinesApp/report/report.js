$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/bddCucumber/search.feature");
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
  "location": "CarStepdefs.we_have_car_database()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "we add car into database as BMW X5 PL 2019 white diesel automatic 280 E sport 200000",
  "keyword": "And "
});
formatter.match({
  "location": "CarStepdefs.we_add_car_into_database_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "we find key words with car searcher as BMW",
  "keyword": "When "
});
formatter.match({
  "location": "CarStepdefs.we_find_key_words_with_car_searcher_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the result should be BMW X5 PL 2019 white diesel automatic 280 E sport 200000",
  "keyword": "Then "
});
formatter.match({
  "location": "CarStepdefs.the_result_should_be(String)"
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
  "location": "CarStepdefs.we_have_car_database()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "we add car into database as Renault Captur FR 2017 yellow petrol automatic 220 C med 120000",
  "keyword": "And "
});
formatter.match({
  "location": "CarStepdefs.we_add_car_into_database_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "we find key words with car searcher as Volkswagen",
  "keyword": "When "
});
formatter.match({
  "location": "CarStepdefs.we_find_key_words_with_car_searcher_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the result should be Nothing found",
  "keyword": "Then "
});
formatter.match({
  "location": "CarStepdefs.the_result_should_be(String)"
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
  "location": "CarStepdefs.we_have_car_database()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "we add car into database as Citroen C5 FR 2010 grey petrol manual 200 C basic 90000",
  "keyword": "And "
});
formatter.match({
  "location": "CarStepdefs.we_add_car_into_database_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "we find key words with car searcher as manual",
  "keyword": "When "
});
formatter.match({
  "location": "CarStepdefs.we_find_key_words_with_car_searcher_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the result should be Citroen C5 FR 2010 grey petrol manual 200 C basic 90000",
  "keyword": "Then "
});
formatter.match({
  "location": "CarStepdefs.the_result_should_be(String)"
});
formatter.result({
  "status": "passed"
});
});