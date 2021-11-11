package apresentacao;

import java.util.Scanner;

import dao.UsuarioDAO;
import model.Usuario;

public class Principal {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		int opcao;
		System.out.print("O que voc� deseja fazer?");
		System.out.println("\n 1 - incluir novo usu�rio"+
						   "\n 2 - consultar usu�rio existente"+
						   "\n 3 - alterar os dados de um usu�rio"+
						   "\n 4 - deletar o cadastro de um usu�rio");
		opcao = input.nextInt();
		
		switch (opcao) {
		case 1: {
			UsuarioDAO usuarioDao = new UsuarioDAO();
			
			Usuario usuario = new Usuario();
			System.out.print("Insira o nome do novo usu�rio: ");
			usuario.setNome(input.next());
			System.out.print("Insira o email do novo usu�rio: ");
			usuario.setEmail(input.next());
			System.out.print("Insira o sexo do novo usu�rio: ");
			usuario.setSexo(input.next());
			System.out.print("Insira a data de nascimento do novo usu�rio: ");
			usuario.setDt_nascimento(input.next());
			System.out.print("Insira o CEP do novo usu�rio: ");
			usuario.setCep(input.next());
			System.out.print("Insira a cidade do novo usu�rio: ");
			usuario.setCidade(input.next());
			System.out.print("Insira a UF do novo usu�rio: ");
			usuario.setUf(input.next());
			System.out.print("Insira o logradouro do novo usu�rio: ");
			usuario.setLogradouro(input.next());
			
			usuarioDao.incluir(usuario);
			
			break;
		}
		
		case 2: {
			System.out.println("digite o id do usuario");
			String id = input.next();
			
			UsuarioDAO usuarioDao = new UsuarioDAO();
			for(Usuario u : usuarioDao.getUsuarios()) {
				System.out.println("ID: " + u.getId());
				System.out.println("Usuario: " + u.getNome());
				System.out.println("E-mail: " + u.getEmail());
				System.out.println("Sexo: " + u.getSexo());
				System.out.println("Data de nascimento: " + u.getDt_nascimento());
				System.out.println("CEP: " + u.getCep());
				System.out.println("Cidade: " + u.getCidade());
				System.out.println("UF: " + u.getUf());
				System.out.println("Logradouro: " + u.getLogradouro());
				System.out.println("----------------------------------------------");
			}

			break;
		}
			
		case 3: {
			UsuarioDAO usuarioDao = new UsuarioDAO();
			//System.out.print("Insira o id do usu�rio que ser� alterado : ");
			//int id = input.nextInt();
			
			for(Usuario u : usuarioDao.getUsuarios()) {
				System.out.println("ID: " + u.getId());
				System.out.println("Usuario: " + u.getNome());
				System.out.println("E-mail: " + u.getEmail());
				System.out.println("Sexo: " + u.getSexo());
				System.out.println("Data de nascimento: " + u.getDt_nascimento());
				System.out.println("CEP: " + u.getCep());
				System.out.println("Cidade: " + u.getCidade());
				System.out.println("UF: " + u.getUf());
				System.out.println("Logradouro: " + u.getLogradouro());
				System.out.println("----------------------------------------------");
				
				//usuarioDao.mostrarDados(id);
			}
			
			Usuario u1 = new Usuario();
			System.out.print("Insira o novo nome: ");
			u1.setNome(input.next());
			System.out.print("Insira o novo email: ");
			u1.setEmail(input.next());
			System.out.print("Insira o novo sexo: ");
			u1.setSexo(input.next());
			System.out.print("Insira o novo nascimento: ");
			u1.setDt_nascimento(input.next());
			System.out.print("Insira o novo cidade: ");
			u1.setCidade(input.next());
			System.out.print("Insira o novo uf: ");
			u1.setUf(input.next());
			System.out.print("Insira o novo cep: ");
			u1.setCep(input.next());
			System.out.print("Insira o novo logr: ");
			u1.setLogradouro(input.next());
			
			usuarioDao.update(u1);
			
			break;
		}
		
		case 4: {
			UsuarioDAO usuarioDao = new UsuarioDAO();
			System.out.println("Insira o id do usuario que sera excluido");
			int id = input.nextInt();
			usuarioDao.deleteById(id);
		}
	  }
	}
}
