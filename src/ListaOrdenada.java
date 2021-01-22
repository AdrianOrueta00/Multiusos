
public class ListaOrdenada<T extends Comparable<Object>> {
	//Atributos
	private BTN<T> root;
	private int length;
	
	//Constructora
	public ListaOrdenada() {
		this.length=0;
	}
	
	//Otros metodos
	
	public void insertar(T pInfo) { //Inserta de manera ordenada llamando al metodo recursivo inertar de la clase BTN<T>
		if (root!=null) {
			root.insertar(pInfo);
		}
		else {
			root = new BTN<T>(pInfo);
		}
		this.length++;
	}
	
	
//	public void insertar(T pInfo) {
//		T info= pInfo;
//		BTN<T> nodo=new BTN<T>(pInfo);
//		if (root==null) {
//			root=nodo;
//		}
//		else if (pInfo.compareTo(nodo.info)<0) {
//			if (root.balance>-1) {
//		
//			}
//			else {
//		
//			}
//		}
//		else {
//			if (root.balance<1) {
//		
//			}
//			else {
//		
//			}
//
//		}
//	}
	public void quitarDelPrincipio() { //Retira del arbol el valor minimo llamando al metodo privado del mismo nombre para usar recursividad
		
		if (root!=null) { //Si el arbol no esta vacio
			quitarDelPrincipio(root);
			this.length--;
		}
	}
	
	private void quitarDelPrincipio(BTN<T> pNodo) { //Usa recursividad por inmersion para encontrar el nodo con el valor minimo y retirarlo

		if (pNodo.left==null) { //Si no hay valores mas a la 'izquierda' es el valor minimo o 'del principio'
			
			if (pNodo!=root) { //Caso especial si el valor minimo es root
				pNodo.father.left=pNodo.right;
				pNodo.right.father=pNodo.father;
			}
			
			else { //Caso final normal
				root=pNodo.right;
				if (pNodo.right!=null) {
					pNodo.right.father=null;
				}
				
			}
		}
		else { //Caso recursivo usando inmersion
			quitarDelPrincipio(pNodo.left);
			pNodo.balance++;
			pNodo.corregirEquilibrio(); //Reequilibra el arbol
		}
	}
	
	public void quitarDelFinal() { //Llama al metodo privado para poder usar recursividad por inmersion
		
		if (root!=null) { //Si el arbol no esta vacio
			quitarDelFinal(root);
		}
	}
	
	private void quitarDelFinal(BTN<T> pNodo) { //Usa recursividad por inmersion para encontrar el nodo con el valor maximo y retirarlo
		
		if (pNodo.right==null) { //Si no hay valores mas a la 'derecha' es el valor maximo o 'del final'
			
			if (pNodo!=root) { //Caso especial si el valor maximo es root
				pNodo.father.right=pNodo.left;
				pNodo.left.father=pNodo.father;
			}
			else { //Caso final normal
				this.root=pNodo.left;
				if (pNodo.left!=null) {
					pNodo.left.father=null;
				}
			}
		}
		else { //Caso recursivo usando inmersion
			quitarDelFinal(pNodo.right);
			pNodo.balance--;
			pNodo.corregirEquilibrio(); //Reequilibra el arbol
		}
	}
	
	public void quitar(T pInfo) {
		
	}
	
	public void quitar(int pPos) {
		if (pPos>=0&&pPos<this.length) {
			
		}
		else {
			throw new IndexOutOfBoundsException();
		}
	}
	
	public T encontrar(T pInfo) {
		T res=null;
		if (this.root!=null) {
			res=this.encontrar(pInfo, root);
		}
		return res;
	}
	
	private T encontrar(T pInfo, BTN<T> pNodo) {
		
	}
}
