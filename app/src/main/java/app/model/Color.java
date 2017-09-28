package app.model;

/**
 * Created by mhasby on 9/28/2017.
 * mhmmd.hsby@gmail.com
 */

public class Color {

    public String name;
    public int color;
    public String hexacode;

    public Color(String name, int color, String hexacode) {
        this.name = name;
        this.color = color;
        this.hexacode = hexacode;
    }

    @Override
    public String toString() {
        return "Color{" +
                "name='" + name + '\'' +
                ", color=" + color +
                ", hexacode='" + hexacode + '\'' +
                '}';
    }
}
