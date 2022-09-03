#version 460

#moj_import <fog.glsl>

layout(location = 0) uniform sampler2D Sampler0;

layout(location = 1) uniform vec4 ColorModulator;
layout(location = 2) uniform float FogStart;
layout(location = 3) uniform float FogEnd;
layout(location = 4) uniform vec4 FogColor;

layout(location = 0) in float vertexDistance;
layout(location = 1) in vec2 texCoord0;
layout(location = 2) in vec4 vertexColor;

layout(location = 3) out vec4 fragColor;

void main() {
    vec4 color = texture(Sampler0, texCoord0) * vertexColor * ColorModulator;
    if (color.a < 0.1) {
        discard;
    }
    fragColor = linear_fog(color, vertexDistance, FogStart, FogEnd, FogColor);
}
