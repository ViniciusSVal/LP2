public class PolygonAPP {
        public static void main (String[] args) {
                Polygon pol = new Polygon(0.0f, 0.0f, 10.0f, 10.0f, 15, 0.5f);
                pol.print();
        }
}

class Figure {
        //posição da figura
        public float x, y;

        //dimensões do poligono
        public float width;
        public float height;
}

class Polygon extends Figure {
        //quantidade de pontas que o poligono tem
        public int corners;
        //fator que arredonda as pontas do poligono
        public float rounded;

        //construtor
        Polygon (float x, float y, float w, float h, int c, float r) {
                this.x = x;
                this.y = y;

                this.width = w;
                this.height = h;

                this.corners = c;
                this.rounded = r;
        };

        void print () {
                        System.out.printf("pos: (%.1f, %.1f)\nwidth: %.1f\nheight: %.1f\ncorners: %d\nrounded: %.1f\n",
                        this.x, this.y,
                        this.width, this.height,
                        this.corners, this.rounded);
        }
}
