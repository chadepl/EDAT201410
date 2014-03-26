package huffman;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;

import bitString.BitString;

public class InfoCaracter implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	private char caracter;
	
	private BitString codigo;
	
	/**
	 * Constructor de la clase InfoCaracter
	 * @param pChar Caracter con el que se va a inicializar
	 */
	public InfoCaracter(char pChar){
		
		caracter=pChar;
		
		codigo = null;
		
	}
	
	/**
	 * Constructor de la clase InfoCaracter
	 * @param in Flujo de entrada a partir del cual se va a inicializar
	 * @throws IOException Se lanza si hay algun problema de lectura o escritura
	 */
	public InfoCaracter(DataInputStream in) throws IOException{
		
		caracter = in.readChar();
		
		codigo = new BitString(in);
		
	}
	
	/**
	 * Metodo que retorna el bitString
	 * @return BitString
	 */
	public BitString darCodigo(){
		return codigo;
	}
	
	/**
	 * Metodo que retorna el caracter
	 * @return Caracter
	 */
	public char darCaracter(){
		return caracter;
	}
	
	/**
	 * Metodo que se encarga de asignar un codigo a un caracter
	 * @param info Informacion del caracter donde se va a asignar el codigo 
	 * @param bit Codigo o bit que se va a asignar
	 */
	public void asignarCodigo(InfoCaracter info, boolean bit){
		
		if(info.codigo!=null){
			codigo=new BitString(info.codigo);
		}else if(codigo==null){
			codigo=new BitString();
		}
		codigo.concatenar(bit);
		
	}
	
	/**
	 * Metodo que se encarga de salvar la instancia de la clase
	 * @param out DataOutputStream donde se va a guardar
	 * @throws IOException Se lanza si se presenta algun error de lectura o escritura
	 */
	public void salvar(DataOutputStream out) throws IOException{
		out.writeChar(caracter);
		codigo.salvar(out);
		
	}
	
	/**
	 * Metodo que se encarga de retornar el toString de la clase
	 */
	public String toString(){
		return caracter+":"+codigo;
	}

}
