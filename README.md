# DN_MM_Hunter  

## 1.The Team  
We are University student that are trying our best to fullfill our Tasks.  
  
## 2 Aimed Scope 
### 2.1. Functionality  
  
+ Make a simulation that shows various hunting stratgies for group hunting
    + each predator should be making decisions based upon their knowledge [x]
    + predators hunt small pray alone [x]
    + predators notify group when help is needed for larger prey [x]
    + there are only cooperative and solo hunters [x]
    + when cooperative hunting predators must stay within a group radius, while trying to corner the prey [X]
    + prey is considered killed once one of the predators of a group has reached it [x]
    + if the group of predators it not large enough the prey will retaliate [x]
        + prey attacks the closest predator [x]
        + prey kills closest predator if their atk is higher than the predator def [x]
    + attacked predators try to escape the preys attack and rejoin the group by being in the group radius [x]
    + Predators should use diffrent movement tactics to corner prey without being aware of the predator < ? >
    + Prey need noticing them to go as far as possible without the predators without a specific strategy [x]
    + The predator needs to see prey (there must be a way to determine if they see them or not) [x]
    + The predator needs to inform others (in group circle there is no howling required, else the wolf needs to share their possition and prey via howling) [x]
    + each cycle predators loose hp due to starvation [x]
    + predators gain hp by killing prey [x]
+ programmed with Java (not further specified)
    + unclear what libary is allowed 
        `seems like all are ok`
        + all are ok
    + unclear if we need to use the standard GUI or if we can output to HTML/CSS or use GUI libary
        `seems like Java FX is required`
        + all platform independent libaries are ok
+ there has to be a Visual representation of the hunters and hunted  [x]
    + this can be a simple 2D grid based envoirement with colored singulare or groups of tiles [x]
    + the hunter and predator should be diffrentiable [x]
    + movement should be shown [x]
    + a trail does is not given for the hunter (maybe debug version though) [x]
+ there has to be a GUI for the user to enter parameters that influence the GUI [x]
  
### 2.2. Input parameters  
*The input parameters may include but are not limted to*    
+ the grid size [x]
    + X and Y size shall be indipendet [x]
+ predator [x]
    + Initial Predator count [x]
    + run speed (how many tiles per cycle) [x]
    + Q: should there be growth of these or just death
+ Prey
    + position on the grip (x | y coordiante)
    + size of prey in grid ( x | y size )
        + smaller prey is easier to kill
        + gives less nutrition
    + run speed (how many tiles per cycle)    
    + Q: number of prey? is it one
+ Auto generate prey (Toggle) [x]
    + generate prey every x seconds [x]
    + place at random possitions [x]
+ Predator stavation resiliaence(Starvation rate) [x]
    + how many cycle can a predator survive without starving to death [x]
+ Predator defance chance
    + larger prey would attack a lone predator
    + the predator will be killed if its score is bigger than the predators defance
+ predator group radius [x]
    + if a number of predators are within radius of eachother they form a group and can hunt larger prey [x]
+ Simulation object colors
    + allow color palets for predators and prey
    + Q: What are dublicates in this context, should every predators 
+ Simulation Speed [x]
    + fast reperesents results faster [x]
    + slow should be easy to follow [x]

### 2.3. Application outputs  
*output shall include but is not limited to*
+ average food gain per iteration [x]
    + averge nutrition gained on average per cycle [x]
+ predator count [x]
    + OWN: show avg deaths [x]
    + OWN: show avg death rate [x]

## 3. possible pitfalls
### 3.1. Effective scouting  
+ if a group is together it is stronger but it will find less prey
+ a strategy is needed to disperse the group ideally so it will regather quickly again  
### 3.2 Hunting in subgroups
+ should the group gather in at once in oder to hunt safely or should it hunt in sub groups
+ OWN: will should this depend on average hunger or main hunger 
