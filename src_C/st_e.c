#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <sys/types.h>


void encode(char *image,int imagelen,char *message,int messagelen, char *name) {
  
  int i,j,shift;
  int messagebits;
  FILE *c;
  unsigned char messagemask,imagemask,dataoff;

  dataoff = image[10];
  printf("Les données de l'image comencent à l'offset %d\n",dataoff);

  i=dataoff+34;  //on garde 34 octets de reserve pour pouvoir stocker des informations diverses (besoins ulterieurs)

  messagebits=1; // on consacre 1 bit par octet d'image à stocker le message

  imagemask = 0xFF << messagebits;   //<< decalage à gauche -> le masque d'image est donc 0xFE (pour messagebit = 1) 
  messagemask = imagemask ^ 0xFF; //ou exclusif binaire -> le masque de message est donc 0x01 (pour messagebit = 1)

//tant qu'on a pas ateint la fin du message, on parcours le fichier image à partir de i+34
// de maniere à stocker 1 (messagebit) bit de message dans un octet d'image
  for (j=0,shift=(8-messagebits);j<messagelen;i++) {
    //on remplace les octets d'image de départ par ceux qui integrent un bit de message
    image[i] = (image[i]&imagemask) | ((message[j]>>shift)&messagemask); 
    if (shift == 0) {
	//on reinitialise shift et on avance à l'octet suivant du message
      shift = (8-messagebits);
      j++;
    }
    else
      //on parcours tous les bits d'un octet donné de message
      shift-=messagebits;  //i.e shift= shift-messagebits
  }

  char dst[20];
  sprintf(dst,"images/%s_out.bmp",name);
  printf("Enregistrement du fichier out.bmp sur le disque\n");
  c = fopen(dst,"w");
  fwrite(image,1,imagelen,c);
  fclose(c);
}

int main(int argc,char **argv)
{
  FILE *file;
  char *image=0,*message=0, src[20];
  int imagelen = 0,messagelen = 0;
  int bytesread;

  sprintf(src,"images/%s.bmp",argv[1]);

  printf("Ouverture du fichier image %s ...",src);
  file = fopen(src,"r");
  fseek(file,0,SEEK_END);
  imagelen = ftell(file);
  fseek(file,0,SEEK_SET);
  image = (char *)malloc(imagelen);
  bytesread = fread(image,1,imagelen,file);
  printf("Lecture de %d octets.\n",bytesread);
  fclose(file);

  message=argv[2];
  messagelen=strlen(message);
  printf("la longeur du message est de : %d\n",messagelen);
  
  encode(image,imagelen,message,messagelen,argv[1]);
 
  free(image);
  return 0;
}
