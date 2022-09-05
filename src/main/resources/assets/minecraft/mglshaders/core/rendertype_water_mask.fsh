#version 460

uniform vec4 ColorModulator;

out vec4 fragColor;

void main() {
    fragColor = ColorModulator;
}
