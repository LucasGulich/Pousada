package main;

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    try (Scanner keyboard = new Scanner(System.in)) {
		Quarto[] quartos = new Quarto[10];
		Cliente[] clientes = new Cliente[1000];

		criarQuartos(quartos);

		int numeroDeClientes = 0;
		System.out.println("Use o comando de acordo com o que desejar:\n-relatorio\n-reservar\n-clientes\n\n");
		while(true) {
		  String command = keyboard.nextLine();
		  switch(command) {
		    case "-relatorio":
		      getRelatorio(quartos);
		      break;
		    case "-reservar":
		      System.out.println("Qual quarto que deseja reservar? Opções de 0 à 9");
		      int nQuarto = keyboard.nextInt();
		      Quarto quarto = quartos[nQuarto];
		      
		      if(quarto.getIsReservado()) {
		        System.out.println("Quarto já reservado");
		        break;
		      }
		      
		      System.out.println("Digite seu nome:");
		      String nome = keyboard.next();
		      
		      System.out.println("Digite seu email");
		      String email = keyboard.next();
		      
		      Cliente cliente = new Cliente(nome, email);
		      clientes[numeroDeClientes] = cliente;
		      numeroDeClientes ++;
		      
		      quarto.reservar(cliente);
		      System.out.println("Reservado realizado com sucesso para: " + cliente.getNome());
		      break;
		    case "-clientes":
		      mostrarClientes(clientes, numeroDeClientes);
		      break;
		  }
		}
	}
  }

  private static void criarQuartos(Quarto[] quartos) {
    for(int i=0; i<quartos.length; i++) {
      quartos[i] = new Quarto();
    }
  }
  
  private static void getRelatorio(Quarto[] quartos) {
    for(int i=0; i<quartos.length; i++) {
      boolean reservado = quartos[i].getIsReservado();
      if(reservado) {
        Cliente cliente = quartos[i].getCliente();
        System.out.println("O quarto " + i + " está reservado para " + cliente.getNome());
      }
      else System.out.println("O quarto " + i + " não reservado.");
    }
  }

  private static void mostrarClientes(Cliente[] clientes, int totalDeClientes) {
    for(int i=0; i<totalDeClientes; i++) {
      System.out.println("Cliente " + i + " / Nome:" + clientes[i].getNome() + " / Email:" + clientes[i].getEmail());
    }
  }
}