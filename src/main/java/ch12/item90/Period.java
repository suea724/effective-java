package ch12.item90;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * 직렬화 프록시를 사용한 Period 클래스
 */
public class Period implements Serializable {
    private final Date start;
    private final Date end;

    public Period(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
        if (this.start.compareTo(this.end) > 0) {
            throw new IllegalArgumentException(start + "가 " + end + "보다 늦다.");
        }
    }

    public Date start() {
        return new Date(this.start.getTime());
    }

    public Date end() {
        return new Date(this.end.getTime());
    }

    public String toString() {
        return start + "-" + end;
    }

    private static class SerializationProxy implements Serializable {
        private final Date start;
        private final Date end;

        SerializationProxy(Period p) {
            this.start = p.start;
            this.end = p.end;
        }

        // 직렬화 가능한 클래스에 선언. 어떤 값이든 상관없음.
        private static final long serialVersionUID = 234098243823485285L;
    }

    // 직렬화 프록시 패턴용 writeReplace 메서드
    private Object writeReplace() {
        return new SerializationProxy(this);
    }
    
    // 직렬화 프록시 패턴용 readObject 메서드
    private void readObject(ObjectInputStream stream) throws InvalidObjectException {
        throw new InvalidObjectException("프록시가 필요합니다");
    }
    
    
}
