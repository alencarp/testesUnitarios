package br.ce.wcaquino.servicos;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.utils.DataUtils;

public class LocacaoServiceTest {
	
	@Test
	public void teste() {
		
		//cenário = onde as variáveis serão inicializadas
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Maria");
		Filme filme = new Filme("IA", 2, 10.0);
		
		//ação = onde vamos invocar o método que queremos testar		
		Locacao locacao = service.alugarFilme(usuario, filme); 
		
		//validação = onde vamos coletar os resultados da ação com o cenário especificado. E podemos avaliar se o seu resultado está de acordo com o esperado		
		Assert.assertTrue(locacao.getValor() == 10.0);
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
		
		
	}
}
