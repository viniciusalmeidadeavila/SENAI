public class Bebida extends Produto {
    private int volumeML;
    public Bebida(String nome, double preco, int volumeML) {
        super(nome, preco);
        this.volumeML = volumeML;
    }

    public int getVolumeML(){
        return this.volumeML;
    }
}