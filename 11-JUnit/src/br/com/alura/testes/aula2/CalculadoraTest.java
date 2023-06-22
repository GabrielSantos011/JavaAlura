package br.com.alura.testes.aula2;

import br.com.alura.testes.aula1.Calculadora;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

//nomenclatura padrão para testes com JUnit
//nome da classe + Test
public class CalculadoraTest {

    //as IDE's tem integração com o JUnit então usando essa notação conseguimos que ela
    //atualize nosso build path e importe
    @Test
    public void somaDoisInteiros() {
        Calculadora c = new Calculadora();

        double soma = c.somar(1,1);

        //método para verificar se o resultado esperado é igual ao gerado
        Assertions.assertEquals(2, soma);
    }

    //método para demonstrar um caso onde o teste daria errado
    @Test
    public void somaComPontoFlutuante() {
        Calculadora c = new Calculadora();

        double soma = c.somar(1.1,1);

        Assertions.assertEquals(2.2, soma);
    }

    //TDD - Test Driven Development
    //criar o teste antes da codificação
    //ou seja, soma 1 + 1 deveria dar 2
    //então ja crio esse teste
    //depois implemento a funcionalidade
    //e rodo para ver se o case está correto
    //após isso posso olhar para o código e ver
    //se há necessidade de refatoração
    //
    //pontos positivos:
    //código ja sai "testado"
    //evita testes "viciados"
    //refatoração faz parte do processo

    //lidando com exceções
    @Test
    public void testaExcecao() {
        Calculadora c = new Calculadora();

        //duas maneiras
        Assertions.assertThrows(IllegalArgumentException.class, () -> c.subtrai(1,0.0));

        //ou
        try {
            c.subtrai(1,0);
            fail("não deu a exception");
        } catch (Exception e) {
            Assertions.assertEquals("Não pode 0", e.getMessage());
        }
    }

    //caso seja necessário rodar um método primeiro para inicializar algo por exemplo
    //ou para fechar alguma conexão
    //usar a notação @BeforeEach e @AfterEach - antes de cada teste serão chamados
    //caso precise rodar um método uma única vez antes/depois de todos e não a cada vez
    //usar @AfterAll e @BeforeAll - os métodos desses devem ser static

    //métodos privados não são testados
    //nem todas as classes e métodos devem ser testados, focar em classes/ métodos que
    //mexem com regras de negócio
}
