package br.ufscar.dc.dsw;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.ufscar.dc.dsw.dao.IAgenciaDAO;
import br.ufscar.dc.dsw.dao.IPacoteDAO;
import br.ufscar.dc.dsw.dao.IUsuarioDAO;
import br.ufscar.dc.dsw.domain.Agencia;
import br.ufscar.dc.dsw.domain.Pacote;
import br.ufscar.dc.dsw.domain.Usuario;

@SpringBootApplication
public class LivrariaMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(LivrariaMvcApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(IUsuarioDAO usuarioDAO, BCryptPasswordEncoder encoder, IAgenciaDAO agenciaDAO, IPacoteDAO pacoteDAO) {
		return (args) -> {

			Usuario u1 = new Usuario();
			u1.setUsername("admin");
			u1.setPassword(encoder.encode("admin"));
			u1.setName("Administrador");
			u1.setRole("ROLE_ADMIN");
			u1.setEnabled(true);
			u1.setCPF("012.345.678-90");
			u1.setTelefone("31-99999-9999");
			u1.setSexo("F");
			u1.setDataNascimento("01-01-1999");
			usuarioDAO.save(u1);
			
			Usuario u2 = new Usuario();
			u2.setUsername("user");
			u2.setPassword(encoder.encode("user"));
			u2.setName("Beltrano Silva");
			u2.setRole("ROLE_USER");
			u2.setEnabled(true);
			u2.setCPF("985.849.614-10");
			u2.setTelefone("31-99999-9988");
			u2.setSexo("M");
			u2.setDataNascimento("01-01-2000");
			usuarioDAO.save(u2);
			

			Usuario u3 = new Usuario();
			u3.setUsername("user2");
			u3.setPassword(encoder.encode("user2"));
			u3.setName("Xulambis Costa");
			u3.setRole("ROLE_USER");
			u3.setEnabled(true);
			u3.setCPF("367.318.380-04");
			u3.setTelefone("31-99999-9977");
			u3.setSexo("N");
			u3.setDataNascimento("01-01-2001");
			usuarioDAO.save(u3);
			

			Agencia e1 = new Agencia();
			e1.setUsername("agencia1");
			e1.setPassword(encoder.encode("agencia1"));
			e1.setName("Companhia Aéria");
			e1.setRole("ROLE_AGENCIA");
			e1.setEnabled(true);
			e1.setCNPJ("55.789.390/0008-99");
			e1.setDescricao("Viagens de avião");
			agenciaDAO.save(e1);
			

			Agencia e2 = new Agencia();
			e2.setUsername("agencia2");
			e2.setPassword(encoder.encode("agencia2"));
			e2.setName("Companhia Ferroviária");
			e2.setRole("ROLE_AGENCIA");
			e2.setEnabled(true);
			e2.setCNPJ("71.150.470/0001-40");
			e2.setDescricao("Viagens de trem");
			agenciaDAO.save(e2);
			

			Agencia e3 = new Agencia();
			e3.setUsername("agencia3");
			e3.setPassword(encoder.encode("agencia3"));
			e3.setName("Companhia Marítima");
			e3.setRole("ROLE_AGENCIA");
			e3.setEnabled(true);
			e3.setCNPJ("32.106.536/0001-82");
			e3.setDescricao("Viagens de canoa");
			agenciaDAO.save(e3);
			
			Pacote l1 = new Pacote();
			l1.setTitulo("Ensaio sobre a Cegueira");
			l1.setAutor("José Saramago");
			l1.setAno(1995);
			l1.setPreco(BigDecimal.valueOf(54.9));
			l1.setAgencia(e1);
			pacoteDAO.save(l1);
			
			Pacote l2 = new Pacote();
			l2.setTitulo("Cem anos de Solidão");
			l2.setAutor("Gabriel Garcia Márquez");
			l2.setAno(1977);
			l2.setPreco(BigDecimal.valueOf(59.9));
			l2.setAgencia(e2);
			pacoteDAO.save(l2);
			
			Pacote l3 = new Pacote();
			l3.setTitulo("Diálogos Impossíveis");
			l3.setAutor("Luis Fernando Verissimo");
			l3.setAno(2012);
			l3.setPreco(BigDecimal.valueOf(22.9));
			l3.setAgencia(e3);
			pacoteDAO.save(l3);
		};
	}
}
