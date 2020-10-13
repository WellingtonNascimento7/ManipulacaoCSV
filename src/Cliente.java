
public class Cliente {
		private int ID;
		private String nome;
		private String CPF;
		private String Dnasc;
		private String endereco;
		private String email;
		private String telefone;

		public Cliente(int ID, String nome, String CPF, String Dnasc, String endereco, String email, String telefone) {
			this.ID = ID;
			this.nome = nome;
			this.CPF = CPF;
			this.Dnasc = Dnasc;
			this.endereco = endereco;
			this.email = email;
			this.telefone = telefone;
		}	
		public Cliente () {
			
		}

		public int getID() {
			return ID;
		}

		public void setID(int iD) {
			ID = iD;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}
		
		public String getCPF() {
			return CPF;
		}
		public void setCPF(String cPF) {
			CPF = cPF;
		}

		public String getDnasc() {
			return Dnasc;
		}

		public void setDnasc(String dnasc) {
			Dnasc = dnasc;
		}

		public String getEndereco() {
			return endereco;
		}

		public void setEndereço(String endereco) {
			this.endereco = endereco;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getTelefone() {
			return telefone;
		}

		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}
		
		public void Imprimir() {
			System.out.println("Codigo: " + ID +" Nome: " + nome + " CPF: " + CPF + " DataNascimento: " + Dnasc
					+ " Endereco: " + endereco + " Email: " + email + " Telefone: " + telefone);
		}
}
