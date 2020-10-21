#include "item.h"
#include "game.h"

typedef struct shop *Shop;

Shop newShop();
void addGame(Shop,Game);
Game searchGame(Shop,char*);
void outputShop(Shop);
void sortGames(Shop);

