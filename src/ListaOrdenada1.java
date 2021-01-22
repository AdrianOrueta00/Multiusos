
public class ListaOrdenada1<T extends Comparable<Object>> {
		//Atributos
		private Nodo first;
		private int largo;
		
		//Constructora
		public ListaOrdenada1() {
			
		}
		
		//Otros metodos
		public void anadir(T pObjeto) { //Coste O(n x log(n) + n)
			
		}
		
		public void quitarDelPrincipio() { //Coste Constante
			first.prev.next=first.next;
			first.next.prev=first.prev;
			first=first.next;
			largo--;
		}
		
		public void quitarDelFinal() { //Coste Constante
			first.prev.prev.next=first;
			first.prev=first.prev.prev;
			largo--;
		}
		
		public void quitar(int pPos) throws ArrayIndexOutOfBoundsException{ //Coste Lineal
			if (0<=pPos && pPos<largo) {
				int vueltas;
				Nodo act=first;
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
	}
