public class Game5_Battleship_Board {
    private boolean p_ship;
    private int p_ship_length;
    private boolean p_hit;
    private boolean p_miss;
    private boolean c_ship;
    private int c_ship_length;
    private boolean c_hit;
    private boolean c_miss;

    public void setP_ship(int p_ship_length) {
        p_ship = true;
        this.p_ship_length = p_ship_length;
    }

    public void setP_hit() {
        p_hit = true;
    }

    public void setP_miss() {
        p_miss = true;
    }

    public int getP_ship_length() {
        return p_ship_length;
    }

    public boolean isP_ship() {
        return p_ship;
    }

    public boolean isP_hit() {
        return p_hit;
    }

    public boolean isP_miss() {
        return p_miss;
    }

    public void setC_ship(int c_ship_length) {
        c_ship = true;
        this.c_ship_length = c_ship_length;
    }

    public void setC_hit() {
        c_hit = true;
    }

    public void setC_miss() {
        c_miss = true;
    }

    public int getC_ship_length() {
        return c_ship_length;
    }

    public boolean isC_ship() {
        return c_ship;
    }

    public boolean isC_hit() {
        return c_hit;
    }

    public boolean isC_miss() {
        return c_miss;
    }
}
