public class PolygonAPP {
        public static void main (String[] args) {
                float[] pos = new float[2];
                pos[0] = 0.0f;
                pos[1] = 0.0f;

                Polygon pol = new Polygon(pos, 10.0f, 10.0f, 15, 0.5f);
                pol.print();
        }
}

class Figure {
        //posição da figura
        public float[] pos;

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
        Polygon (float[] pos, float w, float h, int c, float r) {
                this.pos = pos;
                
                this.width = w;
                this.height = h;

                this.corners = c;
                this.rounded = r;
        };

        //método print
        void print () {
                        System.out.printf("center pos: (%.1f, %.1f)\nwidth: %.1f\nheight: %.1f\ncorners: %d\nrounded: %.1f\n", 
                        this.pos[0], this.pos[1],
                        this.width, this.height,        
                        this.corners, this.rounded);
        }
}
