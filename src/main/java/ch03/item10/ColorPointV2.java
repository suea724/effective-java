package ch03.item10;

import java.util.Objects;

// equals 규약을 지키면서 값 추가하기
public class ColorPointV2 {
    private final Point point;
    private final Color color;

    public ColorPointV2(int x, int y, Color color) {
        point = new Point(x, y);
        this.color = Objects.requireNonNull(color);
    }

    /**
     * 이 ColorPoint의 Point 뷰를 반환한다.
     */
    public Point asPoint() {
        return point;
    }

    @Override public boolean equals(Object o) {
        if (!(o instanceof ColorPointV2))
            return false;
        ColorPointV2 cp = (ColorPointV2) o;
        return cp.point.equals(point) && cp.color.equals(color);
    }

    @Override public int hashCode() {
        return 31 * point.hashCode() + color.hashCode();
    }
}
