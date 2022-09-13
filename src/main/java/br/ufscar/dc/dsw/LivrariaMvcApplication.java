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
			l1.setDescricao("Ensaio sobre a Cegueira");
			l1.setDuracao(19);
			l1.setValor(BigDecimal.valueOf(420.69));
			l1.setAgencia(e1);
			l1.setCidade("Sumaré");
			l1.setEstado("SP");
			l1.setPais("não posso falar");
			l1.setData_partida("19/09/2022");
			pacoteDAO.save(l1);
			
			Pacote l2 = new Pacote();
			l2.setDescricao("Aprenda a bolar com o Vini");
			l2.setDuracao(19);
			l2.setValor(BigDecimal.valueOf(420.69));
			l2.setAgencia(e1);
			l2.setCidade("Sumaré");
			l2.setEstado("SP");
			l2.setPais("não posso falar");
			l2.setData_partida("19/09/2022");
			pacoteDAO.save(l2);

			Pacote l3 = new Pacote();
			l3.setDescricao("Ensaio sobre o Vini");
			l3.setDuracao(19);
			l3.setValor(BigDecimal.valueOf(420.69));
			l3.setAgencia(e2);
			l3.setCidade("Sumaré");
			l3.setEstado("SP");
			l3.setPais("não posso falar");
			l3.setData_partida("19/09/2022");
			pacoteDAO.save(l3);
		};
	}
}
