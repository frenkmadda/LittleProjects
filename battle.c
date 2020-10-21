//Programma che simula una battaglia a turni

#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#include <unistd.h>
 
 int main(void)
 
 {
	int hp=300, atk, def=43, ehp=350, eatk, edef=32,choise=0,emove,potion=5,book=1,tf=0,cr=0; //variabili che simulano le statistiche dei combattenti
	 
	 system("zelda.mp3");
	 printf("E' giunta l'ora...");
	 sleep(2);
	 printf("di affrontare un ultima battaglia...");
	 sleep(2);
	 printf("per salvare un regno in rovina....\n");
	 sleep(2);
	 printf("Sta arrivando....");
	 sleep(2);
	 printf("dopo una lunga agonia...");
	 sleep(2);
	 printf("Il momento in cui...");
	 sleep(2);
	 printf("la luce tornera' a splendere!\n\n");
	 sleep(3.5);
	 printf("                  VAI EROE DISTRUGGI IL SIGNORE OSCURO!            \n\n");
	 sleep(2.5);
	 
	 printf("                     CHE LA BATTAGLIA INIZI!                       \n\n");
	 sleep(1);
	 
	 
	 while(hp>0 && ehp>0) { 	 //ciclo che continua finche uno dei due combattenti non perde
	 def=43;                                 //difesa riportata a valori normali in caso di precedente azione difensiva 
	 
	 printf("\n");                           //estetica
	 printf("HERO: %dHP",hp);                
	 printf("               BOSS: %dHP\n\n\n",ehp);     //stat attuale nella battaglia
	 sleep(1);
	  printf("Cosa vuoi fare?\n\n");
	 
	   printf("1)Attack\n");
	   printf("2)Defense\n");
	   printf("3)Item\n");
	   printf("4)Run away\n");
	    
		scanf("%d", &choise);       
		printf("\n");
		
	    switch(choise) {
                        case 1: { if(hp>100) printf("HERO: |Take this!|\n");
				  else
				   printf("HERO:  |Time to end thiiiis!|    \n");
				   sleep(2);
				   srand((unsigned)time(NULL));
                                   emove=rand()%5;             //una chance non troppo alta di mancare l'attacco
			           if(emove) {	
		                     printf("                |SLASH!|           \n\n");								  //box di dialogo
		                     srand((unsigned)time(NULL));
				     atk=rand()%80;                  //genera un danno casuale che se sotto un certo valore viene moderato per far ugualmente danno
	                             if(atk<=43) atk=52;
                                     ehp-=(atk-edef);               //danno effettivo
				      printf("\a");
			              printf("\a");
				      sleep(0.5);
				      printf("\a");
				      sleep(0.2);
				      printf("\a");
				      printf("\a");
				      printf("You deal %d damage!\n\n", atk-edef);
				       sleep(1);
                                       if(ehp>250) { printf("|BOSS: AUH! YOU DAMN FOOL!|\n\n");	break;}
				        else { printf("BOSS: AAAAAARGH! YOU LITTLE SCUM!\n\n");  break;
					 }						 
					}
					else    {
                                          printf("             |SWOOSH!|             \n");	 
					 sleep(1);
					 printf("The Boss avoided the attack!\n\n"); break;
					 }											 
			 }
                        case 2: { printf("You receive a defense boost!");
				  sleep(1);
			           printf("\a");
				   printf("\a");
				   sleep(0.5);
				   printf("\a");
				   sleep(0.3);
			           printf("\a");
				   printf("\a");
                                  printf("......YOU FEEL STRONGER!\n\n");
                                  def+=20; 
				 break; //aumento difesa per questo turno
				} 								  
	                    case 3: { printf("Scegli un oggetto: \n\n");
				      sleep(1);		          
				      printf("1)Potion\n");
	                              printf("2)Book of info\n");					
				      scanf("%d", &choise);		  
                                    switch(choise) {
                                                     case 1: { printf("You drunk an healing potion!\n\n");
							       sleep(1);
                                                               printf("You earned 40hp! \n");	
		        				         printf("\a");                               //suono campanella
								printf("\a");
								 sleep(0.5);
								 printf("\a");
								 printf("\a");
								  sleep(0.3);
								 printf("\a");
                                                                sleep(1);															   															    
                                                                if(potion!=0){                             //counter pozioni per averne di limitate
									 hp+=40;
									 potion--;
									printf("remaining potions: %d\n", potion); //pozioni rimaste
								}
                                                                else 
                                                                    printf("You're out of Potion!!\n");	break;
									 }	
                                                     case 2: { 
							     printf("You're facing SDADHEDE a Boss of the underground world: ATK 80 - DEF 43 \n\n");                                                          
							     printf("\a");															   //suono campanella
							     sleep(1);
							     printf("\a");
						             printf("\a");
						              printf("\a");
							     sleep(0.2);
							      printf("\a");															                                   
                                                               if(book>0) {
								       edef-=5;
									printf("You read a weakness of SDAGHEDE, his defense decreased by 5\n\n");
									sleep(1);
									 book--;
								 } 
                                                               else 
								if(book==0)                                             //libro puo esser letto una sola volta
                                                                   printf("You have already read this book!\n");  break;	
								  }															   
								   default: break;
								} 
						         }break;
								  
								  
		     		case 4: { 
				 printf("HERO: |Now I'll show my secret techninc!\n|");
                                  sleep(2);					
                                  printf("|NIIIGERUNDAYOOOOOOOOOOOO!!|\n");
                                  system("escape.mp3");								  
					 return 0;           //programma termina se si scappa
				 }								  
	                    default: { 
				    printf("BOSS: |ARE YOU STUPID YOU SORT OF A DUMBASS HERO?|\n"); //insulto se si inserisce una scelta non esistente e si viene colpiti dal boss
				      sleep(2); 
				    break;   
				 }  
		               }
			  printf("\n");
		if(ehp>250){
			 printf("BOSS: |MY TURN NOW!|\n\n");              //turno del BOSS che attacchera il giocatore
		         sleep(1);
                         printf("BOSS:|TAKE THIS YOU LITTLE BRAT!|\n\n");
		         sleep(1);
		        }
		else
		     {
               	    printf("BOSS: |THATS ENOUGH!!!|\n\n");              //turno del BOSS che attacchera il giocatore con rabbia dopo il berserk
		         sleep(1);
                    printf("BOSS:|AAAAAAAAAAAAAAAAAARGHHH!!!|\n\n");
		          sleep(1);
			 }		
           	srand((unsigned)time(NULL));
             emove=rand()%3;                              //una chance non troppo alta di evitare l'attacco
			if(emove && ehp>1) {                                //se srand genera un valore diverso da 0 si viene attaccati
			       srand((unsigned)time(NULL));
			       eatk=rand()%78;
			        if(eatk<=54) eatk=67;
		                hp-=(eatk-def);
				if(ehp>250) printf("|         BOOOM!!         |\n\n");
				 else
					printf("|                  SBAAAAAAM!!                    |\n\n");
					sleep(1);
            		                printf("You take %d damage!\n\n", eatk-def);
					 sleep(1);
			         }
			else {
			        printf("                      |SWOOSH!|\n               ");
				sleep(1);
                  printf("You avoid the attack!\n\n");
			      sleep(1);
			     }
			  
			if(hp<100 && cr==0) {                                               //fase critica per l'utente
				 printf("HERO: |I-I'M FALLING DOWN!|\n\n");
				sleep(1);
				  printf("HERO: |I'LL NEVER LOSE!|\n");
				   sleep(1);
				 printf("\a");
				 printf("You're filled with determination! You're power increased!\n\n");
				sleep(1);
				edef-=8;
				system("battle.mp3");
                               	cr++;						
			                    }
					  
			 if(ehp<250 && tf==0) {                      //fase critica per il boss, aumenta di potenza
				printf("BOSS: |IT'S TIME TO REVEAL MY TRUE FORM!!!| \n");
				sleep(2);
				def-=8;
				printf("You feel scared...Your defense's decreased by 8 \n");
				sleep(1);
				system("phase.mp3");
				 tf++;
			                      }						                    
		   
		   
	 }
	 if(hp<1) {
	    printf("HERO: |NOOOOOOOOO....HOW COULD IT HAPPEN!|\n");
            sleep(1);
	    printf("BOSS: |MUAHHAHAHAHAHA YOU NEVER STOOD A CHANCE AGAINST ME!!|\n");
	 system("gameover.mp3");
	 sleep(5);
	          }
	else
      if(ehp<1) {
           printf("HERO:|TIME FOR THE FINAL BLOOOOOW!!!| \n\n"); //box di dialogo	
           sleep(1);
	   printf("                |SBAAAAAAAAAAAAAM!|              \n"); 
	sleep(1);                                       						           
	 printf("BOSS: |NOOOOOOOOOOOOOO IT'S IMPOSSIBLEEE NOOOOOOOOOOOOOOO|\n");
            sleep(1);
	system("victory.mp3");
	sleep(2);
	 printf("HERO: |THE KINGDOM IS FREEEEEEE!| \n");
	sleep(1);
	printf("                              YOU WON!!!!!!!!!!!!!!!!!                                \n");
	 sleep(3);
	            }				 
			   
  return 0;
 } 
  
					   
	  
