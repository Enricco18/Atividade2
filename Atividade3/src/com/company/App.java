package com.company;

import dao.SingletonProdutoDAO;
import dao.SingletonUsuarioDAO;
import dao.SingletonVendaDAO;
import model.Produto;
import model.Usuario;
import model.Venda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private Scanner scan;
    private  String nome, senha;
    private Usuario logado;
    private List<Produto> produtoList;
    private  List<Usuario> usuarioList;
    private  List<Venda> vendaList;

    public App(){
        scan = new Scanner(System.in);
        produtoList = new ArrayList<>();
        usuarioList = new ArrayList<>();
        vendaList = new ArrayList<>();
    }

    public Usuario logar(String nome, String senha){
        Usuario user = SingletonUsuarioDAO.getInstance().getUser(nome, senha);
        return user;
    }

    public void mainLoop(){
        do{
        System.out.println("Digite usuário: ");
        nome = scan.next();
        System.out.println("Digite senha: ");
        senha = scan.next();
        logado = logar(nome,senha);
        }while (logado==null);

        int op;
        while(true){
            menu();
            op = scan.nextInt();
            if(op == 0)
                break;
            else
                avaliarOp(op);
        }

    }

    private void avaliarOp(int op){
        String busca;
        Produto produto = new Produto();
        Usuario user =new Usuario();
        Venda venda = new Venda();
        switch (op){
            //Buscar todos
            case 1:
                System.out.println("Informe usuário: ");
                user.nome = scan.next();
                System.out.println("Digite senha: ");
                user.senha = scan.next();
                if(logado.nome.equals("admin")) {
                    SingletonUsuarioDAO.getInstance().insereUsuario(user);
                    System.out.println("Adicionado Tio!");
                }else{
                    System.out.println("Você precisa ser adm pra adicionar!");
                }
//                    System.out.println("Você precisa ser adm pra adicionar!");
                break;
            case 2:
                System.out.println("Informe nome: ");
                produto.nome = scan.next();
                System.out.println("Informe preço unitário: ");
                produto.preco = scan.nextFloat();
                System.out.println("Informe quantidade: ");
                produto.quantidade = scan.nextInt();
                System.out.println("Informe fabricante: ");
                produto.fabricante = scan.next();
                System.out.println("Informe categoria: ");
                produto.categoria = scan.next();

                SingletonProdutoDAO.getInstance().inserirProduto(produto);

                break;
            case 3:
                produtoList = SingletonProdutoDAO.getInstance().getAllProdutos();
                exibirProdutos();
                break;

            case 4:
                System.out.println("Informe categoria:");
                busca = scan.next();
                produtoList= SingletonProdutoDAO.getInstance().getAllProdutosByType(busca);
                exibirProdutos();
                break;

            case 5:
                System.out.println("Informe ID do produto:");
                produto.id = scan.nextInt();
                System.out.println("Quantidade pedida:");
                int quantidade = scan.nextInt();
                produto = SingletonProdutoDAO.getInstance().getProdutoById(produto.id);
                if(produto.quantidade<quantidade){
                    System.out.println("Não temos nessa quantidade.Temos em estoque:"+produto.quantidade);
                }else{
                    produto.quantidade -= quantidade;
                    SingletonProdutoDAO.getInstance().updateProdutoQuantidade(produto);
                    venda.userId = logado.id;
                    venda.nomeProd = produto.nome;
                    venda.quantidade = quantidade;
                    SingletonVendaDAO.getInstance().insertVenda(venda);
                    System.out.println("Vendido!");
                }
                break;
            case 6:
                vendaList = SingletonVendaDAO.getInstance().getAllVendas();
                exibirVendas();
                break;
            case 7:
                usuarioList = SingletonUsuarioDAO.getInstance().getAllUsuarios();
                exibirUsuarios();
                break;
                }
        }

    private void menu() {
        System.out.println("1 - Inserir Usuario");
        System.out.println("2 - Inserir Produto");
        System.out.println("3 - Buscar produtos");
        System.out.println("4 - Buscar por categoria");
        System.out.println("5 - Vender");
        System.out.println("6 - Histórico de Vendas");
        System.out.println("7 - Ver usuários");
        System.out.println("0 - Sair");
    }
    private void exibirProdutos() {
        for (Produto produto : produtoList) {
            System.out.println(produto);
        }
    }
    private void exibirVendas() {
        for (Venda venda : vendaList) {
            System.out.println(venda);
        }
    }
    private void exibirUsuarios() {
        for (Usuario user : usuarioList) {
            System.out.println(user);
        }
    }
}

