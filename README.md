# Multithreaded-games

Building multi-threaded games where multiple clients can connect to the server at the same time using Sockets in Java.

##  First game : toUpperCase 
A game where you Input any text and the server responds with the same text in upperCase.
You can exit the game by typing 'exit' (not case sensitive)
### ------ Steps to launch the game :

1. #### Launching the Server
![ Launching the server](https://github.com/b0b1n/Multithreaded-games/blob/master/toUpperCase/images/server_launch.png) 

2. #### When the client is connected.(Server side) 
![ Client connection from server](https://github.com/b0b1n/Multithreaded-games/blob/master/toUpperCase/images/server_client_connect.png) 

3. #### The client interface
![ Client interface ](https://github.com/b0b1n/Multithreaded-games/blob/master/toUpperCase/images/client_interface.png) 

4. #### After the client has disconnected (server side) 
![ Server interface when a client has disconnected  ](https://github.com/b0b1n/Multithreaded-games/blob/master/toUpperCase/images/Client_disconnect.png) 

##  Second game : HashMyMessage 
A game where you Input any text and the server responds with your input hashed.
You can exit the game by typing 'exit' (not case sensitive)

1. #### Launching the Server
![ Launching the server](https://github.com/b0b1n/Multithreaded-games/blob/master/HashMyMessage/images/server_launch.png) 

2. #### When the clients connect.(Server side) 
Each client is definitied by a number, which helps know if any client has disconnected 
![ Client connection from server](https://github.com/b0b1n/Multithreaded-games/blob/master/HashMyMessage/images/clients_connecting.png) 

3. #### The client interface
The user interface that each client sees in the beginning :
![ Client interface ](https://github.com/b0b1n/Multithreaded-games/blob/master/HashMyMessage/images/client_interface.png) 

4. #### A client enters a text
the text that was given by the client + his hashed text will be stored in the 'hashed messages' file, with the name : '__{the text}__hashed.txt' 
![ After entering a simple text ](https://github.com/b0b1n/Multithreaded-games/blob/master/HashMyMessage/images/simple_text.png) 

5. #### The text file ( a simple text )
The text file with the hashed text :
![ Simple text, hashed ](https://github.com/b0b1n/Multithreaded-games/blob/master/HashMyMessage/images/simple_text_hash.png) 

6. #### A client enters a text with  "prohibited" caracters
There are some caracters in a file name(/, { ... ) , also, there are some keyWords that are reserved by the operating system.
Which is why, each text that is definied as a prohibited text will be added plus his hashed text in text file with the name 'WITH PROHIBITED CARACTERS.txt' 
In the same file.
![ After entering a prohibited text ](https://github.com/b0b1n/Multithreaded-games/blob/master/HashMyMessage/images/prohibited.png)

7. #### The text file ( a prohibited text )
The prohibited text will be appended to the 'WITH PROHIBITED CARACTERS.txt'  text file
![ Prohibited text, hashed ](https://github.com/b0b1n/Multithreaded-games/blob/master/HashMyMessage/images/prohibited_hashed.png) 


