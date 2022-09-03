#version 460

#moj_import <fog.glsl>

layout(location = 0) in vec3 Position;
layout(location = 1) in vec2 UV0;
layout(location = 2) in vec4 Color;
layout(location = 3) in ivec2 UV2;

layout(location = 0) uniform sampler2D Sampler2;

layout(location = 1) uniform mat4 ModelViewMat;
layout(location = 2) uniform mat4 ProjMat;
layout(location = 3) uniform int FogShape;

layout(location = 4) out float vertexDistance;
layout(location = 5) out vec2 texCoord0;
layout(location = 6) out vec4 vertexColor;

void main() {
    gl_Position = ProjMat * ModelViewMat * vec4(Position, 1.0);

    vertexDistance = fog_distance(ModelViewMat, Position, FogShape);
    texCoord0 = UV0;
    vertexColor = Color * texelFetch(Sampler2, UV2 / 16, 0);
}
