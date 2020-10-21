#include "item.h"
#include "game.h"
#include <string.h>
#include <stdlib.h>
#include <stdio.h>

Item inputItem(){
	char NAME[30],LDATE[50],PLATFORM[25],GENRE[15];
	float price;
	printf("inserire il nome del titolo: \n");
	fflush(stdin);
	scanf("%[^'\n']",NAME);
	printf("inserire la data di lancio del titolo dd-mm-ye\n");
	fflush(stdin);
	scanf("%[^'\n']",LDATE);
	printf("inserire la piattaforma del titolo: \n");
	fflush(stdin);
	scanf("%[^'\n']",PLATFORM);
	printf("inserire il genere del titolo\n");
	fflush(stdin);
	scanf("%[^'\n']",GENRE);
	printf("inserire il prezzo del titolo: \n");
	fflush(stdin);
	scanf("%f",&price);

	return initGame(NAME,LDATE,PLATFORM,GENRE,price);
}

void outputItem(Item item){
	Game outGame=item;
	printf("TITLE: %s  RELEASE: %s PLATFORM: %s  GENRE:  %s  PRICE: %.2fEUR\n",gameName(outGame),gameLaunchDate(outGame),gamePlatform(outGame),gameGenre(outGame),gamePrice(outGame));
    return;	
}

int cmpItem(Item item1, Item item2){ //in ordine alfabetico
	Game game1=item1,game2=item2;
	return strcmp(gameName(game1),gameName(game2));
}
void swapItems(Item* item1,Item* item2){
	
	Item temp;
	temp=*item1;
	*item1=*item2;
	*item2=temp;
	
	return;
}