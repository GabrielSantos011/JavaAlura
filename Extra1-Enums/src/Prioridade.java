public enum Prioridade {
    //enums são constantes
    //funcionam como uma classe normal
    //porém funcionam de uma maneira diferente
    //cada constante aqui é como se fosse um objeto
    //e de uma maneira básica para criar basta:
    //BAIXA, MEDIA, ALTA

    //porém se quisermos alguns valores customizados podemos fazer dessa maneira
    //para isso precisaremos de um construtor (esse construtor é privado)
    BAIXA(1),
    MEDIA(5),
    ALTA(10);

    private int valor;

    //como dito acima esse construtor é privado - embora não coloquemos o modificador
    //fica implicito que ele é privado pois se trata de um enum
    //em classes podemos funcionaria como o modificador package mas podemos ter o construtor 
    //privado caso não quisermos que a classe seja instanciada
    //exemplo de classe cheia de métodos estáticos
    Prioridade(int valor) {
        this.valor = valor;
    }

    //podemos ter métodos nas enums
    public int getValor() {
        return valor;
    }

}
