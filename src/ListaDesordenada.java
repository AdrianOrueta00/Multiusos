

public class ListaDesordenada<T extends Object> {
	//Atributos
	private Nodo<T> first;
	private int largo;
	//Constructora
	public ListaDesordenada() {
		this.largo=0;
	}
	//Otros metodos
	
	
	public void anadir(T pObjeto) { //Coste Constante
		Nodo<T> ins=new Nodo<T>(pObjeto);		//Anade al final
		if (first!=null) {
			ins.next=first;
			ins.prev=first.prev;
			first.prev.next=ins;
			first.prev=ins;
		}
		else {
			first=ins;
			first.prev=first;
			first.next=first;
		}
		largo++;
	}
	
	
	public void anadir(T pObjeto, int pPos) throws ArrayIndexOutOfBoundsException{ //Coste Lineal      			Media n/4
		if (0<=pPos && pPos<largo) {													//Anade en la posicion pPos
			int vueltas;
			Nodo<T> ins=new Nodo<T>(pObjeto);
			Nodo<T> act=first;
			if (pPos<=(largo-pPos)) { //Decide en que sentido el camino es mas corto
				vueltas=pPos;
				while (vueltas>0) {
					act=act.next;
					vueltas--;
				}
			}
			else {
				vueltas=(largo-pPos);
				while (vueltas>0) {
					act=act.prev;
					vueltas--;
				}
			}
			//Inserta el nuevo nodo
			ins.next=act;
			ins.prev=act.prev;
			act.prev.next=ins;
			act.prev=ins;
			largo++;
		}
		else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	
	public void anadirAlPrincipio(T pObjeto) { //Coste Constante
		Nodo<T> ins=new Nodo<T>(pObjeto);
		if (first!=null) {
			ins.next=first;
			ins.prev=first.prev;
			first.prev.next=ins;
			first.prev=ins;
			first=first.prev;
		}
		else {
			first=ins;
			first.prev=first;
			first.next=first;
		}
		largo++;
	}

	
	//Si la lista es vacia no hace nada
	public void quitarDelPrincipio() { //Coste Constante
		if (first!=null) {
			first.prev.next=first.next;
			first.next.prev=first.prev;
			first=first.next;
			largo--;
		}
	}
	
	//Quita el ultimo elemento
	public void quitar() {
		first.prev.prev.next=first;
		first.prev=first.prev.prev;
		largo--;
	}
	
	
	public void quitar(int pPos) throws ArrayIndexOutOfBoundsException{ //Coste Lineal      media n/4
		if (0<=pPos && pPos<largo) {
			int vueltas;
			Nodo<T> act=first;
			if (pPos<=(largo-pPos)) { //Decide en que sentido el camino es mas corto
				vueltas=pPos;
				while (vueltas>0) {
					act=act.next;
					vueltas--;
				}
			}
			else {
				vueltas=(largo-pPos);
				while (vueltas>0) {
					act=act.prev;
					vueltas--;
				}
			}
			//Quita el nodo
			if (act.next!=act) { //Mas de un elemento en la lista
				act.prev.next=act.next;
				act.next.prev=act.prev;
			}
			else { //Solo un elemento en la lista
				first=null;
			}
		}
		else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	
	public void ordenar(Object pObjeto) {
		
	}
	
	public void toOrdenada() {
		
	}
}
