Feature: Delete cars by cars list
As a: user
In order to: know how delete method work
I: prepare some BDD style tests


Scenario Outline: Delete cars from database by cars to delete list

Given we have new car database
Given we have car list to delete

And we add first car into database as <car_1>
And we add second car into database as <car_2>
And we add third car into database as <car_3>
And we add fourth car into database as <car_4>

But we add car number 2 into to delete list as <car_2>
But we add car number 4 into to delete list as <car_4>

When we delete cars from database using list of cars
Then the database shouldnt contains cars from list but should contains cars <car_1> ___and___ <car_3> 

Examples:
 | car_1                                                           | car_2           										     | car_3 		  										              | car_4															 |
 | BMW X5 PL 2019 white diesel automatic 280 E sport 200000        | Fiat Punto IT 2002 white petrol automatic 180 B sport 10000 | Dodge Viper US 2010 yellow petrol automatic 310 F sport 300000     | Subaru Forester KO 2016 grey diesel automatic 230 D trail 160000 | 
 | Renault Captur FR 2017 yellow petrol automatic 220 C med 120000 | Honda Civic JP 2000 red petrol manual 200 B sport 15000     | Volkswagen Passat DE 2017 black diesel manual 280 E comfort 130000 | Daewoo Lanos KO 1999 green petrol manual 280 B basic 3000	  	 | 
 | Citroen C5 FR 2010 grey petrol manual 200 C basic 90000         | Citroen ZX FR 2003 green petrol manual 170 B standard 4000  | Toyota Supra JP 2013 yellow petrol manual 300 F sport 280000       | Opel Astra US 2019 blue petrol automatic 260 C sport 120000      | 
 | Renault Thalia FR 2001 silver petrol manual 170 B basic 4000    | Fiat 126P PL 1995 red petrol manual 120 A fun 17000         | Toyota Avensis JP 2015 blue diesel automatic 240 D basic 140000 	  | Toyota Tundra JP 2017 black diesel manual 230 E trail 190000 	 | 
 