package br.com.teste.banco.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import br.com.teste.banco.dao.TimeDao;
import br.com.teste.banco.model.Jogador;
import br.com.teste.banco.model.Time;
import br.com.teste.banco.service.TimeService;

public class TimeServiceImpl implements TimeService {

	private TimeDao timeDao = new TimeDao();

	@Override
	public void persistir(Time time) {
		this.timeDao.persistir(time);
	}

	@Override
	public void definirCapitao(Jogador jogador) {
		jogador.getTime().setCapitao(jogador);
		this.persistir(jogador.getTime());
	}

	@Override
	public Jogador buscarCapitaoDoTime(Long idTime) {
		return timeDao.porId(idTime).getCapitao();
	}

	@Override
	public String buscarNomeTime(Long idTime) {
		return timeDao.porId(idTime).getNome();
	}

	@Override
	public List<Jogador> buscarJogadoresDoTime(Long idTime) {
		return timeDao.porId(idTime).getJogadores();
	}

	@Override
	public String buscarMelhorJogadorDoTime(Long idTime) {
		return timeDao.porId(idTime).getJogadores().stream()
				.sorted(Comparator.comparingInt(Jogador::getNivelHabilidade).reversed())
				.map(Jogador::getNome)
				.limit(1)
				.collect(Collectors.toList())
				.toString();
	}

	@Override
	public Jogador buscarJogadorMaisVelho(Long idTime) {
		return timeDao.porId(idTime).getJogadores().stream()
				.sorted(Comparator.comparing(Jogador::getDataNascimento))
				.findFirst().get();
	}

	@Override
	public List<Time> buscarTimes() {
		return this.timeDao.listar();
	}

}
