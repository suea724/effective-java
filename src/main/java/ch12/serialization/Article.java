package ch12.serialization;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 직렬화 가능 클래스
 */
@ToString
@AllArgsConstructor
public class Article implements Serializable {
    private transient Integer id; // 직렬화 대상에서 제외
    private String title;
    private String pressName;
    private String reporterName;

    /**
     * 직렬화 때 자동으로 호출된다.
     * 반드시 private으로 선언해야 한다.
     */
    private void writeObject(ObjectOutputStream oos) {
        try {
            oos.defaultWriteObject();
            oos.writeObject(this.id); // transient 선언 필드
            oos.writeObject(this.title);
            oos.writeObject(this.pressName);
            oos.writeObject(this.reporterName);
            System.out.println("writeObject method called");
        } catch (IOException e) {

        }
    }

    /**
     * 역직렬화 때 자동으로 호출된다.
     * 반드시 private으로 선언해야 한다.
     */
    private void readObject(ObjectInputStream ois) {
        try {
            ois.defaultReadObject();
            this.id = (Integer) ois.readObject();
            this.title = (String) ois.readObject();
            this.pressName = (String) ois.readObject();
            this.reporterName = (String) ois.readObject();
            System.out.println("readObject method called");
        } catch (IOException | ClassNotFoundException exception) {

        }
    }
}
