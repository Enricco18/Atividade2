package com.company;

import java.util.ArrayList;
import java.util.List;

public abstract class Lista implements Functions {
    protected int limite;
    protected List<Produto> s = new ArrayList();

    public Lista(int limite) {
        this.limite = limite;
    }

    public boolean adicionarALista(Produto p) {
        if (s.size() <= limite) {
            s.add(p);
            return true;
        } else
            return false;
    }

    public boolean removerUltimoDaLista() {
        if (s.isEmpty())
            return false;
        else {
            s.remove((s.size()-1));
            return true;
        }
    }

    public void limparLista(){
        s.clear();
        }

    public int getRestantes(){
        int temp = limite - s.size();
        return temp;
    }

    public String retornarResumo() {
        String temp = "";
        for (Produto p : s) {
            temp = p.exibirResumo() + "\n" + temp;
        }
        return temp;
    }
    }

