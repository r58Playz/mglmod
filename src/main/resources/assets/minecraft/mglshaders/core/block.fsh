#version 460

layout(location = 0) uniform sampler2D Sampler0;

layout(location = 1) uniform vec4 ColorModulator;

layout(location = 0) in vec4 vertexColor;
layout(location = 1) in vec2 texCoord0;
layout(location = 2) in vec2 texCoord2;
layout(location = 3) in vec4 normal;

layout(location = 4) out vec4 fragColor;

void main() {
    vec4 color = texture(Sampler0, texCoord0) * vertexColor;
    fragColor = color * ColorModulator;
}
