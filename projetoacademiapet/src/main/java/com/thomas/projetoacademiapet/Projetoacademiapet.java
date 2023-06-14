

package com.thomas.projetoacademiapet;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Projetoacademiapet {
    static String secaoTreino = "@#!!?!#@";
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       
       String nova_linha;
       
       File arquivo = new File("academia.txt");
       if (!arquivo.exists()) {
           criarArquivo(arquivo);
       }
       int linhas_no_arquivo = contaLinhas(arquivo);
       
       String[] linhasArquivo = new String[linhas_no_arquivo];
       lerArquivo(arquivo,linhasArquivo);
       
       int opcao;
       
       do {
           menugeral();
           opcao = sc.nextInt();
           if(opcao==1){ //Entrar
               String CPF;
               String senha;
               System.out.print("CPF: ");
               sc.nextLine();
               CPF = sc.nextLine();
               System.out.print("Senha: ");
               senha = sc.nextLine();
               
               int autorizado = verificarLogin(arquivo, CPF, senha);
               
               if (autorizado == 1) { // == Aluno
                   int opaluno;
                   do{
                       menualuno();
                       opaluno = sc.nextInt();  
                       if(opaluno == 1){
                           //lerdo arquivo treinos do aluno certo
                       }else{
                           System.out.println("Opção inválida\n");
                       }
                   }while(opaluno != 2);
               } else if (autorizado == 2) { // == Per
                   int opprof;
                   do{
                       menupersonal();
                       opprof = sc.nextInt();
                       if(opprof == 1){ // Criar treino
                            String id_treino;
                            String nome_treino;
                            String musuculo_focal;
                            String exercicios;
                            String series;
                            String id_personal;
                            System.out.print("Nome treino: ");
                            sc.nextLine();
                            nome_treino = sc.nextLine();
                            System.out.print("ID treino: ");
                            id_treino = sc.nextLine();
                            System.out.print("Musculo focal: ");
                            musuculo_focal = sc.nextLine();
                            System.out.print("Exercicios: ");
                            exercicios = sc.nextLine();
                            System.out.print("Series: ");
                            series = sc.nextLine();
                            id_personal = CPF;
                            
                            nova_linha = secaoTreino + "|" + nome_treino + "|" + id_treino + "|" + musuculo_focal + "|" + exercicios + "|" + series + "|" + id_personal;
                            
                            cadastrarNoArquivo(arquivo, nova_linha);
                           
                       }else if(opprof == 2){ // Passar treino
                           //Listar treinos que ele tem do arquivo
                           String id_treino;
                           String id_aluno;
                           String id_personal;
                           System.out.print("ID treino: ");
                           sc.nextLine();
                           id_treino = sc.nextLine();
                           System.out.print("ID Aluno: ");
                           id_aluno = sc.nextLine();
                           id_personal = CPF;
                           //botar no arquivo do aluno
                       }           
                   }while(opprof != 3);
               }
               
               //Ler arquivp
           } else if(opcao==2){ //Cadastrar
               String nome;
               float salario;
               char tipo;
               int idade;
               String CPF;
               String senha;
               System.out.print("Nome: ");
               sc.nextLine();
               nome = sc.nextLine();
               System.out.print("CPF: ");
               CPF = sc.nextLine();
               System.out.print("Idade: ");
               idade = sc.nextInt();
               System.out.print("Senha: ");
               sc.nextLine();
               senha = sc.nextLine();
               System.out.print("Tipo: ");
               tipo = sc.nextLine().charAt(0);
               tipo = Character.toUpperCase(tipo);
               nova_linha = CPF + ";" + nome + ";" + idade + ";" + senha + ";" + tipo;
               if(tipo == 'P'){ // Personal
                   System.out.print("Salario:");
                   salario = sc.nextFloat();
                   nova_linha += ";" + salario;
                   cadastrarNoArquivo(arquivo, nova_linha);
                   int opprof;
                   do{
                       menupersonal();
                       opprof = sc.nextInt();
                       if(opprof == 1){ // Criar treino
                            String id_treino;
                            String nome_treino;
                            String musuculo_focal;
                            String exercicios;
                            String series;
                            String id_personal;
                            System.out.print("Nome treino: ");
                            sc.nextLine();
                            nome_treino = sc.nextLine();
                            System.out.print("ID treino: ");
                            id_treino = sc.nextLine();
                            System.out.print("Musculo focal: ");
                            musuculo_focal = sc.nextLine();
                            System.out.print("Exercicios: ");
                            exercicios = sc.nextLine();
                            System.out.print("Series: ");
                            series = sc.nextLine();
                            id_personal = CPF;
                            
                            nova_linha = secaoTreino + "|" + nome_treino + "|" + id_treino + "|" + musuculo_focal + "|" + exercicios + "|" + series + "|" + id_personal;
                            
                            cadastrarNoArquivo(arquivo, nova_linha);
                           
                       }else if(opprof == 2){ // Passar treino
                           //Listar treinos que ele tem do arquivo
                           String id_treino;
                           String id_aluno;
                           String id_personal;
                           System.out.print("ID treino: ");
                           sc.nextLine();
                           id_treino = sc.nextLine();
                           System.out.print("ID Aluno: ");
                           id_aluno = sc.nextLine();
                           id_personal = CPF;
                           //botar no arquivo do aluno
                       }
                               
                   }while(opprof != 3);
               }else if(tipo == 'A'){ // Aluno
                   cadastrarNoArquivo(arquivo, nova_linha);
                   int opaluno;
                   do{
                       menualuno();
                       opaluno = sc.nextInt();  
                       if(opaluno == 1){
                           //lerdo arquivo treinos do aluno certo
                       }else{
                           System.out.println("Opção inválida\n");
                       }
                   }while(opaluno != 2);
               } else {
                   System.out.println("Tipo inválido\n");
               }
           }
           
           
       }while(opcao != 3);
      
    }
    public static void menugeral(){
        System.out.printf("""
                           \n1. Entrar\n
                           2. Cadastrar\n
                           3. Fechar
                           """);
    }
    public static void menupersonal() {
        System.out.println("""
                            \n1. Criar Treinos\n
                            2. Passar Treinos\n
                            3. Sair
                            """);
    }
    public static void menualuno(){
        System.out.println("""
                            \n1. Ver treinos\n
                            2. Sair\n
                           """);
    }
    public static int contaLinhas(File arquivo) {
        int cont = 0;
        try {
            FileReader leitura = new FileReader(arquivo);
            BufferedReader buff = new BufferedReader(leitura);

            String linha;

            while((linha = buff.readLine()) != null) {
                cont++;
            }
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
        
        return cont;
    }
    
    public static void criarArquivo(File arquivo) {
        try {
            FileWriter escrita = new FileWriter(arquivo);
            escrita.write("");
            escrita.close();
        } catch( IOException e) {
            System.out.println("Erro ao inicializar arquivo: " + e.getMessage());
        }
    }
    
    public static void lerArquivo(File arquivo,String[] vetor) {
                
        try {
            FileReader leitura = new FileReader(arquivo);
            BufferedReader buff = new BufferedReader(leitura);

            String linha;
            int cont = 0;
            while((linha = buff.readLine()) != null) {
                vetor[cont] = linha;
                cont++;
            }
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void cadastrarNoArquivo(File arquivo, String linha) {
        try {
            FileWriter escrita = new FileWriter(arquivo, true);
            escrita.write(linha + "\n");
            escrita.close();
            System.out.println("Cadastrou");
        }catch(IOException e ) {
            System.out.println(e.getMessage());
        }
    }
    
    public static int verificarLogin(File arquivo, String CPF, String senha) {
        try {
            FileReader leitura = new FileReader(arquivo);
            BufferedReader buff = new BufferedReader(leitura);

            String linha;
            while((linha = buff.readLine()) != null) {
                String[] linhaSp = linha.split(";");
                if (linhaSp[0].equals(secaoTreino)) {
                    continue;
                } else {
                    if (linhaSp[0].equalsIgnoreCase(CPF)) {
                        if (linhaSp[3].equals(senha)) {
                            if (linhaSp[4].equalsIgnoreCase("A")) {
                                return 1;
                            }
                            return 2;
                        } else {
                            System.out.println("Senha incorreta\n");
                        }
                    } else {
                        System.out.println("Pessoa nao cadastrada\n");
                    }
                }
            }
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
        
        return 0;
    }
}
