# IDEAS

## Use ArrayList for the creation of Hunters and Prey
* Create objects for n objects with ArrayList <as seen in ./knowledge_base-samples/objArrTest.java>
* Enter n via UI (use slider)
* use arraylist or array
  
## create class Actor
* int hp
* int atk
* int def
* visCone()
* movement()
* isFriendly()
* attack()
* onOverlap()
* movement speed defined

## HunterActor
`DERIVED FROM ACTOR`
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


## gui elements
* hunter starvation rate
* movement speed
*