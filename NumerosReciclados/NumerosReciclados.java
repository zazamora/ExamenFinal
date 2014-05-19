import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
public class NumerosReciclados{
	private static BufferedReader lector;
	private static PrintWriter escritor;
	public static void leer(String nombreArchivo){
		try{
			lector = new BufferedReader(new FileReader(nombreArchivo));
			//primero se crea el buffer lector. En su constructor debe recibir el archivo que va a leer.
		}catch(FileNotFoundException e){
			System.out.println("El archivo " + nombreArchivo + " no existe");
		}
		String [] datos = null;
		String linea;
		try{
			while((linea = lector.readLine()) != null){
				datos = linea.split(" ");
				if(datos.length>1){
                   revisarDatos(datos,nombreArchivo);
               	}
			}
		}catch(Exception e){
			
		}

	}
	public static void revisarDatos(String [] datos,String nombreArchivo){
		int a = Integer.parseInt(datos[0]), b = Integer.parseInt(datos[1]);
		int contador = 0;
		int tam = 0;
		int index = 0;
		String resultados = "";
		for (int i = a;i<=b;i++) {
			String var = String.valueOf(i);
			String var2 = var;
			int lon = var.length();
			if(lon%2==0){
				tam = lon/2;
			}else{
				tam = (lon-1)/2;
			}	
			//System.out.println("tamaño: " + tam + " longi: " + lon);
			String numero = var.substring(tam,lon);
			String numero2 = var2.substring(0,tam);
			if (!numero.substring(0,1).equals("0")) {
				int dato = Integer.parseInt(numero+numero2);
				if (dato<=b && dato!=i && dato>i) {
					contador++;
				}
			}
		} 
		resultados = "Rango: " + datos[0] + " - " + datos[1] + ". La cantidad de numeros reciclados es: " + contador;
		escribir("NumerosReciclados_201313952.txt",resultados);
		contador = 0;
	}
	public static void escribir(String nombreArchivo, String resultados){
		FileWriter escritorDeArchivo = null;
		try{
			escritorDeArchivo = new FileWriter(nombreArchivo,true);
			//El true crea el archivo en caso no exista.
		}catch(IOException e){
			System.out.println("Error al intentar escribir en el archivo");
		}
		escritor = new PrintWriter(escritorDeArchivo,true);
		escritor.println(resultados);
	}


	public static void main(String[] args) {
		leer(args[0].toString());
	}
}