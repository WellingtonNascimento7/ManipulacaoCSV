import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ManipulacaoCSV {
	String arquivo = "Cliente.csv";

	public void verificaDir() throws IOException {
		String path = new File("").getAbsolutePath() + "\\Arquivos";
		File dir = new File(path);
		if (!dir.exists() && !dir.isDirectory()) {			
			dir.mkdir();
			System.out.println("Diretorio criado");
		}
	}

	public boolean verificaRegistro(int codigo) throws IOException {
		String path = new File("").getAbsolutePath() + "\\Arquivos";
		File arq = new File(path, arquivo);
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) { 
				linha = buffer.readLine();
				if (linha != null) {
					String[] p = linha.split(";");
					if (Integer.parseInt(p[0]) == codigo) {
						buffer.close();
						leitor.close();
						fluxo.close();
						return true;
					}
				}
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		} else {
			throw new IOException("Arquivo Inválido");
		}
		return false;
	}

	public Cliente Pesquisar(int codigo) throws IOException {
		String path = new File("").getAbsolutePath() + "\\Arquivos";
		File dir = new File(path);
		File arq = new File(path, arquivo);
		boolean aux = false;
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) { 
				linha = buffer.readLine();
				if (linha != null) {
					String[] p = linha.split(";");
					if (Integer.parseInt(p[0]) == codigo) {						
						Cliente c1 = new Cliente(Integer.parseInt(p[0]), p[1], p[2], p[3], p[4], p[5], p[6]);
						aux = true;
						return c1;
						
					}
				}
			}
			buffer.close();
			leitor.close();
			fluxo.close();
			if (!aux) {
				System.out.println("Nenhum registro encontrado");
				return null;
			}
		} else {
			throw new IOException("Arquivo Inválido");
		}
		return null;
	}

	public void Cadastrar(Cliente c) throws IOException {
		verificaDir();
		String path = new File("").getAbsolutePath() + "\\Arquivos";
		File dir = new File(path);
		File arq = new File(path, arquivo);
		if (dir.exists() && dir.isDirectory()) {
			boolean existe = false;
			if (arq.exists()) {
				existe = true;
			} else {
				String conteudo = "Codigo;" + "Nome;" + "CPF;" + "DataNascimento;" + "Endereco;" + "Email;"
						+ "Telefone;" + " \r\n";
				FileWriter fileWriter = new FileWriter(arq, existe);
				PrintWriter print = new PrintWriter(fileWriter);
				print.write(conteudo);
				print.flush();
				print.close();
				fileWriter.close();
				existe = true;
			}
			if (verificaRegistro(c.getID())) {
				System.out.println("Já existe um registro com este codigo.");
			} else {
				String conteudo = c.getID() + ";" + c.getNome() + ";" + c.getCPF() + ";" + c.getDnasc() + ";"
						+ c.getEndereco() + ";" + c.getEmail() + ";" + c.getTelefone() + ";\r\n";
				FileWriter fileWriter = new FileWriter(arq, existe);
				PrintWriter print = new PrintWriter(fileWriter);
				print.write(conteudo);
				print.flush();
				print.close();
				fileWriter.close();
			}

		} else {
			throw new IOException("Diretorio inválido");
		}
	}

	public static void main(String[] args) throws IOException {
		Cliente c1 = new Cliente(1, "Jose Silva", "202.654.321.12", "10/10/1989", "Av alcantara, 666", "jose@silva.com",
				"(11)91259-5776");
		Cliente c2 = new Cliente(2, "Marcos Oliveira", "202.654.321.12", "10/10/1989", "Av tanto faz, 40",
				"marcos@oliv.com", "(11)95726-7895");
		Cliente c3 = new Cliente(3, "Josefina Rodrigues", "202.654.321.12", "10/10/1989", "Av qualquer, 654",
				"josefina@rodri.com", "(11)97070-7070");
		Cliente c4 = new Cliente(4, "Natalia souza", "202.654.321.12", "10/10/1989", "Rua 15 de novembro, 56",
				"natalia@silva.com", "(11)92411-6696");
		Cliente c5 = new Cliente(5, "Fulano de Tal", "202.654.321.12", "10/10/1989", "Av 25 de março, 1000",
				"Fulano@tal.com", "(11)94002-8922");
		
		ManipulacaoCSV m = new ManipulacaoCSV();
		
		
	}
}
