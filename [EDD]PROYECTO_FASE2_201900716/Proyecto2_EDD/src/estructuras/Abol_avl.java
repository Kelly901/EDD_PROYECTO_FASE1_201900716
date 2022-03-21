/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

/**
 *
 * @author Kelly
 */
public class Abol_avl {

    NodeAvl root = null;

    public void add(int valor) {

        root = add(valor, root);
    }

    public NodeAvl add(int valor, NodeAvl tmp) {

        if (tmp == null) {
            tmp = new NodeAvl(valor);
        } else if (valor < tmp.getValor()) {
            tmp.setLeft(add(valor, tmp.getLeft()));
            if ((altura(tmp.getLeft()) - altura(tmp.getRight())) == 2) {
                if (valor < tmp.getLeft().getValor()) {
                    tmp = srl(tmp);
                } else {
                    tmp = drl(tmp);
                }
            }
        } else {
            tmp.setRight(add(valor, tmp.getRight()));
            if ((altura(tmp.getRight()) - altura(tmp.getLeft())) == 2) {
                if (valor > tmp.getRight().getValor()) {
                    tmp = srr(tmp);
                } else {
                    tmp = drr(tmp);
                }
            }

        }
        int d, i, m;
        d = altura(tmp.getRight());
        i = altura(tmp.getLeft());
        m = maxi(d, i);

        return tmp;

    }

    public int altura(NodeAvl tmp) {

        if (tmp == null) {
            return -1;
        } else {
            return tmp.alt;
        }
    }

    public int maxi(int val1, int val2) {
        return ((val1 > val2) ? val1 : val2);

    }

    public NodeAvl srl(NodeAvl t1) {
        NodeAvl t2;
        t2 = t1.getRight();
        t1.setRight(t2.getLeft());
        t2.setLeft(t1);
        t1.alt = maxi(altura(t1.getLeft()), altura(t1.getRight())) + 1;
        t2.alt = maxi(altura(t2.getRight()), t1.alt) + 1;

        return t2;

    }

    public NodeAvl drl(NodeAvl tmp) {

        tmp.setLeft(srr(tmp.getLeft()));

        return srl(tmp);
    }

    public NodeAvl drr(NodeAvl tmp) {
        tmp.setRight(srl(tmp.getRight()));
        return srr(tmp);

    }

    public NodeAvl srr(NodeAvl t1) {

        NodeAvl t2;
        t2 = t1.getRight();
        t1.setRight(t2.getLeft());
        t2.setLeft(t1);
        t1.alt = maxi(altura(t1.getLeft()), altura(t1.getRight()) + 1);
        t2.alt = maxi(altura(t2.getRight()), t1.alt) + 1;

        return t2;

    }

    public void preorder(NodeAvl tmp) {
        if (tmp!=null) {
            System.out.println(tmp.getValor());
            preorder(tmp.getLeft());
            preorder(tmp.getRight());
        }

    }



}
