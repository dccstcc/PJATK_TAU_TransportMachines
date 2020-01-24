Feature: The searcher for finding cars
As a: user
In order to: know how search method work
I: prepare some BDD style tests


Scenario Outline: Search car by key words

Given: we have car database
And: we have car searcher for database 
And: we have key word for find car in searcher
When: we find key words with car searcher as "<carAttr>"
Then: the result should be "<carResults>"

Examples:
    | carAttr            | car 		   |
    | Mitsubishi         | Not found   |
    | BMW       	     | BMW  	   |
    | Renault            | Renault     |