package ch12.serialization;

import java.util.Arrays;

import static ch12.Util.deserialize;
import static ch12.Util.serialize;

public class SerializationTest {
    public static void main(String[] args) {

        Article article = new Article(1, "직렬화 테스트", "수아일보", "수아");
        byte[] serializedArticle = serialize(article);
        System.out.println("serializedArticle = " + Arrays.toString(serializedArticle));

        Article deserializedArticle = (Article) deserialize(serializedArticle);
        System.out.println("deserializedArticle = " + deserializedArticle);
    }
}
