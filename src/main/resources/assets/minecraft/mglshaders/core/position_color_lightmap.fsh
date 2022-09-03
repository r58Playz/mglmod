#version 460

layout(location = 0) uniform sampler2D Sampler2;

layout(location = 1) uniform vec4 ColorModulator;

layout(location = 0) in vec4 vertexColor;
layout(location = 1) in vec2 texCoord2;

layout(location = 2) out vec4 fragColor;

void main() {
    vec4 color = texture(Sampler2, texCoord2) * vertexColor;
    fragColor = color * ColorModulator;
}
