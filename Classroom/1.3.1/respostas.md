# Editor Vetorial: INKSCAPE
### 1) Que outras operações gráficas são comuns? Explique o comportamento esperado de pelo menos 3 operações (1 parágrafo para cada).
- Duplicate: Copia todas as propriedades de um objeto ou uma seleção de objetos, e duplica ele(s) (nas mesmas posições)

- Gradient Tool: Adiciona um gradiente de cor personalizável no fundo do objeto, podendo alterar a direção, a intensidade, as cores e opacidades iniciais e finais, o tipo de gradiente, e etc.

- Dropper Tool (Conta gotas): Permite copiar uma cor de um pixel especifico da tela na posição do mouse ou coletar a média de todos os pixeis dentro da área de um circulo com posição e raio definidos ao segurar e soltar o mouse.

### 2) Que atributos são compartilhados entre as figuras geométricas? Indique pelo menos 5 atributos.
- Posição: x, y
- Dimensões: w, h
- Preenchimento: Sem fundo, Cor sólida, Gradiente linerar, Gradiente radial, Padrões, etc
- Layer (Camada)
- Profundidade (posição na layer)

### 3) Que atributos são específicos a certas figuras geométricas. Indique pelo menos 2 atributos específicos de 3 figuras diferentes.
Ellipse:
- Start e End determinam os angulos em que a elipse começa e termina de ser desenhada
- o "Tipo" define se ela vai ser uma "fatia", um "arco" ou uma "corda", esses tipos definem como que os angulos Start e End vão influenciar no formato do objeto 

Star/Polygon: 
- Corners definem quantas pontas o polígono vai ter
- Rounded define o fator que vai arredondar as pontas do polígono

Spiral: 
- Turns define a quantidade de voltas que a espiral vai fazer
- Inner Radius define o raio interno da espiral, permitindo construir uma espiral com um "buraco" em seu centro, por padrão é 0 (sem o buraco)
