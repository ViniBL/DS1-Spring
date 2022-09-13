package br.ufscar.dc.dsw;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.ufscar.dc.dsw.dao.IEditoraDAO;
import br.ufscar.dc.dsw.dao.IPacoteDAO;
import br.ufscar.dc.dsw.dao.IUsuarioDAO;
import br.ufscar.dc.dsw.domain.Editora;
import br.ufscar.dc.dsw.domain.Pacote;
import br.ufscar.dc.dsw.domain.Usuario;

@SpringBootApplication
public class LivrariaMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(LivrariaMvcApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(IUsuarioDAO usuarioDAO, BCryptPasswordEncoder encoder, IEditoraDAO editoraDAO, IPacoteDAO pacoteDAO) {
		return (args) -> {
			
			Usuario u1 = new Usuario();
			u1.setUsername("admin");
			u1.setPassword(encoder.encode("admin"));
			u1.setCPF("012.345.678-90");
			u1.setName("Administrador");
			u1.setRole("ROLE_ADMIN");
			u1.setEnabled(true);
			usuarioDAO.save(u1);
			
			Usuario u2 = new Usuario();
			u2.setUsername("beltrano");
			u2.setPassword(encoder.encode("123"));
			u2.setCPF("985.849.614-10");
			u2.setName("Beltrano Andrade");
			u2.setRole("ROLE_USER");
			u2.setEnabled(true);
			usuarioDAO.save(u2);
			
			Usuario u3 = new Usuario();
			u3.setUsername("fulano");
			u3.setPassword(encoder.encode("123"));
			u3.setCPF("367.318.380-04");
			u3.setName("Fulano Silva");
			u3.setRole("ROLE_USER");
			u3.setEnabled(true);
			usuarioDAO.save(u3);
			
			Editora e1 = new Editora();
			e1.setCNPJ("56.789.390/0008-99");
			e1.setNome("Companhia das Letras");
			editoraDAO.save(e1);
			
			Editora e2 = new Editora();
			e2.setCNPJ("71.150.470/0001-40");
			e2.setNome("Record");
			editoraDAO.save(e2);
			
			Editora e3 = new Editora();
			e3.setCNPJ("32.106.536/0001-82");
			e3.setNome("Objetiva");
			editoraDAO.save(e3);
			
			Pacote l1 = new Pacote();
			l1.setDescricao("Ensaio sobre a Cegueira");
			l1.setDuracao(19);
			l1.setValor(BigDecimal.valueOf(420.69));
			l1.setEditora(e1);
			l1.setCidade("Sumaré");
			l1.setEstado("SP");
			l1.setPais("não posso falar");
			l1.setData_partida("19/09/2022");
			pacoteDAO.save(l1);
			
			Pacote l2 = new Pacote();
			l2.setDescricao("Aprenda a bolar com o Vini");
			l2.setDuracao(19);
			l2.setValor(BigDecimal.valueOf(420.69));
			l2.setEditora(e1);
			l2.setCidade("Sumaré");
			l2.setEstado("SP");
			l2.setPais("não posso falar");
			l2.setData_partida("19/09/2022");
			pacoteDAO.save(l2);

			Pacote l3 = new Pacote();
			l3.setDescricao("Ensaio sobre o Vini");
			l3.setDuracao(19);
			l3.setValor(BigDecimal.valueOf(420.69));
			l3.setEditora(e2);
			l3.setCidade("Sumaré");
			l3.setEstado("SP");
			l3.setPais("não posso falar");
			l3.setData_partida("19/09/2022");
			pacoteDAO.save(l3);
		};
	}
}
