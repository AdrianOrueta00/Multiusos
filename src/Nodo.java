
public class Nodo<T extends Object> {
	//Atributos
	public Nodo<T> prev;
	public Nodo<T> next;
	public T info;
	
	//Constructora
	public Nodo(T pInfo) {
		this.info=pInfo;
	}
	
	//Otros metodos
}
