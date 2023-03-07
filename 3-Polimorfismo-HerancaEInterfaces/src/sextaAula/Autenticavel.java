package sextaAula;

//interface é um contrato, quem assinar este contrato deve obrigatóriamente
//implementar todos os métodos
public interface Autenticavel {
	//interface é uma classe abstrata, com todos seus métodos publicos e abstratos
	//sendo assim não há necessidade de escrevermos public abstract (pois todos são)

	//no java não existe herança multipla, então neste exemplo o gerente e o administrador não poderiam
	//herdar de autenticavel e funcionario ao mesmo tempo, e autenticavel não poderia herdar de funcionario
	//pois cliente é um autenticavel e não é um funcionário
	//logo a solução é a interface, uma classe pode implementar quantas interfaces quiser

	void setSenha(int senha);

	boolean autentica(int senha);

}
