package edat.estructuras2023.Jerarquicas.Dinamicas;

import edat.estructuras2023.Lineales.Dinamicas.Lista;

public class ArbolBin {

    private NodoArbol raiz;

    public ArbolBin() {
        this.raiz = null;
    }

    public boolean insertar(Object nuevoElem, Object elemPadre, Character lugar) {
        boolean rta = false;

        if (this.raiz == null) {
            this.raiz = new NodoArbol(nuevoElem, null, null);
        rta = true;
        } else {
            NodoArbol nodoPadre = obtenerNodo(this.raiz, elemPadre);

            /* Si el nodo padre existe, comprueba si el lugar esta vacio.
             * si esta vacio, inserta el nuevo elemento en el lugar correspondiente
             * y devuelve true. Si no esta vacio, devuelve false.
             */

            if (nodoPadre != null) {
                if (Character.toLowerCase(lugar) == 'i'  && nodoPadre.getIzquierdo() == null) {
                    nodoPadre.setIzquierdo(new NodoArbol(nuevoElem, null, null));
                rta = true;
                } else if (Character.toLowerCase(lugar) == 'd' && nodoPadre.getDerecho() == null) {
                    nodoPadre.setDerecho(new NodoArbol(nuevoElem, null, null));
                rta = true;
                }
            
            }
        }

        return rta;
    }

    private NodoArbol obtenerNodo (NodoArbol nodo, Object elem){
        NodoArbol rta=null;

        if(nodo!=null){
            if(nodo.getElem().equals(elem)){
                rta=nodo;
            }else {
                    rta = obtenerNodo(nodo.getIzquierdo(), elem);

                    if( rta==null){

                        rta = obtenerNodo(nodo.getDerecho(), elem);
                    }
                }
            }
        

        return rta;

    }

    public boolean esVacio(){

        boolean rta=false;

        if (this.raiz !=null){
            rta=true;
        }

        return rta;
    }


    public void vaciar(){
        this.raiz=null;
    }

    public int altura(){
        int rta;

       
            rta=alturaAux(this.raiz);
        

        return rta;
    }

    private int alturaAux(NodoArbol nodo){
        int rta;
        int altIzq, altDer;

        if (nodo ==null){
            rta=-1;
        }else{
            // rta = 1 + Math.max(alturaAux(nodo.getIzquierdo()), alturaAux(nodo.getDerecho())

            altDer=alturaAux(nodo.getDerecho());

            altIzq=alturaAux(nodo.getIzquierdo());
            
            if(altDer>altIzq){
                rta=altDer+1;
            }else{
                rta=altIzq+1;
            }
           
        }

        return rta;
    }

    public NodoArbol padre(NodoArbol elem){

        NodoArbol rta=null;

        rta=padreAux(this.raiz, elem);
        
        return rta;
    }

    public NodoArbol padreAux(NodoArbol nodo, NodoArbol elem){
        
        NodoArbol rta=null;

        if(nodo!=null){
            //si el nodo no es nulo, comprueba si el hijo izquierdo o derecho contiene elemento buscado
            if(nodo.getIzquierdo().getElem().equals(elem) || nodo.getDerecho().getElem().equals(elem)){
                //si lo contiene, devuelve el nodo
                rta=nodo;
            }else{ //si no lo contiene, busca en el hijo izquierdo y derecho
                rta=padreAux(nodo.getIzquierdo(), elem);
                //si no lo encuentra en el hijo izquierdo, busca en el derecho
                if(rta==null){
                    rta=padreAux(nodo.getDerecho(), elem);
                }
            }
        }

        return rta;
    }

    public int nivel(NodoArbol elem){
        int rta;

       rta=alturaAux(obtenerNodo(this.raiz, elem));

        return rta;
    }

    public Lista listarPreorden(){
        Lista rta=new Lista();
        return listarPreordenAux(this.raiz,rta);
    }

    private Lista listarPreordenAux(NodoArbol nodo, Lista lista){
        
        if(nodo!=null){

        lista.insertar(nodo.getElem(), lista.longitud()+1);
        
        lista = listarPreordenAux(nodo.getDerecho(), lista);
        lista = listarPreordenAux(nodo.getIzquierdo(), lista);

        }

        return lista;
    }

    public Lista listarInorden(){
        Lista rta=new Lista();
        return listarInordenAux(this.raiz,rta);
    }

    private Lista listarInordenAux(NodoArbol nodo, Lista lista){
        
        if(nodo!=null){

        lista = listarInordenAux(nodo.getDerecho(), lista);

        lista.insertar(nodo.getElem(), lista.longitud()+1);

        lista = listarInordenAux(nodo.getIzquierdo(), lista);

        }

        return lista;
    }

    public Lista listarPosorden(){
        Lista rta=new Lista();
        return listarPosordenAux(this.raiz,rta);
    }

    private Lista listarPosordenAux(NodoArbol nodo, Lista lista){
        
        if(nodo!=null){

        lista = listarPosordenAux(nodo.getDerecho(), lista);

        lista = listarPosordenAux(nodo.getIzquierdo(), lista);

        lista.insertar(nodo.getElem(), lista.longitud()+1);

        }

        return lista;
    }

    public Lista listarPorNiveles(){
        Lista rta=new Lista();
        return listarPorNivelesAux(this.raiz,rta);
    }

    private Lista listarPorNivelesAux(NodoArbol nodo, Lista lista){
        
        if(nodo!=null){
        
        }

        return lista;
    }



}
