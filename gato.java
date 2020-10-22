package gato;
import java.io.*;
public class gato{
  
    public char [] [] tablero;
    public char jugadorUno;
    public char jugadorDos;
    public boolean turno;
    int contador;        
    public gato(){
       
        tablero      = new char[3][3];               
        jugadorUno   = 'X';
        jugadorDos   = 'O';
        turno        = true; 
        int contador = 0;     
        inicializarTablero();  
    }

    public void inicializarTablero(){
       
        int posicion = 1;
       
        for(int i=0;i<3;i++){
               
                for(int j=0; j<3;j++){
                       
                        tablero[i][j] = Integer.toString(posicion).charAt(0);
                        posicion++;
                }                      
        }
    }
    
    
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
   

    public void indicarPosicionArreglo (int a, int b, char c) {tablero [a][b]=c;}
    public void setTurno               (boolean d)            {turno         =d;}
    public void setContador            (int e)                {contador      =e;}
    public char getPosicionArreglo (int a, int b)  {return tablero[a][b];}
    public char getJugadorUno      ()  {return jugadorUno   ;}            
    public char getJugadorDos      ()  {return jugadorDos   ;}            
    public boolean getTurno        ()  {return turno        ;}          
    public int getContador         ()  {return contador     ;}          
    
    public void indicarTurno(){    
        if(getTurno()==true)              
                System.out.println("JUGADOR 1: Elija su casilla con el numero.");        
        else
               
                System.out.println("JUGADOR 2: Elija su casilla con el numero.");      
    }
 
    public char obtenerFigura(){      
        if(getTurno()==true)             
                return jugadorUno;          
        else
               
                return jugadorDos;     
    }
    
    public void cambiarTurno(){        
       
        if(obtenerFigura()=='X') 
               
                setTurno(false);       
        else
               
                setTurno(true);
    }
     
    public void comprobarEspacio(char espacio, int posicionUno, int posicionDos){
     
        if(espacio!=getJugadorUno()&&espacio!=getJugadorDos()){
               
           indicarPosicionArreglo(posicionUno, posicionDos,obtenerFigura());
           cambiarTurno();                                                    
           contador++;                                                                   
        }   
        else                     
           System.out.println("Elije otra casilla");                
    }
           
 
    public void elegirPosicion(int posicion){
                           
            switch(posicion){
               
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
                            
                  System.out.println("Por Favor, Ingrese Solo Un Digito Del 1 al 9.");break;                             
            }          
    }
   
  
    public void decirGanador(char a){

        if(a=='X')
                               
                System.out.println("Gano el jugador 1");
       
               
        else if(a=='O')
                           
                    System.out.println("Gano el jugador 2");                                            
    }

    public void buscarGanador(){
        for(int i=0;i<3;i++){
               
                for(int j=1;j<2;j++){
                       
                        if(tablero[i][j]==tablero[i][j-1]&&tablero[i][j]==tablero[i][j+1]){
                                                       
                           decirGanador(tablero[i][j]);
                           imprimirTablero(0);
                           setContador(10);
                        }                              
                }                      
        }
     
        for(int i=0;i<3;i++){
               
                for(int j=1;j<2;j++){
                       
                        if(tablero[j][i]==tablero[j-1][i]&&tablero[j][i]==tablero[j+1][i]){
                       
                           decirGanador(tablero[j][i]);
                           imprimirTablero(0);
                           setContador(10);
                        }                              
                }
        }
       if(tablero[1][1]==tablero[0][0]&&tablero[1][1]==tablero[2][2]){
       
           decirGanador(tablero[1][1]);
           imprimirTablero(0);
           setContador(10);
        }    
        if(tablero[1][1]==tablero[0][2]&&tablero[1][1]==tablero[2][0]){
               
           decirGanador(tablero[1][1]);
           imprimirTablero(0);                  
           setContador(10);
        }      
    }    

    
    public void jugarGato(){      
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));  
        System.out.println("Equipo C --Gato--");                    
        do{ 
                indicarTurno();                
                imprimirTablero(0);     
                try{elegirPosicion(Integer.parseInt(entrada.readLine()));}
                catch(IOException e){}    
                catch(NumberFormatException e){
                       
                        if(getTurno()==true)
                           
                           System.out.println("ERROR!: Intente Nuevamente JUGADOR 1");
                       
                        else
                               
                           System.out.println("ERROR!: Intente Nuevamente JUGADOR 2.");      
                }                        
                buscarGanador();      
        }while(getContador()<9);
       
          if(getContador()==9){
               
                System.out.println("Empate");                                        
            imprimirTablero(0);
                         
          }
         
         System.out.println("Fin del Juego");            
    }
   
    public static void main(String [] args) throws IOException{
       int tipo;
       
        InputStreamReader flujoEntrada=new InputStreamReader(System.in);
        BufferedReader teclado=new BufferedReader(flujoEntrada);
        String continuar="si";
        
        while(continuar.equals("si")){
            
        gato Objeto = new gato();
       
        Objeto.jugarGato();    
             System.out.println("Deseas continuar con el juego? Si/No ");
            continuar=teclado.readLine();
        }
        
        
    }  
    
}
