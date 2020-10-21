link :	list.o main.o game.o item-game.o shop.o
	gcc list.o main.o game.o item-game.o shop.o -o shop.exe
	
list.o :
	gcc -c list.c
	
main.o :
	gcc -c main.c
	
game.o :
	gcc -c game.c

item-game.o :
	gcc -c item-game.c
	
shop.o :
	gcc -c shop.c
	
clean: 
	del utils.o shop.o item-game.o game.o list.o shop.o main.o shop.exe