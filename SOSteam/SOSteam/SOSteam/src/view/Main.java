package view;

import java.io.IOException;

import controller.SteamController;

public class Main {

	public static void main(String[] args)
	{
		SteamController controll = new SteamController();
		
		try {
			controll.chamaInfo("C:\\Users\\Downloads\\Exercicio_Arquivos_Steam" , 
								"SteamCharts.csv", 
								"2021", 
								"February", 
								25000);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			controll.criarArquivo("C:\\Users\\dti\\Downloads\\Exercicio_Arquivos_Steam", "SteamCharts.csv", "2021", "February");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
