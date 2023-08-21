package br.com.agenda.aplicacao;

import java.util.Date;
import java.util.Scanner;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.modelo.Contato;

public class Main {

	public static void main(String[] args) {
		 boolean repeticao= true;
		ContatoDAO conataoDAO=new ContatoDAO();
		
		Scanner scan = new Scanner(System.in);
        int opcao=100;
        
        do {
        	System.out.println("Escolha  a  opcao  ou digite 0 para sair ");
        	System.out.println(" 1 - Cadastrar  novo  contato ");
        	System.out.println(" 2 -  Exibe Lista de Contatos ");
        	System.out.println(" 3 - Alterar Contato ");
        	System.out.println( "4 - Excluir Contaro ");
        	System.out.print( " Opcao e : ");
        	opcao=scan.nextInt();
        	
        	
        	switch (opcao) {
			case 1 :  {
				
				System.out.println("\n\n");
				Scanner input = new Scanner(System.in);
				Contato contato = new Contato();
				System.out.println("Novo Contato ");
				System.out.print("Nome :");
				contato.setNome(input.nextLine());
				System.out.print("Idade :");
				contato.setIdade(input.nextInt());
				contato.setDataCadastrao(new Date());
				conataoDAO.save(contato);
				
				System.out.println("Cadastrado ");
				
				break;
				
				
				
			}
			case 2 :  {

				System.out.println("\n\n");

				System.out.println(" Lista Contatos  ");	
				
				
				for( Contato a : conataoDAO.getContatos() ) {
					System.out.println("Id : "+ a.getId()+ " Nome : " +a.getNome()+" Idade :  " +a.getIdade() +" Data Criacao: "+a.getDataCadastrao()+"");
				}
				System.out.println("\n\n");
				break;

				
				
			}
			case 3 :  {

				System.out.println("\n\n");

				Scanner input = new Scanner(System.in);
				Scanner nome = new Scanner(System.in);
				Scanner idade = new Scanner(System.in);
				Contato contato = new Contato();
				
				System.out.println("Editar  Contato ");
				
				System.out.print(" ID Contato : ");
				contato.setId(input.nextInt());
				
				System.out.println("Nome :");
				contato.setNome(nome.nextLine());
				System.out.println("Idade :");
				contato.setIdade(idade.nextInt());
				contato.setDataCadastrao(new Date());
				conataoDAO.update(contato);
				
				System.out.println("Cadastrado ");
				
				break;
			}
			case 4 :  {
				System.out.println("\n\n");

				Scanner input = new Scanner(System.in);
				
				System.out.println("Deletar Contato ");
				System.out.print(conataoDAO.getContatos());
				System.out.println("\nDigite id: ");
				conataoDAO.deleteByID(input.nextInt());

				break;
				
			}
			case 0:  {
				
				repeticao = false;
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + opcao);
				
			}
        	
        }while(repeticao);
		
		
	
		
	}
	
	
	
}
