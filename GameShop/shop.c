#include "item.h"
#include "game.h"
#include "shop.h"
#include "list.h"
#include <string.h>
#include <stdlib.h>
#include <stdio.h>

struct shop{
	char* NSHOP;
	char* ADDRESS;
	List games;	
};

Shop newShop(){
	Shop newShop=malloc(sizeof(struct shop));
	char INPNSHOP[25],INPADDRESS[40];
	printf("Inserire il nome del negozio: \n");
	fflush(stdin);
	scanf("%[^'\n']",INPNSHOP);
	printf("inserire l'indirizzo del negozio: \n");
	fflush(stdin);
	scanf("%[^'\n']",INPADDRESS);
	newShop->NSHOP=strdup(INPNSHOP);
	newShop->ADDRESS=strdup(INPADDRESS);
	newShop->games=newList();
	
	return newShop;
}

void addGame(Shop shop,Game game){
	addHead(shop->games,game);
	
	return;	
}

Game searchGame(Shop shop,char* title){
	Game game=initGame(title,"","","",0);
	Game temp;
	int pos=0;
	temp=searchList(shop->games,game,&pos);
	if(temp==NULL)
		return NULL;
	else
	    return temp;
}

void outputShop(Shop shop){
	
	printf("NEGOZIO: - %s - INDIRIZZO: - %s -\n",shop->NSHOP,shop->ADDRESS);
	printf("TITOLI IN STOCK: \n");
	printList(shop->games);
	return;
	
}

void sortGames(Shop shop){
	selectionSortList(shop->games);
	return;
}


