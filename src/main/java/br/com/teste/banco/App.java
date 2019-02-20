package br.com.teste.banco;

import java.util.List;

import br.com.teste.banco.dao.JogadorDao;
import br.com.teste.banco.model.Jogador;
import br.com.teste.banco.model.Time;
import br.com.teste.banco.service.impl.TimeServiceImpl;

public class App {
	public static void main(String[] args) {

		TimeServiceImpl timeServiceImpl = new TimeServiceImpl();
		
		List<Time> times = timeServiceImpl.buscarTimes();
		
		times.forEach(t -> System.out.println(t.toString()));
		
		System.out.println(timeServiceImpl.buscarNomeTime(1L));
		
		List<Jogador> jogadores = timeServiceImpl.buscarJogadoresDoTime(1L);
		jogadores.forEach(j -> System.out.println(j.toString()));
		
		JogadorDao jogadorDao = new JogadorDao();
		Jogador jogador = jogadorDao.porId(1L);
		timeServiceImpl.definirCapitao(jogador);
		
		System.out.println(timeServiceImpl.buscarCapitaoDoTime(1L).getNome());
		
		System.out.println(timeServiceImpl.buscarMelhorJogadorDoTime(1L));
		
	}
}
