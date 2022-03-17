package Act_joc_vida;


import java.util.Scanner;
public class JocVida1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//funcio nombre veins
		//funcio imprimir taulell
		//usuari diu tamany matriu amb les dos cordenades
		//funcio crear colonies al inici
		//demanar nombre de taulell
		Scanner e= new Scanner (System.in);

		JocVida1 p= new JocVida1();
		p.principal();
	}
	public void principal() {
		int[] dim = new int[2];
		dimensions(dim);
		colonies(dim[0], dim[1]);
		System.out.println("Gràcies per jugar! :)");
	}
	public int[] dimensions( int[] dimensio) {
		Scanner e= new Scanner (System.in);
		
		
		System.out.println("Introdueix el nombre de files de la matriu");
		dimensio[0]= e.nextInt();
		System.out.println("Introdueix el nombre de columnes de la matriu");
		dimensio[1]= e.nextInt();
		
		
		return dimensio;
	}
	public int[][] colonies(int d_fila, int d_columna) {
		
		int[][] taula= new int[d_fila][d_columna];
		Scanner e= new Scanner (System.in);
		int opcio;
		System.out.println("Tria una de les següents opcions");
		System.out.println("[1] --> Crear colonies manualment(5 primeres cel·lules)");
		System.out.println("[2] --> Crear colonies automàticament(En manteniment)");
		opcio=e.nextInt();
		
		int fila=0;
		int columna=0;
		
		switch(opcio) {
			case 1:
				for(int i=0; i<5; i++) {
					System.out.println("Insereix la fila(0-"+(d_fila-1)+") de la cel·lula incial "+i+": ");
					System.out.print("x: ");
					fila=e.nextInt();
					System.out.println("Insereix la columna(0-"+(d_columna-1)+") de la cel·lula incial "+i+": ");
					System.out.print("y: ");
					columna=e.nextInt();
					while(fila<1 || fila>d_fila-1 ) {
						System.out.println("Nombre no vàlid!!");
						System.out.println("Insereix la fila(0-"+(d_fila-1)+") de la cel·lula incial "+i+": ");
						System.out.print("x: ");
						fila=e.nextInt();
					}
					while(fila<1 || fila>d_columna-1 ) {
						System.out.println("Nombre no vàlid!!");
						System.out.println("Insereix la columna(0-"+(d_columna-1)+") de la cel·lula incial "+i+": ");
						System.out.print("y: ");
						columna=e.nextInt();
					}
					taula[fila][columna]= 1;
					
					
				}
				matriu(taula);
				/*for(int f=0; f<taula.length; f++) {
					for(int c=0; c<taula[f].length; c++) {
						
					}
				}*/
				break;
			case 2:
				System.out.println("Quantes colonies vols crear?");
				int N=e.nextInt();
				for(int i=0; i<N; i++) {
					
				}
				for(int f=0; f<taula.length; f++) {
					for(int c=0; c<taula[f].length; c++) {
						
					}
				}
				break;
		}
		creixement(taula);
		
		return taula;
	}
	public int[][] matriu(int[][] print) {
		
		for (int f=0; f < print.length; f++) {
			System.out.print("| ");
		    for (int c=0; c < print[f].length; c++){
		    	
		    	System.out.print (print[f][c] + " | "); 

		    }  
		    System.out.println();

		}
		
		return print;
	}
	public int[][] creixement(int[][] comprova) {
		Scanner e= new Scanner (System.in);
		boolean acabat=false;
		int f=0;
		int[][] veins= new int[comprova.length][comprova[f].length];
		int opcio=0;
		while (!acabat) {
			if (acabat==true) {
				break;
			}
			for(f=0; f<comprova.length; f++) {
				for(int c=0; c<comprova[f].length; c++) {
					if (f==0 || f==comprova.length-1 || c==0 || c==comprova[f].length-1) {
						if (f==0 && c==0) {
							if(comprova[f][c+1]==1) {
								veins[f][c]++;
							}
							if(comprova[f+1][c+1]==1) {
								veins[f][c]++;
							}
							if(comprova[f+1][c]==1) {
								veins[f][c]++;
							}
						}
						if (f==comprova.length-1 && c==0) {
							if(comprova[f][c+1]==1) {
								veins[f][c]++;
							}
							if(comprova[f-1][c]==1) {
								veins[f][c]++;
							}
							if(comprova[f-1][c+1]==1) {
								veins[f][c]++;
							}
						}
						if (f==0 && c==comprova[f].length-1) {
							if(comprova[f][c-1]==1) {
								veins[f][c]++;
							}
							if(comprova[f+1][c-1]==1) {
								veins[f][c]++;
							}
							if(comprova[f][c]==1) {
								veins[f][c]++;
							}
						}
						if (f==comprova.length-1 && c==comprova[f].length-1) {
							if(comprova[f][c-1]==1) {
								veins[f][c]++;
							}
							if(comprova[f-1][c-1]==1) {
								veins[f][c]++;
							}
							if(comprova[f-1][c]==1) {
								veins[f][c]++;
							}
						}
						if (f==0 && (c>0 && c<comprova[f].length-1)) {
							if(comprova[f][c-1]==1) {
								veins[f][c]++;
							}
							if(comprova[f][c+1]==1) {
								veins[f][c]++;
							}
							if(comprova[f+1][c-1]==1) {
								veins[f][c]++;
							}
							if(comprova[f+1][c]==1) {
								veins[f][c]++;
							}
							if(comprova[f+1][c+1]==1) {
								veins[f][c]++;
							}
						}
						if (f==comprova.length-1 && (c>0 && c<comprova[f].length-1)) {
							if (comprova[f-1][c]==1) {
								veins[f][c]++;
							}
							if(comprova[f-1][c-1]==1) {
								veins[f][c]++;
							}
							if(comprova[f][c-1]==1) {
								veins[f][c]++;
							}
							if(comprova[f-1][c+1]==1) {
								veins[f][c]++;
							}
							if(comprova[f][c+1]==1) {
								veins[f][c]++;
							}
						}
						if (c==0 && (f>0 && f<comprova.length-1)) {
							if (comprova[f-1][c]==1) {
								veins[f][c]++;
							}
							if(comprova[f-1][c+1]==1) {
								veins[f][c]++;
							}
							if(comprova[f][c+1]==1) {
								veins[f][c]++;
							}
							if(comprova[f+1][c]==1) {
								veins[f][c]++;
							}
							if(comprova[f+1][c+1]==1) {
								veins[f][c]++;
							}
						}
						if (c==comprova.length-1 && (f>0 && f<comprova.length-1)) {
							if (comprova[f-1][c]==1) {
								veins[f][c]++;
							}
							if(comprova[f-1][c-1]==1) {
								veins[f][c]++;
							}
							if(comprova[f][c-1]==1) {
								veins[f][c]++;
							}
							if(comprova[f+1][c-1]==1) {
								veins[f][c]++;
							}
							if(comprova[f+1][c]==1) {
								veins[f][c]++;
							}
						}
					}
					else {
						
						if (comprova[f-1][c]==1) {
							veins[f][c]++;
						}
						if(comprova[f-1][c-1]==1) {
							veins[f][c]++;
						}
						if(comprova[f][c-1]==1) {
							veins[f][c]++;
						}
						if(comprova[f-1][c+1]==1) {
							veins[f][c]++;
						}
						if(comprova[f][c+1]==1) {
							veins[f][c]++;
						}
						if(comprova[f+1][c-1]==1) {
							veins[f][c]++;
						}
						if(comprova[f+1][c]==1) {
							veins[f][c]++;
						}
						if(comprova[f+1][c+1]==1) {
							veins[f][c]++;
						}
					}
				}
			}
			for(f=0; f<comprova.length; f++) {
				for(int c=0; c<comprova[f].length; c++) {
					if(comprova[f][c]==1) {
						if(veins[f][c]<=1) {
							comprova[f][c]=0;
						}
						else if(veins[f][c]>=4) {
							comprova[f][c]=0;
						}
						else if(veins[f][c]==2 || veins[f][c]==3) {
							comprova[f][c]=1;
						}
					}
					else {
						if(veins[f][c]==3) {
							comprova[f][c]=1;
						}
					}
				}
			}
			for (f=0; f < veins.length; f++) {
			    for (int c=0; c < veins[f].length; c++){
			    	veins[f][c]=0;
			    }
			}
			
			matriu(comprova);
			System.out.println("Vols continuar?");
			System.out.println("[1] --> Sí");
			System.out.println("[2] --> No");
			opcio=e.nextInt();
			switch(opcio) {
			case 1:
				acabat=false;
				break;
			case 2:
				acabat=true;
				break;
			}
		}
		
		return comprova;
	}

}
