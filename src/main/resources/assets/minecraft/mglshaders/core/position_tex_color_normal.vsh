#version 460

#moj_import <fog.glsl>

layout(location = 0) in vec3 Position;
layout(location = 1) in vec2 UV0;
layout(location = 2) in vec4 Color;
layout(location = 3) in vec3 Normal;

layout(location = 0) uniform mat4 ModelViewMat;
layout(location = 1) uniform mat4 ProjMat;
layout(location = 2) uniform int FogShape;

layout(location = 4) out vec2 texCoord0;
layout(location = 5) out float vertexDistance;
layout(location = 6) out vec4 vertexColor;
layout(location = 7) out vec4 normal;

void main() {
    gl_Position = ProjMat * ModelViewMat * vec4(Position, 1.0);

    texCoord0 = UV0;
    vertexDistance = fog_distance(ModelViewMat, Position, FogShape);
    vertexColor = Color;
    normal = ProjMat * ModelViewMat * vec4(Normal, 0.0);
}
