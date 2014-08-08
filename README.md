SnakeLadderGame
===============

Game Rules Covered
----

1. Given a Gaming board of 10X10 size.
2. A dice with six faces which on rolling can give a number between 1 to 6
3. Board contains 8 snakes with their head and tail information. 
4. Currently game is played by 2 Players.
5. As soon as player has to move a position on which snake head lies, its position is reset to snake's tail position.
6. Board contains 8 ladders with their bottom and up information.  
7. As soon as player has to move a position on which ladder bottom lies, its position is reset to ladder's top position.
8. When player hits 6 on dice, he is given another chance to roll dice and whatever will be the total of both roll,
   player will move that positions on board.
9. If player hits 6 thrice, there will be no movement in his position.
10.Whenever any player reaches to a position equal to or greater than maximum number of board (i.e. 100), 
   he is declared winner and game ends.
11.If none player wins,runtime exception occurs (rare scenario).   

-----  


