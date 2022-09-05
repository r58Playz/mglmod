#version 460

#moj_import <fog.glsl>

layout(location = 0) uniform vec4 ColorModulator;
layout(location = 1) uniform float FogStart;
layout(location = 2) uniform float FogEnd;
layout(location = 3) uniform vec4 FogColor;

layout(location = 1) in float vertexDistance;

layout(location = 0) out vec4 fragColor;

void main() {
    fragColor = linear_fog(ColorModulator, vertexDistance, FogStart, FogEnd, FogColor);
}
