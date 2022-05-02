package main;

class Quarto {
  private Cliente cliente;
  public boolean isReservado = false;

  Quarto() {
    this.isReservado = false;
  }

  public boolean getIsReservado() {
    return this.isReservado;
  }

  public Cliente getCliente() {
    return this.cliente;	
  }

  public void reservar(Cliente cliente) {
    this.cliente = cliente;
    this.isReservado = true;
  }
}