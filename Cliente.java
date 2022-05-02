package main;

class Cliente {
  private String nome;
  private String email;

  Cliente(String nome, String email) {
    this.nome = nome;
    this.email = email;
  }

  public void setNome(String nome) {
    this.nome = nome;  
  }
  
  public String getNome() {
    return this.nome;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEmail() {
    return this.email;
  }
}