#include <stdio.h>

typedef struct {
        float pos[2];

        float width;
        float height;

        float turns;
        float innerRadius;
} Spiral;

void spiralPrint (Spiral s) {
        printf("pos: (%.1f, %.1f)\nwidth: %.1f\nheight: %.1f\nturns: %.1f\nInnerRadius: %.1f\n",
                s.pos[0], s.pos[1],
                s.width, s.height,
                s.turns, s.innerRadius
                );
}


int main (void) {
        Spiral s = {0.0, 0.0, 10.0, 10.0, 5.0, 1.0};
        spiralPrint(s);
}
