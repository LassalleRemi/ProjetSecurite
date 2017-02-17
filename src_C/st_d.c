#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <sys/types.h>

void decode(char *image,int imagelen, unsigned long messagelen)
{
  int i,j,shift;
  char *message;
  int  messagebits = 1;
  unsigned char messagemask,imagemask,dataoff;

  dataoff = image[10];
  printf("Les données de l'image comencent à l'offset %d\n",dataoff);

  i = dataoff+34;

  imagemask = 0xFF << messagebits;
  messagemask = imagemask ^ 0xFF;
  
  message = (char *)malloc(messagelen);
  memset(message,0,messagelen);
  for (j=0,shift=(8-messagebits);j<messagelen;i++) {
    message[j] = message[j] | ((image[i]&messagemask)<<shift);
    if (shift == 0) {
      shift=(8-messagebits);
      j++;
    }
    else
      shift-=messagebits;
  }

printf("le message est : %s\n",message);

}


int main(int argc,char **argv)
{
  FILE *file;
  char *image=0;
  int imagelen = 0;
  int bytesread;

  printf("lecture du fichier Image %s...",argv[1]);
  file = fopen(argv[1],"r");
  fseek(file,0,SEEK_END);
  imagelen = ftell(file);
  fseek(file,0,SEEK_SET);
  image = (char *)malloc(imagelen);
  bytesread = fread(image,1,imagelen,file);
  printf("lecture %d octets.\n",bytesread);
  fclose(file);

  decode(image,imagelen,atoi(argv[2]));
 
  free(image);
  return 0;
}
