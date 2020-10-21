#include "item.h"
#include "game.h"
#include "shop.h"
#include "list.h"
#include <string.h>
#include <stdlib.h>
#include <stdio.h>

int main(){
	Shop shop=newShop();
	Game game,fgame;
	char titolo[25];
	int i,scelta;
	
	for(i=0;i<3;i++){
		printf("inserisci un gioco: \n");
		game=inputItem();
		addGame(shop,game);
	}
	while(1){
	printf("selezionare l'operazione desiderata: \n");
    printf("1)Lista titoli in negozio\n");
    printf("2)Ricerca titolo\n");
	printf("3)Aggiunta titolo allo stock\n");
	printf("4) Ordina elenco\n");
	printf("5) Esci\n");
    scanf("%d",&scelta);
	switch(scelta){
		case 1: outputShop(shop);
				break;
		case 2: printf("cerca un titolo: \n");
				fflush(stdin);
				scanf("%[^'\n']",titolo);
				if((fgame=searchGame(shop,titolo))==NULL){
					fprintf(stderr,"Gioco non disponibile \n");
					break;
				}
				else {
					printf("Gioco disponibile in negozio: \n");
					outputItem(fgame);
					break;
				}
		case 3:	printf("inserisci un gioco: \n");
				game=inputItem();
				addGame(shop,game);
				break;
		case 4: sortGames(shop);
				break;
		case 5: return 0;
		default: fprintf(stderr,"scelta non valida\n");	
		}
	}	
	return 0;
}