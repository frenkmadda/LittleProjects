#include "item.h"

typedef struct game *Game;

Game initGame(char *,char *,char*,char*,float);
char* gameName(Game);
char* gameLaunchDate(Game);
char* gamePlatform(Game);
char* gameGenre(Game);
float gamePrice(Game); 

