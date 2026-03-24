#include <stdio.h>

typedef struct {
        float x, y;

        float width, height;

        float turns;
        float innerRadius;
} Spiral;

void spiralPrint (Spiral s) {
        printf("pos: (%.1f, %.1f)\nwidth: %.1f\nheight: %.1f\nturns: %.1f\nInnerRadius: %.1f\n",
                s.x, s.y,
                s.width, s.height,
                s.turns, s.innerRadius
                );
}


int main (void) {
        Spiral s = {0.0, 0.0, 10.0, 10.0, 5.0, 1.0};
        spiralPrint(s);
}
