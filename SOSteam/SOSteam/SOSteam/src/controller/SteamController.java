package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SteamController {

	public SteamController() 
	{
		super();
	}
	
	public void chamaInfo(String path, String arquivo, String ano, String mes, double valor) throws IOException
	{
				
		File arq = new File(path, arquivo);
		
		if(arq.exists() && arq.isFile())
		{
		
			FileInputStream abreFlux = new FileInputStream(arq);
			InputStreamReader lerFlux = new InputStreamReader(abreFlux);
			BufferedReader buffer = new BufferedReader(lerFlux);
			String linha = buffer.readLine();
			
			while(linha != null)
			{
				String[] vet = linha.split(",");
				
				if(vet[1].contains(ano) && vet[2].contains(mes) && Double.parseDouble(vet[3]) >= valor)
				{
					
					System.out.println(vet[0] + espaco(vet[0].length()) + vet[3] + espaco(vet[4].length()));
				}
				
				linha = buffer.readLine();
			}
			
			buffer.close();
			lerFlux.close();
			abreFlux.close();
		}
		else
		{
			throw new IOException("O arquivo nao existe!");
		}
	}
	
	public void criarArquivo(String path, String arquivo, String ano, String mes) throws IOException
	{
		
		File dir = new File(path);
		boolean existe = false;
		if(dir.exists() && dir.isDirectory())
		{
			
			File arq = new File(path, arquivo);
			File arqGera = new File(path, "Steam.csv");
			if(arqGera.exists())
			{
				existe = true;
			}
			
			FileInputStream abreFlux = new FileInputStream(arq);
			InputStreamReader lerFlux = new InputStreamReader(abreFlux);
			BufferedReader buffer = new BufferedReader(lerFlux);
			String linha = buffer.readLine();
			
			FileWriter abreArq = new FileWriter(arqGera, existe);
			PrintWriter escreveArq = new PrintWriter(abreArq);
			
			
			String conteudo;
			
			while(linha != null)
			{
				String[] vet = linha.split(",");
				
				if(vet[1].contains(ano) && vet[2].contains(mes))
				{
					conteudo = vet[0] + ";" + vet[3] + "\n";
					escreveArq.write(conteudo);
					escreveArq.flush();
				}
				
				linha = buffer.readLine();
			}
			buffer.close();
			lerFlux.close();
			abreFlux.close();
			
			escreveArq.close();
			abreArq.close();
			
		}
		
		
		
	}
	
	private String espaco(int i)
	{
		StringBuffer buffer = new StringBuffer();
		if(i == 80)
		{
			return buffer.append(" ").toString();
		}
		else
		{
			buffer.append(" ");
			buffer.append(espaco(i+1));
			return buffer.toString();
		}
	}
}
