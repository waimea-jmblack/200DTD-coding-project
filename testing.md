# Test Plan and Evidence / Results of Testing

## Game Description

The project involves the programming of a two-player game.

The game is about chance and strategy. You and another player both start with 10 explorers. 
With a goal of getting 20 explorers and 200 gold.
For the main quest the users will pick a number (either 1 or 2), 
then the computer picks a random number from these two numbers.
If the user guesses right, then they will be rewarded 10 gold. 
If they guess wrong they there will be a 50/50 chance they lose an explorer.
There will also be random hard challenges, that could offer high reward but higher risk as well. 
One of these hard challenges will consist of the user picking 1 number out of 3. 
If they user gets it right, they gain 3 explorers and 30 gold, but if they get wrong then they would lose for example, 1 explorer and 20 gold.

The strategy of this game is that you could bet against the opposite player when it is their turn.
This will be done by you picking a different number that the opposition did not choose, 
meaning that if the opposition gets their number wrong and the user got it right while betting against them, 
the user gets the reward and the opposition loses the set amount, and vice versa.

### Game Features and Rules

The game has the following features and/or rules:

- Explores, (you start with 10 and have to get 15)
- Random tasks, (Easy or Hard)
- Gold, you start with none and have to get 100 to win (plus 15 explorers)

---

## Test Plan

The following game features / functionality and player actions will need to be tested:

- More how many players can play
- Player wins
- Players switch

The following tests will be run against the completed game. The tests should result in the expected outcomes shown.


### Players switching
I need to test that the players will switch when their turn is over

#### Test Data / Actions to Use

After player has completed their turn, it should become the next players turn

#### Expected Outcome

The player should complete their turn, and then it will become the next players turn.





### How many players can play

The minimum amount of players that can play will be 2 with a maximum amount being 4

#### Test Data / Actions to Use

At the start the users will have to enter the amount of people playing (max of 4)

#### Expected Outcome

The user will not be able to play with less than two people and more than 4





### Player Wins

TEST DESCRIPTION HERE

#### Test Data / Actions to Use

For a player to win, they have to get 15 explorers and 100 gold before the other players do

#### Expected Outcome

When a player wins, the computer will state the winner, and how much gold and explorers they have accumulated






### TEST NAME HERE

TEST DESCRIPTION HERE

#### Test Data / Actions to Use

TEST DATA TO USE DETAILED HERE

#### Expected Outcome

EXPECTED OUTCOME DETAILED HERE


---


## Evidence / Results of Testing

### Players switching

The video below shows a player finishing their turn and then switches to the next player...

[Video Link](https://mywaimeaschool-my.sharepoint.com/:v:/g/personal/jmblack_waimea_school_nz/EQMf5-Q_wwBHoNrpF4e1HoEBGLJsE8EFhFN9X6_QZnI9yA?nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D&e=N24rBZ)


### How many players can play

The video below shows what happens if the user inputs over 4 people, under 2 people and between 2-4 people
(Note: The computer will let the user input below or above the max or min, 
but it will revert to the closest player count)

[Video Link](https://mywaimeaschool-my.sharepoint.com/:v:/g/personal/jmblack_waimea_school_nz/EV7Cycz2UuJGpuMhVurPDnwBueQB2ucOVf7QA3_OFm82lA?nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D&e=hQ1CDC)




### Player Wins

In this video below I continuously pressed 1 until one of the players won. 
This was to see if the player will beat the game when they collect 15 explorers and 100 gold

[Video Link](https://mywaimeaschool-my.sharepoint.com/:v:/g/personal/jmblack_waimea_school_nz/EfEitn2twNZHoUz95kIx3IUBaP7rtQ1KgcQfEj_LFlIwnQ?nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D&e=Kw0Vjb)

NOTES REGARDING THE RESULTS HERE


### TEST NAME HERE

ACTUAL RESULTS OF TESTING SHOWN HERE

[Video Link]()

NOTES REGARDING THE RESULTS HERE

