package br.com.teste.banco.service;

import java.util.List;

import br.com.teste.banco.model.Jogador;
import br.com.teste.banco.model.Time;

public interface TimeService {

	public void persistir(Time time);

	public void definirCapitao(Jogador jogador);

	public Jogador buscarCapitaoDoTime(Long idTime);

	public String buscarNomeTime(Long idTime);

	public List<Jogador> buscarJogadoresDoTime(Long idTime);

	public String buscarMelhorJogadorDoTime(Long idTime);

	public Jogador buscarJogadorMaisVelho(Long idTime);

	public List<Time> buscarTimes();

	
}
