public class TesteEnum {

    public static void main(String[] args) {
        //como instanciar uma enum
        Prioridade pBaixa = Prioridade.BAIXA;
        Prioridade pMedia = Prioridade.MEDIA;
        Prioridade pAlta  = Prioridade.ALTA;

        System.out.println("nome das constantes");
        System.out.println(pBaixa.name());
        System.out.println(pMedia.name());
        System.out.println(pAlta.name()); //poderia ser o toString

        System.out.println("ordinal das constantes");
        System.out.println(pBaixa.ordinal());
        System.out.println(pMedia.ordinal());
        System.out.println(pAlta.ordinal());

        System.out.println("usando o método criado");
        System.out.println(pBaixa.getValor());
        System.out.println(pMedia.getValor());
        System.out.println(pAlta.getValor());
    }

}
