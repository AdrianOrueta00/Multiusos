
public class BTN<T extends Comparable<Object>> {
	//Atributos
	protected T info;
	protected BTN<T> left;
	protected BTN<T> right;
	protected BTN<T> father;
	protected int balance; //negativo si cargado por la izquierda, positivo si cargado por la derecha
	
	//Constructora
	protected BTN(T pInfo) {
		info=pInfo;
		balance=0;
	}
	
	//Otros metodos
/*	public void insertar(T pInfo) {
		BTN<T> nodo=new BTN<T>(pInfo);
		if (pInfo.compareTo(this.info)<0) {	//Si la info a insertar es menor que la del nodo actual
			if (left!=null) {				//Si hay un nodo hijo a la izquierda
				left.insertar(pInfo);
			}
			else {
				left=nodo;
			}
			balance--;
		}
		else {
			if (right!=null) {
				right.insertar(pInfo);
			}
			else {
				right=nodo;
			}
			balance++;
		}
	}
 */
	
	protected void corregirEquilibrio() {
		if (balance<-1) {
			rotar("der");
			balance++;
		}
		else if (balance>1){
			rotar("izq");
			balance--;
		}
	}
	
	private void rotar(String pDir) { //Algoritmo para mantener el arbol equilibrado
		if (pDir.equals("izq")) {
			if (father!=null) {
				BTN<T> padre=father;
				if (father.father!=null) {
					BTN<T> abuelo=father.father;
					if (father.info.compareTo(father.father.info)<0) { //Determina a que lado del abuelo esta el padre
						
						abuelo.left=this;
						padre.father=this;
						padre.right=null;
						this.father=abuelo;
						
					}
					else {
						abuelo.right=this;
						padre.father=this;
						padre.right=null;
						this.father=abuelo;
					}
				}
			}
			father=right;
			
		}
	}
	
	private BTN<T> maximoPorIzquierda() {
		BTN<T> act=this.left;
		while (act.right!=null) {
			act=act.right;
		}
		return act;
	}
	
	private BTN<T> minimoPorDerecha() {
		BTN<T> act=this.right;
		while (act.left!=null) {
			act=act.left;
		}
		return act;
	}
}
