# GasStation

The following items should be evaluated:

○ Documentation

○ High cohesion

○ Low coupling

○ Maintainability:

  ■ Add new vehicle model

  ■ Add new fuel type

  ■ Include new fuel pump

  ■ Change queuing criterion


**Problem:**

A gas station with two independent pumps, one for alcohol and another one for gasoline, receives vehicles of different natures. 

Vehicles enter the fuel station in a single row, being directed to individual rows of supplying pumps. 

Each vehicle can use one or more types of fuel.

Create a program that simulates the filling of a list of vehicles entered in the file provided, carrying out the proper refueling of each vehicle.

Assuming all vehicles are empty and will have topped up, and minimizing the price/km driven when directing vehicles to the pumps, the output must be produced in the chronological order of events, in the following
format (values below are merely illustrative):

**Simulation result**

#---------------------------

...

[00:05] Vehicle model FIAT-UNO, plate JGA-7389 was supllied with 48 liters of ETHANOL.

[00:10] Vehicle model AUDI-A4, plate JGB-1234 was supllied with 65 liters of GASOLINE.

...

**Simulation Summary**

#--------------------------

Total supllied in pump 1 (GASOLINE): 1517 liters

Total supllied in pump 2 (ETHANOL): 1125 liters

Total supllied by the pump 1 (GASOLINE): 1517 liters

Total supllied by the pump 2 (ETHANOL): 1125 liters



**Additional Information:**

The price of a liter of PETROL is R$ 2.90

The price of a liter of ETHANOL is R$ 1.92

Gas pump filling speed: 10 liters / minute

Alcohol pump filling speed: 12 liters / minute



**Hint:** 

Favor low coupling and high cohesion in the proposed solution, minimizing impacts in case of changes in the problem definitions.

![image](https://user-images.githubusercontent.com/20522327/124475681-5e218080-dd78-11eb-9c16-46c8363f7468.png)



