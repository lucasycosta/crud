package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import model.Usuario;

public class UsuarioDAO {
	
	/*
	 * CRUD
	 * C: CREATE (criar/inclui)
	 * R: READ (ler/consultar)
	 * U: UPDATE (atualizar)
	 * D: DELETE (deletar)
	 */
	
	//MÉTODO DE INSERT
	public void incluir (Usuario usuario) {
		String sql = "INSERT INTO Usuario(nome, email, sexo, dt_nascimento, cidade, uf, cep, logradouro)" +
				     "VALUES(?,?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = Conexao.createConnectionToPostgres();	
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, usuario.getNome());
			pstm.setString(2, usuario.getEmail());
			pstm.setString(3, usuario.getSexo());
			pstm.setString(4, usuario.getDt_nascimento());
			pstm.setString(5, usuario.getCidade());
			pstm.setString(6, usuario.getCep());
			pstm.setString(7, usuario.getUf());
			pstm.setString(8, usuario.getLogradouro());
			pstm.execute();
			System.out.println("Usuário salvo com sucesso!!!");
			
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//MÉTODO DE CONSULTA
	public List<Usuario> getUsuarios(){
		String sql = "SELECT * FROM Usuario" ;
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = Conexao.createConnectionToPostgres();
			pstm = conn.prepareStatement(sql);
			ResultSet rset = pstm.executeQuery();
		
			while(rset.next()) {
				Usuario usuario = new Usuario();
				
				usuario.setId(rset.getInt("id"));
				usuario.setNome(rset.getString("nome"));
				usuario.setEmail(rset.getString("email"));
				usuario.setSexo(rset.getString("sexo"));
				usuario.setDt_nascimento(rset.getString("dt_nascimento"));
				usuario.setCidade(rset.getString("cidade"));
				usuario.setCep(rset.getString("cep"));
				usuario.setUf(rset.getString("uf"));
				usuario.setLogradouro(rset.getString("logradouro"));
								
				usuarios.add(usuario);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return usuarios;		
	}

	//MÉTODO UPDATE
	public void update (Usuario usuario) {
		String sql = 
	"UPDATE Usuario SET nome = ?, email = ?, sexo = ?, dt_nascimento = ?, cidade = ?, uf = ?, cep = ?, logradouro = ? WHERE id = ?" ;
		
		Connection conn;
		PreparedStatement pstm;
		
		try {
			conn = Conexao.createConnectionToPostgres();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, usuario.getNome());
			pstm.setString(2, usuario.getEmail());
			pstm.setString(3, usuario.getSexo());
			pstm.setString(4, usuario.getDt_nascimento());
			pstm.setString(5, usuario.getCidade());
			pstm.setString(6, usuario.getCep());
			pstm.setString(7, usuario.getUf());
			pstm.setString(8, usuario.getLogradouro());
			pstm.setInt(9, usuario.getId());
			pstm.execute();
			System.out.println("Usuário atualizado com sucesso!!!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//MÉTODO DELETE
	public void deleteById(int id) {
		String sql = "DELETE FROM Usuario WHERE id = " + id;
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = Conexao.createConnectionToPostgres();
			pstm = conn.prepareStatement(sql);
			pstm.execute();
			System.out.println("Usuário deletado com sucesso!!!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public void mostrarDados(int id) {
		String sql = "SELECT * FROM Usuario WHERE id = " + id;
		
		Connection conn = null;
		PreparedStatement pstm = null;	
		
		try {
			conn = Conexao.createConnectionToPostgres();
			pstm = conn.prepareStatement(sql);
			ResultSet rset = pstm.executeQuery();
			
			while(rset.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rset.getInt("id"));
				usuario.setNome(rset.getString("nome"));
				usuario.setEmail(rset.getString("email"));
				usuario.setSexo(rset.getString("sexo"));
				usuario.setDt_nascimento(rset.getString("dt_nascimento"));
				usuario.setCidade(rset.getString("cidade"));
				usuario.setCep(rset.getString("cep"));
				usuario.setUf(rset.getString("uf"));
				usuario.setLogradouro(rset.getString("logradouro"));    
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
