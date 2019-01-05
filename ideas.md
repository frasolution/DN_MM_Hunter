# IDEAS

## Use ArrayList for the creation of Hunters and Prey
* Create objects for n objects with ArrayList <as seen in ./knowledge_base-samples/objArrTest.java>
* Enter n via UI (use slider)
* use arraylist or array
  
## create class Actor
* int atk
* int def
* visCone()
* movement()
* isFriendly()
* attack()
* onOverlap()
* movement speed defined

# sorry I went to far with this thing following but it was just so much fun as me for a Tl;Dr later if you want Greetings Max

## Unforeseen Consequences
Dear friend this is a note from your good pal Eli Vance from you know, the black mesa science team.  
We have encountered a much better system idea in a very familiar place. Your YouTube subscription inbox.  
I know me and Dr. Kleiner are very sorry that we looked at your PERSONAL COMPUTER  
but regardless we might want to impose some much needed fresh ideas for your RESEARCH.  
So you know this fictional game by my favorite author Mark L.L. it was called Stack Pointer.  
You know where they tried to debug their main system with the help of that shady guy in the suit and ended up i a lot of chaos and the whole facity went wild.
  
Well we have watch some analysis videos that were in your aforementioned subscriptions and found this awesome system in the code Engien that allowed more complex solutions to your very problem.  
Well the isFriendly() function for your object seems to be a nice start but you just go deeper than what you imagined with this.  
Just save the virtual class [Actor] and use relations in numbers to check if they are firendly.
Kleiner also came up with a solution allready just use some prime number magic.  
Every hunter that has a is devideable by the same prime is friendly and if they are diffrent they are enemies.  
The one with the smaller number is prey and the one with the bigger is the hunter.
I'm sure you can get help with that number magic if you really need to but try it yourself first.
The best part is since you use modern day computers with our prototype intel 686 we can use really big numbers with near no impact on simulation speed.
The best part is you could evem go as far as including number of fractions or set up tribes, maybe even allow them hunters to kill their own kind and so on.
Maybe even allow diffrent races to hunte prey with eachother to than attack eachother with no more prey around. I mean the possibilites are truely endless here.
Just think about the what preasure corp did here with Stack Pointer 2. Man I really would like to see what they can do with the Code 2 engien.
  
ANYWAY I hope this helps and DON'T be LATE to our experiment tomorrow or Breen might fire us all.
Yours truely,
Eli Vance  

## HunterActor
`DERIVED FROM ACTOR`
* int hp        (Do we need HP on actor Actor)
* starvation()
    * subtract x hp from hunter actor instance
    * x is determined through gui
* movePoint()
* isInGroup()
* howling()
    * scan array in 'circle' around HunterActor instance -> if hunter found set their move point
* isGroupNeeded()
    * only use objects knowledge
    * if yes do howling()
* soloHunting()
* groupHunting()
    * runs isInGroup() in background for each object
    * as soon as 1 or more hunter are onOverlap() with prey the prey is conmsidered dead
        * delete PreyActor from Stack/Array
* isAttacked()
    *check if the Hunter gets attack if yes invoke run()
* run()
    * look for biggest of the near hunter groups
* isPreyVisible()
    * check if Prey is in visCone()
    * invoke isGroupNeeded()
* killedPrey()
    * send out signal for to all other Hunter Instances in Group radius

## PreyActor
`DERIVED FROM ACTOR`
* canRetaliate()
    * if prey is bigger than hunter than it can retaliate
        * killHunter()
* killHunter()
    * checks if prey.getAtk() is bigger than predator.getDef() delete Predator from Stack/Array
* isHunterVisible()
    * check if Hunter is in visCone()
    * invoke canRetaliate()
    * invoke run() [THIS DIFFRENT FROM HUNTER SINCE PREY CAN'T ESCAPE TO BIGGER GROUP]

## Initilizations
* if autoGenPrey == true
    * use random Gen of stats for each prey
    * use a random position on the grid (use gridx and gridY)
    * how to auto gen ervery cycle ?
        * use thread sleep

## parameters entered with gui
* int starverate -> how many cycles can a hunter survive without food
* int baseMoveSpeed -> movement speed
* int gridX and int gridY -> x and y size
* int predatorCount = input -> Initial pradator count
* boolean autoGenPrey -> prey auto generate toggle
* int simulationSpeed -> speed of the simulation (how long should a cylce last)
* int groupRadius -> Predator group radius

## Gui - visual representation
* colored tile based grid
    * is dependent on the color schema selected on color drop down
* movementt speed should be shown (and set?)
* a trail is NOT required 
    * a trail of movement might be a nice help for debuging
* there has to be a GUI for the user to enter parameters that influence the GUI
    * there needs to be color options for the
    * hunter and prey should be diffrentiable
* grid size is dependednt on ui entered parameter
* predator count
    * add: death stats like avg death and death rate (how many preddator die per cycle)
* avg food gained per iteration
    * add?: avg food gained by cycle
* simulation speed (slider)