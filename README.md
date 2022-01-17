Author: Jack Boccuzzi
# project2 README.md
Deck of Cards + TicTacToe

Sources used: Java API 15, GeeksForGeeks : Info on 2D Arrays (https://www.geeksforgeeks.org/multidimensional-arrays-in-java/) 


#Dealer.java
- creates a deck of 52 cards 
- the cards can be of type SPADES, DIAMONDS, HEARTS, or CLUBS and 
- can be a 1 (ace), 2, 3, 4, 5, 6, 7, 8, 9, t(10), J(jack), Q(queen), K(king)
- all of the cards are first printed in number order for each suit (13 cards per 	  line)
- then the cards are printed randomly but still 13 cards per line
- Last, the cards are printed one at a time until 52 cards have been "Dealt"

#TicTacToe.java
- Program greets the user and prints the rules
- then the users are asked to enter Player 1 and Player 2's name
- Player 1 is assigned 'X' and Player 2 is assigned 'O'
- the board is printed with the board coordinates in each spot and then the starting
  board is printed as well with all open spaces
- Starts with Player 1's turn and asks them to enter a row and column coordinate
- if the place on the board is a valid place and there is no other piece on the board, the player's piece is set there 
- If the place on the board is not valid, then the user is asked to enter valid/in-range coordinates and if there is already a piece on the board, it tells them "There is already a piece on the board. Try Again!"

- If a player wins (by getting 3 in a row) it prints the players name and says " -name- wins!" and prints the amount of wins they have and the amount of games they have played
- If the players tie, the programs prints "The game ended in a tie!"
- After the game, the program asks the user if they want to play again and to enter 'y' or 'n'. Input validation is implemented to make sure they enter only 'y' or 'n'

#Mashup.java
- Program greets the user and prints the rules
- then the users are asked to enter Player 1 and Player 2's name
- Player 1 is assigned 13 HEART cards and Player 2 is assigned 13 DIAMOND cards
- the board is printed with the board coordinates in each spot and then the starting board is printed as well with all open spaces
- Starts with Player 1's turn and asks them to enter a row and column coordinate
- if the place on the board is a valid place and there is no other card/piece on the board, the player's card/piece is set there.
- If the place on the board is not valid, then the user is asked to enter valid/in-range coordinates and if there is already a piece on the board, it tells them "There is already a piece on the board. Try Again!"

- If a player wins (by getting 4 in a row) it prints the players name and says " -name- wins!" and prints the amount of wins they have and the amount of games they have played
- If the players tie, the programs prints "The game ended in a tie!"
- After the game, the program asks the user if they want to play again and to enter 'y' or 'n'. Input validation is implemented to make sure they enter only 'y' or 'n'

