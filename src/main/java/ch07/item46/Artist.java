package ch07.item46;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Artist {
    private final String name;

    @Override
    public String toString() {
        return name;
    }
}
