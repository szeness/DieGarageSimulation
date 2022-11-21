# DieGarageSimulation
Objektorientierte Parkhaus Simulation mit GUI und automatisierten Parkvorgaengen sowie einstellbarem Aufkommen, Stosszeiten und fast forward Funktion . Autos können anhand einzigartiger Kennzeichen gefunden werden in variabler Anzahl von Parkhäusern.

![image](https://user-images.githubusercontent.com/105649203/202902918-95aaee0c-5624-4104-b2d8-635b37e411d8.png)

![image](https://user-images.githubusercontent.com/105649203/202902993-8869a8a0-e1d9-473a-b47d-ffbcb1a4e005.png)



this is some cool playings with artificial simulation of random chances and the controled mass creation of objects

so what it was actualy in begining, it was an exercice given at a job application, where they wanted to have coded a algorythms for building a parking lot wich size 
and floors should be left open, also cars and motorbikes should be registered unique by license plates.
Methods were asked for look up vehicles momentary parking lots. also some like car gets parked and car leaves building.
so no Gui has been asked or further more.  just a object orientated codes.

so I did that and added a Gui and the posibility to have multiple parking buildings, the option to set how many dummy buildings with same sizes should be opened 
and also how many cars should be registered. 

after u set those two options u can start an actual Simulation where the cars park in at random parking buildings and park out after a while. 
where and when to park and leave is based on an ai i made where the chances that something happens is dynamic and with chances from to to explain . 

so if u press play cars will park in and out and u can see it on the screens where and wich car. also u can switch between the buildings and see for each of them 
the usage in % and the numbers of free lots. 

because I wanted simulate a long durration where actualy can conclusions be drawn and a kinda realistic expirience of how things can happen rl. 

therefore i added a Timewarp function so the random times for the decisions of the car drivers is shortened.
also to see the rush hours and events happening the chances of when a driver needs a parking lot can be changed from regular to rush hour.

also its a little stats texts in the upper corner with the number of cars and the number of all parking lots. 

aswell a button for swap between background pictures. 

so we can let it run on fast mode and look how its going. 

the next step in this project would be to add locations where ppl want to go to, and set locations for the garages, so the ai gets more intelligent by leting them use preferly the nearest garage. 
I already have some in mind, tho it maybe gets to far, but was a fun project with nice steps towards ai and random decisions packed with Thread usage. 
here the threads not acting perfect yet, for example if u stop the simulation, the remaining cars wich waiting for a decision to leave will stay runing for that random time period so some seconds up to minutes they kinda stay in the thinking cue and park out then. tho its still working just some cars will leave after stop is pressed. I have a solution for it, it will be that the random time when ppl decide to leave will be checked in some millisec delays, aswell as the time they leave is a random time wich then gonna be checked by ai when the time has come, so if u press the 
stop button it will stop all the threads imidiatly right. kinda like I did in the Timer app. 

u can now add so many garages and cars as ur cpu able to manage with the "bad" threads solution what just mentioned :)

but its all good meanwhile the solution is figured out as mentioned by my timer projects stable threads ai. 

tho very interesting how to best manage the threads in enormous high come ups. 

gonna learn more about it, tho I dont need it at my job now unfortunatly.












