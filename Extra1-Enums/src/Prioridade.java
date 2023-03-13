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

    Prioridade(int valor) {
        this.valor = valor;
    }

    //podemos ter métodos nas enums
    public int getValor() {
        return valor;
    }

}
