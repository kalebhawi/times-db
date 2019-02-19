package br.com.teste.banco;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.teste.banco.dao.JogadorDao;
import br.com.teste.banco.dao.TimeDao;
import br.com.teste.banco.model.Jogador;
import br.com.teste.banco.model.Time;

public class App {
	public static void main(String[] args) {

		TimeDao timeDao = new TimeDao();
		
		JogadorDao jogadorDao = new JogadorDao();
		
		Time time = new Time("Inter", LocalDate.now(), "Vermelho", "Branco");
		
		Jogador jogador = new Jogador("Kaleb", LocalDate.now(), 10, new BigDecimal(500000L), time);

		timeDao.save(time);
		
		jogadorDao.save(jogador);
	}
}
