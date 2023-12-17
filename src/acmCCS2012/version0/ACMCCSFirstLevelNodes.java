package acmCCS2012.version0;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Read the acm_ccs2012.xml file and extracts the elements.
 *
 */
public class ACMCCSFirstLevelNodes {
	static String inputFileName  = "C:\\Projetos\\EduKnow\\JenaKSA\\src\\acm_ccs2012_s.xml";
	
	public static void main(String[] args) {
		parser();
	}
	
	public static ArrayList selectRootNodes() {
		boolean ehNivel1 = false;
		ArrayList root = new ArrayList();
		
		try {
			FileReader arq = new FileReader(inputFileName);
			BufferedReader lerArq = new BufferedReader(arq);

			String linha = lerArq.readLine().trim(); 
			while (linha != null) {
				if (linha.contains("<skos:ConceptScheme"))
					ehNivel1 = true;
				else if (linha.contains("ConceptScheme>"))
					ehNivel1 = false;
				else if (ehNivel1)
					if (linha.contains("resource"))
						root.add(getResource(linha));
						//System.out.printf("[1]: (" + getResource(linha) + ")\n");
					//else
						//System.out.printf("[1]: " + linha + "\n");
				else
					System.out.printf(linha + "\n");

				linha = lerArq.readLine(); 
			}
			arq.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n",	e.getMessage());
		}

		return root;
	}

	private static void parser() {
		boolean ehNivel1 = false;

		System.out.printf("\nConte�do do arquivo texto:\n");
		try {
			FileReader arq = new FileReader(inputFileName);
			BufferedReader lerArq = new BufferedReader(arq);

			String linha = lerArq.readLine().trim(); 
			while (linha != null) {
				if (linha.contains("<skos:ConceptScheme"))
					ehNivel1 = true;
				else if (linha.contains("ConceptScheme>"))
					ehNivel1 = false;
				else if (ehNivel1)
					if (linha.contains("resource"))
						System.out.printf("[1]: (" + getResource(linha) + ")\n");
					else
						System.out.printf("[1]: " + linha + "\n");
				else
					System.out.printf(linha + "\n");

				linha = lerArq.readLine(); 
			}
			arq.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n",	e.getMessage());
		}

		System.out.println();
	}
	
	private static String getResource(String s) {
		int inicio, fim;
		String resource;
		inicio = s.indexOf('"');
		fim = s.indexOf('"', inicio+1);
		
		resource = s.substring(inicio+1, fim);
		return resource;
	}
}
