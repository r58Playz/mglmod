#version 460

layout(location = 0) uniform sampler2D DiffuseSampler;

layout(location = 1) uniform vec4 ColorModulator;

layout(location = 3) in vec2 texCoord;
layout(location = 4) in vec4 vertexColor;

layout(location = 0) out vec4 fragColor;

void main() {
    vec4 color = texture(DiffuseSampler, texCoord) * vertexColor;

    // blit final output of compositor into displayed back buffer
    fragColor = color * ColorModulator;
}
