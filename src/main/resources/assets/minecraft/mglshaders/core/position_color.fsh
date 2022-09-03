#version 460

layout(location = 0) in vec4 vertexColor;

layout(location = 0) uniform vec4 ColorModulator;

layout(location = 1) out vec4 fragColor;

void main() {
    vec4 color = vertexColor;
    if (color.a == 0.0) {
        discard;
    }
    fragColor = color * ColorModulator;
}
