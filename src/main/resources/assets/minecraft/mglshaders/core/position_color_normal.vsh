#version 460

#moj_import <fog.glsl>

layout(location = 0) in vec3 Position;
layout(location = 1) in vec4 Color;
layout(location = 2) in vec3 Normal;

layout(location = 0) uniform mat4 ModelViewMat;
layout(location = 1) uniform mat4 ModelViewProjMat;
layout(location = 2) uniform int FogShape;

layout(location = 3) out float vertexDistance;
layout(location = 4) out vec4 vertexColor;
layout(location = 5) out vec4 normal;

void main() {
    gl_Position = ModelViewProjMat * vec4(Position, 1.0);

    vertexDistance = fog_distance(ModelViewMat, Position, FogShape);
    vertexColor = Color;
    normal = ModelViewProjMat * vec4(Normal, 0.0);
}
