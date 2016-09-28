package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import data.util.Conexao;
import domain.Coordenada;
import domain.Persistible;

public class CoordenadaDAO  implements Persistible<Coordenada>{

		private Connection connection;
		private Conexao conexao;

		public CoordenadaDAO(Conexao conexao) {
			this.conexao = conexao;
			connection = conexao.abrir();
		}
		
		
		@Override
		public void save(Coordenada coordenada) {
			// introdução sql
			String sql = "insert into trajeto (idarquivo,data , hora, latitude, longitude)"
					+ "values(?,?,?,?,?)";
			PreparedStatement pstmt;
			try {
				pstmt = connection.prepareStatement(sql);

				// setar os parametros
				pstmt.setInt(1, coordenada.getIdArquivo());
				pstmt.setString(2, coordenada.getData());
				pstmt.setString(3, coordenada.getHora());
				pstmt.setDouble(4, coordenada.getLatitude());
				pstmt.setDouble(5, coordenada.getLongitude());
				pstmt.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				conexao.fechar();

			}
		}

		@Override
		public Coordenada getOne (long id) {
			Coordenada p = null;
			Statement pstmt;
			try {
				pstmt = (Statement) connection.createStatement();
				ResultSet elements = pstmt.executeQuery("Select * from livro" + " where id = " + id);

				while (elements.next()) {
					p = new Coordenada(elements.getInt("idArquivo"), elements.getString("date"),
							elements.getString("hora"),elements.getDouble("latitude"),elements.getDouble("longitude"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				conexao.fechar();
			}
			return p;

		}

		@Override
		public List<Coordenada> getAll() {
			List<Coordenada> result = new ArrayList<Coordenada>();
			java.sql.Statement sta;
			try {
				sta = connection.createStatement();
				ResultSet elements = sta.executeQuery("Select * from pessoa");

				// enquanto existirem registros no recordset
				while (elements.next()) {
					Coordenada l = new Coordenada();
					l.setIdArquivo(elements.getInt("nome"));
					l.setData(elements.getString("data"));
					l.setHora(elements.getString("hora"));
					l.setLatitude(elements.getDouble("latitude"));
					l.setLongitude(elements.getDouble("longitude"));
					

					// adiciona o objeto ao veto
					result.add(l);
				}
			} catch (SQLException e) {

				e.printStackTrace();
			} finally {
				conexao.fechar();
			}
			return result;

		}

		@Override
		public void delete(Coordenada coordenada) {
			String sql = "delete from livro where id = ?";
			PreparedStatement pstmt;

			try {
				pstmt = connection.prepareStatement(sql);
				pstmt.setInt(1, coordenada.getIdArquivo());
				pstmt.execute();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				conexao.fechar();
			}

		}

		@Override
		public void update(Coordenada coordenada) {
			try {
				String sql = "update pessoa set nome = ?, sobrenome = ?, where id = ?";
				PreparedStatement pstmt = connection.prepareStatement(sql);
				// setar os parametros
				pstmt.setInt(1, coordenada.getIdArquivo());
				pstmt.setString(2, coordenada.getData());
				pstmt.setString(3, coordenada.getHora());
				pstmt.setDouble(4, coordenada.getLatitude());
				pstmt.setDouble(4, coordenada.getLongitude());
				pstmt.execute();
			} catch (SQLException ex) {
				ex.printStackTrace();

			}
		}

}
