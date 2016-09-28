package Default;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.StringTokenizer;

import javax.print.attribute.standard.Sides;
import javax.swing.SingleSelectionModel;

import data.dao.CoordenadaDAO;
import data.util.Conexao;
import domain.Coordenada;

public class Tester {

	public static void main(String[] args) {
		
		String linha = new String();
		String nomeArquivo = "D:\\teste.txt";

		File arq = new File(nomeArquivo);

		if (arq.exists()) {
			try {
				FileReader leitorDeArquivos = new FileReader(nomeArquivo);
				BufferedReader bufferDeArquivo = new BufferedReader(leitorDeArquivos);

				while (true) {
					
					linha = bufferDeArquivo.readLine();
					if (linha == null) {
						break;
					}
					linha = linha.replaceAll(" ",",");
					String array[] = new String[5];
					array = linha.split(",");
										
					/*for (int i = 0; i < array.length; i++) {
						System.out.println( "Linha "+ i + ":" +array[i]);
					}*/
					Coordenada co1 = new Coordenada();
					co1.setIdArquivo(Integer.parseInt(array[0]));
					co1.setData(array[1]);
					co1.setHora(array[2]);
					co1.setLatitude(Double.parseDouble(array[3]));
					co1.setLongitude(Double.parseDouble(array[4]));
					
					Conexao conexao = new Conexao();
					CoordenadaDAO pdao = new CoordenadaDAO(conexao);
					pdao.save(co1);
					
					co1 = null;
					pdao = null;
					
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		/*
		 * Conexao conexao = new Conexao();
		 * 
		 * Coordenada co = new Coordenada(7,"2008-02-02","15:10:26",116.76038,39.79758);
		 * 
		 * CoordenadaDAO pdao = new CoordenadaDAO(conexao);
		 * pdao.save(co);
		 */

	}

}
