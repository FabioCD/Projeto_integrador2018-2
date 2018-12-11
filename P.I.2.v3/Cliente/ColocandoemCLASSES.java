
package agendatelefonica;

/**
 *
 * @author Jr
 */
public class ColocandoemCLASSES {
    
     public static void ColocandoemCLASSES(String[] args ){
         	
     
int classe1 = 0;
int classe2 = 0;
int classe3 = 0;
int classe4 = 0;
int classe5 = 0;
int classe6 = 0;
int classe7 = 0;
int classe8 = 0;
int classe9 = 0;
int classe10 = 0;


double entradados[] = {1,46,49,51,54,54,59,59,60,60,61,61,62,65,66,66,67,67,69,70,70,71,72,74,74,76,79,80,82,87,88};

int tamvetor = entradados.length;

if(tamvetor > 30){
for (int i = 0 ; i < 100 ; i++){
    

if (entradados[i] < 10){
classe1 = classe1 + 1;    
}

if (entradados[i] >= 10 && entradados[i] < 20){
classe2 = classe2 + 1;    
}

if (entradados[i] >= 20 && entradados[i] < 30){
classe3 = classe3 + 1;    
}

if (entradados[i] >= 30 && entradados[i] < 40){
classe4 = classe4 + 1;    
}

if (entradados[i] >= 40 && entradados[i] < 50){
classe5 = classe5 + 1;    
}

if (entradados[i] >= 50 && entradados[i] < 60){
classe6 = classe6 + 1;    
}

if (entradados[i] >= 60 && entradados[i] < 70){
classe7 = classe7 + 1;    
}

if (entradados[i] >= 70 && entradados[i] < 80){
classe8 = classe8 + 1;    
}

if (entradados[i] >= 80 && entradados[i] < 90){
classe9 = classe9 + 1;    
}

if (entradados[i] >= 90 && entradados[i] < 100){
classe10 = classe10 + 1;    
}

    System.out.printf("%d/n%d",classe1 + classe2);

}
}
}

}
