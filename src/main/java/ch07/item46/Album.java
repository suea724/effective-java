package ch07.item46;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Album {
    private final Artist artist;
    private final int sales;

    public Artist artist() {
        return artist;
    }

    public int sales() {
        return sales;
    }

    @Override
    public String toString() {
        return Integer.toString(sales);
    }
}
