#include "item.h"
#include "game.h"
#include <string.h>
#include <stdlib.h>
#include <stdio.h>

struct game {
	char* NAME;
	char* LDATE;
	char* PLATFORM;
	char* GENRE;
	float price;
};

Game initGame(char *name,char *ldate,char*platform,char*genre,float price){
	Game newGame=malloc(sizeof(struct game));
	newGame->NAME=strdup(name);
	newGame->LDATE=strdup(ldate);
	newGame->PLATFORM=strdup(platform);
	newGame->GENRE=strdup(genre);
	newGame->price=price;
	return newGame;
}

char* gameName(Game game){
	char *name;
	name=strdup(game->NAME); //strcpy(name,game->name) e' la stessa cosa
	return name;	
}

char* gameLaunchDate(Game game){
	char *ldate=strdup(game->LDATE);
	return ldate;
}

char* gamePlatform(Game game){
	char *platform=strdup(game->PLATFORM);
	return platform;
}

char* gameGenre(Game game){
	char *genre=strdup(game->GENRE);
	return genre;
}

float gamePrice(Game game){
	float outprice=game->price;
	return outprice;
}

