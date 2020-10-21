#include "item.h"

typedef struct list *List;

List newList();
int isEmpty(List);
void addHead(List, Item);
Item removeHead(List);
struct node * minimo (struct node *p);
void selectionSortList(List list);
Item getHead(List);
int sizeList(List);
void printList(List); 
Item searchList(List, Item, int*);
Item searchListPos(List,int);
Item removeItem(List, Item);
Item removePos(List, int);
int addItem(List list, Item, int pos); // 0 <= pos <= sizeList(list)
int addTail(List, Item);
void reverseList(List);
struct node * extractNext(struct node*);
struct node * extractHead(List lista);
Item getItemNode(struct node*);
