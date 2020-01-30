Feature: The searcher for finding cars
As a: user
In order to: know how search method work
I: prepare some BDD style tests


Scenario Outline: Search car by key words

Given we have car database
And we add car into database as <car>
When we find key words with car searcher as <carAttr>
Then the result should be <carResults>

Examples:
 | car                                                             | carAttr    | carResults 		  									   |
 | BMW X5 PL 2019 white diesel automatic 280 E sport 200000        | BMW		| BMW X5 PL 2019 white diesel automatic 280 E sport 200000 |
 | Renault Captur FR 2017 yellow petrol automatic 220 C med 120000 | Volkswagen | Nothing found  	  								       |
 | Citroen C5 FR 2010 grey petrol manual 200 C basic 90000         | manual     | Citroen C5 FR 2010 grey petrol manual 200 C basic 90000  |
 
 