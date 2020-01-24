Feature: The searcher for finding cars
As a: user
In order to: know how search method work
I: prepare some BDD style tests


Scenario Outline: Search car by key words

Given: we have car searcher
And: we have key word "<carAttr>"
When: we find key word in car searcher
Then: the result should be "<car>"

Examples:
    | carAttr            | car 		   |
    | Mitsubishi         | Not found   |
    | BMW       	     | BMW  	   |
    | Renault            | Renault     |