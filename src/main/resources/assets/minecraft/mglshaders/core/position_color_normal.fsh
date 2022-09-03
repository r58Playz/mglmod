#version 460

#moj_import <fog.glsl>

layout(location = 0) uniform vec4 ColorModulator;
layout(location = 1) uniform float FogStart;
layout(location = 2) uniform float FogEnd;
layout(location = 3) uniform vec4 FogColor;

layout(location = 3) in float vertexDistance;
layout(location = 4) in vec4 vertexColor;
layout(location = 5) in vec4 normal;

layout(location = 0) out vec4 fragColor;

void main() {
    vec4 color = vertexColor * ColorModulator;
    if (color.a < 0.1) {
        discard;
    }
    fragColor = linear_fog(color, vertexDistance, FogStart, FogEnd, FogColor);
}
