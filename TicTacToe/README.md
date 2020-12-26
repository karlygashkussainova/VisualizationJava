## Tic Tac Toe game 
This is a simple game Tic Tac Toe, which is designed for two players. Therefore, the given project has two options for the user: either to play against the computer or against some other plyer. There are 9 squares and 8 winning positions for the players.
Players can occupy the squares with X-s or O-s. In case, any of the players places his/her signs to the winning positions first, he/she wins the game. The winning positions are next:


|   |  |  |  |
| -------------     | -------------  |------------- |-------------  |
|  ![](Images/win1.png)       | ![](Images/win6.png) |![](Images/win7.png) |![](Images/win8.png) |
|  ![](Images/win3.png)       | ![](Images/win4.png) |![](Images/win2.png) |![](Images/win5.png) |
|   |  |  |  |


In order to see both version of the game (playing agaisnt computer and against another player), change the controller in the TicTacToe.fxml file. 
If you want to play against computer, choose TicTacToeController.java, and if you wan to play with another player, choose ControllerPlayers.java.



## Software:
- JavaFX SDK 11.0.2 ( https://openjfx.io/) 
- Scene Builder 11.0.0 (https://gluonhq.com/products/scene-builder/) 
- IntelliJ IDEA ( https://www.jetbrains.com/idea/) 
- For VM options :--module-path ${PATH_TO_JAVAFX} --add-modules javafx.controls,javafx.fxml ;${PATH_TO_JAVAFX} - path to JavaFX library 



## Screen shots and the feature list

### Feature list: 
|  Planned features |  Implemented features|  Yet to implement features |
| -------------     | -------------  |-------------  |
| -use buttons to make signs appear<br /> -use smart algorithms to randomly generate a move <br /> -use a randomizer <br /> -create a scoring system |-used shapes and line to make signs appear<br /> -used 'Initializable' class to play the game simultnously <br /> -used a randomizer to randomly create a new move <br /> -used shapes visibility to hide/show the signs|-use more features to make the interface more user-friendly <br /> (instructions + a choice between two versions of the game)<br /> -use smart algorithms to randomly generate a move <br /> -create a scoring system  |




|  Screenshot |  Description|  
| -------------     | -------------  |
|  ![](Images/img4.PNG)| This is how the app looks like when you play <br />  against a computer: whenever you choose the square, a randomly generated number from 1 to 9 appears and occupies a free space as an X  |
|  ![](Images/img6.PNG)| This is how the app looks like when you loose to the computer ( you loose to X) |
|  ![](Images/img7.PNG)| This is how the app looks like when you win over the computer ( you are O) |
|  ![](Images/img5.PNG)| This is how the app looks like when noone wins and it is a tie (for both versions)|
|  ![](Images/img1.PNG)| This is how the app looks like when the first player starts the game|
|  ![](Images/img4.PNG)| This is how the app looks like when the second player occupies the square|
|  ![](Images/img2.PNG)| This is how the app looks like when the first player wins|
|  ![](Images/img3.PNG)| This is how the app looks like when the second player wins|
|   |  | 

---







