package ch06.item35;

public enum EnsembleV1 {
    SOLO, DUET, TRIO, QUARTET, QUINTET, SEXTET, SEPTET, OCTET, NONET, DECTET;

    public int numberOfMusicians() {
        return ordinal() + 1;
    }

    public static void main(String[] args) {
        System.out.println(EnsembleV1.TRIO.numberOfMusicians());
    }
}
