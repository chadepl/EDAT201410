package bitString;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;


public class BitString implements Serializable {
	
	

	private static final long serialVersionUID = 1L;

	private byte[] bits;
	
	private int numeroBits;
	
	//CONSTRUCTORES
	
	
	/**
	 * Construye un BitString vacio
	 */
	public BitString(){
		
		bits=null;
		numeroBits=0;
		
	}
	
	/**
	 * Construye un BitString a partir de otro que entra por parametro 
	 * @param bs BitString que entra por parametro y a partir del cual se creara el nuevo
	 */
	public BitString(BitString bs){
		if (bs.bits == null) {
			bits = null;
			numeroBits = 0;
		} else {
			bits = new byte[bs.numeroBits];
			numeroBits = bs.numeroBits;
			for (int i = 0; i < bs.bits.length; i++) {
				bits[i] = bs.bits[i];
			}
		}
		
	}
	
	/**
	 * Construye en BitString a partir de un flujo de entrada
	 * @param is Flujo de entrada de datos 
	 * @throws IOException Se lanza si se genera algun error en la lectura;
	 */
	public BitString(DataInputStream is) throws IOException{
		int nBits=is.readInt();
		int nBytes=(int) Math.ceil(nBits/8);
		bits=new byte[nBytes];
		is.read(bits, 0, nBytes);
		
	}
	
	//METODOS
	
	/**
	 * Metodo que se encarga de vaciar el bitString
	 */
	public void vaciar(){
		bits=null;
		numeroBits=0;	
	}
	
	/**
	 * Metodo que retorna la longitud del BitString 
	 * @return Longitud del bitString
	 */
	public int darLongitud(){
		return numeroBits;
	}
	
	/**
	 * Metodo que se encarga de confirmar si un bit en determinada posicion esta encendido o apagado
	 * @param posicionBit Posicion dentro del bitString donde se quiere evaluar el estado del bit
	 * @return true si esta encendido o false en caso contrario
	 */
	public boolean estaEncendido(int posicionBit) {
		if (bits == null || posicionBit >= numeroBits)
			return false;
		else {
			int posByte = posicionBit / 8;
			int posicionLocal = posicionBit % 8;
			byte mascara = 1;
			for (int i = 0; i < posicionLocal; i++) {
				mascara *= 2;
			}
			int resp = bits[posByte] & mascara;
			return resp != 0;
		}

	}
	
	public boolean estaApagado(int posicionBit){
		return !estaEncendido(posicionBit);
	}
	
	/**
	 * Metodo que se encarga de asignar un estado a un bit en la posicion dada.
	 * @param posicionBit La posicion donde se quiere asignar el bit
	 * @param bit Bit que se va a asignar al BitString
	 */
	public void asignar(int posicionBit, boolean bit){
		int posByte = posicionBit / 8;
		if (bits == null || posicionBit >= bits.length * 8) {
			bits = new byte[posByte + 1];
			for (int i = 0; i < posByte + 1; i++) {
				bits[i] = 0;
			}

		} else {
			byte[] old = bits;
			bits = new byte[posicionBit + 1];
			for (int i = 0; i < posByte + 1; i++) {
				bits[i] = i < old.length ? old[i] : 0;
			}
		}

		int posLocal = posicionBit % 8;
		byte mascara = 1;
		for (int i = 0; i < posLocal; i++) {
			mascara *= 2;
		}
		if (bit && posicionBit >= 0) {
			bits[posByte] = (byte) (bits[posByte] | mascara);
		} else if (posicionBit >= 0) {
			mascara = (byte) ~mascara;
			bits[posByte] = (byte) (bits[posByte] & mascara);

		}
		if (posicionBit >= numeroBits) {
			numeroBits = posicionBit + 1;
		}
	}
	
	/**
	 * Metodo que se encarga de concatenar o unir dos bitStrings para formar uno solo
	 * @param bs bitString que se va a concatenar
	 */
	public void concatenar(BitString bs){
		if (bs.numeroBits != 0) {
			if (bits == null) {
				bits = new byte[bs.bits.length];
				numeroBits = bs.numeroBits;
				for (int i = 0; i < bits.length; i++) {
					bits[i] = bs.bits[i];
				}
			} else {
				for (int i = 0; i < bs.numeroBits; i++) {
					concatenar(bs.estaEncendido(i));
				}
			}
		}
	}
	
	/**
	 * 
	 * @param bit
	 */
	public void concatenar(boolean bit){
		
		asignar(numeroBits, bit);
		
	}
	
	/**
	 * Metodo que se encarga de serializar la clase
	 * @param out Stream que se encargara de escribir la informacion
	 * @throws IOException Se lanza si se presenta algun error de lectura - escritura
	 */
	public void salvar(DataOutputStream out) throws IOException{
		
		out.writeInt(numeroBits);

		if (bits != null) {
			out.write(bits, 0, numeroBits);
		}
		
	}
	
	/**
	 * Metodo que compara dos bitStrings para determinar si son o no iguales
	 * @param bs bitString contra el que se va a comparar
	 * @return true si son iguales o false en caso contrario
	 */
	public boolean equals(BitString bs){
		
		if (numeroBits != bs.numeroBits)
			return false;
		else {
			int long1 = Math.min(bits == null ? 0 : bits.length,
					bs.bits == null ? 0 : bs.bits.length);
			int i = 0;
			for (; i < long1 && bits[i] == bs.bits[i]; i++)
				;
			return i == long1;
		}
		
	}
	
	/**
	 * Metodo que retorna el toString de la clase
	 * @return toString de la clase
	 */
	public String toString(){
		
		StringBuffer bf = new StringBuffer( numeroBits + 10 );
		bf.append( "[" + numeroBits + "]:" );
		for( int i = 0; i < numeroBits; i++ ){
			if( estaEncendido( i ) )
				bf.append( "1" );
			else
				bf.append( "0" );
			}
		return bf.toString( );
		}
		
	
	
}
