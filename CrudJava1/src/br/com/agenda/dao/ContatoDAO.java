package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.modelo.Contato;

public class ContatoDAO {
	
	public  void save( Contato contato) {
		
		String  sql= "INSERT INTO contato( nome , idade , datacadastro)value (?,?,?);";
		Connection conn =null;
		PreparedStatement pstm= null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new Date(contato.getDataCadastrao().getTime()));
		
		
		pstm.execute();
		System.out.println("Salvo com Suçesso");
		
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}}catch( Exception e ) {
					e.printStackTrace();
				}
			}
		}
			
	public List<Contato> getContatos(){
		String sql="SELECT * FROM contato;";
		
		List<Contato> contatos = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstm= null;	
		ResultSet rset= null;
		
		try {
			conn =ConnectionFactory.createConnectionToMySQL();
			pstm=conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				Contato contato= new Contato();
				contato.setId(rset.getInt("id"));
				contato.setNome(rset.getString("nome"));
				contato.setIdade(rset.getInt("idade"));
				contato.setDataCadastrao(rset.getDate("datacadastro"));
				 contatos.add(contato);
				 }
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(pstm!=null) {
						pstm.close();
					}
					if(conn != null) {
						conn.close();
					}}catch( Exception e ) {
						e.printStackTrace();
					}
				
			}
			return contatos;
			
			
		}
	
	public void update(Contato contato) {
		String sql  ="UPDATE contato  set nome = ? , idade= ? , datacadastro= ? WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm=null;
		
		try {
			
			conn =ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1,contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new Date(contato.getDataCadastrao().getTime()));
			pstm.setInt(4,contato.getId());
			
			pstm.execute();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}}catch( Exception e ) {
					e.printStackTrace();
				}
			
		}
		
	}
	
	
	public void deleteByID( int id ) {
		String  sql = " DELETE FROM contato WHERE id = ?";
		Connection conn = null;
		PreparedStatement  pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			pstm.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}}catch( Exception e ) {
					e.printStackTrace();
				}
			
		}
		
	}
	
	
	}

	
	
