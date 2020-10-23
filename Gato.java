package gato3;
import java.io.*;
public class gato3 {
         //este lo hizo Peñaloza Arroyo Israel Juda
     public static void main(String [] args) throws IOException{
         int tipo;
      
         InputStreamReader flujoEntrada=new InputStreamReader(System.in);
         BufferedReader teclado=new BufferedReader(flujoEntrada);
         String continuar="si";
        
         while(continuar.equals("si")){
             
             gato3 programa = new gato3();
            
             programa.jugarGato();    
             System.out.println("¿Desea continuar con el juego? Si / No ");
             continuar=teclado.readLine();
         }  
    } 
    
    
    
     public char [] [] tablero;
     public char jugadorUno;
     public char jugadorDos;
     public boolean turno;
     int contador;
     
     //Constructor(Inicializa Variables).
     public gato3(){
       
         tablero      = new char[3][3];               
         jugadorUno   = 'X';
         jugadorDos   = 'O';
         turno        = true;  //Si El Valor De "turno" Es Igual A "true" El Turno Es Del Jugador 1, De Lo Contrario Es Jugador 2.
         int contador = 0;     //Lleva Cuenta De Las Veces Que Han Participado Los Jugadores 1 y 2.
         inicializarTablero();  
    }
     
      //este lo hizo Ambrosio Hernandez Vieney C
    
     public void inicializarTablero(){ //Inicia El Arreglo, Especifica El Numero Que Le Corresponde A Cada Casilla.
       
         int posicion = 1;
       
         for(int i=0;i<3;i++){
               
                 for(int j=0; j<3;j++){
                       
                        tablero[i][j] = Integer.toString(posicion).charAt(0);
                        posicion++;
                 }                      
         }
     }
     
     //este lo hizo Morales Ruiz Joseline Arel
     //Imprime El Formato Del Tablero.
     public void imprimirTablero(int i) {
         if (i < 3) {
             for (int j = 0; j < 3; j++) {
                 if (j < 2) {
                    System.out.print(" " + tablero[i][j] + " |");
                 } else {
                    System.out.print(" " + tablero[i][j] + " ");
                 }
             }
             if (i < 2) {
                System.out.println("\n-----------");
             }
            imprimirTablero((i + 1));
         }
         System.out.println();
     }
     
     //este lo hizo Morales Ruiz Joseline Arel
      
     public void indicarPosicionArreglo (int a, int b, char c){
        tablero [a][b]=c;
     }
      
     public void setTurno (boolean d) {
         turno =d;
     }
      
     public void setContador (int e) {
         contador = e;
     }
   
       
     public char getPosicionArreglo (int a, int b)  {
         return tablero[a][b];}
       
      
     public char getJugadorUno () {
         return jugadorUno;
     }            
   
     
     public char getJugadorDos ()  {
         return jugadorDos;
     }            
 
     
     public boolean getTurno()  {
        return turno;
     }
                   
     public int getContador()  {
        return contador;
     }          
   
    //este lo hizo Martinez Rayo Iris Madai
    //Imprime e Indica El El Turno Del Jugador Que Le Toca Elejir Una Casilla Con Ayuda del Metodo "getTurno()".
     public void indicarTurno(){
       
        if(getTurno()==true){
             System.out.println("");
             System.out.println("Jugador 1: Escribe la posición de tu casilla");
             System.out.println("");
         }       
         else{
             System.out.println("");
             System.out.println("Jugador 2: Escribe la posición de tu casilla");
             System.out.println("");
         }
               
                     
     }
     //este lo hizo Ambrosio Hernandez Vieney C
     //Regresa El Caracter De Tipo Char Para Posteriormente Ingresarlo A Alguna Posicion Del Arreglo, Usandolo En Otro Metodo.
    public char obtenerFigura(){
       
        if(getTurno()==true){
               
                return jugadorUno;
        }  
        else{
                
                return jugadorDos; 
        }
     }
    //este lo hizo Morales Ruiz Joseline Arel
    //Cambia El Valor De La Variable "turno" Para Llevar El Orden Correcto De Los Turnos Entre Los 2 Jugadores.    
    public void cambiarTurno(){        
       
        if(obtenerFigura()=='X'){ //Si el Metodo regresa un valor char igual a "X" cambia el valor de "turno" a "false".
               
                setTurno(false);
         }
        else{
               
                setTurno(true);
         }
     }
    //este lo hizo Villanueva Ahumada Kate
    //Verifica Si La Posicion Del Arreglo Al Que El Jugador Desea Ingresar El Caracter No Fue Utilizada Antes.  
     public void comprobarEspacio(char espacio, int posicionUno, int posicionDos){
     
       //Si Se Cumple La Condicion Se Ingresa El Valor En La Posicion Del Arreglo Especificada. 
         if(espacio!=getJugadorUno()&&espacio!=getJugadorDos()){
               
           indicarPosicionArreglo(posicionUno, posicionDos,obtenerFigura());//Ingresa EL Caracter Si Se Cumple La Condicion.
           cambiarTurno();                                                  //Cambia El Turno Si Se Cumple La Condicion.  
           contador++;                                                      //Solo Incremente Cuando Se Cumple La Anterior Condicion.              
        }
         else{
         
         //Imprime El Siguiente Mensaje En Caso De Que No Se Cumpla La Anterior Condicion.                             
           System.out.println("Casilla ocupada");  
        }
    }
       //este lo hizo Juarez Ramos Alexis Manuel    
  //Metodo Que Hace Uso De Un "switch" Para Indicar La Posicion Del Arreglo Que El Jugador Elijio En El Juego.  
    public void Posicion(int posicion){
                           
            switch(posicion){
               
                  //Comprueba Si La Posicion Esta Disponible Valiendose Del Metodo "comprobarEspacio()"
                        case 1:comprobarEspacio(getPosicionArreglo(0,0),0,0);break;
                        case 2:comprobarEspacio(getPosicionArreglo(0,1),0,1);break;
                        case 3:comprobarEspacio(getPosicionArreglo(0,2),0,2);break;
                        case 4:comprobarEspacio(getPosicionArreglo(1,0),1,0);break;
                        case 5:comprobarEspacio(getPosicionArreglo(1,1),1,1);break;
                        case 6:comprobarEspacio(getPosicionArreglo(1,2),1,2);break;
                        case 7:comprobarEspacio(getPosicionArreglo(2,0),2,0);break;
                        case 8:comprobarEspacio(getPosicionArreglo(2,1),2,1);break;
                        case 9:comprobarEspacio(getPosicionArreglo(2,2),2,2);break;
                        default:
                          //Imprime El Siguiente Mensaje En Caso De Que El "switch" No Reciba Un Digito Del 1 al 9.    
                                System.out.println("Intente de nuevo, solo numeros del 1 a 9");break;                             
            }          
    }
   //este lo hizo Villanueva Ahumada Kate
  //Solo Imprime Un Mensaje Distinto Dependiendo Del Jugador Que Haya Resultado Ganador.
    public void Ganador(char a){
       
       
        if(a=='X'){
             System.out.println(""); 
             System.out.println("El jugador 1 ha ganado");
             System.out.println("");
        }             
        else if(a=='O'){
             System.out.println("");
             System.out.println("El jugador 2 ha ganado");
             System.out.println("");
        }
                               
    }
   //este lo hizo Peñaloza Arroyo Israel Juda, Ambrosio Hernandez Vieney C y Juarez Ramos Alexis Manuel
   
 //Verifica Las Unicas 8 Combinaciones Que Pueden Dar La Victoria A Uno De Los Jugadores.
     public void ElegirGanador(){
                 
      //Ciclo Con Instrucciones Para Comprobar Las 3 Posibilidades De Ganar De Forma Horizontal.
         for(int i=0;i<3;i++){
               
                 for(int j=1;j<2;j++){
                       
                         if(tablero[i][j]==tablero[i][j-1]&&tablero[i][j]==tablero[i][j+1]){
                                                       
                             Ganador(tablero[i][j]);
                             imprimirTablero(0);
                             setContador(10);
                         }                              
                 }                      
         }
   
      //Ciclo Con Instrucciones Para Comprobar Las 3 Posibilidades De Ganar De Forma Vertical.  
         for(int i=0;i<3;i++){
               
                 for(int j=1;j<2;j++){
                       
                         if(tablero[j][i]==tablero[j-1][i]&&tablero[j][i]==tablero[j+1][i]){
                             Ganador(tablero[j][i]);
                             imprimirTablero(0);
                             setContador(10);
                         }                              
                 }
         }
       
      //Instrucciones Para Comprobar La Unica Posibilidad De Ganar De Forma Diagonal.  
         if(tablero[1][1]==tablero[0][0]&&tablero[1][1]==tablero[2][2]){   
             Ganador(tablero[1][1]);
             imprimirTablero(0);
             setContador(10);
        }  
           
      //Ciclo Con Instrucciones Para Comprobar La Unica Posibilidade De Ganar De Forma Diagonal Inversa.
         if(tablero[1][1]==tablero[0][2]&&tablero[1][1]==tablero[2][0]){
             Ganador(tablero[1][1]);  
             imprimirTablero(0);
             setContador(10);
        }      
    }    
     //este lo hizo Santamaria Vera Iris Itzel  
  //Metodo Que Contiene El Flujo Y El Orden Del Juego.
    public void jugarGato(){
       
         BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
       
         System.out.println("*******************Equipo C*******************");      
               
         do{
       
                 indicarTurno();                
                 imprimirTablero(0);     
                 try{Posicion(Integer.parseInt(entrada.readLine()));}
                 catch(IOException e){}    
                 catch(NumberFormatException e){
                    
                         if(getTurno()==true){
                           
                           System.out.println("Jugador 1: Intente de nuevo");
                         }
                         else{
                               
                           System.out.println("Jugador 2: Intente de nuevo");
                         }
                 }
                         
                 ElegirGanador();
       
         }while(getContador()<9);
       
          if(getContador()==9){           
                 System.out.println("Han empatado");
                 imprimirTablero(0); 
                             
          }
         
         System.out.println("----------El juego finalizo----------"); 
         System.out.println("");
    }
 }


//Santamaria Vera Iris Itzel
//Peñaloza Arroyo Israel Juda 
//Ambrosio Hernandez Vieney C
//Villanueva Ahumada Kate
////Juarez Ramos Alexis Manuel
//Morales Ruiz Joseline Arel
//Martinez Rayo Iris Madai
