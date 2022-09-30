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
public class ViaGra {

	public static void main(String[] args) {
		SpringApplication.run(ViaGra.class, args);
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
			

			Agencia a1 = new Agencia();
			a1.setUsername("agencia1");
			a1.setPassword(encoder.encode("agencia1"));
			a1.setName("Companhia Aéria");
			a1.setRole("ROLE_AGENCIA");
			a1.setEnabled(true);
			a1.setCNPJ("55.789.390/0008-99");
			a1.setDescricao("Viagens de avião");
			agenciaDAO.save(a1);
			

			Agencia a2 = new Agencia();
			a2.setUsername("agencia2");
			a2.setPassword(encoder.encode("agencia2"));
			a2.setName("Companhia Ferroviária");
			a2.setRole("ROLE_AGENCIA");
			a2.setEnabled(true);
			a2.setCNPJ("71.150.470/0001-40");
			a2.setDescricao("Viagens de trem");
			agenciaDAO.save(a2);
			

			Agencia a3 = new Agencia();
			a3.setUsername("agencia3");
			a3.setPassword(encoder.encode("agencia3"));
			a3.setName("Companhia Marítima");
			a3.setRole("ROLE_AGENCIA");
			a3.setEnabled(true);
			a3.setCNPJ("32.106.536/0001-82");
			a3.setDescricao("Viagens de canoa");
			agenciaDAO.save(a3);
			
			Pacote p1 = new Pacote();
			p1.setDescricao("Ensaio sobre a Cegueira");
			p1.setDuracao(19);
			p1.setValor(BigDecimal.valueOf(420.69));
			p1.setAgencia(a1);
			p1.setCidade("Campinas");
			p1.setEstado("SP");
			p1.setPais("não posso falar");
			p1.setDataPartida("10/10/2022");
			pacoteDAO.save(p1);
			
			Pacote p2 = new Pacote();
			p2.setDescricao("Aprenda a bolar com o Vini");
			p2.setDuracao(19);
			p2.setValor(BigDecimal.valueOf(420.69));
			p2.setAgencia(a3);
			p2.setCidade("Sumaré");
			p2.setEstado("SP");
			p2.setPais("Brasil");
			p2.setDataPartida("19/09/2022");
			pacoteDAO.save(p2);

			Pacote p3 = new Pacote();
			p3.setDescricao("Ensaio sobre o Vini");
			p3.setDuracao(19);
			p3.setValor(BigDecimal.valueOf(420.69));
			p3.setAgencia(a2);
			p3.setCidade("Sumaré");
			p3.setEstado("SP");
			p3.setPais("não posso falar");
			p3.setDataPartida("30/09/2022");
			pacoteDAO.save(p3);
		};
	}
}
